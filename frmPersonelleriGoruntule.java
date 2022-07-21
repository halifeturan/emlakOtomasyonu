package EmlakciPersonelForms;

import java.awt.BorderLayout;
import dal.Connector;
import forms.frmGiris;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bll.BLLpersonel;
import bll.Security;
import model.Personel;
import javax.swing.JScrollPane;

public class frmPersonelleriGoruntule extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model=new DefaultTableModel();
	Object[] column= {"ID","Şifre", "Ad", "Mail","Çalıştığı İlanlar","Durum"};
	Object[] satirlar= new Object[6];


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Security.adminKontrol();
					frmPersonelleriGoruntule frame = new frmPersonelleriGoruntule();
					frame.setVisible(true);
					Connector.connect();
					
				
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
	
	public frmPersonelleriGoruntule() throws SQLException, ClassNotFoundException {
		Security.adminKontrol();
		setTitle("Personeller");
		setResizable(false);
		setBounds(100, 100, 785, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 786, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(

		));

		scrollPane.setViewportView(table);
		BLLpersonel.listele();
	
		ArrayList<Personel>personelListele=BLLpersonel.listele();
		model.setColumnIdentifiers(column);
		for (Personel item : personelListele) {
			satirlar[0]=item.personel_id;
			satirlar[1]=item.ad;
			satirlar[2]=item.mail;
			satirlar[3]=item.sifre;
			if(item.ilan_atanabilir==true)
			{
			satirlar[4]="ilan atanabilir";
			}
			else
			{
				satirlar[4]="ilan atanamaz";
			}
			
			model.addRow(satirlar);
		}
	
	table.setModel(model);
	}
	
}
