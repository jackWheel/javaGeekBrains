package ru.tsipper.lesson1;

import java.util.Scanner;

public class Task1 {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.println("Task 1. Calculate (a*(b+(c/d))");
        System.out.print("Input a: ");
        int a = in.nextInt();
        System.out.print("Input b: ");
        int b = in.nextInt();
        System.out.print("Input c: ");
        int c = in.nextInt();
        System.out.print("Input d: ");
        int d = in.nextInt();
        getEq(a,b,c,d);

        System.out.println("Task 2. Return TRUE if 10<=a+b<=20. Otherwise return FALSE");
        System.out.print("Input first number: ");
        a = in.nextInt();
        System.out.print("Input first number: ");
        b = in.nextInt();
        check20(a,b);

        System.out.println("Task 3. Return sign of a number.");
        System.out.print("Input number: ");
        a = in.nextInt();
        getSign(a);

        System.out.println("Task 4. Print 'Hello, %username%!'");
        System.out.print("Input username: ");
        String name = in.next();
        helloName(name);

        System.out.println("Task 5. Check if year is leap.");
        System.out.print("Input year: ");
        a = in.nextInt();
        isYearLeap(a);
    }


    static void getEq(int a1, int b1, int c1, int d1) {

        float res = (a1 * (b1 + (c1 / d1)));
        System.out.println("Result: " + res);
    }

    static void check20 (int x, int y) {

        int sum = x + y;
        boolean sumCheck = (sum>=10) && (sum<=20);
        System.out.println("It's " + sumCheck);
    }

    static void getSign(int num) {

        if (num<0){
            System.out.println("Negative");
        }
        else{
            System.out.println("Positive");
        }
    }

    static void helloName(String name) {

        System.out.println("Hello, "+name+"!");
    }

    static void isYearLeap (int year) {

        if ((year % 400) == 0) {
            System.out.println("It's leap year");
        }
        else{
            if (((year % 100) != 0)&&((year % 4) ==0)) {
                System.out.println("It's leap year");
            }
            else{
                System.out.println("It's NOT leap year");
            }
        }
    }
}