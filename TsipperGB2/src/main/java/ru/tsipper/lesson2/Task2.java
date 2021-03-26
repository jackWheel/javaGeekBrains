package ru.tsipper.lesson2;

import java.util.Random;
import java.util.Scanner;
import java.lang.*;

public class Task2 {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.println("Задание 1. Задать целочисленный массив из 0 и 1. Заменить элементы на противоположные.");
        System.out.print("Введите длину массива: ");
        int ar1L = in.nextInt();
        int ar1[];
        ar1 = new int[ar1L];
        getArrayRandom(ar1,2);
        System.out.println("Исходный массив: ");
        showArray(ar1);
        changeBinary(ar1);
        System.out.println("Массив после обработки: ");
        showArray(ar1);

        System.out.println("Задание 2. Задать целочисленный массив размерностью 8. Заполнить его числовой последовательностью.");
        int ar2[];
        ar2 = new int[8];
        getSpecificArray(ar2);
        System.out.println("Массив: ");
        showArray(ar2);

        System.out.println("Задание 3. Задать определенный массив. Умножить элементы, которые меньше 6, на 2.");
        int ar3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: ");
        showArray(ar3);
        multiplyLesserElements(ar3, 6);
        System.out.println("Массив после обработки: ");
        showArray(ar3);

        System.out.println("Задание 4. Задать массив. Найти минимальный и максимальный элементы.");
        System.out.print("Введите длину массива: ");
        int ar4L = in.nextInt();
        int ar4[];
        ar4 = new int[ar4L];
        System.out.print("Элементы массива не меньше 0 и не больше: ");  //верхняя граница значений элементов массива
        int max = in.nextInt();
        getArrayRandom(ar4,max);
        System.out.println("Исходный массив: ");
        showArray(ar4);
        System.out.println("Минимальный элемент: " + getMin(ar4));
        System.out.println("Максимальный элемент: " + getMax(ar4));

        System.out.println("Задание 5. Задать квадратную матрицу N порядка, заполнить главную и побочную диагонали единицами.");
        System.out.print("Введите порядок квадратной матрицы: ");
        int MatrixN = in.nextInt();
        int matrix[][];
        matrix = new int[MatrixN][MatrixN];
        getMatrix(matrix,MatrixN);

        System.out.println("Задания 6 и 7. Циклический сдвиг массива без использования вспомогательных массивов.");
        System.out.println("Для упрощения отслеживания я задаю массив последовательных чисел.");
        System.out.print("Введите длину массива: ");
        int ar6L = in.nextInt();
        int ar6[];
        ar6 = new int[ar6L];
        for (int i = 0; i<ar6.length; i++)
            ar6[i] = i+1;
        System.out.println("Исходный массив: ");
        showArray(ar6);
        System.out.print("Введите сдвиг: ");
        int uShift = in.nextInt();
        arrayShift(ar6,uShift);
        System.out.println("Массив после обработки: ");
        showArray(ar6);

    }

    static int[] getArrayRandom(int[] a, int max) {  //вспомогательный метод заполнения массива случайными числами

        Random random = new Random();
        for (int i = 0; i<a.length; i++)
            a[i] = random.nextInt(max);
        return(a);
    }

    static void showArray(int[] a){   //вспомогательный метод вывода массива

        for (int i = 0; i<a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }

    static int[] changeBinary(int[] a) {   //задание 1

        for (int i = 0; i < a.length; i++)
            switch (a[i]) {
                case 0:
                    a[i] = 1;
                    break;
                case 1:
                    a[i] = 0;
                    break;
            }
        return(a);
    }

    static int[] getSpecificArray(int[] a) {   //задание 2

        for (int i = 0; i < a.length; i++)
            a[i] = i*3 + 1;
        return(a);
    }

    static int[] multiplyLesserElements(int[] a, int ex) {   //задание 3

        for (int i = 0; i < a.length; i++)
            if (a[i] < 6) {
                a[i] = a[i]*2;
            }
        return(a);
    }

    static int getMin(int[] a) {   //задание 4, минимум

        int min = a[0];
        for (int i = 0; i < a.length; i++)
            if (a[i] < min) {
                min = a[i];
            }
        return(min);
    }

    static int getMax(int[] a) {   //задание 4, максимум

        int max = a[0];
        for (int i = 0; i < a.length; i++)
            if (a[i] > max) {
                max = a[i];
            }
        return(max);
    }

    static void getMatrix(int[][] a, int N) {   //задание 5

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                a[i][j] = ((i == j) || ((i + j) == (N - 1))) ? 1 : 0;   //попробовал тернарный оператор
                System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
    }

    static int[] arrayShift(int[] a, int userShift) {

        int shift = userShift % a.length;   //если сдвиг по модулю больше длины массива, то реальный сдвиг будет равен остатку от деления
        switch (Integer.signum(userShift)) {
            case 1:
                for (int i = 0; i<shift; i++) {
                    int temp = a[0];
                    a[0] = a[a.length-1];
                    for (int j = 1; j<a.length-1; j++) {
                        a[a.length-j]=a[a.length-j-1];
                    }
                    a[1]=temp;
                }
                break;
            case -1:
                for (int i = 0; i>shift; i--) {
                    int temp = a[a.length-1];
                    a[a.length-1] = a[0];
                    for (int j = 1; j<a.length-1; j++) {
                        a[j-1]=a[j];
                    }
                    a[a.length-2]=temp;
                }
                break;
        }
        return a;
    }
}