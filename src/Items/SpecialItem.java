package Items;

import Fighter.Fighter;
import Fighter.ISpecialUpdater;

public abstract class SpecialItem extends Item {

	public SpecialItem(String itemName, String itemDescription) {
		super(itemName, itemDescription);
	}

	@Override
	public void perform(Fighter theFighter) {
		performEffect(theFighter);
	}
	
	public abstract void performEffect(ISpecialUpdater theFighter);

}
