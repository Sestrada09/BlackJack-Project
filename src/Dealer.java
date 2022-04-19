import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player {

    int cardTotal;
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
        if (cardTotal >= 17) {
            return true;
        }
        return false;
    }

    @Override
    public void resetCardList() {
        cardList = new ArrayList<>();
        cardTotal = 0;
    }
}
