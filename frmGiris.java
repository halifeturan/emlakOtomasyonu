package forms;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;
import javax.swing.plaf.synth.ColorType;

import EmlakciPersonelForms.frmEmlakciPersonelYonetim;

import bll.BLLpersonel;
import bll.BLLuye;
import design.Design;

import model.Personel;
import model.User;

import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class frmGiris extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	
	public static User aktifuye=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmGiris frame = new frmGiris();
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
	Object[] satirlar= new Object[6];
	private JTextField textField_1;
	public frmGiris() {
		setTitle("Emlak-Giri\u015F");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 284, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Giri\u015F Yap");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(33, 11, 118, 51);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel = new JLabel("Mail");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 98, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 129, 46, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 95, 139, 20);
		panel.add(textField);
		JLabel lblNewLabel_3 = new JLabel("Şifrenizi yanlış girdiniz.");
		lblNewLabel_3.setBounds(94, 70, 139, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		JButton btnGiri = new JButton("Giri\u015F");
		btnGiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<User> uyeListe;
				
				try {
					uyeListe = BLLuye.uyeGetir();
					//adminListe = BLLadmin.adminGetir();
					
					
					for (User item : uyeListe) {
						
						if(textField_1.getText().equals(item.uye_sifre)&&textField.getText().equals(item.uye_mail))
						{
							aktifuye=item;
							setVisible(false);
							if(item.uye_rol.equals("U"))
							{
								frmUyeMain frmmain=new frmUyeMain();
								frmmain.setVisible(true);
							}
							else if(item.uye_rol.equals("A"))
							{
								frmEmlakciPersonelYonetim frmYonetim=new frmEmlakciPersonelYonetim();
								frmYonetim.setVisible(true);
							}
							else
							{
								lblNewLabel_3.setVisible(true);
							}		
						}
							
						}
						
				
				 }catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				
			}
		});
		btnGiri.setMargin(new Insets(10, 10, 10, 10));
		btnGiri.setBounds(94, 158, 139, 30);
		Design.setbtn(btnGiri, Color.WHITE);
		panel.add(btnGiri);
		
		JLabel lblNewLabel_2 = new JLabel("Veya");
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(104, 204, 46, 20);
		panel.add(lblNewLabel_2);
		
		JButton btnKaytOl = new JButton("Kay\u0131t Ol");
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKayit frmkyt=new frmKayit();
				frmkyt.setVisible(true);
			
			}
		});
		btnKaytOl.setMargin(new Insets(10, 10, 10, 10));
		Design.setbtn(btnKaytOl, Color.WHITE);
		btnKaytOl.setBounds(144, 198, 89, 30);
		panel.add(btnKaytOl);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 128, 139, 20);
		panel.add(textField_1);
		
		
	
		}

}
