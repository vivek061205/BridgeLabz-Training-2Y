import java.util.Scanner;

public class SumofNnaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n >= 1) {
            // Formula
            int formulaSum = n * (n + 1) / 2;

            // While loop
            int i = 1, whileSum = 0;
            while (i <= n) {
                whileSum += i;
                i++;
            }

            System.out.println("Sum using formula = " + formulaSum);
            System.out.println("Sum using while loop = " + whileSum);
        } else {
            System.out.println("Not a natural number.");
        }
    }
}