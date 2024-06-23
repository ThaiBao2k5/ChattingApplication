package Client;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import utliz.FriendPanel;
import utliz.UpdateFriend;
import utliz.chatmessagepanel;

public class ClientChat extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane, Menu;
    private static JPanel FriendList;
    private JPanel ChatField;
    private JTextField MessageField;
    private JButton NotifysButton, SendButton;

    private boolean direct;

    public ClientChat() {
        setBackground(new Color(0, 0, 0));
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClientChat.class.getResource("/res/Google_Chat_Logo_512.png")));
        setTitle("DayToCHAT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1091, 651);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Menu();
        Button();

        Chat();
        ButtonFunction();
        FriendList.add(new FriendPanel(FriendList, "Kossi", "Online", 0));
        FriendList.add(new FriendPanel(FriendList, "NVTB", "Online", 1));
    }

    private void Menu() {
        Menu = new JPanel();
        Menu.setBorder(new LineBorder(new Color(115, 115, 115), 3));
        Menu.setBackground(new Color(42, 42, 42));
        Menu.setBounds(10, 10, 235, 594);
        contentPane.add(Menu);
        Menu.setLayout(null);

        FriendList = new JPanel();
        FriendList.setBorder(new LineBorder(new Color(115, 115, 115), 3, true));
        FriendList.setBackground(new Color(34, 34, 34));
        FriendList.setBounds(10, 71, 215, 459);
        Menu.add(FriendList);
        FriendList.setLayout(null);
    }

    private void Button() {
        JPanel MenuButtons = new JPanel();
        MenuButtons.setBorder(new LineBorder(new Color(115, 115, 115), 5, true));
        MenuButtons.setBackground(new Color(34, 34, 34));
        MenuButtons.setBounds(0, 0, 235, 61);
        Menu.add(MenuButtons);
        MenuButtons.setLayout(null);

        JButton FriendsButton = new JButton("");
        FriendsButton.setBackground(new Color(42, 42, 42));
        FriendsButton.setInheritsPopupMenu(true);
        FriendsButton.setBorder(null);
        FriendsButton.setBorderPainted(false);
        FriendsButton.setIcon(new ImageIcon(ClientChat.class.getResource("/res/PersonImg.png")));
        FriendsButton.setBounds(10, 10, 65, 41);
        MenuButtons.add(FriendsButton);

        NotifysButton = new JButton("");
        NotifysButton.setIcon(new ImageIcon(ClientChat.class.getResource("/res/NotifyImg.png")));
        NotifysButton.setBorder(null);
        NotifysButton.setBackground(new Color(42, 42, 42));
        NotifysButton.setBounds(85, 10, 65, 41);
        MenuButtons.add(NotifysButton);

        JButton SettingButton = new JButton("");
        SettingButton.setBorder(null);
        SettingButton.setBackground(new Color(42, 42, 42));
        SettingButton.setIcon(new ImageIcon(ClientChat.class.getResource("/res/SettingImg.png")));
        SettingButton.setBounds(160, 10, 65, 41);
        MenuButtons.add(SettingButton);

        JButton AddFriendButton = new JButton("+ ADD FRIEND");
        AddFriendButton.setForeground(new Color(113, 255, 113));
        AddFriendButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        AddFriendButton.setBorder(new LineBorder(new Color(115, 115, 115)));
        AddFriendButton.setBackground(new Color(42, 42, 42));
        AddFriendButton.setBounds(10, 540, 215, 41);
        Menu.add(AddFriendButton);
    }

    private void Chat() {
        JPanel Chat = new JPanel();
        Chat.setBackground(new Color(34, 34, 34));
        Chat.setBorder(new LineBorder(new Color(115, 115, 115), 2));
        Chat.setBounds(255, 10, 812, 594);
        contentPane.add(Chat);
        Chat.setLayout(null);

        JPanel FriendChat = new JPanel();
        FriendChat.setBorder(new LineBorder(new Color(115, 115, 115), 2));
        FriendChat.setBackground(new Color(42, 42, 42));
        FriendChat.setBounds(0, 0, 812, 61);
        Chat.add(FriendChat);
        FriendChat.setLayout(null);

        JLabel NameChatWith = new JLabel("Nguyen Van Thai Bao");
        NameChatWith.setForeground(new Color(0, 255, 64));
        NameChatWith.setFont(new Font("Tahoma", Font.PLAIN, 29));
        NameChatWith.setBounds(10, 10, 283, 41);
        FriendChat.add(NameChatWith);

        JButton CallVideoButton = new JButton("");
        CallVideoButton.setIcon(new ImageIcon(ClientChat.class.getResource("/res/VideoImg.png")));
        CallVideoButton.setForeground(new Color(113, 255, 113));
        CallVideoButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        CallVideoButton.setBorder(null);
        CallVideoButton.setBackground(new Color(42, 42, 42));
        CallVideoButton.setBounds(716, 10, 86, 41);
        FriendChat.add(CallVideoButton);

        JPanel Text = new JPanel();
        Text.setLayout(null);
        Text.setBorder(new LineBorder(new Color(115, 115, 115), 2));
        Text.setBackground(new Color(42, 42, 42));
        Text.setBounds(0, 533, 812, 61);
        Chat.add(Text);

        MessageField = new JTextField();
        MessageField.setBounds(10, 10, 558, 41);
        Text.add(MessageField);
        MessageField.setColumns(10);

        SendButton = new JButton("SEND");
        SendButton.setBorder(new LineBorder(new Color(115, 115, 115)));
        SendButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        SendButton.setForeground(new Color(113, 255, 113));
        SendButton.setBackground(new Color(42, 42, 42));
        SendButton.setBounds(570, 10, 97, 41);
        Text.add(SendButton);

        JButton StickerButton = new JButton("");
        StickerButton.setBorder(new LineBorder(new Color(115, 115, 115)));
        StickerButton.setIcon(new ImageIcon(ClientChat.class.getResource("/res/EmojiImg.png")));
        StickerButton.setForeground(new Color(113, 255, 113));
        StickerButton.setBackground(new Color(42, 42, 42));
        StickerButton.setBounds(677, 10, 54, 41);
        Text.add(StickerButton);

        JButton FilesButton = new JButton("");
        FilesButton.setBorder(new LineBorder(new Color(115, 115, 115)));
        FilesButton.setIcon(new ImageIcon(ClientChat.class.getResource("/res/FileImg.png")));
        FilesButton.setForeground(new Color(113, 255, 113));
        FilesButton.setBackground(new Color(42, 42, 42));
        FilesButton.setBounds(741, 10, 61, 41);
        Text.add(FilesButton);

        ChatField = new JPanel();
        ChatField.setBackground(new Color(27, 27, 27));
        ChatField.setLayout(null);
        chatmessagepanel.setScrollpane(ChatField);
        Chat.add(chatmessagepanel.getScrollpane());
    }

    private void ButtonFunction() {
        SendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MessageField.getText().isEmpty())
                    System.out.println("Type please");
                else {
                    chatmessagepanel.sendchatmessage(MessageField.getText(), direct, ChatField);
                    direct = !direct;
                    MessageField.setText("");
                }
            }
        });
    }
    public static JPanel getFriendList() {
        return FriendList;
    }
}
