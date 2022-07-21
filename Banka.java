package model;

public class Banka {
public int banka_id;
public String banka_ad;
public float banka_ihtiyac_faiz;
public float banka_konut_faiz;
//String banka_fotograf;
public Banka(int banka_id, String banka_ad, float banka_ihtiyac_faiz, float banka_konut_faiz) {
	this.banka_id = banka_id;
	this.banka_ad = banka_ad;
	this.banka_ihtiyac_faiz = banka_ihtiyac_faiz;
	this.banka_konut_faiz = banka_konut_faiz;
}
}
