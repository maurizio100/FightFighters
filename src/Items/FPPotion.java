package Items;

import Fighter.IStatusUpdater;

public class FPPotion extends Potion {

	public FPPotion() {
		super(ItemConfiguration.FPPOTNAME, ItemConfiguration.FPPOTDESC);
	}

	@Override
	public void performEffect(IStatusUpdater theFighter) {
		theFighter.raiseFP( ItemConfiguration.FPPOTRAISE );
	}

}
