package section15_collections;

import java.util.*;

public class CardMain {

    public static void main(String[] args) {

        Card[] cardArray = new Card[13];
        Card aceOfHeart = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHeart);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHeart);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());
        // fill method는 element를 추가하지 않음 기존 elements를 주어진 element로 대체

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHeart);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClub = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClub);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);
        // copy는 복사를 받는 대상이 복사를 하는 대상의 크기보다 크거나 같아야 함
        // 복사 대상에 실제로 덮어쓰며 복사된 컬렉션을 반환하지 않음

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);
        // Collections 유틸이 아닌 List 인터페이스에서 copyOf를 사용할 경우 깊은 복사를 실행
        // 단 반환되는 List는 수정할 수 없는 list를 반환, 수정 가능한 리스트를 받으려면
        // List 생성자나 addAll 메서드를 사용

        /**
         * <- basic of Collections
         *
         * lots of methods in Collections ->
         */

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck of Cards: ", 4);

        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed: ", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));
        // indexOfSubList는 큰 list 에서 작은 list가 존재하는지 확인 및 인덱스 반환
        // sublist는 연속된 값으로 존재해야함

        Collections.shuffle(deck);
        subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));
        // containsAll은 해당 리스트의 원소가 전부 존재하는지만 확인

        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint2 = " + disjoint2);
        // disjoint는 서로 공유하는 원소가 하나라도 존재하면 false 반환

        deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 8);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex = " + foundIndex);
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex));
        // binarySearch는 검색 전 정렬되어 있어야함

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 8);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        if (Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
            System.out.println("Tens of hearts replaced with tens of clubs");
        } else {
            System.out.println("No tens of hearts found in the list");
        }

        System.out.println("Ten of Clubs Card = " +
                Collections.frequency(deck, tenOfClubs));

        System.out.println("Best Card = " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 2);
        System.out.println("UnRotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + 2 + ": " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, -2);
        System.out.println("UnRotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + -2 + ": " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        for (int i = 0; i < copied.size() / 2; i++) {
            Collections.swap(copied, i, copied.size() - 1 - i);
        }
        System.out.println("Manual reverse : " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.reverse(copied);
        System.out.println("Using reverse : " + copied);
    }

}
