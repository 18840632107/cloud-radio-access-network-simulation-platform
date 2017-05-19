/*
 * ������BbuPool_Link
 * ���ܣ�BBU�ؼ���·�������
 */
package ui.Add_link;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import ui.Share_bag.BackgroundPanel;
import ui.Share_bag.MyTools;
import ui.Share_bag.Num_search_module;

public class BbuPool_Link extends JDialog implements ActionListener{
	boolean b;
	private JPanel contentPanel;
	JLabel label2;
	JTree Treeroot=null;
	DefaultMutableTreeNode node_second2_1,node_second2_2,node_second2_3,node_second2_4,node_second3_1,node_second3_2,node_second3_3,
	node_second4_1,node_second4_2,node_second4_3,node_second4_4,node_second4_5;
	Num_search_module bbuc,bbu;
	int bbupool_num;
	JPanel panel_1,panel_3,panel_4,panel,panel_2,panel_5,panel_6,panel_7,panel_8,panel_9,panel_10,buttonPane;
	JScrollPane jsp1,jsp2;
	private JLabel label;
	private JButton button,button_1,button_2,button_3;
	JTable jt;
	BbuPool_Link_Module BbuPool_Link_table;
	int BbuPool_Link_add_rownum;//��ӵ�BbuPool_Link����
	JComboBox jcb1;//�����б�
	String []jg1={"����","������"};//��·�������飬����дĬ����0,0�����ͣ�1��������
	int total_num;
	BbuPool_Link_Module sql_allnum_model;
	JButton cancelButton;
	JLabel lableBBUPool,lableBBU,lableRRU,lableUE;
	int bbu_num_total,rru_num_total,ue_num_total;//���ݿ���һ���ж��ٸ�bbu
	JPanel panel_12;
	JLabel lblBbu;
//	public static void main(String[] args) {
//		try {
//			BbuPool_Link dialog = new BbuPool_Link();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**************************************
	 * ���ܣ�������·�������
	 ***************************************/
	public BbuPool_Link(Frame owner,String title,boolean modal) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
//public BbuPool_Link() {
		setTitle("BBU�ؼ���·����");

		setBounds(170, 20, 1000, 700);//����λ��
//		getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		getContentPane().setLayout(new BorderLayout());
		contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout());

		
		panel_1 = new JPanel();
//		getContentPane().add(panel_1);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(140);
		panel_1.add(splitPane, BorderLayout.CENTER);
