package com.company;

// класс, определящий значение дроби
// вход - массив А
// вход - массив В
// вход - разрядность системы счисления
public class Divide {
    int first;
    int second;
    int rank;

    // конструктор
    public Divide(int _a, int _b, int _rank){
        first = _a;
        second = _b;
        rank = _rank;
    }

    // функция для расчета значения дроби
    public String Calculate() {
        // вычисляем значение
        String rightResult = "";
        String leftResult = "";
        // количество шагов
        int steps = 10;
        int step = 0;

        // вычисляем дробь в десятичной системе отсчета
        double num = (double) first / second;
        int leftPart = (int)num;
        double rightPart = num - leftPart;
        num = rightPart;

        // вычисляем целую часть в цикле
        int value = leftPart;
        while ( value % rank > 0 ) {

            int p = value / rank;
            int q = value % rank;
            leftResult = q + leftResult;
            value = p;
        }
        if (leftResult == "")
            leftResult = "0";

        // вычисляем дробную часть в цикле, пробегаем с указанной точностью
        while(step++<= steps)
        {
            num = num * rank;
            rightResult += Integer.parseInt(String.valueOf((int)Math.floor(num)),rank);
            num = num - Math.floor(num);
        }

        // сложим правую и левую части
        return leftResult + "," + rightResult;
    }
}
