package com.test;

import com.config.ConfigTti;


public class CppConfig {

	/**
	 * ���ط�������
	 * @param args
	 */
	public native void setConfiguration();
	public native void setConfigCase0(ConfigTti vSample);//Ĭ������һ ������󣬵��ö�����OBJECT[]����
	public native void setConfigCase1(ConfigTti vSample,int vMode);//Ĭ�����ö� ������� ����������
	public native void setConfigCase2(ConfigTti vSample,String name);//Ĭ��������,cpp�л�������û��string ֻ��תΪchar	
}
