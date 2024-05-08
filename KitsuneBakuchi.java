import java.util.Arrays;
import java.util.Scanner;
public class KitsuneBakuchi {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String yesOrNo = "";
        Intro();
        System.out.println("Press Enter to continue");
        scan.nextLine();
        
        do{
        int diceValues[] = {rollDice(), rollDice(), rollDice()};
        System.out.print("You rolled:");
            for(int i = 0; i < diceValues.length; i++){
                System.out.print("\n" + printDie(diceValues[i])
                      .replace("[","")          
                      .replace("]","") 
                      .replace(",",""));
            }
            System.out.println("\n");

            if(diceValues[0] == diceValues[1] && diceValues[0] == diceValues[2]){
                System.out.println("\nThree of a kind. You win!!");
            } else {
                System.out.println("\nYou lose!");
            }

            yesOrNo = rollAgain();
            if (yesOrNo.equalsIgnoreCase("No") || yesOrNo.equalsIgnoreCase("n")){
                System.out.println("Goodbye. Have a nice day!");
               }

        }while(yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("y"));
        scan.close();
    }
    
    public static void Intro() {
        String[] kitsuneCharacters = {""};
        System.out.println(Arrays.toString(kitsuneCharacters)
                          .replace("["," ")
                          .replace("]"," ")
                          .replace(","," "));
        clearScreen();                 
        System.out.println("Welcome to Kitsune Bakuchi (Fox Gambling).\n"
                         + "The object of the game is to roll three dice with the same number.\n"    
                         + "If you win, you will receive four times your bet.");
    }      
    
/** This function generates and returns a random number between 1 and 6
* Function name - rollDice
*
* @return int
*
*/
public static int rollDice() {
    double randomNumber = Math.random() * 6;
    randomNumber++;
    return (int)randomNumber;
 }
    
 /** This function prints a die along with its corresponding number
 * It receives the value returned by rollDice()
 * Function Name - printDie()
 * @param die
 * @return String
 */
    public static String printDie(int die) {
        switch(die){
            case 1: return " _____\n"+
                           "|     |\n"+
                           "|  O  | 1\n"+
                           "|_____|";                
            case 2: return " _____\n"+
                           "|O    |\n"+
                           "|     | 2\n"+
                           "|____O|";
            case 3: return " _____\n"+
                           "|O    |\n"+
                           "|  O  | 3\n"+
                           "|____O|";
            case 4: return " _____\n"+
                           "|O   O|\n"+
                           "|     | 4\n"+
                           "|O___O|";
            case 5: return " _____\n"+
                           "|O   O|\n"+
                           "|  O  | 5\n"+
                           "|O___O|";
            case 6: return " _____\n"+
                           "|O   O|\n"+
                           "|O   O| 6\n"+
                           "|O___O|";
            default: return "impossible";
        }
    }
    /**Function Name - RollAgain()
    * This function asks the player if they want to play again after betting
    * 
    * @return String
    */
    public static String rollAgain() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to roll again? (Y)es or (N)o ");
            String yesOrNo = scan.nextLine();
            while(!yesOrNo.equalsIgnoreCase("No") && !yesOrNo.equalsIgnoreCase("N") 
             && !yesOrNo.equalsIgnoreCase("Yes") && !yesOrNo.equalsIgnoreCase("Y")){
               System.out.print("Please type (Y)es or (N)o");
            yesOrNo = scan.nextLine();           
        }
    
    clearScreen();
    return yesOrNo; 
}
    /**Function Name - clearScreen()
    * This function clears the screen
    */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }
    
}

