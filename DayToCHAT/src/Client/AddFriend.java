package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AddFriend extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField SearchField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFriend frame = new AddFriend();
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
	public AddFriend() {
		setTitle("AddFriend");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(115, 115, 115), 2));
		panel.setBackground(new Color(42, 42, 42));
		panel.setBounds(10, 10, 343, 595);
		contentPane.add(panel);
		panel.setLayout(null);
		
		SearchField = new JTextField();
		SearchField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SearchField.setBounds(10, 10, 221, 36);
		panel.add(SearchField);
		SearchField.setColumns(10);
		
		JButton SearchButton = new JButton("SEARCH");
		SearchButton.setForeground(new Color(113, 255, 113));
		SearchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		SearchButton.setBorder(new LineBorder(new Color(115, 115, 115)));
		SearchButton.setBackground(new Color(42, 42, 42));
		SearchButton.setBounds(235, 10, 97, 36);
		panel.add(SearchButton);
		
		JPanel Result = new JPanel();
		Result.setBorder(new LineBorder(new Color(115, 115, 115), 2));
		Result.setBackground(new Color(34, 34, 34));
		Result.setBounds(10, 56, 322, 529);
		panel.add(Result);
		Result.setLayout(null);
		
		JPanel Friend = new JPanel();
		Friend.setBorder(new LineBorder(new Color(115, 115, 115), 1, true));
		Friend.setBackground(new Color(42, 42, 42));
		Friend.setBounds(10, 10, 302, 58);
		Result.add(Friend);
		Friend.setLayout(null);
		
		JLabel Name = new JLabel("Name");
		Name.setForeground(new Color(0, 255, 128));
		Name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Name.setBounds(10, 10, 214, 38);
		Friend.add(Name);
		
		JButton AddButton = new JButton("+");
		AddButton.setBorder(new LineBorder(new Color(115, 115, 115)));
		AddButton.setBackground(new Color(42, 42, 42));
		AddButton.setForeground(new Color(0, 255, 128));
		AddButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AddButton.setBounds(234, 10, 58, 38);
		Friend.add(AddButton);
	}
}
