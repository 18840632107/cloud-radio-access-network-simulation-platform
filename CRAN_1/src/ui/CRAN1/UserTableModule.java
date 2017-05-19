package ui.CRAN1;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import ui.Share_bag.BBU_sql;

public class UserTableModule extends AbstractTableModel{
	//rowData������������� 
		//columNames�����������
		Vector rowData,columNames;
		Vector hang;
		int search_rownum;
		/***************����������******************/	
		public UserTableModule()
		{
			columNames=new Vector<>();
			//��������
			//columNames.add("");��ѡ��Ԥ����
			columNames.add("�ʻ���");
			columNames.add("Ȩ��");
			rowData=new Vector<>();
		}
		/***************��ѯ����õ���ʾÿ�ж�Ӧ���ݿ�����ĺ���******************/
		public void user_table_search(String sql,String[]paras)
		{
			BBU_sql sqlh=null;
				try {
					sqlh=new BBU_sql();
					ResultSet rs=sqlh.search(sql, paras);
					while(rs.next())
					{
						//rowData���Դ�Ŷ���
						Vector hang=new Vector<>();
						hang.add(rs.getString(2));//�ʻ���
						hang.add(rs.getString(3));//Ȩ��
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
	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.rowData.size();
	}

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
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		((Vector) rowData.get(rowIndex)).remove(columnIndex);
		  ((Vector) rowData.get(rowIndex)).add(columnIndex, aValue);
		  this.fireTableCellUpdated(rowIndex, columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		// TODO �Զ����ɵķ������
		return (String) this.columNames.get(column);
	}

}
