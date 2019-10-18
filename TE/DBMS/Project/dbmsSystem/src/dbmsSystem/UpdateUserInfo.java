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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class UpdateUserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUserInfo frame = new UpdateUserInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void updateaddress() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
			String query = "update user set address = ? where name = ? ";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, textField_3.getText());
			preparedStmt.setString(2, textField.getText());
			
			preparedStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	public void updatephone() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
			String query = "update user set phone = ? where name = ? ";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, textField_1.getText());
			preparedStmt.setString(2, textField.getText());
			
			preparedStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	public void updatemail() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
			String query = "update user set email = ? where name = ? ";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, textField_2.getText());
			preparedStmt.setString(2, textField.getText());
			
			preparedStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public UpdateUserInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(120, 55, 100, 25);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(49, 120, 100,25);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(49, 160, 100, 25);
		contentPane.add(lblPhone);
		
		JLabel lblEmailId = new JLabel("E-Mail ID:");
		lblEmailId.setBounds(49, 200, 100, 25);
		contentPane.add(lblEmailId);
		
		textField = new JTextField();
		textField.setBounds(200, 55, 120, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 120, 120, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 160, 120, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 200,120, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnUpdateAddress = new JButton("UPDATE");
		btnUpdateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_3.getText().toString().isEmpty())
					JOptionPane.showMessageDialog(null, "please enter address");
				else {
					updateaddress();
					JOptionPane.showMessageDialog(null, "Updated successfully");
				}
			
			}
		});
		btnUpdateAddress.setBounds(300, 120, 100, 25);
		contentPane.add(btnUpdateAddress);
		
		JButton btnUpdatePhone = new JButton("UPDATE");
		btnUpdatePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().toString().isEmpty())
					JOptionPane.showMessageDialog(null, "please enter phone number");
				else {
					updatephone();
					JOptionPane.showMessageDialog(null, "Updated successfully");
				}
			
			}
		});
		btnUpdatePhone.setBounds(300, 160, 100, 25);
		contentPane.add(btnUpdatePhone);
		
		JButton btnUpdateEmail = new JButton("UPDATE");
		btnUpdateEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().toString().isEmpty())
					JOptionPane.showMessageDialog(null, "please enter E-mail id");
				else
				{
					updatemail();
					JOptionPane.showMessageDialog(null, "Updated successfully");
				}
			}
		});
		btnUpdateEmail.setBounds(300, 200, 100, 25);
		contentPane.add(btnUpdateEmail);
		
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
