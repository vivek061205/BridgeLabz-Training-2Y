import java.util.Scanner;

public class CompareStrings {
    public static boolean compareByCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.next();
        System.out.print("Enter second string: ");
        String s2 = sc.next();

        boolean charAtResult = compareByCharAt(s1, s2);
        boolean equalsResult = s1.equals(s2);

        System.out.println("Compare using charAt: " + charAtResult);
        System.out.println("Compare using equals: " + equalsResult);
    }
}
