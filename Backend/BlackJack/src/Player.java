import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Player {
    private static final Random random = new Random();
    private static final double hitRatio = 0.5;
    protected final List<Card> cards = new ArrayList<>();

    public Action action (Duck d) {
        if (random.nextDouble() < hitRatio) {
            hit(d);
            return Action.Hit;
        }else {
            stand();
            return Action.Stand;
        }
    }

    public int score() {
        Collections.sort(cards, Collections.reverseOrder());
        int score = 0;
        int i = 0;
        for (; i < cards.size(); i++){
            Card c = cards.get(i);
            if (c.isFace()) {
                score+= 10;
            } else if (!c.isACE()) {
                score+= c.value();
            }else{
                break;
            }
        }
        int numAces = cards.size() - i;
        if (numAces == 0) {
            return score <= 21? score : 0;
        }
        int max = numAces + i;
        int min = numAces;
        if (score + min > 21) {
            return 0;
        } else if (score + max > 21) {
            return min;
        } else {
          return score + max;
        }
    }

    public boolean isBusted(){
        return score() == 0;
    }
    public void hit(Duck d){
        cards.add(d.dealCard());
    }

    public void stand(){
    }

    public boolean isBlackJack(){
        if(cards.size() != 2){
            return false;
        }
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        return (card1.isACE() && card2.isFace() || card1.isFace() && card2.isACE());
    }

    public void printStatus(){
        System.out.println("Score:"+ score());
        for (Card card: cards){
            System.out.println(card.toString());
        }
    }

}
