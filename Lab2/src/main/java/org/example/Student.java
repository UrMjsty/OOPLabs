package org.example;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Faculty faculty;
    private StudyField studyField;
    private String group;
    private int yearOfEducation;
    List<Integer> marks;
    private boolean isOnBudget;
    private boolean isOnGrant;
    private boolean hasFailures;
    private LocalDate dateOfBirth;
    private LocalDate enrollmentDate;

    public Student(String firstName, String lastName,String email,Faculty faculty ,StudyField studyField, String group, boolean isOnBudget, LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty = faculty;
        this.studyField = studyField;
        this.group = group;
        this.yearOfEducation = 1;
        this.marks = new ArrayList<>();
        this.isOnBudget = isOnBudget;
        this.isOnGrant = isOnBudget;
        this.hasFailures = false;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = LocalDate.now();

    };

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
