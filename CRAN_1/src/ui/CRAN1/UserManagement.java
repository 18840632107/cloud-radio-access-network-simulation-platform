package ui.CRAN1;

import java.awt.*;
import java.io.File;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.Add_bbu_rru_ue.Input2;
import ui.Share_bag.BBU_sql;
import ui.Share_bag.BackgroundPanel;
import ui.Share_bag.MyTools;

import java.awt.event.*;

public class UserManagement extends JDialog implements ActionListener,MouseListener{
	static String name = BBU_sql.name;
	static String passWord = BBU_sql.pswd;
	private final JPanel contentPanel = new JPanel();
	JSplitPane splitPane;
	JPanel panel1,panel2;
	private JPanel panel,panel_1,panel_2,panel_3;
	private JButton btnLogou,btnQuit;//ע�����˳�
	private JLabel lblNewLabel;
	private JPanel panel_4,panel_5,panel_6;
	JPanel jpanel_UserImage;
	private JPanel panel_7;
	private JLabel label;
	private JPanel panel_8;
	private JTabbedPane tabbedPane;
	JPanel jp1, jp2, jp3;
	private JPanel panel_10,panel_11,panel_13,panel_14,panel_15,panel_16,panel_17;
	private JLabel label_2,lblNewLabel_1,lblNewLabel_2;
	private JPanel panel_18,panel_19,panel_20,panel_21,panel_22;
	private JTextField textField_1,textField_2,textField_3;
	private JPanel panel_27,panel_28,panel_29,panel_30,panel_31;
	private JButton btnNewButton_6;
	private JPanel panel_32;
	private JButton btnNewButton_3;
	private JPanel panel_33,panel_34,panel_35,panel_36,panel_37;
	private JLabel lblNewLabel_3,lblNewLabel_4,lblNewLabel_5;
	private JPanel panel_38,panel_39,panel_40,panel_41,panel_42,panel_43,panel_44;
	String Account;//���ݿ⵱ǰ�˻�
	String caseName;//���ݿ⵱ǰʵ����
	String Password_current;//��ǰ�˻�����
	int Authority;//��ǰ�˻�Ȩ��
	File file_delete;
	boolean flag_file_Delete;
	JComboBox jcb4;
	Vector jg4=null;
	private JButton btnNewButton_4;
	private JPanel panel_45,panel_47,panel_48,panel_49,panel_50,panel_51,panel_52,panel_53,panel_54;
	private JPanel panel_55,panel_56,panel_57,panel_58,panel_59,panel_60;
	private JLabel lblNewLabel_7,lblNewLabel_8;
	private JButton btnNewButton;
	JButton btn_inputcase,btn_deletecase,btn_newcase;//���룬ɾ�����½�ʵ��
	private JPanel panel_23,panel_24,panel_25,panel_26;
	private JPanel panel_63,panel_64,panel_65,panel_66,panel_67,panel_68,panel_69,panel_70,panel_71;
	private JLabel lblNewLabel_9;
	private JTextField textField,textField_4;
	private JButton Button_security_update,Button_security_show;
	private JPanel panel_46,panel_72,panel_74,panel_75,panel_76;
	private JButton btn_Logoff;
	private JPanel panel_77,panel_78,panel_79,panel_80,panel_81,panel_82;
	private JButton btn_FindPassword,btn_right;
	UserTableModule user_table;
	JTable jt_user;
	JScrollPane scrollPane;
	JButton Button_password;
	Frame tuopu;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			UserManagement dialog = new UserManagement();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
public UserManagement(Frame owner,String title,boolean modal) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
//	public UserManagement() {
		tuopu= owner;
		setBounds(500, 200, 524, 352);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout());
		{
			//�ָ��ߣ��������ҽ���
			splitPane = new JSplitPane();
			splitPane.setDividerLocation(150);
			contentPanel.add(splitPane);
			{
				panel1 = new JPanel();
				splitPane.setLeftComponent(panel1);
				panel1.setLayout(new BorderLayout(0, 0));
				{
					panel = new JPanel();
					panel1.add(panel, BorderLayout.SOUTH);
					panel.setLayout(new GridLayout(2, 1, 0, 0));
					{
						panel_2 = new JPanel();
						panel.add(panel_2);
						panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
						{
							btnQuit = new JButton("�˳�");
							btnQuit.addActionListener(this);
							panel_2.add(btnQuit);
						}
					}
				}
				{
					panel_3 = new JPanel();
					panel1.add(panel_3, BorderLayout.NORTH);
					{
						//��ȡ���ݿ�CurrentUser��������
						String sql="select userName,caseName from CurrentUser where ID=?";
						String []paras={"1"};
						BBU_sql sql_case=new BBU_sql();
						ResultSet sql_case_ResultSet=sql_case.search(sql, paras);
						try {
							sql_case_ResultSet.next();
							Account=sql_case_ResultSet.getString(1).trim();
							caseName=sql_case_ResultSet.getString(2).trim();//��ǰʵ������
						} catch (Exception e) {
							// TODO: handle exception
						}
						lblNewLabel = new JLabel(Account);
						lblNewLabel.setFont(MyTools.f1);
						panel_3.add(lblNewLabel);
					}
				}
				{
					panel_4 = new JPanel();
					panel1.add(panel_4, BorderLayout.WEST);
				}
				{
					panel_5 = new JPanel();
					panel1.add(panel_5, BorderLayout.EAST);
				}
				{
					panel_6 = new JPanel();
					panel_6.setLayout(null);
//Ϊ������û�ͷ���趨ָ����Сpanel��128��128
					jpanel_UserImage=new JPanel();
					jpanel_UserImage.setLocation(0, 0);
					jpanel_UserImage.setSize(128,128);
//					jpanel_UserImage.setBackground(Color.GRAY);
					JLabel lableImage=new JLabel();
					jpanel_UserImage.add(lableImage, BorderLayout.CENTER);
					String path="image"+File.separator+"Login_Management"+File.separator+"user2.png";
					Icon icon = new ImageIcon(path);
					lableImage.setIcon(icon);
					panel_6.add(jpanel_UserImage);
					panel1.add(panel_6, BorderLayout.CENTER);
				}
				{
					
				}
			}
			{
//				String path_2="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"Add_BBU_RRU_UE_Right3.png";
//				Image image_2=new ImageIcon(path_2).getImage(); 
//				panel2= new BackgroundPanel(image_2);
				panel2 = new JPanel();
				splitPane.setRightComponent(panel2);
				panel2.setLayout(new BorderLayout(0, 0));
				{
					panel_7 = new JPanel();
					panel2.add(panel_7, BorderLayout.NORTH);
					panel_7.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					{
						label = new JLabel("��������");
						label.setFont(MyTools.f1);
						panel_7.add(label);
					}
				}
				{
					panel_8 = new JPanel();
					panel2.add(panel_8, BorderLayout.SOUTH);
				}
				{
					tabbedPane = new JTabbedPane(JTabbedPane.TOP);
					jp1=new JPanel();
					jp2=new JPanel();
					{
						panel_54 = new JPanel();
					}
					tabbedPane.add("�����޸�",jp2);
					jp2.setLayout(new BorderLayout(0, 0));
					{
						panel_10 = new JPanel();
						jp2.add(panel_10, BorderLayout.EAST);
					}
					{
						panel_11 = new JPanel();
						jp2.add(panel_11, BorderLayout.SOUTH);
						panel_11.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
						
						Button_password = new JButton("ȷ��");
						Button_password.addActionListener(this);
						panel_11.add(Button_password);
					}
					
					JPanel panel_9 = new JPanel();
					jp2.add(panel_9, BorderLayout.WEST);
					panel_9.setLayout(new GridLayout(5, 1, 0, 0));
					{
						panel_13 = new JPanel();
						panel_9.add(panel_13);
						panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					}
					{
						panel_14 = new JPanel();
						panel_9.add(panel_14);
						panel_14.setLayout(new BorderLayout(0, 0));
						{
							label_2 = new JLabel("      �����룺");
							panel_14.add(label_2, BorderLayout.EAST);
						}
					}
					{
						panel_15 = new JPanel();
						panel_9.add(panel_15);
						panel_15.setLayout(new BorderLayout(0, 0));
						{
							lblNewLabel_1 = new JLabel("      �����룺");
							panel_15.add(lblNewLabel_1, BorderLayout.EAST);
						}
					}
					{
						panel_16 = new JPanel();
						panel_9.add(panel_16);
						panel_16.setLayout(new BorderLayout(0, 0));
						{
							lblNewLabel_2 = new JLabel(" ȷ�������룺");
							panel_16.add(lblNewLabel_2, BorderLayout.EAST);
						}
					}
					{
						panel_17 = new JPanel();
						panel_9.add(panel_17);
					}
					
					JPanel panel_12 = new JPanel();
					jp2.add(panel_12, BorderLayout.CENTER);
					panel_12.setLayout(new GridLayout(5, 1, 0, 0));
					{
						panel_18 = new JPanel();
						panel_12.add(panel_18);
					}
					{
						panel_19 = new JPanel();
						panel_12.add(panel_19);
						panel_19.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
						{
							String sql="select passWord,authority from PUser where userName=?";
							String []paras={Account};
							BBU_sql sql_case=new BBU_sql();
							ResultSet sql_case_ResultSet=sql_case.search(sql, paras);
							try {
								sql_case_ResultSet.next();
								Password_current=sql_case_ResultSet.getString(1).trim();//��ǰʵ������
								Authority=sql_case_ResultSet.getInt(2);//��ǰʵ��Ȩ��
							} catch (Exception e) {
								// TODO: handle exception
							}
							textField_1 = new JTextField();
							textField_1.setText(Password_current);
							panel_19.add(textField_1);
							textField_1.setColumns(16);
						}
					}
					{
						panel_21 = new JPanel();
						panel_12.add(panel_21);
						panel_21.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
						{
							textField_2 = new JTextField();
							panel_21.add(textField_2);
							textField_2.setColumns(16);
						}
					}
					{
						panel_20 = new JPanel();
						panel_12.add(panel_20);
						panel_20.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
						{
							textField_3 = new JTextField();
							panel_20.add(textField_3);
							textField_3.setColumns(16);
						}
					}
					{
						panel_22 = new JPanel();
						panel_12.add(panel_22);
						panel_22.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					}
					{
						
					}
					panel2.add(tabbedPane, BorderLayout.CENTER);
					{
						panel_23 = new JPanel();
						tabbedPane.addTab("�ܱ�����", null, panel_23, null);
						panel_23.setLayout(new BorderLayout(0, 0));
						{
							panel_25 = new JPanel();
							panel_23.add(panel_25, BorderLayout.NORTH);
						}
						{
							panel_26 = new JPanel();
							panel_23.add(panel_26, BorderLayout.WEST);
							panel_26.setLayout(new GridLayout(6, 1, 0, 0));
							
							JPanel panel_61 = new JPanel();
							panel_26.add(panel_61);
							{
								panel_63 = new JPanel();
								panel_26.add(panel_63);
							}
							{
								panel_64 = new JPanel();
								panel_26.add(panel_64);
								panel_64.setLayout(new BorderLayout(0, 0));
								{
									lblNewLabel_9 = new JLabel("     �ܱ����⣺");
									panel_64.add(lblNewLabel_9, BorderLayout.EAST);
								}
							}
							{
								panel_65 = new JPanel();
								panel_26.add(panel_65);
								panel_65.setLayout(new BorderLayout(0, 0));
								
								JLabel lblNewLabel_10 = new JLabel("     �ܱ��𰸣�");
								panel_65.add(lblNewLabel_10, BorderLayout.EAST);
							}
							{
								panel_66 = new JPanel();
								panel_26.add(panel_66);
							}
						}
						
						JPanel panel_61 = new JPanel();
						panel_23.add(panel_61, BorderLayout.SOUTH);
						
						JPanel panel_62 = new JPanel();
						panel_23.add(panel_62, BorderLayout.CENTER);
						panel_62.setLayout(new GridLayout(6, 1, 0, 0));
						{
							panel_67 = new JPanel();
							panel_62.add(panel_67);
						}
						{
							panel_68 = new JPanel();
							panel_62.add(panel_68);
						}
						{
							panel_69 = new JPanel();
							panel_62.add(panel_69);
							
							textField = new JTextField();
							panel_69.add(textField);
							textField.setColumns(16);
						}
						{
							panel_70 = new JPanel();
							panel_62.add(panel_70);
							
							textField_4 = new JTextField();
							panel_70.add(textField_4);
							textField_4.setColumns(16);
						}
						{
							panel_71 = new JPanel();
							panel_62.add(panel_71);
							panel_71.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
							{
								Button_security_show = new JButton("��ʾ��ǰ�ܱ�����");
								Button_security_show.addActionListener(this);
								panel_71.add(Button_security_show);
							}
						}
						{
							panel_46 = new JPanel();
							panel_62.add(panel_46);
							panel_46.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
							{
								Button_security_update = new JButton("�����ܱ�����");
								Button_security_update.addActionListener(this);
								panel_46.add(Button_security_update);
							}
						}
					}
					if(Authority==1)//����ԱȨ��
					{
						{
							panel_24 = new JPanel();
							tabbedPane.addTab("�û�����", null, panel_24, null);
							panel_24.setLayout(new BorderLayout(0, 0));
							{
								panel_72 = new JPanel();
								panel_24.add(panel_72, BorderLayout.SOUTH);
								panel_72.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
							}
							{
								panel_74 = new JPanel();
								panel_24.add(panel_74, BorderLayout.WEST);
							}
							{
								panel_75 = new JPanel();
								panel_24.add(panel_75, BorderLayout.EAST);
								panel_75.setLayout(new GridLayout(6, 1, 0, 0));
								{
									panel_77 = new JPanel();
									panel_75.add(panel_77);
								}
								{
									panel_78 = new JPanel();
									panel_75.add(panel_78);
									panel_78.setLayout(new BorderLayout(0, 0));
									{
										btn_FindPassword = new JButton("�һ�����");
										btn_FindPassword.addActionListener(this);
										panel_78.add(btn_FindPassword);
									}
								}
								{
									panel_80 = new JPanel();
									panel_75.add(panel_80);
									panel_80.setLayout(new BorderLayout(0, 0));
									{
										btn_right = new JButton("����Ȩ��");
										btn_right.addActionListener(this);
										panel_80.add(btn_right);
									}
								}
								{
									panel_81 = new JPanel();
									panel_75.add(panel_81);
									panel_81.setLayout(new BorderLayout(0, 0));
									{
										btn_Logoff = new JButton("ע���û�");
										btn_Logoff.addActionListener(this);
										panel_81.add(btn_Logoff);
									}
								}
								{
									panel_79 = new JPanel();
									panel_75.add(panel_79);
								}
								{
									panel_82 = new JPanel();
									panel_75.add(panel_82);
								}
							}
							{
								panel_76 = new JPanel();
								panel_24.add(panel_76, BorderLayout.CENTER);
								panel_76.setLayout(new BorderLayout(0, 0));
								//bbu_panel��ʾBBU����
								user_table=new UserTableModule();
								jt_user=new JTable(user_table);
								
								jt_user.addMouseListener(this);
								//JTable�ı�����ɫ����
								jt_user.setBackground(new Color(240, 245, 250));

								jt_user.setRowHeight(20);//�޸ı����
								//��ñ�ͷ
								JTableHeader tableH = jt_user.getTableHeader();
								tableH.setFont(MyTools.f12);
								tableH.setBackground(new Color(204, 208, 213));
								  
								DefaultTableCellRenderer r =   new   DefaultTableCellRenderer();   
								r.setHorizontalAlignment(JLabel.CENTER);   
								r.setFont(MyTools.f12);
								jt_user.setDefaultRenderer(Object.class,r);
								
								jt_user.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								scrollPane = new JScrollPane(jt_user);
								scrollPane.getViewport().setBackground(Color.white);
								panel_76.add(scrollPane, BorderLayout.CENTER);
								//ˢ��չʾ�ı��
								String sql2="select * from PUser where 1=?";//�ٴ�PUser�е�����ӵ�����	
								String []paras2={"1"};//������ʾ���е�UeGroup  
								user_table=new UserTableModule();
								user_table.user_table_search(sql2,paras2);
								jt_user.setModel(user_table);
							}
						}
					}else if(Authority==0)//��ͨ�û�Ȩ��
					{
						
					}
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
//		if(arg0.getSource()==btnLogou)//ע��
//		{
//			int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ע�����˺�", "", JOptionPane.YES_NO_OPTION);
//			if(a==JOptionPane.NO_OPTION)
//			{
//				return;
//			}
//			if(a==JOptionPane.YES_OPTION)//ע���˺�
//			{
//				boolean flage;
//				//CurrentUser������˳�
//				String sql="update CurrentUser set userName=?,caseID=?,caseNum=?,LoginOrNot=? where ID=?";	
//				String []paras={"-1","-1","-1","0","1"};
//				BBU_sql sqlh=new BBU_sql();
//				sqlh.add_delete_change(sql, paras);
//				//PUser���ע��
//				String sql1="exec Drop_User ?";	
//				String []paras1={Account};
//				BBU_sql sql_Logout=new BBU_sql();
//				flage=sql_Logout.add_delete_change(sql1, paras1);
//				if(flage==true)
//				{
//					//ɾ��Ĭ��·���¸��˻���Ӧ�ļ���
//					String workspaceRootPath="D:\\CRAN\\"+Account;
//					System.out.println(workspaceRootPath);
//					File file = new File(workspaceRootPath);  
//					boolean success = deleteDir(file);
//					if (success) {
//			            System.out.println("Successfully deleted populated directory: " );
//			        } else {
//			            System.out.println("Failed to delete populated directory: " );
//			        }   
//					//��ʾ
//					JOptionPane.showMessageDialog(this,"ע���ɹ�");
//					this.dispose();
//				}else if(flage==false)
//				{
//					//��ʾ
//					JOptionPane.showMessageDialog(this,"ע��ʧ��");
//					this.dispose();
//				}
//			}
//		}
		if(arg0.getSource()==btnQuit)//�˳��˻�
		{
			int b=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���˳����˺�", "", JOptionPane.YES_NO_OPTION);
			if(b==JOptionPane.NO_OPTION)
			{
				return;
			}
			if(b==JOptionPane.YES_OPTION)//�˳��˺�
			{
				int a=JOptionPane.showConfirmDialog(null, "�Ƿ񱣴浱ǰʵ��", "", JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.YES_OPTION)//���浱ǰʵ����Ϣ�����ݿ�-----�ļ���
				{
					//�������ݿ�ı���ļ���
					Save_DatebaseToFile_forAccount();
				}
				//������ݿ���������--------------Ĭ���˳�ʱ��������ݿ�
				ClearDatebase_forAccount();
				//CurrentUser����˳�
				boolean flage;
				String sql="update CurrentUser set userName=?,caseName=? where ID=?";	
				String []paras={"-1","-1","1"};
				BBU_sql sqlh=new BBU_sql();
				flage=sqlh.add_delete_change(sql, paras);
				if(flage==true)
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"�˳��ɹ�");
					this.dispose();

					tuopu.setVisible(false);
					Login dialog = new Login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				}else if(flage==false)
				{
					JOptionPane.showMessageDialog(this,"�˳�ʧ��");
					return;
				}
			}
		}
		else if(arg0.getSource()==Button_password)//�����޸�
		{
			if(textField_2.getText().length()==0)
			{
				JOptionPane.showMessageDialog(this,"����д������");
				return;
			}
			else if(textField_3.getText().length()==0)
			{
				JOptionPane.showMessageDialog(this,"����д������ȷ��");
				return;
			}else if(!textField_3.getText().equals(textField_2.getText()))
			{
				JOptionPane.showMessageDialog(this,"�������������벻һ�£�����������");
				return;
			}else//�������ݿ�
			{
				int b=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���޸�����", "", JOptionPane.YES_NO_OPTION);
				if(b==JOptionPane.NO_OPTION)
				{
					return;
				}
				if(b==JOptionPane.YES_OPTION)//�޸�����
				{
					//��������
					boolean flage=true;
					String new_password=textField_2.getText();
					String sql="update PUser set passWord=? where userName=?";
					String []paras={new_password,Account};
					BBU_sql sqlh=new BBU_sql();
					flage=sqlh.add_delete_change(sql, paras);
					//���¶�ȡ������
					String sql2="select passWord from PUser where userName=?";
					String []paras2={Account};
					BBU_sql sql_case=new BBU_sql();
					ResultSet sql_case_ResultSet=sql_case.search(sql2, paras2);
					
					try {
						sql_case_ResultSet.next();
						Password_current=sql_case_ResultSet.getString(1).trim();//��ǰʵ������
					} catch (Exception e) {
						// TODO: handle exception
					}
					textField_1.setText(Password_current);
					//����ˢ��
					textField_2.setText("");;
					textField_3.setText("");;
					if(flage==true)
					{
						JOptionPane.showMessageDialog(this, "�޸�����ɹ�");//�����Ի���
						return;
					}else
					{
						JOptionPane.showMessageDialog(this, "�޸�����ʧ��");//�����Ի���
						return;
					}

					
					
				}
			}
		}
		else if(arg0.getSource()==Button_security_show)//��ʾ��ǰ�ܱ�����
		{
			String security1 = null,security2=null;
			String sql="select security1,security2 from PUser where userName=?";
			String []paras={Account};
			BBU_sql sql_case=new BBU_sql();
			ResultSet sql_case_ResultSet=sql_case.search(sql, paras);
			try {
				sql_case_ResultSet.next();
				security1=sql_case_ResultSet.getString(1).trim();//�ܱ�����
				security2=sql_case_ResultSet.getString(2).trim();//�ܱ���
			} catch (Exception e) {
				// TODO: handle exception
			}
			textField.setText(security1);
			textField_4.setText(security2);
		}
		else if(arg0.getSource()==Button_security_update)//�����ܱ�����
		{
			String security1 = textField.getText().trim();
			String security2 = textField_4.getText().trim();
			boolean flage=true;
			if(security1.length()==0)
			{
				JOptionPane.showMessageDialog(this, "�ܱ����ⲻ��Ϊ��");//�����Ի���
				return;
			}
			else if(security2.length()==0)
			{
				JOptionPane.showMessageDialog(this, "�ܱ��𰸲���Ϊ��");//�����Ի���
				return;
			}else{
				String sql="update PUser set security1=?,security2=? where userName=?";
				String []paras={security1,security2,Account};
				BBU_sql sqlh=new BBU_sql();
				flage=sqlh.add_delete_change(sql, paras);
				if(flage==true)
				{
					JOptionPane.showMessageDialog(this, "�����ܱ��ɹ�");//�����Ի���
					return;
				}else
				{
					JOptionPane.showMessageDialog(this, "�����ܱ�ʧ��");//�����Ի���
					return;
				}
			}
		}
		else if(arg0.getSource()==btn_FindPassword)//�һ�����
		{
			int rowNum_selected=jt_user.getSelectedRow();//�����û����е���
			if(rowNum_selected==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			else{
				//�һ�����
				String name=(String) user_table.getValueAt(rowNum_selected, 0);
				String Find_Password="�һ�ʧ��";
				String sql="select passWord from PUser where userName=?";
				String []paras={name};
				BBU_sql sql_case=new BBU_sql();
				ResultSet sql_case_ResultSet=sql_case.search(sql, paras);
				try {
					sql_case_ResultSet.next();
					Find_Password=sql_case_ResultSet.getString(1).trim();//�һ�����
				} catch (Exception e) {
					// TODO: handle exception
				}
				JOptionPane.showMessageDialog(this,"�����ǣ�"+Find_Password);
				return;
			}
		}
		else if(arg0.getSource()==btn_right)//����Ȩ��
		{
			int rowNum_selected=jt_user.getSelectedRow();//�����û����е���
			if(rowNum_selected==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			else{
				//����Ȩ��
				String Name=(String) user_table.getValueAt(rowNum_selected, 0);
				String Right=(String) user_table.getValueAt(rowNum_selected, 1);
				if(Right.equals("1"))//����Ա
				{
					int a=JOptionPane.showConfirmDialog(null, "��ǰΪ����Ա���Ƿ񽵼�Ϊ��ͨ�û���", "", JOptionPane.YES_NO_OPTION);
					if(a==JOptionPane.NO_OPTION)
					{
						return;
					}
					if(a==JOptionPane.YES_OPTION)//����
					{
						//�޸�
						boolean flage=true;
						String sql="update PUser set authority=? where userName=?";
						String []paras={"0",Name};
						BBU_sql sqlh=new BBU_sql();
						flage=sqlh.add_delete_change(sql, paras);
						if(flage==true)
						{
							//ˢ��չʾ�ı��
							String sql2="select * from PUser where 1=?";//�ٴ�PUser�е�����ӵ�����	
							String []paras2={"1"};//������ʾ���е�UeGroup  
							user_table=new UserTableModule();
							user_table.user_table_search(sql2,paras2);
							jt_user.setModel(user_table);
							JOptionPane.showMessageDialog(this, "Ȩ���޸ĳɹ�");//�����Ի���
							return;
						}else
						{
							JOptionPane.showMessageDialog(this, "Ȩ���޸�ʧ��");//�����Ի���
							return;
						}
					}
					
				}else if(Right.equals("0"))//��ͨ�û�
				{
					int a=JOptionPane.showConfirmDialog(null, "��ǰΪ��ͨ�û����Ƿ�����Ϊ����Ա��", "", JOptionPane.YES_NO_OPTION);
					if(a==JOptionPane.NO_OPTION)
					{
						return;
					}
					if(a==JOptionPane.YES_OPTION)//����
					{
						boolean flage=true;
						String sql="update PUser set authority=? where userName=?";
						String []paras={"1",Name};
						BBU_sql sqlh=new BBU_sql();
						flage=sqlh.add_delete_change(sql, paras);
						if(flage==true)
						{
							//ˢ��չʾ�ı��
							String sql2="select * from PUser where 1=?";//�ٴ�PUser�е�����ӵ�����	
							String []paras2={"1"};//������ʾ���е�UeGroup  
							user_table=new UserTableModule();
							user_table.user_table_search(sql2,paras2);
							jt_user.setModel(user_table);
							JOptionPane.showMessageDialog(this, "Ȩ���޸ĳɹ�");//�����Ի���
							return;
						}else
						{
							JOptionPane.showMessageDialog(this, "Ȩ���޸�ʧ��");//�����Ի���
							return;
						}
					}
				}
			}
		}
		else if(arg0.getSource()==btn_Logoff)//ע���˺�
		{
			int rowNum_selected=jt_user.getSelectedRow();//�����û����е���
			if(rowNum_selected==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			else{
				int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ע��ʵ����", "", JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.NO_OPTION)
				{
					return;
				}
				if(a==JOptionPane.YES_OPTION)//ע��ʵ��
				{
					String Name=(String) user_table.getValueAt(rowNum_selected, 0);
					Name=Name.trim();
					if(Name.equals(Account))
					{
						System.out.println(Name);
						System.out.println(Account);
						JOptionPane.showMessageDialog(this, "���˺ŵ�ǰ����ʹ�ã�����ע���������˳���");//�����Ի���
						return;
					}
					else
					{
						//ע�����ݿ�PUser---�����ʾ
						String sql1="delete  from PUser where  userName=?;";	
						String []paras1={Name};
						BBU_sql sql_Logout=new BBU_sql();
						sql_Logout.add_delete_change(sql1, paras1);
						//ˢ��չʾ�ı��
						String sql2="select * from PUser where 1=?";//�ٴ�PUser�е�����ӵ�����	
						String []paras2={"1"};//������ʾ���е�UeGroup  
						user_table=new UserTableModule();
						user_table.user_table_search(sql2,paras2);
						jt_user.setModel(user_table);
						//ɾ���洢�ļ�
						String workspaceRootPath="D:\\CRAN\\"+Name.trim();
						File file = new File(workspaceRootPath);  
						boolean success = deleteDir(file);
						if (success) {
				            System.out.println("Successfully deleted populated directory: " );
				            JOptionPane.showMessageDialog(this,"ע���ɹ�");
							return;
				        } else {
				            System.out.println("Failed to delete populated directory: " );
				            JOptionPane.showMessageDialog(this,"ע��ʧ��");
				            return;
				        }   
					}
				}
			}
		}
		
	}
	//�˻��˳�ʱ��������ݿ⺯��
	private void ClearDatebase_forAccount() {
		// TODO �Զ����ɵķ������
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, passWord);
             conn.setAutoCommit(true);
             Statement stmt = conn.createStatement();
             String sql_drop = "exec Drop_All_forAccount";
			stmt.executeUpdate(sql_drop);
		
		}catch(SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			}
	}

	private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //�ݹ�ɾ��Ŀ¼�е���Ŀ¼��
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }else if(success)
                {
                	return true;
                }
            }
        }
        // Ŀ¼��ʱΪ�գ�����ɾ��
        return dir.delete();
    }  
	private void CreatFile( String Path) {
		// TODO �Զ����ɵķ������
//		String directory = "D:\\CRAN\\"+Account+"\\"+Case_Name;
		String directory = Path;
		File f = new File(directory);
		if(f.exists()) {
			  // �ļ��Ѿ����ڣ�����ļ��������Ϣ
		}
		else
		{            
			f.mkdirs();//�����ļ����ڵ�Ŀ¼   
		}
		
	}
	private void Save_DatebaseToFile_forAccount()//�������ݿ�ı���ļ���----�����˻��л�
	{
		if(caseName.equals("-1"))//�½���ʵ��
		{
			//����PCase�˻���Ӧ��ʵ�����
			String Name=(String) JOptionPane.showInputDialog(null,"����ʵ������:","title",JOptionPane.PLAIN_MESSAGE,null,null,""); 
			if(Name == null)
            {
               return;
            }
           if (Name.equals("") )
           {
              JOptionPane.showMessageDialog(null,"δ���뱣��ʵ�����ƣ�����ʧ��","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
               return;
           }
			String Remark=(String) JOptionPane.showInputDialog(null,"����ʵ����ע:","title",JOptionPane.PLAIN_MESSAGE,null,null,""); 
			if(Remark == null)
            {
               return;
            }
			//�����µ��˻�����
			String sql_add="insert into PCase values(?,?)";
			String []paras_add={Name.trim(),Remark.trim()};
			BBU_sql sqlh1=new BBU_sql();
			sqlh1.add_delete_change(sql_add, paras_add);
			
			//Ĭ��·�����½�ʵ���ļ���
			String Path = "D:\\CRAN\\"+Account.trim()+"\\"+Name.trim();
			System.out.println(Path);
			CreatFile(Path);//�����ļ���
			Output.oneKeyOutput(Path);//��ǰ���ݿ⵼�����ļ���
			
			String Path2 = "D:\\CRAN\\"+Account.trim();
			Output.caseOutput(Path2);
		}
		else{
			File file=new File("D:\\CRAN\\"+Account.trim()+"\\"+caseName.trim());
			if(file.exists())//��ȥ��ʵ������ʵ���ļ���
			{
				//��ǰ���ݿ⵼�����ļ���
				String Path = "D:\\CRAN\\"+Account.trim()+"\\"+caseName.trim();
				Output.oneKeyOutput(Path);
				
				String Path2 = "D:\\CRAN\\"+Account.trim();
				Output.caseOutput(Path2);
			}else
			{
				//Ĭ��·�����½�ʵ���ļ���
				String Path = "D:\\CRAN\\"+Account.trim()+"\\"+caseName.trim();
				CreatFile(Path);//temp�½�ʵ��������=��ǰʵ������+1
				//��ǰ���ݿ⵼�����ļ���
				Output.oneKeyOutput(Path);
				
				String Path2 = "D:\\CRAN\\"+Account.trim();
				Output.caseOutput(Path2);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
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
