package source.waveUSB;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Settings {
    static BufferedWriter writer;
    JFrame frame = new JFrame("Settings");
    JPopupMenu wallpaperMenu = new JPopupMenu();
    JButton save = new JButton("Save Settings");
    static {
        try {
            writer = new BufferedWriter(new FileWriter(".settings"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Settings() throws IOException {
    }

    public static void main(String[] args) throws IOException {

        writer.write("bg=");
        writer.close();
    }
}
