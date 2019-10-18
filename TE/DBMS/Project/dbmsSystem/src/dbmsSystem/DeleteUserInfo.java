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

public class DeleteUserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUserInfo frame = new DeleteUserInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void del() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Mh12nh8849");
			String query = " delete from user where name = ?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, textField.getText().toUpperCase());
			preparedStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public DeleteUserInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterTheName = new JLabel("Enter the name of the user to be deleted:");
		lblEnterTheName.setBounds(80, 80, 350, 25);
		contentPane.add(lblEnterTheName);

		textField = new JTextField();
		textField.setBounds(150, 120, 140, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().toString().isEmpty())
					JOptionPane.showMessageDialog(null, " please enter name ");
				else {
					del();
					JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
				}
			}
		});
		btnDelete.setBounds(150, 180, 140, 25);
		contentPane.add(btnDelete);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete del = new Delete();
				del.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);

	}

}
