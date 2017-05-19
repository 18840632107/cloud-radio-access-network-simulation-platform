/*
 * ������TreeNodeRenderer
 * ���ܣ���չSubstanceDefaultTreeCellRenderer�����Լ������ڵ���Ⱦ��
 */
package ui.Share_bag;

import java.awt.Component;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.pushingpixels.substance.api.renderers.SubstanceDefaultTreeCellRenderer;

public class TreeNodeRenderer extends SubstanceDefaultTreeCellRenderer{
    private static final long serialVersionUID = 8532405600839140757L;
    
//    // ������D��,플ӹ��c��
//    private static final Icon databaseIcon = new ImageIcon(TreeNodeRenderer.class
//            .getResource("/database.gif"));
    
    // ��D��,�����ӹ��c��
    private static final Icon tableIcon = new ImageIcon(TreeNodeRenderer.class
            .getResource("image"+File.separator +"LeafIcon.png"));
    
    // ����g�P�]��B�D��,�P�]��B�ĵڶ��ӹ��c��
    private static final Icon tableSpaceCloseIcon = new ImageIcon(TreeNodeRenderer.class
            .getResource("image"+File.separator +"ClosedIcon.png"));
    
    // ����g�P�]��B�D��,���_��B�ĵڶ��ӹ��c��
    private static final Icon tableSpaceOpenIcon = new ImageIcon(TreeNodeRenderer.class
            .getResource("image"+File.separator +"OpenIcon.png"));
    
    public Component getTreeCellRendererComponent(JTree tree,
                                                  Object value,
                                                  boolean sel,
                                                  boolean expanded,
                                                  boolean leaf,
                                                  int row,
                                                  boolean hasFocus){
         super.getTreeCellRendererComponent(tree,   
                                            value,
                                            sel,   
                                            expanded,   
                                            leaf,   
                                            row,   
                                            hasFocus);   
        // ȡ�ù��c
        DefaultMutableTreeNode node=(DefaultMutableTreeNode)value;
        
        // ȡ��·��
        TreeNode[] paths = node.getPath();
        
        // ��·����θ��費ͬ��ͼ��
        if (paths.length == 3) {            
            setIcon(tableIcon);
        }else if(paths.length == 2){
            // ��չ�_��r���x�費ͬ�ĈD��
            if(expanded){
                setIcon(tableSpaceOpenIcon);
            }
            else{
                setIcon(tableSpaceCloseIcon);
            }
        }
//        else if(paths.length == 1){
//            setIcon(databaseIcon);
//        }
        
        return this;        
    }
}
