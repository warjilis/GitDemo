import java.util.Scanner;

public class MultiplyBinaryNumbers {
    public static void main(String[] args) {
        long binary1, binary2;
        int i = 0, remainder = 0;
        int[] product = new int[20];
        Scanner scan = new Scanner(System.in);
      
        System.out.print("Input first binary number: ");
        binary1 = scan.nextLong();
        System.out.print("Input second binary number: ");
        binary2 = scan.nextLong();
      
        while (binary1 != 0 || binary2 != 0) {
            product[i++] = (int)((binary1 % 10 * binary2 % 10 * remainder) % 2);
            remainder = (int)((binary1 % 10 * binary2 % 10 * remainder) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
            }
        
            if (remainder != 0) {
                 product[i++] = remainder;
            }
            --i;
        
            System.out.print("Product of two binary numbers: ");
            while (i >= 0) {
                System.out.print(product[i--]);
            }
            System.out.print("\n");
    }    
}
