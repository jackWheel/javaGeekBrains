package ru.tsipper.lesson5;   //замечание - из-за особенности сложения чисел с плавающей запятой
                              //пришлось рандомизацию делать в целых числах, после делить на 10 или 100,
import java.util.Random;      //и лишь потом приводить это к типу double
import java.util.Scanner;

public abstract class Animal {

    public String species;
    public String name;
    public int runRestriction;
    public int swimRestriction;
    public double jumpRestriction;


    public abstract void run(int a);
    public abstract void swim(int a);
    public abstract void jump(double a);

    public void getAnimal() {   //вывод информации о животном
        System.out.println();
        System.out.println("Вид: "+this.species);
        System.out.println("Кличка: "+this.name);
        System.out.println("Максимальная дистанция бега: "+this.runRestriction+" м.");
        System.out.println("Максимальная дистанция плавания: "+this.swimRestriction+" м.");
        System.out.println("Максимальная высота прыжка: "+this.jumpRestriction+" м.");
        System.out.println();
    }

    public void setMove() {   //выбор действия для животного
        Scanner in = new Scanner(System.in);
        int selector=0;
        do {
            System.out.println("Какое действие должно выполнить животное?");
            System.out.println("1. Бежать.");
            System.out.println("2. Плыть.");
            System.out.println("3. Прыгать.");
            System.out.print("Введите соответствующую цифру: ");
            selector = in.nextInt();
            switch (selector) {
                case 1:
                    System.out.print("Введите дистанцию бега: ");
                    int run = in.nextInt();
                    this.run(run);
                    break;
                case 2:
                    System.out.print("Введите дистанцию плавания: ");
                    int swim = in.nextInt();
                    this.swim(swim);
                    break;
                case 3:
                    System.out.print("Введите высоту прыжка: ");
                    String jumpTemp = in.next().replace(",",".");  //танцы с бубном, чтобы можно было вводить и с запятой как разделитель
                    double jump = Double.parseDouble(jumpTemp);
                    this.jump(jump);
                    break;
                default:
                    System.out.println("Ошибка! Повторите ввод");
                    System.out.println();
                    selector = 0;
                    break;
            }
        } while (selector == 0);
    }
 }

class Dog extends Animal {

    public Dog(String name) {

        Random random = new Random();

        this.species = "Собака";
        this.name = name;
        this.runRestriction = random.nextInt(5)*100+300;   //ограничение бега собаки варьируется от 300 до 700
        this.swimRestriction = random.nextInt(5)+8;   //ограничение плавание собаки от 8 до 12
        this.jumpRestriction = (double) (random.nextInt(5)+3)/10;   ///ограничение прыжка лошади от 0.3 до 0.7
    }

    @Override
    public void run(int a) {
        System.out.println();
        if (a<=this.runRestriction) {
            System.out.println("Пёсель "+this.name+" успешно пробежал(а) дистанцию.");
        }
        else {
            System.out.println("Пёсель "+this.name+" не смог(ла) пробежать дистанцию.");
        }
        System.out.println();
    }

    @Override
    public void swim(int a) {
        System.out.println();
        if (a<=this.swimRestriction) {
            System.out.println("Пёсель "+this.name+" успешно проплыл(а) дистанцию.");
        }
        else {
            System.out.println("Пёсель "+this.name+" не смог(ла) проплыть дистанцию.");
        }
        System.out.println();
    }

    @Override
    public void jump(double a) {
        System.out.println();
        if (a<=this.jumpRestriction) {
            System.out.println("Пёсель "+this.name+" успешно подпрыгнул(а).");
        }
        else {
            System.out.println("Пёсель "+this.name+" не смог(ла) подпрыгнуть так высоко.");
        }
        System.out.println();
    }
}

class Horse extends Animal {

    public Horse(String name) {

        Random random = new Random();

        this.species = "Лошадь";
        this.name = name;
        this.runRestriction = random.nextInt(5)*100+1300;   //ограничение бега лошади варьируется от 1300 до 1700
        this.swimRestriction = random.nextInt(5)*10+80;   //ограничение плавание лошади от 80 до 120
        this.jumpRestriction = (double)(random.nextInt(11)+25)/10;   ///ограничение прыжка лошади от 2.5 до 3.5
    }

    @Override
    public void run(int a) {
        System.out.println();
        if (a<=this.runRestriction) {
            System.out.println("Коняшка "+this.name+" успешно пробежал(а) дистанцию.");
        }
        else {
            System.out.println("Коняшка "+this.name+" не смог(ла) пробежать дистанцию.");
        }
        System.out.println();
    }

