package spring;

public class Division implements Calculator{

	@Override
	public int sum(int num1, int num2) {
		return num1/num2;
	}
}
