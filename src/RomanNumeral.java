import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Roman Numeral Program
 * Enter in an integer and program outputs a string with the Roman Numeral representation
 *
 * Created by Christie on 7/6/2017.
 */
public class RomanNumeral {

    /**
     * Find the largest key value in the roman map that goes into num
     *
     * @param num
     *      the number left to be converted into a roman numeral
     * @param roman
     *      the roman numeral map which pairs a integer to its roman numeral representation
     * @return
     *      the greatest key that goes into num
     */
    private static int findGreatestKey(int num, Map<Integer, String> roman){
        int greatestKey = 1;
        for(Map.Entry<Integer, String> entry : roman.entrySet()){
            if (num >= entry.getKey() && entry.getKey() > greatestKey){
                greatestKey = entry.getKey();
            }
        }
        return greatestKey;
    }

    /**
     * Takes an integer and returns Roman Numeral representation
     *
     * @param num
     *      the number to be converted into a roman numeral
     * @return
     *      the string representation of the roman numeral
     */
    private static String romanNumeral(int num){
        if (num < 1 || num > 4999){
            return "Number cannot be converted to a roman numeral";
        }

        /*
         * Creating the roman numeral map where key is number and value is the roman numeral string representation.
         *
         * This map contains the base 7 symbols (I, V, X, L, C, D, M) and their subtractive notations
         * (IV, IX, XL, XC, CD, CM). With these 13 symbols, any roman numeral can be created.
         */
        final Map<Integer, String> roman = new LinkedHashMap<>();
        roman.put(1, "I");
        roman.put(4, "IV");
        roman.put(5, "V");
        roman.put(9, "IX");
        roman.put(10, "X");
        roman.put(40, "XL");
        roman.put(50, "L");
        roman.put(90, "XC");
        roman.put(100, "C");
        roman.put(400, "CD");
        roman.put(500, "D");
        roman.put(900, "CM");
        roman.put(1000, "M");

        String str = "";
        /*
         * Find greatest key that goes into num then subtract it from num and repeat the process until num is 0
         */
        int greatestKey = findGreatestKey(num, roman);
        str += roman.get(greatestKey);
        num -= greatestKey;
        while (num > 0){
            greatestKey = findGreatestKey(num, roman);
            str += roman.get(greatestKey);
            num -= greatestKey;
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.print("Enter in an integer to be converted into a Roman Numeral: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        String roman = romanNumeral(n);
        System.out.println(roman);
    }
}
