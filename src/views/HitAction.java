package views;

import Fighter.Fighter;

public class HitAction extends Action {

	public HitAction() {
		super("HIT");
	}

	@Override
	public void performAction(Fighter player, Fighter oponent) {
		player.hit(oponent);
	}

}
