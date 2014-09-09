package com.company;
import java.io.Console;
import java.util.*;
import java.util.Arrays;

// базовый класс
public class Main {

    // главная функция
    public static void main(String[] args) {

        // пример выполнения функции
        System.out.format("Пример нахождения медианы для массива 2N (N > 0)\n");

        // (пример)объявили 2 массива
        int[] arrayFirst = {1, 2, 3, 4};
        int[] arraySecond = {1, 4, 5, 6};

        // посчитаем медиану
        Median median = new Median(arrayFirst, arraySecond);
        median.CalculateMedian();
        median.OutputResult();

        // выполнение функции с вводом данных от пользователя (сначала массив А, потом В)
        arrayFirst = inputUserArray();
        arraySecond = inputUserArray();

        // посчитаем медиану для пользовательского ввода
        median = new Median(arrayFirst, arraySecond);
        median.CalculateMedian();
        median.OutputResult();
    }

    // функция для ввода пользователем массива
    static int[] inputUserArray(){
        List<Integer> list = new ArrayList<Integer>();
        Scanner stdin = new Scanner(System.in);

        System.out.println("Начало ввода целочисленного натурального массива. Для завершения ввода введите символ (например, n):");
        do {
            System.out.println("Текущий список: " + list);
            System.out.println("Ввод числа: ");
            String symb = stdin.next();
            if (!symb.startsWith("n")) {
                try {
                    // преобразуем ввод
                    Integer symbInt = Integer.parseInt(symb);
                    // число должно быть больше нуля
                    if (symbInt <= 0)
                        break;
                    list.add(symbInt);
                } catch (NumberFormatException e) {
                    // некорректный ввод (не целое число)
                    break;
                }
            } else {
                break;
            }
        } while (true);

        // преобразуем в примитивный архив
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        System.out.println("Массив: " + Arrays.toString(arr));
        return arr;
    }
}
