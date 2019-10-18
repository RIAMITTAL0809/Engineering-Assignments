package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Read extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Read frame = new Read();
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
	public Read() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewUser = new JButton("SHOW USER");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadUserInfo rui = new ReadUserInfo();
				rui.setVisible(true);
				
			}
		});
		btnNewUser.setBounds(145, 50, 160, 25);
		contentPane.add(btnNewUser);
		
		JButton btnNewTour = new JButton("SHOW TOUR");
		btnNewTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ReadTourInfo rti=new  ReadTourInfo();
			rti.setVisible(true);
			
			}
		});
		btnNewTour.setBounds(145, 130, 160, 25);
		contentPane.add(btnNewTour);
		
		JButton btnNewHoliday = new JButton("SHOW HOLIDAY");
		btnNewHoliday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ReadHolidayInfo rhi=new ReadHolidayInfo();
			rhi.setVisible(true);
			
			}
		});
		btnNewHoliday.setBounds(145, 210, 160, 25);
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
