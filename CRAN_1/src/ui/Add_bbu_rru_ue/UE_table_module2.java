/*
 * ������UE_table_module2
 * ���ܣ�������������Panel����ʾ��ѯ���ݿ��ǰUE�ı�������ģ��
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
public class UE_table_module2 extends AbstractTableModel{
	//rowData������������� 
	//columNames�����������
	Vector rowData,columNames;
	Vector hang;
	JTextField jtf2,jtf3,jtf4;
	//int cannot_modify_row;
	int search_rownum;
	UE_table_module2 ue_table;
	/***************����UE�������******************/	
	public  UE_table_module2()
	{
		columNames=new Vector<>();
		//��������
		//columNames.add("");��ѡ��Ԥ����
		columNames.add("UE ID");
		columNames.add("X����(m)");
		columNames.add("Y����(m)");
		columNames.add("Z����(m)");
		columNames.add("��������Ϣ");
		columNames.add("��������");
		columNames.add("UEȺ ID");
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
					hang.add(rs.getString(1));//UE ID0
					hang.add(rs.getString(3));//X����1
					hang.add(rs.getString(4));//Y����2
					hang.add(rs.getString(5));//Z����3
					if(rs.getString(2)==null)
					{
						hang.add(rs.getString(2));//RRU��Դ���ȵķ�ʽ
					}else
					{
						if(rs.getString(2).equals("0"))//��������Ϣ4��1�����ڣ�0������
						{
							hang.add("����");
						}else if(rs.getString(2).equals("1"))
						{
							hang.add("����");
						}
					}
					hang.add(rs.getString(9));//��������5
					hang.add(rs.getString(11));//UEȺ ID
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

	@Override
	public int getColumnCount() {
		// TODO �Զ����ɵķ������
		return this.columNames.size();
	}

	@Override
	public String getColumnName(int column) {
		// TODO �Զ����ɵķ������
		return (String) this.columNames.get(column);
	}

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

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		((Vector) rowData.get(rowIndex)).remove(columnIndex);
		  ((Vector) rowData.get(rowIndex)).add(columnIndex, aValue);
		  this.fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);//��ת��stringҲû�й�ϵ
	}
	/**************������һ�� ******************/
	public void addRows(int ue_add_rownum) {
		String sql="exec RowMax ?";
		String []paras={"Ue"};
		ue_table=new UE_table_module2();
		ResultSet Ue_max_id=ue_table.total_num_sql(sql, paras);//ue_max_id����bbu��ǰ���id��
		
		Vector hang=new Vector<>();
		try {
			Ue_max_id.next();
			int temp=Ue_max_id.getInt(1)+ue_add_rownum;
			String ueid=Integer.toString(temp);
			hang.add(ueid);//UE�ı��
		} catch (SQLException e) {
			e.printStackTrace();
		}
		hang.add(jtf2);//X����
		hang.add(jtf3);//Y����
		hang.add(jtf4);//Z����	
		hang.add("");//��������Ϣ
		hang.add("");//��������
		hang.add("");//UEȺ ID
		//���뵽rowData
		rowData.add(hang);
		
	}
	
	//ɾ��
		public void remove_row(int rownum)
		{
			  if (rowData.size()> rownum) {
				  rowData.remove(rownum);
	          }
			
		}
	/**************�Ա�������� ɾ�� �޸Ĳ���******************/
	public boolean add_delete_change_to_sql(String sql,String []paras) {
		// TODO �Զ����ɵķ������
		BBU_sql sqlh=new BBU_sql();
		return sqlh.add_delete_change(sql, paras);
	}
	/**************�˺����������ݿ�ÿ���������������������Ŀ���ǵõ��������������Զ�����ID ******************/
	public ResultSet total_num_sql(String sql,String []paras)
	{
		BBU_sql sqlh=new BBU_sql();
		return sqlh.search(sql, paras);
	}

//	public void For_modify(int ue_add_row_alreaday2) {
//		// TODO �Զ����ɵķ������
//		cannot_modify_row=ue_add_row_alreaday2;
//	}
}
