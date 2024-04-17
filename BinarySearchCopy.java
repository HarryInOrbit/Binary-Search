import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchCopy {

    public static void main(String[] args) throws FileNotFoundException {
        // Array scanned from the file
        int[] array = Scanner();
        // Array of target number
        int[] num = {51216352, 198313119, 196614208};
        for (int i = 0; i < num.length; i++) {
            int result = BinarySearch(array, num[i]);

            if (result >= 0) {
                System.out.println(result);
                System.out.println();
            } else {
                System.out.println("Not Found");
                System.out.println();
            }
        }
    }
    public static int[] Scanner() throws FileNotFoundException {
        // Scan the text file
        File file = new File("numbers.txt");
        Scanner scan = new Scanner(file);

        // Count the number of line
        int count = 0;
        while (scan.hasNextInt()) {
            scan.nextInt();
            count++;
        }
        // Close scanner
        scan.close();

        // Import the numbers into array
        scan = new Scanner(file);
        int[] Number = new int[count];

        for (int i = 0; i < count; i++) {
            Number[i] = scan.nextInt();
        }
        scan.close();
        return Number;
    }

    private static int BinarySearch(int[] array, int numFind) {
        // Counting number of operation
        int operationCount = 0;
        // Initialize the lowest and highest point
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            // Calculate the middle point
            int midPos = (low + high) / 2;
            // The value at the midpoint
            int midNum = array[midPos];

            // Check if the middle point is the target
            if (numFind == midNum) {
                operationCount++;
                System.out.println("It took " + operationCount + " operations");  // O(1)
                return midPos;
            }
            // If the target is smaller than the middle point then search in the left half
            if (numFind < midNum) {
                operationCount += 2;
                high = midPos - 1;
            } else { // If the target is larger than the middle point then search in the right half
                operationCount += 2;
                low = midPos + 1;
            }
        }
        // If not found, return -1
        return -1;
    }

}
