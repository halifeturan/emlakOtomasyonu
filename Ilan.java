package model;

import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;

public class Ilan {


public Ilan(int fiyat, int m2, String oda_sayisi, String site_adi, int aidat,
		String kredi_durumu, String aciklama, String emlak_tipi, String mahalle, String sehir,String ilce,String satilik_kiralik,String ilan_telefon,String ilan_fotograf_adi) {

	this.fiyat = fiyat;
	this.m2 = m2;
	this.oda_sayisi = oda_sayisi;
	this.site_adi = site_adi;
	this.aidat = aidat;
	this.kredi_durumu = kredi_durumu;
	this.aciklama = aciklama;
	this.emlak_tipi=emlak_tipi;
	this.mahalle=mahalle;
	this.sehir=sehir;
	this.ilce=ilce;
	this.satilik_kiralik=satilik_kiralik;
	this.ilan_telefon=ilan_telefon;
    this.ilan_fotograf_adi=ilan_fotograf_adi;
}
public Ilan(int fiyat, int m2, String oda_sayisi, String site_adi, int aidat,
		String kredi_durumu, String aciklama, String emlak_tipi, String mahalle, String sehir,String ilce,String satilik_kiralik, int personel_id) {

	this.fiyat = fiyat;
	this.m2 = m2;
	this.oda_sayisi = oda_sayisi;
	this.site_adi = site_adi;
	this.aidat = aidat;
	this.kredi_durumu = kredi_durumu;
	this.aciklama = aciklama;
	this.emlak_tipi=emlak_tipi;
	this.mahalle=mahalle;
	this.sehir=sehir;
	this.ilce=ilce;
	this.satilik_kiralik=satilik_kiralik;
	this.ilan_personel_id=personel_id;
	
}

public Ilan() {
	// TODO Auto-generated constructor stub
}

public int ilan_id;
public int fiyat;
public int m2;
public String oda_sayisi;
public String site_adi;
public int aidat;
public String kredi_durumu;
public String aciklama;
public String emlak_tipi;
public String mahalle;
public String sehir;
public String ilce;
public String satilik_kiralik;
public int ilan_personel_id;
public String ilan_telefon;
public String ilan_fotograf_adi;
}
