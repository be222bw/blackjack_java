package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {

	private final int g_hitLimit = 17;
	@Override
	public boolean DoHit(Player a_dealer) {
		boolean hasAce = false;
		for (Card c : a_dealer.GetHand()) {
			hasAce |= c.GetValue() == Card.Value.Ace; // true | false == true, so if only one of the cards is ace,
			// hasAce will remain true.
		}
		return (hasAce && a_dealer.CalcScore() == 17) || a_dealer.CalcScore() < g_hitLimit;
	}

}
