package ui.Draft;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.plaf.SplitPaneUI;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.tree.*;

import org.apache.poi.hwpf.usermodel.BorderCode;

import ui.Add_bbu_rru_ue.Bbu_modify;
import ui.Add_bbu_rru_ue.Bbu_table_module;
import ui.Share_bag.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

public class CopyOfBBU_add extends JDialog implements ActionListener{
	private  JPanel contentPanel;
	
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2,textField_3;
	private JTextField textField_4,textField_5,textField_6,textField_7,textField_8;
	JSplitPane splitPane;
	JPanel panel1,panel_1;
	JPanel panel2,panel2_1,panel2_2,panel2_2_1,panel2_2_2,panel2_2_3,panel2_3;
	JPanel panel3_1,panel3_1_2,panel3_2,panel5,panel6,panel7,panel8,panel9,buttonPane,panel_bbuc,panel_10;
	JButton button5,okButton,cancelButton;
	DefaultMutableTreeNode node_second2_1,node_second2_2,node_second2_3,node_second2_4,node_second3_1,node_second3_2,node_second3_3,
	node_second4_1,node_second4_2,node_second4_3,node_second4_4,node_second4_5;
	JTree Treeroot=null;
	Num_search_module rru,ue,bbu,bbuc;
	Bbu_table_module bbu_table,sql_allnum_model,bbuc_table,Bbupool_maxid_model;//���bbu�ģ�ר�������õ�bbu rru ue �����ģ����bbu��,�ҵ�bbu�����ĵ�ǰID 
	int bbu_num_total,rru_num_total,ue_num_total,total_num;//���ݿ���һ���ж��ٸ�bbu
	int bbu_max_id;//bbupool��ǰ���id
	int bbupool_num;//һ���ж��ٸ�bbu��
	int bbu_add_rownum;//ÿ��һ������˶��ٸ�bbu
	int bbu_searchrow;//ͨ����ѯ���ݿ�õ���ÿ��bbu�ض�Ӧ��bbu����
	int bbu_all_row;//һ��bbu���£�һ���ж��ٸ�bbu��
	JLabel lableBBUPool,lableBBU,lableRRU,lableUE;
	JComboBox jcb1,jcb2;//�����б�
	String []jg1={"0","1"};//RRU�ĵ��ȷ�ʽ���飬����дĬ����0
	Vector jg2=null;//LinkID BBU���뻷
	String Bbupool_num;//ѡ��BBUPOOL�ı��
	JTable jt;
	JScrollPane scrollPane,jsp;
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

