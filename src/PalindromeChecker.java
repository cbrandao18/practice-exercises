import java.util.Scanner;

/**
 * This program checks if a word entered by a user is a palindrome - it reads the same forwards and backwards.
 *
 * Created by Christie on 6/6/2017.
 */
public class PalindromeChecker {

    private static boolean palindromeChecker(String str){
        boolean palindrome = true;

        /*
         * Check if an even or odd length
         */
        if (str.length() % 2 == 0) { //even
            /*
             * Split string into front half and second half. Reverse the second half.
             * If the reversed second half and first half is the same, then it is a palindrome.
             */
            String firstHalf = str.substring(0, str.length() / 2);
            String secondHalf = str.substring(str.length() / 2, str.length());
            String secondHalfReversed = new StringBuilder(secondHalf).reverse().toString();
            if (!firstHalf.equals(secondHalfReversed)){
                palindrome = false;
            }
        } else { //odd
            String firstHalf = str.substring(0, str.length()/2);
            String secondHalf = str.substring((str.length() / 2) + 1, str.length());
            String secondHalfReversed = new StringBuilder(secondHalf).reverse().toString();
            if (!firstHalf.equals(secondHalfReversed)){
                palindrome = false;
            }
        }

        return palindrome;
    }
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in a word: ");
        String str = in.nextLine();
        in.close();

        System.out.print("Word: " + str);
        boolean palindrome = palindromeChecker(str);
        if (palindrome){
            System.out.println(" is a palindrome");
        } else {
            System.out.println(" is not a palindrome");
        }
    }
}
