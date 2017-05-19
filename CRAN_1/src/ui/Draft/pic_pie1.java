package ui.Draft;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class pic_pie1{
	ChartPanel frame1;
	public  pic_pie1(){  
		DefaultPieDataset data = getDataSet();  
        JFreeChart chart = ChartFactory.createPieChart3D("ˮ������",data,true,false,false);
      //���ðٷֱ�  
                  PiePlot pieplot = (PiePlot) chart.getPlot();  
                  DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������  
                  NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����  
                  StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����  
                  pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�                  
              //û�����ݵ�ʱ����ʾ������  
                  pieplot.setNoDataMessage("��������ʾ");  
                  pieplot.setCircular(false);  
                  pieplot.setLabelGap(0.02D);  
                  pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ  
                  pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ  
                 chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
                 PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������  
                 piePlot.setLabelFont(new Font("����",Font.BOLD,10));//�������  
                 chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));
                 frame1=new ChartPanel (chart,true);  
                 frame1.setPreferredSize(new Dimension(300,300));
        
	}
	/** 
	 * ��ȡһ����ʾ�õļ����ݼ�����
	 * @return 
	 */ 
	 private static DefaultPieDataset getDataSet() { 
		 DefaultPieDataset dataset = new DefaultPieDataset();  
	     dataset.setValue("ƻ��",100);  
	     dataset.setValue("����",200);  
	     dataset.setValue("����",300);  
	     dataset.setValue("�㽶",400);  
	     dataset.setValue("��֦",500);  
	     return dataset;  


	 } 
	 public ChartPanel getChartPanel(){  
		     return frame1;  
		 }  
}
