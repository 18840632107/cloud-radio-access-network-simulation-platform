//ע��
package ui.CRAN1;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;

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
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.JTextField;

public class Register extends JDialog implements ActionListener{
	private static String Account;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton okButton,cancelButton;
	int register_result;//�жϼ���ע����˻����Ƿ��Ѵ���
	int PUser_id;//PUser���Զ�������ע����˻�id
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Register dialog = new Register();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
public Register(Dialog owner,String title,boolean modal) {
	super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
//	public Register() {
		setBounds(500, 200, 323, 307);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("�û�ע��");
				lblNewLabel.setFont(MyTools.f1);
				panel.add(lblNewLabel);
			}
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
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblNewLabel_1 = new JLabel("       �û�����");
					panel_1.add(lblNewLabel_1, BorderLayout.EAST);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblNewLabel_2 = new JLabel("         ���룺");
					panel_1.add(lblNewLabel_2, BorderLayout.EAST);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblNewLabel_3 = new JLabel("     ȷ�����룺");
					panel_1.add(lblNewLabel_3, BorderLayout.CENTER);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
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
					textField = new JTextField();
					panel_1.add(textField);
					textField.setColumns(16);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					textField_1 = new JTextField();
					panel_1.add(textField_1);
					textField_1.setColumns(16);
				}
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
				{
					JLabel lblNewLabel_5 = new JLabel("���룺��ĸ/����/�»������");
					panel_1.add(lblNewLabel_5);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					JLabel lblNewLabel_4 = new JLabel("���Ȳ�����6λ");
					panel_1.add(lblNewLabel_4);
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
		if(arg0.getSource()==okButton)//ע��
		{
			//���ж��˻�������textfield����Ϊ��
			if(textField.getText().length()==0)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"�ʻ�������Ϊ��");
				return;
			}else if(textField_1.getText().length()==0)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"���벻��Ϊ��");
				return;
			}else if(textField_2.getText().length()==0)
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"ȷ�����벻��Ϊ��");
				return;
			}else if(!textField_1.getText().equals(textField_2.getText()))
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"�����������벻һ�£�����������");
				return;
			}else
			{
				//��Ҫ�������ݿ�
				String sql="exec FindUser ?,?";//@userName,@PassWord
				String []paras={textField.getText(),textField_1.getText()};
				BBU_sql sql_register=new BBU_sql();
				ResultSet sql_register_ResultSet=sql_register.search(sql, paras);
				try {
					sql_register_ResultSet.next();
					register_result=sql_register_ResultSet.getInt(1);			
				} catch (Exception e) {
					// TODO: handle exception
				}
				if(register_result==0)//�˻���û���ҵ�������ע��
				{
					Account=textField.getText().trim();
					//PUser����Զ�ID�ŷ���
					String sql_id="exec RowNum ?";
					String []paras_id={"PUser"};
					sql_register=new BBU_sql();
					sql_register_ResultSet=sql_register.search(sql_id, paras_id);
					try {
						sql_register_ResultSet.next();
						PUser_id=sql_register_ResultSet.getInt(1);			
					} catch (Exception e) {
						// TODO: handle exception
					}
					String string_PUser_id=Integer.toString(PUser_id);////���������ݿ���bbu����
					//�����µ��˻�����
					String sql_add="insert into PUser values(?,?,?,?,?,?)";
					String []paras_add={string_PUser_id,Account,"0",textField_1.getText(),"��","��"};
					BBU_sql sqlh=new BBU_sql();
					sqlh.add_delete_change(sql_add, paras_add);
					//ָ��·�����½����˻��ļ���
					CreatFile();
					//��ʾ
					JOptionPane.showMessageDialog(this, "ע��ɹ�");//�����Ի���
					//�ر�ע�ᴰ��
					this.dispose();
				}else//�ʻ����Ѵ���
				{
					//��ʾ
					JOptionPane.showMessageDialog(this,"���ʻ����Ѵ��ڣ�����������");
					return;
				}
			}
		}
		else if(arg0.getSource()==cancelButton)//ȡ��
		{
			this.dispose();
		}
		
	}
public void CreatFile()//�������ʻ����������ļ���
{
	String directory = "D:\\CRAN\\"+Account;
	File f = new File(directory);
	if(f.exists()) {
		  // �ļ��Ѿ����ڣ�����ļ��������Ϣ
	}
	else
	{            
		f.mkdirs();//�����ļ����ڵ�Ŀ¼   
	}
}
}
