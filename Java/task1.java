import java.util.Scanner;

public class HousePainting {

    // Рекурсивная функция для проверки возможности раскраски домов
    public static boolean canPaintHouses(int currentHouse, int[] colors, int N, int K) {
        // Базовый случай: если все дома раскрашены успешно
        if (currentHouse == N) {
            return true;
        }

        // Перебираем все доступные цвета для текущего дома
        for (int color = 1; color <= K; ++color) {
            // Проверяем условие, что цвет не должен повторяться ранее, чем через 2 дома
            if ((currentHouse < 2 || (colors[currentHouse - 2] != color)) && colors[currentHouse - 1] != color) {
                // Пробуем раскрасить текущий дом в данный цвет
                colors[currentHouse] = color;
                
                // Рекурсивно вызываем функцию для следующего дома
                if (canPaintHouses(currentHouse + 1, colors, N, K)) {
                    return true; // Если удалось успешно раскрасить остальные дома
                }
                
                // Откатываем изменения (backtrack), если не удалось раскрасить дома дальше
                colors[currentHouse] = 0;
            }
        }

        // Если не удалось найти подходящую раскраску
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество домов (N): ");
        int N = scanner.nextInt();
        System.out.print("Введите количество цветов (K): ");
        int K = scanner.nextInt();

        int[] colors = new int[N]; // Массив для хранения цветов домов

        // Проверяем возможность раскраски домов
        if (canPaintHouses(0, colors, N, K)) {
            System.out.println("Можно раскрасить дома с заданными условиями.");
            System.out.println("Раскраска домов:");
            for (int i = 0; i < N; ++i) {
                System.out.println("Дом " + (i + 1) + ": Цвет " + colors[i]);
            }
        } else {
            System.out.println("Невозможно раскрасить дома с заданными условиями.");
        }

        scanner.close();
    }
}
