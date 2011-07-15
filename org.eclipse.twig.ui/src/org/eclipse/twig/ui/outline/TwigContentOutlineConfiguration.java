package org.eclipse.twig.ui.outline;

import org.eclipse.dltk.ast.references.SimpleReference;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceReference;
import org.eclipse.dltk.ui.DLTKPluginImages;
import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.dltk.ui.ScriptElementImageProvider;
import org.eclipse.dltk.ui.ScriptElementLabels;
import org.eclipse.dltk.ui.viewsupport.AppearanceAwareLabelProvider;
import org.eclipse.dltk.ui.viewsupport.DecoratingModelLabelProvider;
import org.eclipse.dltk.ui.viewsupport.ScriptUILabelProvider;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.php.internal.core.typeinference.UseStatementElement;
import org.eclipse.php.internal.ui.PHPUIMessages;
import org.eclipse.php.internal.ui.PHPUiPlugin;
import org.eclipse.php.internal.ui.actions.SortAction;
import org.eclipse.php.internal.ui.editor.PHPStructuredEditor;
import org.eclipse.php.internal.ui.outline.PHPOutlineContentProvider;
import org.eclipse.php.internal.ui.preferences.PreferenceConstants;
import org.eclipse.ui.IEditorPart;
import org.eclipse.wst.html.ui.views.contentoutline.HTMLContentOutlineConfiguration;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.eclipse.wst.xml.ui.internal.contentoutline.JFaceNodeContentProvider;
import org.eclipse.wst.xml.ui.internal.contentoutline.XMLNodeActionManager;

@SuppressWarnings("restriction")
public class TwigContentOutlineConfiguration extends
		HTMLContentOutlineConfiguration {

	private static final String OUTLINE_PAGE = "org.eclipse.php.ui.OutlinePage";
	public static final int MODE_PHP = 1;
	public static final int MODE_HTML = 2;

	protected TwigOutlineContentProvider fContentProvider = null;
	protected JFaceNodeContentProvider fContentProviderHTML = null;
	protected ILabelProvider fLabelProvider = null;
	protected TwigOutlineLabelProvider fLabelProviderHTML = null;
	private IPropertyChangeListener propertyChangeListener;
	private ChangeOutlineModeAction changeOutlineModeActionPHP;
	private ChangeOutlineModeAction changeOutlineModeActionHTML;
	static Object[] NO_CHILDREN = new Object[0];
	private SortAction sortAction;
	private ScriptUILabelProvider fSimpleLabelProvider;
	// private ShowGroupsAction fShowGroupsAction;
	private boolean fShowAttributes = false;
	protected IPreferenceStore fStore = DLTKUIPlugin.getDefault()
			.getPreferenceStore();
	
	
	//private CustomFiltersActionGroup fCustomFiltersActionGroup;

	/** See {@link #MODE_PHP}, {@link #MODE_HTML} */
	private int mode;

	public TwigContentOutlineConfiguration() {
		super();
		mode = PHPUiPlugin.getDefault().getPreferenceStore().getInt(
				PreferenceConstants.PREF_OUTLINEMODE);
	}

	public int getMode() {
		return mode;
	}

	public void setMode(final int mode) {
		this.mode = mode;
	}

	protected IContributionItem[] createMenuContributions(
			final TreeViewer viewer) {
		IContributionItem[] items;

		changeOutlineModeActionPHP = new ChangeOutlineModeAction(
				PHPUIMessages.PHPOutlinePage_mode_php, MODE_PHP, this, viewer); //$NON-NLS-1$
		final IContributionItem showPHPItem = new ActionContributionItem(
				changeOutlineModeActionPHP);

		changeOutlineModeActionHTML = new ChangeOutlineModeAction(
				PHPUIMessages.PHPOutlinePage_mode_html, MODE_HTML, this, viewer); //$NON-NLS-1$

		propertyChangeListener = new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals("checked")) { //$NON-NLS-1$
					boolean checked = ((Boolean) event.getNewValue())
							.booleanValue();
					if (sortAction != null) {
						sortAction.setEnabled(!checked);
					}
				}
			}
		};
		changeOutlineModeActionHTML
				.addPropertyChangeListener(propertyChangeListener);

		final IContributionItem showHTMLItem = new ActionContributionItem(
				changeOutlineModeActionHTML);

		// Custom filter group
