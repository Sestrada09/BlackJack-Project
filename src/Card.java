import java.lang.Math;
public class Card {
    private int cardValue;
    public Card() {
        cardValue = (int)(Math.random()*(1-12+1)+1);
    }
    public int getCardValue() {
        return cardValue;
    }
    
}
