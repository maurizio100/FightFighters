package views;

import Fighter.Fighter;

public class BewitchAction extends Action {

	public BewitchAction() {
		super("BEWITCH");
	}

	@Override
	public void performAction(Fighter player, Fighter oponent) {
		player.bewitch(oponent);
	}

}
