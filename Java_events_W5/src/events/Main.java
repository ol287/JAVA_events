package events;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Beeper extends JPanel implements ActionListener {
    JButton clickButton;
    JButton resetButton;
    JLabel clickCountLabel;

    private int clickCount = 0;

    public Beeper() {
        super(new BorderLayout());

        // Click button
        clickButton = new JButton("Click Me");
        clickButton.setPreferredSize(new Dimension(200, 80));
        clickButton.addActionListener(this);

        // Reset button
        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(200, 80));
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickCount = 0;
                updateClickCountLabel();
            }
        });

        // Click count label
        clickCountLabel = new JLabel("Click Count: 0");
        clickCountLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clickButton);
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(clickCountLabel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clickButton) {
            clickCount++;
            updateClickCountLabel();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private void updateClickCountLabel() {
        clickCountLabel.setText("Click Count: " + clickCount);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Beeper with Click Count");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new Beeper();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
