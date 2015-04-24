/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package buffchecker;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author David
 */
public class BuffChecker {

    /**
     * @param args the command line arguments
     * @throws java.awt.AWTException
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws AWTException, FileNotFoundException, UnsupportedEncodingException, IOException {
        String x = null, y = null, path = null, pathPow = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("settings.txt"));
            x = br.readLine();
            y = br.readLine();
            path = br.readLine();
            pathPow = br.readLine();
            
        } catch(IOException e) {}
        GUI user;
        if (path == null) {
            File examp = new File("./audios/coin.wav");
            if (examp.exists()) {
                path = examp.getAbsolutePath();
            }
        }
        if (pathPow == null) {
            File examp = new File("./audios/message.wav");
            if (examp.exists()) {
                pathPow = examp.getAbsolutePath();
            }
        }
        if (x != null && y != null && path != null) user = new GUI(x, y, path, pathPow);
        else if (pathPow != null && path != null) user = new GUI(path, pathPow);
        else user = new GUI();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        user.setLocation(dim.width/2-user.getSize().width/2, dim.height/2-user.getSize().height/2);
        user.setVisible(true);
        //getBuffMatrix();
    }
    
    /*private static void getBuffMatrix() throws AWTException, FileNotFoundException, UnsupportedEncodingException {
        Robot robot = new Robot();
        String r = "", g = "", b = "";
        for (int i = 0; i < 25; ++i) {
            r += "{";
            g += "{";
            b += "{";
            for (int j = 0; j < 25; ++j) {
                Color a = robot.getPixelColor(395+i, 680+j);
                r += a.getRed();
                if (j < 24) r += ", ";
                g += a.getGreen();
                if (j < 24) g += ", ";
                b += a.getBlue();
                if (j < 24) b += ", ";
            }
            if (i < 24) {
                r += "},";
                g += "},";
                b += "},";
            }
            else {
                r += "}";
                g += "}";
                b += "}";
            }
        }
        System.out.println(r);
        System.out.println(g);
        System.out.println(b);
    }*/
}
