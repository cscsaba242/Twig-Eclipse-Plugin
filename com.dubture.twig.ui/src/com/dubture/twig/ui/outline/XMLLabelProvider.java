package com.dubture.twig.ui.outline;

import org.eclipse.wst.sse.core.utils.StringUtils;
import org.eclipse.wst.xml.core.internal.contentmodel.CMAttributeDeclaration;
import org.eclipse.wst.xml.core.internal.contentmodel.CMDataType;
import org.eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration;
import org.eclipse.wst.xml.core.internal.contentmodel.modelquery.ModelQuery;
import org.eclipse.wst.xml.core.internal.modelquery.ModelQueryUtil;
import org.eclipse.wst.xml.ui.internal.contentoutline.JFaceNodeLabelProvider;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

@SuppressWarnings("restriction")
public class XMLLabelProvider extends JFaceNodeLabelProvider {

	boolean fShowAttributes = false;

	public String getText(Object o) {
		StringBuffer text = new StringBuffer(super.getText(o));
		if (o instanceof Node) {
			Node node = (Node) o;
			if ((node.getNodeType() == Node.ELEMENT_NODE) && fShowAttributes) {
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=88444
				if (node.hasAttributes()) {
					Element element = (Element) node;
					NamedNodeMap attributes = element.getAttributes();
					Node idTypedAttribute = null;
					Node requiredAttribute = null;
					boolean hasId = false;
					boolean hasName = false;
					Node shownAttribute = null;
					// try to get content model element
					// declaration
					CMElementDeclaration elementDecl = null;
					ModelQuery mq = ModelQueryUtil.getModelQuery(element
							.getOwnerDocument());
					if (mq != null) {
						elementDecl = mq.getCMElementDeclaration(element);
					}
					// find an attribute of type (or just named)
					// ID
					if (elementDecl != null) {
						int i = 0;
						while ((i < attributes.getLength())
								&& (idTypedAttribute == null)) {
							Node attr = attributes.item(i);
							String attrName = attr.getNodeName();
							CMAttributeDeclaration attrDecl = (CMAttributeDeclaration) elementDecl
									.getAttributes().getNamedItem(attrName);
							if (attrDecl != null) {
								if ((attrDecl.getAttrType() != null)
										&& (CMDataType.ID.equals(attrDecl
												.getAttrType()
												.getDataTypeName()))) {
									idTypedAttribute = attr;
								} else if ((attrDecl.getUsage() == CMAttributeDeclaration.REQUIRED)
										&& (requiredAttribute == null)) {
									// as a backup, keep tabs on
									// any required
									// attributes
									requiredAttribute = attr;
								} else {
									hasId = hasId || attrName.equals("id"); //$NON-NLS-1$
									hasName = hasName
											|| attrName.equals("name"); //$NON-NLS-1$
								}
							}
							++i;
						}
					}
					/*
					 * If no suitable attribute was found, try using a required
					 * attribute, if none, then prefer "id" or "name", otherwise
					 * just use first attribute
					 */
					if (idTypedAttribute != null) {
						shownAttribute = idTypedAttribute;
					} else if (requiredAttribute != null) {
						shownAttribute = requiredAttribute;
					} else if (hasId) {
						shownAttribute = attributes.getNamedItem("id"); //$NON-NLS-1$
					} else if (hasName) {
						shownAttribute = attributes.getNamedItem("name"); //$NON-NLS-1$
					}
					if (shownAttribute == null) {
						shownAttribute = attributes.item(0);
					}
					// display the attribute and value (without quotes)
					String attributeName = shownAttribute.getNodeName();
					if ((attributeName != null) && (attributeName.length() > 0)) {
						text.append(" " + attributeName); //$NON-NLS-1$
						String attributeValue = shownAttribute.getNodeValue();
						if ((attributeValue != null)
								&& (attributeValue.length() > 0)) {
							text
							.append("=" + StringUtils.strip(attributeValue)); //$NON-NLS-1$
						}
					}
				}
			}
		}
		return text.toString();
	}	

}
