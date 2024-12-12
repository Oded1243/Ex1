import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {

        }

    @Test
    public void testNumber2Int() {
        assertEquals(-1, Ex1.number2Int("123b16"));   // Base 10 representation
        assertEquals(5, Ex1.number2Int("5")); // Binary to Decimal
        assertEquals(39, Ex1.number2Int("100111b2"));    // Invalid base representation
        assertEquals(-1, Ex1.number2Int("1234b11"));   // Invalid number
        assertEquals(135, Ex1.number2Int("135bA"));          // Empty string
        assertEquals(-1, Ex1.number2Int("b3"));        // Invalid format
    }

    // Test the isNumber method
    @Test
    public void testIsNumber() {
        assertTrue(Ex1.isNumber("135bA"));   // Valid number
        assertFalse(Ex1.isNumber("200111b2")); // Binary number
        assertFalse(Ex1.isNumber("123b16"));  // Invalid base
        assertFalse(Ex1.isNumber(""));         // Empty string
        assertFalse(Ex1.isNumber("b3"));       // Invalid number
        assertFalse(Ex1.isNumber("1234b11"));  // Invalid number
    }

    // Test the int2Number method
    @Test
    public void testInt2Number() {
        assertEquals("135", Ex1.int2Number(135, 10));  // Base 10
        assertEquals("110000110110101111", Ex1.int2Number(200111, 2));  // Binary
        assertEquals("", Ex1.int2Number(-1, 10));      // Invalid number
        assertEquals("", Ex1.int2Number(135, 17));     // Invalid base
        assertEquals("F", Ex1.int2Number(15, 16));     // Hexadecimal representation
    }

    // Test the equals method
    @Test
    public void testEquals() {
        assertTrue(Ex1.equals("135bA", "135bA"));   // Same numbers in same format
        assertFalse(Ex1.equals("135bA", "200111b2")); // Different numbers
        assertFalse(Ex1.equals("135bA", "123bG"));   // Same numbers, different bases
    }

    // Test the maxIndex method
    @Test
    public void testMaxIndex() {
        String[] arr1 = {"135bA", "100111b2", "123b5", "152bA"};
        assertEquals(3, Ex1.maxIndex(arr1));  // Index of the largest number

        String[] arr2 = {"-1", "100111b2", "123b5", "10011b2"};
        assertEquals(1, Ex1.maxIndex(arr2));  // Valid number is at index 1

        String[] arr3 = {"123bA", "invalid", "100111b2", "390bA"};
        assertEquals(3, Ex1.maxIndex(arr3));  // Invalid numbers should be ignored
        String[] arr4 = {"30", "5", "52", "44"};
        assertEquals(2, Ex1.maxIndex(arr4));
        String[] arr5 = {"72", "35", "1101011b2", "100111011000b2"};
        assertEquals(3, Ex1.maxIndex(arr5));

    }

        // Add additional test functions - test as much as you can.
    }
