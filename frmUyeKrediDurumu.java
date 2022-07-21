	package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;
import javax.swing.table.DefaultTableModel;

import bll.BLLbanka;
import bll.BLLpersonel;
import bll.BLLuye;
import design.Design;
import model.Banka;
import model.Personel;

import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTable;


public class frmUyeKrediDurumu extends JFrame {

	private JPanel contentPane;
	private JTextField txtQnbTutar;
	private JTextField txtTutarTeb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeKrediDurumu frame = new frmUyeKrediDurumu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	int vade=0;
	float krediTutar=0;
	int girilenTutar=0;
	float ihtiyac_faiz=0f;
	float konut_faiz=0f;
	static boolean dot;
	String banka_ad;
	ArrayList<Banka>bankaListe;
	Object[] column= {"Adı","İhtiyaç Faizi", "Konut Faizi"};
	Object[] satirlar= new Object[3];
	DefaultTableModel model=new DefaultTableModel();
	ArrayList<Banka> faizBanka;
	private JTextField txtAkbankTutar;
	private JTextField txtGarantiTutar;
	private JTextField txtDenizbankTutar;
	
	

	
	public ArrayList<Banka> ingGetir() throws ClassNotFoundException, SQLException
	{

		
		ArrayList<Banka>ingListe=BLLbanka.ingGetir();
		for (Banka item : ingListe) {
			banka_ad=item.banka_ad;
			ihtiyac_faiz=item.banka_ihtiyac_faiz;
			konut_faiz=item.banka_ihtiyac_faiz;
		}
		return ingListe;
	}
	
	public ArrayList<Banka> qnbGetir() throws ClassNotFoundException, SQLException
	{
		
		
		ArrayList<Banka>qnbListe=BLLbanka.qnbGetir();
		for (Banka item : qnbListe) {
			banka_ad=item.banka_ad;
			ihtiyac_faiz=item.banka_ihtiyac_faiz;
			konut_faiz=item.banka_ihtiyac_faiz;
		}
		return qnbListe;
	}
	
	public ArrayList<Banka> tebGetir() throws ClassNotFoundException, SQLException
	{
		
		
		ArrayList<Banka>tebListe=BLLbanka.tebGetir();
		for (Banka item : tebListe) {
			banka_ad=item.banka_ad;
			ihtiyac_faiz=item.banka_ihtiyac_faiz;
			konut_faiz=item.banka_ihtiyac_faiz;
		}
		return tebListe;
	}
	
	public ArrayList<Banka> akbankGetir() throws ClassNotFoundException, SQLException
	{
		
		
		ArrayList<Banka>akbankListe=BLLbanka.akbankGetir();
		for (Banka item : akbankListe) {
			banka_ad=item.banka_ad;
			ihtiyac_faiz=item.banka_ihtiyac_faiz;
			konut_faiz=item.banka_ihtiyac_faiz;
		}
		return akbankListe;
	}
	
	public ArrayList<Banka> denizBankGetir() throws ClassNotFoundException, SQLException
	{
	
		
		ArrayList<Banka>denizBankListe=BLLbanka.denizBank();
		for (Banka item : denizBankListe) {
			banka_ad=item.banka_ad;
			ihtiyac_faiz=item.banka_ihtiyac_faiz;
			konut_faiz=item.banka_ihtiyac_faiz;
		}
		return denizBankListe;
	}
	
