package ru.tsipper.lesson6;

import java.io.*;
import java.util.Random;

public class task6Files {
    public static void main(String args[]) {

        File file1 = new File("file1.txt");
        try
        {
            boolean created = file1.createNewFile();
            if(created) {
                System.out.println("Файл file1.txt создан.");
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        fillFile(file1);
        System.out.println("Файл file1.txt заполнен случайными символами.");

        File file2 = new File("file2.txt");
        try
        {
            boolean created = file2.createNewFile();
            if(created) {
                System.out.println("Файл fil2.txt создан.");
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        fillFile(file2);
        System.out.println("Файл file2.txt заполнен случайными символами.");

        File res = new File("fileFinal.txt");

        if (res.delete()) { ///удаляем результат предыдущей конкатенации
            try
            {
                res.createNewFile();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }

        concatFiles(file1, file2, res);
        System.out.println("Файлы конкатенированы в файл fileFinal.txt.");
    }

    static void fillFile(File file){  //заполнение случайными буквами латинского алфавита в количестве 75 штук

        Random random = new Random();

        try (FileWriter writer = new FileWriter(file, false)) {
            for (int i=0; i<75;i++){
                char c = (char)(random.nextInt(26)+'a');
                writer.append(c);
            }
            writer.flush();
        }
        catch(IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    static void concatFiles(File file1, File file2, File file3) {

        try(FileReader reader1 = new FileReader(file1)) {
            int temp;
            while((temp=reader1.read())!=-1){

                try(FileWriter writer = new FileWriter(file3, true)) {
                    writer.append((char)temp);
                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(FileReader reader2 = new FileReader(file2)) {
            int temp;
            while((temp=reader2.read())!=-1){

                try(FileWriter writer = new FileWriter(file3, true)) {
                    writer.append((char)temp);
                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}