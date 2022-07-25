package javaPack.installGUI;
import javaPack.waveUSB.Unzipper;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.AppEvent;
import java.io.*;

public class Install extends JPanel{
    static JFrame frame = new JFrame("Install Wave USB Writer");
    static JPanel ApplicationPanel = new JPanel();
    static JPanel welcomePanel = new JPanel();
    static JPanel installPanel = new JPanel();
    static JPanel finishPanel = new JPanel();
    static JPanel uninstallPanel = new JPanel();
    static CardLayout layout = new CardLayout();
    static JMenuBar menuBar = new JMenuBar();
    static JMenu File = new JMenu();
    static BufferedWriter writer;
    static Unzipper unzip = new Unzipper();
    static JProgressBar progressBar = new JProgressBar();
    static JLabel showTask = new JLabel();
    static JLabel welcomeLabel = new JLabel("Welcome! This instaler will guide you through to install WaveUSB Writer");
    static Image background = Toolkit.getDefaultToolkit().getImage("/src/javaPack/resources/images/1.jpeg");
    static {
        try {
            writer = new BufferedWriter(new FileWriter(".appData"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Install() throws IOException {
    }

    public static void main(String[] args){

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(new Dimension(700,700));
        frame.setMinimumSize(new Dimension(600,600));
        welcomePanel.add(welcomeLabel);
        welcomePanel.setOpaque(false);
        ApplicationPanel.setLayout(layout);
        ApplicationPanel.add(welcomePanel, "1");
        frame.add(ApplicationPanel);
        layout.show(ApplicationPanel,"1");
        frame.setVisible(true);

    }
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }



}