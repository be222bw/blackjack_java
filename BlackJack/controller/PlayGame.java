package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame {

  public boolean Play(Game a_game, IView a_view) {
    a_view.DisplayWelcomeMessage();
    
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    int input = a_view.GetInput();
    
    switch (input) {
    case 'p':
    	a_game.NewGame();
    	break;
    case 'h':
    	a_game.Hit();
    	break;
    case 's':
    	a_game.Stand();
    	break;
    default:
    		break;
    }
    
    return input != 'q';
  }
}