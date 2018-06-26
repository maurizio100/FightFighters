package Items;

import Fighter.ISpecialUpdater;

public class BonBon extends SpecialItem {

	public BonBon() {
		super(ItemConfiguration.BONBONNAME, ItemConfiguration.BONBONDESC);
	}

	@Override
	public void performEffect(ISpecialUpdater theFighter) {
		theFighter.incrementLevel();
	}

}
