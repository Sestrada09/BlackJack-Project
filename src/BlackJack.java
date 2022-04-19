import java.util.Scanner;

public class BlackJack {
    User user = new User();
    Dealer dealer = new Dealer();
    public void runGame() {
        System.out.println("Welcome to BlackJack!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String userName = scanner.nextLine();
        System.out.println("Choose an option:\n" + "1. Start Game\n" + "2. Exit Game");
        int gameMenu = scanner.nextInt();
        while (gameMenu == 1) {
            drawInitialCards();
            int initialValue = checkDefaultCards();
            if (initialValue ==  3) {
                playerTurn();
                System.out.println("Game continuing");
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
        dealer.drawCard();
        dealer.drawCard();
    }
    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        blackJack.runGame();
    }
    public int checkDefaultCards() {
        int userCardTotal = user.cardsTotal();
        int dealerCardTotal = dealer.cardsTotal();
        System.out.println(userCardTotal);
        System.out.println(dealerCardTotal);
        if (userCardTotal == 21 && dealerCardTotal == 21) {
            System.out.println("You push");
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
    public String playerTurn() {

    }

}
