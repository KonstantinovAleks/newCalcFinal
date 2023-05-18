import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input:");
        Scanner reading = new Scanner(System.in);
        String expression = reading.nextLine();
        char sign = '0';
        String exception = "throws Exception";
        Calculator calculator = new Calculator();

        if (expression.contains(" + ")) {
            sign = '+';
        } else if (expression.contains(" - ")) {
            sign = '-';
        } else if (expression.contains(" * ")) {
            sign = '*';
        } else if (expression.contains(" / ")) {
            sign = '/';
        } else {
            System.out.println(exception);
            return;
        }

        String[] arrayExpression = expression.split("\"");

        if (arrayExpression.length == 4) {
            String str01 = arrayExpression[1];
            String str02 = arrayExpression[3];
            if ((str01.length()>10) || (str02.length()>10)) {
                System.out.println(exception);
                return;
            }
            System.out.println("Output:\n" + "\"" + calculator.calculator(str01, str02, sign) + "\"");
        } else if (arrayExpression.length == 3) {
            String str01 = arrayExpression[1];
            if (str01.length()>10) {
                System.out.println(exception);
                return;
            }
            String str02 = arrayExpression[2];
            String[] arrayStr02 = str02.split(" ");
            int num;
            try {
                num = Integer.parseInt(arrayStr02[2]);
            } catch (NumberFormatException e) {
                System.out.println(exception);
                return;
            }
            if ((num<1) || (num>10)) {
                System.out.println(exception);
                return;
            }
            System.out.println("Output:\n" + "\"" + calculator.calculator(str01, num, sign) + "\"");
        } else {
            System.out.println(exception);
        }
    }
}









