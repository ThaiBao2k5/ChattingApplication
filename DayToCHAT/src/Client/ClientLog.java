package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Server.*;
import utliz.ClientsList;
import utliz.UpdateFriend;
import xmlMethodSaving.UserAuthentication;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ClientLog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton LoginButton,Cancel,SignUp;
	private JTextField Emailfield;
	private JPasswordField passwordField;
	
	private Socket Client;
	private int portPeer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientLog frame = new ClientLog();
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
	public ClientLog() {
		setBackground(new Color(42, 42, 42));
		setTitle("DayToCHAT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DayToCHAT");
		lblNewLabel.setIcon(new ImageIcon(ClientLog.class.getResource("/res/Google_Chat_Logo_512.png")));
		lblNewLabel.setForeground(new Color(113, 255, 113));
		lblNewLabel.setFont(new Font("VNI-Centur", Font.PLAIN, 38));
		lblNewLabel.setBounds(142, 10, 360, 88);
		contentPane.add(lblNewLabel);
		
		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setForeground(new Color(113, 255, 113));
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EmailLabel.setBounds(93, 144, 59, 25);
		contentPane.add(EmailLabel);
		
		Emailfield = new JTextField();
		Emailfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Emailfield.setColumns(10);
		Emailfield.setBounds(191, 145, 341, 31);
		contentPane.add(Emailfield);
		
		JLabel PasswordLebel = new JLabel("Password");
		PasswordLebel.setForeground(new Color(113, 255, 113));
		PasswordLebel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PasswordLebel.setBounds(81, 185, 84, 25);
		contentPane.add(PasswordLebel);
		
		LoginButton = new JButton("LOGIN");
		LoginButton.setForeground(new Color(113, 255, 113));
		LoginButton.setBackground(new Color(42, 42, 42));
		LoginButton.setBounds(226, 243, 103, 25);
		contentPane.add(LoginButton);
		
		Cancel = new JButton("CANCEL");
		Cancel.setForeground(new Color(113, 255, 113));
		Cancel.setBackground(new Color(42, 42, 42));
		Cancel.setBounds(364, 243, 103, 25);
		contentPane.add(Cancel);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account? ");
		lblDontHaveAn.setForeground(new Color(113, 255, 113));
		lblDontHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDontHaveAn.setBounds(340, 292, 163, 25);
		contentPane.add(lblDontHaveAn);
		
		SignUp = new JButton("SIGN UP");
		SignUp.setForeground(new Color(113, 255, 113));
		SignUp.setBackground(new Color(42, 42, 42));
		SignUp.setBounds(507, 294, 103, 25);
		contentPane.add(SignUp);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 186, 341, 31);
		contentPane.add(passwordField);
		
		ButtonFunction();
	}
	private void ButtonFunction() {
		LoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UserAuthentication.UserLogin(Emailfield.getText(), passwordField.getText());
				ClientChat frame = new ClientChat();
				frame.setVisible(true);
				UpdateFriend.startUpdating();
				setVisible(false);
				startConnect();
				
				Client newClient = new Client(Emailfield.getText(), "Online", portPeer);
	            //Main.getClientList().add(newClient); 
				ClientsList clientsList = ClientsList.getInstance();
				clientsList.AddClient(newClient);
				System.out.println(Emailfield.getText());					          
			}
		});
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientSignUp frame = new ClientSignUp();
				frame.setVisible(true);
				setVisible(false);
			}
		});
	}
	  private void startConnect() {
	        Thread connectThread = new Thread(() -> {
	            try {
	                Random rd = new Random();
	                portPeer = 10000 + Math.abs(rd.nextInt() % 1000);	        
	                System.out.println("Generated portPeer: " + portPeer);
	                Client = new Socket("localhost", 1344);
	                
	               
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	        connectThread.start();

	       
	        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	            disconnect();
	        }));
	    }

	    private void disconnect() {
	        if (Client != null && !Client.isClosed()) {
	            try {
	                Client.close();
	                System.out.println("Đã ngắt kết nối khỏi máy chủ.");
	            } catch (IOException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Không thể ngắt kết nối khỏi máy chủ.", "Lỗi Ngắt Kết Nối", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }


	
}
