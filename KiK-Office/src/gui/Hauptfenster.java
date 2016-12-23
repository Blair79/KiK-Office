package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Hauptfenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4427337284807583076L;
	private JPanel contentPane;
	private static Ueber dialog;
	private JTextField txtEingabe;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptfenster frame = new Hauptfenster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hauptfenster() {
		setTitle("KiK-Office");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("Datei");
		menuBar.add(mnFile);

		JMenuItem mntmNeu = new JMenuItem("neu");
		mnFile.add(mntmNeu);

		JMenuItem mntmOeffnen = new JMenuItem("öffnen");
		mnFile.add(mntmOeffnen);

		JMenu mnBearbeiten = new JMenu("Bearbeiten");
		menuBar.add(mnBearbeiten);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);

		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);

		JMenuItem mntmInfoUeberKikoffice = new JMenuItem("Info über KiK-Office");
		mntmInfoUeberKikoffice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					dialog = new Ueber();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
				} catch (Exception f) {
					f.printStackTrace();
				}
				dialog.setVisible(true);
			}
		});

		mnHilfe.add(mntmInfoUeberKikoffice);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JToolBar toolBar = new JToolBar();
		panel.add(toolBar);
		
		JButton btnGo = new JButton("Go");
		toolBar.add(btnGo);
		
				txtEingabe = new JTextField();
				
				txtEingabe.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if(!txtEingabe.getText().startsWith("//"))
								txtEingabe.setText("//");
					}
				});
				txtEingabe.setText("Eingabe Transaktionscode");
				txtEingabe.setEditable(true);
				toolBar.add(txtEingabe);
		
				JButton btnOk = new JButton("ok");
				
				toolBar.add(btnOk);
				
				

		JRadioButton rdbtnTest_1 = new JRadioButton("Ansicht");
		rdbtnTest_1.setSelected(true);
		buttonGroup.add(rdbtnTest_1);
		toolBar.add(rdbtnTest_1);

		JRadioButton rdbtnTest = new JRadioButton("Bearbeiten");
		buttonGroup.add(rdbtnTest);
		toolBar.add(rdbtnTest);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel lblStatusleiste = new JLabel("Statusleiste");
		panel_1.add(lblStatusleiste);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Wurzel");
		DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode("Knoten ");
		root.add(dmtn);
		dmtn.add(new DefaultMutableTreeNode("Bildschirm1"));
		dmtn.add(new DefaultMutableTreeNode("Bildschirm2"));
		JTree tree = new JTree(root);
		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setBorder(new TitledBorder(null, "Transaktion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setPreferredSize(new Dimension(200, 403));
		panel_2.add(scrollPane);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_3.add(tabbedPane);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Mitarbeiter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_4, BorderLayout.EAST);

		JLabel lblMitarbeiterX = new JLabel("Mitarbeiter X");
		panel_4.add(lblMitarbeiterX);
		
		txtEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(tabbedPane.getTitleAt(1));
				if (txtEingabe.getText().startsWith("//"))
					if (tabbedPane.getTabCount()>0){
					for (int i=0;i<tabbedPane.getTabCount();i++)
						if (tabbedPane.getTitleAt(i)!=txtEingabe.getText().substring(2))
							{
							System.out.println(tabbedPane.getTitleAt(i));break;}
					}
					else
					switch (txtEingabe.getText().substring(2)) {
		            case "Bildschirm1":
		            	tabbedPane.addTab(txtEingabe.getText().substring(2), null, new Bildschirm1(), null);
		                     break;
		            case "Bildschirm2":
		            	tabbedPane.addTab(txtEingabe.getText().substring(2), null, new Bildschirm2(), null);
		                     break;
		            
		            default: lblStatusleiste.setText("Transaktion "+txtEingabe.getText().substring(2)+" unbekannt");
		                     break;
		        }
			}
		});

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtEingabe.getText());
				if (txtEingabe.getText().startsWith("//"))
					switch (txtEingabe.getText().substring(2)) {
		            case "Bildschirm1":
		            	tabbedPane.addTab(txtEingabe.getText().substring(2), null, new Bildschirm1(), null);
		                     break;
		            case "Bildschirm2":
		            	tabbedPane.addTab(txtEingabe.getText().substring(2), null, new Bildschirm2(), null);
		                     break;
		            
		            default: lblStatusleiste.setText("Transaktion "+txtEingabe.getText().substring(2)+" unbekannt");
		                     break;
		        }
				
			}
		});
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				TreePath path = e.getNewLeadSelectionPath();
				//System.out.println(path.getLastPathComponent().toString());
				 if (path.getLastPathComponent().toString() == "Bildschirm1") {
						tabbedPane.addTab(path.getLastPathComponent().toString(), null, new Bildschirm1(), null);
					}
				 if (path.getLastPathComponent().toString() == "Bildschirm2") {
						tabbedPane.addTab(path.getLastPathComponent().toString(), null, new Bildschirm2(), null);
					}
			}
		});
	}

}
