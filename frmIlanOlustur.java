package forms;

import java.awt.*;
import java.awt.EventQueue;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import bll.BLLbanka;
import bll.BLLilan;
import bll.BLLpersonel;
import design.Design;
import model.Banka;
import model.Ilan;
import model.Personel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.text.html.ImageView;
import javax.swing.text.Element;
import java.awt.Window.Type;


public class frmIlanOlustur extends JFrame {

	private JPanel contentPane;
	private JTextField txtSehir;
	private JTextField txtMah;
	private JTextField txtFiyat;
	private JTextField txtOda1;
	private JTextField txtSalon;
	private JTextField txtm2;
	private JTextField txtIlce;
	private JTextField txtSite;
	private JTextField txtAidat;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmIlanOlustur frame = new frmIlanOlustur();
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
	String satilikmi;
	boolean kredi;
	static boolean dot;
    String kredi_durumu;
    public static File file;
    public static File xxxx;
    Image image;
	JLabel picLabel;
	JFileChooser chooser;
	int dialogButton;
    FileInputStream fis;
	FileNameExtensionFilter filter;
	File newFile;
	public frmIlanOlustur() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 437, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 421, 772);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u0130lan Olu\u015Ftur");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(33, 11, 183, 51);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblSehir = new JLabel("\u015Eehir");
		lblSehir.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblSehir.setBounds(33, 123, 46, 14);
		panel.add(lblSehir);
		
		JLabel lblIlce = new JLabel("\u0130l\u00E7e");
		lblIlce.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblIlce.setBounds(33, 148, 46, 14);
		panel.add(lblIlce);
	
		txtSehir = new JTextField();
		txtSehir.setColumns(10);
		txtSehir.setBounds(94, 120, 139, 20);
		panel.add(txtSehir);
		
		txtMah = new JTextField();
		txtMah.setColumns(10);
		txtMah.setBounds(94, 179, 139, 20);
		panel.add(txtMah);
		
		JLabel lblMahalle = new JLabel("Mahalle");
		lblMahalle.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblMahalle.setBounds(33, 182, 51, 14);
		panel.add(lblMahalle);
		
		
		
		JRadioButton rdbtnKrediUygunDegil = new JRadioButton("De\u011Fil");
		JRadioButton rdbtnKrediUygun = new JRadioButton("Uygun");
		rdbtnKrediUygun.setBounds(115, 463, 104, 23);
		rdbtnKrediUygunDegil.setBounds(218, 463, 80, 23);
		panel.add(rdbtnKrediUygunDegil);
		panel.add(rdbtnKrediUygun);
		rdbtnKrediUygunDegil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnKrediUygun.setSelected(false);
			}
		});
		
	
	
		rdbtnKrediUygun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnKrediUygunDegil.setSelected(false);
			}
		});
		
		
		
		
		
		JTextArea txtAciklama = new JTextArea();
		txtAciklama.setBounds(115, 332, 250, 119);
		panel.add(txtAciklama);
		JRadioButton rdbtnSatilik = new JRadioButton("");
		JRadioButton rdbtnKiralik = new JRadioButton("");
		rdbtnKiralik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSatilik.setSelected(false);
			}
		});
		rdbtnKiralik.setBounds(112, 299, 32, 23);
		panel.add(rdbtnKiralik);
		
		
		rdbtnSatilik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnKiralik.setSelected(false);
			}
		});
		rdbtnSatilik.setBounds(112, 272, 32, 23);
		panel.add(rdbtnSatilik);
		JComboBox cbEmlakTip = new JComboBox();
		
		cbEmlakTip.setBounds(115, 90, 118, 22);
		
		
		cbEmlakTip.addItem("Daire");
		cbEmlakTip.addItem("Residance");
		cbEmlakTip.addItem("Müstakil Ev");
		cbEmlakTip.addItem("Villa");
		cbEmlakTip.addItem("Ciftlik Evi");
		cbEmlakTip.addItem("Yali");
		cbEmlakTip.addItem("Kooperatif");
		cbEmlakTip.addItem("Yazlik");
		cbEmlakTip.addItem("Kösk & Konak");
		cbEmlakTip.addItem("Arsa");
		panel.add(cbEmlakTip);
		
	
		
		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblFiyat.setBounds(33, 208, 27, 20);
		panel.add(lblFiyat);
		
		txtFiyat = new JTextField();
		txtFiyat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtFiyat, e, dot);
			}
		});
		txtFiyat.setColumns(10);
		txtFiyat.setBounds(94, 210, 139, 20);
		panel.add(txtFiyat);
		
		JLabel lblOdaSayi = new JLabel("Oda say\u0131s\u0131");
		lblOdaSayi.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblOdaSayi.setBounds(33, 241, 72, 20);
		panel.add(lblOdaSayi);
		
		txtOda1 = new JTextField();
		txtOda1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
			}
			@Override
			public void keyReleased(KeyEvent e) {
			
			}
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtOda1, e, dot);
			}
		});
		txtOda1.setColumns(10);
		txtOda1.setBounds(113, 243, 38, 20);
		panel.add(txtOda1);
		
		txtSalon = new JTextField();
		txtSalon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
			}
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtSalon, e, true);
			}
		});
		txtSalon.setColumns(10);
		txtSalon.setBounds(195, 243, 38, 20);
		panel.add(txtSalon);
		
		JLabel lblPlus = new JLabel("+");
		lblPlus.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblPlus.setBounds(167, 241, 11, 20);
		panel.add(lblPlus);
		
		JLabel lblSatilik = new JLabel("Sat\u0131l\u0131k");
		lblSatilik.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblSatilik.setBounds(33, 272, 38, 20);
		panel.add(lblSatilik);
		
	
		JLabel lblKiralik = new JLabel("Kiral\u0131k");
		lblKiralik.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblKiralik.setBounds(33, 299, 38, 20);
		panel.add(lblKiralik);
		
		
		
		JLabel lblAcikla = new JLabel("A\u00E7\u0131klama");
		lblAcikla.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblAcikla.setBounds(33, 330, 72, 14);
		panel.add(lblAcikla);
		
		JLabel lblM2 = new JLabel("M2");
		lblM2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblM2.setBounds(33, 493, 27, 20);
		panel.add(lblM2);
		
		txtm2 = new JTextField();
		txtm2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtm2, e, true);
			}
		});
		txtm2.setColumns(10);
		txtm2.setBounds(94, 495, 139, 20);
		panel.add(txtm2);
		
		txtIlce = new JTextField();
		txtIlce.setColumns(10);
		txtIlce.setBounds(94, 148, 139, 20);
		panel.add(txtIlce);
		
		txtSite = new JTextField();
		txtSite.setColumns(10);
		txtSite.setBounds(94, 526, 139, 20);
		panel.add(txtSite);
		
		JLabel lblSiteAdi = new JLabel("Site Ad\u0131");
		lblSiteAdi.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblSiteAdi.setBounds(33, 527, 51, 14);
		panel.add(lblSiteAdi);
		
		txtAidat = new JTextField();
		txtAidat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Design.sayiYazdir(txtAidat, e, true);
			}
		});
		txtAidat.setColumns(10);
		txtAidat.setBounds(94, 557, 139, 20);
		panel.add(txtAidat);

	
		JLabel lblAidat = new JLabel("Aidat");
		lblAidat.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblAidat.setBounds(33, 557, 51, 14);
		panel.add(lblAidat);
		
				JLabel lblEmlakTip = new JLabel("Emlak Tipi");
				lblEmlakTip.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				lblEmlakTip.setBounds(33, 89, 72, 20);
				panel.add(lblEmlakTip);
				cbEmlakTip.setBackground(Color.WHITE);
				
				JLabel lblKrediye = new JLabel("Krediye");
				lblKrediye.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				lblKrediye.setBounds(33, 467, 72, 14);
				panel.add(lblKrediye);
				
				JButton btnEkleFoto = new JButton("Foto\u011Fraf Ekle");
				btnEkleFoto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						chooser = new JFileChooser();
					   filter = new FileNameExtensionFilter(
					        "JPG, PNG Images", "jpg","png");
					    chooser.setFileFilter(filter);
					    chooser.showOpenDialog(null);
					   file = chooser.getSelectedFile();
					   xxxx = file;
					   
					   try {
						BufferedImage myPicture = ImageIO.read(file);
						if(myPicture.getWidth()<=1000 && myPicture.getHeight()<=1000)
						{	
						 final JOptionPane jop= new JOptionPane(null,JOptionPane.INFORMATION_MESSAGE,JOptionPane.DEFAULT_OPTION,new ImageIcon(myPicture),new Object[]{}, null);
						 final JDialog dialog=new JDialog();
						 dialog.setTitle("Message");
						 dialog.setModal(true);
						 dialog.setContentPane(jop);
						 dialog.pack();
						 Timer timer = new Timer(1000, new AbstractAction() {
							    @Override
							    public void actionPerformed(ActionEvent ae) {
							      
							        JOptionPane.showMessageDialog(null, "Fotografınız eklenmistir.","",JOptionPane.PLAIN_MESSAGE);
							        if(dialogButton == JOptionPane.OK_OPTION) {
							        	dialog.dispose();
						              }
							    }
							});
						 timer.setRepeats(false);
						timer.start();
						dialog.setVisible(true);

						   String path ="src\\ilan_fotograflari\\";
						   File f1 = new File(path.trim());  
						   boolean bool = f1.mkdir();  
						   if(bool){  
						         System.out.println("Folder is created successfully");  
						      }else{  
						         System.out.println("Error Found!");  
						      }  
						   newFile = new File(path+"\\" +txtSite.getText()+txtSehir.getText()+txtMah.getText()+txtIlce.getText()+txtFiyat.getText()+".jpg");
						   copyFileUsingChannel(file, newFile);
						  
			            }
					   else
					   {
						   JOptionPane.showMessageDialog(null,"Eklenecek fotograf boyutu 1000x1000 cozunurlukte veya daha küçük boyutta olmalidir.","Fotograf secimi basarisiz.",JOptionPane.WARNING_MESSAGE);
					   }
					   }
					   catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					   }
					   System.out.println(newFile.getName());
					  

					   
				        }
				});
				btnEkleFoto.setBounds(130, 644, 168, 76);
				panel.add(btnEkleFoto);
				
				
				
				
				JButton btnOlutur = new JButton("\u0130lan Olu\u015Ftur");
				btnOlutur.setBounds(130, 731, 168, 30);
				panel.add(btnOlutur);
				btnOlutur.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(rdbtnKrediUygun.isSelected())
						{
							kredi=true;
							kredi_durumu="Krediye uygun";
							
						}
						if(rdbtnKrediUygunDegil.isSelected())
						{
							kredi=false;
							kredi_durumu="Krediye uygun degil.";
							
						}
						
						if(rdbtnKiralik.isSelected()==true)
						{
							satilikmi="Kiralik";
							
						}
						if(rdbtnSatilik.isSelected()==true)
						{
							satilikmi="Satilik";
							
						}
						
					Ilan ilan=new Ilan(
							Integer.parseInt(txtFiyat.getText()),
							Integer.parseInt(txtm2.getText()),
							txtOda1.getText()+"+"+txtSalon.getText(),
							txtSite.getText(),
							Integer.parseInt(txtAidat.getText()),
							kredi_durumu,
							txtAciklama.getText(),
							cbEmlakTip.getSelectedItem().toString(),				
							txtMah.getText(),
							txtSehir.getText(),
							txtIlce.getText(),
							satilikmi,
							frmGiris.aktifuye.uye_telefon,
							newFile.getName()
							);
					try {
						
						
						BLLilan.ilanKaydet(ilan);
						txtAciklama.setText("");
						txtAidat.setText("");
						txtFiyat.setText("");
						txtIlce.setText("");
						txtm2.setText("");
						txtMah.setText("");
						txtSehir.setText("");
						txtSite.setText("");
						
						
					} catch (SQLException | IOException e1) {
						 
						e1.printStackTrace();
					}
					
					}
				});
		
		cbEmlakTip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbEmlakTip.getSelectedItem()=="Arsa")
				{
					setBounds(100, 100, 437, 670);
					lblAidat.setVisible(false);
					lblKiralik.setVisible(false);
					lblOdaSayi.setVisible(false);
					lblSiteAdi.setVisible(false);
					lblSatilik.setVisible(false);
					txtAidat.setVisible(false);
					rdbtnKiralik.setVisible(false);
					txtOda1.setVisible(false);
					txtSalon.setVisible(false);
					txtSite.setVisible(false);
					rdbtnSatilik.setVisible(false);
					lblPlus.setVisible(false);
					txtm2.setBounds(94, 240, 139, 20);
					lblM2.setBounds(33, 240, 27, 20);
					lblKrediye.setBounds(33, 270, 46, 20);
					rdbtnKrediUygun.setBounds(115, 270, 104, 23);
					rdbtnKrediUygunDegil.setBounds(218, 270, 80, 23);
					lblAcikla.setBounds(33, 300, 72, 14);
					txtAciklama.setBounds(115, 305, 250, 119);
					btnOlutur.setBounds(130, 583, 168, 30);
					btnEkleFoto.setBounds(130, 500, 168, 76);
					

				}
				else
				{
					setBounds(100, 100, 437, 811);
					lblAidat.setVisible(true);
					lblKiralik.setVisible(true);
					lblOdaSayi.setVisible(true);
					lblSiteAdi.setVisible(true);
					lblSatilik.setVisible(true);
					txtAidat.setVisible(true);
					rdbtnKiralik.setVisible(true);
					txtOda1.setVisible(true);
					txtSalon.setVisible(true);
					txtSite.setVisible(true);
					rdbtnSatilik.setVisible(true);
					lblPlus.setVisible(true);
					txtm2.setBounds(94, 495, 139, 20);
					lblM2.setBounds(33, 493, 27, 20);
					lblKrediye.setBounds(33, 467, 72, 14);
					rdbtnKrediUygun.setBounds(115, 463, 104, 23);
					rdbtnKrediUygunDegil.setBounds(218, 463, 80, 23);
					lblAcikla.setBounds(33, 330, 72, 14);
					txtAciklama.setBounds(115, 332, 250, 119);
					btnOlutur.setBounds(130, 731, 168, 30);
					btnEkleFoto.setBounds(130, 644, 168, 76);
				}
			}
		});
		Design.setbtn(btnOlutur, Color.WHITE);
		Design.setbtn(btnEkleFoto, Color.WHITE);
		
		JLabel lblBaslik = new JLabel("");
		lblBaslik.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblBaslik.setBounds(33, 588, 51, 14);
		panel.add(lblBaslik);
	}
	private static void copyFileUsingChannel(File source, File dest) throws IOException {
	    FileChannel sourceChannel = null;
	    FileChannel destChannel = null;
	    try {
	        sourceChannel = new FileInputStream(source).getChannel();
	        destChannel = new FileOutputStream(dest).getChannel();
	        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
	       }finally{
	           sourceChannel.close();
	           destChannel.close();
	   }
	}
}

