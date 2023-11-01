public class DealerPlayer extends Player{
    private static final int DEALER_MUST_HIT = 17;
    private Player player;

    public DealerPlayer(Player player){
        this.player = player;
    }

    @Override
    public Action action(Duck d){
        if(score() < DEALER_MUST_HIT){
            System.out.println("Dealer MUST HIT 17, Current:");
            printStatus();
            hit(d);
            return Action.Hit;
        }else{
            if(score() > this.player.score()){
                stand();
                return Action.Stand;
            }else{
                return super.action(d);
            }
        }
    }

    @Override
    public void printStatus(){
        System.out.println("Dealer Score: "+ score());
        for (Card card: cards){
            System.out.println(card.toString());
        }
    }
}
