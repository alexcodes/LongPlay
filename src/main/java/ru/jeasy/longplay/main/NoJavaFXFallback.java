package ru.jeasy.longplay.main;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.net.URL;

public class NoJavaFXFallback extends JApplet
        implements ActionListener
{
    boolean isInBrowser = false;
    boolean oldJRE = true;
    String requiredJavaFXVersion = null;
    boolean oldJavaFX = false;
    boolean doNotUseJNLPAPI = false;

    public NoJavaFXFallback()
    {
    }

    public NoJavaFXFallback(boolean needJREUpgrade, boolean needFXUpgrade, String requiredJavaFX) {
        this.isInBrowser = false;
        this.oldJavaFX = needFXUpgrade;
        this.requiredJavaFXVersion = requiredJavaFX;
        this.oldJRE = needJREUpgrade;
        this.doNotUseJNLPAPI = true;

        populate();
    }

    private static float getJavaVersionAsFloat() {
        String versionString = System.getProperty("java.version", "1.5.0");

        StringBuffer sb = new StringBuffer();

        int firstDot = versionString.indexOf(".");
        sb.append(versionString.substring(0, firstDot));

        int secondDot = versionString.indexOf(".", firstDot + 1);
        sb.append(versionString.substring(firstDot + 1, secondDot));

        int underscore = versionString.indexOf("_", secondDot + 1);
        if (underscore >= 0) {
            int dash = versionString.indexOf("-", underscore + 1);
            if (dash < 0) {
                dash = versionString.length();
            }
            sb.append(versionString.substring(secondDot + 1, underscore)).append(".").append(versionString.substring(underscore + 1, dash));
        }
        else
        {
            int dash = versionString.indexOf("-", secondDot + 1);
            if (dash < 0) {
                dash = versionString.length();
            }
            sb.append(versionString.substring(secondDot + 1, dash));
        }

        float version = 150.0F;
        try {
            version = Float.parseFloat(sb.toString());
        } catch (NumberFormatException e) {
        }
        return version;
    }

    private void test() {
        this.oldJRE = (getJavaVersionAsFloat() < 160.17999F);
        try
        {
            Class jclass = Class.forName("netscape.javascript.JSObject");
            Method m = jclass.getMethod("getWindow", new Class[] { Applet.class });
            this.isInBrowser = (m.invoke(null, new Object[] { this }) != null); } catch (Exception e) {
        }
    }

    String getText() {
        String text = "This application requires a newer version of the Java runtime. Please download and install the latest Java runtime from java.com.";

        if (this.isInBrowser)
            text = text + " Then restart the browser.";
        else {
            text = text + " Then restart the application.";
        }
        return text;
    }

    public void init()
    {
        this.requiredJavaFXVersion = getParameter("requiredFXVersion");
        test();
        populate();
    }

    private void populate() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        JTextPane l = new JTextPane();
        l.setText(getText());
        l.setEditable(false);

        pane.add(l, "Center");

        if ((getJavaVersionAsFloat() > 160.0F) || ((getJavaVersionAsFloat() > 150.0F) && (!this.doNotUseJNLPAPI)))
        {
            JButton installButton = new JButton("Install Now");
            installButton.addActionListener(this);
            pane.add(installButton, "South");
        }
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            URL u = new URL("http://java.com/");
            if (this.isInBrowser) {
                getAppletContext().showDocument(u);
            }
            else if (!this.doNotUseJNLPAPI) {
                Class sm = Class.forName("javax.jnlp.ServiceManager");
                Class bs = Class.forName("javax.jnlp.BasicService");
                Method lookup = sm.getMethod("lookup", new Class[] { String.class });

                Method showDoc = bs.getMethod("showDocument", new Class[] { URL.class });

                Object s = lookup.invoke(null, new Object[] { "javax.jnlp.BasicService" });

                showDoc.invoke(s, new Object[] { u });
            }
            else {
                Desktop d = Desktop.getDesktop();
                if (d != null)
                    d.browse(u.toURI());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}