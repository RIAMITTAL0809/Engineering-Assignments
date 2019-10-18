package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class UpdateHolidayInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	
	public void updatecost()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
			String query2 = "update holiday set cost = ? where name = ?";
			PreparedStatement preparedStmt2 = con.prepareStatement(query2);
			preparedStmt2.setInt(1,Integer.parseInt(textField_2.getText()));
			preparedStmt2.setString(2, textField.getText().toUpperCase());
			preparedStmt2.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updatedate() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
			String query2 = "update holiday set date = ? where name = ?";
			PreparedStatement preparedStmt2 = con.prepareStatement(query2);
			preparedStmt2.setString(1, textField_5.getText().toUpperCase());
			preparedStmt2.setString(2, textField.getText().toUpperCase());
			preparedStmt2.executeUpdate();
		} catch (Exception a) {
			System.out.println(a);
		}
	}
		
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateHolidayInfo frame = new UpdateHolidayInfo();
					frame.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateHolidayInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(120, 40, 100, 25);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 40, 120, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblAddress = new JLabel("Cost:");
		lblAddress.setBounds(49, 100, 100,25);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Date:");
		lblPhone.setBounds(49, 140, 100, 25);
		contentPane.add(lblPhone);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 100, 120, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
				
		textField_5 = new JTextField();
		textField_5.setBounds(150, 140, 120, 25);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().toString().isEmpty() || textField_2.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null,"please enter name and cost");
					//System.out.println("+++++++"+textField.getText());
					
				}
				else {
					updatecost();
					//System.out.println("+++++++"+textField.getText());
					JOptionPane.showMessageDialog(null,"cost updated successfully");
				}
			}
		});
		btnNewButton.setBounds(300, 100, 100, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() || textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"please enter name and date");
				}
				else {
					updatedate();
					JOptionPane.showMessageDialog(null,"date updated successfully");
				}
				}
		});
		btnNewButton_1.setBounds(300, 140, 100, 25);
		contentPane.add(btnNewButton_1);
		
		

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update u=new Update();
				u.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);
		
		
		
	}

}
