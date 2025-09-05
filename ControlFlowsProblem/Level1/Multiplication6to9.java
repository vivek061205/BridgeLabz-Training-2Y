import java.util.Scanner;

public class Multiplication6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int[] results = new int[4];
        for (int i = 6; i <= 9; i++) {
            results[i - 6] = num * i;
        }
        for (int i = 6; i <= 9; i++) {
            System.out.println(num + " * " + i + " = " + results[i - 6]);
        }
        sc.close();
    }
}