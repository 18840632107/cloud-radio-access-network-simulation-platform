package com.config;

import javax.annotation.Resource;

/**
 * 
 * 1. ϵͳ�ܴ��� 2. Ƶ������
 * 
 * 
 */
public enum EnumResourceModel {
	vResourceConcentation(0),//ϵͳ�ܴ���
	vResourceExcision(1),//Ƶ������
	;

	private int vIndex;

	EnumResourceModel(int vIndex) {
		this.vIndex=vIndex;
	}
	int get_value(){
		return vIndex;
	}
	
	public static EnumResourceModel get_model(int vIndex){
		switch (vIndex) {
		case 0:
			return vResourceConcentation;
		case 1:
			return vResourceExcision;
	
		default:
			return vResourceConcentation;
		}			
	}
}
