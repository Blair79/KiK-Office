package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Bildschirm2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6739603507778596882L;

	/**
	 * Create the panel.
	 */
	public Bildschirm2() {
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		add(chckbxNewCheckBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);

	}

}
