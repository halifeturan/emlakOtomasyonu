package model;

public class Personel {
	
	public Personel(int id, String ad,String sifre,String mail, boolean ilan_atanabilir,String telefon) {
		this.personel_id = id;
		this.ad = ad;
		this.mail = mail;
		this.sifre = sifre;
		this.telefon=telefon;
		this.ilan_atanabilir = ilan_atanabilir;
	}
	
public Personel(String ad,String sifre,String mail, boolean ilan_atanabilir,String telefon) {

		this.ad = ad;
		this.mail = mail;
		this.sifre = sifre;
		this.ilan_atanabilir = ilan_atanabilir;
		this.telefon=telefon;
	}

public Personel() {
	// TODO Auto-generated constructor stub
}

public int personel_id;
public  String ad;
public  String mail;
public  String sifre;
public boolean ilan_atanabilir;
public String rol;
public String telefon;
}
