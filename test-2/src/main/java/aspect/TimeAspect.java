package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeAspect {

	@Around("execution(public * spring..*(..))")
	private void timetarget() {
	}

	@Around("timetarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		Object result = joinPoint.proceed();
		long finish = System.nanoTime();
		System.out.printf("수행 시간 = %d, 결과 = %d",finish-start,result);
		return result;
	}
}
