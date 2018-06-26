package guiversion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Model;

import views.*;
import controller.*;

public class MainFrame extends JFrame implements MainFrameUpdater{

	private JPanel fighterStatePane = null;
	private JTextArea playerState = null;
	private JTextArea oponentState = null;
	
	
	private StartView start = null;
	private FightView fightView = null;
	private ItemView itemView = null;
	
	private Model m;
	private StartReceiver startController;
	private FightReceiver fightController;
	
	private enum GameState{
		START, FIGHT, ITEM, PLAYERDEAD
	}

	private GameState state;
	
	public MainFrame(){
		m = new Model(this);
		startController = new StartManager(m);
		fightController = new FightManager(m);
		init();
	}
	
	private void init(){
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		int screenWidth = tk.getScreenSize().width;
		int screenHeight = tk.getScreenSize().height;
		
		this.setBounds(screenWidth/2-350, screenHeight/2-350,700,700);
		this.setTitle("Fight The Fighters");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(getFighterStatePane(), BorderLayout.NORTH);
		
		start = new StartView( startController );
		this.add(start, BorderLayout.CENTER);
		state = GameState.START;
		
		fightView = new FightView( fightController );
		m.register(fightView);
	}
	
	
	private JPanel getFighterStatePane(){
		if( fighterStatePane == null ){
			fighterStatePane = new JPanel();
		
			fighterStatePane.setBackground(Color.BLACK);
			fighterStatePane.setLayout(new GridLayout(1,2));
			
			playerState = new JTextArea("No Fighter Selected\n\n");
			oponentState = new JTextArea("No Fighter selected\n\n");
			
			playerState.setEnabled(false);
			oponentState.setEnabled(false);
			
			playerState.setOpaque(!playerState.isOpaque());
			oponentState.setOpaque(!oponentState.isOpaque());

			playerState.setForeground(Color.WHITE);
			oponentState.setForeground(Color.WHITE);
			
			playerState.setBorder(BorderFactory.createTitledBorder("Player"));
			oponentState.setBorder(BorderFactory.createTitledBorder("Oponent"));
			
			fighterStatePane.add(playerState);
			fighterStatePane.add(oponentState);
			
			playerState.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
			oponentState.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
			
			return fighterStatePane;
		}
		return null;
	}

	@Override
	public void updateState(String player, String oponent) {
		playerState.setText(player);
		oponentState.setText( oponent );
	}

	@Override
	public void updatePlatform() {
		switch(state){
		case START:
			this.remove(start);
			this.add(fightView);
			state = GameState.FIGHT;
			break;
		case FIGHT:
			this.remove(fightView);
			this.add(itemView);
			state = GameState.ITEM;
			break;
		case ITEM:
			this.remove(itemView);
			this.add(fightView);
			state = GameState.FIGHT;
			break;
		case PLAYERDEAD:
			this.remove(fightView);
			this.add(start);
			state = GameState.START;
			break;
		}
		
		this.repaint();
	}

	@Override
	public void setDeadState() {
		state = GameState.PLAYERDEAD;
		updatePlatform();
	}
}
