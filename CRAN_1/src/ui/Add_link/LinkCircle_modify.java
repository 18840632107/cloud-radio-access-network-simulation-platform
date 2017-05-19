/*
 * ������LinkCircle_modify
 * ���ܣ�����·�����޸Ľ���
 */
package ui.Add_link;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ui.Share_bag.BackgroundPanel;
import ui.Share_bag.MyTools;

public class LinkCircle_modify extends JDialog implements ActionListener{
	String path="image"+File.separator+"ADD_Link"+File.separator+"modify.png";
	Image image=new ImageIcon(path).getImage(); 
	private final JPanel contentPanel = new BackgroundPanel(image);
//	private final JPanel contentPanel = new JPanel();
	private JTextField textField,textField_7,textField_8;
	private JTextField textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
	JLabel lblUe,lblUe_1,lblxm,lblym,lblxm2,lblym2,lblzm,label1,label2,label3,label4;
	JPanel panel1;
	JComboBox jcb1;//�����б�
	String []jg1={"����","������"};///��·���ͣ�����дĬ����0��0�����ͣ�1��������
	JButton okButton,cancelButton;
	LinkCircle_module LinkCircle_table;
	String LinkCircleId;
	/**************************************
	 * ���ܣ������޸Ľ���
	 ***************************************/
	public LinkCircle_modify(Dialog owner,String title,boolean modal,LinkCircle_module LinkCircle_table,int rowNum) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
		setBounds(450, 200, 400, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel1 = new JPanel();
			panel1.setOpaque(false); 
			contentPanel.add(panel1, BorderLayout.NORTH);			
				lblUe = new JLabel("���뻷ID"+(String) LinkCircle_table.getValueAt(rowNum, 0));
				lblUe.setFont(MyTools.f1);
				LinkCircleId=(String) LinkCircle_table.getValueAt(rowNum, 0);
				panel1.add(lblUe);			
		}
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(8, 2, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					lblUe_1 = new JLabel("���뻷���ͣ�");
					lblUe_1.setFont(MyTools.f14);
					panel_1.add(lblUe_1);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					jcb1=new JComboBox<>(jg1);
					jcb1.setBackground(Color.white);
					jcb1.setPreferredSize(new Dimension(113,20));//����������ĸߺͿ�
					panel_1.add(jcb1);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					lblxm = new JLabel("X1����(m)��");
					lblxm.setFont(MyTools.f14);
					panel_1.add(lblxm);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_1 = new JTextField();
					textField_1.setText((String) LinkCircle_table.getValueAt(rowNum, 2));
					panel_1.add(textField_1);
					textField_1.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					lblym = new JLabel("Y1����(m)��");
					lblym.setFont(MyTools.f14);
					panel_1.add(lblym);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_2 = new JTextField();
					textField_2.setText((String) LinkCircle_table.getValueAt(rowNum, 3));
					panel_1.add(textField_2);
					textField_2.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					lblxm2 = new JLabel("X2����(m)��");
					lblxm2.setFont(MyTools.f14);
					panel_1.add(lblxm2);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_7 = new JTextField();
					textField_7.setText((String) LinkCircle_table.getValueAt(rowNum, 4));
					panel_1.add(textField_7);
					textField_7.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					lblym2 = new JLabel("Y2����(m)��");
					lblym2.setFont(MyTools.f14);
					panel_1.add(lblym2);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_8 = new JTextField();
					textField_8.setText((String) LinkCircle_table.getValueAt(rowNum, 5));
					panel_1.add(textField_8);
					textField_8.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					label1 = new JLabel("���뾶��");
					label1.setFont(MyTools.f14);
					panel_1.add(label1);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_4 = new JTextField();
					textField_4.setText((String) LinkCircle_table.getValueAt(rowNum, 6));
					panel_1.add(textField_4);
					textField_4.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					label2 = new JLabel("�̰뾶��");
					label2.setFont(MyTools.f14);
					panel_1.add(label2);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_5 = new JTextField();
					textField_5.setText((String) LinkCircle_table.getValueAt(rowNum, 7));
					panel_1.add(textField_5);
					textField_5.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					label4 = new JLabel("��ѡ����������");
					label4.setFont(MyTools.f14);
					panel_1.add(label4);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				{
					textField_6 = new JTextField();
					textField_6.setText((String) LinkCircle_table.getValueAt(rowNum, 8));
					panel_1.add(textField_6);
					textField_6.setColumns(10);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.white);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("ȷ��");
				okButton.setFont(MyTools.f14);
				okButton.setActionCommand("ȷ��");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
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
			//�ж�X,Y,Z���겻�ܲ���д�����򣬲��ܱ���
			boolean judge=true;
			String X1=textField_1.getText();//X1
			String Y1=textField_2.getText();//Y1
			String X2=textField_7.getText();//X2
			String Y2=textField_8.getText();//Y2
			if(X1.length()==0||Y1.length()==0)
			{
				judge=false;
				//��ʾ
				JOptionPane.showMessageDialog(this,"����X,Y���겻��Ϊ��");
			}
			String LongRadius=textField_4.getText();//LongRadius
			String ShortRadius=textField_5.getText();//ShortRadius
			String AccesspointNum=textField_6.getText();//AccesspointNum
			boolean temp=isNumeric(X1)&isNumeric(Y1)&isNumeric(X2)&isNumeric(Y2)&isNumeric(LongRadius)&isNumeric(ShortRadius)&isNumeric(AccesspointNum);
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
				//�޸ı��1
				String sql="update Link set LinkType=?,X1=?,Y1=?,X2=?,Y2=?,LongRadius=?,ShortRadius=?,AccesspointNum=? where LinkId=?";
				String []paras={LinkType,textField_1.getText(),textField_2.getText(),textField_7.getText(),textField_8.getText(),textField_4.getText(),textField_5.getText(),
						textField_6.getText(),LinkCircleId};
				LinkCircle_table=new LinkCircle_module();
				LinkCircle_table.add_delete_change_to_sql(sql, paras);						
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
