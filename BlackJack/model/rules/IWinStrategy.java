package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IWinStrategy {
	public class DealerWinsOnEqualStrategy {

	}

	boolean IsDealerWinner(Player a_player, Player a_dealer);
}
