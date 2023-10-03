package org.example.processes;

import org.example.models.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public static void writeStudent(Student student){
        try {
            FileWriter studentWriter = new FileWriter("students.txt");
            studentWriter.write(student.toString());
            studentWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeStudent(String str){
        try {
            FileWriter studentWriter = new FileWriter("students.txt");
            studentWriter.write(str);
            studentWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static List<Student> readStudent () {
        int n = 0;
        try {
            File studentsFile = new File("students.txt");
            Scanner reader = new Scanner(studentsFile);
            while (reader.hasNextLine()){
                Student stud;
                switch (n % Student.numberOfAttributes) {
                    case 0:
                        String fn = reader.nextLine();
                        break;
                    case 1:
                        String ln = reader.nextLine();
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;

                }
                n++;
            }
            reader.close();
          //  return reader.next();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<Student>();
    }
}
