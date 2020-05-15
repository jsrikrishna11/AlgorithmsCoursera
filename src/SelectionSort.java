public class SelectionSort {
    //    Returns index of lowest element
    private static int findMin(int[] arr, int size, int lower) {
        int min = lower;
        for (int i = lower + 1; i < size; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }

        return min;
    }

    private static void swap(int arr[], int i, int min) {
        int temp;
        temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        StdOut.print("Enter number of elements");
        int size = StdIn.readInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            StdOut.print("Enter " + i + "th element: ");
            array[i] = StdIn.readInt();
        }

        for (int i = 0; i < size; i++) {
            int min = findMin(array, size, i);
            if (min != i) {
                swap(array, i, min);
            }
        }

        for (int i = 0; i < size; i++) {
            StdOut.print("( " + array[i] + " )");
        }

    }
}
