package waveUSB;

import waveUSB.Core.SoftwareInfo;

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
    static JPanel macOSEULA = new JPanel();
    static JLabel macOSChoose = new JLabel("Choose your macOS Version:");
    static JLabel chooseOS = new JLabel("To start, choose your operating system installer you want to write to your USB:");
    static JLabel welcomeLabel = new JLabel("Welcome!");
    static JLabel linuxChoose = new JLabel("Please choose your linux Installer:");
    static JLabel othersChoose = new JLabel("Please choose an image file:");
    static JLabel timeLeftLabel = new JLabel();
    static JLabel windowsChose = new JLabel("Chose your Windows Version");
    static JTextField imageFileDirectory = new JTextField("Enter the file path or select a file..");
    static JTextField usbDirectory = new JTextField("Enter or Choose the USB path..");
    static JTextArea jTextArea = new JTextArea();
    static JLabel percentLabel = new JLabel();
    static JInternalFrame jInternalFrame = new JInternalFrame();
    static JProgressBar jProgressBar = new JProgressBar();
    static JScrollPane jScrollPane = new JScrollPane();
    static JScrollBar jScrollBar = new JScrollBar();
    static CardLayout layout = new CardLayout();

    static JMenuBar menuBar = new JMenuBar();
    static JMenu fileMenu = new JMenu("File");
    static JMenu help = new JMenu("help");
    static JMenu downloadMenu = new JMenu("Download");
    static JMenu settingsMenu = new JMenu("Settings");
    //Buttons
    static JButton macOS_1015 = new JButton("macOS 10.15 (Codenamed Catalina)",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Catalina_Icons/Catalina_32x32x32.png"));
    static JButton macOS_1014 = new JButton("macOS 10.14 (Codenamed Mojave)",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Mojave_Icons/Mojave_32x32x32.png"));
    static JButton macOS_1013 = new JButton("macOS 10.13(Codenamed High Sierra)",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/HighSierra_Icons/HighSierra_32x32x32.png"));
    static JButton macOS_12 = new JButton("macOS 12.5(Codenamed Monterey)",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Monterey_Icon/Monterey_32x32x32.png"));
    static JButton macOS_11 = new JButton("macOS 11.6.8(Codenamed Big Sur)",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/BigSur_Icons/BigSur_32x32x32.png"));
    static JButton quitButton = new JButton("Quit");
    static JButton selectFile = new JButton("Select a Image File");
    static JButton macOSButton = new JButton("macOS",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Systems-Mac-Os-icon.png"));
    static JButton windowsButton = new JButton("Windows", new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/windows-8-icon.png"));
    static JButton linuxButton = new JButton("Linux",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/OS-Linux-icon.png"));
    static JButton otherButton = new JButton("Other..");
    static JButton ubuntu = new JButton("Ubuntu 22.04(Codenamed Jammy Jellyfish)",  new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/ubuntu.png"));
    static JButton debian = new JButton("Debian 11-32 bit(Codenamed Bullseye)",  new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/debian.png"));
    static JButton debian64 = new JButton("Debian 11 64-bit (Codenamed Bullseye)",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/debian.png"));
    static JButton debianNet64 = new JButton("Debian 11 64-bit Network Installer(Codenamed Bullseye)",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/debian.png"));
    static JButton debianNet = new JButton("Debian 11 32-bit Network Installer(Codenamed Bullseye)",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/debian.png"));
    static JButton ubuntuServer = new JButton("Ubuntu Server 22.04(Codenamed Jammy Jellyfish)",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/ubuntu.png"));
    static JButton Arch = new JButton("Arch 2022.07.01 64-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/arch.png"));
    static JButton fedoraWorkspace = new JButton("Fedora Workstation 36 32-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/fedora.png"));
    static JButton fedoraWorkspace64 = new JButton("Fedora Workstation 36 64-bit", new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/fedora.png"));
    static JButton fedoraServer = new JButton("Fedora Server 36 32-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/fedora.png"));
    static JButton fedoraServer_ARM = new JButton("Fedora Server ARM 64-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/fedora.png"));
    static JButton fedoraServerNet64 = new JButton("Fedora Server Net 64-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/fedora.png"));
    static JButton fedoraServerNet_ARM = new JButton("Fedora Server Net ARM 64-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/fedora.png"));
    static JButton deepin = new JButton("Deepin OS 20.6",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/deepin.png"));
    static JButton ManjaroGnome = new JButton("Manjaro Gnome Edition",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/manjaro.png"));
    static JButton ManjaroXFCE = new JButton("Manjaro XFCE Edition",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/manjaro.png"));
    static JButton ManjaroKDE = new JButton("Manjaro KDE Edition",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/manjaro.png"));
    static JButton LinuxMintEdge = new JButton("Linux Mint Edge Edition Version 20.3",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/linux-mint.png"));
    static JButton LinuxMintCinnamon = new JButton("Linux Mint Cinnamon Version 20.3",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/linux-mint.png"));
    static JButton LinuxMintMate = new JButton("Linux Mint MATE Edition Version 20.3",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/linux-mint.png"));
    static JButton LinuxMintXfce = new JButton("Linux Mint Xfce Edition Version 20.3",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/linux-mint.png"));
    static JButton elementaryOS = new JButton("Elementary OS Version 6.1",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/ElementaryOS.png"));
    static JButton solusGnome = new JButton("Solus Gnome Edition Version 4.3",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/Solus.png"));
    static JButton solusBudgie = new JButton("Solus Budgie Edition Version 4.3",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/Solus.png"));
    static JButton solusMATE = new JButton("Solus MATE Edition Version 4.3",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/Solus.png"));
    static JButton solusKDE = new JButton("Solus KDE Edition Version 4.3",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/Solus.png"));
    static JButton blackArch = new JButton("Black Arch Version 2021.09.1 64-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/blackarch.png"));
    static JButton blackArchMinimum = new JButton("Black Arch Minimum Edition Version 2021.09.1 64-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/blackarch.png"));
    static JButton blackArchNet = new JButton("Black Arch Network Installer Version 2021.09.1 64-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Linux_Icons/blackarch.png"));
    static JButton Windows8 = new JButton("Windows 8 32-bit",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Windows_Icons/win8_and_10.png"));
    static JButton Windows8_64 = new JButton("Windows 8 64-bit", new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Windows_Icons/win8_and_10.png"));
    static JButton Windows10 = new JButton("Windows 10 32-bit", new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Windows_Icons/win8_and_10.png"));
    static JButton Windows10_64 = new JButton("Windows 10 64-bit", new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Windows_Icons/win8_and_10.png"));
    static JButton Windows11 = new JButton("Windows 11",new ImageIcon("/Users/rishonrishon/IdeaProjects/WaveUSB/src/resources/images/Windows_Icons/win11.png"));
    static JButton next = new JButton("Next");
    static JButton back = new JButton("Back");
    static JButton back2 = new JButton("Back");
    static JButton back3 = new JButton("Back");
    static JButton back4 = new JButton("Back");
    static JButton back5 = new JButton("Back");
    static JButton back6 = new JButton("Back");
    static JButton back7 = new JButton("Back");
    static JButton back8 = new JButton("Back");
    static JButton proceed = new JButton("Next");
    static JFileChooser jFileChooser = new JFileChooser();
    static JFileChooser chooseUSB = new JFileChooser();
    static JButton USB = new JButton("Select USB");
    //Image File
    static File image ;
    String os = SoftwareInfo.getOS();
    public static void main(String[] args){
        frame.setLocationRelativeTo(null);
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
                frame.setSize(new Dimension(650,400));
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
                frame.setSize(790, 900);
                layout.show(ApplicationPanel, "3");
                frame.setLocationRelativeTo(null);
            }
        });
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        proceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        macOS_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        welcomeLabel.setFont(new Font("SansSerif", Font.PLAIN,20));
        macOSChoose.setFont(new Font("SansSerif", Font.PLAIN, 20));
        welcome.setLayout(null);
        welcome.setBorder(new EmptyBorder(5, 5, 5, 5));
        welcomeLabel.setBounds(250,0,500,30);
        welcome.add(welcomeLabel);
        chooseOS.setBounds(100,40,500,30);
        welcome.add(chooseOS);
        macOSButton.setBounds(250,100,100,50);
        welcome.add(macOSButton);
        windowsButton.setBounds(250,150,100,50);
        welcome.add(windowsButton);
        linuxButton.setBounds(250,200,100,50);
        welcome.add(linuxButton);
        otherButton.setBounds(250,250,100,50);
        welcome.add(otherButton);
        quitButton.setBounds(30,300,100,30);
        welcome.add(quitButton);
        macOS.setLayout(null);
        macOS.setBorder(new EmptyBorder(5, 5, 5, 5));
        macOSChoose.setBounds(250,0,500,30);
        macOS.add(macOSChoose);
        macOS_11.setBounds(150,40,400,50);
        macOS.add(macOS_11);
        macOS_12.setBounds(150,90,400,50);
        macOS.add(macOS_12);
        macOS_1015.setBounds(150,140,400,50);
        macOS.add(macOS_1015);
        macOS_1014.setBounds(150,190,400,50);
        macOS.add(macOS_1014);
        macOS_1013.setBounds(150,240,400,50);
        macOS.add(macOS_1013);
        back.setBounds(30,310,100,30);
        macOS.add(back);
        Linux.setLayout(null);
        Linux.setBorder(new EmptyBorder(5, 5, 5, 5));
        linuxChoose.setBounds(225,0,400,30);
        Linux.add(linuxChoose);
        ubuntu.setBounds(225,30,200,50);
        Linux.add(ubuntu);
        ubuntuServer.setBounds(225,80,200,50);
        Linux.add(ubuntuServer);
        debian.setBounds(225,130,200,50);
        Linux.add(debian);
        debian64.setBounds(225,180,200,50);
        Linux.add(debian64);
        debianNet.setBounds(225,230,200,50);
        Linux.add(debianNet);
        debianNet64.setBounds(225,280,200,50);
        Linux.add(debianNet64);
        Arch.setBounds(225,330,200,50);
        Linux.add(Arch);
        fedoraWorkspace.setBounds(225,380,200,50);
        Linux.add(fedoraWorkspace);
        fedoraWorkspace64.setBounds(225,430,200,50);
        Linux.add(fedoraWorkspace64);
        fedoraServer.setBounds(225,480,200,50);
        Linux.add(fedoraServer);
        fedoraServer_ARM.setBounds(225,530,200,50);
        Linux.add(fedoraServer_ARM);
        fedoraServerNet64.setBounds(225,580,200,50);
        Linux.add(fedoraServerNet64);
        fedoraServerNet_ARM.setBounds(225,630,200,50);
        Linux.add(fedoraServerNet_ARM);
        deepin.setBounds(425,30,200,50);
        Linux.add(deepin);
        ManjaroGnome.setBounds(425,80,200,50);
        Linux.add(ManjaroGnome);
        ManjaroKDE.setBounds(425,130,200,50);
        Linux.add(ManjaroKDE);
        ManjaroXFCE.setBounds(425,180,200,50);
        Linux.add(ManjaroXFCE);
        LinuxMintCinnamon.setBounds(425,230,200,50);
        Linux.add(LinuxMintCinnamon);
        LinuxMintEdge.setBounds(425,280,200,50);
        Linux.add(LinuxMintEdge);
        LinuxMintMate.setBounds(425,330,200,50);
        Linux.add(LinuxMintMate);
        LinuxMintXfce.setBounds(425,380,200,50);
        Linux.add(LinuxMintXfce);
        elementaryOS.setBounds(425,430,200,50);
        Linux.add(elementaryOS);
        solusGnome.setBounds(425,480,200,50);
        Linux.add(solusGnome);
        solusBudgie.setBounds(425,530,200,50);
        Linux.add(solusBudgie);
        solusKDE.setBounds(425,580,200,50);
        Linux.add(solusKDE);
        solusMATE.setBounds(425,630,200,50);
        Linux.add(solusMATE);
        blackArch.setBounds(225,680,200,50);
        Linux.add(blackArch);
        blackArchMinimum.setBounds(425,680,200,50);
        Linux.add(blackArchMinimum);
        blackArchNet.setBounds(225,730,400,50);
        Linux.add(blackArchNet);
        back2.setBounds(20,800,100,30);
        Linux.add(back2);
        Windows.setLayout(null);
        Windows.setBorder(new EmptyBorder(5, 5, 5, 5));
        windowsChose.setBounds(225,0,300,30);
        Windows.add(windowsChose);
        Windows8.setBounds(225,30,200,50);
        Windows.add(Windows8);
        Windows8_64.setBounds(225,80,200,50);
        Windows.add(Windows8_64);
        Windows10.setBounds(225,130,200,50);
        Windows.add(Windows10);
        Windows10_64.setBounds(225,180,200,50);
        Windows.add(Windows10_64);
        Windows11.setBounds(225,230,200,50);
        Windows.add(Windows11);
        back3.setBounds(30,320,75,30);
        Windows.add(back3);
        others.setLayout(null);
        others.setBorder(new EmptyBorder(5, 5, 5, 5));
        othersChoose.setBounds(225,0,500,30);
        others.add(othersChoose);
        imageFileDirectory.setBounds(125,100,250,40);
        others.add(imageFileDirectory);
        selectFile.setBounds(450,100,150,30);
        others.add(selectFile);
        proceed.setBounds(450,300,150,30);
        others.add(proceed);
        back4.setBounds(30,300,100,30);
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
        ApplicationPanel.add(macOSEULA,"10");
        layout.show(ApplicationPanel ,"1");
        menuBar.add(fileMenu);
        menuBar.add(downloadMenu);
        menuBar.add(help);
        menuBar.add(settingsMenu);
        frame.add(menuBar);
        frame.add(ApplicationPanel);
        frame.setSize(new Dimension(650,400));
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(650,400));
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
        if(new File(filename).exists() && new File(usbDir).exists()
        ) {
            Runtime.getRuntime().exec("dd if="+filename+" of="+usbDir+" bs=1M status=progress");
        }
    }
    //Only for macOS users
    public static void installApp(String packageFile) throws IOException {
        Runtime.getRuntime().exec("sudo installer -pkg " + Constants.appDatamacOS +"/" +packageFile+" -target CurrentUserHomeDirectory");
    }
}

