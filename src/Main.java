public class Main {
    public static void main(String[] args){
//        System.out.println("1234567");
//        System.out.print("1234567");
//        clearScreen();
//        System.out.print("aaaaaaa");

//        Card.draw();
//        Card.draw("♠","10");
//        Card.draw("♦"," 8");
        
        Deck deck = new Deck();
        Card card = deck.getCard();
        card.draw();
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

