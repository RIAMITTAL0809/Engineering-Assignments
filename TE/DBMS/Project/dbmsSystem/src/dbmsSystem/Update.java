package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Update extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewUser = new JButton("UPDATE USER");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUserInfo uui = new UpdateUserInfo();
				uui.setVisible(true);
				
			}
		});
		btnNewUser.setBounds(145, 100, 160, 25);
		contentPane.add(btnNewUser);
		
		JButton btnNewHoliday = new JButton("UPDATE HOLIDAY");
		btnNewHoliday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateHolidayInfo uhi=new UpdateHolidayInfo();
				uhi.setVisible(true);
				
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
