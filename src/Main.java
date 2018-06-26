import Fighter.ArcherFactory;
import Fighter.Fighter;
import Fighter.FighterFactory;
import Fighter.WarriorFactory;
import Fighter.WizardFactory;
import Items.BonBon;
import Items.FPPotion;
import Items.HPPotion;
import Items.MPPotion;

import java.util.Scanner;


public class Main {

	
	private static FighterFactory fightertypes[] = {
		new WarriorFactory(),	
		new WizardFactory(),
		new ArcherFactory()
	};

	private static FighterFactory fighters[]={
		new ArcherFactory("Rocko"),
		new WarriorFactory("Gary"),
		new WarriorFactory("ASH"),
		new WizardFactory("Dr.Eich")
	};
	
	private static int rollDice(int amount){
		int randomNumber = (int)(Math.random() * amount);
		return randomNumber;
	}
	
	private static void performAction( int choice, Fighter me, Fighter foe){
		switch( choice ){
		case 1: me.hit(foe); break;
		case 2: me.bewitch(foe); break;
		case 3: me.performSpecialMove(foe); break;
		default: 
			System.out.println("Dont know the move!");
		}	
	}
	
	public static void main(String[] args) {
		
		String name;
		System.out.println("Name eingeben:");
		Scanner scan = new Scanner(System.in);
		name = scan.nextLine();
		
		for( FighterFactory ff : fightertypes){ ff.setName(name); }
		
		System.out.println("Welchen Kaempfer moechtest du Spielen?");
		System.out.println("1 -> Warrior | 2 -> Wizard | 3 -> Archer");
		int choice = scan.nextInt();
		Fighter me = fightertypes[choice-1].createFighter();

		System.out.print(me); 
		Fighter foe = fighters[rollDice(3)].createFighter(me.getLevel());
		
		System.out.println("=====================Los gehts!===================");
		while(me.hasHP()){
		
			System.out.println("Gegner:\n" + foe.status());
			System.out.println("Du bist am Zug! Was willst du machen?");
			System.out.println("1 -> Hit -1 FP -3*level HP | 2 -> Bewitch -1 MP -2 FP | 3 -> Specialattack");
			System.out.println(me.status());
			
			System.out.print("Auswahl: ");
			choice = scan.nextInt();
			performAction( choice, me, foe);
			
			if( foe.hasHP() ){
				choice = rollDice(2)+1;
				performAction( choice, foe, me);
				
				System.out.println("==========Kaempferstatus=============");
				System.out.println(me.status());
				System.out.print(foe.status());
				
			}else{
				System.out.println("JUhu Du hast gewonnen!");
				me.incrementLevel();
				
				System.out.println("=============Dein Status:=============");
				System.out.print(me);
				System.out.println("======================================");
				
				System.out.println("Du kannst dir ein Item nehmen:");
				System.out.println("1 -> HPPotion | 2 -> FPPotion | 3 -> MPPotion | 4 -> BonBon");
				System.out.print("Auswahl: ");
				choice = scan.nextInt();
				
				switch( choice ){
				case 1: me.addItem(new HPPotion()); break;
				case 2: me.addItem(new FPPotion()); break;
				case 3: me.addItem(new MPPotion()); break;
				case 4: me.addItem(new BonBon()); break;
				}
				
				System.out.println("=============Benutzen eines Items:============");
				System.out.println(me.showBackPackContent());
				System.out.println("Willst du ein Item verwenden? 1) ja 2) nein");
				
				System.out.print("Welches: ");
				choice = scan.nextInt();
				
				if( choice == 1 ){
					System.out.print("Auswahl: ");
					choice = scan.nextInt();
					me.useItem(choice);
				}
				foe = fighters[rollDice(3)].createFighter(me.getLevel());
			}
			System.out.println("=========================Naechste Kampfrunde:==============");
		}
		scan.close();
	}
}
