package org.example;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private String abbreviation;
    private List<Student> enrolledStudents;
    private StudyField studyField;

    public Faculty(String name, String abbreviation, StudyField studyField){
        this.name = name;
        this.abbreviation = abbreviation;
        enrolledStudents = new ArrayList<Student>();
        this.studyField = studyField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
    public void enrollStudent(Student student){
        enrolledStudents.add(student);
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public void setStudyField(StudyField studyField) {
        this.studyField = studyField;
    }
    public void displayCurrentEnrolledStudents(){
        for (Student stud: enrolledStudents
        )
            System.out.println(stud.getFirstName() + " " + stud.getLastName());

    }
}
