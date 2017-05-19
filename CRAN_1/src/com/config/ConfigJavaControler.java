package com.config;

import java.util.Arrays;

/**
 * 
 * @author yaoyaodelaoda
 * ʱ����������������������������ʱ��������ã�
 * 
 *
 */
public final class ConfigJavaControler {
	public static String vSoftName="Cranƽ̨";
	/**���ط�ʽװ�䷽��*/
	public static EnumDemoCase vCaseVersion=EnumDemoCase.vDefaultDemo;//������صķ�ʽ
	/**ʱ�����ģ�����*/
	public static EnumSamplingInterval vIntervalUnit=EnumSamplingInterval.vTTI;//���������λ
	public static EnumSamplingFunction vSamplingFunction=EnumSamplingFunction.vEqualInterval;//������ʽ���ǵȼ�����������Զ���
	public static double vSimuT;//������ʱ������λ�ɷ��������λ����
	//public static int vTtiLength;//TTI����
	public static int vTtiTimeLength=1;//TTI��ʱ�䳤��1ms
	public static int vSamplingNum=10;//ÿ��������λ�������ĳ�����
	public static int vSamplingTime[]={0,1,2,3};//�洢������ʱ��,���������ĸ���
	/**Ui״̬����*/
	public static boolean vFlagPause=true;//��ͣ��ť
	public static boolean vFlagOptimazation=true;
	public static boolean vMeetOptimization=false;//�ж������Ż�
	public volatile static boolean vFlagOptiTriggle=false;
	public static String vLogCppFile="D:\\CRAN\\Log\\"+515+".txt";//log��־�ĵ�ַ��ÿ����һ���޸�һ���ļ�������ͳһ�ļ�������ȶ
	public volatile static String vLogList="log��Ϣ";
	/**����ʱ�����ʱ����Ҫ��
	 * ��vTTI��ʱ�䳤�Ƚ��к˶�����
	 * �ĳ��������Ƿ���ڳ�����
	 * λ�Ĺ涨*/
	public static void check() {
		switch (vIntervalUnit) {
		case vTTI:		
			assert vSamplingNum*vTtiTimeLength<1000 && vSamplingTime.length<vSimuT;//��λms
			break;
		case vMinute:
			assert vSamplingNum*vTtiTimeLength<60000 && vSamplingTime.length<vSimuT;//��λms
		case vHour:
			assert vSamplingTime.length<vSimuT;
		case vDay:
			assert vSamplingTime.length<vSimuT;
		default:
			assert vSamplingTime.length<vSimuT;
			break;
		}
	}
	/**
	 * �û����õȼ�����
	 * @param m:ÿm��������λTTI���г���
	 */
	public static void setSamplingEqual(EnumSamplingInterval vUnit,double vSimuT,int m,int vSamplingNum) {
		//���ó�����ʱ��vSimplingTime[]
		vIntervalUnit=vUnit;
		ConfigJavaControler.vSimuT=vSimuT;
		ConfigJavaControler.vSamplingNum=vSamplingNum;
		int counter=0;
		while (true) {
			vSamplingTime[counter]+=m;
			/**��ֹ���ڷ���ʱ��*/
			if (vSamplingTime[counter]>vSimuT) {
				break;
			}
			counter++;
		}
		
	}
	/**
	 * �û��Զ������ʱ��
	 * @param vUnit ������λ
	 * @param vSimuT������ʱ��
	 * @param m   �û��Զ������ʱ��
	 * @param vSamplingNum ÿ������ʱ�̵ĳ�����
	 */
	public static void setSamplingCustom(EnumSamplingInterval vUnit,double vSimuT,int m[],int vSamplingNum) {
		//���ó�����ʱ��vSimplingTime[]
		vIntervalUnit=vUnit;
		ConfigJavaControler.vSimuT=vSimuT;
		ConfigJavaControler.vSamplingNum=vSamplingNum;
		/**��ֹ�û����������˳�򲻶�*/
			Arrays.sort(m);
			vSamplingTime=m;
			if (vSamplingTime[m.length-1]>vSimuT) {
				System.err.println("ϵͳ��������:����ʱ�����ֵ������ʱ��");			
			}
			/**��ֹ���ڷ���ʱ��*/	
	}
}
