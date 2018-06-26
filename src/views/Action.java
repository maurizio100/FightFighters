package views;

import Fighter.*;

public abstract class Action {

	private String type;
	
	public Action(String type){
		this.type = type;
	}
	
	public abstract void performAction( Fighter player, Fighter oponent );
	
	public String toString(){
		return type;
	}
	
}
