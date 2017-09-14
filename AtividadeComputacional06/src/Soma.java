import java.util.Random;

public class Soma {
	public static void main(String[] args) {
		int[] A;
		int n = 100;
		System.out.printf("%10s%10s\n", "soma1", "soma2");
		System.out.println("--------------------");
		A = criaVetorAleatorio(n);
		System.out.printf("%10d%10d\n", soma1(A), soma2(A, 0, n-1));
	}
	
	static int[] criaVetorAleatorio (int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(100*n);
		}
		return A;
	}
	
	static int soma1(int[] A) {
		int soma = 0;
		for (int i = 0; i < A.length; i++) {
			soma += A[i];
		}
		return soma;
	}

	static int soma2(int[] A, int i, int f) {
		if (i==f)
			return A[i];
		int m = (i + f) / 2;
		return soma2(A, i, m) + soma2(A, m + 1, f);
	}
}
