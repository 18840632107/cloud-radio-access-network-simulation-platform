package ui.Draft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;


public class a extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	JSplitPane splitPane;
	JPanel panel1,panel_1,panel2,panel2_1,panel2_2,panel2_2_1;
	JButton button1,button2;
	JTextField textField,textField_1,textField_2,textField_3;
	
	int bbupool_num;
	DefaultMutableTreeNode node_second2_1,node_second2_2,node_second2_3,node_second2_4,node_second3_1,node_second3_2,node_second3_3,
	node_second4_1,node_second4_2,node_second4_3,node_second4_4,node_second4_5;
	JTree Treeroot=null;
	JTable jt1,jt2;
	JScrollPane jsp1,jsp2;
//	JCheckBox jc1,jc2,jc;//��ѡ��
//	JComboBox jcb1,jcb2,jcb3;//�����б�
	private JPanel panel;
	private JPanel panel_2, panel_3,panel_4,panel_5,panel_6,panel_7,panel_8,panel_9,panel_10,panel_11;
	private JButton button,button_1,button_2,btnNewButton,btnNewButton_1,btnNewButton_2;
//	String []jg1={"�ֲ�0","�ֲ�1","�ֲ�2"};//����
//	String []jg2={"����","����"};//����
//	String []jg3={"����0","����1","����2"};//����

	public static void main(String[] args) {
		try {
			//Ue_add dialog = new Ue_add();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public a() {
		//���ô�������
		setTitle("UE��������");
		setBounds(100, 100, 910, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		splitPane = new JSplitPane();
		contentPanel.add(splitPane);
		panel1 = new JPanel();
//����
		splitPane.setLeftComponent(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		{
			JLabel label = new JLabel("��Ԫ�б�");
			label.setFont(new Font("����", Font.BOLD, 20));
			panel1.add(label, BorderLayout.NORTH);
		}
		{
			panel_1 = new JPanel();
			panel1.add(panel_1, BorderLayout.CENTER);
			panel_1.setBackground(Color.white);
			//build_tree();
			panel_1.add(Treeroot, BorderLayout.CENTER);
			
		}
//����
		panel2 = new JPanel();
		splitPane.setRightComponent(panel2);
		panel2.setLayout(new BorderLayout(0, 0));
		
		
		panel2_2 = new JPanel();
		panel2.add(panel2_2, BorderLayout.NORTH);
		panel2_2.setLayout(new GridLayout(2, 1, 0, 0));//4��1�еı��
		//��1��
		JLabel lblBbu = new JLabel("UE����¼��");
		panel2_2.add(lblBbu);
		lblBbu.setFont(new Font("����", Font.BOLD, 20));
		//��2��
		panel2_2_1 = new JPanel();
		panel2_2.add(panel2_2_1);
		{
			JLabel lblBbu_1 = new JLabel("BBU�ظ�����");//����������������ʱ������bbupool_num
//			panel2_2_1.add(lblBbu_1);
//			int temp_bbupool_num=bbupool_num;
//			String string_bbupool_num=Integer.toString(temp_bbupool_num);
//			textField = new JTextField(string_bbupool_num,5);
			panel2_2_1.add(textField);	
		}
		{
			JLabel lblBbu_2 = new JLabel("BBU������");//��Ҫ�������ݿ�
			panel2_2_1.add(lblBbu_2);
//			//��Ҫ�������ݿ�
//			bbu_module=new bbu_module().bbumodule();;
//			bbu_num=new bbu_module().bbumodule().getRowCount();//bbupool_numһ���м���bbu��
//			int temp_bbu_num=bbu_num;
//			String string_bbu_num=Integer.toString(temp_bbu_num);
//			textField_1 = new JTextField(string_bbu_num,5);
			panel2_2_1.add(textField_1);
		}
		{
			JLabel lblRru = new JLabel("RRU������");
			panel2_2_1.add(lblRru);
//			//��Ҫ�������ݿ�
//			rru_module=new rru_module().rrumodule();;
//			rru_num=new rru_module().rrumodule().getRowCount();//bbupool_numһ���м���bbu��
//			int temp_rru_num=rru_num;
//			String string_rru_num=Integer.toString(temp_rru_num);
//			textField_2 = new JTextField(string_rru_num,5);
			panel2_2_1.add(textField_2);
		}
		{
			JLabel lblUe = new JLabel("UE������");
			panel2_2_1.add(lblUe);
//			//��Ҫ�������ݿ�
//			ue_module=new ue_module().uemodule();;
//			ue_num=new ue_module().uemodule().getRowCount();//bbupool_numһ���м���bbu��
//			int temp_ue_num=ue_num;
//			String string_ue_num=Integer.toString(temp_ue_num);
//			textField_3 = new JTextField(string_ue_num,5);
			panel2_2_1.add(textField_3);
		}
//�����Ϣ�Ĳ���		
		panel = new JPanel();
		panel2.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		//�ϰ벿��
		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));
		
		panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//		
//		jc1=new JCheckBox("ȫѡ");//��ѡ��
//		jc1.addActionListener(this);
//		panel_8.add(jc1);
		button_1 = new JButton("���");
		button_1.addActionListener(this);
		panel_8.add(button_1);
		
		button_2 = new JButton("����");
		button_2.addActionListener(this);
		panel_8.add(button_2);
		
		panel_9 = new JPanel();
		panel_4.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		button = new JButton("ɾ��");
		panel_9.add(button);
		panel_5 = new JPanel();
		panel_5.setLayout(new BorderLayout());
		panel_3.add(panel_5, BorderLayout.CENTER);
//		uep1=new ue1_add_panel();
//		uep1.ue1_add_panel(0);	
//		jt1=new JTable(uep1);
//		jt1.addMouseListener(this);
////		jt1.setRowSelectionAllowed(false);
//		//jt1.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		jt1.setRowSelectionAllowed(true);//ʹ�ñ���ѡȡ������Ϊ��λ,����������Ϊ��λ.����û��д����,����ѡȡ�������ʱ������Ϊ��λ.
//		selectionMode1=jt1.getSelectionModel();
//		selectionMode1.addListSelectionListener(this);
//		selectionMode1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//����ѡ��
		//��ʼ��jsp
		jsp1=new JScrollPane(jt1);
		//��jsp���뵽JFrame��
		panel_5.add(jsp1);
		//�°벿��
		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(1, 2, 0, 0));
		
		panel_10 = new JPanel();
		panel_6.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
//		jc2=new JCheckBox("ȫѡ");//��ѡ��
//		panel_10.add(jc2);
		btnNewButton_2 = new JButton("���");
		panel_10.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("����");
		panel_10.add(btnNewButton_1);
		
		panel_11 = new JPanel();
		panel_6.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnNewButton = new JButton("ɾ��");
		panel_11.add(btnNewButton);
		
		panel_7 = new JPanel();
		panel_7.setLayout(new BorderLayout());
		panel_2.add(panel_7, BorderLayout.CENTER);
		
		
//		jt2=new JTable(uep2);
////		String []jg2={"����","����"};//����
//		jcb2=new JComboBox<>(jg2);
////		String []jg3={"����0","����1","����2"};//����
//		jcb3=new JComboBox<>(jg3);
//		jt2.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(jcb2));//���Ǵ�0��ʼ����
//		jt2.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(jcb3));
//		
//		jt2.getColumnModel().getColumn(0).setCellEditor(this.jt2.getDefaultEditor(Boolean.class)); //��Ӹ�ѡ��
//		jt2.getColumnModel().getColumn(0).setCellRenderer(this.jt2.getDefaultRenderer(Boolean.class));//������ʽ
//		jt2.setRowHeight(21);//�����и�

		//��ʼ��jsp
		jsp2=new JScrollPane(jt2);
		//��jsp���뵽JFrame��
		panel_7.add(jsp2);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("�˳�");
				cancelButton.setActionCommand("�˳�");
				buttonPane.add(cancelButton);
			}
		}
	}

