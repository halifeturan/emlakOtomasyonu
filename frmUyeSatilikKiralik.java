package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmUyeSatilikKiralik extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeSatilikKiralik frame = new frmUyeSatilikKiralik();
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
	public frmUyeSatilikKiralik() {
		setResizable(false);
		setTitle("Emlak-Filtreleme");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 178, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 175, 201);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sat\u0131l\u0131k");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(10, 11, 70, 51);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Kiral\u0131k");
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1_1.setBounds(10, 92, 81, 51);
		panel.add(lblNewLabel_2_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		
		rdbtnNewRadioButton.setBounds(96, 28, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		
		rdbtnNewRadioButton_1.setBounds(96, 109, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
						rdbtnNewRadioButton.setSelected(false);
					
			}
		});
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					rdbtnNewRadioButton.setSelected(false);
				
			}
		});
	}
}
