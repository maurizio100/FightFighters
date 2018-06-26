package Fighter;

public class Warrior extends Fighter{

	public Warrior(String name, int hitpoints, int fightpoints, int magicpoints) {
		this(name, hitpoints, fightpoints, magicpoints,1);
	}

	public Warrior(String name, int hitpoints, int fightpoints,
			int magicpoints, int level) {
		super(name, hitpoints, fightpoints, magicpoints, level);
		type = "Warrior";
	}

	@Override
	public boolean performSpecialMove(Fighter foe) {
		if( reduceSpecialmoveCounter() ){
			return hit( foe ) || hit( foe );
		}
		return false;
	}

	@Override
	protected void raiseAttributes(){
		raiseAttributes( 30,40,10 );
	}
	
}
