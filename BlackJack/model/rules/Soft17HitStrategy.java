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
			if (c.GetValue() == Card.Value.Ace) {
				hasAce = true;
			} else if (c.GetValue() == Card.Value.Hidden); /* No-op */ else {
				score += cardScores[c.GetValue().ordinal()];
			}
		}
		return (hasAce && score == 6) || a_dealer.CalcScore() < g_hitLimit;
	}

}
