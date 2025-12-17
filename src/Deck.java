import java.util.Random;

public class Deck {
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

/*    Card getCard() {
        int id = get();
        Card card = cards[id];
        return card;
    }

    private Card[] cards = {
            new Card("♠", " 6", 6),
            new Card("♠", " 7", 7),
            new Card("♠", " 8", 8),
            new Card("♠", " 9", 9),
            new Card("♠", "10", 10),
            new Card("♠", " Т", 1),
            new Card("♠", " В", 2),
            new Card("♠", " Д", 3),
            new Card("♠", " К", 4),
            new Card("♣", " 6", 6),
            new Card("♣", " 7", 7),
            new Card("♣", " 8", 8),
            new Card("♣", " 9", 9),
            new Card("♣", "10", 10),
            new Card("♣", " Т", 1),
            new Card("♣", " В", 2),
            new Card("♣", " Д", 3),
            new Card("♣", " К", 4),
            new Card("♦", " 6", 6),
            new Card("♦", " 7", 7),
            new Card("♦", " 8", 8),
            new Card("♦", " 9", 9),
            new Card("♦", "10", 10),
            new Card("♦", " Т", 1),
            new Card("♦", " В", 2),
            new Card("♦", " Д", 3),
            new Card("♦", " К", 4),
            new Card("♥", " 6", 6),
            new Card("♥", " 7", 7),
            new Card("♥", " 8", 8),
            new Card("♥", " 9", 9),
            new Card("♥", "10", 10),
            new Card("♥", " В", 2),
            new Card("♥", " Д", 3),
            new Card("♥", " К", 4),
            new Card("♥", " Т", 1),
    };*/


    Card getCard() {
        int cardId = getId();

        String cardSuit = getSuit(cardId);

        String cardRank = getRank(cardId);

        int cardPoints = getCardPoints(cardId);

        Card card = new Card(cardSuit, cardRank, cardPoints);

        return card;
    }

    private static int getCardPoints(int cardId) {
        int cardPointsId = cardId % 9;
        int cardPoints = switch (cardPointsId) {
            case 0 -> 6;
            case 1 -> 7;
            case 2 -> 8;
            case 3 -> 9;
            case 4 -> 10;
            case 5 -> 1;
            case 6 -> 2;
            case 7 -> 3;
            default -> 4;
        };
        return cardPoints;
    }

    private static String getSuit(int cardId) {
        int cardSuitId = cardId / 9;
        String cardSuit = switch (cardSuitId) {
            case 0 -> "♠";
            case 1 -> "♣";
            case 2 -> "♦";
            default -> "♥";
        };
        return cardSuit;
    }

    private static String getRank(int cardId) {
        int rankId = cardId % 9;
        String cardRank = switch (rankId) {
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
        return cardRank;
    }


}
