package Fighter;

public class Archer extends Fighter {

	public Archer(String name, int hitpoints, int fightpoints, int magicpoints) {
		this(name, hitpoints, fightpoints, magicpoints,1);
	}

	public Archer(String name, int hitpoints, int fightpoints, int magicpoints,
			int level) {
		super(name, hitpoints, fightpoints, magicpoints, level);
		type = "Archer";
	}

	@Override
	public boolean performSpecialMove(Fighter foe) {
		if(reduceSpecialmoveCounter()){
			bewitch(foe);
			return hit(foe);
		}
		return false;
	}
		
	@Override
	protected void raiseAttributes(){
		raiseAttributes( 30,30,30 );
	}

}
