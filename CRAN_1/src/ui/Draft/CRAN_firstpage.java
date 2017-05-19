package ui.Draft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import ui.CRAN_excel.Datashow;

public class CRAN_firstpage extends JFrame implements MouseListener,ActionListener{
	JMenuBar jmb;//���ɲ˵�
	JMenu jm1,jm2,jm3,jm4;//���粿����·���������Ż�����������
	JMenuItem jmi31,jmi32,jmi33,jmi34;//�μ��˵���
	JMenuItem jmi11,jmi12,jmi13,jmi14;//�μ��˵���
	JMenuItem jmi21,jmi22,jmi23;//�μ��˵���
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JPanel panel_1;
	private JPanel panel_1_1;
	private JSplitPane splitPane;
	private JPanel panel_2;
	private JPanel panel_3;
	
	private JLabel label;
	private JTree tree;
	private JPanel panel_4;
	private JTextField textField;
	private JButton button_3;
	
	DefaultMutableTreeNode node_second2_1,node_second2_2,node_second2_3,node_second2_4,node_second3_1,node_second3_2,node_second3_3,
	node_second4_1,node_second4_2,node_second4_3,node_second4_4,node_second4_5;
	JTree Treeroot=null;
	private JPanel panel_5;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRAN_firstpage frame = new CRAN_firstpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the frame.
	 */
	public CRAN_firstpage() {
//�˵���
		jmb=new JMenuBar();
		jm1=new JMenu("���粿��");
		jm2=new JMenu("��·����");
		jm3=new JMenu("�����Ż�");
		jm4=new JMenu("��������");
		
		jmi11=new JMenuItem("BBU");
		jmi11.addActionListener(this);//��Ӽ���
		jmi12=new JMenuItem("RRU");
		jmi13=new JMenuItem("UE");
		jmi14=new JMenuItem("�����ļ�����");
		jmi21=new JMenuItem("BBU-BBU");
		jmi22=new JMenuItem("BBU-RRU");
		jmi23=new JMenuItem("RRU-UE");
		jmi31=new JMenuItem("���ӹ滮(P)");
		jmi31.setMnemonic('P');
		jmi32=new JMenuItem("���ؾ���(B)");
		jmi32.setMnemonic('B');
		jmi33=new JMenuItem("��������(M)");
		jmi33.setMnemonic('M');
		jmi34=new JMenuItem("���ܲ���(S)");
		jmi34.setMnemonic('S');
		//���˵�ϵ����ӵ��˵���
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jm1.add(jmi11);
		jm1.add(jmi12);
		jm1.add(jmi13);
		jm1.add(jmi14);
		jm2.add(jmi21);
		jm2.add(jmi22);
		jm2.add(jmi23);
		jm3.add(jmi31);
		jm3.add(jmi32);
		jm3.add(jmi33);
		jm3.add(jmi34);
		//���˵�����ӵ�������
		this.setJMenuBar(jmb);
		
		panel = new JPanel();
		jmb.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		button = new JButton("�˺Ź���");
		panel.add(button);
		
		button_1 = new JButton("�û�����");
		panel.add(button_1);
		
		button_2 = new JButton("�˳�");
		panel.add(button_2);
//���ô�������
		this.setTitle("CRAN����ʵ��ƽ̨");
		this.setSize(1219, 603);//�����С
		this.setLocation(100, 100);//����λ��
	    //��ֹ�û��ı䴰���С
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
//����	
//����
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
//����
		panel_1_1= new JPanel();
		getContentPane().add(panel_1_1, BorderLayout.SOUTH);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		button_9 = new JButton("  ˢ��  ");
		panel_1_1.add(button_9);
		
		button_4 = new JButton("BBU������·��ϵ");
		panel_1_1.add(button_4);
		
		button_5 = new JButton("RRU������·��ϵ");
		panel_1_1.add(button_5);
		
		button_6 = new JButton("�����ļ�����");
		panel_1_1.add(button_6);
		
		button_7 = new JButton("\u53C2\u6570\u6587\u4EF6\u5BFC\u51FA");
		panel_1_1.add(button_7);
		
		button_8 = new JButton("\u62D3\u6251\u53C2\u6570\u4FDD\u5B58");
		panel_1_1.add(button_8);
		
		splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
//����		
		panel_2 = new JPanel();
		splitPane.setLeftComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(2,1, 0, 0));
		
