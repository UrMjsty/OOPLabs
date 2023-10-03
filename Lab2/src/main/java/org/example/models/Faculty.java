package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    public static List<Faculty> facultiesList = new ArrayList<Faculty>();
    private String name;
    private String abbreviation;
    private List<Student> currentEnrolledStudents;
    private List<Student> graduatedStudents;
    private StudyField studyField;

    public Faculty(String name, String abbreviation, StudyField studyField){
        this.name = name;
        this.abbreviation = abbreviation;
        currentEnrolledStudents = new ArrayList<Student>();
        graduatedStudents = new ArrayList<Student>();
        this.studyField = studyField;
        studyField.addFaciulty(this);
        facultiesList.add(this);
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

    public List<Student> getCurrentEnrolledStudents() {
        return currentEnrolledStudents;
    }

    public void setCurrentEnrolledStudents(List<Student> currentEnrolledStudents) {
        this.currentEnrolledStudents = currentEnrolledStudents;
    }
    public void enrollStudent(Student student){
        currentEnrolledStudents.add(student);
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public void setStudyField(StudyField studyField) {
        this.studyField = studyField;
    }
    public void displayCurrentEnrolledStudents(){
        if (currentEnrolledStudents.isEmpty())
            System.out.println("There are no students on " + name + " faculty.");
        else{
            System.out.println("On this faculty are enrolled:");
            for (Student stud: currentEnrolledStudents
            )
                System.out.println(stud.getFirstName() + " " + stud.getLastName());
        }
    }
    public void displayGraduates(){
        if (graduatedStudents.isEmpty())
            System.out.println("There are no graduated students on " + name + "faculty.");
        else
            System.out.println("On this faculty are graduated:");
        for (Student stud : graduatedStudents
        )
            System.out.println(stud.getFirstName() + " " + stud.getLastName());

    }
    public void doExam(String season){
        if (currentEnrolledStudents.isEmpty()){
            System.out.println("There are no students on " + name + " faculty.");
            return;
        }
        if(season.equals("Winter") || season.equals("Summer")){
            for (Student stud: currentEnrolledStudents
            )
                stud.passExam(season, true);
        }
        else
            System.out.println("Wrong season, available options are Winter or Summer");
    }
    public void graduate(Student student){
        System.out.println(student.getFirstName() + "is graduated");
        currentEnrolledStudents.remove(student);
        graduatedStudents.add(student);
    }
    @Override
    public String toString(){
        return this.name + " " + this.abbreviation;
    }
    public static Faculty getFacultyByName(String name){
        for(Faculty fac: facultiesList)
            if (fac.name.equals(name))
                return fac;
        return null;
    }

    public static Faculty getFacultyByAbbreviation(String abbreviation){
        for(Faculty fac: facultiesList)
            if (fac.abbreviation.equals(abbreviation))
                return fac;
        return null;
    }

}