	public ArrayList<Banka> garantiBankGetir() throws ClassNotFoundException, SQLException
	{
	
		
		ArrayList<Banka>garantiListe=BLLbanka.garantiBank();
		for (Banka item : garantiListe) {
			banka_ad=item.banka_ad;
			ihtiyac_faiz=item.banka_ihtiyac_faiz;
			konut_faiz=item.banka_ihtiyac_faiz;
		}
		return garantiListe;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public frmUyeKrediDurumu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1133, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')) {
	                    e.consume();
	                    
			}
			}
		});
		
		txtAkbankTutar = new JTextField();
		txtDenizbankTutar = new JTextField();
		
		JLabel lblIngToplamOdeme = new JLabel("-");
		lblIngToplamOdeme.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblIngToplamOdeme.setBounds(917, 95, 108, 20);
		panel.add(lblIngToplamOdeme);

		txtGarantiTutar = new JTextField();
		
		JLabel lblGarantiToplamOdeme = new JLabel("-");
		lblGarantiToplamOdeme.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblGarantiToplamOdeme.setBounds(912, 393, 108, 20);
		panel.add(lblGarantiToplamOdeme);
		
		JLabel lblAkbankToplamOdeme = new JLabel("-");
		lblAkbankToplamOdeme.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblAkbankToplamOdeme.setBounds(912, 321, 108, 20);
		panel.add(lblAkbankToplamOdeme);
		
		JLabel lblQnbToplamOdeme = new JLabel("-");
		lblQnbToplamOdeme.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblQnbToplamOdeme.setBounds(912, 171, 108, 20);
		panel.add(lblQnbToplamOdeme);
	
		JLabel lblDenizToplamOdeme = new JLabel("-");
		lblDenizToplamOdeme.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblDenizToplamOdeme.setBounds(912, 465, 108, 20);
		panel.add(lblDenizToplamOdeme);
		
		JLabel lblTebToplamOdeme = new JLabel("-");
		lblTebToplamOdeme.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblTebToplamOdeme.setBounds(912, 247, 108, 20);
		panel.add(lblTebToplamOdeme);


		JLabel lblQnbFaiz = new JLabel("0");
		lblQnbFaiz.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblQnbFaiz.setBounds(736, 174, 33, 14);
		panel.add(lblQnbFaiz);
		
		JLabel lblTebFaiz = new JLabel("0");
		lblTebFaiz.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblTebFaiz.setBounds(736, 252, 33, 14);
		panel.add(lblTebFaiz);
		JLabel lblAkbankFaiz = new JLabel("0");
		lblAkbankFaiz.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblAkbankFaiz.setBounds(734, 327, 33, 14);
		
		JLabel lblDenizFaiz = new JLabel("0");
		lblDenizFaiz.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblDenizFaiz.setBounds(735, 470, 33, 14);
		panel.add(lblDenizFaiz);
		panel.add(lblAkbankFaiz);
		
		JLabel lblGarantiFaiz = new JLabel("0");
		lblGarantiFaiz.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblGarantiFaiz.setBounds(734, 400, 33, 14);
		panel.add(lblGarantiFaiz);
		
		JComboBox cmbVadeIng = new JComboBox();
		JComboBox cmbVadeQnb = new JComboBox();
		JComboBox cmbVadeTeb = new JComboBox();
		JComboBox cmbDenizbankVade = new JComboBox();
		cmbDenizbankVade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDenizToplamOdeme.setText(String.valueOf(Design.odenek(cmbDenizbankVade, vade, lblDenizFaiz, txtDenizbankTutar.getText())));
			}
		});
		JComboBox cmbAkbankVade = new JComboBox();
		cmbAkbankVade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAkbankToplamOdeme.setText(String.valueOf(Design.odenek(cmbAkbankVade, vade, lblAkbankFaiz, txtAkbankTutar.getText())));
			}
		});
		JComboBox cmbGarantiVade = new JComboBox();
		cmbGarantiVade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGarantiToplamOdeme.setText(String.valueOf(Design.odenek(cmbGarantiVade, vade, lblGarantiFaiz, txtGarantiTutar.getText())));
			}
		});
	
		JButton kredial5 = new JButton("Kredi Al");
		kredial5.setVisible(false);
		kredial5.setOpaque(false);
		kredial5.setBorder(new EmptyBorder(0, 0, 0, 0));
		kredial5.setBounds(1037, 373, 66, 41);
		panel.add(kredial5);
		
		JButton kredial3 = new JButton("Kredi Al");
		kredial3.setVisible(false);
		kredial3.setOpaque(false);
		kredial3.setBorder(new EmptyBorder(0, 0, 0, 0));
		kredial3.setBounds(1037, 232, 66, 41);
		panel.add(kredial3);
		
		JButton kredial4 = new JButton("Kredi Al");
		kredial4.setVisible(false);
		kredial4.setOpaque(false);
		kredial4.setBorder(new EmptyBorder(0, 0, 0, 0));
		kredial4.setBounds(1037, 302, 66, 41);
		panel.add(kredial4);
		
		JButton kredial1 = new JButton("Kredi Al");
		kredial1.setVisible(false);
		kredial1.setOpaque(false);
		kredial1.setBorder(new EmptyBorder(0, 0, 0, 0));
		kredial1.setBounds(1035, 85, 66, 41);
		panel.add(kredial1);
		
		
		
		
		JButton kredial2 = new JButton("Kredi Al");
		kredial2.setVisible(false);
		kredial2.setOpaque(false);
		kredial2.setBorder(new EmptyBorder(0, 0, 0, 0));
		kredial2.setBounds(1035, 155, 66, 41);
		panel.add(kredial2);
		
		JButton kredial6 = new JButton("Kredi Al");
		kredial6.setVisible(false);
		JTextField txtIngTutar = new JTextField();
		JTextField txtQnbTutar = new JTextField();
		JTextField txtTutarTeb = new JTextField();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1115, 554);
		contentPane.add(panel);
		

		JLabel lblNewLabel_2_1 = new JLabel("Kredi Hesapla");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(33, 11, 244, 51);
		panel.add(lblNewLabel_2_1);
		JLabel lblIngFaiz = new JLabel("0");
		lblIngFaiz.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblIngFaiz.setBounds(735, 98, 33, 14);
		panel.add(lblIngFaiz);
		
		JLabel lblTutar = new JLabel("Tutar");
		lblTutar.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblTutar.setBounds(33, 98, 46, 14);
		panel.add(lblTutar);
		
		
		JLabel lblNewLabel_1 = new JLabel("Vade");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(283, 98, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kredi T\u00FCr\u00FC");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(528, 98, 97, 14);
		panel.add(lblNewLabel_1_1);
		
		JComboBox cbBanka1 = new JComboBox();
		cbBanka1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbBanka1.getSelectedItem().equals("İhtiyaç"))
				{
					
				
					try {
						for(Banka bnk:ingGetir())
						{
							lblIngFaiz.setText(String.valueOf(bnk.banka_ihtiyac_faiz));
							lblIngToplamOdeme.setText(String.valueOf(Design.odenek(cmbVadeIng, vade, lblIngFaiz, txtIngTutar.getText())));
							

						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				else
				{
					try {
						for(Banka bnk:ingGetir())
						{
							lblIngFaiz.setText(String.valueOf(bnk.banka_konut_faiz));
							lblIngToplamOdeme.setText(String.valueOf(Design.odenek(cmbVadeIng, vade, lblIngFaiz, txtIngTutar.getText())));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					float faiz=Float.parseFloat(lblTebFaiz.getText());
					girilenTutar= (int) ((int) ((girilenTutar*faiz)) + (vade*faiz));
				}
			}
		});
		cbBanka1.setBounds(601, 94, 72, 22);
		panel.add(cbBanka1);

		
		JLabel lblTutar_1 = new JLabel("Tutar");
		lblTutar_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblTutar_1.setBounds(33, 174, 46, 14);
		panel.add(lblTutar_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vade");
		lblNewLabel_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(282, 174, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Kredi T\u00FCr\u00FC");
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(528, 174, 97, 14);
		panel.add(lblNewLabel_1_1_2);
		
		JComboBox cbBanka2 = new JComboBox();
		cbBanka2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbBanka2.getSelectedItem().equals("İhtiyaç"))
				{
					try {
						for(Banka bnk:qnbGetir())
						{
							lblQnbFaiz.setText(String.valueOf(bnk.banka_ihtiyac_faiz));
							lblQnbToplamOdeme.setText(String.valueOf(Design.odenek(cmbVadeQnb, vade, lblQnbFaiz, txtQnbTutar.getText())));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
				{
					try {
						for(Banka bnk:qnbGetir())
						{
							lblQnbFaiz.setText(String.valueOf(bnk.banka_konut_faiz));
							lblQnbToplamOdeme.setText(String.valueOf(Design.odenek(cmbVadeQnb, vade, lblQnbFaiz, txtQnbTutar.getText())));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
			
		});
		cbBanka2.setBounds(601, 170, 72, 22);
		panel.add(cbBanka2);
		
		JLabel lblTutar_2 = new JLabel("Tutar");
		lblTutar_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblTutar_2.setBounds(33, 250, 46, 14);
		panel.add(lblTutar_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Vade");
		lblNewLabel_1_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(283, 250, 46, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Kredi T\u00FCr\u00FC");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(528, 250, 97, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JComboBox cbBanka3 = new JComboBox();
		cbBanka3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cbBanka3.getSelectedItem().equals("İhtiyaç"))
				{
					try {
						for(Banka bnk:tebGetir())
						{
							lblTebFaiz.setText(String.valueOf(bnk.banka_ihtiyac_faiz));
							lblTebToplamOdeme.setText(String.valueOf(Design.odenek(cmbVadeTeb, vade, lblTebFaiz, txtTutarTeb.getText())));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
				{
					try {
						for(Banka bnk:tebGetir())
						{
							lblTebFaiz.setText(String.valueOf(bnk.banka_konut_faiz));
							lblTebToplamOdeme.setText(String.valueOf(Design.odenek(cmbVadeTeb, vade, lblTebFaiz, txtTutarTeb.getText())));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			
			}
		});
		cbBanka3.setBounds(601, 246, 72, 22);
		panel.add(cbBanka3);
		JComboBox cbBanka4 = new JComboBox();
		JComboBox cbBanka6 = new JComboBox();
		cbBanka4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbBanka4.getSelectedItem().equals("İhtiyaç")) {
				try {
					for(Banka bnk:akbankGetir())
					{
						lblAkbankFaiz.setText(String.valueOf(bnk.banka_ihtiyac_faiz));
						lblAkbankToplamOdeme.setText(String.valueOf(Design.odenek(cmbAkbankVade, vade, lblAkbankFaiz, txtAkbankTutar.getText())));
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			else
			{
				try {
					for(Banka bnk:akbankGetir())
					{
						lblAkbankFaiz.setText(String.valueOf(bnk.banka_konut_faiz));
						lblAkbankToplamOdeme.setText(String.valueOf(Design.odenek(cmbAkbankVade, vade, lblAkbankFaiz, txtAkbankTutar.getText())));
					}
					}
				 catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		
		JComboBox cbBanka5 = new JComboBox();
		cbBanka5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbBanka5.getSelectedItem().equals("İhtiyaç")) {
					try {
						for(Banka bnk:garantiBankGetir())
						{
							lblGarantiFaiz.setText(String.valueOf(bnk.banka_ihtiyac_faiz));
							lblGarantiToplamOdeme.setText(String.valueOf(Design.odenek(cmbGarantiVade, vade, lblGarantiFaiz, txtGarantiTutar.getText())));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
				{
					try {
						for(Banka bnk:garantiBankGetir())
						{
							lblGarantiFaiz.setText(String.valueOf(bnk.banka_konut_faiz));
							lblGarantiToplamOdeme.setText(String.valueOf(Design.odenek(cmbGarantiVade, vade, lblGarantiFaiz, txtGarantiTutar.getText())));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		cbBanka6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbBanka6.getSelectedItem().equals("İhtiyaç")) {
					try {
						for(Banka bnk:denizBankGetir())
						{
							lblDenizFaiz.setText(String.valueOf(bnk.banka_ihtiyac_faiz));
							lblDenizToplamOdeme.setText(String.valueOf(Design.odenek(cmbDenizbankVade, vade, lblDenizFaiz, txtDenizbankTutar.getText())));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
				{
					try {
						for(Banka bnk:denizBankGetir())
						{
							lblDenizFaiz.setText(String.valueOf(bnk.banka_konut_faiz));
							lblDenizToplamOdeme.setText(String.valueOf(Design.odenek(cmbDenizbankVade, vade, lblDenizFaiz, txtDenizbankTutar.getText())));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		JButton img1 = new JButton("");
		img1.setBounds(667, 48, 117, 41);
		panel.add(img1);
		
		img1.setBorder(new EmptyBorder(0, 0, 0, 0));
		img1.setIcon(new ImageIcon("src\\images\\ing.png"));
		img1.setOpaque(false);
		
		JButton img2 = new JButton("");
		img2.setOpaque(false);
		img2.setBorder(new EmptyBorder(0, 0, 0, 0));
		img2.setBounds(667, 127, 117, 41);
		panel.add(img2);
		
		JButton img3 = new JButton("");
		img3.setOpaque(false);
		img3.setBorder(new EmptyBorder(0, 0, 0, 0));
		img3.setBounds(667, 203, 117, 41);
		panel.add(img3);
		img2.setBorder(new EmptyBorder(0, 0, 0, 0));
		img2.setIcon(new ImageIcon("src\\images\\qnb.png"));
		img2.setOpaque(false);

		img3.setBorder(new EmptyBorder(0, 0, 0, 0));
		img3.setIcon(new ImageIcon("src\\images\\teb.png"));
		img3.setOpaque(false);
		

		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Faiz");
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(683, 252, 33, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Faiz");
		lblNewLabel_1_1_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(683, 174, 24, 14);
		panel.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Faiz");
		lblNewLabel_1_1_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_3.setBounds(683, 98, 33, 14);
		panel.add(lblNewLabel_1_1_3);
		
	
		
		
		cmbVadeIng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIngToplamOdeme.setText(String.valueOf(Design.odenek(cmbVadeIng, vade, lblIngFaiz, txtIngTutar.getText())));
				
			}
		});
		cmbVadeIng.setBounds(339, 96, 148, 22);
		panel.add(cmbVadeIng);
		

		cmbVadeQnb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblQnbToplamOdeme.setText(String.valueOf(Design.odenek(cmbVadeQnb, vade, lblQnbFaiz, txtQnbTutar.getText())));
			}
		});
		cmbVadeQnb.setBounds(339, 172, 148, 22);
		panel.add(cmbVadeQnb);
		
		
		cmbVadeTeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTebToplamOdeme.setText(String.valueOf(Design.odenek(cmbVadeTeb, vade, lblTebFaiz, txtTutarTeb.getText())));
				
			}
		});
		cmbVadeTeb.setBounds(339, 248, 148, 22);
		panel.add(cmbVadeTeb);
		
		cmbDenizbankVade.setOpaque(true);
		cmbDenizbankVade.setBackground(Color.WHITE);
		cmbDenizbankVade.setBounds(339, 466, 148, 22);
		panel.add(cmbDenizbankVade);
		
		cmbGarantiVade.setOpaque(true);
		cmbGarantiVade.setBackground(Color.WHITE);
		cmbGarantiVade.setBounds(339, 394, 148, 22);
		panel.add(cmbGarantiVade);
		cmbAkbankVade.setOpaque(true);
		cmbAkbankVade.setBackground(Color.WHITE);
		cmbAkbankVade.setBounds(339, 322, 148, 22);
		panel.add(cmbAkbankVade);
	
		Design.vadeDoldur(cmbVadeIng);
		Design.vadeDoldur(cmbAkbankVade);
		Design.vadeDoldur(cmbGarantiVade);
		Design.vadeDoldur(cmbDenizbankVade);
		Design.vadeDoldur(cmbVadeQnb);
		Design.vadeDoldur(cmbVadeTeb);
		
		cbBanka1.setBackground(Color.WHITE);
		cbBanka1.setOpaque(true);
		cbBanka2.setBackground(Color.WHITE);
		cbBanka2.setOpaque(true);
		cbBanka3.setBackground(Color.WHITE);
		cbBanka3.setOpaque(true);
		cmbVadeIng.setBackground(Color.WHITE);
		cmbVadeIng.setOpaque(true);
		cmbVadeQnb.setBackground(Color.WHITE);
		cmbVadeQnb.setOpaque(true);
		
		cmbVadeTeb.setBackground(Color.WHITE);
		cmbVadeTeb.setOpaque(true);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Toplam \u00D6deme:");
		lblNewLabel_1_1_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_4.setBounds(794, 95, 108, 20);
		panel.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_4_1 = new JLabel("Toplam \u00D6deme:");
		lblNewLabel_1_1_4_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_4_1.setBounds(794, 171, 108, 20);
		panel.add(lblNewLabel_1_1_4_1);
		
		JLabel lblNewLabel_1_1_4_2 = new JLabel("Toplam \u00D6deme:");
		lblNewLabel_1_1_4_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_4_2.setBounds(794, 247, 108, 20);
		panel.add(lblNewLabel_1_1_4_2);
		

		
	

		
		txtIngTutar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtIngTutar, e, dot);
			}
			@Override
			public void keyReleased(KeyEvent e) {

				
				System.out.println(girilenTutar);
				
				try {
					lblIngToplamOdeme.setText(""+Design.odenek(cmbVadeIng, vade, lblIngFaiz, txtIngTutar.getText()));
				} catch (Exception e2) {
					girilenTutar = 0;
					lblIngToplamOdeme.setText("0");
				}
			
				if(Integer.valueOf(lblIngToplamOdeme.getText())>0)
				{
					kredial1.setVisible(true);
				}
				else
				{
					kredial1.setVisible(false);
				}
			}
			
			
		});
		txtIngTutar.setBounds(97, 95, 136, 20);
		panel.add(txtIngTutar);
		txtIngTutar.setColumns(10);
				txtQnbTutar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				
				System.out.println(girilenTutar);
				
				try {
					lblQnbToplamOdeme.setText(""+Design.odenek(cmbVadeQnb, vade, lblQnbFaiz, txtQnbTutar.getText()));
				} catch (Exception e2) {
					girilenTutar = 0;
					lblQnbToplamOdeme.setText("0");
				}
				if(Integer.valueOf(lblQnbToplamOdeme.getText())>0)
				{
					kredial2.setVisible(true);
				}
				else
				{
					kredial2.setVisible(false);
				}
			
			}
	
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtQnbTutar, e, dot);
			}
		});
		txtQnbTutar.setColumns(10);
		txtQnbTutar.setBounds(97, 173, 136, 20);
		panel.add(txtQnbTutar);
		
		
		txtTutarTeb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					lblTebToplamOdeme.setText(""+Design.odenek(cmbVadeTeb, vade, lblTebFaiz, txtTutarTeb.getText()));
				} catch (Exception e2) {
					girilenTutar = 0;
					lblTebToplamOdeme.setText("0");
				}
				
				if(Integer.valueOf(lblTebToplamOdeme.getText())>0)
				{
					kredial3.setVisible(true);
				}
				else
				{
					kredial3.setVisible(false);
				}
			}
			
			
			
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtTutarTeb, e, dot);
			}
		});
		txtTutarTeb.setColumns(10);
		txtTutarTeb.setBounds(97, 249, 136, 20);
		panel.add(txtTutarTeb);
		
		JButton btnNewButton_1_1 = new JButton("Ana Men\u00FC");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(967, 11, 108, 41);
		panel.add(btnNewButton_1_1);
		Design.setbtn(btnNewButton_1_1, Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setBounds(713, 176, 11, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setBounds(714, 99, 11, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("%");
		lblNewLabel_3.setBounds(713, 253, 11, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblTutar_2_1 = new JLabel("Tutar");
		lblTutar_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblTutar_2_1.setBounds(33, 324, 46, 14);
		panel.add(lblTutar_2_1);
		
		
	
		txtAkbankTutar.setColumns(10);
		txtAkbankTutar.setBounds(97, 323, 136, 20);
		panel.add(txtAkbankTutar);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Vade");
		lblNewLabel_1_3_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(283, 324, 46, 14);
		panel.add(lblNewLabel_1_3_1);
		
		
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Kredi Türü");
		lblNewLabel_1_1_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(528, 324, 97, 14);
		panel.add(lblNewLabel_1_1_1_2);
		
		
		
		
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Faiz");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(683, 326, 33, 14);
		panel.add(lblNewLabel_1_1_1_1_1);
		
	
		
		JLabel lblNewLabel_1_1_4_2_1 = new JLabel("Toplam Ödeme:");
		lblNewLabel_1_1_4_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_4_2_1.setBounds(794, 321, 108, 20);
		panel.add(lblNewLabel_1_1_4_2_1);
		
		
		JButton img4 = new JButton("");
		img4.setOpaque(false);
		img4.setBorder(new EmptyBorder(0, 0, 0, 0));
		img4.setBounds(667, 277, 117, 41);
		panel.add(img4);
		
		JLabel lblTutar_2_2 = new JLabel("Tutar");
		lblTutar_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblTutar_2_2.setBounds(33, 396, 46, 14);
		panel.add(lblTutar_2_2);
		
		
		txtGarantiTutar.setColumns(10);
		txtGarantiTutar.setBounds(97, 395, 136, 20);
		panel.add(txtGarantiTutar);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Vade");
		lblNewLabel_1_3_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_3_2.setBounds(283, 396, 46, 14);
		panel.add(lblNewLabel_1_3_2);
		
		img4.setIcon(new ImageIcon("src\\images\\akbank.png"));
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Kredi Türü");
		lblNewLabel_1_1_1_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_3.setBounds(528, 396, 97, 14);
		panel.add(lblNewLabel_1_1_1_3);
		
		
		
		
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Faiz");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2.setBounds(683, 398, 33, 14);
		panel.add(lblNewLabel_1_1_1_1_2);
		
	
		
		JLabel lblNewLabel_1_1_4_2_2 = new JLabel("Toplam Ödeme:");
		lblNewLabel_1_1_4_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_4_2_2.setBounds(794, 393, 108, 20);
		panel.add(lblNewLabel_1_1_4_2_2);
		
	
		
		JButton img5 = new JButton("");
		img5.setOpaque(false);
		img5.setBorder(new EmptyBorder(0, 0, 0, 0));
		img5.setBounds(667, 349, 117, 41);
		panel.add(img5);
		img5.setIcon(new ImageIcon("src\\images\\garanti.png"));
		
		JLabel lblTutar_2_3 = new JLabel("Tutar");
		lblTutar_2_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblTutar_2_3.setBounds(33, 468, 46, 14);
		panel.add(lblTutar_2_3);
		
		
	
		txtDenizbankTutar.setColumns(10);
		txtDenizbankTutar.setBounds(97, 467, 136, 20);
		panel.add(txtDenizbankTutar);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Vade");
		lblNewLabel_1_3_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_3_3.setBounds(283, 468, 46, 14);
		panel.add(lblNewLabel_1_3_3);
		
		
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("Kredi Türü");
		lblNewLabel_1_1_1_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_4.setBounds(528, 468, 97, 14);
		panel.add(lblNewLabel_1_1_1_4);
		
		
		
		
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Faiz");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_3.setBounds(683, 470, 33, 14);
		panel.add(lblNewLabel_1_1_1_1_3);
		
	
		
		JLabel lblNewLabel_1_1_4_2_3 = new JLabel("Toplam Ödeme:");
		lblNewLabel_1_1_4_2_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblNewLabel_1_1_4_2_3.setBounds(794, 465, 108, 20);
		panel.add(lblNewLabel_1_1_4_2_3);
		
		
		
		JButton img6 = new JButton("");
		img6.setOpaque(false);
		img6.setBorder(new EmptyBorder(0, 0, 0, 0));
		img6.setBounds(667, 421, 117, 41);
		panel.add(img6);
		img4.setIcon(new ImageIcon("src\\images\\akbank.png"));
		img6.setIcon(new ImageIcon("src\\images\\denizbank.png"));
		

		
		cbBanka1.addItem("Konut");
		cbBanka2.addItem("Konut");
		cbBanka3.addItem("Konut");
		cbBanka4.addItem("Konut");
		cbBanka5.addItem("Konut");
		cbBanka6.addItem("Konut");
		
		cbBanka1.addItem("İhtiyaç");
		cbBanka2.addItem("İhtiyaç");
		cbBanka3.addItem("İhtiyaç");
		cbBanka4.addItem("İhtiyaç");
		cbBanka5.addItem("İhtiyaç");
		cbBanka6.addItem("İhtiyaç");
		
		JLabel lblNewLabel_3_1 = new JLabel("%");
		lblNewLabel_3_1.setBounds(714, 328, 11, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("%");
		lblNewLabel_3_2.setBounds(714, 399, 11, 14);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("%");
		lblNewLabel_3_3.setBounds(716, 471, 11, 14);
		panel.add(lblNewLabel_3_3);
		
		txtAkbankTutar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtAkbankTutar, e, dot);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					lblAkbankToplamOdeme.setText(""+Design.odenek(cmbAkbankVade, vade, lblAkbankFaiz, txtAkbankTutar.getText()));
			} 
			catch (Exception e2) {
				girilenTutar = 0;
				lblAkbankToplamOdeme.setText("0");
			}
				if(Integer.valueOf(lblAkbankToplamOdeme.getText())>0)
				{
					kredial4.setVisible(true);
				}
				else
				{
					kredial4.setVisible(false);
				}
			
		}
	
			
		});
		txtGarantiTutar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtGarantiTutar, e, dot);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					lblGarantiToplamOdeme.setText(""+Design.odenek(cmbGarantiVade, vade, lblGarantiFaiz, txtGarantiTutar.getText()));
			} 
			catch (Exception e2) {
				girilenTutar = 0;
				lblGarantiToplamOdeme.setText("0");
			}
				if(Integer.valueOf(lblGarantiToplamOdeme.getText())>0)
				{
					kredial5.setVisible(true);
				}
				else
				{
					kredial5.setVisible(false);
				}
			
		}
			
		});
		txtDenizbankTutar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtDenizbankTutar, e, dot);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					lblDenizToplamOdeme.setText(""+Design.odenek(cmbDenizbankVade, vade, lblDenizFaiz, txtDenizbankTutar.getText()));
					}
			catch (Exception e2) {
				girilenTutar = 0;
				lblDenizToplamOdeme.setText("0");
			}
			
			if(Integer.valueOf(lblDenizToplamOdeme.getText())>0)
			{
				kredial6.setVisible(true);
			}
			else
			{
				kredial6.setVisible(false);
			}
			}
		});
		
		
		cbBanka4.setOpaque(true);
		cbBanka4.setBackground(Color.WHITE);
		cbBanka4.setBounds(601, 320, 72, 22);
		panel.add(cbBanka4);
		
		cbBanka5.setOpaque(true);
		cbBanka5.setBackground(Color.WHITE);
		cbBanka5.setBounds(601, 392, 72, 22);
		panel.add(cbBanka5);
		
		cbBanka6.setOpaque(true);
		cbBanka6.setBackground(Color.WHITE);
		cbBanka6.setBounds(601, 464, 72, 22);
		panel.add(cbBanka6);
		
		
		
		kredial6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String kac_taksit=cmbDenizbankVade.getSelectedItem().toString().substring(cmbDenizbankVade.getSelectedItem().toString().indexOf("(")+1, cmbDenizbankVade.getSelectedItem().toString().indexOf("a"));
		
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
				LocalDate date = null;
				try
				{
					date = LocalDate.parse(frmGiris.aktifuye.uye_kredi_alım_tarihi, formatter);	
				}
				catch(Exception ex)
				{
					
				}
								
				String formattedString = date.format(formatter);
				frmGiris.aktifuye.uye_kredi_alım_tarihi=formattedString;
				BLLuye.zamanGuncelle(frmGiris.aktifuye,formattedString);
			} catch (NumberFormatException | SQLException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			System.out.println();
			frmGiris.aktifuye.uye_bakiye+=Integer.parseInt(lblDenizToplamOdeme.getText());
			frmGiris.aktifuye.uye_alinan_kredi=Integer.parseInt(lblDenizToplamOdeme.getText());	
			kredial6.setEnabled(false);
			kredial5.setEnabled(false);
			kredial4.setEnabled(false);
			kredial3.setEnabled(false);
			kredial2.setEnabled(false);
			kredial1.setEnabled(false);
			try {
				BLLuye.kredibakiyeGuncelle(frmGiris.aktifuye);
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		kredial1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kac_taksit=cmbVadeIng.getSelectedItem().toString().substring(cmbVadeIng.getSelectedItem().toString().indexOf("(")+1, cmbVadeIng.getSelectedItem().toString().indexOf("a"));
				
				try {
					BLLuye.taksitOlustur(frmGiris.aktifuye,Integer.parseInt(kac_taksit));
					DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

					LocalDate date = null;
					try
					{
						date = LocalDate.parse(frmGiris.aktifuye.uye_kredi_alım_tarihi, formatter);	
					}
					catch(Exception ex)
					{
						
					}
									
					String formattedString = date.format(formatter);
					frmGiris.aktifuye.uye_kredi_alım_tarihi=formattedString;
					BLLuye.zamanGuncelle(frmGiris.aktifuye,formattedString);
				} catch (NumberFormatException | SQLException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			frmGiris.aktifuye.uye_bakiye+=Integer.parseInt(lblIngToplamOdeme.getText());
			frmGiris.aktifuye.uye_alinan_kredi=Integer.parseInt(lblIngToplamOdeme.getText());	
			kredial6.setEnabled(false);
			kredial5.setEnabled(false);
			kredial4.setEnabled(false);
			kredial3.setEnabled(false);
			kredial2.setEnabled(false);
			kredial1.setEnabled(false);
			try {
				BLLuye.kredibakiyeGuncelle(frmGiris.aktifuye);
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		kredial2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
       String kac_taksit=cmbVadeQnb.getSelectedItem().toString().substring(cmbVadeQnb.getSelectedItem().toString().indexOf("(")+1, cmbVadeQnb.getSelectedItem().toString().indexOf("a"));
				
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
			
					LocalDate date = null;
					try
					{
						date = LocalDate.parse(frmGiris.aktifuye.uye_kredi_alım_tarihi, formatter);	
					}
					catch(Exception ex)
					{
						
					}
									
					String formattedString = date.format(formatter);
					frmGiris.aktifuye.uye_kredi_alım_tarihi=formattedString;
					BLLuye.zamanGuncelle(frmGiris.aktifuye,formattedString);
				} catch (NumberFormatException | SQLException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			frmGiris.aktifuye.uye_bakiye+=Integer.parseInt(lblQnbToplamOdeme.getText());
			frmGiris.aktifuye.uye_alinan_kredi=Integer.parseInt(lblQnbToplamOdeme.getText());	
			kredial6.setEnabled(false);
			kredial5.setEnabled(false);
			kredial4.setEnabled(false);
			kredial3.setEnabled(false);
			kredial2.setEnabled(false);
			kredial1.setEnabled(false);
			try {
				BLLuye.kredibakiyeGuncelle(frmGiris.aktifuye);
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		kredial3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
String kac_taksit=cmbVadeTeb.getSelectedItem().toString().substring(cmbVadeTeb.getSelectedItem().toString().indexOf("(")+1, cmbVadeTeb.getSelectedItem().toString().indexOf("a"));
				
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
					
					LocalDate date = null;
					try
					{
						date = LocalDate.parse(frmGiris.aktifuye.uye_kredi_alım_tarihi, formatter);	
					}
					catch(Exception ex)
					{
						
					}
									
					String formattedString = date.format(formatter);
					frmGiris.aktifuye.uye_kredi_alım_tarihi=formattedString;
					BLLuye.zamanGuncelle(frmGiris.aktifuye,formattedString);
				} catch (NumberFormatException | SQLException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			frmGiris.aktifuye.uye_bakiye+=Integer.parseInt(lblTebToplamOdeme.getText());
			frmGiris.aktifuye.uye_alinan_kredi=Integer.parseInt(lblTebToplamOdeme.getText());	
			kredial6.setEnabled(false);
			kredial5.setEnabled(false);
			kredial4.setEnabled(false);
			kredial3.setEnabled(false);
			kredial2.setEnabled(false);
			kredial1.setEnabled(false);
			try {
				BLLuye.kredibakiyeGuncelle(frmGiris.aktifuye);
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		kredial4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
String kac_taksit=cmbAkbankVade.getSelectedItem().toString().substring(cmbAkbankVade.getSelectedItem().toString().indexOf("(")+1, cmbAkbankVade.getSelectedItem().toString().indexOf("a"));
				
				try {
					BLLuye.taksitOlustur(frmGiris.aktifuye,Integer.parseInt(kac_taksit));
					DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
					LocalDate date = LocalDate.parse(frmGiris.aktifuye.uye_kredi_alım_tarihi, formatter);					
					String formattedString = date.format(formatter);
					frmGiris.aktifuye.uye_kredi_alım_tarihi=formattedString;
					BLLuye.zamanGuncelle(frmGiris.aktifuye,formattedString);
				} catch (NumberFormatException | SQLException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			frmGiris.aktifuye.uye_bakiye+=Integer.parseInt(lblAkbankToplamOdeme.getText());
			frmGiris.aktifuye.uye_alinan_kredi=Integer.parseInt(lblAkbankToplamOdeme.getText());	
			kredial6.setEnabled(false);
			kredial5.setEnabled(false);
			kredial4.setEnabled(false);
			kredial3.setEnabled(false);
			kredial2.setEnabled(false);
			kredial1.setEnabled(false);
			try {
				BLLuye.kredibakiyeGuncelle(frmGiris.aktifuye);
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		kredial5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
String kac_taksit=cmbGarantiVade.getSelectedItem().toString().substring(cmbGarantiVade.getSelectedItem().toString().indexOf("(")+1, cmbGarantiVade.getSelectedItem().toString().indexOf("a"));
				
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
					LocalDate date=null;
					try
					{
						date = LocalDate.parse(frmGiris.aktifuye.uye_kredi_alım_tarihi, formatter);	
					}
					catch(Exception ex)
					{
						
					}
									
					String formattedString = date.format(formatter);
					frmGiris.aktifuye.uye_kredi_alım_tarihi=formattedString;
					BLLuye.zamanGuncelle(frmGiris.aktifuye,formattedString);
				} catch (NumberFormatException | SQLException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			frmGiris.aktifuye.uye_bakiye+=Integer.parseInt(lblGarantiToplamOdeme.getText());
			frmGiris.aktifuye.uye_alinan_kredi=Integer.parseInt(lblGarantiToplamOdeme.getText());	
			kredial6.setEnabled(false);
			kredial5.setEnabled(false);
			kredial4.setEnabled(false);
			kredial3.setEnabled(false);
			kredial2.setEnabled(false);
			kredial1.setEnabled(false);
			try {
				BLLuye.kredibakiyeGuncelle(frmGiris.aktifuye);
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		kredial6.setOpaque(false);
		kredial6.setBorder(new EmptyBorder(0, 0, 0, 0));
		kredial6.setBounds(1037, 443, 66, 41);
		panel.add(kredial6);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 5, 5);
		contentPane.add(tabbedPane);
	
	}
}
