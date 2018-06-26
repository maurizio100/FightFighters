package Fighter;

public class WarriorFactory extends FighterFactory {

	public WarriorFactory(String name) {
		super("Warrior", name);
		// TODO Auto-generated constructor stub
	}

	public WarriorFactory() {super("Warrior");}

	@Override
	protected Fighter createFighter(String name, int hp, int fp, int mp) {
		return new Warrior(name, hp, fp, mp);
	}

	@Override
	protected Fighter createFighter(String name, int hp, int fp, int mp,
			int level) {
		// TODO Auto-generated method stub
		return new Warrior(name, hp, fp, mp, level);
	}

}
