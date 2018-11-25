package BlackJack.model;

import BlackJack.controller.IObserver;
import BlackJack.model.rules.*;

public class Dealer extends Player implements IObservable {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinStrategy m_winRule;
  private  IObserver m_observer;

  public Dealer(RulesFactory a_rulesFactory) {
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winRule = a_rulesFactory.GetWinRule();
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
	  boolean shallHit = false;
	  if (shallHit |= m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
		  Card c = m_deck.GetCard();
		  c.Show(true);
		  a_player.DealCard(c);
		  notifyObservers();
	  }
	  return shallHit; // By using the bitwise OR in the if statement, shallHit can be assigned true.
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_winRule.IsDealerWinner(a_player, this);
  }

  public boolean IsGameOver() {
	return m_deck != null && !m_hitRule.DoHit(this);
  }
  public void Stand() {
	  if (m_deck != null) {
		  ShowHand();
		  
		  while (m_hitRule.DoHit(this)) {
			  Card c = m_deck.GetCard();
			  c.Show(true);
			  DealCard(c);
		  }
	  }
  }
  
  @Override
  public void setObserver(IObserver a_observer) {
  	m_observer = a_observer;
  }

  @Override
  public void notifyObservers() {
	 m_observer.update(2000);
  }
}