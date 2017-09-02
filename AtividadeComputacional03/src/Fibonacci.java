import java.util.Random;

public class Fibonacci {
	public static void main(String[] args) {
		int n;
		long result, ultimo, penult;
		double inicio, fim, tempo;
		System.out.printf("%20s%30s%30s\n", "n", "termo", "tempo");
		n = 1;;
		while (n <= 50) {
			inicio = System.currentTimeMillis();
			result = 1;
			ultimo = 1;
			penult = 1;
			if (n > 1) {
				for (int i = 3; i <= n; i++) {
					result = ultimo + penult;
					penult = ultimo;
					ultimo = result;
				}
			}
			fim = System.currentTimeMillis();
			tempo = fim - inicio;
			System.out.printf("%20d%30d%30.0f\n", n, result, tempo);
			n++;
		}
		
		System.out.printf("%20s%30s%30s\n", "n", "termo", "tempo");
		n = 1;
		while (n <= 50) {
			inicio = System.currentTimeMillis();
			result = fibo(n);
			fim = System.currentTimeMillis();
			tempo = fim - inicio;
			System.out.printf("%20d%30d%30.0f\n", n, result, tempo);
			n++;
		}
		
	}
	
	static long fibo(int n) {
		long result;
		if (n <= 1) {
			result = n;
		} else {
			result = fibo (n-1) + fibo (n-2);
		}
		return result;
	}
}