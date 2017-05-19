/*
 * ������Input2
 * ���ܣ�ͨ��excel��������������ݽ���
 */
package ui.Add_bbu_rru_ue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ui.CRAN1.Export_excel;
import ui.CRAN_excel.ExcelOperate;
import ui.Share_bag.*;

public class Input2 extends JDialog implements ActionListener{
	static String name = BBU_sql.name;
	static String passWord = BBU_sql.pswd;
	String path="image"+File.separator+"Add_BBU_RRU_UE"+File.separator+"input.png";
	Image image=new ImageIcon(path).getImage(); 
	private final JPanel contentPanel = new BackgroundPanel(image);
//	private final JPanel contentPanel = new JPanel();
	JLabel label,label_2,label_1;
	private JPanel panel,buttonPane,panel_1,panel_2,panel_3,panel_4,panel_5;
	private JButton button,btnexcel,cancelButton;
	private JTextField textField;
	JComboBox jcb;//�����б�
	String []jg={"BBU��","BBU","RRU","UE","����","LinkCircle","LinkBbu2Bbu","LinkBbu2Rru","LinkBbuPool2BbuPool"};//RRU״̬�������飬����дĬ����0
	String Path;
//	public static void main(String[] args) {
//		try {
//			Input2 dialog = new Input2();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Input2(Frame owner,String title,boolean modal) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
//public Input2() {
		setBounds(450, 150, 400, 250);
		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			panel.setOpaque(false);
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			{
				label = new JLabel("�����ļ�����");
				label.setFont(MyTools.f15);
//				label.setForeground(Color.white);
				label.setFont(MyTools.f1);
				panel.add(label);
			}
		}
		{
			panel_1 = new JPanel();
//			panel_1.setBackground(Color.white);
			panel_1.setOpaque(false);
			contentPanel.add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(new GridLayout(2, 1, 0, 0));
			{
				panel_2 = new JPanel();
				panel_2.setBackground(Color.white);
//				panel_2.setOpaque(false);
				panel_1.add(panel_2);
				panel_2.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
				{
					label_1 = new JLabel(" �����ļ��������ͣ�");
					label_1.setFont(MyTools.f15);
					panel_2.add(label_1);
					jcb=new JComboBox<>(jg);
					jcb.setBackground(Color.white);
					jcb.setEditable(false);
					jcb.setPreferredSize(new Dimension(113,20));//����������ĸߺͿ�
					panel_2.add(jcb);
				}	
			}
			{
				panel_4 = new JPanel();
				panel_4.setBackground(Color.white);
				panel_1.add(panel_4);
				panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					{
						label_2 = new JLabel(" �ļ����룺");
//						label_2.setForeground(Color.white);
						label_2.setFont(MyTools.f15);
						panel_4.add(label_2);
					}
					{
						textField = new JTextField();
						panel_4.add(textField);
						textField.setColumns(20);
					}
				}
				


				
			}
		}
		{
			buttonPane = new JPanel();
			buttonPane.setOpaque(false);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			{
				button = new JButton("��");
				button.setFont(MyTools.f14);
				button.addActionListener(this);
				buttonPane.add(button);
			}
			{
				btnexcel = new JButton("�ϴ�");
				btnexcel.setFont(MyTools.f14);
				btnexcel.addActionListener(this);
				buttonPane.add(btnexcel);
			}
				cancelButton = new JButton("�˳�");
				cancelButton.setFont(MyTools.f14);
				cancelButton.setActionCommand("�˳�");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);			
		}
	}
	public static void oneKeyInput(String Path)
	{
		//��������ݿ���������
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, passWord);
             conn.setAutoCommit(true);
             Statement stmt = conn.createStatement();
             String sql = "exec Drop_All";
			stmt.executeUpdate(sql);
		
		}catch(SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			}
		//��ȡ��Ӧ�ļ��б�����Ѿ��洢�õ����ݵ����ݿ��У�����ͨ����ȡ���ݿ���ʾ��ǰ�˻���������
		ExcelOperate excel=new ExcelOperate();
