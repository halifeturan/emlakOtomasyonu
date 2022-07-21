package EmlakciPersonelForms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bll.BLLpersonel;
import bll.Security;
import design.Design;
import forms.frmGiris;
import model.Personel;


public class frmPersonelKayit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Security.adminKontrol();
					frmPersonelKayit frame = new frmPersonelKayit();
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
	public frmPersonelKayit() {
		Security.adminKontrol();
		setTitle("Personel Kaydet");
		setResizable(false);
		setBounds(100, 100, 292, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 284, 313);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Personel Kaydet");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(33, 11, 241, 51);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel = new JLabel("Mail");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 96, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 121, 28, 21);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 95, 139, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 154, 139, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0130sim");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(33, 155, 28, 14);
		panel.add(lblNewLabel_1_1);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Personel prsnl=new Personel(textField.getText(),passwordField.getPassword().toString(),textField_1.getText(),true,textField_2.getText());
			try {
				BLLpersonel.personelKaydet(prsnl);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnKaydet.setMargin(new Insets(10, 10, 10, 10));
		btnKaydet.setBounds(94, 218, 89, 30);
		panel.add(btnKaydet);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(94, 123, 139, 20);
		panel.add(passwordField);
		Design.setbtn(btnKaydet, Color.WHITE);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefon");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(33, 188, 46, 14);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(93, 187, 139, 20);
		panel.add(textField_2);
	
	}
}
