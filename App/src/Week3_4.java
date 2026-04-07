import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class Week3_4 {

    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        System.out.println("Bubble (asc): " + Arrays.toString(arr));
        System.out.println("Swaps: " + swaps);
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && (
                    arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance)
            )) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Insertion (desc): " + Arrays.toString(arr));
    }

    static void printTopRisks(Client[] arr) {
        int limit = Math.min(10, arr.length);
        System.out.print("Top " + limit + " risks: ");
        for (int i = 0; i < limit; i++) {
            System.out.print(arr[i].name + "(" + arr[i].riskScore + ")");
            if (i != limit - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 20000),
                new Client("clientA", 20, 5000),
                new Client("clientB", 50, 10000)
        };

        System.out.println("Input: " + Arrays.toString(clients));

        Client[] bubbleCopy = Arrays.copyOf(clients, clients.length);
        bubbleSort(bubbleCopy);

        Client[] insertionCopy = Arrays.copyOf(clients, clients.length);
        insertionSort(insertionCopy);

        printTopRisks(insertionCopy);
    }
}