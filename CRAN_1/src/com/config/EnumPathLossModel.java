package com.config;

/**
 * 
 * @author yaoyao 1. ���ɿռ�ģ�� 2. ����+˥�� 3. Hata231 4. Hata231����
 * 
 */
public enum EnumPathLossModel {
	vFreedomLoss(0),//�������
	vFreedomVsFading(1),//���ɿռ���ĺͿ�˥
	vHata231(2),//cost231
	vHata231A(3),//cost231a
	;
	
	private int vIndex;

	EnumPathLossModel(int vIndex) {

		this.vIndex=vIndex;
	}
	int get_value(){
		return vIndex;
	}
	public static EnumPathLossModel get_model(int vIndex){
		switch (vIndex) {
		case 0:
			return vFreedomLoss;
		case 1:
			return vFreedomVsFading;
		case 2:
			return vFreedomLoss;
		case 4:
			return vHata231;
		default:
			return vFreedomLoss;
		}			
	}
}
