package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import design.btnset;

import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JFormattedTextField;


public class frmUyeIlanFiltrele extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeIlanFiltrele frame = new frmUyeIlanFiltrele();
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
	public frmUyeIlanFiltrele() {
		setTitle("Emlak-\u0130lan Ara");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 284, 653);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u0130lan Ara");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(33, 11, 118, 51);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblehir = new JLabel("\u015Eehir");
		lblehir.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblehir.setBounds(33, 98, 46, 14);
		panel.add(lblehir);
		
		JLabel lblNewLabel_1 = new JLabel("\u0130l\u00E7e");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 129, 46, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 95, 139, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 154, 139, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mahalle");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(33, 157, 51, 14);
		panel.add(lblNewLabel_1_1);
		
		JButton btnKaytOl = new JButton("Ara");
		btnKaytOl.setMargin(new Insets(10, 10, 10, 10));
		btnKaytOl.setBounds(95, 316, 89, 30);
		btnset.setbtn(btnKaytOl, Color.WHITE);
		panel.add(btnKaytOl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(94, 123, 139, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fiyat");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(33, 183, 27, 20);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 206, 38, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Max.");
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(94, 183, 51, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Min.");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(195, 183, 51, 20);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(195, 206, 38, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("-");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2.setBounds(157, 204, 11, 20);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Oda say\u0131s\u0131");
		lblNewLabel_1_1_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(33, 241, 72, 20);
		panel.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Emlak Tipi");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2_1.setBounds(33, 272, 72, 20);
		panel.add(lblNewLabel_1_1_1_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(115, 273, 118, 22);
		panel.add(comboBox);
		
		comboBox.addItem("Daire");
		comboBox.addItem("Residance");
		comboBox.addItem("Müstakil Ev");
		comboBox.addItem("Villa");
		comboBox.addItem("Çiftlik Evi");
		comboBox.addItem("Yalı");
		comboBox.addItem("Kooperatif");
		comboBox.addItem("Yazlık");
		comboBox.addItem("Köşk & Konak");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(113, 243, 38, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(195, 243, 38, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("+");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2_1.setBounds(167, 241, 11, 20);
		panel.add(lblNewLabel_1_1_1_1_2_1);
	
	}
}
