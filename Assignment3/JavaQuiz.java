package Assignment3;
/**
 * @author Jay Patel
 * @version 1.0
 */

import java.util.Scanner;

public class JavaQuiz {
    Scanner input = new Scanner(System.in);
    private int score = 0 ;
    String questions[][]=new String[3][6];

    /**
     * set values of array
     */
    public void setQuestions(){
        questions[0][0] = "1. What is Java?";
        questions[1][0] = "2. Stack is a ?";
        questions[2][0] = "3. Latest version of JavaFX is ?";
        questions[0][1] = "A. Java is procedural Lang ";
        questions[1][1] = "A. User Defined Class ";
        questions[2][1] = "A. 6 ";
        questions[0][2] = "B. Java is OOP Language ";
        questions[1][2] = "B. Collection Class ";
        questions[2][2] = "B. 2 ";
        questions[0][3] = "C. java is not a language ";
        questions[1][3] = "C. Both A and B ";
        questions[2][3] = "C. 11 ";
        questions[0][4] = "D. java is not a language ";
        questions[1][4] = "D. None of these ";
        questions[2][4] = "D. 14 ";
        questions[0][5] = "B";
        questions[1][5] = "B";
        questions[2][5] = "C";
            }

    /**
     * give questions and take answer as a input
     *
     */
    public void attemptTest(){
        int row,col;
        for (row = 0; row <questions.length ; row++) {
            for (col = 0; col < questions[row].length-1; col++) {
                System.out.println(questions[row][col]);
            }
            System.out.println("Enter your answer: ");
            String ans = input.next();
            checkResult(ans,row);
                }
            }

    /**
     *
     * @param ans - store input value
     * @param row - store original answer value
     */
    public void checkResult(String ans,int row) {
        if (ans.equalsIgnoreCase(questions[row][5])) {
            System.out.println("Your Answer is Correct.\n");
            score++;
        } else {
            System.out.println("Sorry! Your Answer is Incorrect.\n");
        }
    }
    public String toString(){
        if(((score*100)/3)>60){
            return "Your Score is: "+ score+ "\nCongratulations! You Have Successfully Passed The Test.";
        }else {
            return "Your Score is: "+ score+"\nSorry! You Have Failed The Test. So, You Will Need To Do It Again!";
        }

    }
}

