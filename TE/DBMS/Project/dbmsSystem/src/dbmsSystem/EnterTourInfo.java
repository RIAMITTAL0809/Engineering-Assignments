package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class EnterTourInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public void insert(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
			Statement stmt=(Statement) con.createStatement();
			String query = "insert into tour values (?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, textField_2.getText().toUpperCase());
			preparedStmt.setString(2, textField_3.getText().toUpperCase());
			preparedStmt.setInt(3, Integer.parseInt(textField.getText()));
			preparedStmt.setInt(4, Integer.parseInt(textField_1.getText()));
			preparedStmt.setString(5, textField_4.getText().toUpperCase());
			preparedStmt.execute();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterTourInfo frame = new EnterTourInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EnterTourInfo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setBounds(130, 40, 100, 25);
		contentPane.add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setBounds(130, 80, 100, 25);
		contentPane.add(lblDestination);
		
		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setBounds(130, 120, 100, 25);
		contentPane.add(lblDistance);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setBounds(130, 160, 100, 25);
		contentPane.add(lblCost);
		
		JLabel lblTravelBy = new JLabel("Travel By:");
		lblTravelBy.setBounds(130, 200, 100, 25);
		contentPane.add(lblTravelBy);
		
		textField = new JTextField();
		textField.setBounds(250, 120, 100, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(250, 160, 100, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enter enter = new Enter();
				enter.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().toString().isEmpty() || textField_1.getText().toString().isEmpty() || textField_2.getText().toString().isEmpty() || textField_3.getText().toString().isEmpty() || textField_4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"please enter all fields");
				}
				else {
					insert();
					
					JOptionPane.showMessageDialog(null,"tour entered successfully");
				
				}
					
				}
		});
		btnEnter.setBounds(155, 250, 140, 25);
		contentPane.add(btnEnter);
		
		textField_2 = new JTextField();
		textField_2.setBounds(250, 40, 100, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(250, 80, 100, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(250, 200, 100, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
				
		
	}
}
