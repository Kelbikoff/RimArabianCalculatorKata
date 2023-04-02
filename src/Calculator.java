import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {

        System.out.println("Ввод:");
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        String[] sign = {"+", "-", "/", "*"};
        String[] signIn = {"\\+", "-", "/", "\\*"};
        int test = -1;
        for (int i = 0; i < sign.length; i++) {
            if(scan.contains(sign[i])){
                test = i;
                break;
            }
        }

        if(test==-1) {
            System.out.println("Введите корректное выражение");
            return;
        }

        String[] data = scan.split(signIn[test]);
        if(converter.number(data[0]) == converter.number(data[1])){

            int a,b;
            if(converter.number(data[0])==false){


                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }else{
                a=converter.romanToInt(data[0]);
                b=converter.romanToInt(data[1]);
            }
            int result;
            switch (sign[test]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "/":
                    result = a/b;
                    break;
                default:
                    result = a*b;
                    break;

            }
            if(converter.number(data[0])==false) {
                System.out.println(result);
            } else {
                // System.out.println(result);

                if (result >= 0) {


                    System.out.println(converter.intToRoman(result));
                }else{
                    System.out.println("Ошибка: в римской системе нет отрицательных чисел");
                }
            }
        }else{
            System.out.println("Числа разного формата");
        }
    }
}
