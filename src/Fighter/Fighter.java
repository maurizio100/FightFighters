package Fighter;

import java.util.ArrayList;
import java.util.List;

import Items.Item;

public abstract class Fighter implements IStatusUpdater,ISpecialUpdater{

	private int maxFightpoints;
	private int fightpoints;

	private int maxMagicpoints;	
	private int magicpoints;

	private int maxHitpoints;
	private int hitpoints;

	private int maxAllowedSpecialmoves=2;
	private int allowedSpecialmoves=maxAllowedSpecialmoves;

	private int level =1;
	private String name;
	private List<Item> backPack = new ArrayList<Item>();

	protected String type;

	public abstract boolean performSpecialMove(Fighter foe);

	public Fighter(String name,int hitpoints, int fightpoints, int magicpoints){
		this.fightpoints = fightpoints;
		this.hitpoints = hitpoints;
		this.magicpoints = magicpoints;
		this.maxHitpoints = hitpoints;
		this.maxMagicpoints = magicpoints;
		this.maxFightpoints = fightpoints;
		this.name = name;
	}

	public Fighter(String name,int hitpoints, int fightpoints, int magicpoints,int level){
		this(name,hitpoints,fightpoints,magicpoints);
		for( int i = 1; i < level; i++ ){
			raiseLevel();
		}
	}

	public String toString(){
		return this.status() + "-----\n" + showBackPackContent() + "-----\n";  //+super.toString();
	}

	public boolean hit(Fighter foe){
		if(allowHit()){
			fightpoints--;
			if( foe.hitpoints < 3*this.level){
				foe.hitpoints = 0;
			}else{
				foe.hitpoints -= 3*this.level;
			}
			
			if(!foe.hasHP()){
				return true; //krepiert
			}
		}
		return false; //lebend
	}

	public void bewitch(Fighter foe){
		if(allowMagic()){
			if(foe.hasFP()){
				this.magicpoints--;
				foe.fightpoints -= 2;
			}
		}
	}

	public void addItem( Item i ){
		backPack.add(i);
	}

	public String showBackPackContent(){
		String retString = "";
		int i = 1;

		for( Item it : backPack ){
			retString += i + "->" + it + "\n";
			i++;
		}

		return retString;
	}

	public void removeItem( int itemnumber ){
		if( itemnumber > 0 && itemnumber <= backPack.size() ){
			backPack.remove(itemnumber - 1);
		}else{

			//TODO Some kind of error if the user picks an invalid itemnumber

		}
	}

	public void useItem(int itemnumber){
		if( itemnumber > 0 && itemnumber <= backPack.size() ){
			backPack.get( itemnumber -1 ).perform(this);
			removeItem(itemnumber);
		}else{

			//TODO Some kind of error if the user picks an invalid itemnumber

		}
	}

	public String status(){
		return "Name: "+this.name+"("+this.level+")\n" + type + "\n" +
				"HP: "+this.hitpoints+" FP: "+this.fightpoints+" MP :"+this.magicpoints+"\n" +
				"Specialmoves: " + this.allowedSpecialmoves ;
	}

	public boolean hasHP(){
		return this.hitpoints>0;
	}

	private boolean hasFP(){
		return this.fightpoints>0;
	}

	private boolean hasMP(){
		return this.magicpoints>0;
	}

	private boolean hasSpecialMoves(){
		return this.allowedSpecialmoves > 0;
	}

	public Boolean[] getStatusVector(){
		Boolean[] statusVector = {
				hasFP(), hasMP(), hasSpecialMoves()
		};

		return statusVector;
	}

	private boolean allowHit(){
		return this.hasFP() && this.hasHP();
	}

	private boolean allowMagic(){
		return this.hasMP() && this.hasHP();
	}

	private void raiseLevel(){
		level++;
		raiseAttributes(); //Using the Template Pattern
	}

	protected void raiseAttributes(){
		raiseAttributes(20,20,20);
	}

	protected void raiseAttributes( int hp, int fp, int mp){
		maxHitpoints += hp;
		maxMagicpoints += fp;
		maxFightpoints += mp;
		hitpoints += hp;
		magicpoints += mp;
		fightpoints += fp;

		if( level % 5 == 0){ allowedSpecialmoves++; maxAllowedSpecialmoves++; }
	}

	protected boolean reduceSpecialmoveCounter(){
		if( allowedSpecialmoves > 0){
			allowedSpecialmoves--;
			return true;
		}
		return false;

	}

	@Override
	public void raiseHP(double hp) {
		if( hitpoints * hp > maxHitpoints ){
			hitpoints = maxHitpoints;
		}else{
			hitpoints *= hp;
		}
	}

	@Override
	public void raiseFP(double fp) {
		if( fightpoints * fp > maxFightpoints ){
			fightpoints = maxFightpoints;
		}else{
			fightpoints *= fp;
		}
	}

	@Override
	public void raiseMP(double mp) {
		if( magicpoints * mp > maxMagicpoints ){
			magicpoints = maxMagicpoints;
		}else{
			magicpoints *= mp;
		}
	}

	@Override
	public void incrementLevel() {
		raiseLevel();
	}

	public int getLevel() {
		return level;
	}
}
