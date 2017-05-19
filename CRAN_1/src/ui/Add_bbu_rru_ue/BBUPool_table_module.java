/*
 * ������BBUPool_table_module
 * ���ܣ�������������Panel����ʾ��ѯ���ݿ��ǰBBUPOOL�ı�������ģ��
 */
package ui.Add_bbu_rru_ue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import ui.Share_bag.BBU_sql;

public class BBUPool_table_module extends AbstractTableModel{
		//rowData������������� 
		//columNames�����������
		Vector rowData,columNames;
		Vector hang;
		int search_rownum;
		BBUPool_table_module BBUPool_table;
		//panel�õĲ�ѯ��ʾ�ĺ���
		public BBUPool_table_module()
		{
			columNames=new Vector<>();
			//��������
			//columNames.add("");��ѡ��Ԥ����
			columNames.add("BbuPool ID");
			columNames.add("X����(m)");
			columNames.add("Y����(m)");
			columNames.add("Z����(m)");
			columNames.add("��ע");
			rowData=new Vector<>();
		}
		public void bbupool_table_search(String sql,String[]paras)
		{
			BBU_sql sqlh=null;
				try {
					sqlh=new BBU_sql();
					ResultSet rs=sqlh.search(sql, paras);
					while(rs.next())
					{
						//rowData���Դ�Ŷ���
						Vector hang=new Vector<>();
						hang.add(rs.getString(1));//BBUpool��ID
						hang.add(rs.getString(2));//X����
						hang.add(rs.getString(3));//Y����
						hang.add(rs.getString(4));//Z����
						hang.add(rs.getString(9));//��ע
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

	/***************��ձ��******************/
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
	/***************�õ��������******************/
	@Override
	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.rowData.size();
	}
	/***************�õ��ڼ��еڼ��е�����******************/
	@Override
	public Object getValueAt(int row, int col) {
		// TODO �Զ����ɵķ������
		return ((Vector)this.rowData.get(row)).get(col);//��ת��stringҲû�й�ϵ
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
	public String getColumnName(int column) {
		// TODO �Զ����ɵķ������
		return (String) this.columNames.get(column);
	}
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		((Vector) rowData.get(rowIndex)).remove(columnIndex);
		  ((Vector) rowData.get(rowIndex)).add(columnIndex, aValue);
		  this.fireTableCellUpdated(rowIndex, columnIndex);
	}
	/***************���һ��******************/
		public void addRows(int bbu_add_rownum) {
			// TODO �Զ����ɵķ������
			
			String sql="exec RowMax ?";
			String []paras={"BbuPool"};
			BBUPool_table=new BBUPool_table_module();
			ResultSet Bbu_max_id=BBUPool_table.total_num_sql(sql, paras);//Bbu_max_id����bbu��ǰ���id��
			
			Vector hang=new Vector<>();
			try {
				Bbu_max_id.next();
				int temp=Bbu_max_id.getInt(1)+bbu_add_rownum;
				String bbuid=Integer.toString(temp);
				hang.add(bbuid);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}//BBU�ı��
			hang.add("");//X����
			
			hang.add("");//Y����
			
			hang.add("");//Z����
			hang.add("");//��ע
			//���뵽rowData
			rowData.add(hang);
			
		}
		/***************���ú�̨�������ݿ⺯��ʵ�֣���� ɾ�� �޸�******************/
		public boolean add_delete_change_to_sql(String sql,String []paras) {
			// TODO �Զ����ɵķ������
			BBU_sql sqlh=new BBU_sql();
			return sqlh.add_delete_change(sql, paras);
		}
		/***************�˺����������ݿ�ÿ���������������������Ŀ���ǵõ��������������Զ�����ID******************/
		public ResultSet total_num_sql(String sql,String []paras)
		{
			BBU_sql sqlh=new BBU_sql();
			return sqlh.search(sql, paras);
		}

}
