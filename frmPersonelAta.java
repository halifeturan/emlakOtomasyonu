package EmlakciPersonelForms;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import VM.IlanPersonelVM;
import bll.BLLilan;
import bll.BLLpersonel;
import bll.Security;
import design.Design;
import forms.frmGiris;
import model.Personel;

import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class frmPersonelAta extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model=new DefaultTableModel();
	Object[] column= {"ID","Açýklama", "Fotoðraf", "Fotoðraf"};
	Object[] satirlar= new Object[5];
	ArrayList<IlanPersonelVM> ilanpersonelListe;
	int seciliIlan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Security.adminKontrol();
					frmPersonelAta frame = new frmPersonelAta();
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
	 * @throws ClassNotFoundException 
	 */
	public frmPersonelAta() throws ClassNotFoundException, SQLException {
		Security.adminKontrol();
		setTitle("Personel Y\u00F6nlendir");
		setResizable(false);
		setBounds(100, 100, 586, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 570, 474);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Personel Y\u00F6nlendir");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(33, 11, 241, 51);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblPersonelId = new JLabel("Y\u00F6nlendirilecek Personel");
		lblPersonelId.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblPersonelId.setBounds(397, 96, 145, 14);
		panel.add(lblPersonelId);
		
		JButton btnAtamaIleminiGerekletir = new JButton("Atama \u0130\u015Flemini Ger\u00E7ekle\u015Ftir");
		
		btnAtamaIleminiGerekletir.setMargin(new Insets(10, 10, 10, 10));
		btnAtamaIleminiGerekletir.setBounds(177, 433, 253, 30);
		panel.add(btnAtamaIleminiGerekletir);
		Design.setbtn(btnAtamaIleminiGerekletir, Color.WHITE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(397, 124, 145, 22);
		panel.add(comboBox);
		
		table = new JTable();
		table.setBounds(34, 98, 336, 325);
		panel.add(table);
		
	
			 ilanpersonelListe = BLLilan.ilanlariGetir();
		
		
		for (IlanPersonelVM item : ilanpersonelListe) {
			System.out.println(item.user.uye_telefon);
		}
		model.setColumnIdentifiers(column);
		for (IlanPersonelVM item : ilanpersonelListe) {
			if(item.personel_ilan.ilan_personel_id==0)
			{
				satirlar[0]=item.personel_ilan.ilan_id;
				satirlar[1]=item.personel_ilan.aciklama;
				satirlar[2]=item.personel_ilan.ilan_fotograf_adi;
				satirlar[3]="Fotoðrafý görüntüle.";
				model.addRow(satirlar);
			}
			
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
seciliIlan=(int) model.getValueAt(table.getSelectedRow(), 0);
			if(table.getSelectedColumn()==3)
			{
				String selectedResult = (String)model.getValueAt(table.getSelectedRow(), 2);
				
				File file = new File("src\\ilan_fotograflari\\"+selectedResult);
				
				String filepath = "src\\ilan_fotograflari\\";
				String realFile = "src\\ilan_fotograflari\\"+selectedResult;
				File sonfile = new File(realFile);
				BufferedImage myPicture;
					try {
						//myPicture = ImageIO.read(new File("src\\ilan_fotograflari\\"+selectedResult));
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
	table.setModel(model);
	ArrayList<Personel> ilanpersonelListe = BLLpersonel.musaitPersonelListele();
	for (Personel item : ilanpersonelListe) {
		comboBox.addItem(item.personel_id+" - "+item.ad);
	}

	btnAtamaIleminiGerekletir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				BLLpersonel.personelGuncelle(Integer.parseInt(comboBox.getSelectedItem().toString().substring(0,comboBox.getSelectedItem().toString().indexOf("-")-1)));
				BLLilan.ilanGuncelle(seciliIlan,(Integer.parseInt(comboBox.getSelectedItem().toString().substring(0,comboBox.getSelectedItem().toString().indexOf("-")-1))));

			} catch (NumberFormatException | SQLException | IOException e1) {
			
				e1.printStackTrace();
			}
			
		}
	});
	}
	
	
}
