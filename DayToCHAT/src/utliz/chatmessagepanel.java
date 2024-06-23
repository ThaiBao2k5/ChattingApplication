package utliz;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class chatmessagepanel {
	private static JScrollPane scrollPane;
	public static void sendchatmessage(String message, boolean isSender, JPanel ChatField) {
	    JPanel panel = new JPanel();
	    panel.setBorder(new LineBorder(new Color(115, 115, 115), 1, true));
	    panel.setBackground(new Color(42, 42, 42));
	    panel.setLayout(null);

	  
	    JLabel messageLabel = new JLabel(message);
	    messageLabel.setForeground(new Color(0, 255, 128));

	   
	    messageLabel.setSize(new java.awt.Dimension(200, Short.MAX_VALUE));
	    java.awt.Dimension preferredSize = messageLabel.getPreferredSize();

	    
	    messageLabel.setBounds(10, 10, preferredSize.width+10, preferredSize.height);
	    panel.add(messageLabel);
	    
	    int rightChatOffset = 745-messageLabel.preferredSize().width;
	    
	    
	 
	    panel.setBounds(isSender ? rightChatOffset : 10, ChatField.getComponentCount() * (preferredSize.height + 20) + 10, preferredSize.width + 20, preferredSize.height + 20);
	    
	    ChatField.add(panel);
	 
	    int messageCount = ChatField.getComponentCount();
	    int yOffset = messageCount * (preferredSize.height + 20) + 10;
	    ChatField.setPreferredSize(new Dimension(ChatField.getWidth(), yOffset));
	    
	    ChatField.revalidate();
	    ChatField.repaint();
	    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                scrollToBottom(ChatField);
            }
        });
	}
	private static void scrollToBottom(JPanel ChatField) {
	    JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
	    verticalScrollBar.setValue(verticalScrollBar.getMaximum());	    
		ChatField.repaint();
	    ChatField.revalidate();
	}
	public static void setScrollpane(JPanel ChatField) {
		scrollPane = new JScrollPane(ChatField);
		scrollPane.setBounds(10, 71, 792, 452);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	public static JScrollPane getScrollpane() {
		return scrollPane;
	}
}
