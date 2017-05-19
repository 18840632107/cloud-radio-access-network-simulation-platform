package com.database;

import java.io.File;

import ui.running.run2;

import com.config.ConfigJavaControler;
import com.config.ConfigTti;
import com.config.EnumDemoCase;
import com.config.EnumMovmentModel;
import com.config.EnumNetworkTrafficModel;
import com.config.EnumPathLossModel;
import com.config.EnumResourceModel;
import com.config.EnumResourceSheldual;
import com.config.EnumSamplingInterval;
import com.config.EnumSamplingFunction;
import com.config.EnumUeTrafficModel;
import com.config.EnumWirePathModel;
import com.help.HelpClass;

import jxl.Cell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.demo.ReadWrite;

public class ReadConfig {
	String vFileNameString="C:/Users/yaoyaodelaogong/Desktop/input2.xls";
	ReadWrite readWrite;
	int j;
	public ReadConfig(String vName) {
		vFileNameString=vName;
		 try    {
	            Workbook book  =  Workbook.getWorkbook( new  File( vFileNameString ));
	             //  ��õ�һ����������� 
	              Sheet sheet  =  book.getSheet( 0 );
	             //  �õ���һ�е�һ�еĵ�Ԫ�� 
                Cell cell1 ;
                
                //cell1 =  sheet.getCell( 1,  0 );	
  	            ConfigJavaControler.vSoftName="CRAN";
  	            //System.out.println("������ƣ�"+cell1.getContents());
                
                //��ȡ���õ�case
            //    cell1 =  sheet.getCell( 0,  1 );	
  	         //   ConfigJavaControler.vCaseVersion=EnumDemoCase.value(Integer.parseInt(cell1.getContents()));
//  	            System.out.println("ConfigJavaControler.vCaseVersion����"+cell1.getContents());

	           //��ȡ���浥λ
	            cell1=sheet.getCell(4, 1);
//	            System.out.println("��ȡ���浥λ"+cell1.getContents());
	            j =Integer.parseInt(cell1.getContents());
	            run2.jcb1.setSelectedItem(run2.jg1[j]);
	         //   ConfigJavaControler.vIntervalUnit=EnumSamplingInterval.get_model(Integer.parseInt(cell1.getContents()));//������ʽ���ǵȼ�����������Զ���
	            
	            cell1=sheet.getCell(3, 1);
//	            System.out.println("��ȡ���浥λ"+cell1.getContents());
	            j =Integer.parseInt(cell1.getContents());
	           // ConfigJavaControler.vTtiTimeLength = j;
	            run2.textField_2.setText(cell1.getContents());
	            //�Զ���������ǵȼ���������Ĵ���ʽ��Ϊ�����ݵ�һ���ԣ�����double���������ʽ
	            
	            cell1=sheet.getCell(2, 1);
	            j =Integer.parseInt(cell1.getContents());
	            run2.jcb2.setSelectedItem(run2.jg2[j]);
//	            System.out.println("�ȼ�����������Զ���"+cell1.getContents());
	          //  ConfigJavaControler.vSamplingFunction=EnumSamplingFunction.get_model(Integer.parseInt(cell1.getContents()));
	            
	            //������ʱ��
	            cell1  =  sheet.getCell( 5,  1 );
	            run2.textField_4.setText(cell1.getContents());
	           // ConfigJavaControler.vSimuT=Double.parseDouble((cell1.getContents()));//������ʱ������λ�ɷ��������λ����
	            
	            
	            
	        	//public static int vTtiLength;//TTI����
	            
	            //ÿ��������λ�������ĳ�����
	            if (run2.jcb2.getSelectedIndex() == 0) {
	            	cell1  =  sheet.getCell( 6, 1);
	            	run2.textField_1.setText(cell1.getContents());
	            	cell1  =  sheet.getCell( 7, 1 );
		            run2.tf.setText(cell1.getContents());
//		            ConfigJavaControler.vSamplingNum=Integer.parseInt(cell1.getContents());//�洢������ʱ��,���������ĸ���    
//		            ConfigJavaControler.vSamplingTime=new int[(int)ConfigJavaControler.vSimuT/ConfigJavaControler.vSamplingNum];
//		            for (int i = 0; i < (int)ConfigJavaControler.vSimuT/ConfigJavaControler.vSamplingNum; i++) {				
//						ConfigJavaControler.vSamplingTime[i]=ConfigJavaControler.vSamplingNum*i;
//					}
//					System.out.println("�����ĸ���"+ConfigJavaControler.vSimuT);
				}else {
					cell1  =  sheet.getCell( 6, 1);
					run2.textField_1.setText(cell1.getContents());
			          
//		            ConfigJavaControler.vSamplingNum=Integer.parseInt(cell1.getContents());//�洢������ʱ��,���������ĸ���    
		            cell1  =  sheet.getCell( 7, 1 );
		            run2.text.setText(cell1.getContents());
			          
//		            ConfigJavaControler.vSamplingTime=HelpClass.StringTrans2IntArray(cell1.getContents());//�洢������ʱ��,���������ĸ���          
		            
				}
	          
	            //  �û��ƶ���ģ��vEnumResourceSheldual vEnumUeTrafficModel vEnumNetworkTrafficMode
//	            cell1  =  sheet.getCell( 1, 7 );
	           ConfigTti.vMov=EnumMovmentModel.get_model(1);
	           System.out.println("�ƶ���ģ��ConfigTti.vMov");
	           
//	           cell1  =  sheet.getCell( 1, 8 );
	           ConfigTti.vPathLossModel=EnumPathLossModel.get_model(0);
	           System.out.println("·��ģ��ConfigTti.vPathLossModel");
	           
//	           cell1  =  sheet.getCell( 1, 9 );
	           ConfigTti.vBandwidthResourceModel=EnumResourceModel.get_model(0);
	           System.out.println("����ģ��ConfigTti.vResourceModel");
	           
//	           cell1  =  sheet.getCell( 1, 10 );
	           ConfigTti.vEnumUeTrafficModel=EnumUeTrafficModel.get_model(1);
	           System.out.println("�û�ҵ����ģ��ConfigTti.vResourceModel");
	           
//	           cell1  =  sheet.getCell( 1, 11 );
	           ConfigTti.vWirePathModel=EnumWirePathModel.get_model(0);
	           System.out.println("����ģ��ConfigTti.vWirePathModel");
	            
//	           cell1  =  sheet.getCell( 1, 12 );
	           ConfigTti.vEnumNetworkTrafficModel=EnumNetworkTrafficModel.get_model(0);
	           System.out.println("����ҵ����ģ��ConfigTti.vWirePathModel"); 
	           
//	           cell1  =  sheet.getCell( 1, 13 );
	           ConfigTti.vEnumResourceSheldual=EnumResourceSheldual.get_model(0);
	           System.out.println("����ĵ���ģ��vEnumResourceSheldual"); 
	           
	           book.close();//�رվ��
	            
	            
	        }    catch  (Exception e)   {
	            System.out.println(e);
	        }  
	}
	
	
}
