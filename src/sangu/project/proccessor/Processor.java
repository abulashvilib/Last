package sangu.project.proccessor;

import sangu.project.models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processor implements Medium {

    private StorageManager storageManager;

    public Processor() {
        storageManager = new StorageManager();
    }

    @Override
    public void writeUser(User user) {
        List<User> storageUsers = getUsers();
        storageUsers.remove(user);
        storageUsers.add(user);
        storageManager.clearMainFile();
        try {
            PrintWriter writer = new PrintWriter(new File(StorageManager.CURRENT_FILE));
            for(User storageUser : storageUsers) {
                writer.println(storageUser.toString());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Halt reason: " + e.getMessage());
        }
        storageManager.backupFile();
    }

    @Override
    public User getUser(String userId) {
        List<User> storageUsers = getUsers();
        User user = null;
        for(User storageUser : storageUsers) {
            if (storageUser.getUserId().equals(userId)) {
                user = storageUser;
                break;
            }
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> storageUsers = new ArrayList<>();
        File file = new File(StorageManager.CURRENT_FILE);
        if (!file.exists()) {
            storageManager.restoreFile();
        }
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] dataPiece = scanner.nextLine().split(" - ");
                storageUsers.add(new User(dataPiece[0], dataPiece[1], Float.parseFloat(dataPiece[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Halt reason: " + e.getMessage());
        }
        return storageUsers;
    }

}
