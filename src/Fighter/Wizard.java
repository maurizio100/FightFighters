package Fighter;

public class Wizard extends Fighter {

	public Wizard(String name, int hitpoints, int fightpoints, int magicpoints) {
		this(name, hitpoints, fightpoints, magicpoints,1);
	}

	public Wizard(String name, int hitpoints, int fightpoints, int magicpoints,
			int level) {
		super(name, hitpoints, fightpoints, magicpoints, level);
		type = "Wizard";
	}

	@Override
	public boolean performSpecialMove(Fighter foe) {
		if( reduceSpecialmoveCounter() ){
			bewitch(foe);
			bewitch(foe);
			return hit(foe);
		}
		return false;
	}
	
	@Override
	protected void raiseAttributes(){
		raiseAttributes( 30,10,50 );
	}

}
