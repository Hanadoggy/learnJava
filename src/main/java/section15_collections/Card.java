package section15_collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public record Card(Suit suit, String face, int rank) {

    enum Suit {CLUB, DIAMOND, HEART, SPADE;
        public static Suit getRandomSuit() {
            return values()[random.nextInt(Suit.values().length)];
        }
    }

    public static Comparator<Card> sortRankReversedSuit() {
        return Comparator.comparing(Card::rank).reversed().thenComparing(Card::suit);
    }

    private static Random random = new Random();
    private static final int SIZE = 13; // size of deck

    public static Card getNumericCard(Suit suit, int rank) {
        if (rank > 1 && rank < 11) {
            return new Card(suit, setFace(rank), rank);
        }
        System.out.println("Invalid Numeric card selected");
        return null;
    }

    public static Card getFaceCard(Suit suit, char alpha) {
        if ("JQKA".contains(Character.toString(alpha))) {
            int rank = "JQKA".indexOf(alpha) + 9;
            return new Card(suit, setFace(rank), rank);
        }
        System.out.println("Invalid Face card selected");
        return null;
    }

    public static List<Card> getStandardDeck() {
        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for (int i = 0; i < SIZE; i++) {
                deck.add(new Card(suit, setFace(i), i));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck, String description, int rows) {

        System.out.println("----------------");
        if (description != null) {
            System.out.println(description);
        }
        int cardsInRow = deck.size() / rows;
        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

    public static void printDeck(List<Card> deck) {
        printDeck(deck, "CurrentDeck", 4);
    }

    private static String setFace(int rank) {
        return switch (rank) {
            case 0, 1, 2, 3, 4, 5, 6, 7 -> Character.toString((char) (50 + rank));
            case 8 -> "10";
            case 9 -> "J";
            case 10 -> "Q";
            case 11 -> "K";
            case 12 -> "A";
            default -> "";
        };
    }

    @Override
    public String toString() {
        return "%s%c(%d)".formatted(face, switch(suit) {
            case CLUB -> '\u2663';
            case DIAMOND -> '\u2666';
            case HEART -> '\u2665';
            case SPADE -> '\u2660';
        }, rank);
    }
}
