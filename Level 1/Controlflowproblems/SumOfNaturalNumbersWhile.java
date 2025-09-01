import java.util.Scanner;
public class SumOfNaturalNumbersWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (n >= 0) {
            int sumFormula = n * (n + 1) / 2;
            int sumWhile = 0, i = 1;
            while (i <= n) {
                sumWhile += i;
                i++;
            }
            System.out.println("Formula result = " + sumFormula);
            System.out.println("While loop result = " + sumWhile);
        } else {
            System.out.println("Not a natural number");
        }
    }
}