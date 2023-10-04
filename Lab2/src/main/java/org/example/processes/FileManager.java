package org.example.processes;

import org.example.models.Faculty;
import org.example.models.Student;
import org.example.models.StudyField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FileManager {
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
    public void readStudent() {
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
    }
    public void writeFaculties(List<Faculty> faculties){
        String str = "";
        for (Faculty faculty: faculties)
            str += faculty.toString();
        try {
            FileWriter facultyWriter = new FileWriter("faculties.txt");
            facultyWriter.write(str);
            facultyWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void readFaculty() {
        int n = 0;
        String fn = null;
        String fa = null;
        String fs = null;
        try {
            File facultyFile = new File("faculties.txt");
            Scanner reader = new Scanner(facultyFile);
            while (reader.hasNextLine()) {
                switch (n % 4) {
                    case 0:
                        fn = reader.nextLine();
                        break;
                    case 1:
                        fa = reader.nextLine();
                        break;
                    case 2:
                        fs = reader.nextLine();
                        break;
                    case 3:
                        Faculty faculty = new Faculty(fn, fa, StudyField.valueOf(fs));
                }
                n++;
            }
            Faculty faculty = new Faculty(fn, fa, StudyField.valueOf(fs));
            reader.close();
            //  return reader.next();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
