import java.util.Scanner;
import java.util.Random;

public class InsertionSort {
	public static void main(String[] args) {
		int[] A;
		double inicio, fim, tempo;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe o valor de n: ");
		int n = scanner.nextInt();
		scanner.close();
		System.out.printf("%20s%30s\n", "n", "tempo");

		A = CriaVetorCrescente(n);
		inicio = System.currentTimeMillis();
		A = Ordenacao(A);
		fim = System.currentTimeMillis();
		tempo = fim - inicio;
		System.out.printf("%20d%30.0f\n", n, tempo);

		A = CriaVetorAleatorio(n);
		inicio = System.currentTimeMillis();
		A = Ordenacao(A);
		fim = System.currentTimeMillis();
		tempo = fim - inicio;
		System.out.printf("%20d%30.0f\n", n, tempo);

		A = CriaVetorDecrescente(n);
		inicio = System.currentTimeMillis();
		A = Ordenacao(A);
		fim = System.currentTimeMillis();
		tempo = fim - inicio;
		System.out.printf("%20d%30.0f\n", n, tempo);
	}

	static int[] CriaVetorCrescente(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 1; i < n; i++) {
			A[i] = A[i - 1] + randomGenerator.nextInt(10);
		}
		return A;
	}

	static int[] CriaVetorDecrescente(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		A[0] = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			A[i] = A[i - 1] - randomGenerator.nextInt(10);
		}
		return A;
	}

	static int[] CriaVetorAleatorio(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(Integer.MAX_VALUE);
		}
		return A;
	}

	static void ImprimeVetor(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	static int[] Ordenacao(int[] A) {
		for (int j = 1; j < A.length; j++) { // 1.000.000 2 1
			int chave = A[j]; // 1
			int i = j - 1;    // 0
			while (i >= 0 && A[i]/*2*/ > chave/*1*/) { // 1.000.000
				A[i + 1] = A[i]; // 
				i--; // 
			}
			A[i + 1] = chave;
		}
		return A;
	}

}
