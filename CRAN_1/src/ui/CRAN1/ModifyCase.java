package ui.CRAN1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ui.Add_bbu_rru_ue.Bbu_table_module;
import ui.Share_bag.BBU_sql;

public class ModifyCase extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_name;
	JButton okButton,cancelButton;
	JTextArea textArea_remark;
	CaseTableModule case_table;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ModifyCase dialog = new ModifyCase();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
//	public ModifyCase() {
	public ModifyCase(Dialog owner,String title,boolean modal,CaseTableModule case_table,int rowNum) {
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
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
						textField_name.setEditable(false);
						textField_name.setText((String) case_table.getValueAt(rowNum, 0));
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
					textArea_remark.setText((String) case_table.getValueAt(rowNum, 1));
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
		if(arg0.getSource()==okButton)//�޸�
		{
			boolean b=true;
			//PCase����½�����
			String name=textField_name.getText();
			String remark=textArea_remark.getText();
			String sql="update PCase set caseRemark=? where caseName=?";
			String []paras={remark,name};
			case_table=new CaseTableModule();
			b=case_table.add_delete_change_to_sql(sql, paras);
			if(b==true)
			{
				JOptionPane.showMessageDialog(this, "�޸�ʵ���ɹ�");//�����Ի���
			}else
			{
				JOptionPane.showMessageDialog(this, "�޸�ʵ��ʧ��");//�����Ի���
			}
			this.dispose();//�رնԻ���
		}
		else if(arg0.getSource()==cancelButton)//ȡ��
		{
			this.dispose();//�رնԻ���
		}
	}
}