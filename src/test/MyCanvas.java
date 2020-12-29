package test;

import java.awt.*;  
import javax.swing.JFrame;  
  
public class MyCanvas extends Canvas{  
      
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("D:\\OKI_Project\\ATM\\ATMScreenTestingTool\\input\\image\\bad_notes.jpg");  
        g.drawImage(i, 120,100,this);  
          
    }  
        public static void main(String[] args) {  
        MyCanvas m=new MyCanvas();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(400,400);  
        f.setVisible(true);  
    }  
  
}  