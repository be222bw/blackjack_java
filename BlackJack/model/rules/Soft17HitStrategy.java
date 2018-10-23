package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {

	private final int g_hitLimit = 17;
	@Override
	public boolean DoHit(Player a_dealer) {
		int score = 0;
		boolean hasAce = false;
		for (Card c : a_dealer.GetHand()) {
			c.Show(true);
			if (!hasAce && c.GetValue() == Card.Value.Ace) {
				hasAce = true;
				score++;
			} else if (c.GetValue() == Card.Value.Hidden); /* No-op */ else {
				score += c.GetValue().ordinal();
			}
		}
		return (hasAce && score == 7) || a_dealer.CalcScore() < g_hitLimit;
	}

}
