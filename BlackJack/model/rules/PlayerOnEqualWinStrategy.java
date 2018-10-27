package BlackJack.model.rules;

import BlackJack.model.Player;

public class PlayerOnEqualWinStrategy implements IWinStrategy {

	@Override
	public boolean IsDealerWinner(Player a_player, Player a_dealer) {
		final int g_maxScore = 21;
		if (a_player.CalcScore() > g_maxScore) { // If the player busts...
		      return true;
		    } else if (a_dealer.CalcScore() > g_maxScore) { // If the dealer busts...
		      return false;
		    } else if (a_dealer.CalcScore() == a_player.CalcScore()) { // If the dealer has the same score as the player...
		    	return false;
		    }
		return a_dealer.CalcScore() > a_player.CalcScore(); // The dealer's score is greater than the player's.
	}

}
