import java.lang.Math;
import java.util.Random;

public class Card {
    private int cardValue;
    public Card() {
        Random random = new Random();
        cardValue = random.nextInt(11) + 1;
    }
    public int getCardValue() {
        return cardValue;
    }
}
