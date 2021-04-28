package ru.vsu.gribanova;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {4, 2, 1, 6, 2, 4};    //Тесты для проверки
        func(a);
        int[] b = {10, 6, 4, 1, 3, 8, 2, 5, 3};
        func(b);
        int[] c = {9, 4, 6, 2, 4, 11, 6, 3};
        func(c);
    }

    //Функция, в которой происходит сортировка слиянием и стандартная, и вывод результатов для сравнения
    public static void func(int[] a) {
        MergeSort(a, 0, 5);
        int[] b = a;
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }

    //Массив рекурсивно разбивается на более мелкие части, эти части решаются, а решения объединяются в решение исходной задачи
    public static void MergeSort(int[] a, int f, int l) {
        if (l <= f)
            return;
        int mid = f + (l - f) / 2;
        MergeSort(a, f, mid);
        MergeSort(a, mid + 1, l);
        int[] b = new int[a.length];
        for (int k = f; k <= l; k++)
            b[k] = a[k];
        int i = f, j = mid + 1;
        for (int k = f; k <= l; k++) {
            if (i > mid) {
                a[k] = b[j];
                j++;
            } else if (j > l) {
                a[k] = b[i];
                i++;
            } else if (b[j] < b[i]) {
                a[k] = b[j];
                j++;
            } else {
                a[k] = b[i];
                i++;
            }
        }
    }
}
