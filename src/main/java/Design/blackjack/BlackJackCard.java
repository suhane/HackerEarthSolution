package Design.blackjack;

public class BlackJackCard extends Card {

    public BlackJackCard(int v, Suit s) {

        super(v, s);
    }

    public int value() {
        if (isAce())
            return 11;
        if (faceValue < 10)
            return faceValue;
        return 10;
    }

    public int minValue() {
        if (isAce()) { // Ace
            return 1;
        } else {
            return value();
        }
    }

    public int maxValue() {
        if (isAce()) { // Ace
            return 11;
        } else {
            return value();
        }
    }

    public boolean isAce() {
        return faceValue == 1;
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }


}
