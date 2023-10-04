package org.example.processes;

//import org.example.Main;
import org.example.models.Faculty;
import org.example.models.Student;
import org.example.models.StudyField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.Collections;
import java.util.Scanner;

public class FacultyManager {
    LogManager logManager = new LogManager();
    public String input = "input";
    public Scanner scan = new Scanner(System.in);
    public void start(){
        mainMenu();
    }
    private void mainMenu(){
        System.out.println("Welcome to TUM's student management system!\n" +
                "What do you want to do?\n" +
                "g - General operation \n" +
                "f - Faculty operations");
        quit();
        input = scan.nextLine();
        switch (input){
            case "q":
                break;
            case "g":
                generalOperations();
                break;
            case "f":
                facultyOperation();
                break;
            default:
                System.out.println("Unknown function <" + input + "> please try again");
                mainMenu();
        }
    }
    private void generalOperations(){
        System.out.println("General Operations\n" +
                "What do you want to do?\n" +
                "cr/<faculty name>/<faculty abbreviation>/<field> - create faculty\n" +
                "ss/<student email> - search and show faculty\n" +
                "df - display faculties\n" +
                "df/<field> - display all faculties of a field\n" +
                "b - Back");
        quit();
        input = scan.nextLine();
        while(input.length() < 2) {
            if (input.equals("q"))
                return;
            else if(input.equals("b"))
                mainMenu();
            else{
                System.out.println("Unknown function <" + input + "> please try again");
                input = scan.nextLine();
            }
        }

        int slash = input.indexOf('/');
        {
            switch (input.substring(0, 2)){
                case "cr":
                    if(input.length() == 2) {
                        System.out.println("This function requires extra data");
                        generalOperations();
                    }
                    createFaculty(input.substring(3));
                    break;
                case "ss":
                    if(input.length() == 2) {
                        System.out.println("This function requires extra data");
                        generalOperations();
                    }
                    searchStudent(input.substring(3));
                    break;
                case "df":
                    if (slash == -1)
                        displayFaculties();
                    else
                        try {
                            StudyField studyField = StudyField.valueOf(input.substring(3));
                            displayFaculties(studyField);
                        }
                        catch (Exception e){
                            System.out.println("Such StudyField doesn't exist, available options are:\n"+
                                    java.util.Arrays.asList(StudyField.values()));
                        }
                    break;
                default:
                    System.out.println("Unknown function <" + input + "> please try again");
                    generalOperations();
            }
        }
    }
    private void facultyOperation(){
        System.out.println("ns/<faculty abbreviation>/<group number>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student\n" +
                "gs/<email> - graduate student\n" +
                "de/<faculty abbreviation> - display enrolled students\n" +
                "dg/<faculty abbreviation> - display graduated students\n" +
                "cb/<faculty abbreviation>/<email> - check if student belongs to faculty\n" +
                "b - Back ");
        quit();
        input = scan.nextLine();
        while(input.length() < 2) {
            if (input.equals("b")) {
                mainMenu();
            }
            else if (input.equals("q")){
                return;
            }
            else{
            System.out.println("Unknown function <" + input + "> please try again");
            input = scan.nextLine();
            }
        }

        //int slash = input.indexOf('/');
        {
            switch (input.substring(0, 2)){
                case "ns":
                    if(input.length() == 2) {
                        System.out.println("This function requires extra data");
                        facultyOperation();
                    }
                    createStudent(input.substring(3));
                    break;
                case "gs":
                    if(input.length() == 2) {
                        System.out.println("This function requires extra data");
                        facultyOperation();
                    }
                    graduateStudent(input.substring(3));
                    break;
                case"de":
                    if(input.length() == 2) {
                        System.out.println("This function requires extra data");
                        facultyOperation();
                    }
                    Faculty fac = Faculty.getFacultyByAbbreviation(input.substring(3));
                    if(fac == null) {
                        System.out.println("There is no such faculty");
                        facultyOperation();
                    }
                    else
                        fac.displayCurrentEnrolledStudents();
                    doContinue();
                    break;
                case "dg":
                    if(input.length() == 2) {
                    System.out.println("This function requires extra data");
                    facultyOperation();
                    }
                    Faculty fac1 = Faculty.getFacultyByAbbreviation(input.substring(3));
                    if(fac1 == null){
                        System.out.println("There is no such faculty <" + input.substring(3) + ">");
                        facultyOperation();
                    }
                    else
                        fac1.displayGraduates();
                    doContinue();
                    break;
                case"cb":
                    if(input.length() == 2) {
                        System.out.println("This function requires extra data");
                        facultyOperation();
                    }
                    checkBelonging(input.substring(3));
                    break;
                default:
                    System.out.println("Unknown function <" + input + "> please try again");
                    facultyOperation();
            }
        }
    }

