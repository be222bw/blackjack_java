package BlackJack.view;

public class SimpleView implements IView 
{
	public void DisplayWelcomeMessage()
    {
          System.out.println("Black Jack");
          System.out.println("Type 'p' to play, 'h' to hit, 's' to stand or 'q' to quit." + System.lineSeparator());
    }

	public Action GetInput()
	{
		try {
			int c;
            do {
            	c = System.in.read();
            	switch (c) {
            	case 'h':
            	case 'H':
            		return Action.Hit;
            	case 'p':
            	case 'P':
            		return Action.Play;
            	case 's':
            	case 'S':
            		return Action.Stand;
            	case 'q':
            	case 'Q':
            		return Action.Quit;
            	default:
            		break;
            		}
            	} while (c == '\r' || c =='\n');
            	return Action.Default;
          } catch (java.io.IOException e) {
        	  System.out.println("" + e);
        	  return Action.Default;
          	}
		}

        public void DisplayCard(BlackJack.model.Card a_card)
        {
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }

        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }

        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Score: " + a_score + System.lineSeparator());
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            System.out.println((a_dealerIsWinner ? "Dealer won!" : "You won!"));
        }
        
        @Override
		public void update() {
			try {
				System.out.println("*pause*");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
    }