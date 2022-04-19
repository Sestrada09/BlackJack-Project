import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class User implements Player {
    int cardTotal;
    Money money = new Money();
    List<Card> cardList = new ArrayList<Card>();

    @Override
    public int drawCard() {
        Card newCard;
        if (cardList.size() == 1 && cardList.get(0).getCardValue() == 11) {
            do {
                newCard = new Card();
            } while (newCard.getCardValue() == 11);
            cardList.add(newCard);
        }
        else {
            newCard = new Card();
            cardList.add(newCard);
        }
        return newCard.getCardValue();
    }

    @Override
    public int cardsTotal() {
        int total = 0;
        for (Card card : cardList) {
            total += card.getCardValue();
        }
        cardTotal = total;
        return cardTotal;
    }

    @Override
    public boolean stay() {

        Scanner scanner = new Scanner(System.in);
        String userStay = "";

        while (!userStay.equals("N") || !userStay.equals("Y")) {
            System.out.println("Do you want to stay?\n" + "Enter \"Y\" to stay or \"N\" to continue");
            userStay = scanner.nextLine().toUpperCase(Locale.ROOT);
            if (userStay.equals("Y")) {
                return true;
            }
            else if (userStay.equals("N")) {
                return false;
            }
        }
        return false;
    }

    @Override
    public void resetCardList() {
        cardList = new ArrayList<>();
        cardTotal = 0;
    }
}
