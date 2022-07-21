package forms;

import java.awt.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.lang.Runtime;
import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.LargeObjectManager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import VM.IlanPersonelVM;
import bll.BLLilan;
import bll.BLLpersonel;
import bll.BLLuye;
import dal.Connector;
import dal.Helper;
import design.CurrencyRenderer;
import design.Design;
import design.SingleColumnTableHeader;
import model.Ilan;
import model.Personel;
import model.User;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class frmUyeIlanlar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static int ilanid=0;
	DefaultTableModel model=new DefaultTableModel();
	Object[] column= {"Fiyat","m2", "Oda Sayisi", "Site Adi","Aidat","Kredi Durumu","Aciklama","Emlak Tipi","Mahalle","Sehir","Ilce","Satilik/Kiralik","Personel Telefon","Satici Telefon","Fotograf","Fotograf ad","Satın Al","ID"};
	Object[] satirlar= new Object[18];
	private JLabel lblNewLabel_2;
	public static File file;
	ArrayList<User> uyeListe;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeIlanlar frame = new frmUyeIlanlar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmUyeIlanlar() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1650, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		
		ArrayList<IlanPersonelVM> ilanpersonelListe = BLLilan.ilanlariGetir();
		for (IlanPersonelVM item : ilanpersonelListe) {
			System.out.println(item.user.uye_telefon);
		}
		
		model.setColumnIdentifiers(column);
		for (IlanPersonelVM item : ilanpersonelListe) {
		
			satirlar[0]=item.personel_ilan.fiyat;
			satirlar[1]=item.personel_ilan.m2;
			satirlar[2]=item.personel_ilan.oda_sayisi;
			satirlar[3]=item.personel_ilan.site_adi;
			satirlar[4]=item.personel_ilan.aidat;
			satirlar[5]=item.personel_ilan.kredi_durumu;
			satirlar[6]=item.personel_ilan.aciklama;
			satirlar[7]=item.personel_ilan.emlak_tipi;
			satirlar[8]=item.personel_ilan.mahalle;
			satirlar[9]=item.personel_ilan.sehir;
			satirlar[10]=item.personel_ilan.ilce;
			satirlar[11]=item.personel_ilan.satilik_kiralik;
			satirlar[12]=item.personel.telefon;
			satirlar[13]=item.user.uye_telefon;
			satirlar[14]= "Detay";
			satirlar[15]= item.personel_ilan.ilan_fotograf_adi;
			if(frmGiris.aktifuye.uye_bakiye>=item.personel_ilan.fiyat)
			{
				satirlar[16]= "Satın al.";
			}
			else
			{
				satirlar[16]= "Kredi al.";
			}
			satirlar[17]=item.personel_ilan.ilan_id;
			
			model.addRow(satirlar);
		}
	contentPane.setLayout(new BorderLayout(0, 0));
	
	JPanel panel = new JPanel();
	contentPane.add(panel);
	panel.setLayout(new BorderLayout(0, 0));
	JScrollPane scrollPane = new JScrollPane();
	panel.add(scrollPane, BorderLayout.CENTER);
	
	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if	(table.getSelectedColumn()==16 && (String)model.getValueAt(table.getSelectedRow(), 16)=="Satın al."&&frmGiris.aktifuye.uye_bakiye>=(Integer)model.getValueAt(table.getSelectedRow(), 0))
			{
				
				int reply = JOptionPane.showConfirmDialog(null, "Evi satın alıyorsunuz, onaylıyor musunuz?", "Satın Al", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					
					int ev_fiyat=(Integer)model.getValueAt(table.getSelectedRow(), 0);
					ilanid=(Integer)model.getValueAt(table.getSelectedRow(), 17);
					System.out.println(ilanid);
					frmGiris.aktifuye.uye_bakiye-=ev_fiyat;
					try {
						BLLuye.bakiyeGuncelle(frmGiris.aktifuye);
						BLLilan.ilanSil(ilanid);
					    JOptionPane.showMessageDialog(null, "Ev başarıyla satın alındı. Yeni bakiyeniz: "+frmGiris.aktifuye.uye_bakiye+"");
					    
					    LocalDate date = LocalDate.now();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					    
					    DefaultTableModel dm = (DefaultTableModel)table.getModel();
						dm.getDataVector().removeAllElements();
						table.repaint();
						ArrayList<IlanPersonelVM> ilanpersonelListe=null;
						try {
							ilanpersonelListe = BLLilan.ilanlariGetir();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						for (IlanPersonelVM item : ilanpersonelListe) {
							System.out.println(item.user.uye_telefon);
						}
						
						model.setColumnIdentifiers(column);
						for (IlanPersonelVM item : ilanpersonelListe) {
						
							satirlar[0]=item.personel_ilan.fiyat;
							satirlar[1]=item.personel_ilan.m2;
							satirlar[2]=item.personel_ilan.oda_sayisi;
							satirlar[3]=item.personel_ilan.site_adi;
							satirlar[4]=item.personel_ilan.aidat;
							satirlar[5]=item.personel_ilan.kredi_durumu;
							satirlar[6]=item.personel_ilan.aciklama;
							satirlar[7]=item.personel_ilan.emlak_tipi;
							satirlar[8]=item.personel_ilan.mahalle;
							satirlar[9]=item.personel_ilan.sehir;
							satirlar[10]=item.personel_ilan.ilce;
							satirlar[11]=item.personel_ilan.satilik_kiralik;
							satirlar[12]=item.personel.telefon;
							satirlar[13]=item.user.uye_telefon;
							satirlar[14]= "Detay";
							satirlar[15]= item.personel_ilan.ilan_fotograf_adi;
							if(frmGiris.aktifuye.uye_bakiye>=item.personel_ilan.fiyat)
							{
								satirlar[16]= "Satın al.";
							}
							else
							{
								satirlar[16]= "Kredi al.";
							}
							satirlar[17]=item.personel_ilan.ilan_id;
							
							model.addRow(satirlar);
						}
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
				} else {
					  JOptionPane.showMessageDialog(null, "Satın alma işlemi iptal edildi.");
				}
			}
			if	(table.getSelectedColumn()==16 && (String)model.getValueAt(table.getSelectedRow(), 16)=="Kredi al.")
			{
				frmUyeBakiye bakiye=new frmUyeBakiye();
				bakiye.setVisible(true);
			}
		
		if(table.getSelectedColumn()==14)
		{
			String selectedResult = (String)model.getValueAt(table.getSelectedRow(), 15);
			
			file=new File("src\\ilan_fotograflari\\"+selectedResult);
			
			String filepath = "src\\ilan_fotograflari\\";
			String realFile = "src\\ilan_fotograflari\\"+selectedResult;
			File sonfile = new File(realFile);
			BufferedImage myPicture;
				try {
					//myPicture = ImageIO.read(new File("src\\ilan_fotograflari\\"+selectedResult));
					//myPicture = ImageIO.read(sonfile);
					myPicture = ImageIO.read(sonfile);
					//JOptionPane.showMessageDialog(null,"1yol normalde = src\\ilan_fotograflari\\"+selectedResult);
					final JOptionPane jop= new JOptionPane(null,JOptionPane.INFORMATION_MESSAGE,JOptionPane.DEFAULT_OPTION,new ImageIcon(myPicture),new Object[]{}, null);
					final JDialog dialog=new JDialog();
					 dialog.setTitle("Message");
					 dialog.setModal(true);
					 dialog.setContentPane(jop);
					 dialog.pack();
					 dialog.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else
		{
			
			//JOptionPane.showMessageDialog(null,model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString(),model.getColumnName(table.getSelectedColumn()),JOptionPane.WARNING_MESSAGE);
		}
		}
	});
	table.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		}
		@Override
		public void keyReleased(KeyEvent e) {

		}
		@Override
		public void keyTyped(KeyEvent e) {

		}
	});
    table.setRowHeight(7, HEIGHT);
	//table.setTableHeader(new SingleColumnTableHeader());
    table.setFillsViewportHeight(true);
    table.setShowHorizontalLines(true);
    table.setShowVerticalLines(false);
    table.setGridColor(Color.LIGHT_GRAY);
    table.setDefaultRenderer(Double.class, new CurrencyRenderer());
    
	scrollPane.setViewportView(table);
	
	
	scrollPane.setViewportView(table);
	

	table.setModel(model);
	
	JPanel panel_1 = new JPanel();
	panel.add(panel_1, BorderLayout.NORTH);
	panel_1.setLayout(new BorderLayout(0, 0));
	
	lblNewLabel_2 = new JLabel("\u0130lanlar");
	lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
	panel_1.add(lblNewLabel_2, BorderLayout.CENTER);
	
	btnNewButton = new JButton("Yenile");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel dm = (DefaultTableModel)table.getModel();
			dm.getDataVector().removeAllElements();
			table.repaint();
			ArrayList<IlanPersonelVM> ilanpersonelListe=null;
			try {
				ilanpersonelListe = BLLilan.ilanlariGetir();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			for (IlanPersonelVM item : ilanpersonelListe) {
				System.out.println(item.user.uye_telefon);
			}
			
			model.setColumnIdentifiers(column);
			for (IlanPersonelVM item : ilanpersonelListe) {
			
				satirlar[0]=item.personel_ilan.fiyat;
				satirlar[1]=item.personel_ilan.m2;
				satirlar[2]=item.personel_ilan.oda_sayisi;
				satirlar[3]=item.personel_ilan.site_adi;
				satirlar[4]=item.personel_ilan.aidat;
				satirlar[5]=item.personel_ilan.kredi_durumu;
				satirlar[6]=item.personel_ilan.aciklama;
				satirlar[7]=item.personel_ilan.emlak_tipi;
				satirlar[8]=item.personel_ilan.mahalle;
				satirlar[9]=item.personel_ilan.sehir;
				satirlar[10]=item.personel_ilan.ilce;
				satirlar[11]=item.personel_ilan.satilik_kiralik;
				satirlar[12]=item.personel.telefon;
				satirlar[13]=item.user.uye_telefon;
				satirlar[14]= "Detay";
				satirlar[15]= item.personel_ilan.ilan_fotograf_adi;
				if(frmGiris.aktifuye.uye_bakiye>=item.personel_ilan.fiyat)
				{
					satirlar[16]= "Satın al.";
				}
				else
				{
					satirlar[16]= "Kredi al.";
				}
				satirlar[17]=item.personel_ilan.ilan_id;
				
				model.addRow(satirlar);
			}
			try {
				uyeListe = BLLuye.uyeGetir();
				for (User item : uyeListe) {
					item.uye_bakiye=frmGiris.aktifuye.uye_bakiye;
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	panel_1.add(btnNewButton, BorderLayout.WEST);
	table.setDefaultEditor(Object.class, null);
	Design.setbtn(btnNewButton, Color.WHITE);
	}
}
