/*
 * ������BackgroundTree
 * ���ܣ�Ϊ����ʹ�����б������ӱ���ͼƬ����дJTree
 */
package ui.Share_bag;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;

import javax.swing.*;
import javax.swing.tree.*;

public class BackgroundTree extends JTree{
	private Image image = null;  
    public BackgroundTree(Image image,TreeNode root) {  
        this.image = image;  
    }  
    // �̶�����ͼƬ���������JPanel������ͼƬ������������  
    protected void paintComponent(Graphics g) {
    	 g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
    }  

}
