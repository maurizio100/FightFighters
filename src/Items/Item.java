package Items;

import Fighter.Fighter;

public abstract class Item {

	private String itemName;
	private String itemDescription;
	
	public abstract void perform(Fighter theFighter);
		
	public Item( String itemName, String itemDescription ){
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}
		
	public String getItemName(){
		return itemName;
	}
	
	public String getItemDescription(){
		return itemDescription;
	}
	
	public String toString(){
		return "Item: " + getItemName() + " ... " + getItemDescription();
		
	}
	
}
