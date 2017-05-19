/*
 * ������Rru_modify
 * ���ܣ�RRU�����޸Ľ���
 */
package ui.Add_bbu_rru_ue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ui.Share_bag.BackgroundPanel;
import ui.Share_bag.MyTools;

public class Rru_modify extends JDialog implements ActionListener{
	String path="image"+File.separator+"ADD_Link"+File.separator+"modify.png";
	Image image=new ImageIcon(path).getImage(); 
	private final JPanel contentPanel = new BackgroundPanel(image);
	private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5;
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8;
	JButton okButton,cancelButton;
	Rru_Table_module rru_table;
	String rru_id;
	JComboBox jcb1,jcb2;//�����б�
	String []jg1={"�ر�","��"};//RRU״̬���ԣ�����дĬ����0,0���رգ�1����
	String []jg2={"0","1","2"};//�������ͣ�����дĬ����0
	/**************************************
	 * ���ܣ������޸Ľ���
	 ***************************************/
	//owner���ĸ�����
	//title������
	//modalָ��ģ̬���ڣ����Ƿ�ģ̬����
	public Rru_modify(Dialog owner,String title,boolean modal,Rru_Table_module bbu_table,int rowNum) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
		getContentPane().setLayout(new BorderLayout());
		{
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new BorderLayout(0, 0));
			JPanel buttonPane = new JPanel();
			buttonPane.setOpaque(false);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("ȷ��");
				okButton.setFont(MyTools.f14);
				okButton.addActionListener(this);
				okButton.setActionCommand("ȷ��");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("ȡ��");
				cancelButton.setFont(MyTools.f14);
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("ȡ��");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false); 
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblBbu = new JLabel("RRU"+(String) bbu_table.getValueAt(rowNum, 0));
				lblBbu.setFont(MyTools.f1);
				rru_id=(String) bbu_table.getValueAt(rowNum, 0);
				panel.add(lblBbu);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false); 
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new GridLayout(8, 1, 0, 0));
				JLabel lblX = new JLabel("   X���꣺");
				lblX.setFont(MyTools.f14);
				panel.add(lblX);
				JLabel lblY = new JLabel("   Y���꣺");
				lblY.setFont(MyTools.f14);
				panel.add(lblY);
				JLabel lblZ = new JLabel("   Z���꣺");
				lblZ.setFont(MyTools.f14);
				panel.add(lblZ);
				JLabel label1 = new JLabel(" ���书�ʣ�");
				label1.setFont(MyTools.f14);
				panel.add(label1);
				JLabel label2 = new JLabel(" ����û�����");
				label2.setFont(MyTools.f14);
				panel.add(label2);
				JLabel label3 = new JLabel(" ��Ƶ��");
				label3.setFont(MyTools.f14);
				panel.add(label3);
				JLabel label4 = new JLabel(" RRU״̬��");
				label4.setFont(MyTools.f14);
				panel.add(label4);
				JLabel label5 = new JLabel(" �������ͣ�");
				label5.setFont(MyTools.f14);
				panel.add(label5);
		}
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(8, 1, 0, 0));
				panel1 = new JPanel();
				panel1.setOpaque(false); 
				panel.add(panel1);
				panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					textField = new JTextField();
					textField.setText((String) bbu_table.getValueAt(rowNum, 1));
					panel1.add(textField);
					textField.setColumns(10);
				panel2 = new JPanel();
				panel2.setOpaque(false); 
				panel.add(panel2);
				panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					textField_1 = new JTextField();
					textField_1.setText((String) bbu_table.getValueAt(rowNum, 2));
					panel2.add(textField_1);
					textField_1.setColumns(10);
				panel3 = new JPanel();
				panel3.setOpaque(false); 
				panel.add(panel3);
				panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					textField_2 = new JTextField();
					textField_2.setText((String) bbu_table.getValueAt(rowNum, 3));
					panel3.add(textField_2);
					textField_2.setColumns(10);
				panel4= new JPanel();
				panel4.setOpaque(false); 
				panel.add(panel4);
				panel4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					textField_3 = new JTextField();
					textField_3.setText((String) bbu_table.getValueAt(rowNum, 4));
					panel4.add(textField_3);
					textField_3.setColumns(10);
				panel5 = new JPanel();
				panel5.setOpaque(false); 
				panel.add(panel5);
				panel5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					textField_4 = new JTextField();
					textField_4.setText((String) bbu_table.getValueAt(rowNum, 5));
					panel5.add(textField_4);
					textField_4.setColumns(10);
				panel6 = new JPanel();
				panel6.setOpaque(false); 
				panel.add(panel6);
					panel6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					textField_5 = new JTextField();
					textField_5.setText((String) bbu_table.getValueAt(rowNum, 6));
					panel6.add(textField_5);
					textField_5.setColumns(10);
				panel7 = new JPanel();
				panel7.setOpaque(false); 
				panel.add(panel7);
					panel7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));				
					jcb1=new JComboBox<>(jg1);
					jcb1.setBackground(Color.white);
					jcb1.setPreferredSize(new Dimension(113,20));//����������ĸߺͿ�
					panel7.add(jcb1);
				panel8 = new JPanel();
				panel8.setOpaque(false);
				panel.add(panel8);
					panel8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					jcb2=new JComboBox<>(jg2);
					jcb2.setBackground(Color.white);
					jcb2.setPreferredSize(new Dimension(113,20));//����������ĸߺͿ�
					panel8.add(jcb2);
					//չ��
					setBounds(450, 150, 300, 300);
					this.setVisible(true);
	}
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
				JOptionPane.showMessageDialog(this,"X,Y,Z���겻��Ϊ��");
				return;
			}
			String RruTransPower=textField_3.getText();//RRU ���书��
			String user_num=textField_4.getText();//RRU���Ƿ�Χ�ڵ��û�����
			String CarrierFrequent=textField_5.getText();//��Ƶ
			boolean temp=isNumeric(X)&isNumeric(Y)&isNumeric(Z)&isNumeric(RruTransPower)&isNumeric(user_num)&isNumeric(CarrierFrequent);
			if(!(temp))
			{
				judge=false;
				//��ʾ
				JOptionPane.showMessageDialog(this,"����д���֣�");
				return;
			}
			if(judge==true)
			{
				String IsActivity="0";
				if(jcb1.getSelectedItem().equals("�ر�"))//0���رգ�1����
				{
					IsActivity="0";
				}else if(jcb1.getSelectedItem().equals("��"))
				{
					IsActivity="1";
				}
				String sql="update Rru set X=?,Y=?,Z=?,RruTransPower=?,UeNum=?,CarrierFrequent=?,IsActivity=?,RruAntennaId=? where RruId=?";
				String []paras={textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),
						textField_4.getText(),textField_5.getText(),IsActivity,(String) jcb2.getSelectedItem(),rru_id};
				rru_table=new Rru_Table_module();
				rru_table.add_delete_change_to_sql(sql, paras);
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
