import java.util.Scanner;

/**
 * Password checker
 * 1. Password must be at least 6 characters long
 * 2. Must be
 * - at least one upper case letter
 * - at least one lower case letter
 * - at least one digit
 * - at least one special character !@#$%^&*
 * Created by Christie on 6/2/2017.
 */
public class PasswordChecker {

    private static boolean charLenCheck(String pass){
        return (pass.length() >= 6);
    }

    private static boolean uppercaseCheck(String pass){
        boolean upper = false;
        for (int i=0; i<pass.length(); i++){
            char c = pass.charAt(i);
            if (Character.isUpperCase(c)){
                upper = true;
                break;
            }
        }
        return upper;
    }

    private static boolean lowercaseCheck(String pass){
        boolean lower = false;
        for (int i=0; i<pass.length(); i++){
            char c = pass.charAt(i);
            if (Character.isLowerCase(c)){
                lower = true;
                break;
            }
        }
        return lower;
    }

    private static boolean digitCheck(String pass){
        boolean digit = false;
        for (int i=0; i<pass.length(); i++){
            char c = pass.charAt(i);
            if (Character.isDigit(c)){
                digit = true;
                break;
            }
        }
        return digit;
    }

    private static boolean specialCheck(String pass){
        boolean special = false;
        String chars = "!@#$%^&*";
        for (int i=0; i<pass.length(); i++){
            for (int j=0; j<chars.length(); j++){
                char c = pass.charAt(i);
                char s = chars.charAt(j);
                if (c == s){
                    special = true;
                    break;
                }
            }
        }
        return special;
    }

    public static void main (String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter in your password: ");
        String input = reader.nextLine();

        boolean charLenCheck = charLenCheck(input);
        boolean uppercaseCheck = uppercaseCheck(input);
        boolean lowercaseCheck = lowercaseCheck(input);
        boolean digitCheck = digitCheck(input);
        boolean specialCheck = specialCheck(input);

        boolean allCheck = charLenCheck && uppercaseCheck && lowercaseCheck && digitCheck && specialCheck;

        if (allCheck){
            System.out.println("Your password satisfies the requirements.");
        } else {
            if (!charLenCheck){
                System.out.println("6 digit length not satisfied");
            }
            if (!uppercaseCheck){
                System.out.println("Upper case requirement not satisfied");
            }
            if (!lowercaseCheck){
                System.out.println("Lower case requirement not satisfied");
            }
            if (!digitCheck){
                System.out.println("Digit check requirement not satisfied");
            }
            if (!specialCheck){
                System.out.println("Special character check requirement not satisfied");
            }
        }


    }

}
