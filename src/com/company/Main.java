package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**1) угадать число методом перебора по порядку
 * 2) угадать число методом перебора случайных чисел
 * 3) угадать число методом сравнения со средним
 * бинарный поиск
 * есть лист, элементы которого отсортированы по возрастанию,
 * написать метод, который принимает лист и целое число
 * если число есть в листе, метод должен вернуть его индекс
 * если нет, то вернуть минус 1
*/
public class Main {

    public static void main(String[] args) {
        int border = 1_000;
        List<Integer> listCountPerebor = new ArrayList<>();
        List<Integer> listCountRandom = new ArrayList<>();
        List<Integer> listCountAverage = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int guessedNumber = (int) (ThreadLocalRandom.current().nextInt(1, border));
            List <Integer> listRandom = new ArrayList<>();
            for (int a = 1; a < border; a++) {
                listRandom.add(a);
            }
            Collections.shuffle(listRandom);
            perebor(guessedNumber, border, listCountPerebor);
            random(guessedNumber, border, listCountRandom, listRandom);
            average(guessedNumber, border, listCountAverage);
        }
        System.out.println("Лист, состоящий из попыток, полученных перебором по порядку");
        System.out.println(listCountPerebor);
        System.out.println("Лист, состоящий из попыток, полученных перебором случайных чисел");
        System.out.println(listCountRandom);
        System.out.println("Лист, состоящий из попыток, полученных сравнением со средним");
        System.out.println(listCountAverage);
        int sumListCountPerebor = 0;
        for (int i = 0; i < listCountPerebor.size(); i++) {
            sumListCountPerebor = sumListCountPerebor + listCountPerebor.get(i);
        }
        System.out.println("Сумма попыток, полученных перебором по порядку " + sumListCountPerebor);
        int averageListCountPerebor = sumListCountPerebor / listCountPerebor.size();
        System.out.println("Среднее в листе, состоящем из попыток, полученных перебором по порядку " + averageListCountPerebor);
        int sumListCountRandom = 0;
        for (int i = 0; i < listCountRandom.size(); i++) {
            sumListCountRandom = sumListCountRandom + listCountRandom.get(i);
        }
        System.out.println("Сумма попыток, полученных перебором случайных чисел " + sumListCountRandom);
        int averageListCountRandom = sumListCountRandom / listCountRandom.size();
        System.out.println("Среднее в листе, состоящем из попыток, полученных перебором случайных чисел " + averageListCountRandom);
        int sumListCountAverage = 0;
        for (int i = 0; i < listCountAverage.size(); i++) {
            sumListCountAverage = sumListCountAverage + listCountAverage.get(i);
        }
        System.out.println("Сумма попыток, полученных сравнением со средним " + sumListCountAverage);
        int averageListCountAverage = sumListCountAverage / listCountAverage.size();
        System.out.println("Среднее в листе, состоящем из попыток, полученных сравнением со средним " + averageListCountAverage);
    }

     public static void perebor(int guessedNumber, int bound, List<Integer> listCountPerebor) {
        int countPerebor = 0;
         for (int i = 1; i < bound; i++) {
            if (i == guessedNumber) {
                countPerebor = countPerebor + 1;
                break;
            }
            countPerebor = countPerebor + 1;
         }
         listCountPerebor.add(countPerebor);
     }

     public static void random(int guessedNumber, int bound, List<Integer> listCountRandom, List<Integer> listRandom) {
         int countRandom = 0;
         for (int i = 0; i < bound; i++) {
             if (listRandom.get(i) == guessedNumber) {
                 countRandom = countRandom + 1;
                 break;
             }
             countRandom = countRandom + 1;
         }
         listCountRandom.add(countRandom);
     }

     public static void average(int guessedNumber, int border, List<Integer> listCountAverage) {
         int countAverage = 0;
         int lowerBorder = 0;
         int upperBorder = border;
//         for (int i = 0; i < border; i++) {
         while (true) {
             int number = (lowerBorder + upperBorder) / 2;
             if (number == guessedNumber) {
                 countAverage = countAverage + 1;
                 break;
             }
             if (number > guessedNumber) {
                 upperBorder = number;
                 countAverage = countAverage + 1;
             } else if (number < guessedNumber) {
                 lowerBorder = number;
                 countAverage = countAverage + 1;
             }
         }
         listCountAverage.add(countAverage);
     }
}
