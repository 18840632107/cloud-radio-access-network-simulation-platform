package com.config;

public enum EnumMovmentModel{
	//private int pre[]={1,2,3};
	vAllRandomModel(0),//��ȫ���ģ��
	vPatialRandomModel(1),//�������ģ��
	vDirectionRandomModel(2),//�������ģ��
	;
	

	private int vIndex;

	private EnumMovmentModel() {
		// TODO Auto-generated constructor stub
	}
	EnumMovmentModel(int b){
		this.vIndex=b;
	};
	int get_value(){
		return vIndex;
	}
	public static EnumMovmentModel get_model(int vIndex){
		switch (vIndex) {
		case 0:
			return EnumMovmentModel.vAllRandomModel;
		case 1:
			return EnumMovmentModel.vPatialRandomModel;
		case 2:
			return EnumMovmentModel.vDirectionRandomModel;
		default:
			return EnumMovmentModel.vAllRandomModel;
		}			
	}
}