		label = new JLabel("������Դ");//������Դ
		label.setFont(new Font("����", Font.BOLD, 30));
		panel_3.add(label);
		
		panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(30);
		
		button_3 = new JButton("\u641C\u7D22");
		panel_4.add(button_3);
		
		/*tree_1 = new JTree();
		panel_2.add(tree_1, BorderLayout.CENTER);*/
		//�����б�
		//���ڵ�
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("���ڵ�");
		//һ���ڵ�
		DefaultMutableTreeNode node_first1 = new DefaultMutableTreeNode("����BBU������");
		DefaultMutableTreeNode node_first2 = new DefaultMutableTreeNode("��Ԫ�б�");  
		DefaultMutableTreeNode node_first3 = new DefaultMutableTreeNode("��·��ϵ");
		DefaultMutableTreeNode node_first4 = new DefaultMutableTreeNode("��Դ���б�");  
		 //�����ڵ�
		node_second2_1 = new DefaultMutableTreeNode("BBU",false); 
		node_second2_2 = new DefaultMutableTreeNode("RRU����",false);  
		node_second2_3= new DefaultMutableTreeNode("UE",false);
		node_second2_4 = new DefaultMutableTreeNode("�û�״̬��ѯ/�޸�",false);  
		
		node_second3_1 = new DefaultMutableTreeNode("BBU-BBU��·����",false); 
		node_second3_2 = new DefaultMutableTreeNode("BBU-RRU��·����",false);  
		node_second3_3= new DefaultMutableTreeNode("RRU-UE��·����",false);
		
		node_second4_1 = new DefaultMutableTreeNode("�ŵ�ģ��",false); 
		node_second4_2 = new DefaultMutableTreeNode("��·����ģ��",false);  
		node_second4_3= new DefaultMutableTreeNode("�ƶ���ģ��",false);
		node_second4_4 = new DefaultMutableTreeNode("ҵ����ģ��",false);  
		node_second4_5 = new DefaultMutableTreeNode("��Ƶ��Դģ��",false); 
		//�����֦
		root.add(node_first1);
		root.add(node_first2);
		root.add(node_first3);
		root.add(node_first4);
		
		node_first2.add(node_second2_1);
		node_first2.add(node_second2_2);
		node_first2.add(node_second2_3);
		node_first2.add(node_second2_4);
		node_first3.add(node_second3_1);
		node_first3.add(node_second3_2);
		node_first3.add(node_second3_3);
		node_first4.add(node_second4_1);
		node_first4.add(node_second4_2);
		node_first4.add(node_second4_3);
		node_first4.add(node_second4_4);
		node_first4.add(node_second4_5);
		//���ø��ڵ�ֱ�Ӵ�����Treeroot
		Treeroot=new JTree(root);
		Treeroot.addMouseListener(this);;
		panel_2.add(Treeroot, BorderLayout.CENTER);
		//������
		Treeroot.setRootVisible(false);//�޸��ڵ�
		Treeroot.setRowHeight(20);//���ڵ���и�
		DefaultTreeCellRenderer treeCellRenderer=new DefaultTreeCellRenderer();//������ڵ�Ļ��ƶ���
		treeCellRenderer=(DefaultTreeCellRenderer)Treeroot.getCellRenderer();
		treeCellRenderer.setLeafIcon(null);
		treeCellRenderer.setClosedIcon(null);
		treeCellRenderer.setOpenIcon(null);
		Treeroot.setFont(new Font("����", Font.PLAIN, 17));
		
		//panel_5 = new JPanel();
//�ұߣ���ͼ		
		First_panel fpaint=new First_panel();
		//tuoputu tuopu_panel=new tuoputu();
		splitPane.setRightComponent(fpaint);
		
		
		
		
		

	}
	

// ActionListener�ķ���
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		if(arg0.getSource()==jmi11)
		{
			
		}
		
	}


	@Override//�����
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)Treeroot.getLastSelectedPathComponent();	
		 if(e.getClickCount()==2)
		 { //���˫���¼�
			 
			 if(selectionNode.equals(node_second2_3)){ //Ҷ�ӽڵ�ļ���
			    System.out.println("ok");
			    Datashow sa=new Datashow(this, "UE����", true);//�ǵö�jb2ע�������TRUE ģʽ�Ի���
			   }
			  }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

}

class First_panel extends JPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		setBackground(Color.white);
		g.drawOval(100, 100, 20, 20);
	}
}
