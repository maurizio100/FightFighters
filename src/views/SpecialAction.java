package views;

import Fighter.Fighter;

public class SpecialAction extends Action{

	public SpecialAction() {
		super("SPECIAL");
	}

	@Override
	public void performAction(Fighter player, Fighter oponent) {
		player.performSpecialMove(oponent);
	}

}
