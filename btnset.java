package design;

import javax.swing.JButton;
import java.awt.*;

public class btnset {

	public static void setbtn(JButton btn, Color clr) {
	btn.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
	
	
	btn.setBorderPainted(true);
	btn.setBackground(clr);
	btn.setFocusPainted(true);
	btn.setContentAreaFilled(true);
	btn.setOpaque(true);
	btn.setMargin(new Insets(10, 10, 10, 10));

}
}
