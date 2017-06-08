import java.util.Scanner;

/**Collatz
 * Start with a number greater than 1. Find the number of steps it takes to reach 1 using the following process:
 * n is even: divide it by 2
 * n is odd: multiply it by 3 and add 1
 *
 * Created by Christie on 6/8/2017.
 */
public class Collatz {

    private static int collatz(int num){
        int steps = 0;
        while (num != 1){
            if (num % 2 == 0){ //even
                num = num/2;
                steps++;
            } else { //odd
                num = (num*3) + 1;
                steps++;
            }
        }
        return steps;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in a number greater than 1:");
        int num = in.nextInt();
        in.close();
        int steps = collatz(num);
        System.out.println("It takes " + steps + " steps to reach 1 using the Collatz conjecture on " + num);
    }
}
