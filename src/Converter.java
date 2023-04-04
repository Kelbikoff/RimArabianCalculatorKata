import java.util.Arrays;
import java.util.List;

class Converter {

    private Converter(){}

    private static final List<String> ROMAN_NUMERALS = Arrays.asList("", "I", "II", "III", "IV", "V",
            "VI", "VII", "VIII", "IX", "X");

    private static int fromRoman(String s) {
        int n = ROMAN_NUMERALS.indexOf(s);
        if (n == -1) {
            throw new IllegalArgumentException("Неверное римское число");
        }
        return n;
    }

    public static String intToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Число должно быть от 1 до 3999 включительно");
        }
        StringBuilder sb = new StringBuilder();
        int thousands = number / 1000;
        sb.append("M".repeat(thousands));
        number -= thousands * 1000;

        int hundreds = number / 100;
        sb.append(toRomanDigit(hundreds, "C", "D", "M"));
        number -= hundreds * 100;

        int tens = number / 10;
        sb.append(toRomanDigit(tens, "X", "L", "C"));
        number -= tens * 10;

        sb.append(toRomanDigit(number, "I", "V", "X"));
        return sb.toString();
    }

    private static String toRomanDigit(int n, String one, String five, String ten) {
        if (n == 9) {
            return one + ten;
        } else if (n >= 5) {
            return five + one.repeat(n - 5);
        } else if (n == 4) {
            return one + five;
        } else {
            return one.repeat(n);
        }
    }

    static int parseNumber(String number) {
        if (isRoman(number)) {
            return fromRoman(number);
        }

        try {
            int n = Integer.parseInt(number);
            if (n < 1 || n > 10) {
                throw new IllegalArgumentException("Число должно быть от 1 до 10 включительно");
            }
            return n;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(number + " не является целым числом!", e);
        }
    }

    public static boolean isSimilarTypes(String a, String b) {
        boolean aIsRoman = isRoman(a);
        boolean bIsRoman = isRoman(b);
        return (!aIsRoman && !bIsRoman) || (aIsRoman && bIsRoman);
    }

    static boolean isRoman(String s) {
        return s.matches("[IVX]+");
    }
}
