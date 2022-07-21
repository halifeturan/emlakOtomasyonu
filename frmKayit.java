package forms;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import bll.BLLuye;
import design.Design;
import model.User;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmKayit extends JFrame {

	private JPanel contentPane;
	private JTextField txtIsim;
	private JTextField txtSifre;
	private JTextField txtSoyadi;
	private JTextField txtMail;
	private JTextField txtTelefon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKayit frame = new frmKayit();
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
	public frmKayit() {
		setTitle("Emlak-Kayit");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 284, 461);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Kay\u0131t Ol");
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
		
		txtIsim = new JTextField();
		txtIsim.setColumns(10);
		txtIsim.setBounds(94, 154, 139, 20);
		panel.add(txtIsim);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0130sim");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(33, 157, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Do\u011Fum Tarihi");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(33, 262, 105, 20);
		panel.add(lblNewLabel_1_1_1);
		JFormattedTextField txtYil = new JFormattedTextField();
		txtYil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				design.Design.sayiYazdir(txtYil, e, true);
			}
		});
		
		txtYil.setBounds(145, 292, 69, 20);
		panel.add(txtYil);
		
		JButton btnKaytOl = new JButton("Kay\u0131t Ol");
		txtSoyadi = new JTextField();
		txtSoyadi.setColumns(10);
		txtSoyadi.setBounds(94, 183, 139, 20);
		panel.add(txtSoyadi);
		txtTelefon = new JTextField();
		txtTelefon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtTelefon, e, true);
			}
		});
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(94, 215, 139, 20);
		panel.add(txtTelefon);
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy");
				LocalDate date = LocalDate.now();
				int yil=Integer.parseInt(txtYil.getText());
				int simdi=date.getYear();
				if(simdi-(yil)>=18)
				{
					
					User uye=new User(txtIsim.getText(), txtSoyadi.getText(), txtSifre.getText(), 0,0,txtMail.getText(),"U",txtTelefon.getText());
					try {
						BLLuye.uyeKaydet(uye);
						setVisible(false);
						frmGiris frmgiris=new frmGiris();
						frmgiris.setVisible(true);
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Yaşınız 18'den küçük olduğu için kayıt olamazsınız.");
				}
				
			}
		});
		btnKaytOl.setBounds(94, 344, 89, 30);
		panel.add(btnKaytOl);
		Design.setbtn(btnKaytOl, Color.WHITE);
		btnKaytOl.setMargin(new Insets(10, 10, 10, 10));
		
		JComboBox cbAy = new JComboBox();
		cbAy.setBounds(33, 291, 46, 22);
		cbAy.setBackground(Color.WHITE);
		cbAy.setOpaque(true);
		panel.add(cbAy);
		Design.comboDoldur(1, 12, cbAy);
		
		JComboBox cbGun = new JComboBox();
		cbGun.setBounds(89, 291, 46, 22);
		cbGun.setBackground(Color.WHITE);
		cbGun.setOpaque(true);
		panel.add(cbGun);
		Design.comboDoldur(1, 31, cbGun);
		NumberFormat longFormat = NumberFormat.getIntegerInstance();

		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
		numberFormatter.setAllowsInvalid(false); //this is the key!!
		numberFormatter.setMinimum(0l); //Optional

	
		
		JLabel lblAy = new JLabel("Ay");
		lblAy.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblAy.setBounds(33, 313, 27, 20);
		panel.add(lblAy);
		
		JLabel lblGn = new JLabel("G\u00FCn");
		lblGn.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblGn.setBounds(89, 313, 27, 20);
		panel.add(lblGn);
		
		JLabel lblYl = new JLabel("Y\u0131l");
		lblYl.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblYl.setBounds(145, 313, 27, 20);
		panel.add(lblYl);
		
		txtSifre = new JTextField();
		txtSifre.setColumns(10);
		txtSifre.setBounds(94, 126, 139, 20);
		panel.add(txtSifre);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Soyad");
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(33, 182, 46, 20);
		panel.add(lblNewLabel_1_1_2);
		
		txtMail = new JTextField();
		txtMail.setBounds(94, 97, 139, 20);
		panel.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Telefon");
		lblNewLabel_1_1_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(33, 214, 46, 20);
		panel.add(lblNewLabel_1_1_2_1);
		

		
		
	}
}