//		if (fCustomFiltersActionGroup == null) {
//			fCustomFiltersActionGroup = new CustomFiltersActionGroup(
//					OUTLINE_PAGE, viewer); //$NON-NLS-1$
//		}
//
//		final IContributionItem filtersItem = new FilterActionGroupContributionItem(
//				fCustomFiltersActionGroup);

		items = super.createMenuContributions(viewer);

		if (items == null)
			items = new IContributionItem[] { showPHPItem, showHTMLItem,
					/*filtersItem */};
		else {
			final IContributionItem[] combinedItems = new IContributionItem[items.length + /*3*/ 2];
			System.arraycopy(items, 0, combinedItems, 0, items.length);
			combinedItems[items.length] = showPHPItem;
			combinedItems[items.length + 1] = showHTMLItem;
//			combinedItems[items.length + 2] = filtersItem;
			items = combinedItems;
		}
		if (changeOutlineModeActionHTML.isChecked()) {
			sortAction.setEnabled(false);
		}
		return items;
	}

	protected IContributionItem[] createToolbarContributions(
			final TreeViewer viewer) {
		IContributionItem[] items;
		// fShowGroupsAction = new ShowGroupsAction("Show Groups", viewer);
		//		final IContributionItem showGroupsItem = new ActionContributionItem(fShowGroupsAction); //$NON-NLS-1$

		// fixed bug 174653
		// use only the toggleLinking menu and dispose the others
		IContributionItem[] menuContributions = super
				.createMenuContributions(viewer);
		final IContributionItem toggleLinking = menuContributions[0];
		for (int i = 1; i < menuContributions.length; i++) {
			menuContributions[i].dispose();
		}
		sortAction = new SortAction(viewer);
		final IContributionItem sortItem = new ActionContributionItem(
				sortAction);

		items = super.createToolbarContributions(viewer);
		if (items == null)
			items = new IContributionItem[] { sortItem /* , showGroupsItem */};
		else {
			final IContributionItem[] combinedItems = new IContributionItem[items.length + 2];
			System.arraycopy(items, 0, combinedItems, 0, items.length);
			combinedItems[items.length] = sortItem;
			// combinedItems[items.length + 1] = showGroupsItem;
			combinedItems[items.length + 1] = toggleLinking;
			items = combinedItems;
		}
		return items;

	}

	public void unconfigure(TreeViewer viewer) {
		// if (fShowGroupsAction != null) {
		// fShowGroupsAction.dispose();
		// }
		if (changeOutlineModeActionHTML != null
				&& propertyChangeListener != null) {
			changeOutlineModeActionHTML
					.removePropertyChangeListener(propertyChangeListener);
		}
		super.unconfigure(viewer);
	}

	public IContentProvider getContentProvider(final TreeViewer viewer) {
		if (MODE_PHP == mode) {
			if (fContentProvider == null) {
				fContentProvider = new TwigOutlineContentProvider(viewer);
			}
			viewer.setContentProvider(fContentProvider);
		} else if (MODE_HTML == mode) {
			if (fContentProviderHTML == null) {
				fContentProviderHTML = new JFaceNodeContentProvider() {
					public Object[] getElements(Object object) {
						if (object instanceof ISourceModule) {
							IEditorPart activeEditor = PHPUiPlugin
									.getActiveEditor();
							if (activeEditor instanceof StructuredTextEditor) {
								StructuredTextEditor editor = (StructuredTextEditor) activeEditor;
								IDocument document = editor
										.getDocumentProvider().getDocument(
												editor.getEditorInput());
								IStructuredModel model = null;
								try {
									model = StructuredModelManager
											.getModelManager()
											.getExistingModelForRead(document);
									return super.getElements(model);
								} finally {
									if (model != null) {
										model.releaseFromRead();
									}
								}
							}
						}
						return super.getElements(object);
					}

					@Override
					public void inputChanged(Viewer viewer, Object oldInput,
							Object newInput) {
						if (newInput instanceof ISourceModule) {
							IEditorPart activeEditor = PHPUiPlugin
									.getActiveEditor();
							if (activeEditor instanceof StructuredTextEditor) {
								StructuredTextEditor editor = (StructuredTextEditor) activeEditor;
								IDocument document = editor
										.getDocumentProvider().getDocument(
												editor.getEditorInput());
								IStructuredModel model = null;
								try {
									model = StructuredModelManager
											.getModelManager()
											.getExistingModelForRead(document);
								} finally {
									if (model != null) {
										model.releaseFromRead();
									}
								}
								newInput = model;
							}
						}
						super.inputChanged(viewer, oldInput, newInput);
					}
				};
			}
			viewer.setContentProvider(fContentProviderHTML);
		}
		return viewer.getContentProvider();
	}

	public ILabelProvider getLabelProvider(final TreeViewer viewer) {

		if (fLabelProvider == null) {
			fLabelProvider = new DecoratingModelLabelProvider(
					new PHPAppearanceAwareLabelProvider(
							AppearanceAwareLabelProvider.DEFAULT_TEXTFLAGS
									| ScriptElementLabels.F_APP_TYPE_SIGNATURE
									| ScriptElementLabels.ALL_CATEGORY,
							AppearanceAwareLabelProvider.DEFAULT_IMAGEFLAGS,
							fStore));
		}

		if (MODE_PHP == mode) {
			viewer.setLabelProvider(fLabelProvider);
		} else if (MODE_HTML == mode) {
			if (fLabelProviderHTML == null) {
				fLabelProviderHTML = new TwigOutlineLabelProvider(fLabelProvider);
				fLabelProviderHTML.fShowAttributes = fShowAttributes;
			}
			viewer.setLabelProvider(fLabelProviderHTML);
		}
		return (ILabelProvider) viewer.getLabelProvider();
	}

	public ISelection getSelection(final TreeViewer viewer,
			final ISelection selection) {
		final IContentProvider contentProvider = viewer.getContentProvider();
		if (contentProvider instanceof PHPOutlineContentProvider) {
			if (MODE_PHP == mode) {
				if (selection instanceof IStructuredSelection
						&& selection instanceof TextSelection) {
					IEditorPart activeEditor = PHPUiPlugin.getActiveEditor();
					if (activeEditor instanceof PHPStructuredEditor) {
						ISourceReference computedSourceReference = ((PHPStructuredEditor) activeEditor)
								.computeHighlightRangeSourceReference();
						if (computedSourceReference != null) {
							return new StructuredSelection(
									computedSourceReference);
						}
					}
				}
			}
		}
		return super.getSelection(viewer, selection);
	}

	public ILabelProvider getStatusLineLabelProvider(TreeViewer treeViewer) {
		if (fSimpleLabelProvider == null) {
			fSimpleLabelProvider = new ScriptUILabelProvider();
			fSimpleLabelProvider
					.setTextFlags(ScriptElementLabels.DEFAULT_QUALIFIED
							| ScriptElementLabels.ROOT_POST_QUALIFIED
							| ScriptElementLabels.APPEND_ROOT_PATH
							| ScriptElementLabels.M_PARAMETER_TYPES
							| ScriptElementLabels.M_PARAMETER_NAMES
							| ScriptElementLabels.M_APP_RETURNTYPE
							| ScriptElementLabels.M_EXCEPTIONS
							| ScriptElementLabels.F_APP_TYPE_SIGNATURE
							| ScriptElementLabels.T_TYPE_PARAMETERS);
		}
		return fSimpleLabelProvider;
	}

	protected XMLNodeActionManager createNodeActionManager(TreeViewer treeViewer) {
		IEditorPart activeEditor = PHPUiPlugin.getActiveEditor();
		if (activeEditor instanceof StructuredTextEditor) {
			StructuredTextEditor editor = (StructuredTextEditor) activeEditor;
			IDocument document = editor.getDocumentProvider().getDocument(
					editor.getEditorInput());
			IStructuredModel model = null;
			try {
				model = StructuredModelManager.getModelManager()
						.getExistingModelForRead(document);
				return new TwigNodeActionManager(model, treeViewer);
			} finally {
				if (model != null) {
					model.releaseFromRead();
				}
			}
		}
		return null;
	}

	protected void enableShowAttributes(boolean showAttributes,
			TreeViewer treeViewer) {
		super.enableShowAttributes(showAttributes, treeViewer);
		// fix bug #241111 - show attributes in outline
		if (fLabelProviderHTML != null) {
			// This option is only relevant for the HTML outline
			fLabelProviderHTML.fShowAttributes = showAttributes;
		}
		fShowAttributes = showAttributes;
	}

	class UseStatementAwareImageProvider extends ScriptElementImageProvider {

		public ImageDescriptor getBaseImageDescriptor(IModelElement element,
				int renderFlags) {
			if (element instanceof UseStatementElement) {
				return DLTKPluginImages.DESC_OBJS_IMPDECL;
			}
//			if (element instanceof UseStatementsNode) {
//				return DLTKPluginImages.DESC_OBJS_IMPCONT;
//			}
			return super.getBaseImageDescriptor(element, renderFlags);
		}
	}

	class PHPAppearanceAwareLabelProvider extends AppearanceAwareLabelProvider {

		public PHPAppearanceAwareLabelProvider(IPreferenceStore store) {
			super(store);
			fImageLabelProvider = new UseStatementAwareImageProvider();
		}

		public PHPAppearanceAwareLabelProvider(long textFlags, int imageFlags,
				IPreferenceStore store) {
			super(textFlags, imageFlags, store);
			fImageLabelProvider = new UseStatementAwareImageProvider();
		}

		public String getText(Object element) {
//			if (element instanceof UseStatementsNode) {
//				return PHPUIMessages.PHPContentOutlineConfiguration_2; //$NON-NLS-1$
//			}
			if (element instanceof UseStatementElement) {
				SimpleReference alias = ((UseStatementElement) element)
						.getUsePart().getAlias();
				if (alias != null) {
					return NLS.bind(
							PHPUIMessages.PHPContentOutlineConfiguration_3,
							super.getText(element), //$NON-NLS-1$
							alias.getName());
				}
			}
			return super.getText(element);
		}
	}

/*	class FilterActionGroupContributionItem extends ContributionItem {

		// private boolean fState;
		private CustomFiltersActionGroup fActionGroup;

		public FilterActionGroupContributionItem(
				CustomFiltersActionGroup actionGroup) {
			super("filters");
			fActionGroup = actionGroup;
			// fState= state;
		}

		public void fill(Menu menu, int index) {
			
		}

		public boolean isDynamic() {
			return true;
		}
	}	*/

}