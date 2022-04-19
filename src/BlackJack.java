import java.util.Scanner;

public class BlackJack {
    private User user = new User();
    private Dealer dealer = new Dealer();
    private Scanner scanner = new Scanner(System.in);
    public void runGame() {
        System.out.println("Welcome to BlackJack!");
        System.out.println("Please enter your name:");
        String userName = scanner.nextLine();
        System.out.println("Choose an option:\n" + "1. Start Game\n" + "2. Exit Game");
        int gameMenu = scanner.nextInt();
        while (gameMenu == 1) {
            drawInitialCards();
            int initialValue = checkDefaultCards();
            if (initialValue ==  3) {
                playerTurn();
                dealerTurn();
                if ((user.cardsTotal() == 21 && dealer.cardsTotal() != 21) ||
                        (user.cardsTotal() > dealer.cardsTotal() && user.cardsTotal() < 22) ||
                        (user.cardsTotal() < 22 && dealer.cardsTotal() > 22)) {
                    System.out.println("You WIN!");
                }
                else if (user.cardsTotal() == dealer.cardsTotal()) {
                    System.out.println("You push.");
                }
                else {
                    System.out.println("You lose.");
                }
            }
            System.out.println("Choose an option:\n" + "1. Continue Game\n" + "2. Exit Game");
            gameMenu = scanner.nextInt();
            user.resetCardList();
            dealer.resetCardList();
        }
        System.out.println("Thank you for playing!");
        System.exit(0);

    }
    public void drawInitialCards(){
        user.drawCard();
        user.drawCard();
        System.out.println("Your total: " + user.cardsTotal());
        dealer.drawCard();
        System.out.println("Dealers first card: " + dealer.cardsTotal());
        dealer.drawCard();
    }
    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        blackJack.runGame();
    }
    public int checkDefaultCards() {
        int userCardTotal = user.cardsTotal();
        int dealerCardTotal = dealer.cardsTotal();
        if (userCardTotal == 21 && dealerCardTotal == 21) {
            System.out.println("You push.");
            return 0;
        }
        else if (userCardTotal == 21) {
            System.out.println("BlackJack! You win!");
            return 1;
        }
        else if (dealerCardTotal == 21) {
            System.out.println("You lose.");
            return 2;
        }
        return 3;
    }
    public void playerTurn() {
        int userChoice;
        boolean stayInd = false;
        do {
            System.out.println("choose an option\n" + "1. Hit\n" + "2. Stay");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    user.drawCard();
                    System.out.println("Your total is: " + user.cardsTotal());
                    System.out.println("Dealers total: " + dealer.cardList.get(0).getCardValue());
                    break;
                case 2:
                    stayInd = user.stay();
                    break;
                default:
                    System.out.println("Please choose from the menu option.");
            }
        }
        while (stayInd == false && user.cardsTotal() < 22);
    }
    public void dealerTurn() {
        while (dealer.cardsTotal() < 17) {
            dealer.drawCard();
            System.out.println("Dealers total: " + dealer.cardsTotal());
        }
    }

}
