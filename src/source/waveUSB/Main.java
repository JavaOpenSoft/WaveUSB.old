package source.waveUSB;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


class Main {
   //Components of the Application
    static JFrame frame = new JFrame("Wave USB Image Writer");
    static JPanel ApplicationPanel = new JPanel();
    static JPanel welcome = new JPanel();
    static JPanel macOS = new JPanel();
    static JPanel Linux = new JPanel();
    static JPanel Windows = new JPanel();
    static JPanel others = new JPanel();
    static JPanel downloadImage = new JPanel();
    static JPanel writeImageToUSB = new JPanel();
    static JPanel verifyUSB = new JPanel();
    static JPanel finishedScreen = new JPanel();//ending screen
    static JPanel macOS11EULA = new JPanel();
    static JPanel macOS12EULA = new JPanel();
    static JButton macOS_11 = new JButton("macOS 11 (Codenamed Big Sur)");
    static JButton macOS_12 = new JButton("macOS 12(Codenamed Monterey)");
    static JButton macOS_12_MBP = new JButton("macOS 12 (Macbook Pro specific)(Codenamed Monterey)");
    static JLabel macOSChoose = new JLabel("Choose your macOS Version:");
    static JInternalFrame jInternalFrame = new JInternalFrame();
    static JProgressBar jProgressBar = new JProgressBar();
    static JScrollPane jScrollPane = new JScrollPane();
    static JScrollBar jScrollBar = new JScrollBar();
    static JTextArea jTextArea = new JTextArea();
    static JLabel percentLabel = new JLabel();
    static JLabel timeLeftLabel = new JLabel();
    static CardLayout layout = new CardLayout();
    static JFileChooser jFileChooser = new JFileChooser();
    static JMenuBar menuBar = new JMenuBar();

