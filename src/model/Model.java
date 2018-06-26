package model;

import views.Action;
import views.FightUpdater;
import views.ItemUpdater;
import Fighter.*;
import guiversion.MainFrameUpdater;

public class Model implements Observer, Fightercreator, FightActionReceiver{

	private Fighter player;
	private Fighter oponent;
	private MainFrameUpdater view;
	private FightUpdater fightUpdater;
	private ItemUpdater itemUpdater;
	
	
	public Model( MainFrameUpdater updater ){
		view = updater;
	}
	
	@Override
	public void createFighter(int selection, String name) {
		addPlayerFighter( selection, name );
		addOponentFighter();
		notifyMainFrame();
		view.updatePlatform();
	}
	
	private void notifyMainFrame() {
		view.updateState(player.status(), oponent.status());		
	}

	private void addOponentFighter() {
		oponent = Configuration.fighters[rollDice(3)].createFighter(player.getLevel());
		
	}

	private void addPlayerFighter(int selection, String name) {
		 Configuration.fightertypes[selection].setName(name);
		 player = Configuration.fightertypes[selection].createFighter();
	}

	private int rollDice(int amount){
		int randomNumber = (int)(Math.random() * amount);
		return randomNumber;
	}

	@Override
	public void register(MainFrameUpdater mfu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(FightUpdater fu) {
		fightUpdater = fu;
		
	}

	@Override
	public void register(ItemUpdater iu) {
		itemUpdater = iu;		
	}

	@Override
	public void remove(MainFrameUpdater mfu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(FightUpdater fu) {
		fightUpdater = null;
	}

	@Override
	public void remove(ItemUpdater iu) {
		itemUpdater = null;
	}

	@Override
	public void receiveAction(Action a) {
		performPlayerAction( a );
		if( oponent.hasHP() ){
			performKIAction();
			if( !player.hasHP () ){
				view.updateState("Du bist tod!!!", "No Fighter selected");
				view.setDeadState();			
			}else{
				fightUpdater.receiveState(player.getStatusVector());
				view.updateState(player.status(), oponent.status());
			}
		}else{
			view.updateState(player.status(), "The Enemy is Dead!!!!");
		//	view.updatePlatform();
		}
	
	}

	private void performKIAction() {
		int choice = rollDice(2)+1;
		
		switch( choice ){
		case 1: oponent.hit(player); 
		fightUpdater.updateLog("Gegner verwendet HIT");

		break;
		case 2: oponent.bewitch(player); 
		fightUpdater.updateLog("Gegner verwendet BEWITCH");
		
		break;
		case 3: oponent.performSpecialMove(player); 
		fightUpdater.updateLog("Gegner verwendet SPECIALMOVE");

		break;
		default: 
			System.out.println("Dont know the move!");
		}	
	}

	private void performPlayerAction(Action a) {
		a.performAction(player, oponent);
		fightUpdater.updateLog("Spieler verwendet " + a);
	}

}
