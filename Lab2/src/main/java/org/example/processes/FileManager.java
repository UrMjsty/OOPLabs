package org.example.processes;

import org.example.models.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FileManager {
    public void writeStudent(Student student){
        try {
            FileWriter studentWriter = new FileWriter("students.txt");
            studentWriter.write(student.toString());
            studentWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void writeStudent(String str){
        try {
            FileWriter studentWriter = new FileWriter("students.txt");
            studentWriter.write(str);
            studentWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void writeStudents(List<Student> students){
        String str = "";
        for (Student stud: students)
            str += stud.toString();
        try {
            FileWriter studentWriter = new FileWriter("students.txt");
            studentWriter.write(str);
            studentWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public List<Student> readStudent () {
        int n = 0;
        String fn = null;
        String ln = null;
        String email = null;
        String facName = null;
        String gr = null;
        String year = null;
        String bud = null;
        String grant = null;
        String fail = null;
        String grad = null;
        String DoB = null;
        String enD = null;
        try {
            File studentsFile = new File("students.txt");
            Scanner reader = new Scanner(studentsFile);
            while (reader.hasNextLine()) {
                Student stud;
                switch (n % (Student.numberOfAttributes+1)) {
                    case 0:
                        fn = reader.nextLine();
                        break;
                    case 1:
                        ln = reader.nextLine();
                        break;
                    case 2:
                        email = reader.nextLine();
                        break;
                    case 3:
                        facName = reader.nextLine();
                        break;
                    case 4:
                        gr = reader.nextLine();
                        break;
                    case 5:
                        year = reader.nextLine();
                        break;
                    case 6:
                        bud = reader.nextLine();
                        break;
                    case 7:
                        grant = reader.nextLine();
                        break;
                    case 8:
                        fail = reader.nextLine();
                        break;
                    case 9:
                        grad = reader.nextLine();
                        break;
                    case 10:
                        DoB = reader.nextLine();
                        break;
                    case 11:
                        enD = reader.nextLine();
                        break;
                    case 12:
                        Student student = new Student(fn, ln, email, facName, gr, parseInt(year), Boolean.parseBoolean(bud),Boolean.parseBoolean(grant),
                                Boolean.parseBoolean(fail),Boolean.parseBoolean(grad), LocalDate.parse(DoB), LocalDate.parse(enD));
                }
                n++;
            }

            Student student = new Student(fn, ln, email, facName, gr, parseInt(year), Boolean.parseBoolean(bud),Boolean.parseBoolean(grant),
                    Boolean.parseBoolean(fail),Boolean.parseBoolean(grad), LocalDate.parse(DoB), LocalDate.parse(enD));
            reader.close();
          //  return reader.next();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<Student>();
    }
}
