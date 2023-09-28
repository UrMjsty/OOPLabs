package org.example;

public enum StudyField {
    MECHANICAL_ENGINEERING(4),
    SOFTWARE_ENGINEERING(4),
    FOOD_TECHNOLOGY(4),
    URBANISM_ARCHITECTURE(4),
    VETERINARY_MEDICINE(4);
    private final int yearsOfStudying;
    StudyField(int yearsOfStudying){
        this.yearsOfStudying  = yearsOfStudying;
    }
    public int yearsOfStudying(){return yearsOfStudying;}
}
