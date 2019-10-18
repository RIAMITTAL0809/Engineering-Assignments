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

public class EnterUsersInfo extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private JLabel lblPhoneNumber;
	private  static  JTextField textField_2;
	private JLabel lblEmailId;
	private  static  JTextField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterUsersInfo frame = new EnterUsersInfo();
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
		String query = " insert into user (name,address,phone,email) values (?, ?, ?, ?)";
//		//System.out.println("++++++++++++++++++++++++++");
//		String name=textField.getText();
//		System.out.println(textField.getText());
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString(1, textField.getText().toUpperCase());
		preparedStmt.setString(2, textField_1.getText().toUpperCase());
		preparedStmt.setString(3, textField_2.getText().toUpperCase());
		preparedStmt.setString(4, textField_3.getText().toUpperCase());

		// execute the preparedstatement
		preparedStmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	public EnterUsersInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(100, 50, 100, 25);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(205, 50, 100, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Address:");
		lblNewLabel.setBounds(100, 100, 100, 25);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 100, 100, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblPhoneNumber = new JLabel("Number:");
		lblPhoneNumber.setBounds(100, 150, 100, 25);
		contentPane.add(lblPhoneNumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(205, 150, 100, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblEmailId = new JLabel("E-Mail ID:");
		lblEmailId.setBounds(100, 200, 100, 25);
		contentPane.add(lblEmailId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(205, 200, 100, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().toString().isEmpty() || textField_1.getText().toString().isEmpty() || textField_2.getText().toString().isEmpty() || textField_3.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null,"please enter all fields");
				}
				else {
					insert();
					
					JOptionPane.showMessageDialog(null,"user entered successfully");
				
				}
			}
		});
		btnEnter.setBounds(150, 250, 117, 25);
		contentPane.add(btnEnter);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enter enter = new Enter();
				enter.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);
	}
}
