package Fighter;


public abstract class FighterFactory {


	private String name;
	private String fighterType;
	
	protected abstract Fighter createFighter( String name, int hp, int fp, int mp );
	protected abstract Fighter createFighter( String name, int hp, int fp, int mp, int level );
	
	public FighterFactory(String fighterType){ this.fighterType = fighterType;}
	public FighterFactory(String fighterType, String name ){
		this.name = name;
		this.fighterType = fighterType;
	}
	
	public Fighter createFighter( ){
		switch(Configuration.DIFF){
		case EASY:
			return createFighter(name, Configuration.HPEASY, Configuration.FPEASY, Configuration.MPEASY);
		case MEDIUM:
			return createFighter(name, Configuration.HPMEDIUM, Configuration.FPMEDIUM, Configuration.MPMEDIUM);
		case HARD:
			return createFighter(name, Configuration.HPHARD, Configuration.FPHARD, Configuration.MPHARD);
		
		default: return null;
		}
	}
	
	public Fighter createFighter( int level ){
		switch(Configuration.DIFF){
		case EASY:
			return createFighter(name, Configuration.HPEASY, Configuration.FPEASY, Configuration.MPEASY, level);
		case MEDIUM:
			return createFighter(name, Configuration.HPMEDIUM, Configuration.FPMEDIUM, Configuration.MPMEDIUM, level);
		case HARD:
			return createFighter(name, Configuration.HPHARD, Configuration.FPHARD, Configuration.MPHARD, level);
		
		default: return null;
		}
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String toString(){
		return fighterType;
	}

}
