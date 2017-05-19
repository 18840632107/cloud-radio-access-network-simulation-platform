package ui.Draft;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import ui.Share_bag.BBU_sql;

public class CRAN_drawtable extends AbstractTableModel{
	Vector rowData,columNames;
	public  CRAN_drawtable()
	{
		columNames=new Vector<>();
		
		//��������
		rowData=new Vector<>();
	}
	public void table_search_Bbupool(String sql, String[] paras) {
		// TODO �Զ����ɵķ������
		BBU_sql sqlh=null;
		try {
			sqlh=new BBU_sql();
			ResultSet rs=sqlh.search(sql, paras);
			while(rs.next())
			{
				//rowData���Դ�Ŷ���
				Vector hang=new Vector<>();
				hang.add(rs.getString(1));//BbuPoolId
				hang.add(rs.getString(2));//X
				hang.add(rs.getString(3));//Y
				hang.add(rs.getString(4));//Z
				hang.add(rs.getString(5));//AllRes
				hang.add(rs.getString(6));//ResLeft
				hang.add(rs.getString(7));//DynamicEnengy
				hang.add(rs.getString(8));//StaticEnengy
				hang.add(rs.getString(9));//BbuPoolInfo
				//���뵽rowData
				rowData.add(hang);
				
			}
			//search_rownum=this.getRowCount();
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
	public void table_search_Bbupoollink(String sql4, String[] paras4) {
		// TODO �Զ����ɵķ������
		// TODO �Զ����ɵķ������
				BBU_sql sqlh=null;
				try {
					sqlh=new BBU_sql();
					ResultSet rs=sqlh.search(sql4, paras4);
					while(rs.next())
					{
						//rowData���Դ�Ŷ���
						Vector hang=new Vector<>();
						hang.add(rs.getString(1));//LinkPathId
						hang.add(rs.getString(2));//LinkEnd1
						hang.add(rs.getString(3));//LinkEnd2
						hang.add(rs.getString(4));//RealLength
						hang.add(rs.getString(5));//LinkType
						hang.add(rs.getString(6));//MaxTransRate
						hang.add(rs.getString(7));//Attenuation
						hang.add(rs.getString(8));//Delay
						hang.add(rs.getString(9));//ErrorRate
						hang.add(rs.getString(10));//Cost
						hang.add(rs.getString(11));//LinkCircleId
						hang.add(rs.getString(12));//FibersNum
						//���뵽rowData
						rowData.add(hang);
						
					}
					//search_rownum=this.getRowCount();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}finally
				{
					//�ر�
					sqlh.close();
				}	
	}
}
