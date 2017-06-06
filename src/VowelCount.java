import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * Vowel Count
 * Enter in a string and the program counts the number of vowels and prints result to console.
 * Created by Christie on 6/6/2017.
 */
public class VowelCount {

    private static void vowelCount(String str){
        /*
         * Declare and initialize vowel count map with all vowels with an occurrence of 0
         */
        Map<Character, Integer> vowelCount = new HashMap<>();
        vowelCount.put('a', 0);
        vowelCount.put('e', 0);
        vowelCount.put('i', 0);
        vowelCount.put('o', 0);
        vowelCount.put('u', 0);

        /*
         * Iterate through string and update vowel occurrences in map
         */
        str = str.toLowerCase();
        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if (vowelCount.containsKey(c)){
                int count = vowelCount.get(c);
                count++;
                vowelCount.replace(c, count);
            }
        }

        /*
         * Iterate through map and output vowel occurrences
         */
        System.out.println("String: "+ str);
        Iterator it = vowelCount.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println("Vowel: " + pair.getKey() + " Count: " + pair.getValue());
            it.remove();
        }
    }
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = in.nextLine();
        in.close();
        vowelCount(str);
    }
}
