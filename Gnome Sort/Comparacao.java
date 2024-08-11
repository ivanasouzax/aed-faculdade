import java.util.Arrays;
import java.util.Random;

public class Comparacao {

    // Gnome Sort
    static void gnomeSort(int arr[]) {
        int index = 0;
        int n = arr.length;

        while (index < n) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }

    // Quick Sort
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int n = 10000;
        Random rand = new Random();
        int[] largeArray = rand.ints(n, -10000, 10000).toArray();

        
        int[] gnomeArray = Arrays.copyOf(largeArray, largeArray.length);
        long startTime = System.nanoTime();
        gnomeSort(gnomeArray);
        long endTime = System.nanoTime();
        System.out.println("Gnome Sort execution time for large dataset: " + (endTime - startTime) + " ns");

        
        int[] quickArray = Arrays.copyOf(largeArray, largeArray.length);
        startTime = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort execution time for large dataset: " + (endTime - startTime) + " ns");
    }
}
