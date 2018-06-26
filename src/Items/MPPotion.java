package Items;

import Fighter.IStatusUpdater;

public class MPPotion extends Potion {

	public MPPotion() {
		super(ItemConfiguration.MPPOTNAME, ItemConfiguration.MPPOTDESC);
	}

	@Override
	public void performEffect(IStatusUpdater theFighter) {
		theFighter.raiseMP( ItemConfiguration.MPPOTRAISE );
	}

}
