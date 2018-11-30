package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public void NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
	   for (int n = 0; n < 2; n++) {
	    Card c = a_deck.GetCard();
	    c.Show(true);
	    a_player.DealCard(c);
	     c = a_deck.GetCard();
	    c.Show(n != 1);
	    a_dealer.DealCard(c);
	   }
    }
}