public class Card implements Comparable<Card>{
    private final int faceValue;
    private final Suit suit;

    public Card(int v, Suit s){
        faceValue = v;
        suit = s;
    }

    public int value() {
        return faceValue;
    }

    public Suit suit() {
        return suit;
    }

    public boolean isACE(){
        return faceValue == 1;
    }

    public boolean isFace(){
        return faceValue >= 10 && faceValue <= 13;
    }

    @Override
    public String toString(){
        return "Card {" + "faceValue= " +faceValue + ", suit= " + suit + "}";
    }

    @Override
    public int compareTo(Card o) {
        return this.faceValue - o.faceValue;
    }
}
