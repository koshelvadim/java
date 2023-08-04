package lesson4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class lesson4 {
    public static void main(String[] args) {


        // Реализовать консольное приложение, которое принимает строки и запоминает их.
        // Если введено print, то нужно вывести в консоль строки так, что последняя введеная является первой в списке
        // Если введено revert, то удаляем последнюю введную строку
        // java
        // python
        // c#
        // print -> [c#, python, java]
        // revert
        // print -> [python, java]

        Scanner scanner = new Scanner(System.in);
        Deque<String> storage = new ArrayDeque<>();
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equals(input)) {
                break;
            }
            if ("print".equals(input)) {
                System.out.println(storage);
            } else if ("revert".equals(input)) {
                storage.pollFirst();
            } else {
                storage.addFirst(input);
            }
        }
        System.out.println("Программа завершена");
    }
}
