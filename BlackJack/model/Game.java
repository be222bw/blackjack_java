package BlackJack.model;

public class Game {

	private Dealer m_dealer;
	private Player m_player;

	public Game() {
		m_dealer = new Dealer(new BlackJack.model.rules.RulesFactory());
		m_player = new Player();
	}

	public boolean IsGameOver() {
		return m_dealer.IsGameOver();
	}

	public Player getPlayer() {
		return m_player;
	}

	public boolean IsDealerWinner() {
		return m_dealer.IsDealerWinner(m_player);
	}

	public Dealer getDealer() {
		return m_dealer;
	}

	public void NewGame() {
		m_dealer.NewGame(m_player);
	}

	public void Hit() {
		m_dealer.Hit(m_player);
	}

	public void Stand() {
		m_dealer.Stand();
	}

	public Iterable<Card> GetDealerHand() {
		return m_dealer.GetHand();
	}

	public Iterable<Card> GetPlayerHand() {
		return m_player.GetHand();
	}

	public int GetDealerScore() {
		return m_dealer.CalcScore();
	}

	public int GetPlayerScore() {
		return m_player.CalcScore();
	}
}