/*
 * ������RRU_add
 * ���ܣ�RRU�������
 */
package ui.Add_bbu_rru_ue;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.tree.*;

import org.jfree.util.StringUtils;

import ui.Share_bag.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.ResultSet;
import java.util.Enumeration;


public class RRU_add extends JDialog implements ActionListener,MouseListener{
	boolean b;
	private JPanel contentPanel;
	JSplitPane splitPane;
	JPanel panel1,panel_1,panel2,panel2_1,panel2_2,panel2_2_1,panel2_2_2,panel2_2_3,panel3,panel_10,buttonPane;
//	JTextField textField,textField_1,textField_2,textField_3;
	JPanel panel3_1,panel3_2,panel;
	JButton btnbbu_3,button_change;
	JLabel lableBBUPool,lableBBU,lableRRU,lableUE;
//	private JTextField textField_4,textField_5,textField_6,textField_7,textField_8,textField_10,textField_11;
	DefaultMutableTreeNode node_second2_1,node_second2_2,node_second2_3,node_second2_4,node_second3_1,node_second3_2,node_second3_3,
	node_second4_1,node_second4_2,node_second4_3,node_second4_4,node_second4_5;
	JTree Treeroot=null;
	JTable jt,jt_BBU;
	int total_num;//����
	String Bbu_num="0";//��ѡ�е�BBU
	String Bbupool_num;//��ѡ�е�BBUPOOL
	int bbupool_num;//bbu��������ͨ������bbu���õ�
	int rru_searchrow;//ͨ����ѯ���ݿ�õ���ÿ��bbu��Ӧ��rru����
	int rru_add_rownum,rru_all_row;
	int bbu_num_total,rru_num_total,ue_num_total;
	Rru_Table_module rru_table,sql_allnum_model;
	Bbu_table_module bbu_table;
	int bbu_row;
	Num_search_module bbuc,bbu;
	JButton button_1,button,button_2,button_3,cancelButton;
	JComboBox jcb1,jcb2;//�����б�
	String []jg1={"�ر�","��"};//RRU״̬�������飬����дĬ����0,0���رգ�1����
	String []jg2={"0","1","2"};//�����������飬����дĬ����0
	JScrollPane scrollPane;
	DefaultMutableTreeNode root;
//	public static void main(String[] args) {
//		try {
//			RRU_add dialog = new RRU_add();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	public RRU_add(Frame owner,String title,boolean modal) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
//public RRU_add() {
		//���ô�������
		setTitle("RRU��������");
		setBounds(150, 50, 1070, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel = new JPanel();
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		splitPane = new JSplitPane();
		splitPane.setDividerLocation(130);
		contentPanel.add(splitPane);
		panel1 = new JPanel();
/***************************************����************************************/
				splitPane.setLeftComponent(panel1);
				panel1.setLayout(new BorderLayout(0, 0));
				{
					String path_10="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"Add_BBU_RRU_UE_Left.png";
					Image image_10=new ImageIcon(path_10).getImage(); 
					panel_10= new BackgroundPanel(image_10);
					panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					
					JLabel label = new JLabel("��Ԫ�б�");
//					label.setFont(new Font("����", Font.BOLD, 20));
					label.setFont(MyTools.f1);
//					label.setForeground(Color.white);
					panel_10.add(label);
					panel1.add(panel_10, BorderLayout.NORTH);
				}
				{
					panel_1 = new JPanel();
					panel1.add(panel_1, BorderLayout.CENTER);
					panel_1.setBackground(Color.white);
					build_tree();
					panel_1.add(Treeroot, BorderLayout.CENTER);

				}		
/*****************************************����************************************/
	String path_2="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"Add_BBU_RRU_UE_Right3.png";
	Image image_2=new ImageIcon(path_2).getImage(); 
	panel2= new BackgroundPanel(image_2);
	splitPane.setRightComponent(panel2);
	panel2.setLayout(new BorderLayout(0, 0));
	panel2_1 = new JPanel();
	panel2_1.setOpaque(false);
	panel2.add(panel2_1, BorderLayout.SOUTH);
	panel2_1.setLayout(new GridLayout(1, 2, 0, 0));
	
	JPanel panel_2 = new JPanel();
	panel_2.setOpaque(false);
	panel2_1.add(panel_2);
	panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
	
	button_2 = new JButton("���");
	button_2.setFont(MyTools.f14);
	button_2.addActionListener(this);
	panel_2.add(button_2);
	
	button_3 = new JButton("����");
	button_3.setFont(MyTools.f14);
	button_3.addActionListener(this);
	panel_2.add(button_3);
	
	JPanel panel_3 = new JPanel();
	panel_3.setOpaque(false);
	panel2_1.add(panel_3);
	panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	
	button = new JButton("�޸�");
	button.setFont(MyTools.f14);
	button.addActionListener(this);
	panel_3.add(button);
	
	button_1 = new JButton("ɾ��");
	button_1.setFont(MyTools.f14);
	button_1.addActionListener(this);
	panel_3.add(button_1);
	
	panel2_2 = new JPanel();
	panel2_2.setOpaque(false);
	panel2.add(panel2_2, BorderLayout.NORTH);
	panel2_2.setLayout(new BorderLayout());
	{
		JPanel panelTitle=new JPanel();
		panelTitle.setOpaque(false);
		panelTitle.setLayout(new BorderLayout());
		JLabel lblBbu = new JLabel(" RRU����¼��");
		lblBbu.setFont(MyTools.f1);
		panelTitle.add(lblBbu,BorderLayout.CENTER);
		panel2_2.add(panelTitle,BorderLayout.WEST);
		
	}
	{
		JPanel panel_BBU_RRU_UE=new JPanel();
		panel_BBU_RRU_UE.setOpaque(false);
		panel_BBU_RRU_UE.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panel2_2.add(panel_BBU_RRU_UE,BorderLayout.EAST);
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
			sql_allnum_model=new Rru_Table_module();
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
			//��Ҫ�������ݿ�	
			String sql="exec RowNum ?";
			String []paras={"Rru"};
			sql_allnum_model=new Rru_Table_module();
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
			//��Ҫ�������ݿ�
			String sql="exec RowNum ?";
			String []paras={"Ue"};
			sql_allnum_model=new Rru_Table_module();
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
	panel3 = new JPanel();
	panel3.setOpaque(false);
	panel2.add(panel3, BorderLayout.CENTER);
	panel3.setLayout(new GridLayout(2, 1, 0, 0));
	//��ʾÿ��bbu�ض�Ӧbbu���б�
	{
		//BBU��ӦJTable
		panel3_1 = new JPanel();
		panel3_1.setOpaque(false);
		panel3.add(panel3_1);
		panel3_1.setLayout(new BorderLayout(0, 0));
			//bbu_panel��ʾBBU����
			bbu_table=new Bbu_table_module();
			jt_BBU=new JTable(bbu_table);
			jt_BBU.addMouseListener(this);
			//JTable�ı�����ɫ����
			jt_BBU.setBackground(new Color(240, 245, 250));

			jt_BBU.setRowHeight(20);//�޸ı����
			//��ñ�ͷ
			JTableHeader tableH = jt_BBU.getTableHeader();
			tableH.setFont(MyTools.f12);
			tableH.setBackground(new Color(204, 208, 213));
			  
			DefaultTableCellRenderer r =   new   DefaultTableCellRenderer();   
			r.setHorizontalAlignment(JLabel.CENTER);   
			r.setFont(MyTools.f12);
			jt_BBU.setDefaultRenderer(Object.class,r);
			
			jt_BBU.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane = new JScrollPane(jt_BBU);
			scrollPane.getViewport().setBackground(Color.white);
			panel3_1.add(scrollPane, BorderLayout.CENTER);
			//ˢ��չʾ��BBU���
			String sql2="select * from Bbu where 1=?";//�ٴ�UeGroup�е�����ӵ�����	
			String []paras2={"1"};//������ʾ���е�UeGroup  
			bbu_table=new Bbu_table_module();
			bbu_table.bbu_table_search(sql2,paras2);
			jt_BBU.setModel(bbu_table);
//			already_exist_rowbbupool=jt_bbupool.getRowCount();
			//BBU����Ӧ������һ����ɫ�ı���
			{
				panel = new JPanel();
				panel.setOpaque(false);
				panel.setLayout(new GridLayout(1, 2, 0, 0));
				panel3_1.add(panel, BorderLayout.SOUTH);
				{
					JPanel panel_1 = new JPanel(); 
					panel_1.setOpaque(false);
					panel.add(panel_1);
				}
				{
					JPanel panel_1_2 = new JPanel(); 
					panel_1_2.setOpaque(false);
					panel.add(panel_1_2);
					panel_1_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					button_change = new JButton("�޸�");
					button_change.setFont(MyTools.f14);
					button_change.addActionListener(this);
					panel_1_2.add(button_change);
				}
			}
	}
	{
		//��ʾÿ��BBU��ӦRRU���
		panel3_2 = new JPanel();
		panel3_2.setOpaque(false);
		panel3.add(panel3_2);
		panel3_2.setLayout(new BorderLayout(0, 0));
		//rru_table��ʾRRU����
		rru_table=new Rru_Table_module();
		jt=new JTable(rru_table);
		
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
		JScrollPane scrollPane = new JScrollPane(jt);
		scrollPane.getViewport().setBackground(Color.white);
		panel3_2.add(scrollPane, BorderLayout.CENTER);
	}
	/**************************************
	 * ����˳���ť
	 ***************************************/
		{
			String path_button="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"Add_BBU_RRU_UE_Bottom3.png";
			Image image_button=new ImageIcon(path_button).getImage(); 
			buttonPane= new BackgroundPanel(image_button);
//			JPanel buttonPane = new JPanel();
			buttonPane.setOpaque(false);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("�˳�");
				cancelButton.setFont(MyTools.f14);
				cancelButton.setActionCommand("�˳�");//cancel
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
			}
		}
			/**************************************
			 * ���ܣ�����Ŀ¼�����������������Ŀ¼�ڵ㣬�ұ߶�ӦBBU��RRU��������Ӧ�仯
			 ***************************************/
		class SelListener implements TreeSelectionListener
		{

			public void valueChanged(TreeSelectionEvent se) {
				// TODO �Զ����ɵķ������
				rru_add_rownum=0;
				JTree tree = (JTree)se.getSource();
				TreePath []selecttionpath=tree.getSelectionPaths();
				int get_pathcount=selecttionpath[0].getPathCount();
				if(get_pathcount==3)
				{
					DefaultMutableTreeNode selNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					String selNodename=(String) selNode.getUserObject();
					String s[]=selNodename.split("U");
					Bbu_num=s[1];//ѡ��BBU�ı��
					System.out.println("Bbu_num:"+Bbu_num);
//					show_bbupool_textfield(Bbu_num);
		//rru_panel��ʾrru�ı��
					
					String sql1="select * from Rru where ServiceBbuId=?";//�ٴ�Bbu�е���bbu������		
					String []paras1={Bbu_num};
					rru_table=new Rru_Table_module();
					rru_table.table_search(sql1,paras1);
					rru_searchrow=rru_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
					System.out.println("rru_searchrow"+rru_searchrow);
					jt.setModel(rru_table);
					//���ѡ��ĳ��BBU��BBU��������BBU�����С�
					//��Ҫ�������ݿ�
					String sql="select rn from(select rn = row_number()over(order by BbuId),* from Bbu) t Where BbuId =  ?";
					String []paras={Bbu_num};
					sql_allnum_model=new Rru_Table_module();
					ResultSet Bbu_allnum_sql=sql_allnum_model.total_num_sql(sql, paras);
					try {
						Bbu_allnum_sql.next();
						bbu_row=Bbu_allnum_sql.getInt(1)-1;//BBU��0��Ӧ��1�У�����Ҫ��1
					} catch (Exception e) {
						// TODO: handle exception
					}
					jt_BBU.setRowSelectionInterval(bbu_row,bbu_row);
			}
				if(get_pathcount==2)
				{
					DefaultMutableTreeNode selNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					String selNodename=(String) selNode.getUserObject();
					if(selNodename=="����RRU")
					{
						Bbu_num="-1";//����Bbu_num�������ж��������Ŀ¼ѡ�е���BBU���Ƕ���RRU
						//��Ȼѡ�С�����RRU�����ұ�BBU��������нӴ�����ѡ��״̬
						jt_BBU.clearSelection();	
						//rru_panel��ʾrru�ı��
						String sql1="select * from Rru where ServiceBbuId=?";//�ٴ�Bbu�е���bbu������		
						String []paras1={"-1"};
						rru_table=new Rru_Table_module();
						rru_table.table_search(sql1,paras1);
						rru_searchrow=rru_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
						jt.setModel(rru_table);
					}
					else//����Ŀ¼ѡ��BBU��
					{
						jt_BBU.clearSelection();//BBU���ȡ��������ѡ��״̬
						//RRU���հף�ֻ��ѡ���ض�BBU��RRU���Ż���ʾ��BBU��Ӧ������RRU����
						rru_table=new Rru_Table_module();
						jt.setModel(rru_table);
						Bbu_num="0";//Bbu_num=0:δѡ���κ�BBU��ѡ�е���BBU��
					}
					
				}
			
		}
		}
		/**************************************
		 * ���ܣ������ϸ�����ť�ļ�����Ӧ����
		 ***************************************/
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			/***************���rru******************/
			if(arg0.getSource()==button_2)
			{
				rru_add_rownum=rru_add_rownum+1;//���������������ݵ�����
				
				rru_table.addRows(rru_add_rownum);
				rru_table.fireTableRowsInserted(rru_searchrow, rru_searchrow+1);
				jt.setModel(rru_table);
				jcb1=new JComboBox<>(jg1);
				jcb2=new JComboBox<>(jg2);	
				jcb1.setEditable(false);
				jcb2.setEditable(false);
				jt.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(jcb1)); //���Ǵ�0��ʼ����
				jt.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(jcb2)); //���Ǵ�0��ʼ����
				
				
			}
			/***************����rru******************/
			else if(arg0.getSource()==button_3)
			{
				if(rru_add_rownum!=0)
				{
					//�ж�X,YZ���겻�ܲ���д�����򣬲��ܱ���
					boolean judge=true;
					for(int j=rru_searchrow;j<rru_searchrow+rru_add_rownum;j++)
					{
						String X=(String) rru_table.getValueAt(j, 1);//X
						String Y=(String) rru_table.getValueAt(j, 2);//Y
						String Z=(String) rru_table.getValueAt(j, 3);//Z
						if(X==null||Y==null||Z==null)
						{
							judge=false;
							//��ʾ
							JOptionPane.showMessageDialog(this,"X,Y,Z���겻��Ϊ��");
							return;
						}
						String RruTransPower=(String) rru_table.getValueAt(j, 4);//RRU ���书��
						String user_num=(String) rru_table.getValueAt(j, 5);//RRU���Ƿ�Χ�ڵ��û�����
						String CarrierFrequent=(String) rru_table.getValueAt(j, 6);//��Ƶ	
						boolean temp=isNumeric(X)&isNumeric(Y)&isNumeric(Z)&isNumeric(RruTransPower)&isNumeric(user_num)&isNumeric(CarrierFrequent);
						if(!(temp))
						{
							judge=false;
							//��ʾ
							JOptionPane.showMessageDialog(this,"����д���֣�");
							return;
						}
					}
					if(Bbu_num=="0")//δѡ������BBU���������RRU����Ϊ��֪����ӵ�����
					{
						judge=false;
						rru_table=new Rru_Table_module();
						jt.setModel(rru_table);
						JOptionPane.showMessageDialog(this,"�����б�δѡ������BBU���߶���RRU�����ܳɹ����RRU��");
						return;
					}
					if(judge==true)	
					{
						try {
							jt.getCellEditor().stopCellEditing();
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						for(int i=rru_searchrow;i<rru_searchrow+rru_add_rownum;i++)
						{
							String []paras=new String[13];
							paras[0]=(String) rru_table.getValueAt(i, 0);//rru id
							if(Bbu_num=="-1")//���ѡ�С�����RRU��
							{
								paras[1]="-1";//��Ӧ���ݿ���BBU���[ServiceBbuId]=-1
							}else//���ѡ������BBU
							{
								paras[1]=Bbu_num;//��Ӧѡ��BBU�ı��
							}
							paras[2]=null;//���ǰ뾶
							paras[3]=(String) rru_table.getValueAt(i, 1);//X
							paras[4]=(String) rru_table.getValueAt(i, 2);//Y
							paras[5]=(String) rru_table.getValueAt(i, 3);//Z
							paras[6]=(String) rru_table.getValueAt(i, 4);//RRU ���书��
							paras[7]=null;//RRU�Ĵ�����Դ
							paras[8]=(String) rru_table.getValueAt(i, 5);//RRU���Ƿ�Χ�ڵ��û�����
							if(rru_table.getValueAt(i, 7).equals("�ر�"))
							{
								paras[9]="0";
							}else if(rru_table.getValueAt(i, 7).equals("��"))
							{
								paras[9]="1";
							}
//							paras[9]=(String) rru_table.getValueAt(i, 7);//��Ծ״̬��0���رգ�1����
							paras[10]=(String) rru_table.getValueAt(i, 6);//��Ƶ
							paras[11]=(String) rru_table.getValueAt(i, 8);//����Id
							paras[12]=null;//�豸�ܺ�
							String sql="exec Add_Rru ?,?,?,?,?,?,?,?,?,?,?,?,?";//����Ҫһ��һ�е����exec Add_Rru ?,?,?,?,?,?,?,?,?,?,?    insert into Bbu values(?,?,?,?,?,?,?,?,?,?,?)
							b=rru_table.add_delete_change_to_sql(sql, paras);
							}
						//ˢ��չʾ�ı��
						String sql1="select * from Rru where ServiceBbuId=?";//�ٴ�Bbupool�е���bbu������	
						if(Bbu_num=="-1")//���ѡ�С�����RRU��
						{
							String []paras1={"-1"};
							rru_table=new Rru_Table_module();
							rru_table.table_search(sql1,paras1);
						}else//���ѡ������BBU
						{
							String []paras1={Bbu_num};
							rru_table=new Rru_Table_module();
							rru_table.table_search(sql1,paras1);
						}
						rru_searchrow=rru_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�����������������ǰbbupool�����Ӧ����bbu
						jt.setModel(rru_table);
						
						//ˢ����ʾrru������textfield
						String sql="exec RowNum ?";
						String []paras={"Rru"};
						String string_bbu_num=Update_totalnum(sql,paras);////���������ݿ���rru����
						lableRRU.setText(string_bbu_num);
						//ˢ�����νṹ
						panel_1.removeAll();
						panel_1.repaint();
						build_tree();
						if(b==true)
						{
							//����ɹ�
							JOptionPane.showMessageDialog(this, "����ɹ�");//�����Ի���
						}
						rru_add_rownum=0;
					}
					
			}
				}
			/***************�޸�rru******************/
			else if(arg0.getSource()==button)
			{
				int rowNum=this.jt.getSelectedRow();//�����û����е���
				if(rowNum==-1)//����û�û��ѡ��ĳһ��
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"��ѡ��һ��");
					return;
				}
				rru_all_row=rru_searchrow+rru_add_rownum;
				if(rru_all_row==0)
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"��bbu����û������");
					return;
				}
				if(rru_all_row>0)
				{
					new Rru_modify(this, "�޸�", true, rru_table, rowNum);
					String sql1="select * from Rru where ServiceBbuId=?";//�ٴ�Rru�е���ĳ��bbu��Ӧ������		
					String []paras1={Bbu_num};
					rru_table=new Rru_Table_module();
					rru_table.table_search(sql1,paras1);
					
					jt.setModel(rru_table);		
				}
			}
			/***************ɾ��rru******************/
			else if(arg0.getSource()==button_1)
			{
				int rowNum=this.jt.getSelectedRow();//�����û����е���
				if(rowNum==-1)//����û�û��ѡ��ĳһ��
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"��ѡ��һ��");
					return;
				}		
				rru_all_row=rru_searchrow+rru_add_rownum;
				if(rru_all_row==0)
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"��BBU��û��RRU");
					return;
				}
				if(rru_all_row>0)
				{
					int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ��RRU", "", JOptionPane.YES_NO_OPTION);
					if(a==JOptionPane.NO_OPTION)
					{
						return;
					}
					if(a==JOptionPane.YES_OPTION)
					{
						String ID=(String) rru_table.getValueAt(rowNum,0);
						String sql="exec Drop_Rru ?";
						String []paras={ID};
						b=rru_table.add_delete_change_to_sql(sql, paras);
						String sql1="select * from Rru where ServiceBbuId=?";//�ٴ�Bbu�е���bbu������		
						String []paras1={Bbu_num};
						rru_table=new Rru_Table_module();
						rru_table.table_search(sql1,paras1);
						rru_searchrow=rru_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
						jt.setModel(rru_table);
						
						//ˢ����ʾrru������texrfield
						String sql2="exec RowNum ?";
						String []paras2={"Rru"};
						String string_bbu_num=Update_totalnum(sql2,paras2);////���������ݿ���bbu����
						lableRRU.setText(string_bbu_num);
						//ˢ�����νṹ
						panel_1.removeAll();
						panel_1.repaint();
						build_tree();
						if(b==true)
						{
							//ɾ���ɹ�
							JOptionPane.showMessageDialog(this, "ɾ���ɹ�");//�����Ի���
						}
					}
				}
			}
			/***************BBU����޸�******************/
			else if(arg0.getSource()==button_change)
			{
				int rowNum=this.jt_BBU.getSelectedRow();//�����û����е���
				if(rowNum==-1)//����û�û��ѡ��ĳһ��
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"��ѡ��һ��");
					return;
				}
				else
				{
					new Bbu_modify(this, "�޸�", true, bbu_table, rowNum);
					String sql1="select * from Bbu where 1=?";//�ٴ�Bbu�е���bbu������		
					String []paras1={"1"};
					bbu_table=new Bbu_table_module();
					bbu_table.bbu_table_search(sql1,paras1);
					jt_BBU.setModel(bbu_table);		
				}
			}
			/***************�˳���ť******************/
			else if(arg0.getSource()==cancelButton)
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
			sql_allnum_model=new Rru_Table_module();
			ResultSet allnum_sql=sql_allnum_model.total_num_sql(sql,paras);
			try {
				allnum_sql.next();
				total_num=allnum_sql.getInt(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			int temp_num=total_num;
			String string_num_total=Integer.toString(temp_num);//���ݿ���bbu����
			return string_num_total;
		}

		/**************************************
		 * ���ܣ���������Ŀ¼��
		 ***************************************/
		public void build_tree() {
			//�����б�
			//���ڵ�
			root = new DefaultMutableTreeNode("���ڵ�");
			
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
//				String BbuPoolId=Integer.toString(i);//int����ת����string����
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
			DefaultMutableTreeNode node_first = new DefaultMutableTreeNode("����RRU");
			root.add(node_first);
			//���ø��ڵ�ֱ�Ӵ�����Treeroot
			Treeroot=new JTree(root);
			TreeSelectionModel treeSelectionModel;//�������ѡ��ģʽ
			treeSelectionModel=Treeroot.getSelectionModel();
			//��������ѡ��ģʽΪ��ѡ
//			treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);//////////////////////////////////////////////
			Treeroot.addTreeSelectionListener(new SelListener());
			
			panel_1.add(Treeroot, BorderLayout.CENTER);
			//������
			Treeroot.setRootVisible(false);//�޸��ڵ�
			Treeroot.setRowHeight(20);//���ڵ���и�
			DefaultTreeCellRenderer treeCellRenderer=new DefaultTreeCellRenderer();//������ڵ�Ļ��ƶ���
			treeCellRenderer=(DefaultTreeCellRenderer)Treeroot.getCellRenderer();
			treeCellRenderer.setLeafIcon(new ImageIcon("image"+File.separator +"LeafIcon.png"));
			treeCellRenderer.setClosedIcon(new ImageIcon("image"+File.separator +"ClosedIcon.png"));
			treeCellRenderer.setOpenIcon(new ImageIcon("image"+File.separator +"OpenIcon.png"));
			Treeroot.setFont(new Font("����", Font.PLAIN, 20));
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
		 * ���ܣ�������Ӧ������ĺ���
		 ***************************************/
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO �Զ����ɵķ������
	/***********************˫��BBU�������ĳ��BBU����������б��ӦBBU״̬��Ϊ��ѡ�У�ͬʱ��������ʾ��BBU�°���������RRU*********************/
			if(e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e))
			{
				int rowselected=this.jt_BBU.getSelectedRow();//�����û����е���
				Bbu_num=(String) jt_BBU.getValueAt(rowselected, 0);
				//rru_panel��ʾrru�ı��
				String sql1="select * from Rru where ServiceBbuId=?";//�ٴ�Bbu�е���bbu������		
				String []paras1={Bbu_num};
				rru_table=new Rru_Table_module();
				rru_table.table_search(sql1,paras1);
				rru_searchrow=rru_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
				jt.setModel(rru_table);
				//JTree����ʾ��ӦBBU�ڵ�ѡ��״̬
				Enumeration enumeration;
				enumeration=root.preorderEnumeration();
				while(enumeration.hasMoreElements())
				{
					DefaultMutableTreeNode node = (DefaultMutableTreeNode)enumeration.nextElement();
					String selNodename=(String) node.getUserObject();
					if(node.isLeaf())
					{
						String s[]=selNodename.split("U");
						System.out.println(Bbu_num);
						if(Bbu_num.equals(s[1]))//ѡ��BBU�ı��
						{
							//���� node ��ȡ TreePath
							TreePath treePath = new TreePath(node.getPath());
//							Treeroot.addSelectionPath(treePath);
							Treeroot.getSelectionModel().setSelectionPath(treePath);
							break;
						}
					}
					
				}
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO �Զ����ɵķ������
			
		}

		}
		
		