package bll;

import forms.frmGiris;

public class Security {
	public static void adminKontrol() {
		if(frmGiris.aktifuye.uye_rol.equals("A"))
		{
			
		}
		else
		{
			System.exit(1);
		}
	}
}
