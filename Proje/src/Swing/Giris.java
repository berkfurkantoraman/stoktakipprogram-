package Swing;
import dbase.Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Giris extends JFrame {

	JFrame frmLogin;
	private JTextField user;
	private JButton btnNewButton;
	static String ad;
	static String sifre;
	private JPasswordField key;

	/**
	 
	 * Launch the application.
	 
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris window = new Giris();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 
	 
	 * Create the application.
	 
	 */
	public Giris() {
		initialize();
		frmLogin.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Giris.class.getResource("/images/149-1492805_cyber-security-icon-png-lock-icon.png")));
		frmLogin.setTitle("Login\r\n");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 600, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 13));
		user.setBounds(139, 72, 142, 20);
		frmLogin.getContentPane().add(user);
		user.setColumns(10);
		
		
		key = new JPasswordField();
		key.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					ad = user.getText();
					sifre = key.getText();
					String sql_sorgu= "SELECT count(kullanici_id) as giris FROM mydb.users where isim='"+ad+"' and sifre='"+sifre+"'"; 
					
					ResultSet myRs = Main.yap();
					myRs = Main.sorgula(sql_sorgu);
					
					
					try {
						while(myRs.next()){
							if(myRs.getInt("giris")==1){
								
								GUI s1 = new GUI();
								s1.frame_acici();
								frmLogin.setVisible(false);
								
							}else btnNewButton.setText("Hatalý giriþ");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			}
		});
		key.setBounds(139, 118, 142, 20);
		frmLogin.getContentPane().add(key);
		
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(32, 74, 97, 17);
		frmLogin.getContentPane().add(lblNewLabel);
		
		
		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setFont(new Font("Arial", Font.BOLD, 15));
		lblifre.setBounds(32, 119, 87, 17);
		frmLogin.getContentPane().add(lblifre);
		
		
		btnNewButton = new JButton("Giri\u015F");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ad = user.getText();
				sifre = key.getText();
				String sql_sorgu= "SELECT count(kullanici_id) as giris FROM mydb.users where isim='"+ad+"' and sifre='"+sifre+"'"; 
				
				ResultSet myRs = Main.yap();
				myRs = Main.sorgula(sql_sorgu);
				
				
				try {
					while(myRs.next()){
						if(myRs.getInt("giris")==1){
							
							GUI s1 = new GUI();
							s1.frame_acici();
							frmLogin.setVisible(false);
							
						}else btnNewButton.setText("Hatalý giriþ");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
			
		});
		
		btnNewButton.setBounds(164, 149, 97, 25);
		frmLogin.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Giris.class.getResource("/images/WhatsApp Image 2019-12-25 at 22.10.01.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 594, 271);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		
	}
}
