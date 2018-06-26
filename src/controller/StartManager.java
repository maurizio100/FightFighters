package controller;

import model.Fightercreator;


public class StartManager implements StartReceiver{

	private Fightercreator model;
	
	public StartManager(Fightercreator rcv){
		model=rcv;
	}
	
	@Override
	public void start(int selection, String name) {
		model.createFighter(selection, name);
	}

}
