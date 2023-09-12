package org.example;

import java.time.LocalDateTime;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

public class Lab {
    private int numberOfLab;
    private String themeOfLab;
    private LocalDateTime dueTime;
    private final int difficulty;
    private int mark = 0;

    public Lab(int numberOfLab, String themeOfLab, LocalDateTime dueTime, int difficulty) {
        this.numberOfLab = numberOfLab;
        this.themeOfLab = themeOfLab;
        this.dueTime = dueTime;
        this.difficulty = difficulty;
    }

    public int getNumberOfLab() {
        return numberOfLab;
    }

    public void setNumberOfLab(int number) {
        numberOfLab = number;
    }

    public String getThemeOfLab() {
        return themeOfLab;
    }

    public void setThemeOfLab(String themeOfLab) {
        this.themeOfLab = themeOfLab;
    }

    public LocalDateTime getDueTime() {
        return dueTime;
    }

    public void setDueTime(LocalDateTime dueTime) {
        this.dueTime = dueTime;
    }

    public int getDifficulty() {
        return difficulty;
    }
    public int getMark(){return mark;}
    public void setMark(int mark){this.mark = mark;}

    public long getRemainingMinutes(){ return MINUTES.between(dueTime, LocalTime.now());}
}
