package classworkFrame;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {
    private String number = "";

    public MyTextField(String number) {
        super(number);
        repaint();
    }

    public void setNumber (String number) {
        this.number = number;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GRAY);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString(number, getWidth()/2, 25);
    }
}
