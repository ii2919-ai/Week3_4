import java.util.*;

public class Week3_4 {

    // -------- LINEAR SEARCH --------
    static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: threshold=" + target + " → not found");
        }
        System.out.println("Comparisons: " + comparisons);
    }

    // -------- BINARY SEARCH FLOOR & CEILING --------
    static void binaryFloorCeil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary floor(" + target + "): " + floor);
        System.out.println("Binary ceiling(" + target + "): " + ceil);
        System.out.println("Comparisons: " + comparisons);
    }

    // -------- BINARY INSERTION POINT --------
    static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        System.out.println("Sorted risks: " + Arrays.toString(risks));

        // Linear Search on unsorted (simulate)
        int[] unsorted = {50, 10, 100, 25};
        linearSearch(unsorted, 30);

        // Binary Search for floor & ceiling
        binaryFloorCeil(risks, 30);

        // Binary insertion point
        int pos = insertionPoint(risks, 30);
        System.out.println("Insertion index for 30: " + pos);
    }
}