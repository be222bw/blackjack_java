package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Card c;
    Player[] participants= {a_player, a_dealer};
  
    for (int i = 0; i < 3; i++) {
    	c = a_deck.GetCard();
        c.Show(true);
    	participants[i % 2].DealCard(c);
    }

    return true;
  }
}