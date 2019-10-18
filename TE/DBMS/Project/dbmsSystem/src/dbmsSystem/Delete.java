package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Delete extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewUser = new JButton("DELETE USER");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUserInfo dui = new DeleteUserInfo();
				dui.setVisible(true);
			}
		});
		btnNewUser.setBounds(145, 100, 160, 25);
		contentPane.add(btnNewUser);
		
		JButton btnNewHoliday = new JButton("DELETE HOLIDAY");
		btnNewHoliday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteHolidayInfo dhi = new DeleteHolidayInfo();
				dhi.setVisible(true);
				
			}
		});
		btnNewHoliday.setBounds(145, 150, 160, 25);
		contentPane.add(btnNewHoliday);
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPageofSystem spos=new StartPageofSystem();
				spos.setVisible(true);
			}
		});
		btnBack.setBounds(12, 12, 70, 25);
		contentPane.add(btnBack);
		
		
	}

}
