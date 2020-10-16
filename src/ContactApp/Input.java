package ContactApp;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input (){
        scanner = new Scanner(System.in);
    }

    public static String getString(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static boolean yesNo(String prompt){
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input.trim().equalsIgnoreCase("y") || input.trim().equalsIgnoreCase("yes");
    }

    public static int getInt(int min, int max, String prompt){
        System.out.println(prompt);
        String userInput;
        int input;
        try {
            userInput = scanner.nextLine();
            input = Integer.valueOf(userInput);
            if (input > max || input < min) {
                System.out.println("That is not a valid entry. \n");
                prompt = "Please enter 1, 2, 3, 4, or 5";
                input = getInt(min, max, prompt);
            } else return input;
        } catch (Exception e) {
            System.err.println("That is not a valid entry. \n");
            prompt = "Please enter 1, 2, 3, 4, or 5";
            input = getInt(min, max, prompt);
        }
        return input;
    }
}
