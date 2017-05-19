/*
 * ������BackgroundMenuBar jmb;//���ɲ˵�  
 * ���ܣ���д�˵���������ɫ����
 */
package ui.Share_bag;
import java.awt.*;

import javax.swing.*;
public class BackgroundMenuBar extends JMenuBar{
	Color bgColor=new Color(65,169,225); 
    public void setColor(Color color) 
    { 
        bgColor=color; 
    } 
    protected void paintComponent(Graphics g) 
    { 
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g; 
        g2d.setColor(bgColor); 
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1); 
    }
}
