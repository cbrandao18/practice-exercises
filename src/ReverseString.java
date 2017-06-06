import java.util.Scanner;

/**
 * Create a method to reverse a string manually (Question from AppAcademy)
 * This program will also show how to reverse a string using the given reverse method
 *
 * Created by Christie on 6/6/2017.
 */
public class ReverseString {

    private static String reverseString(String str){
        String reverse = "";
        for (int i = str.length()-1; i >= 0; i--){
            char c = str.charAt(i);
            reverse = reverse + c;
        }
        return reverse;
    }
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Using manual reverse method ------------------");
        System.out.println("Enter a string you would like to be reversed: ");
        String str = in.nextLine();
        in.close();
        System.out.println("Original string: " + str);
        String strReversed = reverseString(str);
        System.out.println("Reversed string: " + strReversed);
        System.out.println();
        System.out.println("Using given reverse method -------------------");
        System.out.println("Original string: " + str);
        String strReversed2 = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed string: " + strReversed2);
    }
}