/***************************************����************************************/		
		panel_3 = new JPanel();
		splitPane.setLeftComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));	
		
		String path_10="image"+File.separator+"ADD_Link"+File.separator+"Link_Left.png";
		Image image_10=new ImageIcon(path_10).getImage(); 
		panel_10= new BackgroundPanel(image_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		label2 = new JLabel("��Ԫ�б�");
		label2.setFont(MyTools.f1);
		panel_10.add(label2);
		panel_3.add(panel_10, BorderLayout.NORTH);
		
		panel_4 = new JPanel();		
		panel_4.setBackground(Color.white);
		build_tree();
		panel_4.add(Treeroot, BorderLayout.CENTER);
		jsp1=new JScrollPane(panel_4);
		panel_3.add(jsp1, BorderLayout.CENTER);
/*****************************************����************************************/		
		String path_2="image"+File.separator+"ADD_Link"+File.separator+"Link_Right.png";
		Image image_2=new ImageIcon(path_2).getImage(); 
		panel= new BackgroundPanel(image_2);
		splitPane.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout());
		/***************************************
		 * ����������
		 * ���ܣ�ʵʱ��ȡ���ݿ���BBUPOOL,BBU,RRU,UE�ĸ�������ʾ����
		 * ************************************/
		{
			JPanel panel_BBU_RRU_UE=new JPanel();
			panel_BBU_RRU_UE.setOpaque(false);
			panel_BBU_RRU_UE.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			panel_2.add(panel_BBU_RRU_UE,BorderLayout.EAST);
			{
				String path_BBUPool="image"+File.separator+"public"+File.separator+"bbu�ظ�����ť.png";
				Icon icon_BBUPool=new ImageIcon(path_BBUPool);
				JLabel lblBbu_1 = new JLabel(icon_BBUPool);//����������������ʱ������bbupool_num
				lblBbu_1.setPreferredSize(new Dimension(icon_BBUPool.getIconWidth(), icon_BBUPool.getIconHeight()));
				panel_BBU_RRU_UE.add(lblBbu_1);
				int temp_bbupool_num=bbupool_num;//bbupool_numһ���ж��ٸ�bbupool
				String string_bbupool_num=Integer.toString(temp_bbupool_num);
				lableBBUPool = new JLabel(string_bbupool_num);
				lableBBUPool.setFont(MyTools.f15);
				panel_BBU_RRU_UE.add(lableBBUPool);
				
				JLabel lable_blank=new JLabel(" ");//�ո�
				panel_BBU_RRU_UE.add(lable_blank);
				
			}
			{
				String path_BBU="image"+File.separator+"public"+File.separator+"bbu������ť.png";
				Icon icon_BBU=new ImageIcon(path_BBU);
				JLabel lblBbu_2 = new JLabel(icon_BBU);//����������������ʱ������bbupool_num
				lblBbu_2.setPreferredSize(new Dimension(icon_BBU.getIconWidth(), icon_BBU.getIconHeight()));
				panel_BBU_RRU_UE.add(lblBbu_2);
				//��Ҫ�������ݿ�
				String sql="exec RowNum ?";
				String []paras={"Bbu"};
				sql_allnum_model=new BbuPool_Link_Module();
				ResultSet Bbu_allnum_sql=sql_allnum_model.total_num_sql(sql, paras);
				try {
					Bbu_allnum_sql.next();
					bbu_num_total=Bbu_allnum_sql.getInt(1);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				int temp_bbu_num=bbu_num_total;
				String string_bbu_num=Integer.toString(temp_bbu_num);//���ݿ���bbu����
				lableBBU = new JLabel(string_bbu_num);
				lableBBU.setFont(MyTools.f15);
				panel_BBU_RRU_UE.add(lableBBU);
				
				JLabel lable_blank=new JLabel(" ");//�ո�
				panel_BBU_RRU_UE.add(lable_blank);
			}
			{
				String path_RRU="image"+File.separator+"public"+File.separator+"rru������ť.png";
				Icon icon_RRU=new ImageIcon(path_RRU);
				JLabel lblRru = new JLabel(icon_RRU);//����������������ʱ������bbupool_num
				lblRru.setPreferredSize(new Dimension(icon_RRU.getIconWidth(), icon_RRU.getIconHeight()));
				panel_BBU_RRU_UE.add(lblRru);
				String sql="exec RowNum ?";
				String []paras={"Rru"};
				sql_allnum_model=new BbuPool_Link_Module();
				ResultSet Rru_allnum_sql=sql_allnum_model.total_num_sql(sql, paras);
				try {
					Rru_allnum_sql.next();
					rru_num_total=Rru_allnum_sql.getInt(1);
				} catch (Exception e) {
					// TODO: handle exception
				}
				int temp_rru_num=rru_num_total;
				String string_rru_num=Integer.toString(temp_rru_num);//���ݿ���rru����
				lableRRU = new JLabel(string_rru_num);
				lableRRU.setFont(MyTools.f15);
				panel_BBU_RRU_UE.add(lableRRU);
				
				JLabel lable_blank=new JLabel(" ");//�ո�
				panel_BBU_RRU_UE.add(lable_blank);
			}
			{
				String path_UE="image"+File.separator+"public"+File.separator+"ue������ť.png";
				Icon icon_UE=new ImageIcon(path_UE);
				JLabel lblUe = new JLabel(icon_UE);//����������������ʱ������bbupool_num
				lblUe.setPreferredSize(new Dimension(icon_UE.getIconWidth(), icon_UE.getIconHeight()));
				panel_BBU_RRU_UE.add(lblUe);
				String sql="exec RowNum ?";
				String []paras={"Ue"};
				sql_allnum_model=new BbuPool_Link_Module();
				ResultSet Ue_allnum_sql=sql_allnum_model.total_num_sql(sql, paras);
				try {
					Ue_allnum_sql.next();
					ue_num_total=Ue_allnum_sql.getInt(1);
				} catch (Exception e) {
					// TODO: handle exception
				}
				int temp_ue_num=ue_num_total;
				String string_ue_num=Integer.toString(temp_ue_num);
				lableUE = new JLabel(string_ue_num);
				lableUE.setFont(MyTools.f15);
				panel_BBU_RRU_UE.add(lableUE);
			}
		}
		
		panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_2.add(panel_12, BorderLayout.WEST);

		label = new JLabel("BBU�ؼ���·����");
		label.setFont(MyTools.f1);;
		panel_12.add(label);
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new GridLayout(1, 2, 0, 0));
		
