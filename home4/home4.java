package home4;


import java.util.ArrayList;

class Calculator {

    ArrayList<Integer> results = new ArrayList<>();
    public int calculate(char op, int a, int b) {
        int res = -1;
        switch (op) {
            case '-':
                results.add(a - b);
                res = results.get(results.size() - 1);
                break;
            case '+':
                results.add(a + b);
                res = results.get(results.size() - 1);
                break;
            case '*':
                results.add(a * b);
                res = results.get(results.size() - 1);
                break;
            case '/':
                results.add(a / b);
                res = results.get(results.size() - 1);
                break;
            case '<':
                res = results.get(results.size() - 2);
                break;
        }
        return res;
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class home4 {
    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 13;
            op = '+';
            b = 7;
            c = 14;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
        int result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        int prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);
    }
}


