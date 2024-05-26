import java.util.Scanner;

public class Main {

    public static String decodeString(String s, int[] i) {
        StringBuilder result = new StringBuilder();

        while (i[0] < s.length() && s.charAt(i[0]) != ']') {
            if (Character.isDigit(s.charAt(i[0]))) {   // Считываем число k
                int k = 0;
                while (i[0] < s.length() && Character.isDigit(s.charAt(i[0]))) {
                    k = k * 10 + (s.charAt(i[0]) - '0');
                    i[0]++;
                }
                i[0]++;   // Пропускаем '['
                String decodedString = decodeString(s, i);  // Декодируем содержимое внутри '[' и ']'
                i[0]++;   // Пропускаем ']'
                while (k-- > 0) {   // Добавляем декодированную строку k раз в результат
                    result.append(decodedString);
                }
            } else {   // Если текущий символ не цифра, добавляем его к результату
                result.append(s.charAt(i[0]++));
            }
        }
        return result.toString();
    }

    public static String decodeString(String s) {
        int[] i = {0};
        return decodeString(s, i);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string - ");
        String encoded = scanner.next();
        System.out.println("\nResult - " + decodeString(encoded));
        scanner.close();
    }
}
