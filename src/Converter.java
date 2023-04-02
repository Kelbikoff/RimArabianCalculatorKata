import java.util.TreeMap;

public class Converter {

    TreeMap<Character, Integer> key = new TreeMap<>();
    public Converter() {
        key.put('I', 1);
        key.put('V', 5);
        key.put('X', 10); //
        key.put('L', 50);
        key.put('C', 100);
    }
    public int getArabian(char roman){
        if('I' == roman) return 1;
        else if('V' == roman) return 5;
        else if('X' == roman) return 10;
        else if('L' == roman) return 50;
        else if('C' == roman) return 100;

        return 0;
    }

    public String intToRoman(int number) {

        String[] romanThousands = {"", "M", "MM", "MMM"};
        String[] romanHundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] romanTens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] romanOnes = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return romanThousands[number / 1000] +
                romanHundreds[(number % 1000) / 100] +
                romanTens[(number % 100) / 10] +
                romanOnes[number % 10];

    }

    public int romanToInt(String s) {

        int end = s.length()-1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = getArabian(arr[end]);
        for (int i = end-1; i >=0; i--) {
            arabian = getArabian(arr[i]);

            if (arabian < getArabian(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;

    }
    public boolean number (String number){

        return key.containsKey(number.charAt(0));
    }



}