    private void createFaculty(String str){
        int slash = str.indexOf('/');
        if(slash == -1)
        {
            System.out.println("Operation requires extra data");
            generalOperations();
        }
        String fn = str.substring(0, slash);
        str = str.substring(slash+1);
        slash = str.indexOf('/');
        if(slash == -1)
        {
            System.out.println("Operation requires extra data");
            generalOperations();
        }
        String fa = str.substring(0, slash);
        str = str.substring(slash+1);
        try {
            StudyField studyField = StudyField.valueOf(str);
            Faculty faculty = new Faculty(fn, fa, studyField);
            logManager.log("Faculty <" + faculty.getName() + "> was created");
        }
        catch (Exception e){

            System.out.println("Such StudyField doesn't exist, available options are:\n"+
                    java.util.Arrays.asList(StudyField.values()));
            generalOperations();
        }
        finally {
        doContinue();
        }
    }
    private void searchStudent(String str){
        Student student = Student.getStudentByEmail(str);
        if (student == null){
            System.out.println("There's no student <" + str + "> try again");
            generalOperations();
        }
        else
            System.out.println(student.getFaculty().getName());
        doContinue();
    }
    private void displayFaculties(StudyField studyField){
        boolean is = false;
        if(Faculty.facultiesList.isEmpty()){
            System.out.println("There are no existing faculties");
        }
        else {
            for(Faculty fac: Faculty.facultiesList)
                if(fac.getStudyField().equals(studyField)){
                    System.out.println(fac.getName());
                    is =true;
                }
        }
        if(!is)
            System.out.println("There are no faculties of this field");
        doContinue();
    }
    private void displayFaculties(){
        if(Faculty.facultiesList.isEmpty())
            System.out.println("There are no existing faculties");
        else
        {for(Faculty fac: Faculty.facultiesList)
                System.out.println(fac.getName());
        }
        doContinue();
    }

