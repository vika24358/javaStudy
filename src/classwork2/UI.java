package classwork2;
import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JFrame implements MouseMotionListener, ActionListener {
    int oldX, oldY;
    Color color = Color.black;
    int stroke = 5;

    public UI() {
        setTitle("UI");
        setSize(1000, 900);
        setLayout(null);
        setBackground(Color.WHITE);

        addMouseMotionListener(this);

        JPanel instruments = new JPanel();
        instruments.setSize(1000, 200);
        instruments.setLayout(null);
        instruments.setBackground(Color.LIGHT_GRAY);


        JButton pink = new JButton("pink");
        pink.setBackground(Color.PINK);
        pink.setBounds(900, 0, 100, 100);
        pink.addActionListener(this);
        instruments.add(pink);

        JButton green = new JButton("green");
        green.setBackground(Color.GREEN);
        green.setBounds(800, 0, 100, 100);
        green.addActionListener(this);
        instruments.add(green);

        JButton blue = new JButton("blue");
        blue.setBackground(Color.BLUE);
        blue.setBounds(700, 0, 100, 100);
        blue.addActionListener(this);
        instruments.add(blue);

        JButton yellow = new JButton("yellow");
        yellow.setBackground(Color.YELLOW);
        yellow.setBounds(600, 0, 100, 100);
        yellow.addActionListener(this);
        instruments.add(yellow);

        JButton black = new JButton("black");
        black.setBackground(Color.BLACK);
        black.setBounds(600, 100, 100, 100);
        black.addActionListener(this);
        instruments.add(black);

        JButton white = new JButton("white");
        white.setBackground(Color.WHITE);
        white.setBounds(700, 100, 100, 100);
        white.addActionListener(this);
        instruments.add(white);

        JButton red = new JButton("red");
        red.setBackground(Color.RED);
        red.setBounds(800, 100, 100, 100);
        red.addActionListener(this);
        instruments.add(red);

        JButton orange = new JButton("orange");
        orange.setBackground(Color.ORANGE);
        orange.setBounds(900, 100, 100, 100);
        orange.addActionListener(this);
        instruments.add(orange);

        JButton eraser = new JButton("eraser");
        eraser.setBounds(50, 50, 200, 100);
        eraser.addActionListener(this);
        add(eraser);

        JButton stroke5 = new JButton("5");
        stroke5.setBounds(300, 25, 200, 5);
        stroke5.setBackground(Color.BLACK);
        stroke5.addActionListener(this);
        instruments.add(stroke5);

        JButton stroke10 = new JButton("10");
        stroke10.setBounds(300, 50, 200, 10);
        stroke10.setBackground(Color.BLACK);
        stroke10.addActionListener(this);
        instruments.add(stroke10);

        JButton stroke15 = new JButton("15");
        stroke15.setBounds(300, 80, 200, 15);
        stroke15.setBackground(Color.BLACK);
        stroke15.addActionListener(this);
        instruments.add(stroke15);

        JButton stroke20 = new JButton("20");
        stroke20.setBounds(300, 115, 200, 20);
        stroke20.setBackground(Color.BLACK);
        stroke20.addActionListener(this);
        instruments.add(stroke20);

        JButton stroke30 = new JButton("30");
        stroke30.setBounds(300, 150, 200, 30);
        stroke30.setBackground(Color.BLACK);
        stroke30.addActionListener(this);
        instruments.add(stroke30);

        instruments.setVisible(true);
        add(instruments);
        setVisible(true);
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(stroke));
        int x = e.getX();
        int y = e.getY();
        if (y < 225 || oldY < 225) {
            return;
        }

        g2d.drawLine(oldX, oldY, x, y);
        oldX = x;
        oldY = y;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
    }

//    public void eraser(MouseEvent e) {
//        Graphics g = getGraphics();
//        g.setColor(Color.WHITE);
//        int x = e.getX();
//        int y = e.getY();
//        g.fillRect(x, y, 20, 20);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "pink":
                color = Color.PINK;
                break;

            case "green":
                color = Color.GREEN;
                break;

            case "blue":
                color = Color.BLUE;
                break;

            case "yellow":
                color = Color.YELLOW;
                break;

            case "black":
                color = Color.BLACK;
                break;

            case "white":
                color = Color.WHITE;
                break;

            case "red":
                color = Color.RED;
                break;

            case "orange":
                color = Color.ORANGE;
                break;

            case "eraser":
                stroke = 50;
                color = getBackground();
                break;

            case "5":
                stroke = 5;
                break;

            case "10":
                stroke = 10;
                break;

            case "15":
                stroke = 15;
                break;

            case "20":
                stroke = 20;
                break;

            case "30":
                stroke = 30;
                break;

        }
    }
}
