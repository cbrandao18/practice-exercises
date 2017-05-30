/**
 * Print numbers from 1 - 100
 * For multiples of 3 - print Fizz
 * For multiples of 5 - print Buzz
 * For a multiple of 3 and 5 - print FizzBuzz
 */
public class FizzBuzz {

    public static void main (String[] args){
        for (int i=1; i <= 100; i++){
            String fizzbuzz = "";
            if (i % 3 == 0 && i % 5 == 0){
                fizzbuzz = "FizzBuzz";
            } else if (i % 5 == 0){
                fizzbuzz = "Buzz";
            } else if (i % 3 == 0){
                fizzbuzz = "Fizz";
            }
            System.out.println("Number: " + i + " " + fizzbuzz);
        }
    }

}
