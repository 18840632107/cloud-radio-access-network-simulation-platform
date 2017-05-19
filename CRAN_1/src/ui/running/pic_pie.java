/*
 * ������pic_pie
 * ���ܣ�run3�����б�״ͼģ����
 */
package ui.running;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
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
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class pic_pie {
	ChartPanel frame1;
	PieDataset data;
	String TitleName;//ͼ�����
	JFreeChart chart;
	public  pic_pie(String TitleNames,PieDataset datasets){   
		data=datasets;
		TitleName=TitleNames;
//        chart = ChartFactory.createPieChart3D(TitleName,data,true,true,false);
		chart = ChartFactory.createPieChart(TitleName,data,true,true,false);
      //���ðٷֱ�  
        		  PiePlot pieplot = (PiePlot) chart.getPlot();  
        	      pieplot.setBackgroundPaint(SystemColor.WHITE); //���ñ�����ɫ
//        		  pieplot.setLabelFont(new Font("����", Font.PLAIN, 20));
//    	         TextTitle textTitle = chart.getTitle();
//    	         textTitle.setFont(new Font("����", Font.PLAIN, 20));
                  DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������  
                  NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����  
                  StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����  
                  pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�                  
              //û�����ݵ�ʱ����ʾ������  
                  pieplot.setNoDataMessage("��������ʾ");  
                  pieplot.setCircular(true);  
                  pieplot.setLabelGap(0.02D);  
//                  pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ  
//                  pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ  
                 chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
                 PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������  
                 piePlot.setLabelFont(new Font("����",Font.BOLD,10));//�������  
                 chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));
                 frame1=new ChartPanel (chart,true);  
                 frame1.setPreferredSize(new Dimension(440,300));
        
	}
	 public ChartPanel getChartPanel(){  
		     return frame1;  
		 }  
}
