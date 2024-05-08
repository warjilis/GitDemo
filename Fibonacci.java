import java.util.Scanner;
public class Fibonacci{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the length of the Fibonacci sequence: ");
        long length = scan.nextInt();
        for (int i = 0; i < length; i++){
            System.out.println((i + 1) + ". " + fib(i) + " ");
        }
        scan.close();
    }
    public static long fib(int n){
        if (n <= 1){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    
}