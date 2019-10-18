package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class EnterHolidayInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterHolidayInfo frame = new EnterHolidayInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void insert() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
			String query = " insert into holiday (name,source,destination,cost, date )" + " values (?, ?, ?, ?, ? )";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, textField.getText().toUpperCase());
			preparedStmt.setString(2, textField_3.getText().toUpperCase());
			preparedStmt.setString(3, textField_4.getText().toUpperCase());
			preparedStmt.setInt(4, Integer.parseInt(textField_1.getText()));
			preparedStmt.setString(5, textField_2.getText().toUpperCase());
			preparedStmt.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	/**
	 * Create the frame.
	 */
	public EnterHolidayInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(120, 40, 100, 25);
		contentPane.add(lblName);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(120,80 , 100, 25);
		contentPane.add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setBounds(120, 120, 100, 25);
		contentPane.add(lblDestination);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setBounds(120, 160, 100, 25);
		contentPane.add(lblCost);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(120, 200, 100, 25);
		contentPane.add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(230, 40, 100, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 160, 100, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(230, 200, 100, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enter enter = new Enter();
				enter.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().toString().isEmpty() || textField_1.getText().toString().isEmpty() || textField_2.getText().toString().isEmpty() || textField_3.getText().toString().isEmpty() || textField_4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"please enter all fields");
				}
				else {
					insert();
					JOptionPane.showMessageDialog(null,"holiday entered successfully");
				
				}
			}
		});
		btnNewButton.setBounds(140, 240, 140, 25);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBounds(230, 80, 100, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(230, 120, 100, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
	}
}
