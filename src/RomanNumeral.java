import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Roman Numeral Program
 * Enter in an integer and program outputs a string with the Roman Numeral representation.
 * Also, enter in a Roman Numeral string and program outputs the integer representation.
 *
 * Created by Christie on 7/6/2017.
 */
public class RomanNumeral {

    /**
     * Find the largest key value in the roman map that goes into num. To be used for to_roman method.
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
     * @param number
     *      the number to be converted into a roman numeral
     * @return
     *      the string representation of the roman numeral
     */
    private static String to_roman(int number){
        if (number < 1 || number > 4999){
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
         * Find greatest key that goes into num then subtract it from num. Look up the roman numeral representation
         * of that key and concatenate it to the string. Repeat the process until num is 0.
         */
        int greatestKey = findGreatestKey(number, roman);
        str += roman.get(greatestKey);
        number -= greatestKey;
        while (number > 0){
            greatestKey = findGreatestKey(number, roman);
            str += roman.get(greatestKey);
            number -= greatestKey;
        }

        return str;
    }

    /**
     * Takes a string consisting of Roman Numerals and convert to a number
     *
     * @param string
     *      string of Roman Numerals to convert
     * @return
     *      integer representing the value of the Roman Numeral string
     */
    private static int to_decimal(String string){
        /*
         * Creating the roman numeral map where key is the roman numeral string and value is the number it represents.
         *
         * This map contains the base 7 symbols (I, V, X, L, C, D, M) and their subtractive notations
         * (IV, IX, XL, XC, CD, CM). With these 13 symbols, any roman numeral can be created.
         */
        final Map<String, Integer> roman = new LinkedHashMap<>();
        roman.put("I", 1);
        roman.put("IV", 4);
        roman.put("V", 5);
        roman.put("IX", 9);
        roman.put("X", 10);
        roman.put("XL", 40);
        roman.put("L", 50);
        roman.put("XC", 90);
        roman.put("C", 100);
        roman.put("CD", 400);
        roman.put("D", 500);
        roman.put("CM", 900);
        roman.put("M", 1000);

        int num = 0;
        String token = "";
        //String only holds one roman numeral. No need to check if it is a subtractive notation.
        if (string.length() == 1){
            token = String.valueOf(string.charAt(0));
            return roman.get(token);
        }

        //string is longer than just one roman numeral.
        int i = 0;
        while (i < string.length()){
            if (i+1 < string.length()){
                //At least two roman numerals left in string. So check for subtractive notation
                token = String.valueOf(string.charAt(i)) + String.valueOf(string.charAt(i+1));
                if (roman.containsKey(token)){
                    //Subtractive notation found
                    i = i+2;
                } else {
                    //Subtractive notation not found so get token of single roman numeral
                    token = String.valueOf(string.charAt(i));
                    i++;
                }
            } else {
                //Read last roman numeral in the string
                token = String.valueOf(string.charAt(i));
                i++;
            }
            //Get value of roman numeral from map and add to current number
            num += roman.get(token);
        }
        return num;
    }

    public static void main(String[] args) {
        //Get integer input to convert to a Roman Numeral string
        System.out.print("Enter in an integer to be converted into a Roman Numeral: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        String roman = to_roman(n);
        System.out.println(roman);

        //Get string input of Roman Numeral to convert to integer
        System.out.print("Enter in a Roman Numeral to be converted into a number: ");
        scan = new Scanner(System.in);
        String str = scan.nextLine();

        int num = to_decimal(str);
        System.out.println(num);
    }
}
