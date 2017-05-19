package ui.CRAN1;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import ui.Add_bbu_rru_ue.Bbu_table_module;
import ui.Add_bbu_rru_ue.Rru_Table_module;
import ui.Share_bag.BBU_sql;

public class NewCase extends JDialog implements ActionListener{
	static String name = BBU_sql.name;
	static String passWord = BBU_sql.pswd;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_name;
	JButton okButton,cancelButton;
	JTextArea textArea_remark;
	CaseTableModule case_table;
	/*
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			NewCase dialog = new NewCase();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public NewCase(Dialog owner,String title,boolean modal) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
//	public NewCase() {
		setBounds(100, 100, 423, 202);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new GridLayout(4, 1, 0, 0));
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2, BorderLayout.WEST);
					{
						JLabel lblNewLabel = new JLabel("ʵ�����ƣ�");
						panel_2.add(lblNewLabel);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2, BorderLayout.CENTER);
					panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					{
						textField_name = new JTextField();
						panel_2.add(textField_name);
						textField_name.setColumns(16);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.WEST);
				{
					JLabel label = new JLabel("ʵ����ע��");
					panel_1.add(label);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textArea_remark = new JTextArea(4,25);
					textArea_remark.setLineWrap(true);//�Զ�����
					textArea_remark.setWrapStyleWord(true);//���в�����i
					panel_1.add(textArea_remark);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("ȷ��");
				okButton.setActionCommand("ȷ��");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("ȡ��");
				cancelButton.setActionCommand("ȡ��");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		if(arg0.getSource()==okButton)//�½�
		{
			boolean b=true;
			//��յ�ǰ���ݿ�
			ClearDatebase();
			//PCase����½�����
			String name=textField_name.getText();
			String remark=textArea_remark.getText();
			String []paras=new String[2];
			paras[0]=name;//ʵ������
			paras[1]=remark;//ʵ����ע
			String sql="insert into PCase values(?,?)";//����Ҫһ��һ�е����exec Add_Bbu ?,?,?,?,?,?,?,?,?,?,?    insert into Bbu values(?,?,?,?,?,?,?,?,?,?,?)
			case_table=new CaseTableModule();
			b=case_table.add_delete_change_to_sql(sql, paras);
			if(b==true)
			{
				JOptionPane.showMessageDialog(this, "�½�ʵ���ɹ�");//�����Ի���
			}else
			{
				JOptionPane.showMessageDialog(this, "�½�ʵ��ʧ��");//�����Ի���
			}
			//����CurrentUser���
			String sql1="update CurrentUser set caseName=? where ID=?";	
			String []paras1={name,"1"};
			BBU_sql sqlh=new BBU_sql();
			sqlh.add_delete_change(sql1, paras1);
			this.dispose();//�رնԻ���
		}
		else if(arg0.getSource()==cancelButton)//ȡ��
		{
			this.dispose();//�رնԻ���
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
}
