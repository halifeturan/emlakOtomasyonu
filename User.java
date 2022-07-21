package model;

public class User {

public User(String uye_adi, String uye_soyadi, String uye_sifre, int uye_bakiye, int uye_alinan_kredi, int uye_id,
		String uye_mail, String uye_rol,int uye_ilan_id,String uye_telefon,String uye_kredi_alım_tarihi, int uye_aylık_taksit ) {
	this.uye_adi = uye_adi;
	this.uye_soyadi = uye_soyadi;
	this.uye_sifre = uye_sifre;
	this.uye_bakiye = uye_bakiye;
	this.uye_alinan_kredi = uye_alinan_kredi;
	this.uye_id = uye_id;
	this.uye_mail = uye_mail;
	this.uye_rol = uye_rol;
	this.uye_ilan_id=uye_ilan_id;
	this.uye_telefon=uye_telefon;
	this.uye_kredi_alım_tarihi=uye_kredi_alım_tarihi;
	this.uye_aylık_taksit=uye_aylık_taksit;
}


public User(String uye_adi, String uye_soyadi, String uye_sifre, int uye_bakiye, int uye_alinan_kredi,
		String uye_mail, String uye_rol,String uye_telefon ) {
	this.uye_adi = uye_adi;
	this.uye_soyadi = uye_soyadi;
	this.uye_sifre = uye_sifre;
	this.uye_bakiye = uye_bakiye;
	this.uye_alinan_kredi = uye_alinan_kredi;
	this.uye_mail = uye_mail;
	this.uye_rol=uye_rol;
	this.uye_telefon=uye_telefon;
}


public User(int uye_bakiye) {

	this.uye_bakiye = uye_bakiye;

}
public User(int uye_bakiye,int uye_alinan_kredi) {

	this.uye_alinan_kredi=uye_alinan_kredi;
	this.uye_bakiye = uye_bakiye;

}
public User() {
	
}
public User(String mail,String rol,String sifre)
{
	this.uye_mail=mail;
	this.uye_sifre=sifre;
	this.uye_rol=rol;
}
public String uye_adi;
public String uye_soyadi;
public String uye_sifre;
public int uye_bakiye;
public int uye_id;
public String uye_mail;
public int uye_alinan_kredi;
public String uye_rol;
public int uye_ilan_id;
public String uye_telefon;
public String uye_kredi_alım_tarihi;
public int uye_aylık_taksit;

}
