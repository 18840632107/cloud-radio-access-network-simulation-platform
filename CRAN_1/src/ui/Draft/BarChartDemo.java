package ui.Draft;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartDemo {
	 ChartPanel frame1;  
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		CategoryDataset dataset = getDataSet(); 
        JFreeChart chart = ChartFactory.createBarChart3D( 
                           "ˮ������ͼ", // ͼ�����
                           "ˮ��", // Ŀ¼�����ʾ��ǩ
                           "����", // ��ֵ�����ʾ��ǩ
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,  // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������ false)
                            false, // �Ƿ����ɹ���
                            false  // �Ƿ����� URL ����
                            ); 
        //��������
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
        CategoryAxis domainAxis = categoryplot.getDomainAxis();  
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(new Font("����", Font.PLAIN, 20));      
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
        numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));
        FileOutputStream fos_jpg = null; 
        try { 
            fos_jpg = new FileOutputStream("D:\\BarChart.jpg"); 
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f,chart,400,300,null); 
        } finally { 
            try { 
                fos_jpg.close(); 
            } catch (Exception e) {} 
        } 

	}
	/** 
	 * ��ȡһ����ʾ�õļ����ݼ�����
	 * @return 
	 */ 
	 private static CategoryDataset getDataSet() { 
	     DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	     dataset.addValue(100, "", "ƻ��"); 
	     dataset.addValue(200, "", "����"); 
	     dataset.addValue(300, "", "����"); 
	     dataset.addValue(400, "", "�㽶"); 
	     dataset.addValue(500, "", "��֦"); 
	     return dataset; 
	 } 
}

