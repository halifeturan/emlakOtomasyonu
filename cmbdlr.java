package design;

import javax.swing.JComboBox;

public class cmbdlr {
	public static void comboDoldur(int a, int b, JComboBox cmb) {
		//a means start b means stop of the numbers
		
		for (int i = a; a <= b; a++) {
			cmb.addItem(a);
		}
		
		
		
	}
}
