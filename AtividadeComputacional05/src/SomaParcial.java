import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SomaParcial {
	public static void main(String[] args) {
		int[] A, B;
		double inicio1, fim1, tempo1;
		double inicio2, fim2, tempo2;
		double inicio3, fim3, tempo3;
		
		System.out.printf("%5s%10s%10s%10s\n","n", "tempo1", "tempo2", "tempo3");
		System.out.println("-----------------------------------");
		for (int n = 1; n <= 50; n++) {
			A = criaVetorAleatorio(n);
			inicio1 = System.currentTimeMillis();
			B = soma1(A);
			fim1 = System.currentTimeMillis();
			tempo1 = fim1 - inicio1;
			inicio2 = System.currentTimeMillis();
			B = soma2(A);
			fim2 = System.currentTimeMillis();
			tempo2 = fim2 - inicio2;
			inicio3 = System.currentTimeMillis();
			B = soma3(A);
			fim3 = System.currentTimeMillis();
			tempo3 = fim3 - inicio3;
			System.out.printf("%5d%10.0f%10.0f%10.0f\n", n, tempo1, tempo2, tempo3);
			if (n == 50) {
				imprimeSaida(A, B);
			}
		}
	}
	
	static int[] criaVetorAleatorio (int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(100*n);
		}
		return A;
	}
	
	static void imprimeSaida (int[] A, int[] B) {
		System.out.println("Saída:");
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%9d", A[i]);
		}
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%9d", B[i]);
		}
	}

	static int[] soma1(int[] A) {
		long tempo = 1;                                       // c1   1
		int[] B = new int[A.length];                          // c2   1
		for (int i = 0; i < A.length; i++) {                  // c3   n + 1
			for (int j = 0; j <= i; j++) {                    // c4   (n)(n + 1)
				try {
					TimeUnit.MILLISECONDS.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				B[i] += A[j];                                 // c5   (n)(n)
			}
		}
		return B;                                             // c6   n 
	}

	static int[] soma2(int[] A) {
		long tempo = 3;                                       // c1   1
		int[] B = new int[A.length];                          // c2   1
		for (int i = 0; i < A.length/2; i++) {                // c3   (n/2) + 1
			for (int j = 0; j <= i; j++) {                    // c4   (n/2)((n/2) + 3) / 2
				try {
					TimeUnit.MILLISECONDS.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				B[i] += A[j];                                 // c5 (n/2)((n/2) + 1) / 2
			}
		}
		for (int i = A.length/2; i < A.length; i++) {         // c6 (n/2) + 1
			for (int j = A.length/2; j <= i; j++) {           // c7 (n/2)((n/2) + 3) / 2
				try {
					TimeUnit.MILLISECONDS.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				B[i] += A[j];                                 // c8 (n/2)((n/2) + 1) / 2 
			}
		}
		int soma = 0;                                         // c9  1
		if (A.length/2 - 1 >= 0) {                            // c10 1
			soma = B[A.length/2 - 1];                         // c11 0 ou 1
		}
		for (int i = A.length/2; i < A.length; i++) {         // c12 (n/2) + 1
			try {
				TimeUnit.MILLISECONDS.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			B[i] = B[i] + soma;                               // c13 (n/2)
		}
		return B;
	}

	static int[] soma3(int[] A) {
		long tempo = 100;                                       // c1 1
		int[] B = new int[A.length];                          // c2 1
		B[0] = A[0];                                          // c3 1
		for (int i = 1; i < A.length; i++) {                  // c4 n + 1
			try {      
				TimeUnit.MILLISECONDS.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			B[i] = B[i-1] + A[i];                             // c5 n
		}
		return B;                                             // c6 1
	}

}