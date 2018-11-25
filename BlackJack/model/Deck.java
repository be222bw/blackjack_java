package BlackJack.model;

import java.util.List;
import java.util.LinkedList;

public class Deck {

  private List<Card> m_cards;
  
  public Deck() {
    m_cards = new LinkedList<Card>();
  
    for(int cIx = 0; cIx < Card.Color.Count.ordinal(); cIx++) {
      for (int vIx = 0; vIx < Card.Value.Count.ordinal(); vIx++) {
        AddCard(new Card(Card.Color.values()[cIx], Card.Value.values()[vIx]));
      }
    }
    
    Shuffle();
  }
  
  
  public void AddCard(Card a_cardToAdd) {
    m_cards.add(a_cardToAdd);
  }
  
  public Card GetCard() {
    return m_cards.remove(0);
  }
  
  public Iterable<Card> GetCards()
  {
      return m_cards;
  }
  
  private void Shuffle()
  {
      for (int i = 0; i < 1017; i++)
      {
          int index = (int)(Math.random() * m_cards.size());
          Card c = m_cards.remove(index);
          AddCard(c);
      }
  }
}