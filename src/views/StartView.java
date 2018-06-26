package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import Fighter.*;
import controller.*;

public class StartView extends JPanel {

	
	private JPanel centerPane = null;
	private JLabel lblWelcome = null;
	private JTextField txtName = null;
	private JButton btnStart = null;
	private JList<FighterFactory> lstFighters = null;
	
	private StartReceiver starter = null;
	
	public StartView(StartReceiver controller ){
		starter = controller;
		init();
	}
	
	private void init(){
		this.setLayout(new BorderLayout());
		lblWelcome = new JLabel("<html><body><p align='center'>Willkommen Kaempfer!" +
				"<br>Waehle dir einen Kaempfer aus und gib einen Namen ein!</p></body></html>");

		lblWelcome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		
		this.add(lblWelcome, BorderLayout.NORTH);
		this.add(getCenterPane(), BorderLayout.CENTER);
		
		btnStart = new JButton("S T A R T");
		this.add(btnStart, BorderLayout.SOUTH);
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Diverse Checkings der Eingaben
				starter.start(lstFighters.getSelectedIndex(), txtName.getText());
			}
		});
		
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
	
	private JPanel getCenterPane(){
		if( centerPane == null ){
			
			centerPane = new JPanel();
			centerPane.setLayout(new GridLayout(3,1));
			
			lstFighters = new JList<FighterFactory>(Configuration.fightertypes);
			txtName = new JTextField("Name");
			
			txtName.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
			txtName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
			
			
			centerPane.add(lstFighters);
			centerPane.add( new JLabel("<html><body><br><br><br></body></html>"));
			centerPane.add(txtName);
			
			centerPane.setBackground(Color.BLACK);
			
			lstFighters.setForeground(Color.WHITE);
			lstFighters.setBackground(Color.BLACK);
			lstFighters.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
			
			return centerPane;
		}
		return null;
	}
	
	
	
}
