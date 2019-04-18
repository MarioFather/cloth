
public class Sum {
	public static void main(String[] args) {
		Demo d = new Demo();
		double s = d.add(1.5);
		System.out.println(s);
	}
}
class Demo{
	double sum=0;
	public double add(double...arr){
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}return sum;
	}
}
