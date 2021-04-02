package ru.tsipper.lesson4;

public class Employee {

    public String initials;
    public String position;
    public String phone;
    public int salary;
    public byte age;
    private static byte No_initial = 1;
    private final byte No;

    public Employee(String initials, String position, String phone, int salary, byte age) {

        this.initials = initials;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.No = No_initial++;
    }

    public String getInitials() {

        return initials;
    }

    public String getPosition() {

        return position;
    }

    public String getPhone() {

        return phone;
    }

    public int getSalary() {

        return salary;
    }

    public byte getAge() {

        return age;
    }

    public byte getNo() {

        return No;
    }
}

class Task4{
    public static void main(String args[]) {

        Employee[] list = new Employee[5];   //буду работать с массивом по всем заданиям

        list[0] = new Employee("Вассерман О.У.","хранитель Интернетов","127001",90001,(byte) 66);
        list[1] = new Employee("Одмен О.О.","сисоп","255255255255",15678,(byte) 38);
        list[2] = new Employee("Шрёдер","офисная техника","1",1,(byte) 2);
        list[3] = new Employee("Васька","штатный котэ","n/a",10000, (byte) 3);
        list[4] = new Employee("Имярек И.И.","старший помощник младшей технички","88005553535",15000, (byte) 55);

        System.out.println("Задание 4. Вывести ФИО и должность (и порядковый номер из задания 7).");

        for (int i=0; i<5; i++) {
            System.out.println();
            System.out.println("Имя: " + list[i].getInitials());
            System.out.println("Должность: " + list[i].getPosition());
            System.out.println("Порядковый номер: " + list[i].getNo());
            System.out.println();
        }

        System.out.println("Задание 5. Вывести информацию о сотрудниках старше 40.");

        for (int i=0; i<5; i++) {
            if (list[i].age>40) {
                getEmployee(list[i]);
            }
        }

        System.out.println("Задание 6. Повысить зарплату сотрудникам старше 35 на 10000.");
        raiseSalary35(list);

        System.out.println("Результат выполнения:");
        for (int i=0; i<5; i++) {
            getEmployee(list[i]);
        }

    }

    static void getEmployee(Employee a) {    //вспомогательный метод вывода элементов массива
        System.out.println();
        System.out.println("Имя: " + a.getInitials());
        System.out.println("Должность: " + a.getPosition());
        System.out.println("Номер: " + a.getPhone());
        System.out.println("Зарплата: " + a.getSalary() + " руб.");
        System.out.println("Возраст: " + a.getAge());
        System.out.println("Порядковый номер: " + a.getNo());
        System.out.println();
    }

    static Employee[] raiseSalary35(Employee[] a) { //изменение зарплаты для задания 6
        for (int i=0; i<5; i++) {
            if (a[i].age > 35) {
                a[i].salary = a[i].salary + 10000;
            }
        }
    return a;
    }

}





