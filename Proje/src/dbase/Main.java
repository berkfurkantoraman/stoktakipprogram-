package dbase;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Swing.GUI;
import Swing.Giris;


public class Main implements Baglanti_Testi{
	static Connection myConn;
	static Statement myStat;
	
	 
	public static  ResultSet yap() {
		 ResultSet myRs=null;
		try {
			
			Main tester=new Main();
			tester.connectiontester();
			 myConn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb"
			 		+ "?useUnicode=true&useJDBCCompliantTimezoneShift="
			 		+ "true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Bft123!.");
			 myStat = (Statement) myConn.createStatement();
			 myRs= myStat.executeQuery("select ürün.*,ürün_stok.depo_tipi,ürün_stok.mevcut_stok"
			 		+ " from ürün,ürün_stok where ürün.Barkod_id=ürün_stok.Barkod_id ");
			
			
			}catch(Exception e) {
			e.printStackTrace();
		}
		
		return myRs;
		
	}
	
	public static void ekle(String sql_sorgu) {
		
		try {
			Main tester=new Main();
			tester.inputtester();
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void guncelle(String sql_sorgu) {
		
		try {
			Main tester=new Main();
			tester.inputtester();
			tester.outputtester();
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
	
	public static void sil(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
	
	public static ResultSet sorgula(String sql_sorgu) {
		ResultSet myRs = null;
				
		try {
			Main tester=new Main();
			tester.inputtester();
			tester.outputtester();
			myRs = myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return myRs;
		}
	
		public void inputtester() {
		
		}
		
		// TODO Auto-generated catch block

		public void outputtester() {
			
			Stream_class nesne1=new Stream_class();
			nesne1.outputtester();
			
			// TODO Auto-generated catch block

			
		}
	public void connectiontester() {
		System.out.println("MySQL Baðlantýsý Saðlandý");
	}
	
}