//	private void build_tree() {
//		// TODO �Զ����ɵķ������
//		//�����б�
//		//���ڵ�
//		DefaultMutableTreeNode root = new DefaultMutableTreeNode("���ڵ�");
//		
//		//һ���ڵ�
//		String sql="select * from BbuPool where 1=?";
//		String []paras={"1"};
//		bbuc=new Num_search_module();
//		bbuc.search_num(sql, paras,1);//ֻ��ҪBBU�صĵ�һ�����ݣ���ȡBBU�ص�ID��,��Ϊbbu�ص�id���ǲ������ġ�
//		bbupool_num=bbuc.getRowCount();
//		for(int i=0;i<bbupool_num;i++)//i�����ʾ�ڼ��У���������������ID��
//		{
//			DefaultMutableTreeNode node_first = new DefaultMutableTreeNode("BBU��"+bbuc.getValueAt(i, 0));
//			//�����ڵ�
//			String sql2="select * from Bbu where BbuPoolId=?";
//			//int temp=i;
//			//String BbuPoolId=String.valueOf(temp);//ת����int temp����>String temp�ˣ����Բ���ֱ����int i��Ҫ��һ����ʱ����temp
////			String BbuPoolId=Integer.toString(i);//int����ת����string����
//			String BbuPoolId=(String) bbuc.getValueAt(i, 0);
//			String []paras2={BbuPoolId};
//			bbu=new Num_search_module();
//			bbu.search_num(sql2, paras2,2);//��ҪBBU���������ݣ���ȡBBU��ID�ţ���BBU�ص�ID��
//			int bbu_num=bbu.getRowCount();
//			for(int j=0;j<bbu_num;j++)
//			{
//				DefaultMutableTreeNode node_second = new DefaultMutableTreeNode("BBU"+bbu.getValueAt(j, 0),false);
//				
//				node_first.add(node_second);
//			}
//			root.add(node_first);
//		}
//		//���ø��ڵ�ֱ�Ӵ�����Treeroot
//		Treeroot=new JTree(root);
//		TreeSelectionModel treeSelectionModel;//�������ѡ��ģʽ
//		treeSelectionModel=Treeroot.getSelectionModel();
//		//��������ѡ��ģʽΪ��ѡ
//		treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//		
//		panel_1.add(Treeroot, BorderLayout.CENTER);
//		//������
//		Treeroot.setRootVisible(false);//�޸��ڵ�
//		Treeroot.setRowHeight(20);//���ڵ���и�
//		DefaultTreeCellRenderer treeCellRenderer=new DefaultTreeCellRenderer();//������ڵ�Ļ��ƶ���
//		treeCellRenderer=(DefaultTreeCellRenderer)Treeroot.getCellRenderer();
//		treeCellRenderer.setLeafIcon(null);
//		treeCellRenderer.setClosedIcon(null);
//		treeCellRenderer.setOpenIcon(null);
//		Treeroot.setFont(new Font("����", Font.PLAIN, 20));
//	}
//	
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		// TODO �Զ����ɵķ������
//		if(arg0.getSource()==button_1)//ue1�����
//		{
//			ue1_row_num=ue1_row_num+1;//���������������ݵ�����
//			System.out.println(ue1_row_num);
//			uep1=new ue1_add_panel();
//			uep1.ue1_add_panel(ue1_row_num);;
//			jt1.setModel(uep1);
//			
//////			String []jg1={"�ֲ�0","�ֲ�1","�ֲ�2"};//����
////			jcb1=new JComboBox<>(jg1);
//////			String []jg2={"����","����"};//����
////			jcb2=new JComboBox<>(jg2);
//////			String []jg3={"����0","����1","����2"};//����
////			jcb3=new JComboBox<>(jg3);
////			jt1.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jcb1));
////			jt1.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(jcb2));
////			jt1.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(jcb3));
////			
////			jt1.getColumnModel().getColumn(0).setCellEditor(this.jt1.getDefaultEditor(Boolean.class)); //��Ӹ�ѡ��
////			jt1.getColumnModel().getColumn(0).setCellRenderer(this.jt1.getDefaultRenderer(Boolean.class));//������ʽ
////			jt1.setRowHeight(21);//�����и�
//		}else if(arg0.getSource()==button_2)//ue1��ɾ��
//		{
//
//			if(select_row_num.length==0)//����û�û��ѡ��ĳһ��
//			{
//				//��ʾ
//				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
//				return;
//			}
//			
////			for(int i=0;i<select_row_num.length;i++)
////			{
////			System.out.println(select_row_num[i]+1);
////			}
//			
//			if(ue1_row_num>0)
//			{
//				uep1.removeRows(select_row_num, select_row_num.length);
//				ue1_row_num=ue1_row_num-select_row_num.length;//ue1_row_numɾ������ʣ�༸��
//				System.out.println("ok"+ue1_row_num);
//				uep1.fireTableRowsDeleted(select_row_num[0], select_row_num[select_row_num.length-1]);
//				uep1.ue1_add_panel(ue1_row_num);;
//				jt1.setModel(uep1);
//			}
//			if(ue1_row_num==0)
//			{
//				//���ɾ����һ�ж�û�У���ô��
//			}
//		}
//		else if(arg0.getSource()==button)//ue1������
//		{
//			
//		}else if(arg0.getSource()==btnNewButton)//ue2������
//		{
//			
//		}if(arg0.getSource()==btnNewButton_1)//ue2�����
//		{
//			
//		}else if(arg0.getSource()==btnNewButton_2)//ue2��ɾ��
//		{
//			
//		}
//		
//	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}


	
		
	
}

