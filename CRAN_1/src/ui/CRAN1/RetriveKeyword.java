//�����һ�
package ui.CRAN1;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import ui.Share_bag.BBU_sql;
import ui.Share_bag.MyTools;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JTextField;

public class RetriveKeyword extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	JButton okButton,cancelButton,btnNewButton;
	String Question,Answer,PassWord;
	private JTextField textField_2;
	String Account;
	int count=0;
	JPanel panel_11,panel_12;
	JLabel lable_password,lblPassword;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			RetriveKeyword dialog = new RetriveKeyword();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
public RetriveKeyword(Dialog owner,String title,boolean modal) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
//	public RetriveKeyword() {
		setBounds(500, 200, 344, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("�����һ�");
			lblNewLabel.setFont(MyTools.f1);
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new GridLayout(6, 1, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_3 = new JLabel("   �˻�����");
					panel_1.add(lblNewLabel_3);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_1 = new JLabel("    �ܱ����⣺");
					panel_1.add(lblNewLabel_1);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_2 = new JLabel("    �ܱ��𰸣�");
					panel_1.add(lblNewLabel_2);
				}
			}
			{
				panel_11 = new JPanel();
				panel.add(panel_11);
				{
					lable_password = new JLabel("       �����ǣ�");
					lable_password.setVisible(false);
					panel_11.add(lable_password);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(6, 1, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					textField_2 = new JTextField();
					panel_1.add(textField_2);
					textField_2.setColumns(16);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				btnNewButton = new JButton("�һ�����");
				btnNewButton.addActionListener(this);
				panel_1.add(btnNewButton);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					textField = new JTextField();
					panel_1.add(textField);
					textField.setColumns(16);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					textField_1 = new JTextField();
					panel_1.add(textField_1);
					textField_1.setColumns(16);
				}
			}
			{
				panel_12 = new JPanel();
				panel.add(panel_12);
				{

				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("ȷ��");
				okButton.addActionListener(this);
				okButton.setActionCommand("ȷ��");
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
		if(arg0.getSource()==btnNewButton)//�����˺ţ��һ�����
		{
			int flage=1;
			Account=textField_2.getText().trim();//�˻���
			if(Account.length()==0)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"�ʻ�������Ϊ��");
				return;
			}else
			{
				String sql="select passWord,security1,security2 from PUser where userName=?";//�ٴ�Bbu�е���bbu������		
				String []paras={Account};
				BBU_sql sql_1=new BBU_sql();
				ResultSet sql_qusetion_ResultSet=sql_1.search(sql, paras);
				try {
					sql_qusetion_ResultSet.next();
					PassWord=sql_qusetion_ResultSet.getString(1);
					Question=sql_qusetion_ResultSet.getString(2);
					Answer=sql_qusetion_ResultSet.getString(3);
				} catch (Exception e) {
					// TODO: handle exception
					flage=0;
					//��ʾ
					JOptionPane.showMessageDialog(this,"�ʻ���������");
					return;
				}
				if(flage==1)//
				{
					textField.setText(Question);
				}
			}
		}
		else if(arg0.getSource()==okButton)//�����ܱ����⣬�һ�����
		{
			panel_12.removeAll();
			panel_12.repaint();
			if(textField_1.getText().equals(Answer))//�ܱ�������ȷ
			{

				lable_password.setVisible(true);
				
				lblPassword = new JLabel(PassWord);
				panel_12.add(lblPassword);
				panel_12.repaint();
			}else//�ܱ��������
			{
				if(count==4)//����3���ܱ����������ʾ�����һ�ʧ��
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"�����һ�ʧ�ܣ�����ϵ����Ա");
					this.dispose();
				}else
				{
					count=count+1;
					//��ʾ
					JOptionPane.showMessageDialog(this,"�ܱ��������������������");
					return;
				}
			}
			
		}else if(arg0.getSource()==cancelButton)//ȡ��
		{
			this.dispose();
		}
	}

}
