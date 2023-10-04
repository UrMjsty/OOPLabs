package org.example.models;
import org.example.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student {
    public static List<Student> studentsList = new ArrayList<Student>();
    public static int numberOfAttributes = 12;
    private String firstName;
    private String lastName;
    private String email;
    private Faculty faculty;
    private StudyField studyField;
    private String group;
    private int groupNumber;
    private int yearOfEducation;
    List<Integer> marks;
    private boolean isOnBudget;
    private boolean isOnGrant;
    private boolean hasFailures;
    private boolean isGraduated;
    private LocalDate dateOfBirth;
    private LocalDate enrollmentDate;

    public Student(String firstName, String lastName,String email,String abbreviation, int groupNumber, boolean isOnBudget, LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty = Faculty.getFacultyByAbbreviation(abbreviation);
        faculty.enrollStudent(this);
        this.studyField = faculty.getStudyField();
        this.groupNumber = groupNumber;
        this.yearOfEducation = LocalDate.now().getYear() -groupNumber/10;
        this.group = studyField.toString() + "-" + groupNumber;
        this.marks = new ArrayList<Integer>();
        this.isOnBudget = isOnBudget;
        this.isOnGrant = isOnBudget;
        this.hasFailures = false;
        this.isGraduated = false;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = LocalDate.now();
        studentsList.add(this);
    };
    public Student(String firstName, String lastName, String email, String facultyName, String group, int yearOfEducation, boolean isOnBudget, boolean isOnGrant, boolean hasFailures, boolean isGraduated, LocalDate dateOfBirth, LocalDate enrollmentDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty = Faculty.getFacultyByName(facultyName);
        this.studyField = faculty.getStudyField();
        this.group = group;
        this.yearOfEducation = yearOfEducation;
        this.marks = new ArrayList<Integer>();
        this.isOnBudget = isOnBudget;
        this.isOnGrant = isOnGrant;
        this.hasFailures = hasFailures;
        this.isGraduated = isGraduated;
        if (isGraduated) faculty.enrollStudent(this);
        else
            faculty.enrollGraduate(this);
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
        studentsList.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public void setStudyField(StudyField studyField) {
        this.studyField = studyField;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public boolean hasFailures() {
        return hasFailures;
    }

    public void setHasFailures(boolean hasFailures) {
        this.hasFailures = hasFailures;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    public void setGraduated(boolean graduated) {
        isGraduated = graduated;
        if(isGraduated)
            this.faculty.graduate(this);
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
    public static Student getStudentByEmail(String email){
        for(Student stud: studentsList)
            if (stud.getEmail().equals(email))
                return stud;
        return null;
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
        else {
            if (hasFailures){
                System.out.println(firstName + " " + lastName + "has failures and can't pass the exam");
                return;
            }
            if(!isPassed)
                return;
            else {
                this.yearOfEducation++;
                if (this.yearOfEducation > faculty.getStudyField().yearsOfStudying())
                    graduate();
            }
        }
    }
    private void graduate(){
        isGraduated = true;
        faculty.graduate(this);
    }
    @Override
    public String toString(){
        return firstName + "\n" + lastName + "\n" + email + "\n" + faculty.getName() + "\n" + group + "\n" + yearOfEducation + "\n" + isOnBudget
                + "\n" + isOnGrant  + "\n" + hasFailures + "\n" + isGraduated + "\n" + dateOfBirth + "\n" +enrollmentDate +"\n";
    }
}
