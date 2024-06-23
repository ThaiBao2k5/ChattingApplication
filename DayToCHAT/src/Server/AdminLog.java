package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utliz.ClientsList;
import utliz.UpdateClient;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLog extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EmailField;
	private JButton LoginButton,Cancel;
	private JPasswordField PassField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLog frame = new AdminLog();
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
	public AdminLog() {
		setBackground(new Color(42, 42, 42));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 322);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DayToCHAT");
		lblNewLabel.setForeground(new Color(113, 255, 113));
		lblNewLabel.setFont(new Font("VNI-Centur", Font.PLAIN, 38));
		lblNewLabel.setIcon(new ImageIcon(AdminLog.class.getResource("/res/Google_Chat_Logo_512.png")));
		lblNewLabel.setBounds(126, 10, 360, 88);
		contentPane.add(lblNewLabel);
		
		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setForeground(new Color(113, 255, 113));
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EmailLabel.setBounds(63, 134, 59, 25);
		contentPane.add(EmailLabel);
		
		JLabel PasswordLebel = new JLabel("Password");
		PasswordLebel.setForeground(new Color(113, 255, 113));
		PasswordLebel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PasswordLebel.setBounds(51, 175, 84, 25);
		contentPane.add(PasswordLebel);
		
		EmailField = new JTextField();
		EmailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		EmailField.setBounds(161, 135, 341, 31);
		contentPane.add(EmailField);
		EmailField.setColumns(10);
		
		LoginButton = new JButton("LOGIN");
		
		LoginButton.setForeground(new Color(113, 255, 113));
		LoginButton.setBackground(new Color(42, 42, 42));
		LoginButton.setBounds(196, 233, 103, 25);
		contentPane.add(LoginButton);
		
		Cancel = new JButton("CANCEL");
		
		Cancel.setForeground(new Color(113, 255, 113));
		Cancel.setBackground(new Color(42, 42, 42));
		Cancel.setBounds(334, 233, 103, 25);
		contentPane.add(Cancel);
		
		PassField = new JPasswordField();
		PassField.setBounds(161, 176, 341, 31);
		contentPane.add(PassField);
		
		ButtonFunction();
	}
	private void ButtonFunction() {
		LoginButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		        Main frame = new Main();
		        frame.setVisible(true);
		        UpdateClient.startUpdating();
		        setVisible(false);
		    }
		});

		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
