import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Deck deck = new Deck();
        Card card = deck.getCard();
        int points = card.points;
        card.draw();*/

        Deck deck = new Deck();
        Scanner s = new Scanner(System.in);
        int total = 0;

        int points = getCard(deck);
        total += points;

        while (true) {
            points = getCard(deck);
            total += points;
            if (total > 20) {
                break;
            } else {
                System.out.println("ЕЩЁ?");
                char answer = s.nextLine().toLowerCase().charAt(0);
                if (answer != 'y') {
                    break;
                } else {
                    clearScreen();
                }
            }
        }

        clearScreen();

        if (total == 21) {
            System.out.println("Вы выиграли!");
        } else if (total > 21) {
            System.out.println("Вы проиграли!");
        } else {
            System.out.println("Ваши очки = " + total);
        }


    }

    private static int getCard(Deck deck) {
        Card currentCard = deck.getCard();
        currentCard.draw();
        return currentCard.points;
    }


    /*
    * Для очистки консоли в Java и Kotlin для анимации используйте
    * ANSI-escape последовательности (\u001b[2J\u001b[H) для кросс-платформенной совместимости или
    * платформо-специфичные команды (cls для Windows, clear для Linux/macOS) через System.out.println() и Runtime.exec(), что позволяет быстро перерисовывать кадры в терминале.
    1. ANSI-escape последовательности (Рекомендуется)
    Этот метод работает в большинстве современных терминалов (Linux, macOS, Windows 10/11) и не зависит от команды ОС.
    \u001b[2J: Код для очистки всего экрана.
    \u001b[H: Код для перемещения курсора в верхний левый угол.
     */
    public static void clearScreen() {
        System.out.print("\u001b[2J\u001b[H");
        System.out.flush(); // Может быть полезен для принудительного сброса буфера?

        // Или можем использовать команды терминала ОС
        // PlatformClear.clearScreen();
    }
}

// Класс для вызова команды очистки экрана с использованием командной строки текущей ОС
class PlatformClear {
    public static void clearScreen() {
        // Получаем имя ОС
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                // Создаём команду терминала, которую выполним в потоке выполнения нашей программы
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Для Linux/macOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // main метод аналогичен предыдущему примеру
}