//		String path_6="image"+File.separator+"ADD_Link"+File.separator+"ADD_BBU_Right2.png";
//		Image image_6=new ImageIcon(path_6).getImage(); 
//		panel_6 = new BackgroundPanel(image_6);
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_5.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		button = new JButton("���");
//		button.setForeground(Color.white);
		button.setFont(MyTools.f14);
//		button.setContentAreaFilled(false);
		button.addActionListener(this);
		panel_6.add(button);
		
		button_1 = new JButton("����");
//		button_1.setForeground(Color.white);
		button_1.setFont(MyTools.f14);
//		button_1.setContentAreaFilled(false);
		button_1.addActionListener(this);
		panel_6.add(button_1);
		
//		String path_7="image"+File.separator+"ADD_Link"+File.separator+"ADD_BBU_Right2.png";
//		Image image_7=new ImageIcon(path_7).getImage(); 
//		panel_7 = new BackgroundPanel(image_7);
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_5.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		button_2 = new JButton("�޸�");
//		button_2.setForeground(Color.white);
		button_2.setFont(MyTools.f14);
//		button_2.setContentAreaFilled(false);
		button_2.addActionListener(this);
		panel_7.add(button_2);
		
		button_3 = new JButton("ɾ��");
//		button_3.setForeground(Color.white);
		button_3.setFont(MyTools.f14);
