package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Enter extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enter frame = new Enter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Enter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewUser = new JButton("NEW USER");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterUsersInfo eui = new EnterUsersInfo();
				eui.setVisible(true);
			}
		});
		btnNewUser.setBounds(145, 100, 150, 25);
		contentPane.add(btnNewUser);
		
		JButton btnNewHoliday = new JButton("NEW HOLIDAY");
		btnNewHoliday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterHolidayInfo ehi = new EnterHolidayInfo();
				ehi.setVisible(true);
				
			}
		});
		btnNewHoliday.setBounds(145, 150, 150, 25);
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
