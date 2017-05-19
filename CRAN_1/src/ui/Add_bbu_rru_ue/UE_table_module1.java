/*
 * ������UE_table_module1
 * ���ܣ�������������Panel����ʾ��ѯ���ݿ��ǰUEȺ�ı�������ģ��
 */
package ui.Add_bbu_rru_ue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.*;

import ui.Share_bag.BBU_sql;
import ui.CRAN_excel.Data_operation;
public class UE_table_module1 extends AbstractTableModel{
	//rowData������������� 
	//columNames�����������
	Vector rowData,columNames;
	Vector hang;
	JTextField jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	UE_table_module1 uegroup_table;
//	int cannot_modify_row;
	int search_rownum;
	/***************����UEȺ�������******************/
	public  UE_table_module1()
	{
		columNames=new Vector<>();
		//��������
		//columNames.add("");��ѡ��Ԥ����
		columNames.add("UEȺID");
		columNames.add("UE����");	
		columNames.add("����X����(m)");
		columNames.add("����Y����(m)");
		columNames.add("�ֲ���ʽ");
		columNames.add("����뾶(m)");
		columNames.add("��������Ϣ");
		columNames.add("��������");
		rowData=new Vector<>();
	}
	/***************����õ���ʾÿ�ж�Ӧ���ݿ�����ĺ���******************/
	public void table_search(String sql,String[]paras)
	{
		BBU_sql sqlh=null;
			try {
				sqlh=new BBU_sql();
				ResultSet rs=sqlh.search(sql, paras);
				while(rs.next())
				{
					//rowData���Դ�Ŷ���
					Vector hang=new Vector<>();
					hang.add(rs.getString(1));//UEȺ ID0
					hang.add(rs.getString(8));//UE����
					hang.add(rs.getString(3));//����X����1
					hang.add(rs.getString(4));//����Y����2
					hang.add("����ֲ�");
					hang.add(rs.getString(2));//R
					if(rs.getString(6)==null)
					{
						hang.add(rs.getString(6));//��������Ϣ4��1�����ڣ�0������
					}else{
						if(rs.getString(6).equals("0"))//��������Ϣ4��1�����ڣ�0������
						{
							hang.add("����");
						}else if(rs.getString(6).equals("1"))
						{
							hang.add("����");
						}
					}
					hang.add(rs.getString(7));//��������5
					//���뵽rowData
					rowData.add(hang);
					
				}
				search_rownum=this.getRowCount();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally
			{
				//�ر�
				sqlh.close();
			}	
		}

	//��ձ��
	public void  clean_all() {
		try {
			rowData.clear();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/***************�õ��������******************/
	@Override
	public int getColumnCount() {
		// TODO �Զ����ɵķ������
		return this.columNames.size();
	}
	/***************�õ�������� ******************/
	@Override
	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.rowData.size();
	}
	@Override
	public String getColumnName(int column) {
		// TODO �Զ����ɵķ������
		return (String) this.columNames.get(column);
	}
	/**************���ñ�������Ƿ�����޸� ******************/	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		if(rowIndex<search_rownum)
		{
			return false;
		}else
		{
			return true;
		}
		
	}
	/**************���ñ��ڼ��еڼ�����ֵ ******************/
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		 ((Vector) rowData.get(rowIndex)).remove(columnIndex);
		  ((Vector) rowData.get(rowIndex)).add(columnIndex, aValue);
		  this.fireTableCellUpdated(rowIndex, columnIndex);
	}
	/**************���ر��ڼ��еڼ�����ֵ ******************/
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);//��ת��stringҲû�й�ϵ
	}
	/**************������һ�� ******************/
	public void addRows(int uegroup_add_rownum) {
		String sql="exec RowMax ?";
		String []paras={"UeGroup"};
		uegroup_table=new UE_table_module1();
		ResultSet Uegroup_max_id=uegroup_table.total_num_sql(sql, paras);//ue_max_id����bbu��ǰ���id��
		
		Vector hang=new Vector<>();
		try {
			Uegroup_max_id.next();
//			if(Uegroup_max_id.getString(1)==null)
//			{
//				uegroup_id=-1+uegroup_add_rownum;
//			}else
//			{
				int temp=Uegroup_max_id.getInt(1)+uegroup_add_rownum;
				String uegroup_id=Integer.toString(temp);
//			}
			hang.add(uegroup_id);//UE�ı��
		} catch (SQLException e) {
			e.printStackTrace();
		}
		hang.add("10");//UE����			
		hang.add(jtf3);//X����
		hang.add(jtf4);//Y����
		hang.add("����ֲ�");//�ֲ���ʽ
		hang.add(jtf6);//����뾶
		hang.add(jtf7);//��������Ϣ
		hang.add(jtf8);//��������
		//���뵽rowData
		rowData.add(hang);
		
	}


	/**************�Ա�������� ɾ�� �޸Ĳ���******************/
	public boolean add_delete_change_to_sql(String sql,String []paras) {
		// TODO �Զ����ɵķ������
		BBU_sql sqlh=new BBU_sql();
		return sqlh.add_delete_change(sql, paras);
	}
	/**************�˺����������ݿ�ÿ���������������������Ŀ���ǵõ��������������Զ�����ID ******************/
	public ResultSet total_num_sql(String sql,String []paras)//�˺����������ݿ�ÿ���������������������Ŀ���ǵõ��������������Զ�����ID
	{
		BBU_sql sqlh=new BBU_sql();
		return sqlh.search(sql, paras);
	}

	
	
}
