import java.util.Scanner;


public class Calculator {
    static String[] sign = {"+", "-", "/", "*"};

    public static String calc(String input) {

        boolean containsSign = false;
        for (String s : sign) {
            if (input.contains(s)) {
                containsSign = true;
                break;
            }
        }

        if (!containsSign) {
            throw new IllegalArgumentException("Некорректный ввод! (Нет знака операции)");
        }

        String[] data = input.split(" ");
        if (data.length != 3) {
            throw new IllegalArgumentException("Некорректный ввод! (Неверное кол-во операндов)");
        }

        if (!Converter.isSimilarTypes(data[0], data[2])) {
            throw new IllegalArgumentException("Числа должны быть оба римскими или оба арабскими");
        }

        int a = Converter.parseNumber(data[0]);
        int b = Converter.parseNumber(data[2]);

        String operator = data[1];

        int result = switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Неверный оператор");
        };

        if (Converter.isRoman(data[0])) {
            if (result < 0) {
                throw new IllegalArgumentException("Результат римское отрицательное число");
            }
            return Converter.intToRoman(result);
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.print("Ввод:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(calc(input));
    }
}
