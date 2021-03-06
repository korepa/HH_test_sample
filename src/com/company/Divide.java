package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

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

        // извлечем целую часть
        String res1 = getInteger(first, second, rank);

        // извлечем период
        BigInteger rankType;
        if (rank % 2 == 0 && rank % 5 == 0){
            // если десятичная система, берем на единицу меньше
            rankType = BigInteger.valueOf(rank - 1);
        }
        else {
            rankType = BigInteger.valueOf(rank);
        }
        String res2 = repeatingFraction(first, second, rankType);

        // сложим правую и левую части для формирования результата
        StringBuilder sb = new StringBuilder();
        sb.append(res1);
        sb.append(res2);
        return sb.toString();
    }

    private String getInteger(long num, long den, int ran){
        // вычисляем целую часть в цикле
        String result = "";
        int leftPart = (int)((double) num / den);
        int value = leftPart;
        while ( value % ran > 0 ) {

            int p = value / ran;
            int q = value % ran;
            result = q + result;
            value = p;
        }
        if (result == "")
            result = "0";

        return result;
    }

    // поиск периодов в дробной части
    private String repeatingFraction(long num, long den, BigInteger ran) {

        // сюда будем записывать значения дроби с периодом
        StringBuilder sb = new StringBuilder();
        sb.append('.');

        num %= den;
        for (int i = 3, lim = (int) Math.sqrt(num); i <= lim; i++) {
            while (num % i == 0 && den % i == 0) {
                num /= i;
                den /= i;
            }
        }

        // пока не наткнемся на нулевой остаток
        while (num > 0) {
            // кратность 2
            while (den % 2 == 0 && num % 2 == 0) {
                num /= 2;
                den /= 2;
            }
            // кратность 5
            while (den % 5 == 0 && num % 5 == 0) {
                num /= 5;
                den /= 5;
            }
            // ищем периодичность
            BigInteger denR = ran;
            BigInteger denBI = BigInteger.valueOf(den);
            long lim = den;
            while (lim % 2 == 0) lim /= 2;
            while (lim % 5 == 0) lim /= 5;
            // пробегаем по циклу учитывая степень счисления
            for (int j = 1; j <= lim; j++, denR = denR.multiply(BigInteger.TEN).add(ran)) {
                if (denR.mod(denBI).equals(BigInteger.ZERO)) {
                    BigInteger repeat = BigInteger.valueOf(num).multiply(denR).divide(denBI);
                    // пишем в крублые скобки период
                    sb.append('(').append(String.format("%0" + j + "d", repeat)).append(')');
                    return sb.toString();
                }
            }

            // увеличиваем разряд и заново
            num *= 10;
            sb.append(num / den);
            num %= den;
        }

        // если не пробегали по циклу, добавим на конце 0
        if (sb.toString().equals("."))
            sb.append("0");

        // вернем результат
        return sb.toString();
    }
}
