/*
 * ������BBU_add
 * ���ܣ�BBU����BBU�������
 */
package ui.Add_bbu_rru_ue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.plaf.SplitPaneUI;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.tree.*;

import org.apache.poi.hwpf.usermodel.BorderCode;

import ui.Share_bag.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

public class BBU_add extends JDialog implements ActionListener,MouseListener{
	private  JPanel contentPanel;
	boolean b;
	private JTextField textField_4,textField_5,textField_6,textField_7,textField_8;
	JSplitPane splitPane;
	JPanel panel1,panel_1;
	JPanel panel2,panel2_1,panel2_2,panel2_2_1,panel2_2_2;
	JPanel panel3,panel3_1,panel3_2,buttonPane,panel_bbuc,panel_10;
	JButton button5,okButton,cancelButton;
	DefaultMutableTreeNode node_second2_1,node_second2_2,node_second2_3,node_second2_4,node_second3_1,node_second3_2,node_second3_3,
	node_second4_1,node_second4_2,node_second4_3,node_second4_4,node_second4_5;
	JTree Treeroot=null;
	Num_search_module rru,ue,bbu,bbuc;
	Bbu_table_module bbu_table,sql_allnum_model,bbuc_table,Bbupool_maxid_model;//���bbu�ģ�ר�������õ�bbu rru ue �����ģ����bbu��,�ҵ�bbu�����ĵ�ǰID 
	BBUPool_table_module BBUPool_table ;
	int bbu_num_total,rru_num_total,ue_num_total,total_num;//���ݿ���һ���ж��ٸ�bbu
	int bbu_max_id;//bbupool��ǰ���id
	int bbupool_num;//һ���ж��ٸ�bbu��
	int bbu_add_rownum;//ÿ��һ������˶��ٸ�bbu
	int bbupool_add_rownum;//ÿ��һ������˶��ٸ�bbupool
	int bbu_searchrow;//ͨ����ѯ���ݿ�õ���ÿ��bbu�ض�Ӧ��bbu����
	int bbu_all_row;//һ��bbu���£�һ���ж��ٸ�bbu��
	int bbupool_all_row;//����BBU�أ�����
	int bbupool_alreadyrow=0;//�Ѿ�����˵�BBUPool����
	int already_exist_rowbbupool;
	int bbupool_row;//ѡ��BBUPool��BBUPool���JTable�ĵڼ���
	JLabel lableBBUPool,lableBBU,lableRRU,lableUE;
	JComboBox jcb1,jcb2;//�����б�
	String []jg1={"RRS","CIS","PFSS"};//RRU�ĵ��ȷ�ʽ���飬����дĬ����0,0��RRS 1:CIS 2:PFSS///////////////???????????????????//////////////////
	Vector jg2=null;//LinkID BBU���뻷
	String Bbupool_num;//ѡ��BBUPOOL�ı��
	JTable jt,jt_bbupool;
	JScrollPane scrollPane,scrollPaneBBUPool,jsp;
	private JTable table;
	private JPanel panel,panel_2,panel_4,panel_5,panel_6;
	private JButton button,button_2,button_1,button_3;
	private JButton btnbbu,btnbbu_1,btnbbu_2,btnbbu_3;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblBbu;
	DefaultMutableTreeNode root;

//	public static void main(String[] args) {
//		try {
//			BBU_add dialog = new BBU_add();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	/**************************************
	 * ���ܣ�������·�������
	 ***************************************/
	public BBU_add(Frame owner,String title,boolean modal) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
//	public BBU_add() {
		//���ô�������
		setSize(1000, 620);
		setLocation(150, 50);
		setTitle("BBU��������");
		getContentPane().setLayout(new BorderLayout());
		contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout());
		{
			//�ָ��ߣ��������ҽ���
			splitPane = new JSplitPane();
			splitPane.setDividerLocation(130);
			contentPanel.add(splitPane);
			{
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
					label.setFont(MyTools.f1);
					panel_10.add(label);
					panel1.add(panel_10, BorderLayout.NORTH);
				}
				{
					panel_1 = new JPanel();
					panel_1.setBackground(Color.white);
					build_tree();
					panel_1.add(Treeroot, BorderLayout.CENTER);
					jsp=new JScrollPane(panel_1);
					panel1.add(jsp, BorderLayout.CENTER);
				}
			}
			
