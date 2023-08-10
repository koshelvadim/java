package home5;

import java.util.*;

/** ЗАДАЧА
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
public class home5 {
    public static void main(String[] args) {
        String text = "Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы выполнить тестовое задание GB. " +
                "Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.";

        String regex1 = "[^а-яА-Яa-zA-z -]";
        String regex2 = "[^а-яА-Яa-zA-z ]";

        System.out.println("Исходный текст:\n" + text);
        String[] textArray1 = textRegs(text, regex1);
        ArrayList<String> arrayList1 = getNoRepite(textArray1);
        System.out.println("С учетом дефиса:");
        getMapCollection(arrayList1);

        String[] textArray2 = textRegs(text, regex2);
        ArrayList<String> arrayList2 = getNoRepite(textArray2);
        System.out.println("Без учета дефиса:");
        getMapCollection(arrayList2);
    }

    public static String[] textRegs(String text, String regex){
        String[] textArray = text.toLowerCase().replaceAll(regex, "").split(" ");
        return textArray;
    }

    public static ArrayList<String> getNoRepite(String[] textArray) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(textArray));
        ArrayList<String> newList = new ArrayList<>();

        for (String element : arrayList) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public static void getMapCollection(ArrayList<String> arrayList) {
        Map<Integer, List<String>> newMap = new HashMap<>();

        for (String str : arrayList) {
            int key = str.length();
            newMap.computeIfAbsent(key, value -> new ArrayList<>()).add(str);
        }
        System.out.println(newMap);
    }
}

