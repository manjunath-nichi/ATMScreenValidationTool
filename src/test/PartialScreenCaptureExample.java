package test;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
/**
 * This program demonstrates how to capture screenshot of a portion of screen.
 * @author www.codejava.net
 *
 */
public class PartialScreenCaptureExample {
 
    public static void main(String[] args) {
    	try {
            Robot robot;
			
				robot = new Robot();
			
            String format = "jpg";
            String fileName = "PartialScreenshot." + format;
             
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle captureRect = new Rectangle(0, 0, screenSize.width / 2, screenSize.height / 2);
            BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
            try {
				ImageIO.write(screenFullImage, format, new File(fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
            System.out.println("A partial screenshot saved!");
    	} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}