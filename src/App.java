import java.util.Arrays;

public class App {
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] array = {5, 2, 8, 12, 7, 1, 3, 9, 6};
        
        // Mergesort time
        long startMergeSort = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        long endMergeSort = System.nanoTime();
        long timeTakenMergeSort = endMergeSort - startMergeSort;
        System.out.println("MergeSort result: " + Arrays.toString(array));
        System.out.println("Time taken by MergeSort: " + timeTakenMergeSort + " nanoseconds");

        // Bubblesort time
        int[] array2 = {5, 2, 8, 12, 7, 1, 3, 9, 6};
        long startBubbleSort = System.nanoTime();
        bubbleSort(array2);
        long endBubbleSort = System.nanoTime();
        long timeTakenBubbleSort = endBubbleSort - startBubbleSort;
        System.out.println("BubbleSort result: " + Arrays.toString(array2));
        System.out.println("Time taken by BubbleSort: " + timeTakenBubbleSort + " nanoseconds");

        // Time comparison
        if (timeTakenMergeSort < timeTakenBubbleSort) {
            System.out.println("MergeSort is faster than BubbleSort");
        } else {
            System.out.println("BubbleSort is faster than MergeSort");
        }
    }
}