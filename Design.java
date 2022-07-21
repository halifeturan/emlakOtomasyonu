package design;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Design {

	public static void setbtn(JButton btn, Color clr) {
	btn.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
	
	
	btn.setBorderPainted(true);
	btn.setBackground(clr);
	btn.setFocusPainted(false);
	btn.setContentAreaFilled(true);
	btn.setOpaque(true);
	btn.setMargin(new Insets(10, 10, 10, 10));

}
	public static void vadeDoldur(JComboBox combo)
	{	
		for (int i = 1; i < 13; i++) {
			combo.addItem(i+" Yil (" + i*12 +"ay) vade");
		}
	}
	
	public static void sayiYazdir(JTextField txtYazi,KeyEvent e,boolean dot)
	{
		char vChar = e.getKeyChar();
		  
		if (txtYazi.getText().equals(""))
	        dot = false;
	    if (dot == false){
	        if (vChar == '.') dot = true;
	        else if (!(Character.isDigit(vChar)
	                || (vChar == KeyEvent.VK_BACK_SPACE)
	                || (vChar == KeyEvent.VK_DELETE))) {
	                e.consume();
	        }
	    } else {
	        if (!(Character.isDigit(vChar)
	                || (vChar == KeyEvent.VK_BACK_SPACE)
	                || (vChar == KeyEvent.VK_DELETE))) {
	                e.consume();
	        }
	    }
		}

	
	public static void comboDoldur(int min, int max, JComboBox cmb) {
		//a means start b means stop of the numbers
		
		for (int i = min;min <= max; min++) {
			cmb.addItem(min);
		}
	}
	
	public static int odenek(JComboBox cmb, int vade, JLabel lblFaiz,String txtGirilenTutar)
	{
		int girilenTutar;
		try {
			girilenTutar = (int) Float.parseFloat(txtGirilenTutar);
		} catch (Exception e) {
			 return 0;
		}
		
		for (int i = 1; i < 13; i++) {
			if(cmb.getSelectedIndex()==i-1)
			{
				vade=i*12;				
			}	
		}
		
		float faiz = Float.parseFloat(lblFaiz.getText());
		girilenTutar = (int) ((int) ((girilenTutar*faiz)) + (vade*faiz)); 
		return girilenTutar;
	}
}
