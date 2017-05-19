/*
 * ������tuoputu
 * ���ܣ������˽���
 */
package ui.CRAN1;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import map.network.*;
import ui.CRAN1.Output;
import ui.Draft.CRAN_drawtable;
import ui.Add_bbu_rru_ue.*;
import ui.Add_link.*;
import ui.Share_bag.*;
import twaver.*;
import twaver.network.*;
import twaver.network.background.ImageBackground;
import twaver.network.ui.*;
import twaver.table.*;
import twaver.tree.*;
import ui.running.run1;
import ui.running.run2;

public class tuoputu extends JFrame implements ActionListener{
	int LoginOrNot;//�ж��Ƿ��Ѿ���¼
	static String name = BBU_sql.name;
	static String passWord = BBU_sql.pswd;
	private static Font definedFont = null; 
	BackgroundMenuBar jmb;//���ɲ˵�
	JMenu jm1,jm2,jm3,jm4;//���粿����·���������Ż�����������
	JMenuItem jmi31,jmi32,jmi33,jmi34;//�μ��˵���
	JMenuItem jmi11,jmi12,jmi13,jmi14;//�μ��˵���
	JMenuItem jmi21,jmi22,jmi23,jmi24;//�μ��˵���
	JMenuItem jmi41,jmi42;//�μ��˵���
	private JScrollPane   jp;   
	private JPanel panel;
	private JPanel panel_1_1;
	private JTextField textField;
	private JButton button,button_3,button_4,button_5,button_6,button_7,button_8,button_9;
	private JButton button_case;
	private JPanel panel_2,panel_3,panel_4;
	private JLabel label;
	private JTree tree;
	CRAN_drawtable bbupool_drawtable,bbupoollink_drawtable;
	DefaultMutableTreeNode node_second2_1,node_second2_2,node_second2_3,node_second2_4,node_second3_1,node_second3_2,node_second3_3,
	node_second4_1,node_second4_2,node_second4_3,node_second4_4,node_second4_5;
	JTree Treeroot=null;
	int total_num;
	int int_bbupool_num,int_bbupoollink_num;
	Node node;
private TDataBox box = new TDataBox("Simple Data Box");
private TNetwork network;
//private TTree tree;
private JPanel networkPane = new JPanel(new BorderLayout());
private JPanel treePane = new JPanel(new BorderLayout());
private JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,treePane,networkPane);
public static GraphDemo fpaint;
private JPanel panel_1;
private JPanel panel_5;
private JLabel label_1;
Dialog login;

