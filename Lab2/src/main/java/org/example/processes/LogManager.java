package org.example.processes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class LogManager {
    public void log(String interactionMessage) {
        String logMessage = generateUniqueIdentifier() + " " + LocalDateTime.now().toString() + " " + interactionMessage + "\n";
        writeLog(logMessage);
    }
    private String generateUniqueIdentifier() {
        return System.getProperty("user.name") + "/" + System.getProperty("os.name");
    }
    private void writeLog(String msg){
        try (FileWriter fileWriter = new FileWriter("log.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(msg);
            bufferedWriter.newLine();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
