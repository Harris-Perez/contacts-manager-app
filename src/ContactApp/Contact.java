package ContactApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Contact {
    private String contactName;
    private int contactNumber;
    private static Path dataFilePath = Paths.get("data", "contacts.txt");

    public Contact(String name, int number){
        this.contactName = name;
        this.contactNumber = number;
    }
    public String getContactName(){
        return contactName;
    }

    public int getContactNumber(){
        return contactNumber;
    }

    public void setContactName(String name){
        this.contactName = name;
    }

    public void setContactNumber(int number){
        this.contactNumber = number;
    }



    public Path createDirectoryAndFile() throws IOException {
        if(Files.notExists(dataFilePath)){
            Files.createDirectories(dataFilePath);
        }
        if(!Files.exists(dataFilePath)){
            Files.createFile(dataFilePath);
        }
        return dataFilePath;
    }

    public static void printFileContents() throws IOException {
        List<String> fileContents = Files.readAllLines(dataFilePath);
        System.out.println();
        System.out.printf("%-20s | %-20s%n", "Name", "Phone Number");
        System.out.println("-------------------------------------------");
        for(int i = 0; i < fileContents.size(); i++){
            System.out.printf("%s%n", fileContents.get(i));
        }
    }


    public static void addContact() throws IOException{
        Input entry = new Input();
        System.out.println("Enter your new contacts name: ");
        String name = entry.getString();
        System.out.println();
        System.out.println("Enter new contact's phone number:");
        String number = entry.getString();
        Files.write(dataFilePath, Arrays.asList(String.format("%-20s | %-20s", name, number)), StandardOpenOption.APPEND);
        System.out.print("Contact Added");
    }

    //Needs modified
    public void updateContact(Path filePath, String oldValue, String newValue) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents){
            if (item.equals(oldValue)){
                modifiedList.add(newValue);

            } else {
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }

    //Needs modified
    public void deleteContact() throws IOException {
        Input entry = new Input();
        System.out.println("Which entry would you like to delete?");
        entry.getString();
        List<String> fileContents = Files.readAllLines(dataFilePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents){
            if(!item.equals(entry)){
                modifiedList.add(item);
            }
        }
        Files.write(dataFilePath, modifiedList);

    }

    public static void searchContact() throws IOException{
        Input entry = new Input();
        System.out.println("Search for contact:");
        String search = entry.getString();
        List<String> fileContents = Files.readAllLines(dataFilePath);
        // List<String> modifiedList = new ArrayList<>();
        System.out.println();
        for(String contact: fileContents) {
            if(contact.contains(search)) {
                System.out.println(contact);
            }else {
                System.out.println("No match found");
            }
        }

    }


  
}
