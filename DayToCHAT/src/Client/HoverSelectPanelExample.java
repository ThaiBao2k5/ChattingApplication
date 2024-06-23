package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverSelectPanelExample extends JFrame {

    private JPanel panel;

    public HoverSelectPanelExample() {
        setTitle("Hover and Select Panel Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Thêm MouseListener để xử lý hover và select
        panel.addMouseListener(new MouseAdapter() {
            private boolean isSelected = false;

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isSelected) {
                    panel.setBackground(Color.GRAY);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSelected) {
                    panel.setBackground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                isSelected = !isSelected;
                if (isSelected) {
                    panel.setBackground(Color.DARK_GRAY);
                } else {
                    panel.setBackground(Color.LIGHT_GRAY);
                }
            }
        });

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HoverSelectPanelExample example = new HoverSelectPanelExample();
            example.setVisible(true);
        });
    }
}
