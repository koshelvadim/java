package lesson5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lesson5 {
    public static void main(String[] args) {
        countAndPrint(List.of("1", "2", "2", "4", "3", "1", "4", "5", "2"));

        System.out.println(isIsomorphic("foo","bar"));
        System.out.println(isIsomorphic("abc","abc"));
        System.out.println(isIsomorphic("foo","bar"));
        System.out.println(isIsomorphic("foo","bar"));

    /**
     * Вывести статистику повторений внутри списка
     * "1", "2", "2", "4", "3", "1", "4", "5", "2"
     * "1" -> 2
     * "2" -> 3
     * "3" -> 1
     * "4" -> 2
     * "5" -> 1
     */

    }
    private static void countAndPrint(List<String> values) {
        Map<String, Integer> stats = new HashMap<>();
        for (String value : values) {
            if (stats.containsKey(value)) {
                Integer oldValue = stats.get(value); // старое значение
                stats.put(value, oldValue + 1);
            } else {
                stats.put(value, 1);
            }
        }
        System.out.println(stats);
    }
    /**
     * Проверить, что 2 строки являются изоморфными.
     * <p>
     * abc, abc -> true // a -> a, b -> b, c -> c
     * abc, bce -> true // a -> b, b -> c, c -> e
     * paper, title -> true // p -> t, a -> i, e -> l, r -> e
     * foo, bar -> false // f -> b, o -> a, o -> XXX
     * add, egg -> true // a -> e, d -> g
     * note, code -> true
     * abcde, aaaaa -> true // a, b, c, d, e -> a
     * aaaaa, abcde -> false //
     */
    private static boolean isIsomorphic(String first, String second) {
        // int -> Integer, char -> Character, long -> Long
        Map<Character, Character> mapping = new HashMap<>();

        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();
        if (firstChars.length != secondChars.length) {
            return false;
        }


        for (int i = 0; i < firstChars.length; i++) {
            char firstChar = firstChars[i];   // o
            char secondChar = secondChars[i]; // r

            if (mapping.containsKey(firstChar)) {
                Character prevChar = mapping.get(firstChar); // a
                if (prevChar != secondChar) {
                    return false;
                }
            } else {
                mapping.put(firstChar, secondChar);
            }
        }
        return true;
    }
}
