package com.telran.homeworks;

import java.util.Arrays;

public class Homework_07052024 {
    public static void main(String[] args) {
//  №1.
//  Создайте массив из 8 случайных целых чисел из интервала [1;50]
//  Выведите массив на консоль в строку.
//  Замените каждый элемент с нечетным индексом на ноль.
//  Снова выведете массив на консоль в отдельной строке.
        System.out.println("Task1:");
        int[] array = getRandomArray(8, 1, 50);
        printArray(array);
//  №2.
//  Создайте массив из 5 случайных целых чисел из интервала [10;99]
//  Выведите его на консоль в строку.
//  Определите и выведите на экран сообщение о том, является ли массив строго возрастающей последовательностью.
        System.out.println("Task2:");
        int[] array2 = getRandomArray(5, 10, 99);
        printArray(array2);
        System.out.println(isArrayIncreasing(array2));
//        Arrays.sort(array2);
//        printArray(array2);
//        System.out.println(isArrayIncreasing(array2));

//  Дополнительно
//  Дан массив размера  N-1  , содержащий только различные целые числа в диапазоне от  1 до N . Найдите недостающий элемент.
//  Пример 1:
//      Вход: N = 5  ,  А[] = {1,2,3,5}
//      Выход: 4
//
//  Пример 2:
//      Вход: N = 10  ,  А[] = {6,1,2,8,3,4,7,10,5}
//      Выход: 9
        System.out.println("AddTask:");
        int[] array3 = {1, 2, 3, 5};
        printArray(array3);
        System.out.print("Missing number: ");
        System.out.println(findMissingNumber(array3));

    }

    public static int[] getRandomArray(int number, int min, int max) {
        int[] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static boolean isArrayIncreasing(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int findMissingNumber(int[] array) {
        int max = findMaxInArray(array);
        for (int j = 1; j <= max; j++) {
            if (!isArrayContainNumber(array, j)) {
                return j;
            }
        }
        return -1;
    }

    public static int findMaxInArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static boolean isArrayContainNumber(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }

}