    @Override
    public void swim(int a) {
        System.out.println();
        if (a<=this.swimRestriction) {
            System.out.println("Коняшка "+this.name+" успешно проплыл(а) дистанцию.");
        }
        else {
            System.out.println("Коняшка "+this.name+" не смог(ла) проплыть дистанцию.");
        }
        System.out.println();
    }

    @Override
    public void jump(double a) {
        System.out.println();
        if (a<=this.jumpRestriction) {
            System.out.println("Коняшка "+this.name+" успешно подпрыгнул(а).");
        }
        else {
            System.out.println("Коняшка "+this.name+" не смог(ла) подпрыгнуть так высоко.");
        }
        System.out.println();
    }
}

class Bird extends Animal {

    public Bird(String name) {

        Random random = new Random();

        this.species = "Птица";
        this.name = name;
        this.runRestriction = random.nextInt(5)+3;   //ограничение бега птицы варьируется от 3 до 7
        this.swimRestriction = 0;   //ограничение плавание птицы равно нулю
        this.jumpRestriction = (double)(random.nextInt(16)+10)/100;   ///ограничение прыжка птицы от 0.1 до 0.25
    }

    @Override
    public void run(int a) {
        System.out.println();
        if (a<=this.runRestriction) {
            System.out.println("Птыц "+this.name+" успешно пробежал(а) дистанцию.");
        }
        else {
            System.out.println("Птыц "+this.name+" не смог(ла) пробежать дистанцию.");
        }
        System.out.println();
    }

    @Override
    public void swim(int a) {
        System.out.println();
        System.out.println("Птыц "+this.name+" не очень хорошо плавает, как и другие его/её сородичи.");
        System.out.println();
    }

    @Override
    public void jump(double a) {
        System.out.println();
        if (a<=this.jumpRestriction) {
            System.out.println("Птыц "+this.name+" успешно подпрыгнул(а).");
        }
        else {
            System.out.println("Птыц "+this.name+" не смог(ла) подпрыгнуть так высоко.");
        }
        System.out.println();
    }
}

class Cat extends Animal {

    public Cat(String name) {

        Random random = new Random();

        this.species = "Кот";
        this.name = name;
        this.runRestriction = random.nextInt(11)*10+150;   //ограничение бега кота варьируется от 150 до 250
        this.swimRestriction = 0;   //ограничение плавание кота равно нулю
        this.jumpRestriction = (double) (random.nextInt(16)+15)/10;   ///ограничение прыжка кота от 1.5 до 3.0
    }

    @Override
    public void run(int a) {
        System.out.println();
        if (a<=this.runRestriction) {
            System.out.println("Котэ "+this.name+" успешно пробежал(а) дистанцию.");
        }
        else {
            System.out.println("Котэ "+this.name+" не смог(ла) пробежать дистанцию.");
        }
        System.out.println();
    }

    @Override
    public void swim(int a) {
        System.out.println();
        System.out.println("Котэ "+this.name+" не очень хорошо плавает, как и другие его/её сородичи.");
        System.out.println();
    }

    @Override
    public void jump(double a) {
        System.out.println();
        if (a<=this.jumpRestriction) {
            System.out.println("Котэ "+this.name+" успешно подпрыгнул(а).");
        }
        else {
            System.out.println("Котэ "+this.name+" не смог(ла) подпрыгнуть так высоко.");
        }
        System.out.println();
    }
}

class task5{
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.println("Урок 5. Наследование классов на примере животных.");
        System.out.println("При каждом новом запуске программы параметры животных будут рандомизироваться.");
        System.out.println();

        System.out.print("Введите имя собаки: ");
        String dogName = in.next();
        System.out.print("Введите имя лошади: ");
        String horseName = in.next();
        System.out.print("Введите имя птицы: ");
        String birdName = in.next();
        System.out.print("Введите имя кота: ");
        String catName = in.next();

        Animal beastDog = new Dog(dogName);
        Animal beastHorse = new Horse(horseName);
        Animal beastBird = new Bird(birdName);
        Animal beastCat = new Cat(catName);

        System.out.println("Животные успешно созданы!");

        beastDog.getAnimal();
        System.out.println("Работа с собакой.");
        beastDog.setMove();

        beastHorse.getAnimal();
        System.out.println("Работа с лошадью.");
        beastHorse.setMove();

        beastBird.getAnimal();
        System.out.println("Работа с птицей.");
        beastBird.setMove();

        beastCat.getAnimal();
        System.out.println("Работа с котом.");
        beastCat.setMove();

    }


}
