/*
 * ������BackgroundPanel
 * ���ܣ�Ϊ�˼��ر���ͼƬ����дJPanel
 */
package ui.Share_bag;

import java.awt.*;

import javax.swing.*;

public class BackgroundPanel extends JPanel {
	    private Image image = null;  
	    public BackgroundPanel(Image image) {  
	        this.image = image;  
	    }  
	  
	    // �̶�����ͼƬ���������JPanel������ͼƬ������������  
	    protected void paintComponent(Graphics g) {  
	        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
	    }  

}
