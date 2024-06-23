package utliz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FriendPanel extends JPanel {
	private boolean isSelected = false;
	private JPanel Friend;
	private JLabel Name,Status;
	private int yOffset=10;
	private int index;
	public FriendPanel(JPanel s,String Username, String isOnl, int index) {
		Friend = new JPanel();
		Friend.setBorder(new LineBorder(new Color(115, 115, 115), 1, true));
		Friend.setBackground(new Color(42, 42, 42));
		Friend.setBounds(10, 10, 195, 39);
		s.add(Friend);
		Friend.setLayout(null);		
		Name = new JLabel(Username);
		Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Name.setForeground(new Color(0, 255, 128));
		Name.setBounds(10, 10, 112, 19);
		Friend.add(Name);
		Status = new JLabel(isOnl);
		Status.setForeground(new Color(192, 192, 192));
		Status.setBounds(140, 10, 45, 18);
		Friend.add(Status);
		MouseInput(Username);
		while(true) {
			if(this.index == index) {
				Friend.setBounds(10, yOffset, 195, 39);
				break;
			}
			index++;
			yOffset-=42;
		}	
	}
	public void MouseInput(String Username) {
		Friend.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isSelected) {
                	Friend.setBackground(new Color(34,34,34));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSelected) {
                	Friend.setBackground(new Color(42, 42, 42));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                isSelected = !isSelected;
                if (isSelected) {
                    Friend.setBackground(new Color(20, 20, 20));
                    Object[] options = {"Kết nối", "Không"};
                    int choice = JOptionPane.showOptionDialog(Status, "Bạn có muốn kết nối với "+Username+ " không?", "Xác nhận kết nối",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (choice == JOptionPane.YES_OPTION) {
                      
                    }
                } else {
                    Friend.setBackground(Color.LIGHT_GRAY);
                }
            }

        });
	}
}
