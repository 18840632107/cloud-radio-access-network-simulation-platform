package com.config;


import java.lang.Object;
public class ConfigTti {
	/**��Ա������*/
	/**java���Ƴ�����Ʊ���*/
	public int vTest[]={1,2,3};
	public static int PP[]={4,5,6,4};
	public static String testString="CranSystem_Simulator";
	//vMov  vPathLossModel vResourceModel  vWirePathModel vEnumResourceSheldual vEnumUeTrafficModel vEnumNetworkTrafficMode
	/**�û��ƶ���ģ��*/	
	public static EnumMovmentModel vMov=EnumMovmentModel.vAllRandomModel;
	public static Object[] vConfigMovM=new Object[3];//���������\
		
	
	/**������·ģ��*/
	public static EnumPathLossModel vPathLossModel=EnumPathLossModel.vFreedomLoss;
	public static Object[] vConfigPathLossM;
	
	/**ϵͳƵ����Դ*/
	public static EnumResourceModel vBandwidthResourceModel=EnumResourceModel.vResourceConcentation;
	public static Object[] vConfigResourceM;
	
	/**������·ģ��*/
	public static EnumWirePathModel vWirePathModel=EnumWirePathModel.vDefault;
	public static Object[] vConfigWirePathM;//���������	
	
	/**��Դ����ģ��*/
	public static EnumResourceSheldual vEnumResourceSheldual=EnumResourceSheldual.vFairness;
	public static Object[] vConfigResourceSheldual;//���������
	
	/**�û�ҵ����ģ��*/
	public static EnumUeTrafficModel vEnumUeTrafficModel=EnumUeTrafficModel.vVoIP;	
	public static Object[] vConfigUeTraM;//���������
	
	/**����ҵ����ģ��*/
	public static EnumNetworkTrafficModel vEnumNetworkTrafficModel=EnumNetworkTrafficModel.vPreTrafficLoadModel;	
	public static Object[] vConfigNetworkTraM;//���������
	
	public ConfigTti(){
		
	}
	/**
	 * ���ԵĹ������
	 * @param a testset
	 */
	public ConfigTti(int a[] ){
		vTest=a;
	}
	/**�û��ƶ���ģ�Ͳ�������*/
	public static void configMovmentModel(Object... srgs ) {
		switch (vMov) {
		case vAllRandomModel:
			/**������*/
			break;
		case vPatialRandomModel:	//�������ģ��
			/**������*/
			break;
		case vDirectionRandomModel://�������ģ��
			/**������*/
			break;
		default:
			System.err.println("������������");
			break;
		}
		/**�ɱ������ֵ�����ñ�*/
		vConfigMovM=srgs;
	}
	
	/**������·ģ��*/
	public void configPathLossM(Object... srgs ) {
		switch (vMov) {
		case vAllRandomModel:
			/**������*/
			break;

		default:
			break;
		}
		vConfigMovM=srgs;
	}
	/**ϵͳƵ����Դ*/
	public void configResourceM(Object... srgs ) {
		switch (vMov) {
		case vAllRandomModel:
			/**������*/
			break;

		default:
			break;
		}
		vConfigResourceM=srgs;
	}
	/**������·ģ��*/
	public void configWirePathM(Object... srgs ) {
		switch (vMov) {
		case vAllRandomModel:
			/**������*/
			break;

		default:
			break;
		}
		vConfigWirePathM=srgs;
	}
	
	/**��Դ����ģ��*/
	public void configResourceSheldual(Object... srgs ) {
		switch (vMov) {
		case vAllRandomModel:
			/**������*/
			break;

		default:
			break;
		}
		vConfigResourceSheldual=srgs;
	}
	/**�û�ҵ����ģ��*/
	public void configUeTrafficModel(Object... srgs ) {
		switch (vMov) {
		case vAllRandomModel:
			/**������*/
			break;

		default:
			break;
		}
		vConfigUeTraM=srgs;
	}	
	/**����ҵ����ģ��*/
	public void configNetworkTrafficModel(Object... srgs ) {
		switch (vMov) {
		case vAllRandomModel:
			/**������*/
			break;

		default:
			break;
		}
		vConfigNetworkTraM=srgs;
	}
//	public static void main(String... srgs) {
//		System.out.println(srgs.getClass());
//		Object[] testObjects=new Object[3];
//		double a[]={1,1};
//		testObjects[0]=a;
//		testObjects[1]=1;
//		testObjects[2]="int";	
//		System.out.println(testObjects[0].getClass());
//		System.out.println(testObjects[1].getClass());
//	}
}
