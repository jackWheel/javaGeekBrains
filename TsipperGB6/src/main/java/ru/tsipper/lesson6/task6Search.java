package ru.tsipper.lesson6;

import java.io.*;
import java.util.Scanner;

public class task6Search {  //пусть слово - это последовательность символов, отделенная от таких же
    public static void main(String args[]) {  // последовательностей пробелами,некоторыми знаками препинания
                                              // и символом конца строки.
        Scanner in = new Scanner(System.in);

        System.out.print("Введите слово для поиска: ");
        String example = in.next();

        File homeDir = new File("./2/");

        useDir(homeDir,example);
    }

    static void wordSearch(File file, String example) {

        String[] words;  //массив строк, который заполним сплитом
        int count = 0;  //счетчик

        try (FileReader reader = new FileReader(file)){
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while((line=buffer.readLine())!=null)
            {
                line = removePunctuation(line);
                words=line.split(" ");
                for (String word : words)
                {
                    if (word.equalsIgnoreCase(example))
                    {
                        count++;
                    }
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        if (count>0) {
            System.out.println("В файле "+file.getAbsolutePath()+" слово \""+example+"\" встречается "+count+" раз(а).");
        }
        else {
            System.out.println("В файле "+file.getAbsolutePath()+" слово \""+example+"\" не найдено.");
        }
    }

    static void useDir(File dir, String example){

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                useDir(file,example);  //рекурсивно проходим по подпапкам, если они есть
            }
            else {
                wordSearch(file,example);
            }
        }
    }

    static String removePunctuation(String str){  //немного сильного колдунства для удаления знаков препинания

        str = str.replace(".","");
        str = str.replace(",","");
        str = str.replace("!","");
        str = str.replace("?","");
        str = str.replace("(","");
        str = str.replace(")","");
        str = str.replace(":","");
        str = str.replace(";","");
        str = str.replace("\"","");
        str = str.replace("/","");
        str = str.replace("\\","");
        str = str.replace("@","");

        return str;
    }
}
