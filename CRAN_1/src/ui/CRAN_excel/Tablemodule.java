package ui.CRAN_excel;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class Tablemodule extends AbstractTableModel{

	//rowData������������� 
	//columNames�����������
	Vector rowData,columNames;
	//���ѧ��(��ɾ��)
		public boolean change(String sql,String []paras)//�����û�гɹ�����һ������ֵ
		{
			//����һ��Sqlhelper,������򲢷��Բ����ǣ����԰�Sqlhelper���ɲ�����
			Data_operation sqlh=new Data_operation();
			return sqlh.add_delete_change(sql, paras);

		}

	//��ѯ���ʾ��ǳ�ʼ��
		public void search(String sql,String[]paras)
		{
			Data_operation sqlh=null;
			//�м�
					columNames=new Vector<>();
					//��������
					columNames.add("ID");
					columNames.add("3άλ����Ϣ");
					columNames.add("��������Ϣ");
					columNames.add("��������");
					rowData=new Vector<>();
					try {
						sqlh=new Data_operation();
						ResultSet rs=sqlh.search(sql, paras);
						while(rs.next())
						{
							//rowData���Դ�Ŷ���
							Vector hang=new Vector<>();
							hang.add(rs.getString(1));
							hang.add(rs.getString(2));
							hang.add(rs.getString(3));
							hang.add(rs.getString(4));
							//���뵽rowData
							rowData.add(hang);
							
						}
							
						
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
	public String getColumnName(int arg0) {
		// TODO �Զ����ɵķ������
		return (String) this.columNames.get(arg0);
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO �Զ����ɵķ������
		return ((Vector)this.rowData.get(row)).get(col);//��ת��stringҲû�й�ϵ
	}

}
