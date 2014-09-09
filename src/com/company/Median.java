package com.company;
import java.util.Arrays;

// класс, определящий медиану массива целочисленных элементов
// вход - массив А
// вход - массив В
public class Median {

    // переменные (массивы А и В)
    int[] arrayFirst, arraySecond;
    int[] arrayMerge;
    double median;

    public Median(int[] _arrayFirst, int[] _arraySecond)
    {
        // инициализация массивов
        arrayFirst  = _arrayFirst;
        arraySecond  = _arraySecond;
    }

    // функция вычисления медианы по значениям двух массивов
    public void CalculateMedian() {
        // отсортируем оба массива по увеличению значения
        Arrays.sort(arrayFirst);
        Arrays.sort(arraySecond);

        // соберем общий массив из двух
        arrayMerge = merge(arrayFirst, arraySecond);

        // получим значение медианы
        median = getMedian(arrayMerge);
    }

    public void OutputResult(){
        // выведем отсортированные массивы
        System.out.format("Массив 1: %s\nМассив 2: %s\nМассив общий: %s\n",
                Arrays.toString(arrayFirst),
                Arrays.toString(arraySecond),
                Arrays.toString(arrayMerge));
        // выведем значение медианы
        System.out.format("Значение медианы: %.2f\n" , median);
    }

    // функция для сборки двух массивов в один
    private int[] merge(int[] a, int[] b) {

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
    private double getMedian(int[] a) {
        double median = 0;
        // не нулевой массив
        if (a.length > 0){
            if (a.length % 2 == 0)
                median = ((double)a[a.length/2] + (double)a[a.length/2 - 1])/2;
            else
                median = (double) a[a.length/2];
            }
        return median;
    }
}
