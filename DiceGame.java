// Name: Parakram Basnet          Date Assigned: 3/16/2017
//
// Course: CSCI 2003 60357        Date Due: 3/23/2017
//
// Instructor: Ms. Greer
//
// File name: DiceGame.java
//
// Program Description: The program will first display an introduction and the rules of the game. 
// It asks player one to enter “R” to roll all 6 dice. The roll is displayed. Then, if any 
// sequences are found, those are displayed separately, and points gained from them are added to 
// player 1’s score. If no sequences are found, it says “No sequences!” and no points are added. 
// This process repeats for player 2. The players alternate turns until one player reaches 100. At
// the end, the winning player is declared, and then the program ends.

// Importing Scanner and Random class from java.util package
import java.util.Scanner;
import java.util.Random;

/*
 * The Dicegame class simulates a dice game between two players. It is a turn based game where each
 * player rolls 6 dice per turn and gets points based on the number of sequences and length of
 * sequence generated. The game ends when a player scores 100 or more.   
*/
public class DiceGame
{  // Begin class
   
   public static void main(String[] args)
   {  // Begin main
      
      // Declaring Scanner and Random object
      Scanner in = new Scanner (System.in);
      Random generate = new Random();
      
      // Displaying the manu and the rules
      System.out.println("Run For It! - A Dice Game\n");
      
      System.out.println("Rules \n=====");
      
      System.out.println("1. 2 players take truns rolling 6 dice.");
      System.out.println("\n2. Get points if roll contains one or \n   more sequences.");
      System.out.println("\n\t 1. Sequence must start from 1 and \n\t    not skip any numbers. \n\n\t 2. Get 5 points for each number \n\t    in the sequence(s).");  
   
      System.out.println("\n3. Get no points if roll contains \n   no sequences.");
      System.out.println("\n4. First player to get to 100 points \n   wins.");
      
      System.out.println("\n=======================================\n");
      
      // Declaring variables for scores and winner
      int p1_score = 0;
      int p2_score = 0;
      String winner = "";
      
      // Declaring flag variable
      boolean flag3 = true; 
      boolean flag4 = true;
      
      // The while loop that ends when one of the players scores 100 or more.
      while (flag3)
      {  // Begin while loop 
         
         // Declaring flag variables
         boolean flag1 = true;
         boolean flag2 = true;
         
         // While loop for Player 1 
         while ( flag1)   
         { // Begin Player 1 while loop 
            
            // Declaring variables
            String sequence = "";
            String order_sequence = "";
            String ref_sequence = "123456";
            
            // Asking user input to roll the dice
            System.out.print("Player 1 - Enter R to roll: ");
            String roll = in.nextLine();
            
            // If statement that executes when user enters "r" or "R"
            if ((roll.equals("r")) || (roll.equals("R")))
            {  // Begin if statement
               
               // For statement that generates the dice roll
               for ( int i = 0; i < 6; i++)
               {  // Begin for statement
                  
                  // Generating random numbers and concatenating them into sequence
                  int num = 1 + generate.nextInt(6);
                  sequence += num;
                  
               }  // end for statement
            
               // Declaring variable to print out
               String print_sequence = "";
            
               // For loop to generate the sequence with spaces
               for ( int i = 0; i < 6; i++)
               {  // Begin for loop
                  
                  print_sequence += sequence.substring(i,i+1) + " "; 
               
               }  // end for loop
            
               // Displaying the sequence with spaces
               System.out.println("\nRoll: " + print_sequence + "\n");
            
               
               // Nested for loops that arrange the random number in ascending order
               for ( int i = 0; i < 6; i++)
               {  // begin outer for loop
               
                  for ( int j = 0; j < 6; j++)
                  {  // begin inner for loop 
                   
                     // if statement that compares sequence to reference sequence 
                     if ( (sequence.charAt(j))==( ref_sequence.charAt(i)))
                     {
                        // Saving the ascending number in the variable "order_sequence"
                        order_sequence += ref_sequence.charAt(i);
                     } 
                  
                  }  // ending inner for loop                   
               
               }  // ending outer for loop
            
               // Declaring counter variables to count the number of 1's and 2's respectively
               int count1 = 0;
               int count2 = 0;
            
               // Counting  the number of 1's
               for ( int i = 0; i < 6; i++)
               { 
                  if ( (order_sequence.substring(i, i+1)).equals("1"))
                  {
                     // Saving the number of 1's in count1
                     count1 += 1;
                  }   
               } 
            
               // Counting the number of 2's
               for ( int j = 0; j < 6; j++)
               {
                  if ( (order_sequence.substring(j, j+1)).equals("2"))
                  {
                     // Saving the number of 2's in count2
                     count2 += 1;
                  }
               }
               
               // Condition when there is one 1 and one 2
               if ( count1 == 1 && count2 == 1)
               {
                  // Declaring variables
                  int a = 2;
                  String new_sequence = "12";
               
                  // For loop to generate the required final sequence
                  for (int i = 0; i < 4; i++)
                  {  // start for loop
                     
                     if ( (order_sequence.charAt(i+2)) == ref_sequence.charAt(a))
                     {  
                        // Adding numbers in sequence in new sequence
                        new_sequence += ref_sequence.charAt(a);
                        a += 1;
                     } 
                  }  // end for loop
                  
                  // Calculating score for Player 1
                  p1_score += 5 * new_sequence.length();
                  
                  // Displaying the sequence
                  System.out.println("Sequence 1: " + new_sequence + "\n");
               }
               
               
               // If there are two 1's and two 2's
               else if ( count1 == 2 && count2 == 2)
               {  // start else if statement
               
                  if (((order_sequence.charAt(4)) == (ref_sequence.charAt(2))) && ((order_sequence.charAt(5)) == (ref_sequence.charAt(2))))
                  {
                     // Displaying sequence
                     System.out.println("Sequence 1: 123");
                     System.out.println("Sequence 2: 123\n");
                     
                     // Calculating Score
                     p1_score += 5 * 6;
                  } 
                  
                  else if (((order_sequence.charAt(4)) == (ref_sequence.charAt(2))) && ((order_sequence.charAt(5)) != (ref_sequence.charAt(2))))
                  {
                     if (( order_sequence.charAt(5)) == (ref_sequence.charAt(3)))
                     {
                        // Displaying sequence
                        System.out.println("Sequence 1: 1234");
                        System.out.println("Sequence 2: 12\n");
                        
                        // calculating score
                        p1_score += 5 * 6;
                     }
                     
                     else
                     {  
                        // Displaying sequence
                        System.out.println("Sequence 1: 123");
                        System.out.println("Sequence 2: 12\n");
                        
                        // Calculating score
                        p1_score += 5 * 5;
                     }
                  }
                  
                  else if (((order_sequence.charAt(4)) != (ref_sequence.charAt(2))) && ((order_sequence.charAt(5)) != (ref_sequence.charAt(2))))
                  {
                     // Displaying sequence
                     System.out.println("Sequence 1: 12");
                     System.out.println("Sequence 2: 12\n");
                     
                     // Calculating score
                     p1_score += 5 * 4;
                  }
               
               } // end else if
               
               // When there are three 1's and three 2's
               else if ( count1 == 3 && count2 == 3)
               {
                  // Displaying sequence
                  System.out.println("Sequence 1: 12");
                  System.out.println("Sequence 2: 12");
                  System.out.println("Sequence 3: 12\n");
                  
                  // Calculating score
                  p1_score += 5 * 6;
               
               }
               
               // When there are no 1's, 2's or six 1's
               else if ( count1 == 0 || count2 == 0  || count1 == 6 )
               {
                  System.out.println("No sequence!\n");
               }
               
               // When there is only one sequence
               else if ( (count1 >= 1 && count2 == 1) || (count1 == 1 && count2 >= 1)) 
               {
                  // declaring variable
                  int a = 1;
                  
                  // declaring new sequence
                  String new_sequence = "1";
               
                  // for loop to determine the sequence
                  for ( int i = 0; i < 5; i++)
                  {
                     if ((order_sequence.charAt(i + 1)) == ( ref_sequence.charAt(a)))
                     {
                        // Concatenating numbers into new sequence
                        new_sequence += order_sequence.substring(i + 1,i + 2);
                        a = a + 1;
                     }                        
                  }
                  
                  // displaying the sequence
                  System.out.println("Sequence 1: " + new_sequence + "\n");
                  
                  // Calculating score
                  p1_score += 5 * (new_sequence.length());
               }
               
               // when there is more than one 1's and more than one 2's  
               else if ( count1 > 1 && count2 > 1)
               {
                  if (( count1 == 3 && count2 == 2) || ( count1 == 2 && count2 == 3))
                  {
                     if ( order_sequence.charAt(5) == ref_sequence.charAt(2))
                     {
                        System.out.println("Sequence 1: 123");
                        System.out.println("Sequence 2: 12\n");
                     
                        p1_score += 5 * 5;
                     }
                     
                     else
                     {
                        System.out.println("Sequence 1: 12");
                        System.out.println("Sequence 2: 12\n");
                     
                        p1_score += 5 * 4;
                     }
                  }
               }
               
               // Displaying the scores of both the players
               System.out.println("Player 1 Score: " + p1_score); 
               System.out.println("Player 2 Score: " + p2_score + "\n");
            
               System.out.println("=======================================\n");
            
               // Changing the value of flag
               flag1 = false;
            
            } // end if statement
         
         } // end while for Player 1
         
         // if statement to check if Player 1 has scored more than 100 
         if (p1_score >= 100)
         {
            flag3 = false;
            winner = "Player 1"; 
         }
         
         // If player 1 has not scored more than 100, player 2 gets to play.
         else
         {  // else statement begin
         
            // while loop for Player 2
            while ( flag2)   
            {  // begin while loop
            
               // Declaring variables
               String sequence = "";
               String order_sequence = "";
               String ref_sequence = "123456";
            
               // Asking input from player
               System.out.print("Player 2 - Enter R to roll: ");
               String roll = in.nextLine();
            
               // If statement that executes when user enters "r" or "R"
               if ((roll.equals("r")) || (roll.equals("R")))
               {  // Begin if statement
               
                  // For statement that generates the dice roll
                  for ( int i = 0; i < 6; i++)
                  {  // Begin for loop
                     
                     int num = 1 + generate.nextInt(6);
                     sequence += num;
                     
                  } // End for loop
               
                  // Declaring variable to print out
                  String print_sequence = "";
               
                  // For loop to generate the sequence with spaces
                  for ( int i = 0; i < 6; i++)
                  {
                     print_sequence += sequence.substring(i,i+1) + " "; 
                  }
                  
                  // Displaying the sequence with spaces
                  System.out.println("\nRoll: " + print_sequence + "\n"); 
               
                  // Nested for loops that arrange the random number in ascending order
                  for ( int i = 0; i < 6; i++)
                  {
                     for ( int j = 0; j < 6; j++)
                     {
                        // if statement that compares sequence to reference sequence
                        if ( (sequence.charAt(j))==( ref_sequence.charAt(i)))
                        {
                           // Concatenating characters from reference
                           order_sequence += ref_sequence.charAt(i);
                        } 
                     }
                  
                  } 
                  
                  // Declaring counter variables
                  int count1 = 0;
                  int count2 = 0;
               
                  // Counting number of 1's
                  for ( int i = 0; i < 6; i++)
                  { 
                     if ( (order_sequence.substring(i, i+1)).equals("1"))
                     {
                        count1 += 1;
                     }   
                  } 
               
                  // Counting number of 2's
                  for ( int j = 0; j < 6; j++)
                  {
                     if ( (order_sequence.substring(j, j+1)).equals("2"))
                     {
                        count2 += 1;
                     }
                  }
                  
                  // If statement that gets executed when there is one 1 and one 2
                  if ( count1 == 1 && count2 == 1)
                  {
                     // Declaring variables
                     int a = 2;
                     String new_sequence = "12";
                     
                     // For loop to generate the required final sequence
                     for (int i = 0; i < 4; i++)
                     {   // start for loop
                        
                        if ( (order_sequence.charAt(i+2)) == ref_sequence.charAt(a))
                        {
                           // Adding numbers in sequence in new sequence
                           new_sequence += ref_sequence.charAt(a);
                           a += 1;
                        } 
                     }  // end for
                     
                     // Calculating score for Player 2
                     p2_score += 5 * new_sequence.length();
                     
                     // Displaying score for Player 2
                     System.out.println("Sequence 1: " + new_sequence + "\n");
                  }
                  
                  // If there are two 1's and two 2's
                  else if ( count1 == 2 && count2 == 2)
                  { // start else if
                     
                     if (((order_sequence.charAt(4)) == (ref_sequence.charAt(2))) && ((order_sequence.charAt(5)) == (ref_sequence.charAt(2))))
                     {  
                        // Displaying sequence
                        System.out.println("Sequence 1: 123");
                        System.out.println("Sequence 2: 123\n");
                     
                        // Displaying score
                        p2_score += 5 * 6;
                     } 
                     
                     else if (((order_sequence.charAt(4)) == (ref_sequence.charAt(2))) && ((order_sequence.charAt(5)) != (ref_sequence.charAt(2))))
                     {
                        if (( order_sequence.charAt(5)) == (ref_sequence.charAt(3)))
                        {
                           // Displaying sequence
                           System.out.println("Sequence 1: 1234");
                           System.out.println("Sequence 2: 12\n");
                           
                           // Displaying score
                           p2_score += 5 * 6;
                        }
                        
                        else
                        {
                           // Displaying sequence
                           System.out.println("Sequence 1: 123");
                           System.out.println("Sequence 2: 12\n");
                        
                           // Displaying score
                           p2_score += 5 * 5;
                        }
                     }
                     
                     else if (((order_sequence.charAt(4)) != (ref_sequence.charAt(2))) && ((order_sequence.charAt(5)) != (ref_sequence.charAt(2))))
                     {
                        // Displaying sequence
                        System.out.println("Sequence 1: 12");
                        System.out.println("Sequence 2: 12\n");
                     
                        // Displaying score
                        p2_score += 5 * 4;
                     }
                  } // End else if 2
                  
                  else if ( count1 == 3 && count2 == 3)
                  {
                     // Displaying sequence
                     System.out.println("Sequence 1: 12");
                     System.out.println("Sequence 2: 12");
                     System.out.println("Sequence 3: 12\n");
                  
                     // Displaying score
                     p2_score += 5 * 6;
                  
                  }
                  
                  // When there are no 1's, 2's or six 1's   
                  else if ( count1 == 0 || count2 == 0  || count1 == 6 )
                  {
                     System.out.println("No sequence!\n");
                  }
                  
                  // When there is only one sequence
                  else if ( (count1 >= 1 && count2 == 1) || (count1 == 1 && count2 >= 1)) 
                  {
                     // Declaring variable
                     int a = 1;
                     
                     // Declaring new sequence
                     String new_sequence = "1";
                  
                     // For loop to determine the sequence
                     for ( int i = 0; i < 5; i++)
                     {
                        if ((order_sequence.charAt(i + 1)) == ( ref_sequence.charAt(a)))
                        {
                           // Concatenating numbers into new sequence
                           new_sequence += order_sequence.substring(i + 1,i + 2);
                           a = a + 1;
                        }                        
                     }
                  
                     // Displaying the sequence
                     System.out.println("Sequence 1: " + new_sequence + "\n");
                     
                     // Calculating score
                     p2_score += 5 * (new_sequence.length());
                  }
                  
                  // When there is more than one 1's and more than one 2's  
                  else if ( count1 > 1 && count2 > 1)
                  {
                     if (( count1 == 3 && count2 == 2) || ( count1 == 2 && count2 == 3))
                     {
                        if ( order_sequence.charAt(5) == ref_sequence.charAt(2))
                        {
                           // Displaying the sequence
                           System.out.println("Sequence 1: 123");
                           System.out.println("Sequence 2: 12\n");
                           
                           // Calculating score
                           p2_score += 5 * 5;
                        }
                        
                        else
                        {
                           // Displaying the sequence
                           System.out.println("Sequence 1: 12");
                           System.out.println("Sequence 2: 12\n");
                        
                           // Calculating score
                           p2_score += 5 * 4;
                        }
                     }
                  }
               
                  // Displaying the scores of both the players
                  System.out.println("Player 1 Score: " + p1_score);
                  System.out.println("Player 2 Score: " + p2_score + "\n");
               
                  System.out.println("=======================================\n");
                  
                  // Changing the value of flag
                  flag2 = false;
               
               } // end if statement
            
            } // end while p2
         
         } // end else
         
         // if statement to check if Player 2 score 100 ir more
         if ( p2_score >= 100)
         {
            flag3 = false;
            winner = "Player 2";
         }
            
      } // end main while score loop 
      
      // Displaying the winner of the game
      System.out.printf("%20s Wins!", winner);
      System.out.println("\n\n=======================================\n"); 
   
   } // end main
} // end class