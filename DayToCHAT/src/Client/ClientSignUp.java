package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.text.Document;

import xmlMethodSaving.SaveUserSignUp;

import javax.swing.JButton;

public class ClientSignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton SignUp, btnLogIn;
	private JTextField Email;
	private JTextField Username;
	private JTextField Password;
	private JTextField CFPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSignUp frame = new ClientSignUp();
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
	public ClientSignUp() {
		setBackground(new Color(42, 42, 42));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 42, 42));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DayToCHAT");
		lblNewLabel.setIcon(new ImageIcon(ClientSignUp.class.getResource("/res/Google_Chat_Logo_512.png")));
		lblNewLabel.setForeground(new Color(113, 255, 113));
		lblNewLabel.setFont(new Font("VNI-Centur", Font.PLAIN, 38));
		lblNewLabel.setBounds(234, 10, 360, 88);
		contentPane.add(lblNewLabel);
		
		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setForeground(new Color(113, 255, 113));
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		EmailLabel.setBounds(30, 152, 81, 31);
		contentPane.add(EmailLabel);
		
		Email = new JTextField();
		Email.setBounds(96, 152, 294, 31);
		contentPane.add(Email);
		Email.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(113, 255, 113));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsername.setBounds(400, 152, 118, 31);
		contentPane.add(lblUsername);
		
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(518, 152, 294, 31);
		contentPane.add(Username);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(113, 255, 113));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(192, 207, 103, 31);
		contentPane.add(lblPassword);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(300, 207, 294, 31);
		contentPane.add(Password);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(113, 255, 113));
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblConfirmPassword.setBounds(96, 259, 202, 31);
		contentPane.add(lblConfirmPassword);
		
		CFPassword = new JTextField();
		CFPassword.setColumns(10);
		CFPassword.setBounds(300, 259, 294, 31);
		contentPane.add(CFPassword);
		
		JRadioButton MaleRadio = new JRadioButton("Male");
		MaleRadio.setBorder(new LineBorder(new Color(192, 192, 192)));
		MaleRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MaleRadio.setForeground(new Color(113, 255, 113));
		MaleRadio.setBackground(new Color(42, 42, 42));
		MaleRadio.setBounds(343, 321, 59, 21);
		contentPane.add(MaleRadio);
		
		JRadioButton FemaleRadio = new JRadioButton("Female");
		FemaleRadio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FemaleRadio.setForeground(new Color(113, 255, 133));
		FemaleRadio.setBackground(new Color(42, 42, 42));
		FemaleRadio.setBounds(468, 321, 77, 21);
		contentPane.add(FemaleRadio);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(113, 255, 113));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGender.setBounds(214, 311, 81, 31);
		contentPane.add(lblGender);
		
		SignUp = new JButton("SIGN UP");
		SignUp.setFont(new Font("Tahoma", Font.BOLD, 27));
		SignUp.setForeground(new Color(113, 255, 113));
		SignUp.setBackground(new Color(42, 42, 42));
		SignUp.setBounds(338, 388, 180, 53);
		contentPane.add(SignUp);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		lblAlreadyHaveAn.setForeground(new Color(113, 255, 113));
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlreadyHaveAn.setBounds(535, 415, 173, 25);
		contentPane.add(lblAlreadyHaveAn);
		
		btnLogIn = new JButton("Login");
		btnLogIn.setForeground(new Color(113, 255, 113));
		btnLogIn.setBackground(new Color(42, 42, 42));
		btnLogIn.setBounds(718, 416, 81, 25);
		contentPane.add(btnLogIn);
		ButtonFunction();
	}
	private void ButtonFunction() {
		SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientLog frame = new ClientLog();
				frame.setVisible(true);
				SaveUserSignUp.UserSignUp(Email.getText(),Username.getText(),Password.getText());
				setVisible(false);
			}
		});
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientLog frame = new ClientLog();
				frame.setVisible(true);
				setVisible(false);
			}
		});
	}
}
