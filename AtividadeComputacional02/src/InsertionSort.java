import java.util.Random;

public class InsertionSort {
	public static void main(String[] args) {
		int n;
		int[] A;
		double inicio, fim, tempo;

		System.out.println("Ordenado crescente");
		System.out.printf("%20s%30s\n", "n", "tempo");
		System.out.println("----------------------------------------------");
		for (int i = 1; i <= 50; i++) {
			n = 1000 * i;
			A = criaVetorCrescente(n);
			inicio = System.currentTimeMillis();
			A = selectionSort(A);
			fim = System.currentTimeMillis();
			tempo = fim - inicio;
			System.out.printf("%20d%30.0f\n", n, tempo);
		}

		System.out.println("Ordenado decrescente");
		System.out.printf("%20s%30s\n", "n", "tempo");
		System.out.println("----------------------------------------------");
		for (int i = 1; i <= 50; i++) {
			n = 1000 * i;
			A = criaVetorDecrescente(n);
			inicio = System.currentTimeMillis();
			A = selectionSort(A);
			fim = System.currentTimeMillis();
			tempo = fim - inicio;
			System.out.printf("%20d%30.0f\n", n, tempo);
		}

		System.out.println("Ordenado aleatório");
		System.out.printf("%20s%30s\n", "n", "tempo");
		System.out.println("----------------------------------------------");
		for (int i = 1; i <= 50; i++) {
			n = 1000 * i;
			A = criaVetorAleatorio(n);
			inicio = System.currentTimeMillis();
			A = selectionSort(A);
			fim = System.currentTimeMillis();
			tempo = fim - inicio;
			System.out.printf("%20d%30.0f\n", n, tempo);
		}
	}

	static int[] criaVetorCrescente(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 1; i < n; i++) {
			A[i] = A[i - 1] + randomGenerator.nextInt(10);
		}
		return A;
	}

	static int[] criaVetorDecrescente(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		A[0] = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			A[i] = A[i - 1] - randomGenerator.nextInt(10);
		}
		return A;
	}

	static int[] criaVetorAleatorio(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(100 * n);
		}
		return A;
	}

	static void imprimeVetor(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	static int[] insertionSort(int[] A) {
		for (int j = 1; j < A.length; j++) {
			int chave = A[j];
			int i = j - 1;
			while (i >= 0 && A[i] > chave) {
				A[i + 1] = A[i];
				i--;
			}
			A[i + 1] = chave;
		}
		return A;
	}

	static int[] selectionSort(int[] A) {
		// to do
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					int chave = A[j];
					A[j] = A[i];
					A[i] = chave;
				}

			}
		}
		return A;
	}
}