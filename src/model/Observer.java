package model;

import views.FightUpdater;
import views.ItemUpdater;
import guiversion.MainFrameUpdater;

public interface Observer {

	public void register(MainFrameUpdater mfu);
	public void register(FightUpdater fu);
	public void register(ItemUpdater iu);
	
	public void remove(MainFrameUpdater mfu);
	public void remove(FightUpdater fu);
	public void remove(ItemUpdater iu);


}
