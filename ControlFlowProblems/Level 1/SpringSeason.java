import java.util.Scanner;
public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = sc.nextInt();
        System.out.print("Enter day: ");
        int day = sc.nextInt();
        boolean isSpring = (month == 3 && day >= 20) || (month == 6 && day <= 20) ||
                           (month == 4) || (month == 5);
        if (isSpring) System.out.println("It's a Spring Season");
        else System.out.println("Not a Spring Season");
    }
}