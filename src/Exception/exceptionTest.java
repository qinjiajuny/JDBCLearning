package Exception;

import java.util.ArrayList;

public class exceptionTest {

	public static void main(String[] args) {
//		try {
//			//Exception in thread "main" java.lang.NullPointerException 空指针错误
//		//目前list为空，没有new，无法使用
//		ArrayList list = null;
//		list.add(3);
//		list.add(34);
//			
//		} catch (NullPointerException e) {
////			System.out.println("出现了空指针异常");
//			//抛出异常
//			throw e;
//		}
		
		//处理抛出的异常
		try {
			test(0);
			test(10);
			test(20);
			test(-20);
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		

	}
	public static void test(int age) throws Exception//throws Exception表示该方法可以抛出异常
	{
		if(age>=0&&age<18)
		{
			System.out.println("未成年人");
		}else if(age>18)
		{
			System.out.println("成年人");
		}else //抛出一个自定的异常
			throw new Exception("年龄输入不合法");
	}

}
