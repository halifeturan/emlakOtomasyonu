package EmlakciPersonelForms;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.Security;
import design.Design;
import forms.frmGiris;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmEmlakciPersonelYonetim extends JFrame {

	private JPanel contentPane;
	frmGiris frmgiris=new frmGiris();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEmlakciPersonelYonetim frame = new frmEmlakciPersonelYonetim();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public frmEmlakciPersonelYonetim() throws ClassNotFoundException, SQLException {
		
		//Security.adminKontrol();
		inisilayz();
	
	}
	public void inisilayz() throws SQLException, ClassNotFoundException
	{
		setTitle("Personel Y\u00F6netim Sistemi");
		setResizable(true);
		setBounds(100, 100, 418, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 5, 434, 315);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Personel Y\u00F6netim Sistemi");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(43, 11, 325, 51);
		panel.add(lblNewLabel_2_1);
		
		JButton btnPersonelKayt = new JButton("Personel Kay\u0131t");
		btnPersonelKayt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Security.adminKontrol();
				frmPersonelKayit frmkayit= new frmPersonelKayit();
				frmkayit.setVisible(true);
				
			}
		});
		btnPersonelKayt.setMargin(new Insets(10, 10, 10, 10));
		btnPersonelKayt.setBounds(43, 73, 315, 30);
		panel.add(btnPersonelKayt);
		
		JButton btnBirEmlaaPersonel = new JButton("Bir Emla\u011Fa Personel Ata");
		btnBirEmlaaPersonel.setMargin(new Insets(10, 10, 10, 10));
		btnBirEmlaaPersonel.setBounds(43, 120, 315, 30);
		panel.add(btnBirEmlaaPersonel);
		btnBirEmlaaPersonel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Security.adminKontrol();
				
				frmPersonelAta personelata;
				try {
					personelata = new frmPersonelAta();
					personelata.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
			}
		);
		
		JButton btnBotaPersonelleriGrntle = new JButton("M\u00FCsait Personelleri G\u00F6r\u00FCnt\u00FCle");
		btnBotaPersonelleriGrntle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Security.adminKontrol();
				frmBosPersoneller frmbospersonel;
				try {
					frmbospersonel = new frmBosPersoneller();
					frmbospersonel.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
			}
		);
		btnBotaPersonelleriGrntle.setMargin(new Insets(10, 10, 10, 10));
		btnBotaPersonelleriGrntle.setBounds(43, 166, 315, 30);
		panel.add(btnBotaPersonelleriGrntle);
		
		JButton btnPersonelleriGrntle = new JButton("Personelleri Listele");
		btnPersonelleriGrntle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmPersonelleriGoruntule frmpersonel;
				try {
					frmpersonel = new frmPersonelleriGoruntule();
					frmpersonel.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		);
		btnPersonelleriGrntle.setMargin(new Insets(10, 10, 10, 10));
		btnPersonelleriGrntle.setBounds(43, 211, 315, 30);
		panel.add(btnPersonelleriGrntle);
		Design.setbtn(btnBotaPersonelleriGrntle, Color.WHITE);
		Design.setbtn(btnBirEmlaaPersonel, Color.WHITE);
		Design.setbtn(btnPersonelKayt, Color.WHITE);
		Design.setbtn(btnPersonelleriGrntle, Color.WHITE);
	}
}
