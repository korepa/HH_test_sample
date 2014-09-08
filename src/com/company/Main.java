package com.company;
import java.util.*;
import java.util.Arrays;

// базовый класс
public class Main {

    // главная функция
    public static void main(String[] args) {

        // (пример)объявили 2 массива
        int[] arrayFirst = {1, 2, 3, 4};
        int[] arraySecond = {1, 4, 5, 6};

        // поситаем медиану
        calculateMedian(arrayFirst, arraySecond);

        // для ввода пользователю
    }

    // функция вычисления медианы по значениям двух массивов
    public static void calculateMedian(int[] arrayFirst, int[] arraySecond) {
        // отсортируем оба массива по увеличению значения
        Arrays.sort(arrayFirst);
        Arrays.sort(arraySecond);

        // соберем общий массив из двух
        int[] arrayMerge = merge(arrayFirst, arraySecond);

        // получим значение медианы
        double median = getMedian(arrayMerge);

        // пример выполнения функции
        System.out.format("Пример нахождения медианы для массива 2N (N > 0)\n");
        // выведем отсортированные массивы
        System.out.format("Массив 1: %s\nМассив 2: %s\nМассив общий: %s\n",
                Arrays.toString(arrayFirst),
                Arrays.toString(arraySecond),
                Arrays.toString(arrayMerge));
        // выведем значение медианы
        System.out.format("Значение медианы: %.2f\n" , median);
        
    }

    // функция для сборки двух массивов в один
    public static int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
        {
            if (a[i] < b[j])
                answer[k++] = a[i++];

            else
                answer[k++] = b[j++];
        }

        while (i < a.length)
            answer[k++] = a[i++];


        while (j < b.length)
            answer[k++] = b[j++];

        return answer;
    }

    // функция для сборки двух массивов в один
    public static double getMedian(int[] a) {
        double median;
        if (a.length % 2 == 0)
            median = ((double)a[a.length/2] + (double)a[a.length/2 - 1])/2;
        else
            median = (double) a[a.length/2];
        return median;
    }
}
