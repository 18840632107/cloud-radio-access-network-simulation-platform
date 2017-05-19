
package ui.running;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import ui.Share_bag.BBU_sql;

public class UEModifyModel extends AbstractTableModel{
	//rowData������������� 
		//columNames�����������
		Vector rowData,columNames;
		Vector hang;
		int search_rownum;
		public UEModifyModel()
		{
			columNames=new Vector<>();
			rowData=new Vector<>();
		}
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
						hang.add(rs.getString(1));//CaseNum
						hang.add(rs.getString(2));//CaseTTI
						hang.add(rs.getString(3));//AllUeModel
						hang.add(rs.getString(4));//UeGroupId
						hang.add(rs.getString(5));//VelocityUpper
						hang.add(rs.getString(6));//VelocityLower
						hang.add(rs.getString(7));//DirectionUpper
						hang.add(rs.getString(8));//DirectionLower
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
		public boolean judge_search(String sql,String[]paras)
		{
			BBU_sql sqlh=null;
			try {
				sqlh=new BBU_sql();
				ResultSet rs=sqlh.search(sql, paras);
				if(!rs.next()){
					return rs.next();	
				}} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}finally
				{
					//�ر�
					sqlh.close();
				}
				return true;
		}
		@Override
		public int getColumnCount() {
			// TODO �Զ����ɵķ������
			return this.columNames.size();
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
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO �Զ����ɵķ������
			((Vector) rowData.get(rowIndex)).remove(columnIndex);
			  ((Vector) rowData.get(rowIndex)).add(columnIndex, aValue);
			  this.fireTableCellUpdated(rowIndex, columnIndex);
		}
		//��� ɾ�� �޸�
		public boolean add_delete_change_to_sql(String sql,String []paras) {
			// TODO �Զ����ɵķ������
			BBU_sql sqlh=new BBU_sql();
			return sqlh.add_delete_change(sql, paras);
		}
		public ResultSet total_num_sql(String sql,String []paras)//�˺����������ݿ�ÿ���������������������Ŀ���ǵõ��������������Զ�����ID
		{
			BBU_sql sqlh=new BBU_sql();
			return sqlh.search(sql, paras);
		}
}
