package bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dal.Helper;
import model.Personel;
import model.User;

public class BLLuye {
	public static ArrayList uyeGetir() throws SQLException, ClassNotFoundException {
		User user = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql="SELECT uye_adi, uye_soyadi, uye_sifre, uye_bakiye, uye_id, uye_mail, uye_alinan_kredi,uye_rol,uye_ilan_id,uye_telefon,uye_kredi_alma_tarihi,uye_taksit_ay\r\n"
				+ "	FROM public.t_uyeler;";
		
		Helper.executeQuery(listeleSql);
		
		while (Helper.rsltst.next()) {
			
			
			String uye_adi = Helper.rsltst.getString("uye_adi");
			String uye_soyadi= Helper.rsltst.getString("uye_soyadi");
			String uye_sifre = Helper.rsltst.getString("uye_sifre");
			int uye_bakiye = Helper.rsltst.getInt("uye_bakiye");
			int uye_alinan_kredi = Helper.rsltst.getInt("uye_alinan_kredi");
			int uye_id = Helper.rsltst.getInt("uye_id");
			String uye_mail = Helper.rsltst.getString("uye_mail");
			String uye_rol = Helper.rsltst.getString("uye_rol");
			int uye_ilan_id=Helper.rsltst.getInt("uye_ilan_id");
			String uye_telefon=Helper.rsltst.getString("uye_telefon");
			String uye_kredi_alým_tarihi=Helper.rsltst.getString("uye_kredi_alma_tarihi");
			int uye_aylýk_taksit=Helper.rsltst.getInt("uye_taksit_ay");			
			user = new User(uye_adi, uye_soyadi, uye_sifre, uye_bakiye, uye_alinan_kredi, uye_id, uye_mail, uye_rol,uye_ilan_id,uye_telefon,uye_kredi_alým_tarihi,uye_aylýk_taksit);			
			liste.add(user);
			
		}
		Helper.rsltst.close();
		return liste;

}
	public static boolean uyeKaydet(User user) throws SQLException, IOException {
		ArrayList parametreler=new ArrayList();

		String eklesql = "INSERT INTO public.t_uyeler(\r\n"
				+ "	uye_adi, uye_soyadi, uye_sifre, uye_bakiye, uye_id, uye_mail, uye_alinan_kredi,uye_kredi_durumu,uye_rol,uye_telefon,uye_kredi_alma_tarihi)\r\n"
				+ "	VALUES (?, ?, ?, ?, nextval('s_uyeler'), ?, ?,?,?,?,'2022-05-31');";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);
		parametreler.add(user.uye_adi);
		parametreler.add(user.uye_soyadi);
		parametreler.add(user.uye_sifre);
		parametreler.add(user.uye_bakiye);
		parametreler.add(user.uye_mail);
		parametreler.add(user.uye_alinan_kredi);
		parametreler.add("Alabilir.");
		parametreler.add(user.uye_rol);
		parametreler.add(user.uye_telefon);
		
		
		Helper.executeNonQuery(eklesql, "sssisisss", parametreler);
		return true;

}
	public static boolean bakiyeGuncelle(User user) throws SQLException, IOException {
		ArrayList parametreler=new ArrayList();

		String eklesql = "UPDATE public.t_uyeler\r\n"
				+ "	SET uye_bakiye=?\r\n"
				+ "	WHERE uye_id=?;";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);

		parametreler.add(user.uye_bakiye);
		parametreler.add(user.uye_id);
		
	
		
		Helper.executeNonQuery(eklesql, "ii", parametreler);
		return true;

}
	public static boolean uyeGuncelle(User user, int ilan_id) throws SQLException, IOException {
		ArrayList parametreler=new ArrayList();

		String eklesql = "UPDATE public.t_uyeler\r\n"
				+ "	SET uye_ilan_id=?\r\n"
				+ "	WHERE uye_id=?;";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);

		parametreler.add(ilan_id);
		parametreler.add(user.uye_id);
		
	
		
		Helper.executeNonQuery(eklesql, "ii", parametreler);
		return true;

}
	
	public static boolean kredibakiyeGuncelle(User user) throws SQLException, IOException {
		ArrayList parametreler=new ArrayList();

		String eklesql = "UPDATE public.t_uyeler\r\n"
				+ "	SET uye_bakiye=?, uye_alinan_kredi=?\r\n"
				+ "	WHERE uye_id=?;";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);

		parametreler.add(user.uye_bakiye);
		parametreler.add(user.uye_alinan_kredi);
		parametreler.add(user.uye_id);
		
	
		
		Helper.executeNonQuery(eklesql, "iii", parametreler);
		return true;

}
	public static boolean zamanGuncelle(User user, String date) throws SQLException, IOException {
		ArrayList parametreler=new ArrayList();

		String eklesql = "UPDATE public.t_uyeler\r\n"
				+ "	SET uye_kredi_alma_tarihi='"+date+"'\r\n"
				+ "	WHERE uye_id=?;";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);
		parametreler.add(user.uye_id);
		
	
		
		Helper.executeNonQuery(eklesql, "i", parametreler);
		return true;

}
	public static boolean taksitOlustur(User user,int kac_taksit) throws SQLException, IOException {
		ArrayList parametreler=new ArrayList();

		String eklesql = "UPDATE public.t_uyeler\r\n"
				+ "	SET uye_kredi_alma_tarihi=CURRENT_DATE,uye_taksit_ay="+kac_taksit+"\r\n"
				+ "	WHERE uye_id=?;";
		//PreparedStatement preparedStatement = conn.prepareStatement(eklesql);

		parametreler.add(user.uye_id);
		
	
		
		Helper.executeNonQuery(eklesql, "i", parametreler);
		return true;

}
}
