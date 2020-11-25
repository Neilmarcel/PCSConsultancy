package view;

import java.awt.*;

import javax.swing.*;

public class PMEHome extends JFrame{

	Container container=null;
	public PMEHome() {
		container=getContentPane();
		
		
		this.setTitle("PME Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}