//public static void main(String[] args) {
////System.setProperty("swing.plaf.metal.controlFont","΢���ź�");
////Input2.oneKeyInput();
//////��������ݿ���������--------------Ĭ���˳�ʱ��������ݿ�
////Connection conn = null;
////try {
////Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////conn = java.sql.DriverManager.getConnection(  
////        "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, passWord);
//// conn.setAutoCommit(true);
//// Statement stmt = conn.createStatement();
//// String sql_drop = "exec Drop_All";
////stmt.executeUpdate(sql_drop);
////
////}catch(SQLException e1) {
////e1.printStackTrace();
////} catch (ClassNotFoundException e1) {
////e1.printStackTrace();
////}
//tuoputu frame = new tuoputu();
//frame.setVisible(true);
//}
/***************************************���캯��************************************/
public tuoputu(Dialog owner,String title,boolean modal) {
//public tuoputu() {
	login=owner;
	Draw_window();

	getContentPane().add(split, BorderLayout.CENTER);
	split.setDividerLocation(210);
	try {
		
		fpaint = new GraphDemo();
		split.setRightComponent(fpaint);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
/***************************************���������溯��************************************/
private void Draw_window() {
	// TODO �Զ����ɵķ������
	//�˵���
	jmb=new BackgroundMenuBar();
	jm1=new JMenu("���粿��");
	jm1.setFont(MyTools.f15);
//	jm1.setForeground(Color.white);

	jm2=new JMenu("��·����");
	jm2.setFont(MyTools.f15);
//	jm2.setForeground(Color.white);

	jm3=new JMenu("�����Ż�");
	jm3.setFont(MyTools.f15);
//	jm3.setForeground(Color.white);

	jm4=new JMenu("��������");
	jm4.setFont(MyTools.f15);
//	jm4.setForeground(Color.white);

	
	jmi11=new JMenuItem("BBU");
	jmi11.setFont(MyTools.f14);
	jmi11.addActionListener(this);//��Ӽ���
	jmi12=new JMenuItem("RRU");
	jmi12.setFont(MyTools.f14);
	jmi12.addActionListener(this);
	jmi13=new JMenuItem("UE");
	jmi13.setFont(MyTools.f14);
	jmi13.addActionListener(this);
	jmi14=new JMenuItem("�����ļ�����");
	jmi14.setFont(MyTools.f14);
	jmi14.addActionListener(this);
	
	jmi21=new JMenuItem("BbuPool-BbuPool");
	jmi21.setFont(MyTools.f14);
	jmi21.addActionListener(this);
	jmi22=new JMenuItem("BBU-BBU");
	jmi22.setFont(MyTools.f14);
	jmi22.addActionListener(this);
	jmi23=new JMenuItem("BBU-RRU");
	jmi23.setFont(MyTools.f14);
	jmi23.addActionListener(this);
	jmi24=new JMenuItem("LinkCircle");
	jmi24.setFont(MyTools.f14);
	jmi24.addActionListener(this);
	jmi31=new JMenuItem("���ӹ滮(P)");
	jmi31.setFont(MyTools.f14);
	jmi31.setMnemonic('P');
	jmi32=new JMenuItem("���ؾ���(B)");
	jmi32.setFont(MyTools.f14);
	jmi32.setMnemonic('B');
	jmi33=new JMenuItem("��������(M)");
	jmi33.setFont(MyTools.f14);
	jmi33.setMnemonic('M');
	jmi34=new JMenuItem("���ܲ���(S)");
	jmi34.setFont(MyTools.f14);
	jmi34.setMnemonic('S');
	jmi41=new JMenuItem("������������");
	jmi41.setFont(MyTools.f14);
	jmi41.addActionListener(this);
	jmi42=new JMenuItem("���Ʋ�������");
	jmi42.setFont(MyTools.f14);
	jmi42.addActionListener(this);
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
	jm2.add(jmi24);
	jm3.add(jmi31);
	jm3.add(jmi32);
	jm3.add(jmi33);
	jm3.add(jmi34);
	jm4.add(jmi41);
	jm4.add(jmi42);
	//���˵�����ӵ�������
	this.setJMenuBar(jmb);
	
	String path="image"+File.separator+"�˵���.png";
	Image image=new ImageIcon(path).getImage();  
	panel = new BackgroundPanel(image);  
	jmb.add(panel);
	panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	//�û�����button
	String path1="image"+File.separator+"�û�.png";
	Icon icon=new ImageIcon(path1);
	button = new JButton(icon);
	button.addActionListener(this);
	button.setContentAreaFilled(false);
	button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
	panel.add(button);
	//ʵ������button
	button_case = new JButton("ʵ������");
	button_case.addActionListener(this);
	button_case.setContentAreaFilled(false);
//	button_case.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
	panel.add(button_case);

	/***************************************���ô�������************************************/
	this.setTitle("CRAN����ʵ��ƽ̨");
	
	this.setSize(1219, 603);//�����С
	this.setLocation(100, 100);//����λ��
    //��ֹ�û��ı䴰���С
    this.setResizable(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	/***************************************������ť************************************/
	String path_1_1="image"+File.separator+"�²˵���.png";
	Image image_1_1=new ImageIcon(path_1_1).getImage(); 
	panel_1_1= new BackgroundPanel(image_1_1);
	getContentPane().add(panel_1_1, BorderLayout.SOUTH);
	panel_1_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	
	String path9="image"+File.separator+"ˢ��.png";
	Icon icon9=new ImageIcon(path9);
	button_9 = new JButton(icon9);
	button_9.setContentAreaFilled(false);
//	button_9.setBackground(Color.blue);
	button_9.setContentAreaFilled(false);
	
	button_9.addActionListener(this);
	button_9.setPreferredSize(new Dimension(icon9.getIconWidth(), icon9.getIconHeight()));
	panel_1_1.add(button_9);
	
	String path4="image"+File.separator+"BBU������·��ϵ.png";
	Icon icon4=new ImageIcon(path4);
	button_4 = new JButton(icon4);
	button_4.setContentAreaFilled(false);
	button_4.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));//д����仰����ť�͸�ͼƬһ����
	button_4.addActionListener(this);
	panel_1_1.add(button_4);
	
	String path5="image"+File.separator+"RRU������·��ϵ.png";
	Icon icon5=new ImageIcon(path5);
	button_5 = new JButton(icon5);
	button_5.setContentAreaFilled(false);
	button_5.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
	button_5.addActionListener(this);
	panel_1_1.add(button_5);
	
	String path6="image"+File.separator+"��Ԫ��������.png";
	Icon icon6=new ImageIcon(path6);
	button_6 = new JButton(icon6);
	button_6.setContentAreaFilled(false);
	button_6.setPreferredSize(new Dimension(icon6.getIconWidth(), icon6.getIconHeight()));
	panel_1_1.add(button_6);
	
	String path8="image"+File.separator+"��·��������.png";
	Icon icon8=new ImageIcon(path8);
	button_8 = new JButton(icon8);
	button_8.setContentAreaFilled(false);
	button_8.setPreferredSize(new Dimension(icon8.getIconWidth(), icon8.getIconHeight()));
	button_8.addActionListener(this);
	panel_1_1.add(button_8);
	
	String path7="image"+File.separator+"�����ļ�����.png";
	Icon icon7=new ImageIcon(path7);
	button_7 = new JButton(icon7);
	button_7.setContentAreaFilled(false);
	button_7.setPreferredSize(new Dimension(icon7.getIconWidth(), icon7.getIconHeight()));
	button_7.addActionListener(this);
	panel_1_1.add(button_7);
	/***************************************����************************************/		
//	String path_tree="image"+File.separator+"��.png";
//	Image image_tree=new ImageIcon(path_tree).getImage(); 
	panel_2 = new JPanel();
	panel_2.setLayout(new BorderLayout(0, 0));
	
	panel_3 = new JPanel();
	panel_3.setBackground(Color.white);
	panel_2.add(panel_3, BorderLayout.NORTH);
//	panel_3.setLayout(new GridLayout(2,1, 0, 0));
	
	

	
	textField = new JTextField();
	panel_3.add(textField);
	textField.setColumns(10);
	
	String path_search="image"+File.separator+"����.png";
	Icon icon_search=new ImageIcon(path_search);
	button_3 = new JButton(icon_search);
	button_3.setContentAreaFilled(false);
	button_3.setPreferredSize(new Dimension(icon_search.getIconWidth(), icon_search.getIconHeight()));
//	button_3 = new JButton("����");
	button_3.setFont(MyTools.f15);
	button_3.setForeground(Color.white );//���ð�ť��ǰ����ɫ��������ɫ
	button_3.setBackground(new Color(65,169,225));//���ð�ť�ı�����ɫ
	panel_3.add(button_3);
	
/***************************************�����б�************************************/
	//���ڵ�
	DefaultMutableTreeNode root = new DefaultMutableTreeNode();
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
	
	//Treeroot.addMouseListener(this);
	treePane.add(panel_2);
	
//	String path_1="image"+File.separator+"��.png";
//	Image image_1=new ImageIcon(path_1).getImage(); 
//	panel_1 = new BackgroundPanel(image_1);
	panel_1 = new JPanel();
	panel_1.setBackground(Color.white);
	panel_2.add(panel_1, BorderLayout.CENTER);
	panel_1.setLayout(new BorderLayout(0, 0));
	
	label_1 = new JLabel("������Դ");
	label_1.setFont(MyTools.f1);
	panel_1.add(label_1, BorderLayout.NORTH);
	panel_1.add(Treeroot,BorderLayout.CENTER);
	//������
	Treeroot.setRootVisible(false);//�޸��ڵ�
	Treeroot.setRowHeight(20);//���ڵ���и�
	DefaultTreeCellRenderer treeCellRenderer=new DefaultTreeCellRenderer();//������ڵ�Ļ��ƶ���
	treeCellRenderer=(DefaultTreeCellRenderer)Treeroot.getCellRenderer();
	treeCellRenderer.setOpaque(false);
	treeCellRenderer.setLeafIcon(new ImageIcon("image"+File.separator +"LeafIcon.png"));
	treeCellRenderer.setClosedIcon(new ImageIcon("image"+File.separator +"ClosedIcon.png"));
	treeCellRenderer.setOpenIcon(new ImageIcon("image"+File.separator +"OpenIcon.png"));
	Treeroot.setFont(MyTools.f15);

	
}


/***************************************�õ����ݿ�ÿ�������������************************************/
private int totalnum(String sql, String[] paras) {
	// TODO �Զ����ɵķ������
	BBU_sql sqlh=new BBU_sql();
	ResultSet sql_totalnum=sqlh.search(sql, paras);
	try {
		sql_totalnum.next();
		total_num=sql_totalnum.getInt(1);
	} catch (Exception e) {
		// TODO: handle exception
	}
	//���ݿ���bbu����
	return total_num;
}
/**************************************
 * ���ܣ������ϸ�����ť�ļ�����Ӧ����
 ***************************************/
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO �Զ����ɵķ������
	if(arg0.getSource()==jmi11)
	{
		JDialog a=new BBU_add(this,"BBU_add",true);
		a.setVisible(true);
	}
	if(arg0.getSource()==jmi12)
	{
		JDialog a=new RRU_add(this,"RRU_add",true);
		a.setVisible(true);
	}
	else if(arg0.getSource()==jmi13)
	{
		JDialog a=new Ue_add(this,"Ue_add",true);
		a.setVisible(true);
	}
	else if(arg0.getSource()==jmi14)
	{
		JDialog a=new Input2(this,"Input2",true);
		a.setVisible(true);
	}else if(arg0.getSource()==jmi21)
	{
		JDialog a=new BbuPool_Link(this,"BbuPool_Link",true);
		a.setVisible(true);
	}
	else if(arg0.getSource()==jmi22)
	{
		JDialog a=new Bbu2Bbu_Link(this,"Bbu2Bbu_Link",true);
		a.setVisible(true);
	}
	else if(arg0.getSource()==jmi23)
	{
		JDialog a=new BBU2RRU_Link(this,"BBU2RRU_Link",true);
		a.setVisible(true);
	}
	else if(arg0.getSource()==jmi24)
	{
		JDialog a=new LinkCircle(this,"LinkCircle",true);
		a.setVisible(true);
	}
	else if(arg0.getSource()==jmi41)
	{
		JDialog a=new run1(this,"run1",true);
		a.setVisible(true);
	}
	else if(arg0.getSource()==jmi42)
	{
		JDialog a=new run2(this,"run2",false);
		a.setVisible(true);
	}
	if(arg0.getSource()==button_7)
	{
		JDialog a=new Output(this,"Output",true);
		a.setVisible(true);
	}
	if(arg0.getSource()==button_4)//ɾ����һ��else
	{
		fpaint.ShowBbuLink();
	}
	else if(arg0.getSource()==button_5)
	{
		fpaint.ShowRruLink();
	}
	else if(arg0.getSource()==button_9)
	{
//		try {
//			
//			fpaint = new GraphDemo();
//			split.setRightComponent(fpaint);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		fpaint.clear();
	}
	else if(arg0.getSource()==button)//�û�����
	{
		JDialog a=new UserManagement(this,"UserManagement",true);
		a.setVisible(true);
		
	}
	else if(arg0.getSource()==button_case)//ʵ������
	{
		JDialog a=new CaseManage(this,"CaseManage",true);
		a.setVisible(true);
	}
}



}