/*****************************************����************************************/
			{
				String path_2="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"Add_BBU_RRU_UE_Right3.png";
				Image image_2=new ImageIcon(path_2).getImage(); 
				panel2= new BackgroundPanel(image_2);
				splitPane.setRightComponent(panel2);
				panel2.setLayout(new BorderLayout(0, 0));
				/***************************************
				 * ����������
				 * ���ܣ�ʵʱ��ȡ���ݿ���BBUPOOL,BBU,RRU,UE�ĸ�������ʾ����
				 * ************************************/
				{
					panel2_2 = new JPanel();
					panel2_2.setOpaque(false);
					panel2.add(panel2_2, BorderLayout.NORTH);
					panel2_2.setLayout(new BorderLayout());
						{
							JPanel panel_BBU_RRU_UE=new JPanel();
							panel_BBU_RRU_UE.setOpaque(false);
							panel_BBU_RRU_UE.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
							panel2_2.add(panel_BBU_RRU_UE,BorderLayout.EAST);
							{//BBUPOOL
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
							{//BBU
								String path_BBU="image"+File.separator+"public"+File.separator+"bbu������ť.png";
								Icon icon_BBU=new ImageIcon(path_BBU);
								JLabel lblBbu_2 = new JLabel(icon_BBU);//����������������ʱ������bbupool_num
								lblBbu_2.setPreferredSize(new Dimension(icon_BBU.getIconWidth(), icon_BBU.getIconHeight()));
								panel_BBU_RRU_UE.add(lblBbu_2);
								//��Ҫ�������ݿ�
								String sql="exec RowNum ?";
								String []paras={"Bbu"};
								sql_allnum_model=new Bbu_table_module();
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
							{//RRU
								String path_RRU="image"+File.separator+"public"+File.separator+"rru������ť.png";
								Icon icon_RRU=new ImageIcon(path_RRU);
								JLabel lblRru = new JLabel(icon_RRU);//����������������ʱ������bbupool_num
								lblRru.setPreferredSize(new Dimension(icon_RRU.getIconWidth(), icon_RRU.getIconHeight()));
								panel_BBU_RRU_UE.add(lblRru);
								String sql="exec RowNum ?";
								String []paras={"Rru"};
								sql_allnum_model=new Bbu_table_module();
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
							{//UE
								String path_UE="image"+File.separator+"public"+File.separator+"ue������ť.png";
								Icon icon_UE=new ImageIcon(path_UE);
								JLabel lblUe = new JLabel(icon_UE);//����������������ʱ������bbupool_num
								lblUe.setPreferredSize(new Dimension(icon_UE.getIconWidth(), icon_UE.getIconHeight()));
								panel_BBU_RRU_UE.add(lblUe);
								String sql="exec RowNum ?";
								String []paras={"Ue"};
								sql_allnum_model=new Bbu_table_module();
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
						panel2_2.add(panel_12, BorderLayout.WEST);
						
						lblBbu = new JLabel("BBU����¼��");
						lblBbu.setFont(MyTools.f1);
						panel_12.add(lblBbu);
				}
			/***************************************
			 * ����JTable���
			 * ************************************/
				panel3 = new JPanel();
				panel3.setOpaque(false);
				panel2.add(panel3, BorderLayout.CENTER);
				panel3.setLayout(new GridLayout(2, 1, 0, 0));
				/***********��ʾÿ��BBU�ص��б�**********/
				{
					//BBUPool��JTable���
					panel3_2 = new JPanel();
					panel3_2.setOpaque(false);
					panel3.add(panel3_2);
					panel3_2.setLayout(new BorderLayout(0, 0));
					BBUPool_table=new BBUPool_table_module();
					jt_bbupool=new JTable(BBUPool_table);
					jt_bbupool.addMouseListener(this);
					jt_bbupool.setBackground(new Color(240, 245, 250));//JTable�ı�����ɫ����
					jt_bbupool.setRowHeight(20);//�޸ı����
					//��ñ�ͷ
					JTableHeader tableH = jt_bbupool.getTableHeader();
					tableH.setFont(MyTools.f12);
					tableH.setBackground(new Color(204, 208, 213));
					  
					DefaultTableCellRenderer r =   new   DefaultTableCellRenderer();   
					r.setHorizontalAlignment(JLabel.CENTER);   
					r.setFont(MyTools.f12);
					jt_bbupool.setDefaultRenderer(Object.class,r);
					
					jt_bbupool.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPaneBBUPool = new JScrollPane(jt_bbupool);
					scrollPaneBBUPool.getViewport().setBackground(Color.white);
					panel3_2.add(scrollPaneBBUPool, BorderLayout.CENTER);
					//ˢ��չʾ�ı��jt_bbupool
					String sql2="select * from BbuPool where 1=?";//�ٴ�UeGroup�е�����ӵ�����	
					String []paras2={"1"};//������ʾ���е�UeGroup  
					BBUPool_table=new BBUPool_table_module();
					BBUPool_table.bbupool_table_search(sql2,paras2);
					jt_bbupool.setModel(BBUPool_table);
					already_exist_rowbbupool=jt_bbupool.getRowCount();
				/**************************************
				 * BBUPool���/����/�޸�/ɾ����ť
				 * ************************************/	
					panel_4 = new JPanel();
					panel_4.setOpaque(false);
					panel_4.setLayout(new GridLayout(1, 2, 0, 0));
					
					panel_5 = new JPanel();
					panel_5.setOpaque(false);
					panel_4.add(panel_5);
					panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					
					btnbbu = new JButton("���BBU��");
					btnbbu.setFont(MyTools.f14);
					btnbbu.addActionListener(this);
					panel_5.add(btnbbu);
					
					btnbbu_1 = new JButton("����BBU��");
					btnbbu_1.setFont(MyTools.f14);
					btnbbu_1.addActionListener(this);
					panel_5.add(btnbbu_1);
					
					panel_6 = new JPanel();
					panel_6.setOpaque(false);
					panel_4. add(panel_6);
					panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					
					btnbbu_2 = new JButton("ɾ��BBU��");
					btnbbu_2.setFont(MyTools.f14);
					btnbbu_2.addActionListener(this);
					panel_6.add(btnbbu_2);
					panel3_2.add(panel_4, BorderLayout.SOUTH);
				}
				/***********��ʾÿ��bbu�ض�Ӧbbu���б�**********/
				{
					//BBU��ӦJTable
					panel3_1 = new JPanel();
					panel3_1.setOpaque(false);
					panel3.add(panel3_1);
					panel3_1.setLayout(new BorderLayout(0, 0));
						//bbu_panel��ʾBBU����
						bbu_table=new Bbu_table_module();
						jt=new JTable(bbu_table);
//						jt.setRowSelectionAllowed(true);//ʹ�ñ���ѡȡ������Ϊ��λ,����������Ϊ��λ.����û��д����,����ѡȡ�������ʱ������Ϊ��λ.
//						selectionMode=jt.getSelectionModel();
//						selectionMode.addListSelectionListener(this);
//						selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//����ѡ��
						
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
						scrollPane = new JScrollPane(jt);
						scrollPane.getViewport().setBackground(Color.white);
						panel3_1.add(scrollPane, BorderLayout.CENTER);
						//BBU��Ӧ���/����/�޸�/ɾ��
						{
							panel2_1 = new JPanel();
							panel2_1.setOpaque(false);
							panel2_1.setLayout(new GridLayout(1, 2, 0, 0));
							panel3_1.add(panel2_1, BorderLayout.SOUTH);
								panel = new JPanel(); 
								panel.setOpaque(false);
								panel2_1.add(panel);
								panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
									button = new JButton("���");
									button.setFont(MyTools.f14);
									button.addActionListener(this);
									panel.add(button);
									button_1 = new JButton("����");
									button_1.setFont(MyTools.f14);
									button_1.addActionListener(this);
									panel.add(button_1);
								panel_2 = new JPanel();
								panel_2.setOpaque(false);
								panel2_1.add(panel_2);
								panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
									btnbbu_3 = new JButton("ת��BBU��");
									btnbbu_3.setFont(MyTools.f14);
									btnbbu_3.addActionListener(this);
									panel_2.add(btnbbu_3);	
									
									button_3 = new JButton("�޸�");
									button_3.setFont(MyTools.f14);
									button_3.addActionListener(this);
									panel_2.add(button_3);
									
									button_2 = new JButton("ɾ��");
									button_2.setFont(MyTools.f14);
									button_2.addActionListener(this);
									panel_2.add(button_2);				
						}
				}
			}
		}
		/**************************************
		 * ����˳���ť
		 ***************************************/
		{
			String path_button="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"Add_BBU_RRU_UE_Bottom3.png";
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
	 * ���ܣ������������б����
	 ***************************************/
	class SelListener implements TreeSelectionListener
	{
		@Override
		public void valueChanged(TreeSelectionEvent se) {
			// TODO �Զ����ɵķ������
			bbu_add_rownum=0;
			JTree tree = (JTree)se.getSource();
			TreePath []selecttionpath=tree.getSelectionPaths();
			int get_pathcount=selecttionpath[0].getPathCount();
			if(get_pathcount==2)
			{
				DefaultMutableTreeNode selNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				String selNodename=(String) selNode.getUserObject();
				String s[]=selNodename.split("��");
				Bbupool_num=s[1];//ѡ��BBUPOOL�ı��
//				System.out.println(s[0]+s[1]);//�����Ľ��ַ�������
//				show_bbupool_textfield(Bbupool_num);
	//bbu_panel��ʾbbu�ı��
				//bbu_table.clean_all();//bbu��JTable��գ���дBBU��JTable
				String sql1="select * from Bbu where BbuPoolId=?";//�ٴ�Bbu�е���bbu������		
				String []paras1={s[1]};
				bbu_table=new Bbu_table_module();
				bbu_table.bbu_table_search(sql1,paras1);
				bbu_searchrow=bbu_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
				jt.setModel(bbu_table);		
				//���ѡ��ĳ��BBUPool��BBUPool��������BBUPool�����С�
				//��Ҫ�������ݿ�
				String sql="select rn from(select rn = row_number()over(order by BbuPoolId),* from BbuPool) t Where BbuPoolId =  ?";
				String []paras={Bbupool_num};
				sql_allnum_model=new Bbu_table_module();
				ResultSet Bbu_allnum_sql=sql_allnum_model.total_num_sql(sql, paras);
				try {
					Bbu_allnum_sql.next();
					bbupool_row=Bbu_allnum_sql.getInt(1)-1;//BBU��0��Ӧ��1�У�����Ҫ��1
				} catch (Exception e) {
					// TODO: handle exception
				}
				jt_bbupool.setRowSelectionInterval(bbupool_row,bbupool_row);
			}
			if(get_pathcount==3)
			{
				jt_bbupool.clearSelection();//BBUPOOL���ȡ��������ѡ��״̬
				//BBU�����ʾѡ��BBU
				DefaultMutableTreeNode selNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				String selNodename=(String) selNode.getUserObject();
				String s[]=selNodename.split("U");
				String Bbu_num;
				Bbu_num=s[1];//ѡ��BBU�ı��
				String sql1="select * from Bbu where BbuId=?";//�ٴ�Bbu�е���bbu������		
				String []paras1={Bbu_num};
				bbu_table=new Bbu_table_module();
				bbu_table.bbu_table_search(sql1,paras1);
				jt.setModel(bbu_table);
			}
			
		}
		
	}
	/**************************************
	 * ���ܣ������ϸ�����ť�ļ�����Ӧ����
	 ***************************************/
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		/***************��Ӱ�ť******************/
		if(arg0.getSource()==button)
		{
			
			bbu_add_rownum=bbu_add_rownum+1;//���������������ݵ�����
			String X;
			String Y;
			String Z;
			String sql="select * from BbuPool where BbuPoolId=?";//�ȴ�BbuPool�е�������		
			String []paras={Bbupool_num};
			bbuc.clean_all();//bbuc��JTable��գ���дBBUC��JTable
			bbuc.search_num(sql, paras,9);//�����Ҫ��ʾ���ݿ�BBUc��ǰ4�е�����
			int rowcount=bbuc.getRowCount();
			System.out.println(rowcount);
			if(rowcount>=1)
			{
				X=(String) bbuc.getValueAt(0, 1);
				Y=(String) bbuc.getValueAt(0, 2);
				Z=(String) bbuc.getValueAt(0, 3);
				bbu_table.addRows(bbu_add_rownum,X,Y,Z);
				bbu_table.fireTableRowsInserted(bbu_searchrow, bbu_searchrow+1);	
				jt.setModel(bbu_table);
				
				jcb1=new JComboBox<>(jg1);			
				jcb1.setEditable(false);			
				jt.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(jcb1)); //���Ǵ�0��ʼ����			
				jt.setRowHeight(21);
				//���뻷
				jg2=new Vector<>();
					String sql1="select * from LinkCircle where 1=?";//	
					String []paras1={"1"};//
					BBU_sql circlid_sql=new BBU_sql();
					ResultSet rs=circlid_sql.search(sql1, paras1);
					try {
						while(rs.next())
						{
							jg2.add(rs.getString(1));//LinkCircleId
						}
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}finally
					{
						//�ر�
						circlid_sql.close();
					}				
				jcb2=new JComboBox<>(jg2);			
				jcb2.setEditable(false);			
				jt.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(jcb2)); //���Ǵ�0��ʼ����
			}	
		}
		/***************���水ť******************/
		else if(arg0.getSource()==button_1)
		{
			if(bbu_add_rownum!=0)
			{
				
				boolean judge=true;
				//�ж�X,Y,Z���겻�ܲ���д�����򣬲��ܱ���
				for(int j=bbu_searchrow;j<bbu_searchrow+bbu_add_rownum;j++)
				{
					String X=(String) bbu_table.getValueAt(j, 1);//X
					String Y=(String) bbu_table.getValueAt(j, 2);//Y
					String Z=(String) bbu_table.getValueAt(j, 3);//Z
					if(X==null||Y==null||Z==null)
					{
						judge=false;
						//��ʾ
						JOptionPane.showMessageDialog(this,"X,Y,Z���겻��Ϊ��");
						return;
					}
					String TransPower=(String) bbu_table.getValueAt(j, 4);//���书��
					String Res=(String) bbu_table.getValueAt(j, 5);//��Դ��	
					boolean temp=isNumeric(X)&isNumeric(Y)&isNumeric(Z)&isNumeric(TransPower)&isNumeric(Res);
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
					for(int i=bbu_searchrow;i<bbu_searchrow+bbu_add_rownum;i++)
					{
						String []paras=new String[12];
						paras[0]=(String) bbu_table.getValueAt(i, 0);//bbu id
						paras[1]=Bbupool_num;//ѡ��BBUpool�ı��
						paras[2]=(String) bbu_table.getValueAt(i, 1);//X
						paras[3]=(String) bbu_table.getValueAt(i, 2);//Y
						paras[4]=(String) bbu_table.getValueAt(i, 3);//Z
						paras[5]=null;
						if(bbu_table.getValueAt(i, 6).equals("RRS"))//RRU��Դ���ȵķ�ʽ:0��RRS 1:CIS 2:PFS
						{
							paras[6]="0";
						}else if(bbu_table.getValueAt(i, 6).equals("CIS"))
						{
							paras[6]="1";
						}else if(bbu_table.getValueAt(i, 6).equals("PFS"))
						{
							paras[6]="2";
						}else
						{
							paras[6]=null;
						}
//						paras[6]=(String) bbu_table.getValueAt(i, 6);//RRU��Դ���ȵķ�ʽ
						paras[7]=(String) bbu_table.getValueAt(i, 4);//���书��dbm��ʽ
						paras[8]=null;//s�豸�ܺ�
						paras[9]=null;//bbu״̬�Ƿ��Ծ
						paras[10]=(String) bbu_table.getValueAt(i, 5);//��Դ��
						paras[11]=(String) bbu_table.getValueAt(i, 7);//���뻷
						String sql="exec Add_Bbu ?,?,?,?,?,?,?,?,?,?,?,?";//����Ҫһ��һ�е����exec Add_Bbu ?,?,?,?,?,?,?,?,?,?,?    insert into Bbu values(?,?,?,?,?,?,?,?,?,?,?)
						b=bbu_table.add_delete_change_to_sql(sql, paras);
						}
					//ˢ��չʾ�ı��
					String sql1="select * from Bbu where BbuPoolId=?";//�ٴ�Bbupool�е���bbu������		
					String []paras1={Bbupool_num};
					bbu_table=new Bbu_table_module();
					bbu_table.bbu_table_search(sql1,paras1);
					bbu_searchrow=bbu_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�����������������ǰbbupool�����Ӧ����bbu
					jt.setModel(bbu_table);
					
					//ˢ����ʾbbu������texrfield
					String sql="exec RowNum ?";
					String []paras={"Bbu"};
					String string_bbu_num=Update_totalnum(sql,paras);////���������ݿ���bbu����
					lableBBU.setText(string_bbu_num);
					//ˢ�����νṹ
					panel_1.removeAll();
					panel_1.repaint();
					build_tree();
					//����ɹ�
					if(b==true)
					{
						JOptionPane.showMessageDialog(this, "����ɹ�");//�����Ի���
					}	
					bbu_add_rownum=0;
				}
				
			}
			}
		/***************ɾ��BBU��ť******************/
		else if(arg0.getSource()==button_2)
		{
			
			int rowNum=this.jt.getSelectedRow();//�����û����е���
			if(rowNum==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}		
			bbu_all_row=bbu_searchrow+bbu_add_rownum;
			if(bbu_all_row==0)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��bbu����û������");
				return;
			}
			if(bbu_all_row>0)
			{
				int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ��BBU", "", JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.NO_OPTION)
				{
					return;
				}
				if(a==JOptionPane.YES_OPTION)
				{
					String ID=(String) bbu_table.getValueAt(rowNum,0);
					String sql="exec Drop_Bbu ?";
					String []paras={ID};
					b=bbu_table.add_delete_change_to_sql(sql, paras);
					String sql1="select * from Bbu where BbuPoolId=?";//�ٴ�Bbu�е���bbu������		
					String []paras1={Bbupool_num};
					bbu_table=new Bbu_table_module();
					bbu_table.bbu_table_search(sql1,paras1);
					bbu_searchrow=bbu_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
					jt.setModel(bbu_table);
					
					//ˢ����ʾbbu������texrfield
					String sql2="exec RowNum ?";
					String []paras2={"Bbu"};
					String string_bbu_num=Update_totalnum(sql2,paras2);////���������ݿ���bbu����
					lableBBU.setText(string_bbu_num);
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
		/***************�޸İ�ť******************/
		else if(arg0.getSource()==button_3)
		{
			int rowNum=this.jt.getSelectedRow();//�����û����е���
			if(rowNum==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			bbu_all_row=bbu_searchrow+bbu_add_rownum;
			if(bbu_all_row==0)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��bbu����û������");
				return;
			}
			if(bbu_all_row>0)
			{
				new Bbu_modify(this, "�޸�", true, bbu_table, rowNum);
				String sql1="select * from Bbu where BbuPoolId=?";//�ٴ�Bbu�е���bbu������		
				String []paras1={Bbupool_num};
				bbu_table=new Bbu_table_module();
				bbu_table.bbu_table_search(sql1,paras1);
				
				jt.setModel(bbu_table);		
			}
		}
		/***************ת��BBU��******************/
		else if(arg0.getSource()==btnbbu_3)
		{
			int rowNum=jt.getSelectedRow();
			if (rowNum==-1)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			else
				{
				//ת��
				String bbu_id=(String) bbu_table.getValueAt(rowNum, 0);
				String input_bbupool_num=JOptionPane.showInputDialog("��BBU"+bbu_id+"   ת�Ƶ�BBU��:");//input_bbupool_num�û�����ϣ��ת�Ƶ���bbu��
				String sql="ReConnectBbu2BbuPool ?,?";//�ٴ�Bbu�е���bbu������		
				String []paras={bbu_id,input_bbupool_num};
				bbu_table=new Bbu_table_module();
				b=bbu_table.add_delete_change_to_sql(sql,paras);
				//ˢ��jtable
				String sql1="select * from Bbu where BbuPoolId=?";//�ٴ�Bbu�е���bbu������		
				String []paras1={Bbupool_num};
				bbu_table=new Bbu_table_module();
				bbu_table.bbu_table_search(sql1,paras1);
				bbu_searchrow=bbu_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
				jt.setModel(bbu_table);
				//ˢ�����νṹ
				panel_1.removeAll();
				panel_1.repaint();
				build_tree();
				if(b==true)
				{
					//ɾ���ɹ�
					JOptionPane.showMessageDialog(this, "ת�Ƴɹ�");//�����Ի���
				}
				}
			
			
		}
		/***************���bbu�ذ�ť******************/
		else if(arg0.getSource()==btnbbu)
		{
			bbupool_add_rownum=bbupool_add_rownum+1;//���������������ݵ�����
			
			BBUPool_table.addRows(bbupool_add_rownum);
			BBUPool_table.fireTableRowsInserted(bbupool_alreadyrow, bbupool_alreadyrow+1);	
			jt_bbupool.setModel(BBUPool_table);		
		}
		/***************����bbu�ذ�ť******************/
		else if(arg0.getSource()==btnbbu_1)
		{
			if(bbupool_add_rownum!=0)
			{
				//�ж�X,Y���겻�ܲ���д�����򣬲��ܱ���
				boolean judge=true;
				for(int j=(already_exist_rowbbupool+bbupool_alreadyrow);j<(already_exist_rowbbupool+bbupool_alreadyrow)+bbupool_add_rownum;j++)
				{
					String X=(String) BBUPool_table.getValueAt(j, 1);//X
					String Y=(String) BBUPool_table.getValueAt(j, 2);//Y
					if(X==null||Y==null||X.length()==0||Y.length()==0)
					{
						judge=false;
						//��ʾ
						JOptionPane.showMessageDialog(this,"����X���ꡢ����Y���겻��Ϊ��");
						return;
					}
					boolean temp=isNumeric(X)&isNumeric(Y);
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
					jt_bbupool.getCellEditor().stopCellEditing();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				for(int i=already_exist_rowbbupool+bbupool_alreadyrow;i<already_exist_rowbbupool+bbupool_alreadyrow+bbupool_add_rownum;i++)
				{
					String []paras=new String[9];
					paras[0]=(String) BBUPool_table.getValueAt(i, 0);//bbupool id
					paras[1]=(String) BBUPool_table.getValueAt(i, 1);//X
					paras[2]=(String) BBUPool_table.getValueAt(i, 2);//Y
					paras[3]=(String) BBUPool_table.getValueAt(i, 3);//Z
					paras[4]=null;
					paras[5]=null;
					paras[6]=null;
					paras[7]=null;
					paras[8]=(String) BBUPool_table.getValueAt(i, 4);//��ע
					String sql="exec Add_BbuPool ?,?,?,?,?,?,?,?,?";//����Ҫһ��һ�е����exec Add_Bbu ?,?,?,?,?,?,?,?,?,?,?    insert into Bbu values(?,?,?,?,?,?,?,?,?,?,?)
					b=BBUPool_table.add_delete_change_to_sql(sql, paras);
					}
				//ˢ��չʾ�ı��
				String sql1="select * from BbuPool where 1=?";//�ٴ�Bbupool�е�������BBUPool����		
				String []paras1={"1"};
				BBUPool_table=new BBUPool_table_module();
				BBUPool_table.bbupool_table_search(sql1,paras1);
				bbupool_alreadyrow=BBUPool_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�����������������ǰbbupool�����Ӧ����bbu
				jt_bbupool.setModel(BBUPool_table);
				
				//ˢ����ʾbbupool������texrfield
				String sql="exec RowNum ?";
				String []paras={"BbuPool"};
				String string_bbupool_num=Update_totalnum(sql,paras);////���������ݿ���bbu����
				lableBBUPool.setText(string_bbupool_num);
				//ˢ�����νṹ
				panel_1.removeAll();
				panel_1.repaint();
				build_tree();
				if(b=true)
				{
					//����ɹ�
					JOptionPane.showMessageDialog(this, "����ɹ�");//�����Ի���
				}
				bbupool_add_rownum=0;
			}
			}
			
		}
		/***************ɾ��bbu�ذ�ť******************/
		else if(arg0.getSource()==btnbbu_2)
		{
			int rowNum=this.jt_bbupool.getSelectedRow();//�����û����е���
			if(rowNum==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}		
			bbupool_all_row=bbupool_alreadyrow+bbupool_add_rownum;
			if(bbupool_all_row==0)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��δ����BBU��");
				return;
			}
			if(bbupool_all_row>0)
			{
				int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ��BBU��", "", JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.NO_OPTION)
				{
					return;
				}
				if(a==JOptionPane.YES_OPTION)
				{
					String ID=(String) BBUPool_table.getValueAt(rowNum,0);
					String sql="exec Drop_BbuPool ?";
					String []paras={ID};
					b=BBUPool_table.add_delete_change_to_sql(sql, paras);
					String sql1="select * from BbuPool where 1=?";//�ٴ�Bbu�е���bbu������		
					String []paras1={"1"};
					BBUPool_table=new BBUPool_table_module();
					BBUPool_table.bbupool_table_search(sql1,paras1);
					bbupool_alreadyrow=BBUPool_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
					jt_bbupool.setModel(BBUPool_table);
					
					//ˢ����ʾbbu��������texrfield
					String sql2="exec RowNum ?";
					String []paras2={"BbuPool"};
					String string_bbupool_num=Update_totalnum(sql2,paras2);////���������ݿ���bbu����
					lableBBUPool.setText(string_bbupool_num);
					//ˢ�����νṹ
					panel_1.removeAll();
					panel_1.repaint();
					build_tree();
					if(b==true)
					{
						//ɾ���ɹ�
						JOptionPane.showMessageDialog(this, "ɾ���ɹ�");//�����Ի���
					}
					//
					bbu_table=new Bbu_table_module();
					bbu_table.clean_all();
					jt.setModel(bbu_table);
					//BBU���ˢ��
					String sql4="select * from Bbu where BbuPoolId=?";//�ٴ�Bbu�е���bbu������		
					String []paras4={ID};
					bbu_table=new Bbu_table_module();
					bbu_table.bbu_table_search(sql4,paras4);
					bbu_searchrow=bbu_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
					jt.setModel(bbu_table);
					
					//ˢ����ʾbbu������texrfield
					String sql3="exec RowNum ?";
					String []paras3={"Bbu"};
					String string_bbu_num=Update_totalnum(sql3,paras3);////���������ݿ���bbu����
					lableBBU.setText(string_bbu_num);
				}
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
	//public void delete_bbuc(String tempBbupool_num)//ɾ��BBU�صĺ���//////////////////////
//{
//	
//	String sql="exec Drop_BbuPool ?";
//	String []paras={tempBbupool_num};
//	bbu_table.add_delete_change_to_sql(sql, paras);
//	//ˢ��bbu�ص�textfield
//	textField_4.setText("");
//	textField_5.setText("");
//	textField_6.setText("");
//	textField_7.setText("");
//	textField_8.setText("");
//	//ˢ��jtable
//	bbu_table=new Bbu_table_module();
//	jt.setModel(bbu_table);
//	//ˢ����ʾbbu��������texrfield
//	String sql2="exec RowNum ?";
//	String []paras2={"BbuPool"};
//	String string_bbuc_num=Update_totalnum(sql2,paras2);
//	lableBBUPool.setText(string_bbuc_num);
//	//ˢ����ʾbbu������texrfield
//	String sql3="exec RowNum ?";
//	String []paras3={"Bbu"};
//	String string_bbu_num=Update_totalnum(sql3,paras3);
//	lableBBU.setText(string_bbu_num);
//	//ˢ�����νṹ
//	panel_1.removeAll();
//	panel_1.repaint();
//	build_tree();
//	//ɾ���ɹ�
//	JOptionPane.showMessageDialog(this, "ɾ���ɹ�");//�����Ի���
//}
//	@Override
//	public void valueChanged(ListSelectionEvent arg0) {
//		// TODO �Զ����ɵķ������
//		select_row_num= jt.getSelectedRows();
//	}
	/**************************************
	 * ���ܣ���������Ŀ¼��
	 ***************************************/
	public void build_tree()
	{
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
//	public void show_bbupool_textfield(String Bbupool_num)//��ʾbbuPool��ID��X,Y,Z,���꣬��עtextfield�ĺ���
//	{
//		String sql="select * from BbuPool where BbuPoolId=?";//�ȴ�BbuPool�е�������		
//		String []paras={Bbupool_num};
//		bbuc.clean_all();//bbuc��JTable��գ���дBBUC��JTable
//		bbuc.search_num(sql, paras,9);//�����Ҫ��ʾ���ݿ�BBUc��ǰ4�е�����
//		textField_4.setText((String) bbuc.getValueAt(0, 0));
//		textField_5.setText((String) bbuc.getValueAt(0, 1));
//		textField_6.setText((String) bbuc.getValueAt(0, 2));
//		textField_7.setText((String) bbuc.getValueAt(0, 3));
//		textField_8.setText((String) bbuc.getValueAt(0, 8));
//	}
	/***************ʵʱ��ȡ���ݿ��ж�����������������ĺ���******************/
	public String Update_totalnum(String sql,String[]paras)
	{
		sql_allnum_model=new Bbu_table_module();
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
	 * ���ܣ�������Ӧ������ĺ���
	 ***************************************/
@Override
public void mouseClicked(MouseEvent e) {
	// TODO �Զ����ɵķ������
	if(e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e))
	{
		int rowselected=this.jt_bbupool.getSelectedRow();//�����û����е���
		Bbupool_num=(String) jt_bbupool.getValueAt(rowselected, 0);
		//rru_panel��ʾrru�ı��
		String sql1="select * from Bbu where BbuPoolId=?";//�ٴ�Bbu���е���bbu������		
		String []paras1={Bbupool_num};
		bbu_table=new Bbu_table_module();
		bbu_table.bbu_table_search(sql1,paras1);
		bbu_searchrow=bbu_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
		jt.setModel(bbu_table);
		//JTree����ʾ��ӦBBU�ڵ�ѡ��״̬
		Enumeration enumeration;
		enumeration=root.preorderEnumeration();
		while(enumeration.hasMoreElements())
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)enumeration.nextElement();
			String selNodename=(String) node.getUserObject();
			TreePath treePath0 = new TreePath(node.getPath());
			int num=treePath0.getPathCount();
			if(num==2)
			{
				String s[]=selNodename.split("��");
				if(Bbupool_num.equals(s[1]))//ѡ��BBU�ı��
				{
					//���� node ��ȡ TreePath
					TreePath treePath = new TreePath(node.getPath());
//					Treeroot.addSelectionPath(treePath);
					Treeroot.getSelectionModel().setSelectionPath(treePath);

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

