package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class amogus extends JFrame {
	public amogus() {
		setSize(400,400);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel label = new JLabel ("Nah, I'd win");
		panel.add(label);
	}
	public static void main(String[] args) {
		new amogus().setVisible(true);
	}
}
