package controller;

import views.Action;
import model.FightActionReceiver;

public class FightManager implements FightReceiver{

	private FightActionReceiver model;
	
	public FightManager( FightActionReceiver actionReceiver){
		model = actionReceiver;
	}

	@Override
	public void receive(Action a) {
		model.receiveAction(a);
	}
	
}
