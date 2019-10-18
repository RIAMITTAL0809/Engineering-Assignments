package dbmsSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class StartPageofSystem extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPageofSystem frame = new StartPageofSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StartPageofSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewUser = new JButton("INSERT");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Enter enter = new Enter();
				enter.setVisible(true);
			}
		});
		btnNewUser.setBounds(145, 50, 160, 25);
		contentPane.add(btnNewUser);

		JButton btnNewTour = new JButton("UPDATE");
		btnNewTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update update = new Update();
				update.setVisible(true);

			}
		});
		btnNewTour.setBounds(145, 100, 160, 25);
		contentPane.add(btnNewTour);

		JButton btnRead = new JButton("READ");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Read read = new Read();
				read.setVisible(true);
			}
		});
		btnRead.setBounds(145, 150, 160, 25);
		contentPane.add(btnRead);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete del = new Delete();
				del.setVisible(true);
			}
		});
		btnDelete.setBounds(145, 200, 160, 25);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("JOIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				join j = new join();
				j.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(145, 250, 160, 25);
		contentPane.add(btnNewButton);
	}

}
