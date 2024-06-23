package utliz;

import java.util.List;
import javax.swing.SwingUtilities;
import Client.ClientChat;
import Server.Main;

public class UpdateFriend extends Thread {
    private static boolean isStop;
    private static int timeOut = 3000;

    public static void startUpdating() {
        isStop = false;
        new UpdateFriend().start();
    }

    public static void stopUpdating() {
        isStop = true;
    }

    @Override
    public void run() {
        while (!isStop) {
            try {
                System.out.println("Updating friends list...");
                Thread.sleep(timeOut);
                updateFriend();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void updateFriend() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {             
                int size = ClientsList.getClientsList().size();
                ClientChat.getFriendList().removeAll();
                for (int i = 0; i < size; i++) {
                    ClientChat.getFriendList().add(new FriendPanel(ClientChat.getFriendList(), ClientsList.getClientsList().get(i).getUsername(), "Online", i));
                    System.out.println(ClientsList.getClientsList().get(i).getPort());
                }               
                ClientChat.getFriendList().revalidate();
                ClientChat.getFriendList().repaint();
            }
        });
    }
}
