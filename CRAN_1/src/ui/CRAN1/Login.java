package ui.CRAN1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.Add_bbu_rru_ue.Bbu_modify;
import ui.Add_bbu_rru_ue.Input2;
import ui.Share_bag.BBU_sql;
import ui.Share_bag.MyTools;

public class Login extends JDialog implements ActionListener{
//	public static int LoginOrNot=0;//LoginOrNot=0û�е�¼����ʾ��½���棻LoginOrNot=1��¼����ʾ�û��������
	static String name = BBU_sql.name;
	static String passWord = BBU_sql.pswd;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1;
	private JTextField textField;
	private JButton button_register,button_RetriveKeyword,okButton,cancelButton;
	int login_result;//�Ƿ�ɹ������ظ��˺�ʵ������
	String login_result_casenum;
	String Account;//�ʻ���
	String PassWord;//����
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
//public Login(Frame owner,String title,boolean modal) {
//	super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
	public Login() {
		setBounds(500, 200, 416, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("CRAN");
				lblNewLabel.setFont(MyTools.f1);
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.EAST);
				panel_1.setLayout(new GridLayout(2, 1, 0, 0));
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					{
						button_register = new JButton("ע���˺�");
						button_register.addActionListener(this);
						panel_2.add(button_register);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					{
						button_RetriveKeyword = new JButton("�һ�����");
						button_RetriveKeyword.addActionListener(this);
						panel_2.add(button_RetriveKeyword);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.WEST);
				panel_1.setLayout(new GridLayout(2, 1, 0, 0));
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new BorderLayout(0, 0));
					{
						JLabel label = new JLabel("   �˻���   ");
						panel_2.add(label, BorderLayout.CENTER);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new BorderLayout(0, 0));
					{
						JLabel label = new JLabel("   ���룺   ");
						panel_2.add(label, BorderLayout.CENTER);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new GridLayout(2, 1, 0, 0));
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					{
						textField = new JTextField();
						panel_2.add(textField);
						textField.setColumns(16);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2);
					panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					{
						textField_1 = new JTextField();
						panel_2.add(textField_1);
						textField_1.setColumns(16);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("��¼");
				okButton.setActionCommand("��¼");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("ȡ��");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("ȡ��");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		if(arg0.getSource()==button_register)//ע��
		{
			JDialog a=new Register(this, "Register", true);
			a.setVisible(true);
		}
		else if(arg0.getSource()==button_RetriveKeyword)//�һ�����
		{
			JDialog a=new RetriveKeyword(this,"RetriveKeyword",true);
			a.setVisible(true);
		}
		else if(arg0.getSource()==okButton)//ȷ����¼
		{
			Account=textField.getText().trim();
			PassWord=textField_1.getText().trim();
			//���ж��˻�������textfield����Ϊ��
			if(Account.length()==0)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"�ʻ�������Ϊ��");
				return;
			}else if(PassWord.length()==0)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"���벻��Ϊ��");
				return;
			}else
			{
				//��Ҫ�������ݿ�
				String sql="exec FindUser ?,?";//@userName,@PassWord
				String []paras={Account,PassWord};
				BBU_sql sql_login=new BBU_sql();
				ResultSet sql_login_ResultSet=sql_login.search(sql, paras);
				try {
					sql_login_ResultSet.next();
					login_result=sql_login_ResultSet.getInt(1);			
					login_result_casenum=sql_login_ResultSet.getString(2);	
					System.out.println(login_result_casenum);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if(login_result==0)//�˻���û���ҵ�
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"���ʻ���������");
					return;
				}else if(login_result==1)//�˻����ҵ�����������ȷ
				{
					//��������ݿ���������
					ClearDatebase_forAccount();
					//���뵱ǰ�˺�ʵ�����PCase
					String path="D:\\CRAN\\"+Account;
					Input2.CaseInput(path);//������case.xls�������ݿ⣬��ע����û����ᵼ��case.xls����Ϊ��ע����û���û��case.xls�ļ�
					//CurrentUser����޸�
					String sql_tuopu="update CurrentUser set userName=?,caseName=?  where ID=?";
					String []paras_tuopu={textField.getText(),"-1","1"};
					BBU_sql sqlh=new BBU_sql();
					sqlh.add_delete_change(sql_tuopu, paras_tuopu);
					//��ʾ
					JOptionPane.showMessageDialog(this,"��¼�ɹ�");
//					LoginOrNot=1;
					//�رյ�¼����
					this.dispose();
					
					JFrame a=new tuoputu(this,"tuoputu",true);
					a.setVisible(true);

				}else if(login_result==2)//�ʻ����ҵ������벻��ȷ
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"�������");
					return;
				}
			}
		}
		else if(arg0.getSource()==cancelButton)//ȡ��---�˳�����
		{
			System.exit(0);
		}
	}

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

}
