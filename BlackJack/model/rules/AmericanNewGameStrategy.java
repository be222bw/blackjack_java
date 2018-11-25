package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
	final int g_numberOfCardsWithWhichToStart = 2;

    for (int i = 0; i < g_numberOfCardsWithWhichToStart; i++) {
    	Player[] participants = {a_player, a_dealer};
    	for (int index = 0; index < participants.length; index++) {
    		Card c = a_deck.GetCard();
    		c.Show(!(i == 1 && participants[index] == a_dealer)); // If it's the dealer's second card, don't show it.
    		participants[index].DealCard(c);
    	}
    }
    return true;
  }
}