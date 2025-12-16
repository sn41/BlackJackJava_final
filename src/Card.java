public class Card {
    String suit;
    String rank;
    int points;

    Card(String cardSuit, String cardRank, int cardPoints){
        suit = cardSuit;
        rank = cardRank;
        points = cardPoints;
    }

    public void draw() {
        String d = rank;
        String m = suit;
        System.out.println("┌────┐");
        System.out.println("│"+d+" "+m+"│");
        System.out.println("│    │");
        System.out.println("│ "+m+"  │");
        System.out.println("│    │");
        System.out.println("│"+m+" "+d+"│");
        System.out.println("└────┘");
    }
}
