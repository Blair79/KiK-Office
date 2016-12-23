package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ueber extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3989400419083449431L;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public Ueber() throws IOException {
		setTitle("Urheber Informationen");
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 550, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		BufferedImage myPicture = ImageIO.read(new File("image/Ueber.png"));
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{222, 1, 0};
		gbl_contentPanel.rowHeights = new int[]{1, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(this.getWidth(), this.getHeight()-90, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_picLabel = new GridBagConstraints();
		gbc_picLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_picLabel.gridx = 1;
		gbc_picLabel.gridy = 0;
		contentPanel.add(picLabel, gbc_picLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
