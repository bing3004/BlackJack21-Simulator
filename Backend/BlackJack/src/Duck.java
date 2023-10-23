import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Duck {
    private static final Random random = new Random();
    private final List<Card> cards = new ArrayList<>();
    private int dealIndex = 0;

    public Duck(){
        for (int i = 1; i <= 13; i++) {
            for (Suit suit: Suit.values()) {
                cards.add(new Card(i, suit));
            }
        }
    }

    public void shuffle(){
        for (int i = cards.size() - 1; i >= 0; i--) {
            int j = random.nextInt(i +  1);
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    private int remainingCards(){
        return cards.size() - dealIndex;
    }

    public Card dealCard() {
        return remainingCards()==0?null: cards.get(dealIndex++);
    }




}
