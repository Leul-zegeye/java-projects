public class CardDeckDemo {

    enum Suit {
        SPADES("Black"), HEARTS("Red"), CLUBS("Black"), DIAMONDS("Red");

        private final String color;

        Suit(String color) { this.color = color; }
        public String getColor() { return color; }
    }

    enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    static class Card {
        private final Suit suit;
        private final Rank rank;

        Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public Suit getSuit() { return suit; }
        public Rank getRank() { return rank; }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }

    public static void main(String[] args) {
        // Create and print several cards
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.QUEEN);

        System.out.println(card1 + " (color: " + card1.getSuit().getColor() + ")");
        System.out.println(card2 + " (color: " + card2.getSuit().getColor() + ")");

        // Compare two suits with compareTo() and show ordinal values
        System.out.println("SPADES.compareTo(HEARTS) = " + Suit.SPADES.compareTo(Suit.HEARTS));
        System.out.println("SPADES.ordinal() = " + Suit.SPADES.ordinal());

        // Print all cards in a 52-card deck
        Card[] deck = new Card[52];
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck[i++] = new Card(suit, rank);
            }
        }
        System.out.println();
        for (Card c : deck) {
            System.out.println(c + " (color: " + c.getSuit().getColor() + ")");
        }
    }
}
