package ContactApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main(String[] args) throws Exception {
        Input input = new Input();
        String directoryName = "data";
        String fileName = "contacts.txt";
        
        
        try{
            Path dataFilePath = Contact.createDirectoryAndFile(directoryName, fileName);
            List<String> contacts = Arrays.asList("Jack Blank : 2105678923", "Jane Doe : 7898902", "Sam Space : 2105818123");
            Files.write(dataFilePath, contacts);
            userInterface();
            int userChoice = Input.getInt(1, 5, "Enter an option (1, 2, 3, 4 or 5):");
          
    

        } catch (IOException ex){
            System.out.println("Cannot create the file.");
            ex.printStackTrace();
        }
        
     


    }
 

    public static void userInterface(){
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");
    }

    public static void displayUserSelection() {
        Input input = new Input();
        int option = input.getInt(min, max, prompt);
        switch(option) {
            case 1:
                Contact.printFileContents();
                break;
            case 2:
           
               
                break;
            case 3:
                Contact.searchContact();
                break;
            case 4:
                Contact.deleteContact();
                break;
            case 5:
                System.out.println("Goodbye");
                System.exit(0);
                break;
        }

        boolean confirm = Input.yesNo("Would you like to select another option? [y/n]");
        if(confirm) {
            userInterface();
            int userChoice = Input.getInt(1,5, "Enter an option (1, 2, 3, 4 or 5):");
            displayUserSelection(userChoice);
        }else{
            System.out.println("Goodbye");
            System.exit(0);
        }
    }
 
}
