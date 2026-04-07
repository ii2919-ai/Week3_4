import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class Week3_4 {

    static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        int passes = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break;
        }

        System.out.println("BubbleSort (fees): " + list);
        System.out.println("Passes: " + passes + ", Swaps: " + swaps);
    }

    static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && (
                    list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).timestamp.compareTo(key.timestamp) > 0)
            )) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        System.out.println("InsertionSort (fee+ts): " + list);
    }

    static void findOutliers(List<Transaction> list) {
        List<Transaction> outliers = new ArrayList<>();
        for (Transaction t : list) {
            if (t.fee > 50) {
                outliers.add(t);
            }
        }

        if (outliers.isEmpty()) {
            System.out.println("High-fee outliers: none");
        } else {
            System.out.println("High-fee outliers: " + outliers);
        }
    }

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        System.out.println("Input: " + transactions);

        if (transactions.size() <= 100) {
            List<Transaction> copy = new ArrayList<>(transactions);
            bubbleSort(copy);
        }

        if (transactions.size() > 100 && transactions.size() <= 1000) {
            List<Transaction> copy = new ArrayList<>(transactions);
            insertionSort(copy);
        } else {
            List<Transaction> copy = new ArrayList<>(transactions);
            insertionSort(copy);
        }

        findOutliers(transactions);
    }
}