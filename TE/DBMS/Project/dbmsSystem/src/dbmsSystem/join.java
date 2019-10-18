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

public class join extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					join frame = new join();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPageofSystem spos = new StartPageofSystem();
				spos.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);
		
		JButton btnNaturalJoin = new JButton("Natural Join");
		btnNaturalJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
					
					String query = "SELECT name,source,destination FROM user NATURAL JOIN holiday";
					PreparedStatement stmt = con.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					
				}catch(Exception a)
				{
					System.out.println(a);
				}
				
			}
			
			
		});
		btnNaturalJoin.setBounds(162, 12, 117, 25);
		contentPane.add(btnNaturalJoin);
		
		table = new JTable();
		table.setBounds(22, 65, 398, 210);
		contentPane.add(table);
		
		
	}

}
