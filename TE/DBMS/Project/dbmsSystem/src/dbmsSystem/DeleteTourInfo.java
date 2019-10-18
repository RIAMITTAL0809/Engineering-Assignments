package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;

public class DeleteTourInfo extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteTourInfo frame = new DeleteTourInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*public void del() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
			String query = " delete from tour where source = ? and destination = ? ";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, comboBox.getSelectedItem());
			preparedStmt.setString(2, comboBox_1.getSelectedItem());
			
			preparedStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}*/
	
	/**
	 * Create the frame.
	 */
	public DeleteTourInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setBounds(100, 100, 100, 25);
		contentPane.add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setBounds(100, 150, 100, 25);
		contentPane.add(lblDestination);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(230, 100, 100, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(230, 150, 100, 25);
		contentPane.add(comboBox_1);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDelete.setBounds(160, 200, 100, 25);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete del=new Delete();
				del.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);
	}

}
