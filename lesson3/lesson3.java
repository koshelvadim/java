package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class lesson3 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("1", "2", "2", "4", "3", "1", "4", "5", "2"));
        countAndPrint(strings);
        removeDuplicates(strings);
        System.out.println(strings);

    }

    /**
     * Вывести статистику повторений внутри списка
     * "1", "2", "2", "4", "3", "1", "4", "5", "2"
     * "1" -> 2
     * "2" -> 3
     * "3" -> 1
     * "4" -> 2
     * "5" -> 1
     */
    private static void countAndPrint(ArrayList<String> strings) {
        // "1" -> 2
        // "2" -> 3

        ArrayList<String> unique = new ArrayList<>();

        for (int i = 0; i < strings.size(); i++) { // [0, size)
            String element = strings.get(i);
            if (unique.contains(element)) {
                continue;
            }

            int counter = 1;
            for (int j = i + 1; j < strings.size(); j++) { // [i + 1, size)
                String another = strings.get(j);
                if (element.equals(another)) {
                    counter++;
                }
            }
            System.out.println(element + " - " + counter);
            unique.add(element);
        }
    }

    /**
     * Удалить из списка убрать дубликаты
     * "1", "2", "2", "4", "3", "1", "4", "5", "2" -> "1", "2", "4", "3", "5"
     */
    private static void removeDuplicates(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String element = strings.get(i);
            for (int j = i + 1; j < strings.size(); j++) {
                String another = strings.get(j);
                if (element.equals(another)) {
                    strings.remove(j--);
                }
            }
        }
    }

    /**
     * Есть список строк, в котором могут быть целые числа. Их нужно удалить.
     * "first", "1", "-2", "second", "third", "5" -> "first", "second", "third"
     */
    private static void removeIntegers(List<String> strings) {
//        strings.removeIf(it -> isInteger(it));

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (isInteger(element)) {
                iterator.remove();
            }
        }

//        for (int i = 0; i < strings.size(); i++) {
//            String element = strings.get(i);
//            if (isInteger(element)) {
//                strings.remove(i--);
//            }
//        }
    }

    private static boolean isInteger(String str) {
//        int first = 0;
//        if (str.charAt(0) == '-') {
//            if (str.length() == 1) {
//                return false;
//            }
//            first = 1;
//        }
//
//        for (int i = first; i < str.length(); i++) {
//            if (!Character.isDigit(str.charAt(i))) {
//                return false;
//            }
//        }
//        return true;

//        return str.matches("[-]{0,1}\\d+");

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

