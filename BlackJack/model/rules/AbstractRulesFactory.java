package BlackJack.model.rules;

public class AbstractRulesFactory {
	INewGameStrategy m_newGameStrategy;
	IHitStrategy m_hitStrategy;
	
	/**
	 * Constructs an abstract rule factory.
	 * @param a_newGameStrategy Character representing the new game strategy ('A' for American and 'I'
	 * for international.
	 * @param a_hitStrategy Character representing the hit strategy ('B' for Basic and 'S' for Soft17).
	 * @throws Exception Thrown if either the hit strategy or new game strategy was not found.
	 */
	public AbstractRulesFactory(char a_newGameStrategy, char a_hitStrategy) throws Exception {
		setNewGameStrategy(a_newGameStrategy);
		setHitStrategy(a_hitStrategy);
	}
	
	/** Sets the hit strategy.
	 * @param a_hitStrategy The character supplied in the constructor.
	 * @throws Exception Throws exception if the hit strategy is not found.
	 */
	private void setHitStrategy(char a_hitStrategy) throws Exception {
		switch (a_hitStrategy) {
		case 'B':
		case 'b':
			m_hitStrategy = new BasicHitStrategy();
			break;
		case 'S':
		case 's':
			m_hitStrategy = new Soft17HitStrategy();
			break;
			default:
				throw new Exception("No such hit strategy!");
		}
	}
		
	/**
	 * Sets the new game strategy.
	 * @param a_newGameStrategy The character supplied in the constructor.
	 * @throws Exception Throws an exception if the new game strategy is not found.
	 */
	private void setNewGameStrategy(char a_newGameStrategy) throws Exception {
		switch (a_newGameStrategy) {
		case 'A':
		case 'a':
			m_newGameStrategy = new AmericanNewGameStrategy();
			break;
		case 'I':
		case 'i':
			m_newGameStrategy = new InternationalNewGameStrategy();
			break;
		default:
			throw new Exception("No such new game strategy!");
		}
	}
}
