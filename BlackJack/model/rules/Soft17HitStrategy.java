package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {

	private final int g_hitLimit = 17;
	@Override
	public boolean DoHit(Player a_dealer) {
		int score = 0;
		boolean hasAce = false;
		int cardScores[] = {
		        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
		    };
		for (Card c : a_dealer.GetHand()) {
			c.Show(true);
			if (!hasAce && c.GetValue() == Card.Value.Ace) {
				hasAce = true;
				score++;
			} else {
				score += cardScores[c.GetValue().ordinal()];
			}
		}
		return (hasAce && score == 7) || a_dealer.CalcScore() < g_hitLimit;
	}

}
