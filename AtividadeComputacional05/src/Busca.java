import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Busca {
	public static void main(String[] args) {
		int[] A; int chave;
		double inicio1, fim1, tempo1;
		double inicio2, fim2, tempo2;
		
		System.out.printf("%20s%30s%30s\n","n", "linear", "binária");
		System.out.println("----------------------------------------------");
		for (int n = 1; n <= 50; n++) {
			A = criaVetorCrescente(n);
			Random randomGenerator = new Random();
			chave = randomGenerator.nextInt(A[n-1]+1);
			inicio1 = System.currentTimeMillis();
			buscaLinear(A, chave);
			fim1 = System.currentTimeMillis();
			tempo1 = fim1 - inicio1;
			inicio2 = System.currentTimeMillis();
			buscaBinaria(A, 0, n-1, chave);
			fim2 = System.currentTimeMillis();
			tempo2 = fim2 - inicio2;
			System.out.printf("%20d%30.0f%30.0f\n", n, tempo1, tempo2);
		}

	}
	
	static int[] criaVetorCrescente (int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 1; i < n; i++) {
			A[i] = A[i-1] + randomGenerator.nextInt(10) + 1;
		}
		return A;
	}
	
	static void imprimeVetor (int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	static int buscaLinear(int[] A, int chave) {
		for (int i = 0; i < A.length; i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (chave == A[i])
				return i;
			if (chave < A[i])
				return -1;
		}
		return -1;
	}

	static int buscaBinaria(int[] A, int i, int f, int chave) {
		if (i > f)
			return -1;
		
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int pontoMedio = (i + f) / 2;
		if (A[pontoMedio] == chave)
			return pontoMedio;
		
		if (A[pontoMedio] > chave)
			return buscaBinaria(A, i + 1, pontoMedio, chave);
		
		return buscaBinaria(A, pontoMedio + 1, f, chave);
	}

}
