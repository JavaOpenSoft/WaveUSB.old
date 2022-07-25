package javaPack.waveUSB;

public class SoftwareInfo {
    String version = "0.1 GUI Staging";
    String About = "GUI Edition of WaveUSB, A complete USB writer designed mostly in Java.";
    public String getVersion() {
        return this.version;
    }
    public String getAbout()
    {
        return this.About;
    }
    public static String getOS(){
        return System.getProperty("os.name");
    }
    public static String getOSVersion(){
        return System.getProperty("os.version");
    }

}
