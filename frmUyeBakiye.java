package forms;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.BLLuye;
import design.Design;
import model.Personel;
import model.User;

import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class frmUyeBakiye extends JFrame {

	private JPanel contentPane;
int taksit_ucreti;
int alýnan_kredi=frmGiris.aktifuye.uye_alinan_kredi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(frmGiris.aktifuye!=null)
					{
					frmUyeBakiye frame = new frmUyeBakiye();
					frame.setVisible(true);
					}
					else
					{
						frmGiris frmgiris=new frmGiris();
						frmgiris.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */	
	static boolean dot = false;
	private JTextField textField;
	public frmUyeBakiye() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//if(frmGiris.aktifuye!=null)
		{
		JPanel panel_2 = new JPanel();
		JLabel lblNewLabel_2_1 = new JLabel("Kredi Durumu");
		JLabel lblBakiyemiGncelle_1_1 = new JLabel("0");
		lblBakiyemiGncelle_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblBakiyemiGncelle_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblBakiyemiGncelle_1_1.setBounds(232, 78, 136, 20);
		JLabel lblBakiyemiGncelle_1 = new JLabel("Durum");
		JLabel lblBakiyemiGncelle_1_2_1_1 = new JLabel("-");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				lblBakiyemiGncelle_1_2_1_1.setText(String.valueOf(frmGiris.aktifuye.uye_bakiye));
				if(frmGiris.aktifuye.uye_alinan_kredi>0)
				{
					lblBakiyemiGncelle_1.setText("Kredi Alinamaz, borcunuz bulunmakta.");
					lblBakiyemiGncelle_1_1.setText(String.valueOf(frmGiris.aktifuye.uye_alinan_kredi));
					panel_2.setVisible(false);
					
				}
				else
				{
					lblBakiyemiGncelle_1.setText("Kredi alabilirsiniz.");
					
				}
			}
		});
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		contentPane.add(tabbedPane);
		
		JLabel lblBakiyemiGncelle_1_1_1 = new JLabel("0");
		lblBakiyemiGncelle_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblBakiyemiGncelle_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblBakiyemiGncelle_1_1_1.setBounds(237, 215, 136, 20);
		panel_2.add(lblBakiyemiGncelle_1_1_1);
					
					JPanel panel_1 = new JPanel();
					tabbedPane.addTab("Bakiye Ekle", null, panel_1, null);
					panel_1.setLayout(null);
					
					JLabel lblNewLabel_2_1_1 = new JLabel("Bakiye Yukle");
					lblNewLabel_2_1_1.setBounds(183, 11, 160, 41);
					lblNewLabel_2_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
					
					panel_1.add(lblNewLabel_2_1_1);
					
					JButton btnBakiyem_1_1 = new JButton("Bakiye Ekle");
					
					
				
					btnBakiyem_1_1.setBounds(148, 219, 234, 39);
					
					btnBakiyem_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
							frmGiris.aktifuye.uye_bakiye+=Integer.parseInt(textField.getText());
							lblBakiyemiGncelle_1_2_1_1.setText(String.valueOf(frmGiris.aktifuye.uye_bakiye));
							try {
								BLLuye.bakiyeGuncelle(frmGiris.aktifuye);
							} catch (SQLException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						}
					});
					btnBakiyem_1_1.setMargin(new Insets(10, 10, 10, 10));
					panel_1.add(btnBakiyem_1_1);
					
					JLabel lblYeniBakiye = new JLabel("Yeni Bakiye");
					lblYeniBakiye.setBounds(74, 183, 67, 20);
					lblYeniBakiye.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
					panel_1.add(lblYeniBakiye);
					
					textField = new JTextField();
					textField.setBounds(148, 185, 234, 20);
					textField.setColumns(10);
					panel_1.add(textField);
					
	
					JLabel lblAylkBorcunuz_1 = new JLabel("Ayl\u0131k Taksitiniz:");
					lblAylkBorcunuz_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
					lblAylkBorcunuz_1.setBounds(67, 176, 382, 30);
					panel_2.add(lblAylkBorcunuz_1);
					panel_2.setLayout(null);
					tabbedPane.addTab("Kredi Borcu \u00D6de", null, panel_2, null);
					
					JLabel lblNewLabel_2_1_2 = new JLabel("Kredi Borcu \u00D6de");
					lblNewLabel_2_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
					lblNewLabel_2_1_2.setBounds(145, 6, 234, 51);
					panel_2.add(lblNewLabel_2_1_2);
					
					JLabel lblToplamBor = new JLabel("Toplam Bor\u00E7:");
					lblToplamBor.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
					lblToplamBor.setBounds(130, 73, 79, 30);
					panel_2.add(lblToplamBor);
					JButton btnNewButton_1_1_2_1 = new JButton("Kredi Al");
					lblBakiyemiGncelle_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblBakiyemiGncelle_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
					lblBakiyemiGncelle_1.setBounds(0, 69, 490, 143);
					
					JButton btnNewButton = new JButton("T\u00FCm Borcu \u00D6de");
					try
					{
						taksit_ucreti=(alýnan_kredi/frmGiris.aktifuye.uye_aylýk_taksit);
					}
					catch(Exception ex)
					{
						
					}
				
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							if(frmGiris.aktifuye.uye_bakiye>=alýnan_kredi)
							{
								
							frmGiris.aktifuye.uye_alinan_kredi=0;	
							frmGiris.aktifuye.uye_bakiye-=frmGiris.aktifuye.uye_bakiye-frmGiris.aktifuye.uye_alinan_kredi;
							try {
								BLLuye.kredibakiyeGuncelle(frmGiris.aktifuye);
								lblAylkBorcunuz_1.setText("Ödemeniz yoktur.");
								try
								{
									 taksit_ucreti=(alýnan_kredi/frmGiris.aktifuye.uye_aylýk_taksit);
								}
							   catch(Exception ex)
							   {
								   
							   }
								
								lblBakiyemiGncelle_1_1_1.setText(String.valueOf("0"));
								lblBakiyemiGncelle_1_1.setText(String.valueOf(frmGiris.aktifuye.uye_alinan_kredi));
								lblBakiyemiGncelle_1_2_1_1.setText(String.valueOf(frmGiris.aktifuye.uye_bakiye));
							
							} catch (SQLException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Kredi borcunuzdan yuksek miktarda odeme yapamazsiniz.");
							}
							if(frmGiris.aktifuye.uye_alinan_kredi>0)
							{
								lblBakiyemiGncelle_1.setText("Kredi Alinamaz, borcunuz bulunmakta.");		
								btnNewButton_1_1_2_1.setVisible(false);
								
							}
							else
							{
								lblBakiyemiGncelle_1.setText("Kredi alabilirsiniz.");
								btnNewButton_1_1_2_1.setVisible(true);
								
							}
						}
					});
					btnNewButton.setBounds(130, 114, 243, 23);
					panel_2.add(btnNewButton);
					panel_2.add(lblBakiyemiGncelle_1_1);
					JPanel panel = new JPanel();
					panel.addComponentListener(new ComponentAdapter() {
						@Override
						public void componentShown(ComponentEvent e) {
							if(frmGiris.aktifuye.uye_alinan_kredi<=0)
							{
								
							btnNewButton_1_1_2_1.setVisible(true);
							}
							else
							{
								System.out.println("alamaz");
							}
						}
					});
					
					panel.setLayout(null);
					tabbedPane.addTab("Kredi Durumu", null, panel, null);
					
					
				
					lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
					lblNewLabel_2_1.setBounds(157, 7, 181, 51);
					panel.add(lblNewLabel_2_1);
					
					panel.add(lblBakiyemiGncelle_1);
					
				

		
					
	
					
					lblBakiyemiGncelle_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblBakiyemiGncelle_1_2_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
					lblBakiyemiGncelle_1_2_1_1.setBounds(148, 80, 207, 20);
					panel_1.add(lblBakiyemiGncelle_1_2_1_1);
					
					JLabel lblBakiyemiGncelle_1_2_2 = new JLabel("Bakiyeniz:");
					lblBakiyemiGncelle_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
					lblBakiyemiGncelle_1_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
					lblBakiyemiGncelle_1_2_2.setBounds(74, 81, 65, 20);
					panel_1.add(lblBakiyemiGncelle_1_2_2);
					Design.setbtn(btnNewButton_1_1_2_1, Color.WHITE);
					Design.setbtn(btnBakiyem_1_1, Color.WHITE);
					Design.setbtn(btnNewButton, Color.WHITE);
					
					try
					{
						taksit_ucreti=(alýnan_kredi/frmGiris.aktifuye.uye_aylýk_taksit);
					}
					catch(Exception ex)
					{
						
					}
					
					lblAylkBorcunuz_1.setText("En yakýn taksit ödemeniz: "+frmGiris.aktifuye.uye_kredi_alým_tarihi+" tarihinde tahsil edilecektir.");
					JButton btnNewButton_1 = new JButton("Ayl\u0131k Taksit \u00D6de");
					
				
					
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						taksit_ucreti=(alýnan_kredi/frmGiris.aktifuye.uye_aylýk_taksit);
					
						
						try {
							if(frmGiris.aktifuye.uye_bakiye>=taksit_ucreti)
							{

							
								
								DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
								LocalDate date = LocalDate.parse(frmGiris.aktifuye.uye_kredi_alým_tarihi, formatter);
							System.out.println(date+" "+date.now());
								
								if(date.equals(date.now())&&frmGiris.aktifuye.uye_alinan_kredi>0)
								{
									date.plusMonths(1);
									String formattedString = date.format(formatter);
									frmGiris.aktifuye.uye_kredi_alým_tarihi=formattedString;		
									frmGiris.aktifuye.uye_alinan_kredi=alýnan_kredi-taksit_ucreti;
									BLLuye.kredibakiyeGuncelle(frmGiris.aktifuye);
									frmGiris.aktifuye.uye_bakiye=alýnan_kredi-taksit_ucreti;
						         	BLLuye.bakiyeGuncelle(frmGiris.aktifuye);
									alýnan_kredi=frmGiris.aktifuye.uye_alinan_kredi;
									BLLuye.zamanGuncelle(frmGiris.aktifuye,formattedString);
									lblAylkBorcunuz_1.setText("En yakýn taksit ödemeniz: "+date+" tarihinde tahsil edilecektir.");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Bu ay için ödemeniz yoktur.");
								}
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Bakiyeniz taksit ödemeye yeterli deðil!");
							}
							
							lblBakiyemiGncelle_1_1.setText(String.valueOf(frmGiris.aktifuye.uye_alinan_kredi));
							
							lblBakiyemiGncelle_1_1_1.setText(String.valueOf(taksit_ucreti));
						} catch (SQLException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					});
					btnNewButton_1.setBounds(131, 243, 243, 23);
					panel_2.add(btnNewButton_1);
					
					JLabel lblAylkBorcunuz = new JLabel("Ayl\u0131k Taksitiniz:");
					lblAylkBorcunuz.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
					lblAylkBorcunuz.setBounds(130, 210, 98, 30);
					panel_2.add(lblAylkBorcunuz);
		
					lblBakiyemiGncelle_1_1_1.setText(String.valueOf(taksit_ucreti));
					Design.setbtn(btnNewButton_1, Color.white);
					
					
					
				
	}
		
	}
}
