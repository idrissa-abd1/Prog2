package Lab10;
/*****************************************************************************/
/*                                                                           */
/* ArrayAccess.java                                                          */
/* A program that allows a user to input SIZE many numbers (usually 10) then */
/* choose one of two actions:                                                */
/*    1. Enter a number to search for in the array                           */
/*    2. Enter an index to retrieve the value at that index                  */
/*                                                                           */
/* The main purpose of this program is to write two new exception classes    */
/* NumberNotFoundException, and MyArrayIndexOutOfBoundsException, and then   */
/* modify the code to include try/catch blocks to handle any exceptions that */
/* might arise from one of three potential problems:                         */
/*    1. The user inputs something besides an integer (causing a             */
/*       NumberFormatException to be thrown                                  */
/*    2. The number to be searched for is not in the array (causing a        */
/*       NumberNotFoundException to be thrown)                               */
/*    3. The index entered is out of bounds (causing an                      */
/*       MyArrayIndexOutOfBoundsException to be thrown)                      */
/*                                                                           */
/*                                                                           */
/*****************************************************************************/

import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayAccess
{
    public static void main (String[] args) {
        final int SIZE = 10;            // size of array

        Scanner reader = new Scanner( System.in );
        StringTokenizer tokenizer;
        int [] myArray = new int [SIZE]; // array to hold integers
        String line;                     // for reading input
        String token = "";               // for the tokens from the StringTokenizer
        int searchValue;                 // value to search array for
        int index;                       // used for retrieving value from array
        int i, j;                        // loop counters
        boolean found;                   // flag used in search


        System.out.println( "Please enter " + SIZE + " integers, all on one line:" );
        line = reader.nextLine();
        tokenizer = new StringTokenizer( line );
        i = 0;
        while ( tokenizer.hasMoreTokens() )
        {
            try{
                token = tokenizer.nextToken();
                myArray[i] = Integer.parseInt( token );
                i++;
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println( "\nNow what would you like to do? Enter: " );
        System.out.println( "\t1: To search for a number in the array" );
        System.out.println( "\t2: To enter an index to retrieve its value" );
        System.out.println( "\tq: To quit" );
        System.out.print( "Your choice: " );
        line = reader.nextLine();
        while ( line.compareTo( "1" ) != 0 && line.compareTo( "2" ) != 0 && line.compareTo( "q" ) != 0 )
        {
            System.out.println( "\nInvalid choice! Please enter 1, 2, or q" );
            System.out.println( "Your choice: " );
            line = reader.nextLine();
        }
        while ( line.compareTo( "q" ) != 0 )
        {
            if ( line.compareTo( "1" ) == 0 )
            {
                System.out.print( "\nEnter the integer to search for: " );
                line = reader.nextLine();
                searchValue = Integer.parseInt( line );
                i = 0;
                found = false;
                while( i < myArray.length  && !found )
                {

                    if ( myArray[i] == searchValue )
                        found = true;
                    else
                        i++;
                }
                try{
                if ( found )
                    System.out.println( "The value " + searchValue + " was found at index " + i );
                else
                    throw new NumberNotFoundException();
                }catch (NumberNotFoundException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println("Something went wrong!");
                }
            }
            else if ( line.compareTo( "2" ) == 0 )
            {
                System.out.print( "\nEnter the index to retrieve: " );
                line = reader.nextLine();

                try{
                    index = Integer.parseInt( line );
                    if(index < 0 || index >= SIZE){
                        throw new MyArrayIndexOutOfBoundsException(index);
                    }
                    System.out.println( "The value at index " + index + " is: " + myArray[index] );
                }catch (MyArrayIndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println("something went wrong");
                }
            }
            System.out.println( "\nWould you like to go again?" );
            System.out.println( "\t1: To search for a number in the array" );
            System.out.println( "\t2: To enter an index to retrieve its value" );
            System.out.println( "\tq: To quit" );
            System.out.print( "Your choice: " );
            line = reader.nextLine();
            while ( line.compareTo( "1" ) != 0 && line.compareTo( "2" ) != 0 && line.compareTo( "q" ) != 0 )
            {
                System.out.println( "\nInvalid choice! Please enter 1, 2, or q" );
                System.out.println( "Your choice: " );
                line = reader.nextLine();
            }
        } // end while loop
    } // main method
} // ArrayAccess class
