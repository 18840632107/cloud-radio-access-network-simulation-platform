package ui.CRAN1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;

import ui.Add_bbu_rru_ue.Input2;
import ui.Share_bag.BBU_sql;
import ui.Share_bag.MyTools;

import javax.swing.JTextField;

public class CaseManage extends JDialog implements ActionListener,MouseListener{
	static String name = BBU_sql.name;
	static String passWord = BBU_sql.pswd;
	private final JPanel contentPanel = new JPanel();
	JButton button_new,Button_modify,Button_delete,Button_import,Button_search,Button_all;
	private JTextField textField;
	private JPanel panel_2;
	CaseTableModule case_table;
	JTable jt_case;
	JScrollPane scrollPaneCase;
	String caseName; //��ǰʵ������
	String Account;//��ǰ�˻�����
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CaseManage dialog = new CaseManage();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
//	public CaseManage() {
	public CaseManage(Frame owner,String title,boolean modal) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
		setBounds(100, 100, 613, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			{
				JLabel label = new JLabel("ʵ������");
				label.setFont(MyTools.f1);
				panel.add(label);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			{
				button_new = new JButton("�½�");
				button_new.addActionListener(this);
				panel.add(button_new);
			}
			{
				Button_modify = new JButton("�޸�");
				Button_modify.addActionListener(this);
				panel.add(Button_modify);
			}
			{
				Button_delete = new JButton("ɾ��");
				Button_delete.addActionListener(this);
				panel.add(Button_delete);
			}
			{
				Button_import = new JButton("����ʵ��");
				Button_import.addActionListener(this);
				panel.add(Button_import);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					JLabel lblNewLabel = new JLabel("ʵ������");
					panel_1.add(lblNewLabel);
				}
				{
					textField = new JTextField();//��ѯtextfield
					panel_1.add(textField);
					textField.setColumns(16);
				}
				{
					Button_search = new JButton("��ѯ");
					Button_search.addActionListener(this);
					panel_1.add(Button_search);
				}
				{
					Button_all = new JButton("ȫ����ʾ");
					Button_all.addActionListener(this);
					panel_1.add(Button_all);
				}
			}
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
			{
				panel_2 = new JPanel();
				panel.add(panel_2);
				panel_2.setLayout(new BorderLayout(0, 0));
				case_table=new CaseTableModule();
				jt_case=new JTable(case_table);
				jt_case.addMouseListener(this);
				jt_case.setBackground(new Color(240, 245, 250));//JTable�ı�����ɫ����
				jt_case.setRowHeight(20);//�޸ı����
				jt_case.getColumnModel().getColumn(0).setPreferredWidth(10);
				//��ñ�ͷ
				JTableHeader tableH = jt_case.getTableHeader();
				tableH.setFont(MyTools.f12);
				tableH.setBackground(new Color(204, 208, 213));
				  
				DefaultTableCellRenderer r =   new   DefaultTableCellRenderer();   
				r.setHorizontalAlignment(JLabel.CENTER);   
				r.setFont(MyTools.f12);
				jt_case.setDefaultRenderer(Object.class,r);
				
				jt_case.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
				scrollPaneCase = new JScrollPane(jt_case);
				scrollPaneCase.getViewport().setBackground(Color.white);
				panel_2.add(scrollPaneCase, BorderLayout.CENTER);
				//ˢ��չʾ�ı��PCase
				String sql2="select * from PCase where 1=?";//�ٴ�PCase�е�������	
				String []paras2={"1"};//������ʾ���е�UeGroup  
				case_table=new CaseTableModule();
				case_table.case_table_search(sql2,paras2);
				jt_case.setModel(case_table);
			}
			
			

		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		if(arg0.getSource()==button_new)//�½�
		{
			int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���½�ʵ����", "", JOptionPane.YES_NO_OPTION);
			if(a==JOptionPane.NO_OPTION)
			{
				return;
			}
			if(a==JOptionPane.YES_OPTION)//�½�ʵ��
			{
				int b=JOptionPane.showConfirmDialog(null, "�Ƿ񱣴浱ǰʵ��?", "", JOptionPane.YES_NO_OPTION);
				if(b==JOptionPane.YES_OPTION)//���浱ǰʵ����Ϣ�����ݿ�-----�ļ���
				{
					//�������ݿ�ı���ļ���
					Save_DatebaseToFile();
				}
				//�½�ʵ��
				new NewCase(this,"�½�ʵ��", true).setVisible(true);
				//����ʵ�����
				String sql2="select * from PCase where 1=?";//�ٴ�PCase�е�������	
				String []paras2={"1"};//������ʾ���е�UeGroup  
				case_table=new CaseTableModule();
				case_table.case_table_search(sql2,paras2);
				jt_case.setModel(case_table);
				//��ȡ���ݿ�CurrentUser��������
				String sql="select caseName from CurrentUser where ID=?";
				String []paras={"1"};
				BBU_sql sql_case=new BBU_sql();
				ResultSet sql_case_ResultSet=sql_case.search(sql, paras);
				try {
					sql_case_ResultSet.next();
					caseName=sql_case_ResultSet.getString(1).trim();//��ǰʵ������
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}
		else if(arg0.getSource()==Button_modify)//�޸�
		{
			int rowNum_selected=jt_case.getSelectedRow();//�����û����е���
			if(rowNum_selected==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			else{
				int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���޸�ʵ����", "", JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.NO_OPTION)
				{
					return;
				}
				if(a==JOptionPane.YES_OPTION)//�޸�ʵ��
				{
					//�޸�ʵ��
					new ModifyCase(this,"�޸�ʵ��", true,case_table,rowNum_selected).setVisible(true);
					//����ʵ�����
					String sql2="select * from PCase where 1=?";//�ٴ�PCase�е�������	
					String []paras2={"1"};//������ʾ���е�UeGroup  
					case_table=new CaseTableModule();
					case_table.case_table_search(sql2,paras2);
					jt_case.setModel(case_table);
				}
			}
		}
		else if(arg0.getSource()==Button_delete)//ɾ��
		{
			int rowNum_selected=jt_case.getSelectedRow();//�����û����е���
			if(rowNum_selected==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			else{
					String name=(String) jt_case.getValueAt(rowNum_selected, 0);//ʵ������
					//�鿴Ҫɾ����ʵ�������Ƿ��ǵ�ǰ����ʹ�õ�ʵ������
					String sql="select caseName from CurrentUser where ID=?";
					String []paras={"1"};
					BBU_sql sql_case=new BBU_sql();
					ResultSet sql_case_ResultSet=sql_case.search(sql, paras);
					try {
						sql_case_ResultSet.next();
						caseName=sql_case_ResultSet.getString(1).trim();//��ǰʵ������
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(name.equals(caseName))//������ɾ��
					{
						//��ʾ
						JOptionPane.showMessageDialog(this,"ʵ������ʹ�ã�����ɾ�������ȵ�������ʵ����");
						return;
					}else//����ɾ��
					{
						int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ��ʵ����", "", JOptionPane.YES_NO_OPTION);
						if(a==JOptionPane.NO_OPTION)
						{
							return;
						}
						if(a==JOptionPane.YES_OPTION)//ɾ��ʵ��
						{
							boolean b=true;
							//�����ݿ�---�洢�ļ�����
							
							//��ʵ�����Ĳ���
							String sql1="delete from PCase where caseName=?";
							String []paras1={name};
							b=case_table.add_delete_change_to_sql(sql1, paras1);
							if(b==true)
							{
								//ɾ��Ĭ��·���¸��˻���Ӧ�ļ���
								String workspaceRootPath="D:\\CRAN\\"+Account+"\\"+name.trim();
//								System.out.println(workspaceRootPath);
								File file = new File(workspaceRootPath);  
								boolean success = deleteDir(file);
								if (success) {
						            System.out.println("ɾ��ʵ���ļ��ɹ�" );
						        } else {
						            System.out.println("ɾ��ʵ���ļ�ʧ��" );
						        }   
							}else
							{
								JOptionPane.showMessageDialog(this, "ɾ��ʵ��ʧ��");//�����Ի���
							}
							//ˢ�±��
							String sql2="select * from PCase where 1=?";//�ٴ�PCase�е�������	
							String []paras2={"1"};//������ʾ���е�UeGroup  
							case_table=new CaseTableModule();
							case_table.case_table_search(sql2,paras2);
							jt_case.setModel(case_table);
						}
					}
				
			}
		}
		else if(arg0.getSource()==Button_import)//����ʵ��
		{
			int rowNum_selected=jt_case.getSelectedRow();//�����û����е���
			if(rowNum_selected==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			else{
				String name=(String) jt_case.getValueAt(rowNum_selected, 0);
				//�鿴Ҫɾ����ʵ�������Ƿ��ǵ�ǰ����ʹ�õ�ʵ������
				String sql1="select caseName from CurrentUser where ID=?";
				String []paras2={"1"};
				BBU_sql sql_case=new BBU_sql();
				ResultSet sql_case_ResultSet=sql_case.search(sql1, paras2);
				try {
					sql_case_ResultSet.next();
					caseName=sql_case_ResultSet.getString(1).trim();//��ǰʵ������
				} catch (Exception e) {
					// TODO: handle exception
				}
				if(name.equals(caseName))//�����Ե���
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"ʵ������ʹ�ã����ܵ��롣�뵼������ʵ����");
					return;
				}else//���Ե���
				{
					int a=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ������ʵ����", "", JOptionPane.YES_NO_OPTION);
					if(a==JOptionPane.NO_OPTION)
					{
						return;
					}
					if(a==JOptionPane.YES_OPTION)//����ʵ��
					{
						int b=JOptionPane.showConfirmDialog(null, "�Ƿ񱣴浱ǰʵ��", "", JOptionPane.YES_NO_OPTION);
						if(b==JOptionPane.YES_OPTION)//���浱ǰʵ����Ϣ�����ݿ�-----�ļ���
						{
							//�������ݿ�ı���ļ���
							Save_DatebaseToFile();
						}
						//����CurrentUser���
						String sql="update CurrentUser set caseName=? where ID=?";	
						String []paras={name,"1"};
						BBU_sql sqlh=new BBU_sql();
						sqlh.add_delete_change(sql, paras);
						//�ļ��е������ݿ�
						String path="D:\\CRAN\\"+Account.trim()+'\\'+name.trim();
						Input2.oneKeyInput(path);//����ʵ��ʱ���Զ�������ݿ�
						//��ȡ���ݿ�CurrentUser��������
						String sql3="select caseName from CurrentUser where ID=?";
						String []paras3={"1"};
						BBU_sql sql_case3=new BBU_sql();
						ResultSet sql_case_ResultSet3=sql_case3.search(sql3, paras3);
						try {
							sql_case_ResultSet3.next();
							caseName=sql_case_ResultSet3.getString(1).trim();//��ǰʵ������
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			}
		}
		else if(arg0.getSource()==Button_search)//��ѯ
		{
			String search_name=textField.getText().trim();

			String sql2="select * from PCase where caseName=?";//�ٴ�PCase�е�����ӵ�����	
			String []paras2={search_name};
			case_table=new CaseTableModule();
			case_table.case_table_search(sql2,paras2);
			jt_case.setModel(case_table);
		}
		else if(arg0.getSource()==Button_all)//ȫ����ʾ
		{
			String sql2="select * from PCase where 1=?";//�ٴ�PCase�е�����ӵ�����	
			String []paras2={"1"};
			case_table=new CaseTableModule();
			case_table.case_table_search(sql2,paras2);
			jt_case.setModel(case_table);
		}
	}
	//������ݿ���������--------------�˳���ǰʵ��ʱ��������ݿ�
		private void ClearDatebase() {
			// TODO �Զ����ɵķ������
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = java.sql.DriverManager.getConnection(  
		                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, passWord);
		         conn.setAutoCommit(true);
		         Statement stmt = conn.createStatement();
		         String sql_drop = "exec Drop_All";
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
	                }
	            }
	        }
	        // Ŀ¼��ʱΪ�գ�����ɾ��
	        return dir.delete();
	    }  
		private void CreatFile( String Path) {
			// TODO �Զ����ɵķ������
//			String directory = "D:\\CRAN\\"+Account+"\\"+Case_Name;
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
		private void Save_DatebaseToFile()//�������ݿ�ı���ļ���
		{
			if(caseName.equals("-1"))//�½���ʵ��,��û��ʵ������ʵ����עд�����ݿ⣬û��ʵ���ļ���
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
				CreatFile(Path);//temp�½�ʵ��������=��ǰʵ������+1
				//��ǰ���ݿ⵼�����ļ���
				Output.oneKeyOutput(Path);
			}
			else{
				File file=new File("D:\\CRAN\\"+Account.trim()+"\\"+caseName.trim());
				if(file.exists())//��ȥ��ʵ������ʵ���ļ���
				{
					//��ǰ���ݿ⵼�����ļ���
					String Path = "D:\\CRAN\\"+Account.trim()+"\\"+caseName.trim();
					Output.oneKeyOutput(Path);
				}else
				{
					//Ĭ��·�����½�ʵ���ļ���
					String Path = "D:\\CRAN\\"+Account.trim()+"\\"+caseName.trim();
					CreatFile(Path);//temp�½�ʵ��������=��ǰʵ������+1
					//��ǰ���ݿ⵼�����ļ���
					Output.oneKeyOutput(Path);
				}
			}
			
			
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
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
