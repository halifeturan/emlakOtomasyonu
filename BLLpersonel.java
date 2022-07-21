package bll;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dal.Connector;
import dal.Helper;
import forms.frmGiris;
import dal.Connector;
import model.Personel;
import model.User;

public class BLLpersonel {

	public static ArrayList listele() throws SQLException, ClassNotFoundException {
		Security.adminKontrol();
		Personel per = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql="SELECT personel_id, ad, mail, sifre, ilan_atanabilir,personel_telefon\r\n"
				+ "	FROM public.t_personel;";
		
		Helper.executeQuery(listeleSql);
		
		while (Helper.rsltst.next()) {
			
			
			int personel_id = Helper.rsltst.getInt("personel_id");
			String ad= Helper.rsltst.getString("ad");
			String mail = Helper.rsltst.getString("mail");
			String sifre = Helper.rsltst.getString("sifre");
			boolean ilan_atanabilir = Helper.rsltst.getBoolean("ilan_atanabilir");
			String personel_telefon = Helper.rsltst.getString("personel_telefon");
			per = new Personel(personel_id, ad, mail, sifre,ilan_atanabilir,personel_telefon);
			
			liste.add(per);
		}
		Helper.rsltst.close();
		return liste;

}
	public static ArrayList musaitPersonelListele() throws SQLException, ClassNotFoundException {
		Security.adminKontrol();
		Personel per = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql1="SELECT personel_id, ad, mail, sifre, ilan_atanabilir,personel_telefon\r\n"
				+ "	FROM public.t_personel where ilan_atanabilir='true';";

		Helper.executeQuery(listeleSql1);
		
while (Helper.rsltst.next()) {
	Security.adminKontrol();
			
			int personel_id = Helper.rsltst.getInt("personel_id");
			String ad= Helper.rsltst.getString("ad");
			String mail = Helper.rsltst.getString("mail");
			String sifre = Helper.rsltst.getString("sifre");
			boolean ilan_atanabilir = Helper.rsltst.getBoolean("ilan_atanabilir");
			String personel_telefon = Helper.rsltst.getString("personel_telefon");
			per = new Personel(personel_id, ad, mail, sifre, ilan_atanabilir,personel_telefon);
			
			liste.add(per);
		}
Helper.rsltst.close();
		return liste;
}
	public static boolean personelKaydet(Personel persnl) throws SQLException, IOException {
		Security.adminKontrol();
		ArrayList parametreler=new ArrayList();

		String eklesql = "INSERT INTO public.t_personel(\r\n"
				+ "	personel_id, ad, mail, sifre, ilan_atanabilir,personel_telefon)\r\n"
				+ "	VALUES (nextval('s_personel'), ?, ?, ?, 'True', ?);";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);
		parametreler.add(persnl.ad);
		parametreler.add(persnl.mail);
		parametreler.add(persnl.sifre);
		parametreler.add(persnl.telefon);
		Helper.executeNonQuery(eklesql, "ssss", parametreler);
		Helper.rsltst.close();
		return true;

}
	public static boolean personelGuncelle(int personelid) throws SQLException, IOException {
		ArrayList parametreler=new ArrayList();

		String eklesql = "UPDATE public.t_personel\r\n"
				+ "	SET ilan_atanabilir=?\r\n"
				+ "	WHERE personel_id="+personelid+";";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);

		parametreler.add(false);
		
	
		
		Helper.executeNonQuery(eklesql, "b", parametreler);
		return true;

}
	/*
	public static ResultSet calistir(String sorgu) throws SQLException
	{
		Statement st;
		ResultSet rs;
		st=conn.createStatement();
		rs=st.executeQuery(sorgu);
		return rs;
	}*/
	}