	public static void main(String[] args) {
		try {
			CopyOfBBU_add dialog = new CopyOfBBU_add();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public BBU_add(Frame owner,String title,boolean modal) {
//		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
	public CopyOfBBU_add() {
		//���ô�������
		setSize(1000, 620);
		setLocation(150, 50);
		setTitle("BBU��������");
		getContentPane().setLayout(new BorderLayout());
		contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout());

		{
			splitPane = new JSplitPane();
//			splitPane.setDividerSize(0);

			splitPane.setDividerLocation(130);
			contentPanel.add(splitPane);
			{
				panel1 = new JPanel();
//				panel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//����
				splitPane.setLeftComponent(panel1);
				panel1.setLayout(new BorderLayout(0, 0));
				{
					String path_10="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"Add_BBU_RRU_UE_Left.png";
					Image image_10=new ImageIcon(path_10).getImage(); 
					panel_10= new BackgroundPanel(image_10);
					
					JLabel label = new JLabel("��Ԫ�б�");
					label.setFont(MyTools.f1);
					panel_10.add(label, BorderLayout.CENTER);
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
			
//����
			{
				String path_2="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"Add_BBU_RRU_UE_Right3.png";
				Image image_2=new ImageIcon(path_2).getImage(); 
				panel2= new BackgroundPanel(image_2);
//				panel2 = new JPanel();
				splitPane.setRightComponent(panel2);
				panel2.setLayout(new BorderLayout(0, 0));
				{
					panel2_1 = new JPanel();
					panel2_1.setOpaque(false);
					panel2_1.setLayout(new GridLayout(1, 2, 0, 0));
					panel2.add(panel2_1, BorderLayout.SOUTH);
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
				{
					panel2_2 = new JPanel();
					panel2_2.setOpaque(false);
					panel2.add(panel2_2, BorderLayout.NORTH);
					panel2_2.setLayout(new GridLayout(4, 1, 0, 0));//4��1�еı��
						//��1��
								JPanel panel1=new JPanel();
								panel1.setOpaque(false);
								panel1.setLayout(new BorderLayout());
								panel2_2.add(panel1);

								{
									JPanel panel_BBU_RRU_UE=new JPanel();
									panel_BBU_RRU_UE.setOpaque(false);
									panel_BBU_RRU_UE.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
									panel1.add(panel_BBU_RRU_UE,BorderLayout.EAST);
									{
										JLabel lblBbu_1 = new JLabel("BBU�ظ���:");//����������������ʱ������bbupool_num
										lblBbu_1.setFont(MyTools.f15);
//										lblBbu_1.setForeground(Color.white);
										panel_BBU_RRU_UE.add(lblBbu_1);
										int temp_bbupool_num=bbupool_num;//bbupool_numһ���ж��ٸ�bbupool
										String string_bbupool_num=Integer.toString(temp_bbupool_num);
										lableBBUPool = new JLabel(string_bbupool_num);
										lableBBUPool.setFont(MyTools.f15);
										panel_BBU_RRU_UE.add(lableBBUPool);
										
										JLabel lable_blank=new JLabel("  ");//�ո�
										panel_BBU_RRU_UE.add(lable_blank);
										
									}
									{
										JLabel lblBbu_2 = new JLabel("BBU����:");//��Ҫ�������ݿ�
										lblBbu_2.setFont(MyTools.f15);
//										lblBbu_2.setForeground(Color.white);
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
										
										JLabel lable_blank=new JLabel("  ");//�ո�
										panel_BBU_RRU_UE.add(lable_blank);
									}
									{
										JLabel lblRru = new JLabel("RRU����:");
										lblRru.setFont(MyTools.f15);
//										lblRru.setForeground(Color.white);
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
										
										JLabel lable_blank=new JLabel("  ");//�ո�
										panel_BBU_RRU_UE.add(lable_blank);
									}
									{
										JLabel lblUe = new JLabel("UE����:");
										lblUe.setFont(MyTools.f15);
//										lblUe.setForeground(Color.white);
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
										
										JLabel lable_blank=new JLabel("  ");//�ո�
										panel_BBU_RRU_UE.add(lable_blank);
									}
								}
								
								panel_12 = new JPanel();
								panel_12.setOpaque(false);
								panel1.add(panel_12, BorderLayout.WEST);
								
								lblBbu = new JLabel("BBU����¼��");
								lblBbu.setFont(MyTools.f1);
								panel_12.add(lblBbu);
						//��2��
						{
							panel2_2_2 = new JPanel();
							panel2_2_2.setOpaque(false);
							panel2_2.add(panel2_2_2);
							panel2_2_2.setLayout(new GridLayout(1, 7, 0, 0));
								JLabel lblBbuid = new JLabel("BBU��ID", null, JLabel.CENTER);
								lblBbuid.setFont(MyTools.f15);
//								lblBbuid.setForeground(Color.white);
								panel2_2_2.add(lblBbuid);
								JLabel lblX = new JLabel("X����(m)", null, JLabel.CENTER);
								lblX.setFont(MyTools.f15);
//								lblX.setForeground(Color.white);
								panel2_2_2.add(lblX);
								JLabel lblY = new JLabel("Y����(m)", null, JLabel.CENTER);
								lblY.setFont(MyTools.f15);
//								lblY.setForeground(Color.white);
								panel2_2_2.add(lblY);
								JLabel lblZ = new JLabel("Z����(m)", null, JLabel.CENTER);
								lblZ.setFont(MyTools.f15);
//								lblZ.setForeground(Color.white);
								panel2_2_2.add(lblZ);
								JLabel label = new JLabel("��ע", null, JLabel.CENTER);
								label.setFont(MyTools.f15);
//								label.setForeground(Color.white);
								panel2_2_2.add(label);
							{
								JPanel panel_3 = new JPanel();
								panel_3.setOpaque(false);
								panel2_2_2.add(panel_3);
							}
							{
								JPanel panel_3 = new JPanel();
								panel_3.setOpaque(false);
								panel2_2_2.add(panel_3);
							}
							{
								JPanel panel_3 = new JPanel();
								panel_3.setOpaque(false);
								panel2_2_2.add(panel_3);
							}
						}
						//������
						{
							panel2_2_3 = new JPanel();
							panel2_2_3.setOpaque(false);
							panel2_2.add(panel2_2_3);
							panel2_2_3.setLayout(new GridLayout(1, 2, 0, 0));
							{
								panel5 = new JPanel();
								panel5.setOpaque(false);
								panel2_2_3.add(panel5);
								panel5.setLayout(new GridLayout(1, 4, 0, 0));
								{
									panel6 = new JPanel();
									panel6.setOpaque(false);
									panel5.add(panel6);
										textField_4 = new JTextField();
										panel6.add(textField_4);
										textField_4.setColumns(5);
								}
								{
									panel7 = new JPanel();
									panel7.setOpaque(false);
									panel5.add(panel7);
										textField_5 = new JTextField();
										panel7.add(textField_5);
										textField_5.setColumns(7);
								}
								{
									panel8 = new JPanel();
									panel8.setOpaque(false);
									panel5.add(panel8);
										textField_6 = new JTextField();
										panel8.add(textField_6);
										textField_6.setColumns(7);
								}
								{
									panel9 = new JPanel();
									panel9.setOpaque(false);
									panel5.add(panel9);
										textField_7 = new JTextField();
										panel9.add(textField_7);
										textField_7.setColumns(7);
								}
							}
							{
								panel2_3 = new JPanel();
								panel2_3.setOpaque(false);
								panel2_2_3.add(panel2_3);
								panel2_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
									textField_8 = new JTextField(20);
									panel2_3.add(textField_8);
									
							}
						}
						
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
						panel2_2.add(panel_4);
				}
//��ʾÿ��bbu�ض�Ӧbbu���б�
				{
					panel3_1 = new JPanel();
					panel3_1.setOpaque(false);
					panel2.add(panel3_1, BorderLayout.CENTER);
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
				}
			}
		}
		{
			String path_button="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"Add_BBU_RRU_UE_Bottom3.png";
			Image image_button=new ImageIcon(path_button).getImage(); 
			buttonPane= new BackgroundPanel(image_button);
//			buttonPane = new JPanel();
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
				show_bbupool_textfield(Bbupool_num);
	//bbu_panel��ʾbbu�ı��
				//bbu_table.clean_all();//bbu��JTable��գ���дBBU��JTable
				String sql1="select * from Bbu where BbuPoolId=?";//�ٴ�Bbu�е���bbu������		
				String []paras1={s[1]};
				bbu_table=new Bbu_table_module();
				bbu_table.bbu_table_search(sql1,paras1);
				bbu_searchrow=bbu_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�������������
				jt.setModel(bbu_table);

				
			}
			
		}
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		if(arg0.getSource()==button)//���//////////////////////////////////////////////////////////////////
		{
			
			bbu_add_rownum=bbu_add_rownum+1;//���������������ݵ�����
			
			bbu_table.addRows(bbu_add_rownum,textField_5.getText(),textField_6.getText(),textField_7.getText());
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
		else if(arg0.getSource()==button_1)//����///////////////////////////////////////////////////////////
		{
			if(bbu_add_rownum!=0)
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
					paras[6]=(String) bbu_table.getValueAt(i, 6);//RRU��Դ���ȵķ�ʽ
					paras[7]=(String) bbu_table.getValueAt(i, 4);//���书��dbm��ʽ
					paras[8]=null;//s�豸�ܺ�
					paras[9]=null;//bbu״̬�Ƿ��Ծ
					paras[10]=(String) bbu_table.getValueAt(i, 5);//��Դ��
					paras[11]=(String) bbu_table.getValueAt(i, 7);//���뻷
					String sql="exec Add_Bbu ?,?,?,?,?,?,?,?,?,?,?,?";//����Ҫһ��һ�е����exec Add_Bbu ?,?,?,?,?,?,?,?,?,?,?    insert into Bbu values(?,?,?,?,?,?,?,?,?,?,?)
					bbu_table.add_delete_change_to_sql(sql, paras);
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
				JOptionPane.showMessageDialog(this, "����ɹ�");//�����Ի���
				bbu_add_rownum=0;
			}
			

			}
		else if(arg0.getSource()==button_2)//ɾ��bbu//////////////////////////////////////////////////////////
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
					bbu_table.add_delete_change_to_sql(sql, paras);
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
					//ɾ���ɹ�
					JOptionPane.showMessageDialog(this, "ɾ���ɹ�");//�����Ի���
				}
			}
		}
		else if(arg0.getSource()==button_3)//�޸�//////////////////////////////////////////////////////////
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
		else if(arg0.getSource()==btnbbu_3)//ת��BBU��//////////////////////////////////////////////////////////
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
				bbu_table.add_delete_change_to_sql(sql,paras);
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
				//ɾ���ɹ�
				JOptionPane.showMessageDialog(this, "ת�Ƴɹ�");//�����Ի���
				
				}
			
			
		}
		else if(arg0.getSource()==btnbbu)//���bbu��//////////////////////////////////////////////////////////
		{
			//bbu����һ��һ����ӵģ������ݿ��������һ���µ�bbu������
			bbuc_table=new Bbu_table_module();
			
			//�ҵ�bbupool���ĵ�ǰID
			String sql1="exec RowMax ?";
			String []paras1={"BbuPool"};//�ҵ�bbupool���ĵ�ǰID
			Bbupool_maxid_model=new Bbu_table_module();
			ResultSet Bbu_maxid=Bbupool_maxid_model.total_num_sql(sql1, paras1);
			try {
				Bbu_maxid.next();
				bbu_max_id=Bbu_maxid.getInt(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			int temp_rru_num=bbu_max_id;
			String string_bbu_max_id=Integer.toString(bbu_max_id+1);//���ݿ���bbu����������ӵ�Ҫ+1
			//���bbu��
			String []paras=new String[9];
			paras[0]=string_bbu_max_id;//��ӵ�bbu�� id����������ѡ�е�bbupool��ID��Bbupool_num
			for(int i=1;i<=9;i++)//��Ϊbbu���ǵ�0�е���8��,��8���Ǳ�ע
			{
				paras[i]=null;
			}
			String sql="exec Add_BbuPool ?,?,?,?,?,?,?,?,?";
			bbuc_table.add_delete_change_to_sql(sql, paras);
			//ˢ����ʾbbu��������textfield
			String sql2="exec RowNum ?";
			String []paras2={"BbuPool"};
			String string_bbuc_num=Update_totalnum(sql2,paras2);////���������ݿ���bbu������
			lableBBUPool.setText(string_bbuc_num);
			
			Bbupool_num=string_bbu_max_id;
		
			show_bbupool_textfield(Bbupool_num);
			//ˢ�����νṹ
			panel_1.removeAll();
			panel_1.repaint();
			build_tree();
			
			//ˢ��չʾ�ı��
			String sql3="select * from Bbu where BbuPoolId=?";//�ٴ�Bbupool�е���bbu������		
			String []paras3={Bbupool_num};
			bbu_table=new Bbu_table_module();
			bbu_table.bbu_table_search(sql3,paras3);
			bbu_searchrow=bbu_table.getRowCount();//bbu����ѯ���ݿ⣬�Զ�����������������ǰbbupool�����Ӧ����bbu
			jt.setModel(bbu_table);
			
			

		}
		else if(arg0.getSource()==btnbbu_1)//����bbu��//////////////////////////////////////////////////////////
		{
			//��textfield���ݴ浽sql��
			String sql="update BbuPool set X=?,Y=?,Z=?,BbuPoolInfo=? where BbuPoolId=?";
			String []paras={textField_5.getText(),textField_6.getText(),textField_7.getText(),textField_8.getText(),textField_4.getText()};
			bbuc_table=new Bbu_table_module();
			bbuc_table.add_delete_change_to_sql(sql, paras);
			//ˢ��textfield
			JOptionPane.showMessageDialog(this,"����bbu�����ݳɹ�");
			return;
			
		}
		else if(arg0.getSource()==btnbbu_2)//ɾ��bbu��//////////////////////////////////////////////////////////
		{
			if(Bbupool_num.isEmpty())//����û�û��ѡ��һ��BBU��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��BBU��");
				return;
			}else
			{
				int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ��BBU��,��ͬʱɾ��BBU�������BBU", "", JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.NO_OPTION)
				{
					return;
				}
				if(a==JOptionPane.YES_OPTION)
				{
					delete_bbuc(Bbupool_num);//ѡ��BBUPOOL�ı��
				}
				
			}
			
		}
		else if(arg0.getSource()==cancelButton)//ȡ��//////////////////////////////////////////////////////////
		{
			this.dispose();//�رնԻ���
		}
		
	}
public void delete_bbuc(String tempBbupool_num)//ɾ��BBU�صĺ���//////////////////////
{
	
	String sql="exec Drop_BbuPool ?";
	String []paras={tempBbupool_num};
	bbu_table.add_delete_change_to_sql(sql, paras);
	//ˢ��bbu�ص�textfield
	textField_4.setText("");
	textField_5.setText("");
	textField_6.setText("");
	textField_7.setText("");
	textField_8.setText("");
	//ˢ��jtable
	bbu_table=new Bbu_table_module();
	jt.setModel(bbu_table);
	//ˢ����ʾbbu��������texrfield
	String sql2="exec RowNum ?";
	String []paras2={"BbuPool"};
	String string_bbuc_num=Update_totalnum(sql2,paras2);
	lableBBUPool.setText(string_bbuc_num);
	//ˢ����ʾbbu������texrfield
	String sql3="exec RowNum ?";
	String []paras3={"Bbu"};
	String string_bbu_num=Update_totalnum(sql3,paras3);
	lableBBU.setText(string_bbu_num);
	//ˢ�����νṹ
	panel_1.removeAll();
	panel_1.repaint();
	build_tree();
	//ɾ���ɹ�
	JOptionPane.showMessageDialog(this, "ɾ���ɹ�");//�����Ի���
}
//	@Override
//	public void valueChanged(ListSelectionEvent arg0) {
//		// TODO �Զ����ɵķ������
//		select_row_num= jt.getSelectedRows();
//	}
	public void build_tree()
	{
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
	public void show_bbupool_textfield(String Bbupool_num)//��ʾbbuPool��ID��X,Y,Z,���꣬��עtextfield�ĺ���
	{
		String sql="select * from BbuPool where BbuPoolId=?";//�ȴ�BbuPool�е�������		
		String []paras={Bbupool_num};
		bbuc.clean_all();//bbuc��JTable��գ���дBBUC��JTable
		bbuc.search_num(sql, paras,9);//�����Ҫ��ʾ���ݿ�BBUc��ǰ4�е�����
		textField_4.setText((String) bbuc.getValueAt(0, 0));
		textField_5.setText((String) bbuc.getValueAt(0, 1));
		textField_6.setText((String) bbuc.getValueAt(0, 2));
		textField_7.setText((String) bbuc.getValueAt(0, 3));
		textField_8.setText((String) bbuc.getValueAt(0, 8));
	}
	public String Update_totalnum(String sql,String[]paras)//���������ĺ���
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



}

