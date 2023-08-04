package home5;

import java.util.*;

public class home5 {
    public static void main(String[] args) {
        String text = "Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы выполнить тестовое задание GB. " +
                "Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.";

        System.out.println(text);
        printStats(text);
    }

    static void printStats(String text) {
        String[] textArray1 = text.toLowerCase().replaceAll("[^а-яА-Яa-zA-z ]", "").split(" ");
        String[] textArray2 = text.toLowerCase().replaceAll("[^а-яА-Яa-zA-z -]", "").split(" ");

        // создаем массив слов
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(textArray1));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(textArray2));

        // избавляемся от повторений слов в массиве
        ArrayList<String> newList1 = new ArrayList<>();
        ArrayList<String> newList2 = new ArrayList<>();

        for (String element : arrayList1) {
            if (!newList1.contains(element)) {
                newList1.add(element);
            }
        }
        for (String element : arrayList2) {
            if (!newList2.contains(element)) {
                newList2.add(element);
            }
        }

        // создаем коллекцию мап: ключ - количество букв в слове, значение - слова
        Map<Integer, List<String>> newMap1 = new HashMap<>();
        Map<Integer, List<String>> newMap2 = new HashMap<>();

        for (String str : newList1) {
            int key = str.length();
            newMap1.computeIfAbsent(key, value -> new ArrayList<>()).add(str);
        }
        for (String str : newList2) {
            int key = str.length();
            newMap2.computeIfAbsent(key, value -> new ArrayList<>()).add(str);
        }

        System.out.println(newMap1);
        System.out.println(newMap2);
    }
}

/**
 * Дан текст. Нужно отсортировать слова по длине (по возрастанию) и вывести статистику на экран.
 * Регистр слова не имеет значения. Формат вывода произвольный.
 * Программа-минимум:
 * 1. Слова, состоящие из дефисов, считаем одним словом. Т.е. каких-то - одно слово из 8 символов.
 * 2. Точки и запятые не должны входить в статистику.
 * <p>
 * Доп. задание
 * 1. * Не включать дефис в длину слова. Т.е. каких-то - одно слово из 7 символов.
 * <p>
 * Пример:
 * <p>
 * Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы выполнить тестовое задание GB.
 * Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.
 * <p>
 * 1 -> [и, в]
 * 2 -> [он, из, gb, не]
 * 3 -> [мой, для]
 * 4 -> [слов, того, себе]
 * 5 -> [текст, нужен, чтобы, несет, набор]
 * ...
 */
