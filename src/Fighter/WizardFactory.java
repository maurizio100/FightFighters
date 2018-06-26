package Fighter;

public class WizardFactory extends FighterFactory {

	public WizardFactory(String name) {
		super("Wizard", name);
		// TODO Auto-generated constructor stub
	}

	public WizardFactory() {super("Wizard");}

	@Override
	protected Fighter createFighter(String name, int hp, int fp, int mp) {
		// TODO Auto-generated method stub
		return new Wizard(name, hp, fp, mp);
	}

	@Override
	protected Fighter createFighter(String name, int hp, int fp, int mp,
			int level) {
		// TODO Auto-generated method stub
		return new Wizard(name, hp, fp, mp, level);
	}

}
