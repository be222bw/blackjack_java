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
			Card.Value v = c.GetValue();
			hasAce |= v == Card.Value.Ace; // true | false == true, so if only one of the cards is ace, hasAce will remain true.
			
			if (v != Card.Value.Ace && v != Card.Value.Hidden) {
				score += cardScores[c.GetValue().ordinal()];
			}
		}
		return (hasAce && score == 6) || a_dealer.CalcScore() < g_hitLimit;
	}

}