    static JLabel chooseOS = new JLabel("To start, choose your operating system installer you want to write to your USB:");
    static JLabel welcomeLabel = new JLabel("Welcome!");
    static JLabel linuxChoose = new JLabel("Please choose your linux Installer:");
    static JLabel othersChoose = new JLabel("Please choose an image file:");
    static JMenu fileMenu = new JMenu("File");
    static JMenu help = new JMenu("help");
    static JMenu downloadMenu = new JMenu("Download");
    static JMenu settingsMenu = new JMenu("Settings");
    static JTextField imageFileDirectory = new JTextField("Enter the file path or select a file..");
    //Buttons
    static JButton selectFile = new JButton("Select a Image File");
    static JButton macOSButton = new JButton("macOS");
    static JButton windowsButton = new JButton("Windows");
    static JButton linuxButton = new JButton("Linux");
    static JButton otherButton = new JButton("Other..");
    static JButton ubuntu = new JButton("Ubuntu 22.04(Codenamed Jammy Jellyfish)");
    static JButton debian = new JButton("Debian 11-32 bit(Codenamed Bullseye)");
    static JButton debian64 = new JButton("Debian 11 64-bit (Codenamed Bullseye)");
    static JButton debianNet64 = new JButton("Debian 11 64-bit Network Installer(Codenamed Bullseye)");
    static JButton debianNet = new JButton("Debian 11 32-bit Network Installer(Codenamed Bullseye)");
    static JButton ubuntuServer = new JButton("Ubuntu Server 22.04(Codenamed Jammy Jellyfish)");
    static JButton Arch = new JButton("Arch 2022.07.01 64-bit");
    static JButton fedoraWorkspace = new JButton("Fedora Workstation 36 32-bit");
    static JButton fedoraWorkspace64 = new JButton("Fedora Workstation 36 64-bit");
    static JButton fedoraServer = new JButton("Fedora Server 36 32-bit");
    static JButton fedoraServer_ARM = new JButton("Fedora Server ARM 64-bit");
    static JButton fedoraServerNet64 = new JButton("Fedora Server Net 64-bit");
    static JButton fedoraServerNet_ARM = new JButton("Fedora Server Net ARM 64-bit");
    static JButton deepin = new JButton("Deepin OS 20.6");
    static JButton ManjaroGnome = new JButton("Manjaro Gnome Edtion");
    static JButton ManjaroXFCE = new JButton("Manjaro XFCE Edition");
    static JButton ManjaroKDE = new JButton("Manjaro KDE Edition");
    static JButton LinuxMintEdge = new JButton("Linux Mint Edge Edition Version 20.3");
    static JButton LinuxMintCinnamon = new JButton("Linux Mint Cinnamon Version 20.3");
    static JButton LinuxMintMate = new JButton("Linux Mint MATE Edition Version 20.3");
    static JButton LinuxMintXfce = new JButton("Linux Mint Xfce Edition Version 20.3");
    static JButton elementaryOS = new JButton("Elementary OS Version 6.1");
    static JButton solusGnome = new JButton("Solus Gnome Edition Version 4.3");
    static JButton solusBudgie = new JButton("Solus Budgie Edition Version 4.3");
    static JButton solusMATE = new JButton("Solus MATE Edition Version 4.3");
    static JButton solusKDE = new JButton("Solus KDE Edition Version 4.3");
    static JButton blackArch = new JButton("Black Arch Version 2021.09.1 64-bit");
    static JButton blackArchMinimum = new JButton("Black Arch Minimum Edition Version 2021.09.1 64-bit");
    static JButton blackArchNet = new JButton("Black Arch Network Installer Version 2021.09.1 64-bit");
    static JButton Windows8 = new JButton("Windows 8 32-bit");
    static JButton Windows8_64 = new JButton("Windows 8 64-bit");
    static JButton Windows10 = new JButton("Windows 10 32-bit");
    static JButton Windows10_64 = new JButton("Windows 10 64-bit");
    static JButton Windows11 = new JButton("Windows 11");
    static JButton next = new JButton("Next");
    static JButton back = new JButton("Back");
    static JButton back2 = new JButton("Back");
    static JButton back3 = new JButton("Back");
    static JButton back4 = new JButton("Back");
    static JButton back5 = new JButton("Back");
    static JButton back6 = new JButton("Back");
    static JButton back7 = new JButton("Back");
    static JButton back8 = new JButton("Back");
    static JLabel windowsChose = new JLabel("Chose your Windows Version");
    //Image File
    static File image ;
    Icon icon = new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB");
    public static void main(String[] args){
        selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = jFileChooser.showOpenDialog(null);
                if(response == JFileChooser.APPROVE_OPTION) {
                    imageFileDirectory.setText(jFileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(ApplicationPanel, "5");
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(ApplicationPanel, "1");
            }
        });
        macOSButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(ApplicationPanel, "2");
            }
        });
        windowsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                layout.show(ApplicationPanel, "4");
            }
        });
        back2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                layout.show(ApplicationPanel, "1");
            }
        });
        back4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                layout.show(ApplicationPanel, "1");
            }
        });
        back3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(ApplicationPanel, "1");
            }
        });
        linuxButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(ApplicationPanel, "3");
            }
        });
        macOS_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        welcomeLabel.setFont(new Font("SansSerif", Font.PLAIN,30));
        macOSChoose.setFont(new Font("SansSerif", Font.PLAIN, 30));
        welcome.setLayout(null);
        welcome.setBorder(new EmptyBorder(5, 5, 5, 5));
        welcome.add(welcomeLabel);
        welcome.add(chooseOS);
        welcome.add(macOSButton);
        welcome.add(windowsButton);
        welcome.add(linuxButton);
        welcome.add(otherButton);
        welcome.add(otherButton);
        macOS.setLayout(null);
        macOS.setBorder(new EmptyBorder(5, 5, 5, 5));
        macOS.add(macOSChoose);
        macOS.add(macOS_11);
        macOS.add(macOS_12);
        macOS.add(macOS_12_MBP);
        macOS.add(back);
        Linux.setLayout(null);
        Linux.setBorder(new EmptyBorder(5, 5, 5, 5));
        Linux.add(linuxChoose);
        Linux.add(ubuntu);
        Linux.add(ubuntuServer);
        Linux.add(debian);
        Linux.add(debian64);
        Linux.add(debianNet);
        Linux.add(debianNet64);
        Linux.add(Arch);
        Linux.add(fedoraWorkspace);
        Linux.add(fedoraWorkspace64);
        Linux.add(fedoraServer);
        Linux.add(fedoraServer_ARM);
        Linux.add(fedoraServerNet64);
        Linux.add(fedoraServerNet_ARM);
        Linux.add(deepin);
        Linux.add(ManjaroGnome);
        Linux.add(ManjaroKDE);
        Linux.add(ManjaroXFCE);
        Linux.add(LinuxMintCinnamon);
        Linux.add(LinuxMintEdge);
        Linux.add(LinuxMintMate);
        Linux.add(LinuxMintXfce);
        Linux.add(elementaryOS);
        Linux.add(solusGnome);
        Linux.add(solusBudgie);
        Linux.add(solusKDE);
        Linux.add(solusMATE);
        Linux.add(blackArch);
        Linux.add(blackArchMinimum);
        Linux.add(blackArchNet);
        Linux.add(back2);
        Windows.setLayout(null);
        Windows.setBorder(new EmptyBorder(5, 5, 5, 5));
        Windows.add(windowsChose);
        Windows.add(Windows8);
        Windows.add(Windows8_64);
        Windows.add(Windows10);
        Windows.add(Windows10_64);
        Windows.add(Windows11);
        Windows.add(back3);
        others.setLayout(null);
        others.setBorder(new EmptyBorder(5, 5, 5, 5));
        others.add(othersChoose);
        others.add(imageFileDirectory);
        others.add(selectFile);
        others.add(back4);
        others.add(next);
        downloadImage.setLayout(null);
        downloadImage.setBorder(new EmptyBorder(5, 5, 5, 5));
        downloadImage.add(jProgressBar);
        ApplicationPanel.setLayout(null);
        ApplicationPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        ApplicationPanel.setLayout(layout);
        ApplicationPanel.add(welcome,"1");
        ApplicationPanel.add(macOS,"2");
        ApplicationPanel.add(Linux,"3");
        ApplicationPanel.add(Windows,"4");
        ApplicationPanel.add(others,"5");
        ApplicationPanel.add(writeImageToUSB,"6");
        ApplicationPanel.add(verifyUSB,"7");
        ApplicationPanel.add(finishedScreen,"8");
        ApplicationPanel.add(downloadImage,"9");
        ApplicationPanel.add(macOS11EULA,"10");
        ApplicationPanel.add(macOS12EULA,"11");
        layout.show(ApplicationPanel ,"10");
        menuBar.add(fileMenu);
        menuBar.add(downloadMenu);
        menuBar.add(help);
        menuBar.add(settingsMenu);
        frame.add(menuBar);
        frame.add(ApplicationPanel);
        frame.setSize(new Dimension(700,700));
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(600,600));
        //frame.pack();
        frame.setVisible(true);

    }

 private static int getFileSize(URL url) {
  URLConnection conn = null;
  try {
   conn = url.openConnection();
   if(conn instanceof HttpURLConnection) {
    ((HttpURLConnection)conn).setRequestMethod("HEAD");
   }
   conn.getInputStream();
   return conn.getContentLength();
  } catch (IOException e) {
   throw new RuntimeException(e);
  } finally {
   if(conn instanceof HttpURLConnection) {
    ((HttpURLConnection)conn).disconnect();
   }
  }
 }


    public static void writeImage(String filename, String usbDir) throws IOException {
        if(new File(filename).exists() && new File(usbDir).exists()) {
            Runtime.getRuntime().exec("dd ");
        }
    }
    public static void installApp(String packageFile) throws IOException {
        Runtime.getRuntime().exec("sudo installer -pkg " + Constants.appDatamacOS +"/" +packageFile+" -target CurrentUserHomeDirectory");
    }
}

