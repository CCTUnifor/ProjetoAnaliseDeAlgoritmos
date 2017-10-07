import java.util.Random;

public class HeapSort {
	public static void main(String[] args) {
		int[] A = {86, 78, 36, 61, 67, 34, 58, 42, 35, 59, 62, 28, 60, 37, 12};
		System.out.println("Vetor A:");
//		maxheapfy(A, 5);
//		maxheapfy(A, 2);

		imprimeVetor(A);
		imprimeHeap(A);
		
		imprimeLeft2(A);
		imprimeRight4(A);
		
		int[] B = criaVetorAleatorio(15);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Vetor B:");
		buildmaxheap(B);
		imprimeVetor(B);
		imprimeHeap(B);
	}
	
	static void imprimeLeft2(int[] A) {
		System.out.print("\nImprime A[left(2)]: " + A[left(2)] + "\n");
	}
	
	static void imprimeRight4(int[] A) {
		System.out.print("Imprime A[right(4)]: " + A[right(4)] + "\n\n");
	}
	
	static int left (int i) {
		return (i * 2) + 1;
	}

	static int right (int i) {
		return (i * 2) + 2;
	}

	static void maxheapfy (int[] V, int i) {
		int l = left(i);
		int r = right(i);
		int m = i;
		if (l < V.length && V[l] > V[i]) { // se o left for maior que o valor do pai, troca o index do pai para o left
			m = l;
		}
		if (r < V.length && V[r] > V[m]) { // se o right for maior que o valor do pai, troca o index do pai para o right
			m = r;
		}
		if (m != i) { // se tiver trocado o index do pai
			int aux = V[m];
			V[m] = V[i];
			V[i] = aux;
			maxheapfy(V, m);
		}
	}

	static void buildmaxheap (int[] V) {
		// Porque executar maxheapfy para os folhas? Poderia fazer
		// for (int i = (V.length / 2) + (V.length % 2); i >= 0; i--)
		for (int i = V.length - 1; i >= 0; i--) {
			maxheapfy(V, i);
		}
	}

	static int[] criaVetorAleatorio (int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(10 * n);
		}
		return A;
	}

	static void imprimeVetor (int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%6d", A[i]);
		}
		System.out.print("\n\n\n");
	}
	
	static void imprimeHeap (int[] A) {
		int h = (int) (Math.log(A.length) / Math.log(2));
		int espacos = calculaEspacos(h);
		for (int i = 0; i <= h; i++) {
			for (int j = 1; j <= Math.pow(2, i); j++) {
				if ((int) (Math.pow(2, i)) - 1 + (j-1) >= A.length) break;
				imprimeEspacos(espacos);
				System.out.printf("%3d", A[(int) (Math.pow(2, i)) - 1 + (j-1)]);
				imprimeEspacos(espacos);
				if (j < Math.pow(2, i)) {
					System.out.printf("%3s", "");
				}
			}
			espacos = (espacos - 3) / 2;
			System.out.println();
		}
	}
	
	static int calculaEspacos (int h) {
		int espacos = 3;
		for (int i = 1; i <= h; i++) {
			espacos = 2 * espacos + 3;
		}
		return espacos;
	}
	
	static void imprimeEspacos (int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(" ");
		}
	}
	
}