//		button_3.setContentAreaFilled(false);
		button_3.addActionListener(this);
		panel_7.add(button_3);
		//bbuc_link_module��ʾBBU����·���
		panel_8 = new JPanel();
		panel_8.setLayout(new BorderLayout());
		panel.add(panel_8, BorderLayout.CENTER);
		BbuPool_Link_table=new BbuPool_Link_Module();
		jt=new JTable(BbuPool_Link_table);
		
		//JTable�ı�����ɫ����
		jt.setBackground(new Color(240, 245, 250));

		jt.setRowHeight(20);//�޸ı����
		//��ñ�ͷ
		JTableHeader tableH = jt.getTableHeader();
		tableH.setFont(MyTools.f12);
		tableH.setBackground(new Color(204, 208, 213));
		  
		DefaultTableCellRenderer r =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		r.setFont(MyTools.f12);
		jt.setDefaultRenderer(Object.class,r);
		jt.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		//��ʼ��jsp
		jsp2=new JScrollPane(jt);
		jsp2.getViewport().setBackground(Color.white);
		//��jsp���뵽JFrame��
		panel_8.add(jsp2);
		//ˢ��չʾ�ı��jt
		String sql="select * from LinkBbuPool2BbuPool where 1=?";//�ٴ�UE�е�����ӵ�����		
		String []paras={"1"};//������ʾ�����Ѿ���ӵ�UE
		BbuPool_Link_table=new BbuPool_Link_Module();
		BbuPool_Link_table.BbuPool_Link_search(sql,paras);
		
		jt.setModel(BbuPool_Link_table);
		/**************************************
		 * �˳���ť
		 ***************************************/
		{
			String path_button="image"+File.separator+"ADD_Link"+File.separator+"Link_bottom.png";
			Image image_button=new ImageIcon(path_button).getImage(); 
			buttonPane= new BackgroundPanel(image_button);
			buttonPane.setOpaque(false);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);			
			cancelButton = new JButton("�˳�");
			cancelButton.setFont(MyTools.f14);
			cancelButton.setActionCommand("�˳�");
			cancelButton.addActionListener(this);
			buttonPane.add(cancelButton);
		}
	}
	/**************************************
	 * ���ܣ���������Ŀ¼��
	 ***************************************/
	private void build_tree() {
		// TODO �Զ����ɵķ������
		//�����б�
		//���ڵ�
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("���ڵ�");
		
		//һ���ڵ�
		String sql="select * from BbuPool where 1=?";
		String []paras={"1"};
		bbuc=new Num_search_module();
		bbuc.search_num(sql, paras,1);//ֻ��ҪBBU�صĵ�һ�����ݣ���ȡBBU�ص�ID��,��Ϊbbu�ص�id���ǲ������ġ�
		bbupool_num=bbuc.getRowCount();
		for(int i=0;i<bbupool_num;i++)//i�����ʾ�ڼ��У���������������ID��
		{
			DefaultMutableTreeNode node_first = new DefaultMutableTreeNode("BBU��"+bbuc.getValueAt(i, 0));
			//�����ڵ�
			String sql2="select * from Bbu where BbuPoolId=?";
			//int temp=i;
			//String BbuPoolId=String.valueOf(temp);//ת����int temp����>String temp�ˣ����Բ���ֱ����int i��Ҫ��һ����ʱ����temp
//			String BbuPoolId=Integer.toString(i);//int����ת����string����
			String BbuPoolId=(String) bbuc.getValueAt(i, 0);
			String []paras2={BbuPoolId};
			bbu=new Num_search_module();
			bbu.search_num(sql2, paras2,2);//��ҪBBU���������ݣ���ȡBBU��ID�ţ���BBU�ص�ID��
			int bbu_num=bbu.getRowCount();
			for(int j=0;j<bbu_num;j++)
			{
				DefaultMutableTreeNode node_second = new DefaultMutableTreeNode("BBU"+bbu.getValueAt(j, 0),false);
				
				node_first.add(node_second);
			}
			root.add(node_first);
		}
		//���ø��ڵ�ֱ�Ӵ�����Treeroot
		Treeroot=new JTree(root);
		TreeSelectionModel treeSelectionModel;//�������ѡ��ģʽ
		treeSelectionModel=Treeroot.getSelectionModel();
		//��������ѡ��ģʽΪ��ѡ
		treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		panel_4.add(Treeroot, BorderLayout.CENTER);
		//������
		Treeroot.setRootVisible(false);//�޸��ڵ�
		Treeroot.setRowHeight(20);//���ڵ���и�
		DefaultTreeCellRenderer treeCellRenderer=new DefaultTreeCellRenderer();//������ڵ�Ļ��ƶ���
		treeCellRenderer=(DefaultTreeCellRenderer)Treeroot.getCellRenderer();
		treeCellRenderer.setLeafIcon(new ImageIcon("image"+File.separator +"LeafIcon.png"));
		treeCellRenderer.setClosedIcon(new ImageIcon("image"+File.separator +"ClosedIcon.png"));
		treeCellRenderer.setOpenIcon(new ImageIcon("image"+File.separator +"OpenIcon.png"));
//		Treeroot.setFont(new Font("����", Font.PLAIN, 20));
		Treeroot.setFont(MyTools.f14);
		//������Ĭ��Ϊչ��ģʽ
		//��ǰ��������нڵ�
		Enumeration<?>enumaration;
		enumaration=root.preorderEnumeration();
		while(enumaration.hasMoreElements())
		{
			DefaultMutableTreeNode node;
			node=(DefaultMutableTreeNode)enumaration.nextElement();
			if(!node.isLeaf())
			{
				TreePath path=new TreePath(node.getPath());
				Treeroot.expandPath(path);
			}
		}
	}

	/**************************************
	 * ���ܣ������ϸ�����ť�ļ�����Ӧ����
	 ***************************************/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//���
		if(arg0.getSource()==button)
		{
			BbuPool_Link_add_rownum=BbuPool_Link_add_rownum+1;//���������������ݵ�����
			BbuPool_Link_table.addRows(BbuPool_Link_add_rownum);
			BbuPool_Link_table.fireTableRowsInserted(BbuPool_Link_add_rownum, BbuPool_Link_add_rownum+1);
			jt.setModel(BbuPool_Link_table);
			
			jcb1=new JComboBox<>(jg1);			
			jcb1.setEditable(false);			
			jt.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(jcb1)); //���Ǵ�0��ʼ����
			
		}
		//����
		else if(arg0.getSource()==button_1)
		{
			if(BbuPool_Link_add_rownum!=0)
			{
				String sql1="exec RowNum ?";
				String []paras1={"LinkBbuPool2BbuPool"};
				String BbuPool_Link_searchrow=Update_totalnum(sql1,paras1);//���������ݿ���ue����
				int temp_BbuPool_Link_searchrow= Integer.parseInt(BbuPool_Link_searchrow);
				//�жϱ�����д���֣�������д��ĸ
				boolean judge=true;
				for(int j=temp_BbuPool_Link_searchrow;j<temp_BbuPool_Link_searchrow+BbuPool_Link_add_rownum;j++)
				{
					String MaxTransRate=(String) BbuPool_Link_table.getValueAt(j, 3);//MaxTransRate
					boolean temp=isNumeric(MaxTransRate);
					if(!(temp))
					{
						judge=false;
						//��ʾ
						JOptionPane.showMessageDialog(this,"����д���֣�");
						return;
					}
				}
				if(judge==true)	
				{
					try {
						jt.getCellEditor().stopCellEditing();
					} catch (Exception e) {
						// TODO: handle exception
					}	
					for(int i=temp_BbuPool_Link_searchrow;i<temp_BbuPool_Link_searchrow+BbuPool_Link_add_rownum;i++)
					{
						String []paras=new String[13];
						paras[0]="LinkBbuPool2BbuPool";
						paras[1]=(String) BbuPool_Link_table.getValueAt(i, 0);//LinkPathId
						paras[2]=(String) BbuPool_Link_table.getValueAt(i, 1);//LinkEnd1
						paras[3]=(String) BbuPool_Link_table.getValueAt(i, 2);//LinkEnd2
						paras[4]="0";//RealLength
						if(BbuPool_Link_table.getValueAt(i, 4).equals("����"))
						{
							paras[5]="0";//LinkType,0�����ͣ�1��������
						}else if(BbuPool_Link_table.getValueAt(i, 4).equals("������"))
						{
							paras[5]="1";//LinkType,0�����ͣ�1��������
						}
//						paras[5]=(String) BbuPool_Link_table.getValueAt(i, 4);//LinkType
						paras[6]=(String) BbuPool_Link_table.getValueAt(i, 3);//MaxTransRate
						paras[7]="0";//Attenuationnull
						paras[8]="0";//Delay
						paras[9]="0";//ErrorRate
						paras[10]="0";//Cost
						paras[11]="0";//LinkCircleId
						paras[12]="0";//FibersNum exec Add_Link LinkBbuPool2BbuPool,3,1,2,3,4,5,6,7,8,9,1,2
						String sql="exec Add_Link ?,?,?,?,?,?,?,?,?,?,?,?,?";//����Ҫһ��һ�е����exec Add_Bbu ?,?,?,?,?,?,?,?,?,?,?    insert into Bbu values(?,?,?,?,?,?,?,?,?,?,?)
						b=BbuPool_Link_table.add_delete_change_to_sql(sql, paras);
						}
					//ˢ��չʾ�ı��
					String sql2="select * from LinkBbuPool2BbuPool where 1=?";//�ٴ�Bbupool�е���bbu������		
					String []paras2={"1"};
					BbuPool_Link_table=new BbuPool_Link_Module();
					BbuPool_Link_table.BbuPool_Link_search(sql2,paras2);
					jt.setModel(BbuPool_Link_table);
					if(b==true)
					{
						//����ɹ�
						JOptionPane.showMessageDialog(this, "�������");//�����Ի���
					}
					BbuPool_Link_add_rownum=0;
				}
		}
	}
		else if(arg0.getSource()==button_2)//�޸�
		{
			int rowNum=this.jt.getSelectedRow();//�����û����е���
			if(rowNum==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}else
			{
				new BbuPool_Link_modify(this, "�޸�", true, BbuPool_Link_table, rowNum);
				//ˢ�±��
				String sql2="select * from LinkBbuPool2BbuPool where 1=?";//�ٴ�Bbupool�е���bbu������		
				String []paras2={"1"};
				BbuPool_Link_table=new BbuPool_Link_Module();
				BbuPool_Link_table.BbuPool_Link_search(sql2,paras2);
				jt.setModel(BbuPool_Link_table);
			}
		}
		else if(arg0.getSource()==button_3)//ɾ��
		{
			int rowNum=this.jt.getSelectedRow();//�����û����е���
			if(rowNum==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}else
			{
				int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ��������·", "", JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.NO_OPTION)
				{
					return;
				}
				if(a==JOptionPane.YES_OPTION)
				{
					String Link_ID=(String) BbuPool_Link_table.getValueAt(rowNum,0);
					String sql="exec Drop_Link ?,?";
					String []paras={"LinkBbuPool2BbuPool",Link_ID};
					b=BbuPool_Link_table.add_delete_change_to_sql(sql, paras);
					//ˢ�±��
					String sql1="select * from LinkBbuPool2BbuPool where 1=?";//�ٴ�Bbu�е���bbu������		
					String []paras1={"1"};
					BbuPool_Link_table=new BbuPool_Link_Module();
					BbuPool_Link_table.BbuPool_Link_search(sql1,paras1);
					jt.setModel(BbuPool_Link_table);
					//
					if(BbuPool_Link_add_rownum!=0)
					{
						BbuPool_Link_add_rownum=BbuPool_Link_add_rownum-1;
					}
					else
					{
						BbuPool_Link_add_rownum=0;
					}
					if(b==true)
					{
						//ɾ���ɹ�
						JOptionPane.showMessageDialog(this, "ɾ���ɹ�");//�����Ի���
					}
				}
			}
			
		}
		else if(arg0.getSource()==cancelButton)//ȡ��//////////////////////////////////////////////////////////
		{
			this.dispose();//�رնԻ���
		}
		
}
	public static boolean isNumeric(String str){ 
		if(str==null)
		{
			return true;
		}
		if(str=="")
		{
			return true;
		}
		int index = str.indexOf(".");
		if(index<0)//�������������
		{
			for (int i = str.length();--i>=0;)
			  {    
				   if (!Character.isDigit(str.charAt(i)))
				   {  
				    return false;  
				   }
			   }
		}
		else{//���������С��
			String num1 = str.substring(0, index); 
			String num2 = str.substring(index + 1);
			String num=num1+num2;
			for (int i = num.length();--i>=0;)
			  {    
				   if (!Character.isDigit(num.charAt(i)))
				   {  
				    return false;  
				   }
			   }
		}
		  return true;  
		} 
	/***************ʵʱ��ȡ���ݿ��ж�����������������ĺ���******************/
	private String Update_totalnum(String sql, String[] paras) {
		// TODO �Զ����ɵķ������
	sql_allnum_model=new BbuPool_Link_Module();
	ResultSet allnum_sql=sql_allnum_model.total_num_sql(sql,paras);
	try {
		allnum_sql.next();
		total_num=allnum_sql.getInt(1);
	} catch (Exception e) {
		// TODO: handle exception
	}
	int temp_num=total_num;
	String string_num_total=Integer.toString(temp_num);//���ݿ���ue����
	return string_num_total;
	}
}
class Draw_panel extends JPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		setBackground(Color.white);
		g.drawOval(100, 100, 20, 20);
	}
}

