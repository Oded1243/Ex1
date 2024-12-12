/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “1b200111”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

        /**
         * Convert the given number (num) to a decimal representation (as int).
         * If the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            int ans = -1;

            if (!num.contains("b")){
                num = num + "bA";
            }

            String regex = "^[A-F0-9]+b[2-9A-Ga-g]+$";

            if (!num.matches(regex)) {
               return ans;
            }

            String[] parts = num.split("b");
            String numberPart = parts[0];
            String basePart = parts[1];

            // Determine the base
            int base;
            if (Character.isDigit(basePart.charAt(0))) {
                base = Integer.parseInt(basePart);
            } else if (Character.isLetter(basePart.charAt(0))) {
                char baseChar = Character.toUpperCase(basePart.charAt(0));
                base = baseChar - 'A' + 10;
            } else {
                return ans; // Invalid base
            }


            if (base < 2 || base > 16) {
                return ans; // Base is out of range
            }

            try {
                ans = Integer.parseInt(numberPart, base);
            } catch (NumberFormatException e) {
                return -1;
            }

            return ans;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            if (a == null || a.isEmpty()) {
                return false;
            }
            String digits = "0123456789";
            if (!a.contains("b")) {
                boolean ans1 = true;
                for (int z =0 ; z < a.length(); z += 1 ) {
                    String currentchar = Character.toString(a.charAt(z));
                    if (!digits.contains(currentchar)) {
                        ans1 = false;
                    }
                }
                return ans1;
            }

            String regex = "^[A-F0-9]+b[2-9A-Ga-g]+$"; // Match the pattern <number>b<base>

            if (!a.matches(regex)) { //Make sure the string match the pattern
                return false;
            }

            String[] parts = a.split("b"); //Split the string into <number> and <base>
            if (parts.length != 2) {
                return false;
            }

            String numberPart = parts[0];
            String basePart = parts[1];

            try {
                int base = Integer.parseInt(basePart,17);////Base 16

                if (base < 2 || base > 16) {
                    return false;
                }
                for (char c : numberPart.toCharArray()) {  // Making sure that the number part contain only valid digit
                    int digitValue = Character.digit(c, base);
                    if (digitValue == -1) {
                        return false; // Wrong digit
                    }
                }
            } catch (NumberFormatException e) {
                return false;
            }

            return true;


            ////////////////////

        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String  int2Number(int num, int base) {
            String ans  = "";
            if (num > 0 && base > 1 && base < 17) {
                ans = (""  + Integer.toString(num, base));
            }
            return ans.toUpperCase();
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            int number;
            if (n1 == n2) {
                System.out.println("num 1 & num 2 are equals , value: " + n1);
                return ans;

            } try {
                int x = Ex1.number2Int(n1);
                int y = Ex1.number2Int(n2);

                if (x == y) {
                    System.out.println("num 1 & num 2 are equals , value: " + n1);
                    return ans;
                } else {
                    return false;
                }

            } catch (NumberFormatException e) {
                System.out.println("num 1 & num 2 are not equals ");
                return ans;
            }

            ////////////////////

        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            if (arr == null || arr.length == 0){

            }

            int maxIndex = 0;
            int max = number2Int(arr[0]);

            for (int i = 1 ; i < arr.length ; i++) {

                if (Ex1.number2Int(arr[i]) > max) {
                    max = number2Int(arr[i]);
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

}
