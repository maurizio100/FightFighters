package Fighter;

public class Configuration {

	public static final int HPEASY = 10;
	public static final int MPEASY = 10;
	public static final int FPEASY = 10;
	
	public static final int HPMEDIUM = 105;
	public static final int MPMEDIUM = 75;
	public static final int FPMEDIUM = 87;
	
	public static final int HPHARD = 173;
	public static final int MPHARD = 133;
	public static final int FPHARD = 149;
	
	public enum Difficulty{
		EASY,HARD,MEDIUM
	}

	public static final FighterFactory fightertypes[] = {
			new WarriorFactory(),	
			new WizardFactory(),
			new ArcherFactory()
		};
	
	public static final FighterFactory fighters[]={
		new ArcherFactory("Rocko"),
		new WarriorFactory("Gary"),
		new WarriorFactory("ASH"),
		new WizardFactory("Dr.Eich")
	};
	
	public static final Configuration.Difficulty DIFF = Difficulty.EASY;
		
}
