package org.example.processes;

import org.example.Main;
import org.example.models.Faculty;
import org.example.models.StudyField;

import java.util.Scanner;

public class FacultyManager {

    public String input = "input";
    public Scanner scan = new Scanner(System.in);
    public void start(){
        mainMenu();
    }
    private void mainMenu(){
        System.out.println("Welcome to TUM's student managment system!\n" +
                "What do you want to do?\n" +
                "g - General operation \n" +
                "f - Faculty operations \n" +
                "s - Student operations");
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
            case "s":
                studentOperation();
                break;
            default:
                System.out.println("Unknown function, please try again");
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
        if (input.equals("b")) {
            mainMenu();
        }
        else if (input.equals("q")){
            return;
        }
        int slash = input.indexOf('/');
        {
            switch (input.substring(0, 2)){
                case "cr":
                    createFaculty(input.substring(3));
                case "ss":
                    searchStudent(input.substring(3));
                    break;
                case "df":
                    if (slash == -1)
                        displayFaculties();
                    else
                        displayFaculties(StudyField.valueOf(input.substring(3)));
                    break;
                default:
                    System.out.println("Unknown function, please try again");
                    generalOperations();
            }
        }
    }
    private void facultyOperation(){
        System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student\n" +
                "gs/<email> - graduate student\n" +
                "de/<faculty abbreviation> - display enrolled students\n" +
                "dg/<faculty abbreviation> - display graduated students\n" +
                "cb/<faculty abbreviation>/<email> - check if student belongs to faculty\n" +
                "b - Back ");
        quit();
        input = scan.nextLine();
        if (input.equals("b")) {
            mainMenu();
        }
        else if (input.equals("q")){
            return;
        }
        int slash = input.indexOf('/');
        {
            switch (input.substring(0, 2)){
                case "ns":
                    break;
                case "gs":
                    break;
                case"de":
                    break;
                case "dg":
                    break;
                case"cb":
                    break;
                default:
                    System.out.println("Unknown function, please try again");
                    facultyOperation();
            }
        }
    }
    private void studentOperation(){
        System.out.println("StudOper");
        doContinue();
    }
    private void createFaculty(String str){
        System.out.println(str);
        int slash = str.indexOf('/');
        String fn = str.substring(0, slash);
        str = str.substring(slash+1);
        slash = str.indexOf('/');
        String fa = str.substring(0, slash);
        System.out.println(fa);
        str = str.substring(slash+1);
        System.out.println(str);
        StudyField studyField = StudyField.valueOf(str);
        Faculty faculty = new Faculty(fn, fa, studyField);
        Faculty.facultiesList.add(faculty);
        doContinue();
    }
    private void searchStudent(String str){
        System.out.println(str);
        doContinue();
    }
    private void displayFaculties(StudyField studyField){
        for(Faculty fac: Faculty.facultiesList)
            if(fac.getStudyField().equals(studyField))
                System.out.println(fac.getName());
        doContinue();
    }
    private void displayFaculties(){
        //System.out.println("dispFac");
        for(Faculty fac: Faculty.facultiesList)
            System.out.println(fac.getName());
        doContinue();
    }

    private void quit(){
        System.out.println("\nq - Quit Program\n" +
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
                System.out.println("Unknown function, please try again");
                doContinue();
        }

    }

}