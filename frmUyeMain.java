package forms;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import design.Design;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class frmUyeMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeMain frame = new frmUyeMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmUyeMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("selam");
			}
		});
		
		if(frmGiris.aktifuye == null) {
			frmGiris frmgiris = new frmGiris();
			frmgiris.setVisible(true);
			dispose();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 411, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 434, 366);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ho\u015F Geldin");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(131, 7, 143, 51);
		panel.add(lblNewLabel_2_1);
		
		JButton btnIlanAra = new JButton("\u0130lan Ara");
		btnIlanAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				frmUyeIlanlar frmilanlar;
				try {
					frmilanlar = new frmUyeIlanlar();
					frmilanlar.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnIlanAra.setMargin(new Insets(10, 10, 10, 10));
		btnIlanAra.setBounds(63, 123, 273, 30);
		panel.add(btnIlanAra);
		
		JButton btnBakiyeBilgim = new JButton("Bakiye Bilgileriniz");
		btnBakiyeBilgim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frmUyeBakiye frmbakiye=new frmUyeBakiye();
				frmbakiye.setVisible(true);				
				
			
			}
		});
		btnBakiyeBilgim.setMargin(new Insets(10, 10, 10, 10));
		btnBakiyeBilgim.setBounds(63, 164, 273, 30);
		panel.add(btnBakiyeBilgim);
		
		JButton btnKrediDurumuren = new JButton("Kredi Durumunuzu \u00D6\u011Frenin");
		btnKrediDurumuren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmGiris.aktifuye.uye_alinan_kredi>0)
				{
					JOptionPane.showMessageDialog(null, "Kredi borcunuz bulunmaktadir, tekrar kredi alabilmeniz için mevcut borcunuzu ödemeniz gerekmektedir. Mevcut borcunuzu odemek için,''Borc ode' secenegine tiklayiniz.'");
				}
				else
				{
				frmUyeKrediDurumu frmkredi=new frmUyeKrediDurumu();
				frmkredi.setVisible(true);
				frmGiris frmgiris=new frmGiris();
				frmgiris.setVisible(false);
				}
				
			}
		});
		btnKrediDurumuren.setMargin(new Insets(10, 10, 10, 10));
		btnKrediDurumuren.setBounds(63, 205, 273, 30);
		panel.add(btnKrediDurumuren);
		Design.setbtn(btnIlanAra, Color.WHITE);
		Design.setbtn(btnBakiyeBilgim, Color.WHITE);
		Design.setbtn(btnKrediDurumuren, Color.WHITE);
		
		JLabel lblNewLabel_2_1_1 = new JLabel(frmGiris.aktifuye.uye_adi);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 50, 382, 51);
		panel.add(lblNewLabel_2_1_1);
		
		JButton btnOturumuKapat = new JButton("\u00C7\u0131k\u0131\u015F");
		btnOturumuKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frmGiris frmgiris=new frmGiris();
				frmgiris.setVisible(true);
				frmGiris.aktifuye=null;
			}
		});
		btnOturumuKapat.setMargin(new Insets(10, 10, 10, 10));
		btnOturumuKapat.setBounds(256, 287, 117, 24);
		panel.add(btnOturumuKapat);
		Design.setbtn(btnOturumuKapat, Color.WHITE);
		
		JButton btnIlanOlutur = new JButton("\u0130lan Olu\u015Ftur");
		btnIlanOlutur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmIlanOlustur frmolustur=new frmIlanOlustur();
				frmolustur.setVisible(true);	
			
			}
		});
		btnIlanOlutur.setMargin(new Insets(10, 10, 10, 10));
		btnIlanOlutur.setBounds(63, 246, 273, 30);
		panel.add(btnIlanOlutur);
		Design.setbtn(btnIlanOlutur, Color.WHITE);

	}
}
