package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;

public class ReadHolidayInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadHolidayInfo frame = new ReadHolidayInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReadHolidayInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Read r=new Read();
				r.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);
		
		JButton btnLoadHolidays = new JButton("Load Holidays");
		btnLoadHolidays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
				
				String query = "select * from holiday";
				PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				 
				
			}catch(Exception a)
			{
				System.out.println(a);
			}
			
		}
		});
		btnLoadHolidays.setBounds(154, 12, 166, 25);
		contentPane.add(btnLoadHolidays);
		
		table = new JTable();
		table.setBounds(12, 49, 426, 239);
		contentPane.add(table);
		
	}

}
