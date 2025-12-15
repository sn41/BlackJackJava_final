import java.util.Random;

public class Deck {
    boolean[] exists = new boolean[36];

    {
        for (int i = 0; i<36;i++){
            exists[i] = true;
        }
    }

    int get(){
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

    Card getCard(){
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
            new Card("♣", " 6"),
            new Card("♣", " 7"),
            new Card("♣", " 8"),
            new Card("♣", " 9"),
            new Card("♣", "10"),
            new Card("♣", " В"),
            new Card("♣", " Д"),
            new Card("♣", " К"),
            new Card("♣", " Т"),
            new Card("♦", " 6"),
            new Card("♦", " 7"),
            new Card("♦", " 8"),
            new Card("♦", " 9"),
            new Card("♦", "10"),
            new Card("♦", " В"),
            new Card("♦", " Д"),
            new Card("♦", " К"),
            new Card("♦", " Т"),
            new Card("♥", " 6"),
            new Card("♥", " 7"),
            new Card("♥", " 8"),
            new Card("♥", " 9"),
            new Card("♥", "10"),
            new Card("♥", " В"),
            new Card("♥", " Д"),
            new Card("♥", " К"),
            new Card("♥", " Т"),
    };


}