    private void quit(){
        System.out.print("\nq - Quit Program\n" +
                "your input> ");
    }
    private void doContinue(){
        System.out.println("Continue?\n" +
                "mm - Back to main menu");
        quit();
        input = scan.nextLine();
        switch (input){
            case "q":
                break;
            case "mm":
                mainMenu();
                break;
            default:
                System.out.println("Unknown function <" + input + "> please try again");
                doContinue();
        }

    }
    private void createStudent(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        int slash = str.indexOf('/');
        if(slash == -1)
        {
            System.out.println("Operation requires extra data");
            facultyOperation();
        }
        String fa = str.substring(0, slash);
        if (Faculty.getFacultyByAbbreviation(fa) == null) {
            System.out.println("There's no faculty with abbreviation <" + fa + "> try again");
            facultyOperation();
        }
        str = str.substring(slash+1);
        slash = str.indexOf('/');
        if(slash == -1)
        {
            System.out.println("Operation requires extra data");
            facultyOperation();
        }
        String group = str.substring(0, slash);
        try {
            int gr = Integer.parseInt(group);
        }
        catch (Exception e){
            System.out.println("Group number should be an integer number, try again");
            facultyOperation();
        }
        str = str.substring(slash+1);
        slash = str.indexOf('/');
        if(slash == -1)
        {
            System.out.println("Operation requires extra data");
            facultyOperation();
        }
        String fn = str.substring(0, slash);
        str = str.substring(slash+1);
        slash = str.indexOf('/');
        if(slash == -1)
        {
            System.out.println("Operation requires extra data");
            facultyOperation();
        }
        String ln = str.substring(0, slash);
        str = str.substring(slash+1);
        slash = str.indexOf('/');
        if(slash == -1)
        {
            System.out.println("Operation requires extra data");
            facultyOperation();
        }
        String email = str.substring(0, slash);
        str = str.substring(slash+1);
        String date = str;
        try {
            LocalDate d = LocalDate.parse(date, formatter);
        }
        catch (Exception e){

            System.out.println("Wrong date format, try again");
            facultyOperation();
        }
        new Student(fn, ln, email, fa, Integer.parseInt(group), true, LocalDate.parse(date,formatter));
        System.out.println("Continue?\n" +
                "ns/<faculty abbreviation>/<group number>/<first name>/<last name>/<email>/<day>/<month>/<year> - create another student\n" +
                "mm - Back to main menu");
        quit();
        input = scan.nextLine();
        if(input.substring(input.length() -1).equals("q"))
            return;
        switch (input.substring(0,2)){
            case "mm":
                mainMenu();
                break;
            case "ns":
                if(input.length() == 2) {
                    System.out.println("This function requires extra data");
                    facultyOperation();
                }
                createStudent(input.substring(3));
                break;
            default:
                System.out.println("Unknown function <" + input + "> please try again");
                doContinue();
        }
        /*
ns/CIM/223/John/Johnson/JJ@gmail.com/12/11/2003
ns/CIM/223/John/Johnson/JJ@gmail.com/12/11/2003
ns/CIM/223/John/Johnson/JJ@gmail.com/12/11/2003
ns/CIM/223/John/Johnson/JJ@gmail.com/12/11/2003
         */

    }
    private void graduateStudent(String email){
        Student student = Student.getStudentByEmail(email);
        if (student == null){
            System.out.println("There's no student <" + email + "> try again");
            facultyOperation();
        }
        else{
            System.out.println(student.getFirstName() + " " + student.getLastName() + "was successfully graduated\n");
            student.setGraduated(true);
        }
        System.out.println("Continue?\n" +
                "gs/<email> - graduate student\n" +
                "mm - Back to main menu");
        quit();
        input = scan.nextLine();
        if(input.substring(input.length() -1).equals("q"))
            return;
        switch (input.substring(0,2)){
            case "mm":
                mainMenu();
                break;
            case "gs":
                if(input.length() == 2) {
                    System.out.println("This function requires extra data");
                    facultyOperation();
                }
                graduateStudent(input.substring(3));
                break;
            default:
                System.out.println("Unknown function <" + input + "> please try again");
                doContinue();
        }
    }
    private void checkBelonging(String str){
        int slash = str.indexOf('/');
        if(slash == -1)
        {
            System.out.println("Operation requires extra data");
            facultyOperation();
        }
        String fa = str.substring(0, slash);
        String email = str.substring(slash+1);
        Student student = Student.getStudentByEmail(email);
        if (student == null){
            System.out.println("There's no student <" + email + "> try again");
            generalOperations();
        }
        Faculty faculty = Faculty.getFacultyByAbbreviation(fa);
        if (faculty == null) {
            System.out.println("There's no faculty <" + fa + "> try again");
            generalOperations();
        }
        else if (faculty.getCurrentEnrolledStudents().contains(student))
            System.out.println("Yes, this student belongs to");
        else
            System.out.println("No, student doesn't belong to ");
        doContinue();
    }

}
