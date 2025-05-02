package classworkFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class UI extends JFrame implements ActionListener {
    private MyTextField display;
    private JTextField secondaryDisplay;
    private JButton[] buttons;
    private int num1, num2, result;
    private String operator;
    private ArrayList<String> historyList = new ArrayList<>();

    UI() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(2, 1));

        secondaryDisplay = new JTextField();
        secondaryDisplay.setEditable(false);
        secondaryDisplay.setFont(new Font("Arial", Font.PLAIN, 16));

        display = new MyTextField("");
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setHorizontalAlignment(JTextField.RIGHT);

        displayPanel.add(secondaryDisplay);
        displayPanel.add(display);

        frame.add(displayPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 3, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "4",
                "5", "6", "1", "2",
                "3", "0", "+", "-",
                "*", "/", "=",
                "C", "AC", "History"
        };

        buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            panel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }


        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (e.getActionCommand()){
            case "+": case "-": case "*": case "/":
                num1 = Integer.parseInt(display.getText());
                operator = command;
                display.setText("");
                display.setNumber(num1+operator);
                break;

            case "History":
                JFrame history = new JFrame("History");
                history.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                history.setSize(300, 400);
                JPanel historyPanel = new JPanel();
                historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.Y_AXIS));
                for (String h : historyList) {
                    JLabel label = new JLabel(h);
                    label.setAlignmentX(Component.LEFT_ALIGNMENT);
                    historyPanel.add(label);
                }
                JScrollPane scrollPane = new JScrollPane(historyPanel);
                history.add(scrollPane);
                history.setVisible(true);
                break;

            case "C":
                int endIndex = display.getText().length() -1;
                display.setText(display.getText().substring(0, endIndex));
                break;

            case "AC":
                num1 = 0;
                operator = "";
                display.setText("");
                display.setNumber("");
                break;

            case "=":
                num2 = Integer.parseInt(display.getText());
                switch(operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "/":
                        if (num2 == 0){
                            display.setText("не діліть на 0");
                            display.setNumber("");
                            return;
                        }else {
                            result = num1 / num2;
                        }
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                }

                display.setText(String.valueOf(result));
                display.setNumber("");
                Path historyPath = Path.of("C:\\Users\\User\\IdeaProjects\\java\\src\\classworkFrame\\history.txt");
                String content = String.format("%d %s %d = %d%n", num1, operator, num2, result);
                historyList.add(content);
                try {
                    Files.writeString(historyPath, content, java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND);
                } catch (IOException ex) {
                    System.out.println("Сталася помилка при записі файлу: " + ex.getMessage());
                }
                num1 = result;
                break;
            default:
                display.setText(display.getText()+command);
                break;
            }
    }
}


