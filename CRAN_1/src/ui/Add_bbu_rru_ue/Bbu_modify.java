/*
 * ������Bbu_modify
 * ���ܣ�BBU�����޸Ľ���
 */
package ui.Add_bbu_rru_ue;

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

import ui.Share_bag.BBU_sql;
import ui.Share_bag.BackgroundPanel;
import ui.Share_bag.MyTools;



public class Bbu_modify extends JDialog implements ActionListener {
	String path="image"+File.separator+"ADD_Link"+File.separator+"modify.png";
	Image image=new ImageIcon(path).getImage(); 
	private final JPanel contentPanel = new BackgroundPanel(image);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7;
	JButton okButton,cancelButton;
	Bbu_table_module bbu_table;
	String bbu_id;
	JComboBox jcb1,jcb2;//�����б�
	String []jg1={"RRS","CIS","PFS"};//RRU�ĵ��ȷ�ʽ������дĬ����0,0��RRS 1:CIS 2:PFS
	Vector jg2;//�洢���뻷id
	/**************************************
	 * ���ܣ������޸Ľ���
	 ***************************************/
	//owner���ĸ�����
	//title������
	//modalָ��ģ̬���ڣ����Ƿ�ģ̬����
	public Bbu_modify(Dialog owner,String title,boolean modal,Bbu_table_module bbu_table,int rowNum) {
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
				JLabel lblBbu = new JLabel("BBU"+(String) bbu_table.getValueAt(rowNum, 0));
				lblBbu.setFont(MyTools.f1);
				bbu_id=(String) bbu_table.getValueAt(rowNum, 0);
				panel.add(lblBbu);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false); 
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new GridLayout(7, 1, 0, 0));//����һ��LinkID
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
				JLabel label2 = new JLabel("  ��Դ����");
				label2.setFont(MyTools.f14);
				panel.add(label2);
				JLabel label3 = new JLabel(" ���ȷ�ʽ��");
				label3.setFont(MyTools.f14);
				panel.add(label3);
				JLabel lblink = new JLabel(" ���뻷ID��");
				lblink.setFont(MyTools.f14);
				panel.add(lblink);
		}
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false); 
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(7, 1, 0, 0));//����һ��LinkID
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
					jcb1=new JComboBox<>(jg1);
					jcb1.setBackground(Color.white);
					jcb1.setPreferredSize(new Dimension(113,20));//����������ĸߺͿ�
					panel6.add(jcb1);
					
				panel7 = new JPanel();
				panel7.setOpaque(false); 
				panel.add(panel7);
				panel7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
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
					panel7.add(jcb2);
					//չ��
					setBounds(500, 150, 300, 300);
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
		}
		String TransPower=textField_3.getText();//���书��
		String Res=textField_4.getText();//��Դ��
		boolean temp=isNumeric(X)&isNumeric(Y)&isNumeric(Z)&isNumeric(TransPower)&isNumeric(Res);
		if(!(temp))
		{
			judge=false;
			//��ʾ
			JOptionPane.showMessageDialog(this,"����д���֣�");
			return;
		}
		if(judge==true)
		{
			String SchedualRruMode="0";
			if(jcb1.getSelectedItem().equals("RRS"))//0��RRS 1:CIS 2:PFS
			{
				SchedualRruMode="0";
			}else if(jcb1.getSelectedItem().equals("CIS"))
			{
				SchedualRruMode="1";
			}else if(jcb1.getSelectedItem().equals("PFS"))
			{
				SchedualRruMode="2";
			}
			String sql="update Bbu set X=?,Y=?,Z=?,TransPower=?,Res=?,SchedualRruMode=?,LinkId=?  where BbuId=?";
			String []paras={textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),SchedualRruMode,(String) jcb2.getSelectedItem(),bbu_id};
			bbu_table=new Bbu_table_module();
			bbu_table.add_delete_change_to_sql(sql, paras);
			
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
	if(index<0)
	{
		for (int i = str.length();--i>=0;)
		  {    
			   if (!Character.isDigit(str.charAt(i)))
			   {  
			    return false;  
			   }
		   }
	}
	else{
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
