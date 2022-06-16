package Practice;

import java.util.ArrayList;
import java.util.Collection;

public class Student {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList();

        addStudents(studentNames);
        //Collection.sort();
        displayStudents(studentNames);
    }

    static void addStudents(ArrayList<String> studentNames){
        studentNames.add("Christian");
        studentNames.add("Christine");
        studentNames.add("John Kier");
    }

    static void displayStudents(ArrayList<String> studentNames){
        for(String student : studentNames){
            System.out.println("Student name: " + student);
        }
    }
}
