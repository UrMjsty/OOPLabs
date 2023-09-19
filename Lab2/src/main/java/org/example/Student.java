package org.example;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Student {
    private String name;
    private String surname;
    private String faculty;
    private String speciality;
    private String group;
    private int yearOfEducation;
    private int id;
    public static int lastId = 1;
    List<Integer> marks;
    private boolean isOnBudget;
    private boolean isOnGrant;
    private boolean hasFailures;
    private LocalDateTime dateOfBirth;

    public Student(String name, String surname, String speciality, String group, boolean isOnBudget, LocalDateTime dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.faculty = "FCIM";
        this.speciality = speciality;
        this.group = group;
        this.yearOfEducation = 1;
        this.id = Student.lastId++;
        this.marks = new ArrayList<>(10);
        this.isOnBudget = isOnBudget;
        this.isOnGrant = isOnBudget;
        this.hasFailures = false;
        this.dateOfBirth = dateOfBirth;

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getYearOfEducation() {
        return yearOfEducation;
    }

    public void setYearOfEducation(int yearOfEducation) {
        this.yearOfEducation = yearOfEducation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOnBudget() {
        return isOnBudget;
    }

    public void setOnBudget(boolean onBudget) {
        isOnBudget = onBudget;
    }

    public boolean isOnGrant() {
        return isOnGrant;
    }

    public void setOnGrant(boolean onGrant) {
        isOnGrant = onGrant;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public boolean isHasFailures() {
        return hasFailures;
    }

    public void setHasFailures(boolean hasFailures) {
        this.hasFailures = hasFailures;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
    public void passExam(String season, boolean isPassed){
        if (season.equals("Winter")){
            if (isPassed) {
                setOnGrant(true);
            }
            else {
                setOnGrant(false);
                setHasFailures(true);
            }
        }
    }
}