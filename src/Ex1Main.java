
import java.util.Arrays;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (!num1.equals("quit")) {
                boolean number1 = Ex1.isNumber(num1);
                if (number1 == true) {
                    System.out.println("num 1 = " + num1 + " is number: true , value " + num1);
                } else {
                    System.out.println("num 1 = " + num1 + " is number: false , value " + "-1");
                    System.out.println(num1 + " is not a valid number\n ");
                    continue;
                }
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals("quit")) {
                    boolean number2 = Ex1.isNumber(num2);
                    if (number2 == true) {
                        System.out.println("num 2 = " + num2 + " is number: true , value " + num2);
                    } else {
                        System.out.println("num 2 = " + num2 + " is number: false , value " + "-1");
                        System.out.println(num2 + " is not a valid number\n ");
                        continue;
                    }
                    System.out.println("Enter a base for output: (a number [2,16]) ");
                    int base = sc.nextInt();
                    if (1 < base || base < 17) {
                        int x = Ex1.number2Int(num1);
                        int y = Ex1.number2Int(num2);
                        String z = Ex1.int2Number(x + y, base);
                        String w = Ex1.int2Number(x * y, base);
                        System.out.println(x + " + " + y + " = " + z + "b" + base);
                        System.out.println(x + " * " + y + " = " + w + "b" + base);

                        String[] numbers = {num1, num2, z, w};
                        int index = Ex1.maxIndex(numbers);

                        System.out.println("Max number over " + Arrays.toString(numbers) + " is: " + index);

                    }

                }
            }
            System.out.println("quiting now...");
        }
    }
}
