package Items;

import Fighter.IStatusUpdater;


public class HPPotion extends Potion {

	public HPPotion() {
		super(ItemConfiguration.HPPOTNAME, ItemConfiguration.HPPOTDESC);
	}

	@Override
	public void performEffect(IStatusUpdater theFighter) {
		theFighter.raiseHP( ItemConfiguration.HPPOTRAISE );
	}

}
