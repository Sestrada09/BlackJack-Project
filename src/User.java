import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class User implements Player {
    int cardTotal;
    List<Card> cardList = new ArrayList<Card>();

    @Override
    public int drawCard() {
        Card newCard = new Card();
        cardList.add(newCard);
        return newCard.getCardValue();
    }

    @Override
    public int cardsTotal() {
        for (Card card : cardList) {
            cardTotal += card.getCardValue();
        }
        return cardTotal;
    }

    @Override
    public boolean stay() {

        String stay = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to stay?\n" + "Enter \"Y\" to stay or \"N\" to continue");

        String userStay = scanner.nextLine().toUpperCase(Locale.ROOT);

        while (stay != "Y" || stay != "N") {
            if (stay == "Y") {
                return true;
            } else if (stay != "Y" || stay != "N") {
                System.out.println("Please choose from menu option");
                String userNewStay = scanner.nextLine().toUpperCase(Locale.ROOT);
            } else {
                return false;
            }
        }
        return false;
    }
}
