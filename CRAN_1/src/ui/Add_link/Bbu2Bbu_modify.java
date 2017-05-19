/*
 ������Ǳ����һ��ͼƬmodify.png��һ��panel����ɫ����ɫ�������޸Ľ��涼�ô��޸ķ�����
 * ������Bbu2Bbu_modify
 * ���ܣ�����BBU����·�����޸Ľ���
 */
package ui.Add_link;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ui.Share_bag.BBU_sql;
import ui.Share_bag.BackgroundPanel;
import ui.Share_bag.MyTools;


public class Bbu2Bbu_modify extends JDialog implements ActionListener{
	String path="image"+File.separator+"ADD_Link"+File.separator+"modify.png";
	Image image=new ImageIcon(path).getImage(); 
	private final JPanel contentPanel = new BackgroundPanel(image);
//	private final JPanel contentPanel = new JPanel();
	JLabel lblid;
	JPanel panel,buttonPane;
	JButton okButton,cancelButton;
	private JTextField textField,textField_1,textField_2,textField_3;	
	Bbu2Bbu_Link_module Bbu2Bbu_Link_table;
	String LinkPathId;
	JComboBox jcb1,jcb2;//�����б�
	String []jg1={"����","������"};///��·���ͣ�����дĬ����0��0�����ͣ�1��������
	Vector jg2;//�洢���뻷id
	/**************************************
	 * ���ܣ������޸Ľ���
	 ***************************************/
	public Bbu2Bbu_modify(Dialog owner,String title,boolean modal,Bbu2Bbu_Link_module Bbu2Bbu_Link_table,int rowNum) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
		setBounds(450, 200, 400, 280);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			panel.setOpaque(false); 
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				lblid = new JLabel("������·ID��"+(String) Bbu2Bbu_Link_table.getValueAt(rowNum, 0));
				lblid.setFont(MyTools.f1);
				LinkPathId=(String) Bbu2Bbu_Link_table.getValueAt(rowNum, 0);
				panel.add(lblid);
			}
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setOpaque(false); 
			contentPanel.add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(new GridLayout(5, 2, 0, 0));
			{
				{
					JPanel panel_3 = new JPanel();
					panel_3.setOpaque(false); 
					panel_1.add(panel_3);
					panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					{
						JLabel lblid_1 = new JLabel("�˵��ID��");
						lblid_1.setFont(MyTools.f14);
						panel_3.add(lblid_1);
					}
				}
				{
					JPanel panel_3 = new JPanel();
					panel_3.setOpaque(false); 
					panel_1.add(panel_3);
					panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					{
						textField = new JTextField();
						textField.setText((String) Bbu2Bbu_Link_table.getValueAt(rowNum, 1));
						panel_3.add(textField);
						textField.setColumns(10);
					}
				}
				{
					JPanel panel_3 = new JPanel();
					panel_3.setOpaque(false); 
					panel_1.add(panel_3);
					panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					{
						JLabel lblid_2 = new JLabel("�˵��ID��");
						lblid_2.setFont(MyTools.f14);
						panel_3.add(lblid_2);
					}
				}
				{
					JPanel panel_3 = new JPanel();
					panel_3.setOpaque(false); 
					panel_1.add(panel_3);
					panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					{
						textField_1 = new JTextField();
						textField_1.setText((String) Bbu2Bbu_Link_table.getValueAt(rowNum, 2));
						panel_3.add(textField_1);
						textField_1.setColumns(10);
					}
				}
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.setOpaque(false); 
				panel_1.add(panel_2);
				panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					JLabel label = new JLabel("������ٶȣ�");
					label.setFont(MyTools.f14);
					panel_2.add(label);
				}
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.setOpaque(false); 
				panel_1.add(panel_2);
				panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_2 = new JTextField();
					textField_2.setText((String) Bbu2Bbu_Link_table.getValueAt(rowNum, 3));
					panel_2.add(textField_2);
					textField_2.setColumns(10);
				}
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.setOpaque(false); 
				panel_1.add(panel_2);
				panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					JLabel label = new JLabel(" ��·���ͣ�");
					label.setFont(MyTools.f14);
					panel_2.add(label);										
				}
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.setOpaque(false); 
				panel_1.add(panel_2);
				panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{				
					jcb1=new JComboBox<>(jg1);
					jcb1.setBackground(Color.white);
					jcb1.setPreferredSize(new Dimension(113,20));//����������ĸߺͿ�
					panel_2.add(jcb1);					
				}
			}
				{
					JPanel panel_3 = new JPanel();
					panel_3.setOpaque(false); 
					panel_1.add(panel_3);
					panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					{
						JLabel label = new JLabel(" ���뻷��    ");
						label.setFont(MyTools.f14);
						panel_3.add(label);
					}
				}
				{
					JPanel panel_3 = new JPanel();
					panel_3.setOpaque(false); 
					panel_1.add(panel_3);
					panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					{
						//jcg2��������list�����Ǵ����ݿ����������
						jg2=new Vector<>();
							String sql1="select * from LinkCircle where 1=?";//�ٴ�UE�е�����ӵ�����		
							String []paras1={"1"};//������ʾ�����Ѿ���ӵ�UE
							BBU_sql circlid_sql=new BBU_sql();
							ResultSet rs=circlid_sql.search(sql1, paras1);
							try {
								while(rs.next())
								{
									jg2.add(rs.getString(1));//LinkCircleId
								}
							} catch (SQLException e) {
								// TODO �Զ����ɵ� catch ��
								e.printStackTrace();
							}finally
							{
								//�ر�
								circlid_sql.close();
							}		
						jcb2=new JComboBox<>(jg2);
						jcb2.setBackground(Color.white);
						jcb2.setPreferredSize(new Dimension(113,20));//����������ĸߺͿ�
						panel_3.add(jcb2);	
					}
				}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.white);//����ɫ����ɫ
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("ȷ��");
				okButton.setFont(MyTools.f14);
				okButton.setActionCommand("ȷ��");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("ȡ��");
				cancelButton.setFont(MyTools.f14);
				cancelButton.setActionCommand("ȡ��");
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
		if(arg0.getSource()==okButton)
		{
			//�ж϶˵��ID���ܲ���д�����򣬲��ܱ���
			boolean judge=true;
			String POOL1=textField.getText();//�˵��ID
			String POOL2=textField_1.getText();//�˵��ID
			if(POOL1.length()==0||POOL2.length()==0)
			{
				judge=false;
				//��ʾ
				JOptionPane.showMessageDialog(this,"�˵��ID����Ϊ��");
			}
			String MaxTransRate=textField_2.getText();//������ٶ�
			boolean temp=isNumeric(POOL1)&isNumeric(POOL2)&isNumeric(MaxTransRate);
			if(!(temp))
			{
				judge=false;
				//��ʾ
				JOptionPane.showMessageDialog(this,"����д���֣�");
				return;
			}
			if(judge==true)
			{
				String LinkType="0";
				if(jcb1.getSelectedItem().equals("����"))//0�����ͣ�1��������
				{
					LinkType="0";
				}else if(jcb1.getSelectedItem().equals("������"))
				{
					LinkType="1";
				}
				String sql="update LinkBbu2Bbu set LinkEnd1=?,LinkEnd2=?,LinkType=?,MaxTransRate=?,LinkCircleId=? where LinkPathId=?";
				String []paras={textField.getText(),textField_1.getText(),LinkType,textField_2.getText(),(String) jcb2.getSelectedItem(),LinkPathId};
				Bbu2Bbu_Link_table=new Bbu2Bbu_Link_module();
				Bbu2Bbu_Link_table.add_delete_change_to_sql(sql, paras);
				this.dispose();//�رնԻ���
			}
			
			
		}
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
