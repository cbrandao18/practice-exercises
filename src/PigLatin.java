import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pig Latin
 * Initial consonant cluster sound is transposed to the end of the world and an "ay" is affixed.
 * If a word starts with a vowel - just add "ay" to the end
 *
 * Enter a word and the program translates it to pig latin
 *
 * Created by Christie on 6/6/2017.
 */
public class PigLatin {

    private static String pigLatin(String str){
        String pigLatin = "";
        str = str.toLowerCase();
        /*
         * Initialize array list of vowels
         */
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        /*
         * Check if first letter in str is a vowel or a consonant
         */
        if(vowels.contains(str.charAt(0))){ //first letter is a vowel
            pigLatin = str + "ay";
        } else { //first letter is a consonant
            //check for consonant clusters
            int consonantCount = 0;
            int i = 0;
            char c = str.charAt(i);
            while (!vowels.contains(c) && i < str.length()){
                consonantCount++;
                i++;
                c = str.charAt(i);
            }
            pigLatin = str.substring(consonantCount) + str.substring(0, consonantCount) + "ay";

        }
        return pigLatin;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in a word: ");
        String str = in.nextLine();
        in.close();
        String pigLatin = pigLatin(str);
        System.out.println("Original word: " + str);
        System.out.println("Pig Latin word: " + pigLatin);
    }
}
