package bll;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VM.IlanPersonelVM;
import dal.Helper;
import forms.frmGiris;
import forms.frmIlanOlustur;
import model.Ilan;
import model.User;
import model.Personel;

public class BLLilan {
	
	public static boolean ilanKaydet(Ilan ilan) throws SQLException, IOException {
		ArrayList parametreler=new ArrayList();

		String eklesql = "INSERT INTO public.t_ilanlar(\r\n"
				+ "ilan_id, ilan_fiyat, ilan_m2, ilan_oda_sayisi, ilan_site_adi, ilan_aidat, ilan_kredi_durumu, ilan_aciklama, ilan_emlak_tipi, ilan_mahalle, ilan_sehir, ilan_ilce, ilan_satilik_kiralik,ilan_fotograf_adi,ilan_personel_id,ilan_sahip_id)\r\n"
				+ "	VALUES (nextval('s_ilanlar'), ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,0,?);";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);
		parametreler.add(ilan.fiyat);//i
		parametreler.add(ilan.m2);//i
		parametreler.add(ilan.oda_sayisi);//s
		parametreler.add(ilan.site_adi);//s
		parametreler.add(ilan.aidat);//i
		parametreler.add(ilan.kredi_durumu);//s
		parametreler.add(ilan.aciklama);//s
		parametreler.add(ilan.emlak_tipi);//s
		parametreler.add(ilan.mahalle);//s
		parametreler.add(ilan.sehir);//s
		parametreler.add(ilan.ilce);//s
		parametreler.add(ilan.satilik_kiralik);//s
		parametreler.add(ilan.ilan_fotograf_adi);//s
		parametreler.add(frmGiris.aktifuye.uye_id);//s
		Helper.executeNonQuery(eklesql, "iississssssssi", parametreler);
		return true;

}
	public static ArrayList<IlanPersonelVM> ilanlariGetir() throws SQLException {
		ArrayList<IlanPersonelVM> liste = new ArrayList();
		
		Ilan ilan=null;
		Personel personel = null;
		IlanPersonelVM VM = null;
		User uye =null;
		String sqlIlanGetir="select \r\n"
				+ "	*, \r\n"
				+ "	(select personel_telefon from t_personel where personel_id = ilan_personel_id),\r\n"
				+ "	(select uye_telefon from t_uyeler where ilan_sahip_id = uye_id)\r\n"
				+ "		from t_ilanlar";
		Helper.executeQuery(sqlIlanGetir);
		while(Helper.rsltst.next()) {
			ilan = new Ilan();
			personel = new Personel();
			uye=new User();
			ilan.ilan_id = Helper.rsltst.getInt("ilan_id");
			ilan.fiyat = Helper.rsltst.getInt("ilan_fiyat");
			ilan.m2 = Helper.rsltst.getInt("ilan_m2");
			ilan.oda_sayisi= Helper.rsltst.getString("ilan_oda_sayisi");
			ilan.site_adi = Helper.rsltst.getString("ilan_site_adi");
			ilan.aidat = Helper.rsltst.getInt("ilan_aidat");
			ilan.kredi_durumu = Helper.rsltst.getString("ilan_kredi_durumu");
			ilan.aciklama= Helper.rsltst.getString("ilan_aciklama");
			ilan.mahalle= Helper.rsltst.getString("ilan_mahalle");
			ilan.sehir= Helper.rsltst.getString("ilan_sehir");
			ilan.ilce= Helper.rsltst.getString("ilan_ilce");
			ilan.satilik_kiralik= Helper.rsltst.getString("ilan_satilik_kiralik");
			ilan.emlak_tipi= Helper.rsltst.getString("ilan_emlak_tipi");
			ilan.ilan_personel_id=Helper.rsltst.getInt("ilan_personel_id");		
			ilan.aciklama=Helper.rsltst.getString("ilan_aciklama");
			ilan.ilan_fotograf_adi=Helper.rsltst.getString("ilan_fotograf_adi");
			personel.telefon = Helper.rsltst.getString("personel_telefon");
			uye.uye_ilan_id=Helper.rsltst.getInt("ilan_id");
			uye.uye_telefon=Helper.rsltst.getString("uye_telefon");
			VM = new IlanPersonelVM();
			VM.personel = personel;
			VM.personel_ilan = ilan;
			VM.user=uye;
			
			liste.add(VM);
		}
		Helper.rsltst.close();
		return liste;
	}
	public static boolean ilanGuncelle(int ilan_id,int personel_id) throws SQLException, IOException {
		ArrayList parametreler=new ArrayList();

		String eklesql = "UPDATE public.t_ilanlar\r\n"
				+ "	SET ilan_personel_id=?\r\n"
				+ "	WHERE ilan_id="+ilan_id+";";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);

		parametreler.add(personel_id);
		
	
		
		Helper.executeNonQuery(eklesql, "i", parametreler);
		return true;

}
	public static boolean ilanSil(int ilan_id) throws SQLException, IOException {
		
		ArrayList parametreler=new ArrayList();

		String eklesql = "DELETE FROM public.t_ilanlar\r\n"
				+ "	WHERE ilan_id=?;";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);

		parametreler.add(ilan_id);
		
	
		
		Helper.executeNonQuery(eklesql, "i", parametreler);
		return true;

}

}
