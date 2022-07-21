package EmlakciPersonelForms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Window.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import VM.IlanPersonelVM;
import bll.BLLilan;
import bll.BLLpersonel;
import bll.Security;
import dal.Connector;
import forms.frmGiris;
import model.Personel;

import javax.swing.JScrollPane;
import bll.BLLpersonel;
import javax.swing.JButton;
public class frmBosPersoneller extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model=new DefaultTableModel();
	Object[] column= {"ID","Şifre", "Ad", "Mail","Durum"};
	Object[] satirlar= new Object[6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Security.adminKontrol();
					frmBosPersoneller frame = new frmBosPersoneller();
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
	
	public frmBosPersoneller() throws SQLException, ClassNotFoundException {
		
		Security.adminKontrol();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bo\u015Ftaki Personeller");
		setResizable(false);
		setBounds(100, 100, 785, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 769, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
	
		));
	
		ArrayList<Personel> ilanpersonelListe = BLLpersonel.musaitPersonelListele();
		
		model.setColumnIdentifiers(column);
		for (Personel item : ilanpersonelListe) {
			
			satirlar[0]=item.personel_id;
			satirlar[1]=item.sifre;
			satirlar[2]=item.ad;
			satirlar[3]=item.mail;
			satirlar[4]=item.ilan_atanabilir;
			model.addRow(satirlar);
			
		}
		table.setModel(model);
	}
		
		
	
	
	
}
