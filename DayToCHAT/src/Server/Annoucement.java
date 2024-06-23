package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Annoucement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Annoucement frame = new Annoucement();
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
	public Annoucement() {
		setTitle("Annoucement");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 403, 654);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(42, 42, 42));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CHAT", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 255, 128)));
		panel.setBounds(10, 10, 370, 549);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 15, 326, 463);
		panel.add(textArea);
		textArea.setEditable(false);
		
		textField = new JTextField();
		textField.setBounds(6, 502, 222, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("SEND");
		btnSend.setBounds(238, 502, 63, 30);
		panel.add(btnSend);
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSend.setForeground(new Color(113, 255, 113));
		btnSend.setBackground(new Color(42, 42, 42));
		
		JButton LoginButton_1 = new JButton("QUICK");
		LoginButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		LoginButton_1.setBounds(301, 502, 63, 30);
		panel.add(LoginButton_1);
		LoginButton_1.setForeground(new Color(113, 255, 113));
		LoginButton_1.setBackground(new Color(42, 42, 42));
	}
}
