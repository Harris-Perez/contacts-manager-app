package ContactApp;
import java.io.IOException;


public class App {
    
    public static void main(String[] args) throws Exception {
        try{
            userInterface();
          
    

        } catch (IOException ex){
            System.out.println("Cannot create the file.");
            ex.printStackTrace();
        }
        
     


    }
 

    public static void userInterface() throws IOException {
        System.out.println();
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");
        System.out.println();
        displayUserSelection();
    }

    public static void displayUserSelection() throws IOException {
        Input input = new Input();
        int option = input.getInt(1, 5, "Enter an option (1, 2, 3, 4 or 5):");
        switch(option) {
            case 1:
                Contact.printFileContents();
                break;
            case 2:
                Contact.addContact();
                break;
            case 3:
                Contact.searchContact();
                break;
            case 4:
                Contact.deleteContact();
                break;
            case 5:
                System.out.println();
                System.out.println("Goodbye");
                System.exit(0);
                break;
        }

        boolean confirm = input.yesNo("Would you like to select another option? [y/n]");
        if(confirm) {
            userInterface();
            displayUserSelection();
        }else{
            System.out.println("Goodbye");
            System.exit(0);
        }
    }
    
}
