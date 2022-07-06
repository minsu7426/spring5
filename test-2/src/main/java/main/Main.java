package main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Calculator;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Calculator tmp = null;
		Scanner sc = new Scanner(System.in);
		int result = 0;
		System.out.println("첫번째 값을 입력하세요");
		int num1 = sc.nextInt();
		System.out.println("두번째 값을 입력하세요.");
		int num2 = sc.nextInt();
		System.out.println("연산 처리방법을 입력하세요\n1.+ 2.- 3.* 4./");
		int aa = sc.nextInt();
		if(aa == 1) {
			tmp = ctx.getBean("plus", Calculator.class);
		} else if(aa == 2) {
			tmp = ctx.getBean("minus", Calculator.class);
		} else if(aa == 3) {
			tmp = ctx.getBean("multiplication", Calculator.class);
		} else if(aa == 4) {
			tmp = ctx.getBean("division", Calculator.class);
		} else {
			System.out.println("값을 잘못 입력하였습니다.");
		}
		result = tmp.sum(num1, num2);
		System.out.println("메인 결과 : "+result);
		ctx.close();
	}

}
