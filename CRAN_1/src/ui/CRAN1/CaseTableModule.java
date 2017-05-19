package ui.CRAN1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import ui.Add_bbu_rru_ue.Bbu_table_module;
import ui.Share_bag.BBU_sql;

public class CaseTableModule extends AbstractTableModel{
	//rowData������������� 
			//columNames�����������
			Vector rowData,columNames;
			Vector hang;
			int search_rownum;
			/***************������,����******************/	
			public CaseTableModule()
			{
				columNames=new Vector<>();
				//��������
				//columNames.add("");��ѡ��Ԥ����
				columNames.add("ʵ����");
				columNames.add("��ע");
				rowData=new Vector<>();
			}
			/***************��ѯ����õ���ʾÿ�ж�Ӧ���ݿ�����ĺ���******************/
			public void case_table_search(String sql,String[]paras)
			{
				BBU_sql sqlh=null;
					try {
						sqlh=new BBU_sql();
						ResultSet rs=sqlh.search(sql, paras);
						while(rs.next())
						{
							//rowData���Դ�Ŷ���
							Vector hang=new Vector<>();
							hang.add(rs.getString(1));//ʵ����
							hang.add(rs.getString(2));//��ע
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
	public String getColumnName(int column) {
		// TODO �Զ����ɵķ������
		return (String) this.columNames.get(column);
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������//��ʱ��Ϊ���ܱ༭��֮�����
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
//	/**************������һ�� ******************/
//	public void addRows() {
//		// TODO �Զ����ɵķ������
//		
//		Vector hang=new Vector<>();
//		hang.add("");//
//		hang.add("");//
//		//���뵽rowData
//		rowData.add(hang);
//	}
	/**************�Ա�������� ɾ�� �޸Ĳ���******************/
	public boolean add_delete_change_to_sql(String sql,String []paras) {
		// TODO �Զ����ɵķ������
		BBU_sql sqlh=new BBU_sql();
		return sqlh.add_delete_change(sql, paras);
	}
}
