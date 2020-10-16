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



    public static Path createDirectoryAndFile(String directoryName, String fileName) throws IOException {
        Path directoryPath = Paths.get(directoryName);
        Path dataFilePath = Paths.get(directoryName, fileName);

        if(Files.notExists(directoryPath)){
            Files.createDirectories(directoryPath);
        }
        if(!Files.exists(dataFilePath)){
            Files.createFile(dataFilePath);
        }
        return dataFilePath;
    }

    public static void printFileContents(Path filePath) throws IOException {
        System.out.println();
        List<String> fileContents = Files.readAllLines(filePath);
        for(int i = 0; i < fileContents.size(); i++){
            System.out.printf("%s%n", fileContents.get(i));
        }
    }


    public static void addContact(){
        Input entry = new Input();
        System.out.println("enterYour new contacts name: ");
        String name = entry.getString();
        Files.write(dataFilePath, Arrays.asList(), StandardOpenOption.APPEND);
    }

    //Needs modified
    public static void updateContact(Path filePath, String oldValue, String newValue) throws IOException {
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
    public static void deleteContact(Path filePath, String deletedValue) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents){
            if(!item.equals(deletedValue)){
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);

    }

    public static void searchContact(){
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();

        for(String )

    }


  
}
