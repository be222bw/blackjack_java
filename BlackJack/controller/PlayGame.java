package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.view.Action;
import BlackJack.model.Game;

public class PlayGame implements IObserver {
	
  public boolean Play(Game a_game, IView a_view) {
	a_game.getDealer().setObserver(this);
    a_view.DisplayWelcomeMessage();
    
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    Action input = a_view.GetInput();
    
    switch (input) {
    case Play:
    	a_game.NewGame();
    	break;
    case Hit:
    	a_game.Hit();
    	break;
    case Stand:
    	a_game.Stand();
    	break;
    default:
    		break;
    }
    
    return input != Action.Quit;
  }
  
@Override
public void update(int a_millis) {
	try {
		System.out.println("Waiting ...");
		Thread.sleep(a_millis);
	} catch (InterruptedException e) {
		e.printStackTrace();
		System.exit(-1);
	}
	
}
}