package Fighter;

public class ArcherFactory extends FighterFactory {

	public ArcherFactory(String name) {
		super("Archer", name);
	}

	public ArcherFactory() {super("Archer");}

	@Override
	protected Fighter createFighter(String name, int hp, int fp, int mp) {
		// TODO Auto-generated method stub
		return new Archer(name,hp,fp,mp);
	}

	@Override
	protected Fighter createFighter(String name, int hp, int fp, int mp,
			int level) {
		// TODO Auto-generated method stub
		return new Archer(name,hp,fp,mp, level);

	}

}
