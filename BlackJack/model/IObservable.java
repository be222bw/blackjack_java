package BlackJack.model;

import BlackJack.controller.IObserver;

public interface IObservable {
	public void setObserver(IObserver a_observer);
	public void notifyObservers();
}
