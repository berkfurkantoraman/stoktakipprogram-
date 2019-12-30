package Swing;
import	dbase.Main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class GUI extends JFrame{

	
	
	private JFrame frmStokTakipProgram;
	private JTable table;
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"Barkod","Ýsim","Birim Fiyat","Depo Tipi","Mevcut Stok"};
	Object[] satýrlar = new Object[5];
	private JTextField barkod;
	private JTextField isim;
	private JTextField birimfiyat;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JTextField sorgula;
	private JTextField mevcutstok;
		Main at = new Main();
		
		
	public void frame_acici() {
		frmStokTakipProgram.setVisible(true);
		
		}
	
	
	/**
	 * Launch the application.
	 */
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmStokTakipProgram.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	

	/**
	 * Create the application.
	 */
	public GUI() {
		
		initialize();
		frmStokTakipProgram.setLocationRelativeTo(null);
	}
	
	

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmStokTakipProgram = new JFrame();
		frmStokTakipProgram.setResizable(false);
		frmStokTakipProgram.setTitle("Stok Takip Program\u0131");
		frmStokTakipProgram.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/karton-koli.jpg")));
		frmStokTakipProgram.setFont(new Font("Arial", Font.PLAIN, 15));
		frmStokTakipProgram.getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		frmStokTakipProgram.setBounds(100, 100, 886, 497);
		frmStokTakipProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStokTakipProgram.getContentPane().setLayout(null);
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(720, 11, 147, 29);
		frmStokTakipProgram.getContentPane().add(lblNewLabel_2);
		Calendar cal = new GregorianCalendar();
		int gün,ay,yýl;
		gün = cal.get(Calendar.DAY_OF_MONTH);
		ay = cal.get(Calendar.MONTH);
		yýl = cal.get(Calendar.YEAR);
		
		lblNewLabel_2.setText("Tarih : "+gün+"/"+(ay+1)+"/"+yýl);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		
		scrollPane.setBounds(35, 30, 538, 144);
		frmStokTakipProgram.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.ITALIC, 15));
		table.setRowHeight(25);
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(300, 300, 300, 300);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Listele");
		btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setRowCount(0);
				
				ResultSet myRs = Main.yap();
				
				table.setModel(modelim);
				try {
					while(myRs.next()) {
						satýrlar[0]=myRs.getString("Barkod_id");
						satýrlar[1]=myRs.getString("Ýsim");
						satýrlar[2]=myRs.getString("birim_fiyat");
						satýrlar[3]=myRs.getString("depo_tipi");
						satýrlar[4]=myRs.getString("mevcut_stok");
						modelim.addRow(satýrlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		btnNewButton.setBounds(646, 91, 171, 56);
		frmStokTakipProgram.getContentPane().add(btnNewButton);
		
		barkod = new JTextField();
		barkod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		barkod.setBounds(694, 290, 147, 20);
		frmStokTakipProgram.getContentPane().add(barkod);
		barkod.setColumns(10);
		
		isim = new JTextField();
		isim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		isim.setBounds(694, 320, 147, 20);
		frmStokTakipProgram.getContentPane().add(isim);
		isim.setColumns(10);
		
		birimfiyat = new JTextField();
		birimfiyat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		birimfiyat.setBounds(694, 350, 147, 20);
		frmStokTakipProgram.getContentPane().add(birimfiyat);
		birimfiyat.setColumns(10);
		
		mevcutstok = new JTextField();
		mevcutstok.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mevcutstok.setColumns(10);
		mevcutstok.setBounds(694, 410, 147, 20);
		frmStokTakipProgram.getContentPane().add(mevcutstok);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Adet", "Litre", "Kilogram", "Metre", "Metre^2"}));
		comboBox_1.setBounds(694, 380, 147, 22);
		frmStokTakipProgram.getContentPane().add(comboBox_1);
		
		btnNewButton_1 = new JButton("Kay\u0131t Ekle");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				String barkodtxt,isimtxt,birimfiyattxt,sql_sorgu,mevcutstoktxt;
				barkodtxt = barkod.getText();
				isimtxt = isim.getText();
				birimfiyattxt = birimfiyat.getText();
				String depotipitxt = comboBox_1.getSelectedItem().toString();
				mevcutstoktxt  = mevcutstok.getText();
				
				if(!(barkodtxt.isEmpty()||isimtxt.isEmpty()||birimfiyattxt.isEmpty()||depotipitxt.isEmpty()||mevcutstoktxt.isEmpty())) {
					sql_sorgu = "INSERT INTO ürün (Barkod_id,Ýsim,birim_fiyat) VALUES ("+"'"+barkodtxt+"'," + "'"+ isimtxt +"',"+"'"+ birimfiyattxt +"')";	
					Main.ekle(sql_sorgu);
					
					sql_sorgu = "INSERT INTO ürün_stok (Barkod_id,depo_tipi,mevcut_stok) VALUES ("+"'"+barkodtxt+"',"+"'"+depotipitxt+"','"+mevcutstoktxt+"')";	
					Main.ekle(sql_sorgu);
				}
				else{
					JOptionPane.showMessageDialog(null, "Boþ alanlarý doldurun!");
				}
				
				
modelim.setRowCount(0);
				
				ResultSet myRs = Main.yap();
				
				table.setModel(modelim);
				try {
					while(myRs.next()) {
						satýrlar[0]=myRs.getString("Barkod_id");
						satýrlar[1]=myRs.getString("Ýsim");
						satýrlar[2]=myRs.getString("birim_fiyat");
						satýrlar[3]=myRs.getString("depo_tipi");
						satýrlar[4]=myRs.getString("mevcut_stok");
						modelim.addRow(satýrlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		
		
		btnNewButton_1.setBounds(67, 187, 135, 40);
		frmStokTakipProgram.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Barkod");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(580, 290, 86, 17);
		frmStokTakipProgram.getContentPane().add(lblNewLabel);
		
		JLabel lblIsim = new JLabel("\u0130sim");
		lblIsim.setForeground(Color.BLACK);
		lblIsim.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblIsim.setBounds(580, 320, 53, 17);
		frmStokTakipProgram.getContentPane().add(lblIsim);
		
		JLabel lblNewLabel_1_1 = new JLabel("Birim Fiyat");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(580, 350, 97, 17);
		frmStokTakipProgram.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton_2 = new JButton("Güncelle");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				String barkodtxt,isimtxt,birimfiyattxt,sql_sorgu,mevcutstoktxt;
				barkodtxt = barkod.getText();
				isimtxt = isim.getText();
				birimfiyattxt = birimfiyat.getText();
				String depotipitxt = comboBox_1.getSelectedItem().toString();
				mevcutstoktxt = mevcutstok.getText();
				
				sql_sorgu = "UPDATE ürün_stok Set depo_tipi='"+depotipitxt+"',mevcut_stok='"+mevcutstoktxt+"'"+" Where ürün_stok.Barkod_id="+barkodtxt;
				Main.guncelle(sql_sorgu);				
				
				sql_sorgu = "UPDATE ürün Set "+"Ýsim="+"'"+isimtxt+"',"+"birim_fiyat="+"'"+birimfiyattxt+"' Where ürün.Barkod_id="+barkodtxt;
				Main.guncelle(sql_sorgu);
modelim.setRowCount(0);
				
				ResultSet myRs = Main.yap();
				
				table.setModel(modelim);
				try {
					while(myRs.next()) {
						satýrlar[0]=myRs.getString("Barkod_id");
						satýrlar[1]=myRs.getString("Ýsim");
						satýrlar[2]=myRs.getString("birim_fiyat");
						satýrlar[3]=myRs.getString("depo_tipi");
						satýrlar[4]=myRs.getString("mevcut_stok");
						modelim.addRow(satýrlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		
		
		btnNewButton_2.setBounds(238, 187, 135, 40);
		frmStokTakipProgram.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Sil");
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String barkodtxt,sql_sorgu;
				barkodtxt = barkod.getText(); 
				sql_sorgu = "DELETE FROM ürün_stok where ürün_stok.Barkod_id="+"'"+barkodtxt+"'";
				Main.sil(sql_sorgu);
				sql_sorgu = "DELETE FROM ürün where ürün.Barkod_id="+"'"+barkodtxt+"'";
				Main.sil(sql_sorgu);
				
modelim.setRowCount(0);
				
				ResultSet myRs = Main.yap();
				
				table.setModel(modelim);
				try {
					while(myRs.next()) {
						satýrlar[0]=myRs.getString("Barkod_id");
						satýrlar[1]=myRs.getString("Ýsim");
						satýrlar[2]=myRs.getString("birim_fiyat");
						satýrlar[3]=myRs.getString("depo_tipi");
						satýrlar[4]=myRs.getString("mevcut_stok");
						modelim.addRow(satýrlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		btnNewButton_3.setBounds(411, 187, 135, 40);
		frmStokTakipProgram.getContentPane().add(btnNewButton_3);
		
		sorgula = new JTextField();
		sorgula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sorgula.setBounds(197, 382, 121, 29);
		frmStokTakipProgram.getContentPane().add(sorgula);
		sorgula.setColumns(10);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Barkod", "\u0130sim", "Birim Fiyat", "Depo Tipi"}));
		comboBox.setBounds(35, 382, 121, 29);
		frmStokTakipProgram.getContentPane().add(comboBox);
		
		JButton btnNewButton_4 = new JButton("Sorgula");
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setRowCount(0);
				
				String sql_sorgu=null;
				String alan = sorgula.getText();
				ResultSet myRs = null;
				
				int secilen = comboBox.getSelectedIndex();
				
				if(secilen==0) {
					sql_sorgu = "select ürün.*,ürün_stok.depo_tipi,ürün_stok.mevcut_stok from ürün,ürün_stok where ürün_stok.Barkod_id=ürün.Barkod_id and ürün.Barkod_id="+"'"+alan+"'";
				}else if(secilen==1) {
					sql_sorgu = "select ürün.*,ürün_stok.depo_tipi,ürün_stok.mevcut_stok from ürün,ürün_stok where ürün_stok.Barkod_id=ürün.Barkod_id and ürün.Ýsim="+"'"+alan+"'";
				}else if(secilen==2) {
					sql_sorgu = "select ürün.*,ürün_stok.depo_tipi,ürün_stok.mevcut_stok from ürün,ürün_stok where ürün_stok.Barkod_id=ürün.Barkod_id and ürün.birim_fiyat="+"'"+alan+"'";
				}else if(secilen==3) {
					sql_sorgu = "select ürün.*,ürün_stok.depo_tipi,ürün_stok.mevcut_stok from ürün,ürün_stok where ürün_stok.Barkod_id=ürün.Barkod_id and ürün_stok.depo_tipi="+"'"+alan+"'";
				}
				
				
				
				myRs = Main.sorgula(sql_sorgu);
				table.setModel(modelim);
				try {
					while(myRs.next()) {
						satýrlar[0]=myRs.getString("ürün.Barkod_id");
						satýrlar[1]=myRs.getString("ürün.Ýsim");
						satýrlar[2]=myRs.getString("ürün.birim_fiyat");
						satýrlar[3]=myRs.getString("ürün_stok.depo_tipi");
						satýrlar[4]=myRs.getString("ürün_stok.mevcut_stok");
						modelim.addRow(satýrlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		btnNewButton_4.setBounds(346, 371, 109, 40);
		frmStokTakipProgram.getContentPane().add(btnNewButton_4);
		

		
		JLabel lblNewLabel_1_1_2 = new JLabel("Mevcut Stok");
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(580, 410, 109, 14);
		frmStokTakipProgram.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel depotipi = new JLabel("Depo Tipi");
		depotipi.setForeground(Color.BLACK);
		depotipi.setFont(new Font("Arial Black", Font.PLAIN, 13));
		depotipi.setBounds(580, 380, 86, 18);
		frmStokTakipProgram.getContentPane().add(depotipi);
		
		JLabel lblDepoTipiSeiniz = new JLabel("Sorgulama Tipi Se\u00E7iniz !");
		lblDepoTipiSeiniz.setForeground(Color.BLACK);
		lblDepoTipiSeiniz.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblDepoTipiSeiniz.setBackground(Color.WHITE);
		lblDepoTipiSeiniz.setBounds(10, 352, 192, 19);
		frmStokTakipProgram.getContentPane().add(lblDepoTipiSeiniz);
		
		JButton btnNewButton_5 = new JButton("Temizle");
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnNewButton_5.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				barkod.setText("");
				isim.setText("");
				birimfiyat.setText("");
				comboBox_1.setSelectedItem(comboBox_1.getItemAt(0));
				mevcutstok.setText("");
				
			}
		});
		
		
		
		btnNewButton_5.setBounds(752, 256, 89, 23);
		frmStokTakipProgram.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GUI.class.getResource("/images/WhatsApp Image 2019-12-25 at 18.42.12.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 880, 468);
		frmStokTakipProgram.getContentPane().add(lblNewLabel_1);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				barkod.setText((String) modelim.getValueAt(table.getSelectedRow(),0));
				isim.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				birimfiyat.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				comboBox_1.setSelectedItem(modelim.getValueAt(table.getSelectedRow(),3));
				mevcutstok.setText((String) modelim.getValueAt(table.getSelectedRow(),4));
			}
		});
		

	}
}