//		String Path = "D:";
		try {
			String BbuPool_Path=Path+"/BbuPool.xls";
			excel.BbuPoolImport(BbuPool_Path);
			String Bbu_Path=Path+"/Bbu.xls";
			excel.BbuImport(Bbu_Path);
			String Rru_Path=Path+"/Rru.xls";
			excel.RruImport(Rru_Path);
			String Ue_Path=Path+"/Ue.xls";
			excel.UeImport(Ue_Path);
			String Antenna_Path=Path+"/Antenna.xls";
			excel.AntennaImport(Antenna_Path);
			String LinkCircle_Path=Path+"/Link.xls";
			excel.LinkCircleImport(LinkCircle_Path);
		} catch (Exception e1) {
			// TODO �Զ����ɵ� catch ��
			//e1.printStackTrace();
		}
	}
	public static void CaseInput(String Path)
	{
		//��ȡ��Ӧ�ļ��б�����Ѿ��洢�õ����ݵ����ݿ��У�����ͨ����ȡ���ݿ���ʾ��ǰ�˻���������
		ExcelOperate excel=new ExcelOperate();
		try {
			String case_Path=Path+"/PCase.xls";
			excel.caseImport(case_Path);
		} catch (Exception e1) {
			// TODO �Զ����ɵ� catch ��
			//e1.printStackTrace();
		}
	}
	/**************************************
	 * ���ܣ������ϸ�����ť�ļ�����Ӧ����
	 ***************************************/
	@Override
	public void actionPerformed(ActionEvent arg0) {
			/***************�����ť******************/
				if(arg0.getSource()==button)
				{
					JFileChooser filechooser=new JFileChooser();
					//��ʾ�ļ�ѡ��Ի���
					int i=filechooser.showOpenDialog(getContentPane());//this.getContentPane()�������ǳ�ʼ��һ�����������������������һЩ�ؼ�
					//�ж��û��������Ƿ�Ϊ�򿪰�ť
					if(i==JFileChooser.APPROVE_OPTION)
					{
						//���ѡ�е��ļ�����
						File selectedFile=filechooser.getSelectedFile();
						//��ʾѡ���ļ�������
						textField.setText(selectedFile.getName());//BBU��textField
						Path=selectedFile.getAbsolutePath();
					}
				}
				/***************�ϴ���ť******************/
				else if(arg0.getSource()==btnexcel)
				{
					/*******************************
					 * �ж�ѡ���������ͣ�BBUPOOL,BBU,RRU,UE,����,
					 * LinkCircle,LinkBbu2Bbu,LinkBbu2Rru,LinkBbuPool2BbuPool
					 * ****************************/
					if(jcb.getSelectedIndex()==0)//BBU��
					{
						ExcelOperate excel=new ExcelOperate();
						try {
							excel.BbuPoolImport(Path);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							//e1.printStackTrace();
						}
					}
					else if(jcb.getSelectedIndex()==1)//BBU
					{
						ExcelOperate excel=new ExcelOperate();
						try {
							excel.BbuImport(Path);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							//e1.printStackTrace();
						}
					}
					else if(jcb.getSelectedIndex()==2)//RRU
					{
						ExcelOperate excel=new ExcelOperate();
						try {
							excel.RruImport(Path);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							//e1.printStackTrace();
						}
					}
					else if(jcb.getSelectedIndex()==3)//UE
					{
						ExcelOperate excel=new ExcelOperate();
						try {
							excel.UeImport(Path);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							//e1.printStackTrace();
						}
					}
					else if(jcb.getSelectedIndex()==4)//����
					{
						ExcelOperate excel=new ExcelOperate();
						try {
							excel.AntennaImport(Path);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							//e1.printStackTrace();
						}
					}
					else if(jcb.getSelectedIndex()==5)//LinkCircle
					{
						ExcelOperate excel=new ExcelOperate();
						try {
							excel.LinkCircleImport(Path);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							//e1.printStackTrace();
						}
					}
					else if(jcb.getSelectedIndex()==6)//LinkBbu2Bbu
					{
						ExcelOperate excel=new ExcelOperate();
						try {
							excel.LinkImport("LinkBbu2Bbu",Path);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							//e1.printStackTrace();
						}
					}
					else if(jcb.getSelectedIndex()==7)//LinkBbu2Rru
					{
						ExcelOperate excel=new ExcelOperate();
						try {
							excel.LinkImport("LinkBbu2Rru",Path);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							//e1.printStackTrace();
						}
					}
					else if(jcb.getSelectedIndex()==8)//LinkBbu2Rru
					{
						ExcelOperate excel=new ExcelOperate();
						try {
							excel.LinkImport("LinkBbuPool2BbuPool",Path);
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							//e1.printStackTrace();
						}
					}
					
				}
				/***************�˳���ť******************/
				else if(arg0.getSource()==cancelButton)
				{
					this.dispose();
				}
	}

}
