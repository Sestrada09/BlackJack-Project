import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player {

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
        if (cardTotal >= 17) {
            return true;
        }
        return false;
    }
}
