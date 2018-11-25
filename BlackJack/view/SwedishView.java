package BlackJack.view;

public class SwedishView implements IView 
    {
        public void DisplayWelcomeMessage()
        {
            System.out.println("Black Jack");
            System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta." + System.lineSeparator());
        }
        
        public Action GetInput()
        {
          try {
            int c;
            do {c = System.in.read();
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
            System.err.println("" + e);
            return Action.Default;
          }
        }
        
        public void DisplayCard(BlackJack.model.Card a_card)
        {
            if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hjärter", "Spader", "Ruter", "Klöver" };
                String values[] =  
                    { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Poäng: " + a_score);
            System.out.println("");
        }
    }
