package com.company;

import java.util.*;
import java.util.Arrays;

// базовый класс
public class Main {

    // главная функция
    public static void main(String[] args) {

        // выберем тип задания (1 - вычисление медианы, 2 - вычисление дроби в k-ной системе счисления)
        System.out.println("Введите действие: 1 - вычисление медианы, 2 - вычисление дроби в k-ной системе счисления. Другой символ - для выхода");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();

        if (type.equals("1")){
            // выбрали вычисление медианы

            // пример выполнения функции
            System.out.format("Пример нахождения медианы для массива 2N (N > 0)\n");

            // (пример)объявили 2 массива
            int[] arrayFirst = {1, 2, 3, 4};
            int[] arraySecond = {1, 4, 5, 6};

            // посчитаем медиану
            Median median = new Median(arrayFirst, arraySecond);
            median.CalculateMedian();
            median.OutputResult();

            // выполнения функции с вводом данных
            System.out.format("Нахождение медианы для массива 2N (N > 0)\n");

            // выполнение функции с вводом данных от пользователя (сначала массив А, потом В)
            arrayFirst = inputUserArray();
            arraySecond = inputUserArray();

            // сверим размеры массивов
            if (arrayFirst.length == arraySecond.length){
                // посчитаем медиану для пользовательского ввода
                median = new Median(arrayFirst, arraySecond);
                median.CalculateMedian();
                median.OutputResult();
            }
            else {
                System.out.format("Размеры массивов не совпадают. Массив А[%d]. Массив В[%d].\n", arrayFirst.length, arraySecond.length);
            }

        }
        else if (type.equals("2")){
            // выбрали вычисление дроби в k-ной системе счисления

            // используемые переменные
            Divide data;
            String result;

            // текстовое сообщение
            System.out.println("Пример деления в k-ичной системе счисления");

            // примеры 1
            System.out.println("Первый ввод (1-число, 2-число, разрядность): 1 2 8");
            data = new Divide(1,2,8);
            result = data.Calculate();
            System.out.format("Результат дроби a/b: %s\n", result);

            // примеры 2
            System.out.println("Второй ввод (1-число, 2-число, разрядность): 1 12 10");
            data = new Divide(1,12,10);
            result = data.Calculate();
            System.out.format("Результат дроби a/b: %s\n", result);

            // обрабатываем пользовательский ввод
            // ввод 1
            System.out.println("Первый ввод (1-число, 2-число, разрядность) через пробел:");
            data = inputBlock();
            result = data.Calculate();
            System.out.format("Результат дроби a/b: %s\n", result);

            // ввод 2
            System.out.println("Второй ввод (1-число, 2-число, разрядность) через пробел:");
            data = inputBlock();
            result = data.Calculate();
            System.out.format("Результат дроби a/b: %s\n", result);
        }

        // для выхода нажмите кнопку
        System.out.format("Для выхода нажмите любую кнопку.\n");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    // функция для ввода пользователем массива
    static int[] inputUserArray(){
        List<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Начало ввода целочисленного натурального массива. Для завершения ввода введите символ - не число (например, n):");
        do {
            System.out.println("Ввод числа. Текущий массив: " + list);
            String symb = sc.next();
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
        System.out.println("Полученный массив: " + Arrays.toString(arr));
        return arr;
    }

    // функция для расчета значения дроби
    static Divide inputBlock() {

        // объявим класс
        Divide data;
        int a, b, div;

        // вычисляем значение
        Scanner sc=new Scanner(System.in);

        System.out.println("Введите первое число (делимое)...");
        a=getInt(sc);
        System.out.println("Введите второе число (делитель)...");
        b=getInt(sc);
        System.out.println("Введите степень исчисления...");
        div=getInt(sc);

        // полученные значения
        System.out.format("Полученные значения: %d, %d, %d\n", a,   b,  div );
        data = new Divide(a, b, div);
        return data;
    }

    private static int getInt(Scanner sc)
    {
        for (;;) {
            if (!sc.hasNextInt()) {
                System.out.println("Вводите только целые числа больше 0!");
                sc.next();
                continue;
            }
            int value = sc.nextInt();
            if (value >= 0) {
                return value;

            } else {
                System.out.print("Некорректный ввод!");

            }
            break;
        }

        return 0;
    }
}
