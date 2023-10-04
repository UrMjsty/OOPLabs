package org.example.models;

import java.util.ArrayList;
import java.util.List;

public enum StudyField {
    MECHANICAL_ENGINEERING(4),
    SOFTWARE_ENGINEERING(4),
    FOOD_TECHNOLOGY(4),
    URBANISM_ARCHITECTURE(4),
    VETERINARY_MEDICINE(4);
    private final int yearsOfStudying;
    private List<Faculty> faculties;
    StudyField(int yearsOfStudying){

        this.yearsOfStudying  = yearsOfStudying;
        this.faculties = new ArrayList<Faculty>();
    }
    public int yearsOfStudying(){return yearsOfStudying;}

    public List<Faculty> getFaculties() {
        return faculties;
    }
    public void addFaciulty(Faculty faculty){
        faculties.add(faculty);
    }
}
