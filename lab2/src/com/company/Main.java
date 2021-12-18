package com.company;

/*Создать объект класса Текстовый файл, используя классы Файл, Директория.
 Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.*/
public class Main {

    public static void main(String[] args) {
        Directory dir = new Directory("src/", "main");
        File file = new File("file1", dir);
        TextFile textfile = new TextFile("textfile1", dir);
        System.out.println(textfile.toString());
        textfile.addContent("12324567532");
        System.out.println(textfile.toString());
        textfile.deleteContent();
        System.out.println(textfile.toString());
        textfile.addContent("1234543243224");
        System.out.println(textfile.toString());
        textfile.addContent("dfbksjodfboubodusb");
        System.out.println(textfile.toString());
        textfile.rename("textfile2");
        System.out.println(textfile.toString());

    }
}
