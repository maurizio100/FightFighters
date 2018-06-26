package Items;

import Fighter.Fighter;
import Fighter.IStatusUpdater;

public abstract class Potion extends Item{

	public abstract void performEffect(IStatusUpdater theFighter);
	
	public void perform(Fighter theFighter){
		performEffect(theFighter);
	}
	
	public Potion(String itemName, String itemDescription) {
		super(itemName, itemDescription);
	}
	
}
