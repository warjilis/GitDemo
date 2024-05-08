//This program compares two strings to see if they are identical.
import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        userInput();  
    }

    public static void userInput() {
        Scanner scan = new Scanner(System.in);    
        String status = "yes"; 
        String firstString = "";
        String secondString = "";
        while (status.equals("yes")){    
            System.out.print("Enter the first string: ");
            firstString = scan.nextLine();
            System.out.print("Enter the second string: ");
            secondString = scan.nextLine();
            if(stringsMatch(firstString, secondString) == true){
                System.out.println("The strings match!");
            } else {
                System.out.println("The strings don't match");
            }
        }
        scan.close();
        }
   
    public static boolean stringsMatch(String firstString, String secondString){
        return firstString.equals(secondString); //Compare the two strings and return true or false.
    }
}
