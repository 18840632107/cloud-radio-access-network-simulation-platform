package com.config;

public enum EnumWirePathModel {
	vDefault("vDefault",0);//Ĭ�ϵ�ģ��
	private String vName;
	private int  vIndex;
	EnumWirePathModel(String name,int vIndex){
		
	}
	int get_value(){
		return vIndex;
	}
	public static EnumWirePathModel get_model(int vIndex){
		switch (vIndex) {
		case 0:
			return vDefault;
		default:
			return vDefault;
		}			
	}
}
