package com.nichi.view;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.nichi.util.FileOperations;
import com.nichi.util.LoggerClass;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageSlider extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
	int l1;
	JButton FDK1;
	JButton FDK2;
	JButton FDK3;
	JButton FDK4;
	JButton FDK5;
	JButton FDK6;
	JButton FDK7;
	JButton FDK8;

	public void createScreen() throws Exception {

		// Create frame with ATM slandered size
		setLayout(new BorderLayout());
		setSize(FileOperations.PANEL_WIDTH, FileOperations.PANEL_HEIGHT);

		// set it to full screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);

		// Add a label
		label = new JLabel("", JLabel.LEFT);
		add(label, BorderLayout.WEST);
		setState(ImageSlider.ICONIFIED);

		// Start of showing TouchArea function
		LoggerClass.logInfo("Start of showing TouchArea function");
		markTouchArea();
		LoggerClass.logInfo("End of showing TouchArea function ");
		// End of showing TouchArea function

		// Start sliding images
		LoggerClass.logInfo("Start sliding images ");
		slideImages();
		LoggerClass.logInfo("End of sliding images ");
		// Start sliding images

		// End of process and show final dialog with confirmation message
		LoggerClass.logInfo("End of process and show final dialog with confirmation message ");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JOptionPane.showMessageDialog(this, "Process Completed !");
		setVisible(false);
		dispose();
		LoggerClass.logInfo("END !");
		System.exit(0);

	}

	private void markTouchArea() throws Exception {

		FDK1 = new JButton("");
		FDK1.setContentAreaFilled(false);
		FDK1.setBounds(FileOperations.BTNFDK1keyLEFT, FileOperations.BTNFDK1keyTOP, FileOperations.BTN_WIDTH,
				FileOperations.BTN_HEIGHT);
		label.add(FDK1);

		FDK2 = new JButton("");
		FDK2.setContentAreaFilled(false);
		FDK2.setBounds(FileOperations.BTNFDK2keyLEFT, FileOperations.BTNFDK2keyTOP, FileOperations.BTN_WIDTH,
				FileOperations.BTN_HEIGHT);
		label.add(FDK2);

		FDK3 = new JButton("");
		FDK3.setContentAreaFilled(false);
		FDK3.setBounds(FileOperations.BTNFDK3keyLEFT, FileOperations.BTNFDK3keyTOP, FileOperations.BTN_WIDTH,
				FileOperations.BTN_HEIGHT);
		label.add(FDK3);

		FDK4 = new JButton("");
		FDK4.setContentAreaFilled(false);
		FDK4.setBounds(FileOperations.BTNFDK4keyLEFT, FileOperations.BTNFDK4keyTOP, FileOperations.BTN_WIDTH,
				FileOperations.BTN_HEIGHT);
		label.add(FDK4);

		FDK5 = new JButton("");
		FDK5.setContentAreaFilled(false);
		FDK5.setBounds(FileOperations.BTNFDK5keyLEFT, FileOperations.BTNFDK5keyTOP, FileOperations.BTN_WIDTH,
				FileOperations.BTN_HEIGHT);
		label.add(FDK5);

		FDK6 = new JButton("");
		FDK6.setContentAreaFilled(false);
		FDK6.setBounds(FileOperations.BTNFDK6keyLEFT, FileOperations.BTNFDK6keyTOP, FileOperations.BTN_WIDTH,
				FileOperations.BTN_HEIGHT);
		label.add(FDK6);

		FDK7 = new JButton("");
		FDK7.setContentAreaFilled(false);
		FDK7.setBounds(FileOperations.BTNFDK7keyLEFT, FileOperations.BTNFDK7keyTOP, FileOperations.BTN_WIDTH,
				FileOperations.BTN_HEIGHT);
		label.add(FDK7);

		FDK8 = new JButton("");
		FDK8.setContentAreaFilled(false);
		FDK8.setBounds(FileOperations.BTNFDK8keyLEFT, FileOperations.BTNFDK8keyTOP, FileOperations.BTN_WIDTH,
				FileOperations.BTN_HEIGHT);
		label.add(FDK8);

		setButtonBorder();
	}

	private void setButtonBorder() {
		FDK1.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
		FDK2.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
		FDK3.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
		FDK4.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
		FDK5.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
		FDK6.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
		FDK7.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
		FDK8.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
	}

	private void slideImages() throws Exception {
		// Start Listing images from path
		LoggerClass.logInfo("Start Listing images from path:" + FileOperations.IMAGEFOLDERPATH);
		File f = new File(FileOperations.IMAGEFOLDERPATH);
		// check for folder existence
		if (!f.exists()) {
			throw new Exception(FileOperations.IMAGEFOLDERPATH + "-> path not found");
		}
		String[] imageNames = f.list();
		// check image file presence 
		if (imageNames.length <= 0) {
			throw new Exception("No file found at -> " + FileOperations.IMAGEFOLDERPATH );
		}
		LoggerClass.logInfo("End Listing images from path:" + FileOperations.IMAGEFOLDERPATH);
		// End Listing images from path
		
		// Start validating each image
		LoggerClass.logInfo("Start validating each image");
		for (String pathname : imageNames) {
			String fileFullPath = FileOperations.IMAGEFOLDERPATH + "\\" + pathname;

			LoggerClass.logInfo("Set as backgound image :" + fileFullPath);
			label.setIcon(new ImageIcon(new ImageIcon(fileFullPath).getImage()
					.getScaledInstance(FileOperations.PANEL_WIDTH, FileOperations.PANEL_HEIGHT, Image.SCALE_DEFAULT)));

			// Add sleep to avoid systemimpact
			Thread.sleep(500);

			// Take screenshot
			LoggerClass.logInfo("Start taking screenshot for :" + fileFullPath);
			String format = "jpg";

			
			String fileName = FileOperations.OUTPUTPATH + "\\TestResult_" + pathname;

			BufferedImage image = new BufferedImage(FileOperations.PANEL_WIDTH, FileOperations.PANEL_HEIGHT,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = image.createGraphics();
			label.paint(graphics2D);

			ImageIO.write(image, format, new File(fileName));
			LoggerClass.logInfo("End taking screenshot for :" + fileFullPath);

			// Add sleep to avoid systemimpact
			Thread.sleep(100);

		}

		LoggerClass.logInfo("End of validating ");
		// End of validating
	}

	protected void paintComponent(Graphics g) {
		g.drawRect(0, 0, FileOperations.PANEL_WIDTH, FileOperations.PANEL_HEIGHT);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}