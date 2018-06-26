package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.FightReceiver;

public class FightView extends JPanel implements FightUpdater{

	private JButton btnHit = null;
	private JButton btnBewitch = null;
	private JButton btnSpecial = null;
	
	private JTextArea taFightLog = null;
	private JPanel southPanel = null;
	
	
	private FightReceiver fightReceiver = null;
	
	public FightView(FightReceiver controller ){
		fightReceiver = controller;
		init();
	}
	
	private void init(){
		this.setLayout( new BorderLayout() );
		taFightLog = new JTextArea();
		taFightLog.setEnabled(false);
		taFightLog.setBackground(Color.BLACK);
		taFightLog.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		this.add(taFightLog, BorderLayout.CENTER);
		this.add(getSouthPanel(), BorderLayout.SOUTH);
	}
	
	private JPanel getSouthPanel(){
		if(southPanel == null){
			southPanel = new JPanel();
			southPanel.setLayout(new GridLayout(1,3));
			
			btnHit = new JButton("H I T");
			btnBewitch = new JButton("M A G I C");
			btnSpecial = new JButton("S P E C I A L");
			
			btnHit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fightReceiver.receive(new HitAction());
				}
			});
			btnBewitch.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fightReceiver.receive(new BewitchAction());
				}
			});
			btnSpecial.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fightReceiver.receive(new SpecialAction());
				}
			});
			
			southPanel.add(btnHit);
			southPanel.add(btnBewitch);
			southPanel.add(btnSpecial);
			
			return southPanel;
		}
		return null;
		
	}
	
	private void toggleButton(JButton btn){
		btn.setEnabled(!btn.isEnabled());
	}

	@Override
	public void updateLog(String logmsg) {
		taFightLog.setText(logmsg +"\n" + taFightLog.getText());
	}

	@Override
	public void receiveState(Boolean[] states) {
		if( !states[0] ){
			toggleButton(btnHit);
		}
		if( !states[1] ){
			toggleButton(btnBewitch);
		}
		if( !states[2] ){
			toggleButton(btnSpecial);
		}	
	}
}
