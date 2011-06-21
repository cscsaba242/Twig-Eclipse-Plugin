/* The following code was generated by JFlex 1.4.1 on 6/21/11 1:46 AM */

/********************************************************************************   
 * Copyright (c) 2006 Zend Corporation and IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Zend and IBM - Initial implementation
 ********************************************************************************/

package org.eclipse.twig.core.documentModel.parser;

import org.eclipse.php.internal.core.util.collections.IntHashtable;
import org.eclipse.wst.sse.core.utils.StringUtils;
import org.eclipse.twig.core.util.Debug;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 6/21/11 1:46 AM from the specification file
 * <tt>highlighting_scanner.jflex</tt>
 */
public class TwigLexer extends org.eclipse.twig.core.documentModel.parser.AbstractTwigLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int ST_TWIG_DOUBLE_QUOTES = 2;
  public static final int ST_TWIG_CONTENT = 1;
  public static final int YYINITIAL = 0;
  public static final int ST_TWIG_HIGHLIGHTING_ERROR = 4;
  public static final int ST_TWIG_DOUBLE_QUOTES_SPECIAL = 3;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\31\1\40\2\0\1\31\22\0\1\31\1\32\1\41\1\34"+
    "\1\33\1\2\1\32\1\36\2\45\3\32\2\45\1\32\12\4\1\32"+
    "\1\0\2\32\1\45\2\32\1\23\1\13\1\16\1\11\1\5\1\20"+
    "\1\3\1\26\1\22\1\3\1\17\1\14\1\27\1\10\1\15\1\30"+
    "\1\3\1\21\1\12\1\7\1\24\1\3\1\25\1\6\2\3\1\43"+
    "\1\37\1\44\1\32\1\3\1\42\1\23\1\13\1\16\1\11\1\5"+
    "\1\20\1\3\1\26\1\22\1\3\1\17\1\14\1\27\1\10\1\15"+
    "\1\30\1\3\1\21\1\12\1\7\1\24\1\3\1\25\1\6\2\3"+
    "\1\1\1\32\1\35\1\32\201\3\uff00\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\1\2\1\1\1\3\1\4\13\3\1\5"+
    "\2\6\1\1\1\7\1\1\1\10\1\11\1\1\1\12"+
    "\1\13\1\14\1\15\1\1\1\16\1\17\1\20\1\21"+
    "\6\3\2\22\5\3\1\23\1\24\1\25\1\0\1\26"+
    "\1\0\1\27\1\30\11\3\1\0\11\3\2\0\3\3"+
    "\1\31\1\32\4\3";

  private static int [] zzUnpackAction() {
    int [] result = new int[90];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\46\0\114\0\162\0\230\0\0\0\0\0\276"+
    "\0\344\0\u010a\0\u0130\0\u0156\0\u017c\0\u01a2\0\u01c8\0\u01ee"+
    "\0\u0214\0\u023a\0\u0260\0\u0286\0\u02ac\0\u02d2\0\0\0\u02f8"+
    "\0\u031e\0\u0344\0\u036a\0\0\0\u0390\0\u03b6\0\0\0\0"+
    "\0\u03dc\0\u0402\0\u0428\0\0\0\0\0\u044e\0\u0474\0\u049a"+
    "\0\u04c0\0\u04e6\0\u050c\0\u0532\0\u0558\0\u057e\0\344\0\u05a4"+
    "\0\u05ca\0\u05f0\0\u0616\0\u063c\0\u0662\0\0\0\u0688\0\u036a"+
    "\0\0\0\u06ae\0\u06d4\0\u06fa\0\u0720\0\u0746\0\u076c\0\u0792"+
    "\0\u07b8\0\u07de\0\u0804\0\u082a\0\u0850\0\u0876\0\u089c\0\u08c2"+
    "\0\u08e8\0\u090e\0\u0934\0\u095a\0\u0980\0\u09a6\0\u09cc\0\u09f2"+
    "\0\u0a18\0\u0a3e\0\u0a64\0\u0a8a\0\0\0\0\0\u0ab0\0\u0ad6"+
    "\0\u0afc\0\u0b22";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[90];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\46\0\1\6\1\7\1\10\1\11\1\12\1\13\2\11"+
    "\1\14\1\11\1\15\1\16\4\11\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\11\1\25\1\11\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\6\1\26\1\34\1\6"+
    "\3\27\33\35\1\36\5\35\1\37\1\40\3\35\3\6"+
    "\1\41\1\42\24\41\2\6\1\43\4\6\1\0\1\6"+
    "\1\44\2\6\1\27\31\45\1\46\6\45\1\46\5\45"+
    "\35\0\1\47\13\0\26\11\21\0\1\12\44\0\3\11"+
    "\1\50\1\11\1\51\20\11\20\0\12\11\1\52\13\11"+
    "\20\0\2\11\1\52\23\11\20\0\11\11\1\53\14\11"+
    "\20\0\12\11\1\54\13\11\20\0\2\11\1\55\23\11"+
    "\20\0\5\11\1\56\7\11\1\57\6\11\1\60\1\11"+
    "\20\0\7\11\1\57\11\11\1\61\4\11\20\0\7\11"+
    "\1\62\16\11\20\0\17\11\1\63\6\11\20\0\20\11"+
    "\1\64\5\11\46\0\1\26\6\0\1\26\10\0\1\65"+
    "\1\0\24\65\52\0\1\66\45\0\1\67\10\0\36\70"+
    "\1\71\1\72\6\70\33\35\1\0\5\35\2\0\3\35"+
    "\3\0\1\73\1\0\24\73\20\0\26\41\21\0\1\42"+
    "\44\0\1\74\1\0\24\74\46\0\1\46\6\0\1\46"+
    "\36\0\1\47\6\0\1\47\10\0\4\11\1\75\21\11"+
    "\20\0\6\11\1\76\17\11\20\0\4\11\1\57\21\11"+
    "\20\0\12\11\1\77\13\11\20\0\16\11\1\57\7\11"+
    "\20\0\5\11\1\100\20\11\20\0\13\11\1\101\12\11"+
    "\20\0\25\11\1\102\20\0\4\11\1\103\21\11\20\0"+
    "\2\11\1\57\23\11\20\0\4\11\1\104\21\11\20\0"+
    "\13\11\1\105\12\11\20\0\26\65\46\0\1\67\6\0"+
    "\1\67\5\0\40\70\1\0\5\70\3\0\26\73\12\0"+
    "\1\106\5\0\26\74\20\0\2\11\1\107\23\11\20\0"+
    "\10\11\1\16\4\11\1\17\1\11\1\110\1\111\3\11"+
    "\1\25\1\11\20\0\13\11\1\112\12\11\20\0\6\11"+
    "\1\113\17\11\20\0\11\11\1\114\14\11\20\0\12\11"+
    "\1\115\13\11\20\0\12\11\1\116\13\11\20\0\23\11"+
    "\1\57\2\11\20\0\16\11\1\117\7\11\20\0\1\120"+
    "\1\121\24\120\20\0\5\11\1\122\20\11\20\0\15\11"+
    "\1\57\10\11\20\0\21\11\1\61\4\11\20\0\14\11"+
    "\1\57\11\11\20\0\2\11\1\54\23\11\20\0\21\11"+
    "\1\123\4\11\20\0\16\11\1\52\7\11\20\0\2\11"+
    "\1\124\23\11\20\0\12\11\1\57\13\11\20\0\26\120"+
    "\13\0\1\125\5\0\1\121\37\0\1\126\4\0\6\11"+
    "\1\127\17\11\20\0\6\11\1\62\17\11\20\0\7\11"+
    "\1\130\16\11\20\0\7\11\1\57\16\11\20\0\13\11"+
    "\1\131\12\11\20\0\20\11\1\132\5\11\20\0\25\11"+
    "\1\62\15\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2888];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\10\4\0\2\11\17\1\1\11\4\1\1\11\2\1"+
    "\2\11\3\1\2\11\20\1\1\11\1\1\1\0\1\11"+
    "\1\0\13\1\1\0\11\1\2\0\3\1\2\11\4\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[90];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
    public TwigLexer(int state){
        initialize(state);
    }
    public void reset(char array[], int offset, int length) {
        this.zzBuffer = array;
        this.zzCurrentPos = offset;
        this.zzMarkedPos = offset;
        this.zzPushbackPos = offset;
        this.yychar = offset;
        this.zzEndRead = offset + length;
        this.zzStartRead = offset;
        this.zzAtEOF = zzCurrentPos >= zzEndRead;
        this.firstPos = offset;
    }

    public void reset(java.io.Reader  reader, char[] buffer, int[] parameters){
    	this.zzReader = reader;
    	this.zzBuffer = buffer;
    	this.zzMarkedPos = parameters[0];
    	this.zzPushbackPos = parameters[1];
    	this.zzCurrentPos = parameters[2];
    	this.zzStartRead = parameters[3];
    	this.zzEndRead = parameters[4];
    	this.yyline = parameters[5];  
    	initialize(parameters[6]);
    }

    
    public int[] getParamenters(){
    	return new int[]{zzMarkedPos, zzPushbackPos, zzCurrentPos, zzStartRead, zzEndRead, yyline, zzLexicalState};
    }

    protected int getZZLexicalState() {
        return zzLexicalState;
    }

    protected int getZZMarkedPos() {
        return zzMarkedPos;
    }

    protected int getZZEndRead() {
        return zzEndRead;
    }

    public char[] getZZBuffer() {
        return zzBuffer;
    }
    
    protected int getZZStartRead() {
    	return this.zzStartRead;
    }

    protected int getZZPushBackPosition() {
    	return this.zzPushbackPos;
    }

	protected void pushBack(int i) {
		yypushback(i);
	}

	// A pool of states. To avoid creation of a new state on each createMemento.
	private static final IntHashtable lexerStates = new IntHashtable(100);
	
	protected IntHashtable getLexerStates() {
		return lexerStates;
	}
	
	private final void dump(String s) {
		if (Debug.debugTokenizer) {
			System.out.println("lexer: " + s + " (" + yychar + "-" + //$NON-NLS-2$//$NON-NLS-1$
				(yylength() + yychar) + "):\'" +//$NON-NLS-1$
					StringUtils.escape(yytext()) + "\'");//$NON-NLS-1$
		}
	}
	
	

 // End user code


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public TwigLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public TwigLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 172) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public String yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 6: 
          { return TWIG_DELIMITER;
          }
        case 27: break;
        case 26: 
          { if (Debug.debugTokenizer)
		System.out.println("variable3");

    return TWIG_VARIABLE;
          }
        case 28: break;
        case 24: 
          { if (Debug.debugTokenizer)
		System.out.println("variable5");

    return TWIG_VARIABLE;
          }
        case 29: break;
        case 16: 
          { popState();return TWIG_WHITESPACE;
          }
        case 30: break;
        case 1: 
          { if(Debug.debugTokenizer)
		dump("TWIG HIGHLIGHT ERROR");

	reportError();
    yypushback(1);
    pushState(ST_TWIG_HIGHLIGHTING_ERROR);
          }
        case 31: break;
        case 18: 
          { if(Debug.debugTokenizer)
		dump("TWIG KEYWORD");

	return TWIG_KEYWORD;
          }
        case 32: break;
        case 5: 
          { if(Debug.debugTokenizer)
		dump("TWIG WHITESPACE");

	return TWIG_WHITESPACE;
          }
        case 33: break;
        case 12: 
          { return TWIG_LABEL;
          }
        case 34: break;
        case 3: 
          { if(Debug.debugTokenizer)
		dump("TWIG LABEL");

	return TWIG_LABEL;
          }
        case 35: break;
        case 10: 
          { if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES END");

	yybegin(ST_TWIG_CONTENT);
    return TWIG_DOUBLE_QUOTES_END;
          }
        case 36: break;
        case 17: 
          { if(Debug.debugTokenizer)
		dump("TWIG_STMT_CLOSE");

	return TWIG_STMT_CLOSE;
          }
        case 37: break;
        case 9: 
          { if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES CONTENT");

    return TWIG_DOUBLE_QUOTES_CONTENT;
          }
        case 38: break;
        case 23: 
          { if (Debug.debugTokenizer)
		dump("TWIG DOLLAR VAR");
		
    return TWIG_VARIABLE;
          }
        case 39: break;
        case 2: 
          { if(Debug.debugTokenizer)
		dump("TWIG JSON START");


    return TWIG_JSON_START;
          }
        case 40: break;
        case 14: 
          { yybegin(ST_TWIG_DOUBLE_QUOTES);
    return TWIG_BACKTICK_END;
          }
        case 41: break;
        case 19: 
          { if (Debug.debugTokenizer)
		dump("TWIG VARIABLE");

	return TWIG_VARIABLE;
          }
        case 42: break;
        case 11: 
          { yybegin(ST_TWIG_DOUBLE_QUOTES_SPECIAL);
    return TWIG_BACKTICK_START;
          }
        case 43: break;
        case 25: 
          { if (Debug.debugTokenizer)
		System.out.println("variable4");

    return TWIG_VARIABLE;
          }
        case 44: break;
        case 22: 
          { if(Debug.debugTokenizer)
		dump("TWIG_CONSTANT_ENCAPSED_STRING");

    return TWIG_CONSTANT_ENCAPSED_STRING;
          }
        case 45: break;
        case 21: 
          { if(Debug.debugTokenizer)
		dump("return TWIG_CLOSETAG " + TWIG_CLOSETAG);

	return TWIG_CLOSETAG;
          }
        case 46: break;
        case 4: 
          { if(Debug.debugTokenizer)
		dump("TWIG NUMBER");

    return TWIG_NUMBER;
          }
        case 47: break;
        case 13: 
          { return TWIG_NUMBER;
          }
        case 48: break;
        case 20: 
          { if(Debug.debugTokenizer)
		dump("TWIG COMMENT CLOSE");
		
	yybegin(YYINITIAL);
	return TWIG_COMMENT_CLOSE;
          }
        case 49: break;
        case 8: 
          { if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES START");

	yybegin(ST_TWIG_DOUBLE_QUOTES);
    return TWIG_DOUBLE_QUOTES_START;
          }
        case 50: break;
        case 7: 
          { if(Debug.debugTokenizer)
		dump("TWIG JSON END");

	//yybegin(ST_TWIG_JSON)

    return TWIG_JSON_END;
          }
        case 51: break;
        case 15: 
          { return UNKNOWN_TOKEN;
          }
        case 52: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
