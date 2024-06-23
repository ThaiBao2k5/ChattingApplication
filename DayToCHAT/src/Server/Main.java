	package Server;
	
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import java.awt.Color;
	import javax.swing.JLabel;
	import java.awt.Font;
	import javax.swing.border.TitledBorder;
	import javax.swing.border.EtchedBorder;
	import javax.swing.JButton;
	import javax.swing.ImageIcon;
	import javax.swing.JTextPane;
	import javax.swing.JTable;
	import javax.swing.JTextArea;
	import javax.swing.table.DefaultTableModel;
	
	import Client.ClientChat;
	import utliz.ClientsList;
	
	import javax.swing.JScrollPane;
	import javax.swing.ListSelectionModel;
	import javax.swing.SwingUtilities;
	import javax.swing.border.LineBorder;
	import java.awt.TextArea;
	import java.awt.event.ActionListener;
	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.util.ArrayList;
	import java.awt.event.ActionEvent;
	import javax.swing.JTextField;
	import java.awt.Window.Type;
	
	public class Main extends JFrame {
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton ExcuteButton,SettingButton,btnChat;
		private JLabel statusLabel,PortNumberLabel;
		private JTable table;
		private TextArea textArea;
		
		private ServerSocket socket;
		private Socket Client;
		private boolean isOn = false;
	
		/**
		 * Launch the application.
		 */
		public Main() {
			ClientsList clientsList = ClientsList.getInstance();
		    setTitle("ADMIN");
		    setBackground(new Color(42, 42, 42));
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setBounds(100, 100, 866, 654);
		    contentPane = new JPanel();
		    contentPane.setBackground(new Color(42, 42, 42));
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    
		    setContentPane(contentPane);
		    contentPane.setLayout(null);
		    Status();
		    port();
		    Button();
		    Clients();
		    Log();
		    ButtonFunction();
		}
	
		private void Status() {
			JPanel status = new JPanel();
			status.setForeground(new Color(255, 255, 255));
			status.setBackground(new Color(42, 42, 42));
			status.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(113, 255, 113)));
			status.setBounds(10, 10, 308, 52);
			contentPane.add(status);
			status.setLayout(null);
			
			JLabel ServerStatusLabel = new JLabel("SERVER STATUS:");
			ServerStatusLabel.setBounds(14, 18, 156, 19);
			status.add(ServerStatusLabel);
			ServerStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			ServerStatusLabel.setForeground(new Color(255, 255, 255));
			
			statusLabel = new JLabel("STOP");
			statusLabel.setBounds(209, 10, 65, 31);
			status.add(statusLabel);
			statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			statusLabel.setForeground(new Color(255, 4, 11));
		}
		private void port() {
			JLabel PortLabel = new JLabel("PORT:");
			PortLabel.setForeground(Color.WHITE);
			PortLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			PortLabel.setBounds(328, 26, 58, 19);
			contentPane.add(PortLabel);
			
			PortNumberLabel = new JLabel("0000");
			PortNumberLabel.setForeground(new Color(113, 255, 113));
			PortNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			PortNumberLabel.setBounds(396, 18, 59, 31);
			contentPane.add(PortNumberLabel);
		}
		private void Button() {
			ExcuteButton = new JButton("ON");
			ExcuteButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
			ExcuteButton.setForeground(new Color(113, 255, 113));
			ExcuteButton.setBackground(new Color(42, 42, 42));
			ExcuteButton.setBounds(490, 23, 129, 31);
			contentPane.add(ExcuteButton);
			
			btnChat = new JButton("ANNOUNCEMENT");
			btnChat.setForeground(new Color(113, 255, 113));
			btnChat.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnChat.setBackground(new Color(42, 42, 42));
			btnChat.setBounds(626, 22, 159, 31);
			contentPane.add(btnChat);
			
			SettingButton = new JButton("");
			SettingButton.setIcon(new ImageIcon(Main.class.getResource("/res/SettingLogo.png")));
			SettingButton.setForeground(new Color(113, 255, 113));
			SettingButton.setBackground(new Color(42, 42, 42));
			SettingButton.setBounds(795, 10, 58, 52);
			contentPane.add(SettingButton);
		}
		private void ButtonFunction() {
			ExcuteButton.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        if (!isOn) {
			            isOn = true;
			            statusLabel.setText("RUNNING");
			            statusLabel.setForeground(new Color(113, 255, 113));
			            statusLabel.setBounds(180, 10, 118, 31);
			            ExcuteButton.setText("OFF");
			            ExcuteButton.setForeground(new Color(255, 4, 11));
			            startSocket();
			        } else {
			            isOn = false;
			            statusLabel.setText("STOP");
			            statusLabel.setForeground(new Color(255, 4, 11));
			            statusLabel.setBounds(209, 10, 65, 31);
			            ExcuteButton.setText("ON");
			            ExcuteButton.setForeground(new Color(113, 255, 113));
			            try {
			                if (socket != null && !socket.isClosed()) {
			                    socket.close();
			                    SwingUtilities.invokeLater(() -> textArea.append("Server đã dừng.\n"));
			                }
			            } catch (IOException ioException) {
			                SwingUtilities.invokeLater(() -> textArea.append("Lỗi khi dừng server: " + ioException.getMessage() + "\n"));
			                ioException.printStackTrace();
			            }
			        }
			    }
			});
			SettingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		private void Clients() {
			JPanel CLIENTS = new JPanel();
			CLIENTS.setBackground(new Color(42, 42, 42));
			CLIENTS.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CLIENTS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(113, 255, 113)));
			CLIENTS.setBounds(128, 81, 591, 270);
			contentPane.add(CLIENTS);
			CLIENTS.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 15, 575, 249);
			CLIENTS.add(scrollPane);
			scrollPane.setViewportBorder(null);
			
			table = new JTable();
			table.setBackground(new Color(42, 42, 42));
			table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			table.setForeground(new Color(113, 255, 113));
			table.setSurrendersFocusOnKeystroke(true);
			scrollPane.setViewportView(table);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Client", "Client's status", "Port ", "Information"
				}
			) {			
				private static final long serialVersionUID = 1L;
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					String.class, String.class, Integer.class, Object.class
				};
				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setPreferredWidth(52);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(3).setPreferredWidth(67);
		}
		private void Log() {
			JPanel LOGPanel = new JPanel();
			LOGPanel.setBackground(new Color(42, 42, 42));
			LOGPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LOG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(113, 255, 113)));
			LOGPanel.setBounds(127, 361, 592, 245);
			contentPane.add(LOGPanel);
			LOGPanel.setLayout(null);
			
			textArea = new TextArea();
			textArea.setEditable(false);
			textArea.setForeground(new Color(113, 255, 113));
			textArea.setBackground(new Color(42, 42, 42));
			textArea.setBounds(10, 18, 572, 217);
			LOGPanel.add(textArea);
		}
	
		private void startSocket() {
		    Thread start = new Thread(() -> {
		        try {
		            socket = new ServerSocket(1344);
		            PortNumberLabel.setText("1344");
		            SwingUtilities.invokeLater(() -> textArea.append("Server is running and waiting for Connections...\n"));
		            while (isOn) {
		                Client = socket.accept();
		                SwingUtilities.invokeLater(() -> textArea.append("Client đã kết nối: " + Client.getInetAddress() + "\n"));	               
		            }
		        } catch (IOException e) {        	
		            SwingUtilities.invokeLater(() -> textArea.append("Lỗi: " + e.getMessage() + "\n"));	          
		            e.printStackTrace();
		        }
		    });
		    start.start();
		}
		
		public Main getMain() {
			return this;
		}
	}
