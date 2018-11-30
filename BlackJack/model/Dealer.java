package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinStrategy m_winRule;

  public Dealer(RulesFactory a_rulesFactory) {
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winRule = a_rulesFactory.GetWinRule();
  }
  
  
  public void NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      m_newGameRule.NewGame(m_deck, this, a_player);   
    }
  }

  public void Hit(Player a_player) {
	  if (a_player.CalcScore() < g_maxScore && !IsGameOver()) {
		  Card c = m_deck.GetCard();
		  c.Show(true);
		  a_player.DealCard(c);
	  }
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_winRule.IsDealerWinner(a_player, this);
  }

  public boolean IsGameOver() {
	return !m_hitRule.DoHit(this);
  }
  
  public void Stand() {
	  // Whilst the sequence diagram said to check m_deck for null here, m_deck will never be null here, since it is initialised
	  // in NewGame, and the deck cannot ever be emptied with just two players.
		  ShowHand();
		  
		  while (m_hitRule.DoHit(this)) {
			  Card c = m_deck.GetCard();
			  c.Show(true);
			  DealCard(c);
		  }
  }
}