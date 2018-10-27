package BlackJack.model.rules;

import BlackJack.model.Player;

/**
 * The dealer wins on an equal score or if the player busts. If the player does not bust, but the dealer does, the player wins.
 * @author genga
 */
public class DealerOnEqualWinStrategy implements IWinStrategy {
	@Override
	public boolean IsDealerWinner(Player a_player, Player a_dealer) {
		final int g_maxScore = 21;
		if (a_player.CalcScore() > g_maxScore) { // If the player busts...
		      return true;
		    } else if (a_dealer.CalcScore() > g_maxScore) { // If the dealer busts...
		      return false;
		    }
		return a_dealer.CalcScore() >= a_player.CalcScore(); // The dealer's score is greater than or equal to the player's score.
	}

}
