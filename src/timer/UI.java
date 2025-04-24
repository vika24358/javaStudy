package timer;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {

    private JLabel timeLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;

    private Thread timerThread = new Thread();
    private int seconds = 0;
    private boolean running = false;

    public UI() {
        setTitle("Timer");
        setSize(320, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        timeLabel = new JLabel("00:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(timeLabel);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        add(startButton);
        add(stopButton);
        add(resetButton);

        startButton.addActionListener(e -> {
            if (timerThread == null || !timerThread.isAlive()) {
                running = true;
                timerThread = new Thread(() -> {
                    while (running) {
                        try {
                            SwingUtilities.invokeLater(() -> timeLabel.setText(formatTime(seconds)));
                            Thread.sleep(1000);
                            seconds++;
                        } catch (InterruptedException ex) {
                            break;
                        }
                    }
                });
                timerThread.start();
            }
        });

        stopButton.addActionListener(e -> {
            running = false;
        });

        resetButton.addActionListener(e -> {
            running = false;
            seconds = 0;
            if (timerThread != null) {
                timerThread.interrupt();
            }
            timeLabel.setText("00:00");
        });

        setVisible(true);
    }

    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
