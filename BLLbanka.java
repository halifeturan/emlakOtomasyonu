package bll;

import java.sql.SQLException;
import java.util.ArrayList;

import dal.Helper;
import model.Banka;


public class BLLbanka {
	public static ArrayList ingGetir() throws SQLException, ClassNotFoundException {
		Banka banka = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql="SELECT banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz, banka_fotograf\r\n"
				+ "	FROM public.t_bankalar where banka_ad='ing';";
		
		Helper.executeQuery(listeleSql);
		
		while (Helper.rsltst.next()) {
			
			int banka_id = Helper.rsltst.getInt("banka_id");
			String banka_ad = Helper.rsltst.getString("banka_ad");
			float banka_ihtiyac_faiz= Helper.rsltst.getFloat("banka_ihtiyac_faiz");
			float banka_konut_faiz= Helper.rsltst.getFloat("banka_konut_faiz");
			
			banka = new Banka(banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz);
			
			liste.add(banka);
			
		}
		
		
		Helper.rsltst.close();
		return liste;

}
	
	public static ArrayList qnbGetir() throws SQLException, ClassNotFoundException {
		Banka banka = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql="SELECT banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz, banka_fotograf\r\n"
				+ "	FROM public.t_bankalar where banka_ad='qnb';";
		
		Helper.executeQuery(listeleSql);
		
		while (Helper.rsltst.next()) {
			
			int banka_id = Helper.rsltst.getInt("banka_id");
			String banka_ad = Helper.rsltst.getString("banka_ad");
			float banka_ihtiyac_faiz= Helper.rsltst.getFloat("banka_ihtiyac_faiz");
			float banka_konut_faiz= Helper.rsltst.getFloat("banka_konut_faiz");
			
			banka = new Banka(banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz);
			
			liste.add(banka);
			
		}
		
		
		Helper.rsltst.close();
		return liste;

}
	public static ArrayList tebGetir() throws SQLException, ClassNotFoundException {
		Banka banka = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql="SELECT banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz, banka_fotograf\r\n"
				+ "	FROM public.t_bankalar where banka_ad='teb';";
		
		Helper.executeQuery(listeleSql);
		
		while (Helper.rsltst.next()) {
			
			int banka_id = Helper.rsltst.getInt("banka_id");
			String banka_ad = Helper.rsltst.getString("banka_ad");
			float banka_ihtiyac_faiz= Helper.rsltst.getFloat("banka_ihtiyac_faiz");
			float banka_konut_faiz= Helper.rsltst.getFloat("banka_konut_faiz");
			
			banka = new Banka(banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz);
			
			liste.add(banka);
			
		}
		
		
		Helper.rsltst.close();
		return liste;

}
	
	public static ArrayList akbankGetir() throws SQLException, ClassNotFoundException {
		Banka banka = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql="SELECT banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz, banka_fotograf\r\n"
				+ "	FROM public.t_bankalar where banka_ad='akbank';";
		
		Helper.executeQuery(listeleSql);
		
		while (Helper.rsltst.next()) {
			
			int banka_id = Helper.rsltst.getInt("banka_id");
			String banka_ad = Helper.rsltst.getString("banka_ad");
			float banka_ihtiyac_faiz= Helper.rsltst.getFloat("banka_ihtiyac_faiz");
			float banka_konut_faiz= Helper.rsltst.getFloat("banka_konut_faiz");
			
			banka = new Banka(banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz);
			
			liste.add(banka);
			
		}
		
		
		Helper.rsltst.close();
		return liste;

}
	public static ArrayList denizBank() throws SQLException, ClassNotFoundException {
		Banka banka = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql="SELECT banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz, banka_fotograf\r\n"
				+ "	FROM public.t_bankalar where banka_ad='denizbank';";
		
		Helper.executeQuery(listeleSql);
		
		while (Helper.rsltst.next()) {
			
			int banka_id = Helper.rsltst.getInt("banka_id");
			String banka_ad = Helper.rsltst.getString("banka_ad");
			float banka_ihtiyac_faiz= Helper.rsltst.getFloat("banka_ihtiyac_faiz");
			float banka_konut_faiz= Helper.rsltst.getFloat("banka_konut_faiz");
			
			banka = new Banka(banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz);
			
			liste.add(banka);
			
		}
		
		
		Helper.rsltst.close();
		return liste;

}
	public static ArrayList garantiBank() throws SQLException, ClassNotFoundException {
		Banka banka = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql="SELECT banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz, banka_fotograf\r\n"
				+ "	FROM public.t_bankalar where banka_ad='garanti';";
		
		Helper.executeQuery(listeleSql);
		
		while (Helper.rsltst.next()) {
			
			int banka_id = Helper.rsltst.getInt("banka_id");
			String banka_ad = Helper.rsltst.getString("banka_ad");
			float banka_ihtiyac_faiz= Helper.rsltst.getFloat("banka_ihtiyac_faiz");
			float banka_konut_faiz= Helper.rsltst.getFloat("banka_konut_faiz");
			
			banka = new Banka(banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz);
			
			liste.add(banka);
			
		}
		
		
		Helper.rsltst.close();
		return liste;

}
	public static ArrayList faizGetir(float faiz) throws SQLException, ClassNotFoundException {
		Banka banka = null;
		ArrayList liste = new ArrayList();
		
		String listeleSql="SELECT banka_ad, banka_ihtiyac_faiz FROM public.t_bankalar where banka_ihtiyac_faiz <= ?";
		
		liste.add(listeleSql+"F");
		Helper.executeQuery(listeleSql,"f",liste);
		
		while (Helper.rsltst.next()) {
			
			int banka_id = Helper.rsltst.getInt("banka_id");
			String banka_ad = Helper.rsltst.getString("banka_ad");
			float banka_ihtiyac_faiz= Helper.rsltst.getFloat("banka_ihtiyac_faiz");
			float banka_konut_faiz= Helper.rsltst.getFloat("banka_konut_faiz");
			
			banka = new Banka(banka_id, banka_ad, banka_ihtiyac_faiz, banka_konut_faiz);
			
			liste.add(banka);
			
		}
		
		
		Helper.rsltst.close();
		return liste;

}
}
