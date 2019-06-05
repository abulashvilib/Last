package sangu.project.proccessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

public class StorageManager {

    static final String CURRENT_FILE = "C:\\Users\\sxsdxsdx\\Desktop\\UniProject\\src\\sangu\\project\\storage\\storage";
    private static final String LATEST_BAK_FILE = "C:\\Users\\sxsdxsdx\\Desktop\\UniProject\\src\\sangu\\project\\storage\\storage.bak";

    void clearMainFile() {
        try {
            PrintWriter writer = new PrintWriter(new File(CURRENT_FILE));
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Halt reason: " + e.getMessage());
        }
    }

    void restoreFile() {
        File currentFile = new File(CURRENT_FILE);
        File backupFile = new File(LATEST_BAK_FILE);
        if (!backupFile.exists()) {
            System.out.println("Critical situation: Even backup is deleted :(");
        } else {
            try {
                Files.copy(backupFile.toPath(), currentFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Halt reason: " + e.getMessage());
            }
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    void backupFile() {
        File currentFile = new File(CURRENT_FILE);
        File backupFile = new File(LATEST_BAK_FILE);
        try {
            if (!backupFile.exists()) {
                backupFile.createNewFile();
            }
            Files.copy(currentFile.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Halt reason: " + e.getMessage());
        }
    }

}
