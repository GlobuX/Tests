package appstart.mymodappdemo;

import java.util.ServiceLoader;
import appfuncs.simplefuncs.SimpleMathFuncs;
import appsupport.supportfuncs.SupportFuncs;
import userfuncs.binaryfuncs.*;

public class MyModAppDemo {
	public static void main(String[] args) {
		if (SupportFuncs.isFactor(2, 10))
			System.out.println("2 - множитель 10");
		System.out.println("Наименьший общий множитель 35 и 105 - " 
							+ SimpleMathFuncs.lcf(35, 105));
		System.out.println("Наибольший общий множитель 35 и 105 - " 
							+ SimpleMathFuncs.gcf(35, 105));
		
		//Использование служб
		ServiceLoader<BinFuncProvider> ldr = ServiceLoader.load(BinFuncProvider.class);
		BinaryFunc binOp = null;
		for (BinFuncProvider bfp : ldr) {
			if (bfp.get().getName().equals("absPlus")) {
				binOp = bfp.get();
				break;
			}
		}
		if (binOp != null)
			System.out.println("Результат выполнения функции absPlus(): " + binOp.func(12, -4));
		else
			System.out.println("Функция absPlus() не найдена");
		binOp = null;
		
		for (BinFuncProvider bfp : ldr) {
			if (bfp.get().getName().equals("absMinus")) {
				binOp = bfp.get();
				break;
			}
		}
		if (binOp != null)
			System.out.println("Результат выполнения функции absMinus(): " + binOp.func(12, -4));
		else
			System.out.println("Функция absPlus() не найдена");
	}
}