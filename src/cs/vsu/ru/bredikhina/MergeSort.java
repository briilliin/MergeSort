package cs.vsu.ru.bredikhina;


import java.util.Arrays;

public class MergeSort {


    public static void mergeSort(int[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        } else {
            int mid = n / 2;
            int[] leftArray = new int[mid];
            int[] rightArray = new int[n - mid];
            for (int i = 0; i < mid; i++) {
                leftArray[i] = array[i];
            }
            for (int j = mid; j < n; j++) {
                rightArray[j - mid] = array[j];
            }
            mergeSort(leftArray);
            mergeSort(rightArray);
            merge(leftArray, rightArray, array);
        }
    }

    public static void merge(int leftArray[], int rightArray[], int array[]) {
        int L = leftArray.length;
        int R = rightArray.length;
        int i = 0;
        int j = 0;
        int k = 0;


        while (i < L && j < R) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else if (leftArray[i] > rightArray[j]) {
                array[k] = rightArray[j];
                j++;
            }
            k = k + 1;
        }


        while (i < L) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < R) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {


        System.out.println("Исходный массив: ");
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 100));
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
        System.out.println("Стандартная сортировка: ");
        int[] arr = array.clone();
        Arrays.sort(arr);
        for (int i = 0; i < array.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");

        mergeSort(array);
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
