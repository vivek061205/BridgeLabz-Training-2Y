import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        int phy = sc.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chem = sc.nextInt();
        System.out.print("Enter Maths marks: ");
        int math = sc.nextInt();
        double avg = (phy + chem + math) / 3.0;
        System.out.println("Average = " + avg);
        char grade;
        if (avg >= 80) grade = 'A';
        else if (avg >= 70) grade = 'B';
        else if (avg >= 60) grade = 'C';
        else if (avg >= 50) grade = 'D';
        else if (avg >= 40) grade = 'E';
        else grade = 'R';
        System.out.println("Grade = " + grade);
    }
}
