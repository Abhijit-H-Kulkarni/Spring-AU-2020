@FunctionalInterface
interface Triconsumer<T1,T2,T3>{
	void accept(T1 t1 ,T2 t2,T3 t3);
}
public class triconsumerlambda {
   public static void main(String args[]) {
	   Triconsumer<Integer, Integer, Integer> t = (a,b,c) -> System.out.println(a+b+c);
	   t.accept(15, 10, 5);
   }
}