/*
Paolo S.
CS 2-1 | PT2
*/

import java.util.regex.*;
import java.io.*;

public class AnswerKeyProblem {
    private static String a, b, c, d, answers = "";
    public static void main(String args[])throws IOException
    {
        //read in the file provided by your teacher
        BufferedReader codedAnswers = new BufferedReader(
                new FileReader(new File("C:/git/OOP/PT2/CodedAnswerKey.txt")));
        //initialize string line as the first line of the file
        String line = codedAnswers.readLine();

        //keep reading each line and adding answers that match answer
        //Possibilities to string answers until there are no more lines in the file
        while (line != null) {
            if (line.matches("[a-fA-F]")) {
                answers = answers + line;
            }
            // read the next line of the file
            line = codedAnswers.readLine();
        }//end while

        System.out.println("\nHere are the choices: ");
        for (int i = 0; i < answers.length(); i++) {
            System.out.println(answers.charAt(i));
        }
        answers = finalAnswers(answers);
    }//end method main

    private static String finalAnswers(String answers) {
        a = answers.replace('e', 'b');
        b = a.replace('E', 'A');
        c = b.replace('f', 'c');
        d = c.replace('F', 'D');

        System.out.println("\nHere are the correct answers: ");
        for (int i = 0; i < answers.length(); i++) {
            char x = d.charAt(i);
            char y = Character.toLowerCase(x);
            System.out.println(y);
        }
        System.out.println();
        return answers;
    }
}//end class AnswerKeyProblem
