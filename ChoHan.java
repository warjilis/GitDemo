import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class ChoHan {
        public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Intro();
        System.out.print("Press Enter to continue: ");
        scan.nextLine();
        String betEvenOrOdd = "";
        String yesOrNo = "";
        
        do{
            System.out.print("Please bet on Even or Odd (Type 'even' or 'odd') ");
            betEvenOrOdd = scan.nextLine();
            while(!betEvenOrOdd.equalsIgnoreCase("even") && !betEvenOrOdd.equalsIgnoreCase("odd")){
                System.out.print("Please enter 'even' or 'odd' ");
                betEvenOrOdd = scan.nextLine();
            }
            System.out.println("You chose " + betEvenOrOdd.toUpperCase());
            
            int die1 = rollDice(); 
            int die2 = rollDice();
            System.out.println("\nDealer rolled a " + die1);
            System.out.println(printDie(die1)); 
            System.out.println("\nAnd a " + die2);
            System.out.println(printDie(die2));
            
            String printEvenOrOdd = sumOfDiceParity(die1, die2);
            System.out.println("The sum of the dice is: " + (die1 + die2));
            checkWin(printEvenOrOdd, betEvenOrOdd);

            yesOrNo = betAgain();
            if (yesOrNo.equalsIgnoreCase("No") || yesOrNo.equalsIgnoreCase("n")){
                System.out.println("Goodbye. Have a nice day!");
               }

        }while(yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("y"));
    scan.close();
}

 /** This function introduces the game, and explains the rules
 */
public static void Intro(){
    clearScreen();
    String[] choHan = {"  ---------      \\ | /  \n",
                       "     |            |    \n",
                       "     |        ---------\n",
                       "     |            |    \n",
                       "     |       -----------\n",
                       "  ___|            |     \n"};
    System.out.println(Arrays.toString(choHan)
              .replace("[", "")
              .replace("]", "")
              .replace(",", ""));
    System.out.println("Welcome to Cho Han (Even-Odd)\n");
    System.out.println("The object of the game is to bet on whether");
    System.out.println("the sum of the two rolled dice will be even or odd.");
    System.out.println("If you bet successfully. You win");
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

/** This function reads the two results of rollDice()
 *  and determines whether the sum of the two dice
 *  are even or odd.
 *  Function name - sumOfDiceParity
 *
 @param int,int
 @return String
 *
 */

public static String sumOfDiceParity (int die1, int die2) {
    int sum = die1 + die2;
    if(sum % 2 == 0){
        return "Even";
    } else if (sum % 2 == 1) {
        return "Odd";
    } else {
        return "impossible";
    }
}

/** This function will check if the player won or lost.
 *  It checks their bet against the sum of the die
 *  being an even or odd number.
 *  Function Name - checkWin()
 *
 * @param evenOrOdd
 * @param selection
 */

public static void checkWin(String evenOrOdd, String selection) {
    if(selection.equalsIgnoreCase("even") && evenOrOdd.equals("Even")){
        System.out.println("Result: " + evenOrOdd + ", "  + "You win!");
    } else if (selection.equalsIgnoreCase("even") && evenOrOdd.equals("Odd")){
        System.out.println("Result: " + evenOrOdd + ", " + "You lose!");
    } else if(selection.equalsIgnoreCase("odd") && evenOrOdd.equals("Odd")){
        System.out.println("Result: " + evenOrOdd + ", " + "You win!");
    } else if (selection.equalsIgnoreCase("odd") && evenOrOdd.equals("Even")){
        System.out.println("Result: " + evenOrOdd + ", " + "You lose!");
    }
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
                       "|  O  |\n"+
                       "|_____|";                
        case 2: return " _____\n"+
                       "|O    |\n"+
                       "|     |\n"+
                       "|____O|";
        case 3: return " _____\n"+
                       "|O    |\n"+
                       "|  O  |\n"+
                       "|____O|";
        case 4: return " _____\n"+
                       "|O   O|\n"+
                       "|     |\n"+
                       "|O___O|";
        case 5: return " _____\n"+
                       "|O   O|\n"+
                       "|  O  |\n"+
                       "|O___O|";
        case 6: return " _____\n"+
                       "|O   O|\n"+
                       "|O   O|\n"+
                       "|O___O|";
        default: return "impossible";
    }
}
/**Function Name - betAgain()
 * This function asks the player if they want to play again after betting
 * 
 * @return String
 */
public static String betAgain() {
    Scanner scan = new Scanner(System.in);
    System.out.print("Do you want to bet again? (Y)es or (N)o ");
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