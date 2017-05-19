/*
 * ������UE2_modify
 * ���ܣ�����UE�����޸Ľ���
 */
package ui.Add_bbu_rru_ue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextField;

import ui.Share_bag.BackgroundPanel;
import ui.Share_bag.MyTools;

public class UE2_modify extends JDialog implements ActionListener{
	String path="image"+File.separator+"ADD_Link"+File.separator+"modify.png";
	Image image=new ImageIcon(path).getImage(); 
	private final JPanel contentPanel = new BackgroundPanel(image);
//	private final JPanel contentPanel = new JPanel();
	JPanel panel1;
	JLabel lblUe;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblZ;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblUeid;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JComboBox jcb1,jcb2;//�����б�
	String []jg1={"����","����"};//��������Ϣ������дĬ����0��1�����ڣ�0������
	String []jg2={"0","1","2"};//�������ͣ�����дĬ����0
	JButton okButton,cancelButton;
	UE_table_module2 ue2_table;
	String Ue_id;

	/**************************************
	 * ���ܣ������޸Ľ���
	 ***************************************/
	public UE2_modify(Dialog owner,String title,boolean modal,UE_table_module2 ue2_table,int rowNum){
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
		setBounds(450, 150, 305, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel1 = new JPanel();
			panel1.setOpaque(false);
			contentPanel.add(panel1, BorderLayout.NORTH);
			{
				lblUe = new JLabel("UE"+(String) ue2_table.getValueAt(rowNum, 0));
				lblUe.setFont(MyTools.f1);
				Ue_id=(String) ue2_table.getValueAt(rowNum, 0);
				panel1.add(lblUe);
			}
		}
		{
			panel = new JPanel();
			panel.setOpaque(false);
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new GridLayout(6, 1, 0, 0));
			{
				panel_2 = new JPanel();
				panel_2.setOpaque(false);
				panel.add(panel_2);
				{
					lblX = new JLabel("X���꣨m����");
					lblX.setFont(MyTools.f14);
					panel_2.add(lblX);
				}
			}
			{
				panel_3 = new JPanel();
				panel_3.setOpaque(false);
				panel.add(panel_3);
				{
					lblY = new JLabel("Y���꣨m����");
					lblY.setFont(MyTools.f14);
					panel_3.add(lblY);
				}
			}
			{
				panel_4 = new JPanel();
				panel_4.setOpaque(false);
				panel.add(panel_4);
				{
					lblZ = new JLabel("Z���꣨m����");
					lblZ.setFont(MyTools.f14);
					panel_4.add(lblZ);
				}
			}
			{
				panel_5 = new JPanel();
				panel_5.setOpaque(false);
				panel.add(panel_5);
				{
					label = new JLabel("��������Ϣ��");
					label.setFont(MyTools.f14);
					panel_5.add(label);
				}
			}
			{
				panel_7 = new JPanel();
				panel_7.setOpaque(false);
				panel.add(panel_7);
				{
					label_1 = new JLabel("�������ͣ�");
					label_1.setFont(MyTools.f14);
					panel_7.add(label_1);
				}
			}
			{
				panel_6 = new JPanel();
				panel_6.setOpaque(false);
				panel.add(panel_6);
				{
					lblUeid = new JLabel("UEȺID��");
					lblUeid.setFont(MyTools.f14);
					panel_6.add(lblUeid);
				}
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setOpaque(false);
			contentPanel.add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(new GridLayout(6, 1, 0, 0));
			{
				panel_8 = new JPanel();
				panel_8.setOpaque(false);
				panel_1.add(panel_8);
				panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField = new JTextField();
					textField.setText((String) ue2_table.getValueAt(rowNum, 1));
					panel_8.add(textField);
					textField.setColumns(10);
				}
			}
			{
				panel_9 = new JPanel();
				panel_9.setOpaque(false);
				panel_1.add(panel_9);
				panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_1 = new JTextField();
					textField_1.setText((String) ue2_table.getValueAt(rowNum, 2));
					panel_9.add(textField_1);
					textField_1.setColumns(10);
				}
			}
			{
				panel_10 = new JPanel();
				panel_10.setOpaque(false);
				panel_1.add(panel_10);
				panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_2 = new JTextField();
					textField_2.setText((String) ue2_table.getValueAt(rowNum, 3));
					panel_10.add(textField_2);
					textField_2.setColumns(10);
				}
			}
			{
				panel_11 = new JPanel();
				panel_11.setOpaque(false);
				panel_1.add(panel_11);
				panel_11.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				jcb1=new JComboBox<>(jg1);
				jcb1.setBackground(Color.white);
				jcb1.setPreferredSize(new Dimension(113,20));//����������ĸߺͿ�
				panel_11.add(jcb1);
			}
			{
				panel_12 = new JPanel();
				panel_12.setOpaque(false);
				panel_1.add(panel_12);
				panel_12.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				jcb2=new JComboBox<>(jg2);
				jcb2.setBackground(Color.white);
				jcb2.setPreferredSize(new Dimension(113,20));//����������ĸߺͿ�
				panel_12.add(jcb2);
			}
			{
				panel_13 = new JPanel();
				panel_13.setOpaque(false);
				panel_1.add(panel_13);
				panel_13.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_3 = new JTextField();
					textField_3.setText((String) ue2_table.getValueAt(rowNum, 6));
					panel_13.add(textField_3);
					textField_3.setColumns(10);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setOpaque(false);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("ȷ��");
				okButton.setFont(MyTools.f14);
				okButton.setActionCommand("ȷ��");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("�˳�");
				cancelButton.setFont(MyTools.f14);
				cancelButton.setActionCommand("�˳�");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
		this.setVisible(true);
	}
	/**************************************
	 * ���ܣ������ϸ�����ť�ļ�����Ӧ����
	 ***************************************/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		/***************ȷ����ť******************/
		if(arg0.getSource()==okButton)
		{
			//�ж�X,Y,Z���겻�ܲ���д�����򣬲��ܱ���
			boolean judge=true;
			String X=textField.getText();//X
			String Y=textField_1.getText();//Y
			String Z=textField_2.getText();//Z
			if(X.length()==0||Y.length()==0||Z.length()==0)
			{
				judge=false;
				//��ʾ
				JOptionPane.showMessageDialog(this,"����X,Y,Z���겻��Ϊ��");
			}
			boolean temp=isNumeric(X)&isNumeric(Y)&isNumeric(Z);
			if(!(temp))
			{
				judge=false;
				//��ʾ
				JOptionPane.showMessageDialog(this,"����д���֣�");
				return;
			}
			if(judge==true)
			{
				String UeType="0";
				if(jcb1.getSelectedItem().equals("����"))//1�����ڣ�0������
				{
					UeType="0";
				}else if(jcb1.getSelectedItem().equals("����"))
				{
					UeType="1";
				}
				String sql="update Ue set UeType=?,X=?,Y=?,Z=?,UeAntennaId=?,UeGroupId=? where UeId=?";
				String []paras={UeType,textField.getText(),textField_1.getText(),textField_2.getText()
					,(String) jcb2.getSelectedItem(),textField_3.getText(),Ue_id};
				ue2_table=new UE_table_module2();
				ue2_table.add_delete_change_to_sql(sql, paras);
				this.dispose();//�رնԻ���
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

}
