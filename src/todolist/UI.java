package todolist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JFrame implements ActionListener, MouseMotionListener, MouseListener {
    private JButton button = new JButton("Додати");
    private JTextField textfield = new JTextField(30);
    private JPanel notStarted = new JPanel();
    private JPanel inProgress = new JPanel();
    private JPanel finished = new JPanel();

    private JPanel draggedTask;
    private Point initialClick;

    private int mouseX;
    private int mouseY;


    public UI() {
        setTitle("todo list");
        setSize(1200, 700);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());

        button.addActionListener(this);

        top.add(textfield);
        top.add(button);
        add(top, BorderLayout.NORTH);

        JPanel columns = new JPanel();
        columns.setLayout(new GridLayout(1, 3));


        notStarted.setBackground(Color.RED);
        notStarted.setLayout(new BoxLayout(notStarted, BoxLayout.Y_AXIS));


        inProgress.setBackground(Color.YELLOW);
        inProgress.setLayout(new BoxLayout(inProgress, BoxLayout.Y_AXIS));


        finished.setBackground(Color.GREEN);
        finished.setLayout(new BoxLayout(finished, BoxLayout.Y_AXIS));

        columns.add(notStarted);
        columns.add(inProgress);
        columns.add(finished);

        add(columns, BorderLayout.CENTER);
        enableDrop(notStarted);
        enableDrop(inProgress);
        enableDrop(finished);

        notStarted.setPreferredSize(new Dimension(400, 600));
        inProgress.setPreferredSize(new Dimension(400, 600));
        finished.setPreferredSize(new Dimension(400, 600));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void enableDrop(JPanel panel) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (textfield.getText().isEmpty())
            return;
        JPanel task = new JPanel();
        task.setLayout(new BoxLayout(task, BoxLayout.X_AXIS));

        JLabel label = new JLabel(textfield.getText());
        JButton delete = new JButton("Видалити");

        task.addMouseListener(this);
        task.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        task.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        delete.addActionListener(evt -> {
            Container parent = task.getParent();
            if (parent != null) {
                parent.remove(task);
                revalidate();
                repaint();
            }
        });

        task.add(delete);
        task.add(label);
        task.add(Box.createHorizontalStrut(10));
        task.setOpaque(false);

        task.setTransferHandler(new TransferHandler("taskPanel"));
        task.addMouseListener(this);
        task.addMouseMotionListener(this);

        notStarted.add(task);
        textfield.setText("");
        revalidate();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (draggedTask == null)
            return;

        Point location = draggedTask.getLocation();
        int x = location.x - initialClick.x + e.getX();
        int y = location.y - initialClick.y + e.getY();

        draggedTask.setLocation(x, y);
        draggedTask.getParent().repaint();
//        draggedTask.getParent().revalidate();

        draggedTask.getParent().setComponentZOrder(draggedTask, 0);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        draggedTask = (JPanel) e.getSource();
        initialClick = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (draggedTask == null)
            return;
        Rectangle boundsNotStarted = notStarted.getBounds();
        Rectangle boundsInProgress = inProgress.getBounds();
        Rectangle boundsFinished = finished.getBounds();

        Point releaseLocation = SwingUtilities.convertPoint(draggedTask, e.getPoint(), getContentPane());
        if (boundsNotStarted.contains(releaseLocation)) {
            moveTask(draggedTask, notStarted);
        } else if (boundsInProgress.contains(releaseLocation)) {
            moveTask(draggedTask, inProgress);
        } else if (boundsFinished.contains(releaseLocation)) {
            moveTask(draggedTask, finished);
        } else {
            moveTask(draggedTask, notStarted);
        }
        draggedTask.getParent().setComponentZOrder(draggedTask, 0);
    }

    private boolean isInsidePanel(Point releaseLocation, JPanel panel) {
        panel.revalidate();
        panel.repaint();

        return panel.getBounds().contains(releaseLocation);
    }

    private void moveTask(JPanel draggedTask, JPanel panel) {
        Container parent = draggedTask.getParent();
        if (parent != null)
            parent.remove(draggedTask);

        panel.add(draggedTask);
        panel.revalidate();
        panel.repaint();

        getContentPane().revalidate();
        getContentPane().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
