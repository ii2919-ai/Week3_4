import java.util.*;

public class Week3_4 {

    // -------- LINEAR SEARCH --------
    static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1;
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear first " + target + ": index " + first);
        System.out.println("Linear last " + target + ": index " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // -------- BINARY SEARCH --------
    static void binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;
        int foundIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                foundIndex = mid;
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int count = 0;

        if (foundIndex != -1) {
            // Count duplicates (expand left & right)
            int left = foundIndex;
            int right = foundIndex;

            while (left >= 0 && arr[left].equals(target)) {
                count++;
                left--;
            }

            while (right < arr.length && arr[right].equals(target)) {
                count++;
                right++;
            }

            count--; // adjust double count at foundIndex
        }

        System.out.println("Binary " + target + ": index " + foundIndex);
        System.out.println("Count: " + count);
        System.out.println("Comparisons: " + comparisons);
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Input logs: " + Arrays.toString(logs));

        // Linear Search
        linearSearch(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted logs: " + Arrays.toString(logs));

        // Binary Search
        binarySearch(logs, "accB");
    }
}