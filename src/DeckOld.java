import java.util.Random;

public class DeckOld {
    boolean[] exists = new boolean[36];

    {
        for (int i = 0; i < 36; i++) {
            exists[i] = true;
        }
    }

    int getId() {
        Random r = new Random();
        while (true) {
            int id = r.nextInt(0, 36);
            boolean ex = exists[id];
            if (ex) {
                exists[id] = false;
                return id;
            }
        }
    }

    Card getCard() {
        int id = getId();
//        Card card = cards[id];
        int suitId = id / 9;
        String suit = switch (suitId){
            case 0 -> "♠";
            case 1 -> "♠";
            case 2 -> "♦";
            default -> "♥";
        };

        int rankId = id % 9;
        String rank = switch (rankId){
            case 0 -> " 6";
            case 1 -> " 7";
            case 2 -> " 8";
            case 3 -> " 9";
            case 4 -> "10";
            case 5 -> " Т";
            case 6 -> " В";
            case 7 -> " Д";
            default -> " К";
        };

        int points;
        switch (rankId){
            case 0 -> {
                points = 6;
            }
            case 1 -> points = 7;
            case 2 -> points = 8;
            case 3 -> points = 9;
            case 4 -> points = 10;
            case 5 -> points = 1;
            case 6 -> points = 2;
            case 7 -> points = 3;
            default -> points = 4;
        };


        Card card = new Card(suit, rank, points);
        return card;
    }

//    private Card[] cards = {
//            new Card("♠", " 6", 6),
//            new Card("♠", " 7", 7),
//            new Card("♠", " 8", 8),
//            new Card("♠", " 9", 9),
//            new Card("♠", "10", 10),
//            new Card("♠", " Т", 1),
//            new Card("♠", " В", 2),
//            new Card("♠", " Д", 3),
//            new Card("♠", " К", 4),
//            new Card("♣", " 6", 6),
//            new Card("♣", " 7", 7),
//            new Card("♣", " 8", 8),
//            new Card("♣", " 9", 9),
//            new Card("♣", "10", 10),
//            new Card("♣", " Т", 1),
//            new Card("♣", " В", 2),
//            new Card("♣", " Д", 3),
//            new Card("♣", " К", 4),
//            new Card("♦", " 6", 6),
//            new Card("♦", " 7", 7),
//            new Card("♦", " 8", 8),
//            new Card("♦", " 9", 9),
//            new Card("♦", "10", 10),
//            new Card("♦", " Т", 1),
//            new Card("♦", " В", 2),
//            new Card("♦", " Д", 3),
//            new Card("♦", " К", 4),
//            new Card("♥", " 6", 6),
//            new Card("♥", " 7", 7),
//            new Card("♥", " 8", 8),
//            new Card("♥", " 9", 9),
//            new Card("♥", "10", 10),
//            new Card("♥", " В", 2),
//            new Card("♥", " Д", 3),
//            new Card("♥", " К", 4),
//            new Card("♥", " Т", 1),
//    };

    // todo вынести получение масти, ранга и очков карты в отдельные функции


}
