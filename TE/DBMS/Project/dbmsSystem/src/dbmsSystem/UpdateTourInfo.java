package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class UpdateTourInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateTourInfo frame = new UpdateTourInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateTourInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblAddress = new JLabel("Source:");
		lblAddress.setBounds(100, 40, 100, 25);
		contentPane.add(lblAddress);

		JLabel lblPhone = new JLabel("Destination:");
		lblPhone.setBounds(100, 80, 100, 25);
		contentPane.add(lblPhone);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update u = new Update();
				u.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(225, 40, 100, 25);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(225, 80, 100, 25);
		contentPane.add(comboBox_1);

		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setBounds(30, 120, 100, 25);
		contentPane.add(lblDistance);

		JLabel lblCost = new JLabel("Cost:");
		lblCost.setBounds(30, 160, 100, 25);
		contentPane.add(lblCost);

		JLabel lblTravelBy = new JLabel("Travel  By:");
		lblTravelBy.setBounds(30, 200, 100, 25);
		contentPane.add(lblTravelBy);

		textField = new JTextField();
		textField.setBounds(162, 120, 100, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(162, 160, 100, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(162, 200, 100, 25);
		contentPane.add(comboBox_2);

		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().toString().isEmpty())
					JOptionPane.showMessageDialog(null, "please enter distance");
				else
					JOptionPane.showMessageDialog(null, "Updated successfully");
			}
		});
		btnNewButton.setBounds(321, 120, 100, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().toString().isEmpty())
					JOptionPane.showMessageDialog(null, "please enter cost");
				else
					JOptionPane.showMessageDialog(null, "Updated successfully");
			}
		});
		btnNewButton_1.setBounds(321, 160, 100, 25);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.setBounds(321, 200, 100, 25);
		contentPane.add(btnNewButton_2);

	}

}
