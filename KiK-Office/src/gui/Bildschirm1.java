package gui;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bildschirm1 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6739603507778596882L;

	/**
	 * Create the panel.
	 */
	public Bildschirm1() {
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);

	}

}
