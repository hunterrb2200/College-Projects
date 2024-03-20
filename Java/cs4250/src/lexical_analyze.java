

import java.util.*;
import java.io.*;

class lexical_analyze{
   /* Global declarations */
   /* Variables */
   int charClass;
   char lexeme[]   =   new char[100]; // declaration and instantiation.
   //char nextChar;
   int file_pointer;
   int lexLen;
   int token;
   int nextToken;
   FileInputStream in = null;
  
   /* Character classes */
   final int LETTER = 0;
   final int DIGIT = 1;
   final int UNKNOWN = 99;

   /* Token codes */
   final int INT_LIT = 10;
   final int IDENT = 11;
   final int ASSIGN_OP = 20;
   final int ADD_OP = 21;
   final int SUB_OP = 22;
   final int MULT_OP = 23;
   final int DIV_OP = 24;
   final int LEFT_PAREN = 25;
   final int RIGHT_PAREN = 26;
   final int SEMI_COLUMN = 27;
   final int COMP_OP_SMALL = 28;
   final int COMP_OP_LARGE = 29;
   final int COMP_OP_EQUAL = 30;

  
   /** Function to to lookup operators and parentheses and return the token
   *
   * @param void
   *
   * @return void
   *
   */
   public int lookup(char ch){
       switch(ch){
           case '(' :
               addChar();
               nextToken = LEFT_PAREN;
               break;
           break;
          
           case ')' :
               addChar();
               nextToken = RIGHT_PAREN;
break;

           case '+' :
               addChar();
               nextToken = ADD_OP;
           break;
  
           case '-' :
               addChar();
               nextToken = SUB_OP;
           break;
  
           case '*' :
               addChar();
               nextToken = MULT_OP;
break;
  
           case '/' :
               addChar();
               nextToken = DIV_OP;
break;
  
           case '=' :
               addChar();
               nextToken = ASSIGN_OP;
break;
  
           case ';' :
               addChar();
               nextToken = SEMI_COLUMN;
break;
  
           case '>':
               addChar();
               nextToken = COMP_OP_LARGE;
break;
  
           case '<' :
               addChar();
               nextToken = COMP_OP_SMALL;
break;
  
           default :
               addChar();
               nextToken = -1;
           //break;          
       }
       return nextToken;
   }// end lookup()
  
   /** Function to add nextChar to lexeme
   *
   * @param void
   *
   * @return void
   *
   */
   public void addChar(){
       if(lexLen <= 98){
           lexeme[lexLen++]    =    file_pointer;
           lexeme[lexLen]        =    0;
       }else{
           System.out.println("Error - lexeme is too long");
       }
   }// end addChar()
  
   /** Function to get the next character of input and determine its character class
   *
   * @param void
   *
   * @return void
   *
   */
   public void getChar(){
       //int file_pointer;
       if((file_pointer = in.read()) != -1){
           if(Character.isLetterOrDigit(file_pointer)){
               charClass = LETTER;
           }else if(Character.isDigit(file_pointer)){
               charClass = DIGIT;
           }else{
               charClass = UNKNOWN;
           }
       }else{
           charClass = -1;
       }
   }// end getChar()
  
   /** Function to call getChar until it returns a non-whitespace character
   *
   * @param void
   *
   * @return void
   *
   */
   public void getNonBlank(){
       while(Character.isSpace(file_pointer)){
           getChar();
       }
   }// end getNonBlank()
  
   /** Function for a simple lexical analyzer for arithmetic expressions
   *
   * @param void
   *
   * @return void
   *
   */
   public int lex(){
       lexLen = 0;
       getNonBlank();
       switch(charClass){
           /* Parse identifiers */
           case LETTER :
               addChar();
               getChar();
               while(charClass == LETTER || charClass == DIGIT){
                   addChar();
                   getChar();
               }
               nextToken = IDENT;
           break;
          
           /* Parse integer literals */
           case DIGIT :
               addChar();
               getChar();
               while(charClass == DIGIT){
                   addChar();
                   getChar();
               }
               nextToken = INT_LIT;
           break;
          
           /* Parentheses and operators */
           case UNKNOWN :
               lookup(file_pointer);
               getChar();
           break;
          
           /* EOF */
           default :
               nextToken = -1;
               lexeme[0] = 'E';
               lexeme[1] = 'O';
               lexeme[2] = 'F';
               lexeme[3] = 0;  
       } /* End of switch */
       System.out.println("Next token is : " + nextToken + " Next lexeme is " + lexeme);
       return nextToken;
   }// end lex()
}// end class

class lexicalanalyzer{
   public static void main(String []args) throws IOexception{
       lexical_analyze lex_ana = new lexical_analyze();
       //FileInputStream instr = null;
       lex_ana.in = new FileInputStream("front.in");
       int c;
       if((c = lex_ana.in.read()) != -1) {
           System.out.println("Cannot open front.in");
       }else{
           lex_ana.getChar();
           do{
               lex_ana.lex();
           }while(lex_ana.nextToken != -1);
       }
       System.out.println("Parsing complete");
   }  
}