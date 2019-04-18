
public class Test {
	public static void main(String[] args) {
		Syoon s = new Syoon();
		s.talk();
		An a = new An();
		a.show();
	}
}
interface Inter{
	
	public abstract void talk();
}

class Syoon implements  Inter{
	public void talk(){
		System.out.println("nishi zhizhang");
	}
}
interface Animal{
	public static final int a=100;
	public static final String na="动物";
	public abstract void show();
}
class An implements Animal{
	public static final int a=100;
	public static final String na="动物";
	public void show(){
		System.out.println("我是刚定义的接口");
	}
}