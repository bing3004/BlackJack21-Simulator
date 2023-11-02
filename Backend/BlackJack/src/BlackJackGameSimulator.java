public class BlackJackGameSimulator {
    private Duck duck;
    private Player player;
    private Player dealer;

    public BlackJackGameSimulator(){
        duck = new Duck();
        duck.shuffle();
        player = new Player();
        dealer = new DealerPlayer(player);

        player.hit(duck);
        dealer.hit(duck);
        player.hit(duck);
        dealer.hit(duck);
    }

    private void printStatus(){
        player.printStatus();
        dealer.printStatus();
    }

    public void simulate(){
        String newline = System.lineSeparator();

        System.out.println("------------------Game Start------------------");
        printStatus();

        if(player.isBlackJack()){
            if(dealer.isBlackJack()){
                System.out.println("Result:>>>>>>>>>>>>>>   Draw");
            }else{
                System.out.println("Result:>>>>>>>>>>>>>>   Player Black jack wins!!!!!!");
            }
            return;
        } else if (dealer.isBlackJack()) {
            System.out.println("Result:>>>>>>>>>>>>>>   Dealer Black jack wins!!!!!!");
            printStatus();
            return;
        }

        System.out.println("---------------Player round---------------");
        while(player.action(this.duck) == Action.Hit){
            if(player.isBusted()){
                System.out.println("--Dealer wins--");
                printStatus();
                return;
            }
        }

        System.out.println("------------------Dealer round--------------");
        while(dealer.action(this.duck) == Action.Hit){
            if(dealer.isBusted()){
                System.out.println("--Player wins--");
                printStatus();
                return;
            }
        }

        System.out.println("--Now comparing score!!!!!--");
        if(player.score() > dealer.score()){
            System.out.println("--Player Win--");
        } else if (player.score() < dealer.score()) {
            System.out.println("--Dealer Win--");
        }else{
            System.out.println("--Draw--");
        }
        printStatus();
    }

    public static void main(String[] args) {
        BlackJackGameSimulator simulator = new BlackJackGameSimulator();
        simulator.simulate();
    }

}
