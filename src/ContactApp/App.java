package ContactApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        Input input = new Input();
        String directoryName = "data";
        String fileName = "contacts.txt";
        Path dataFilePath = Contact.createDirectoryAndFile(directoryName, fileName);
        userInterface();
        int userChoice = Input.getInt(1,5, "Enter an option (1, 2, 3, 4 or 5):");
        switch (userChoice){

        }

        try{


        } catch (IOException ex){

        };


    }

    public static void userInterface(){
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");
    }

    public static void displayUserSelection(int option) {
        switch(option) {
            case 1:
                Contact.printFileContents(dataFilePath);
                break;
            case 2:
                Contact.addContact();
                break;
            case 3:
                Contact.searchContact(userInput);
                break;
            case 4:
                Contact.deleteContact(dataFilePath, userInput);
                break;
            case 5:
                System.out.println("Goodbye");
                System.exit(0);
                break;
        }
    }
}
