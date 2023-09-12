package org.example;
// Airplane.java
import java.time.LocalDateTime;
import java.time.LocalTime;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Lab lab1 = new Lab(1, "Classes",
                LocalDateTime.of(2023, 9, 12, 12, 0), 1);
        Lab lab2 = new Lab(1, "Classes",
                LocalDateTime.of(2023, 9, 19, 12, 0), 3);
        Lab lab3 = new Lab(1, "Classes",
                LocalDateTime.of(2023, 9, 26, 12, 0), 5);
        System.out.println("Finish your lab in" + lab2.getRemainingMinutes() + " minutes");
        lab1.setMark(10);
        System.out.println("You got" + lab1.getMark());

    }

}