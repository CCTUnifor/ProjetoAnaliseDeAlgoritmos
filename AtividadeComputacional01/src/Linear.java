import java.util.Scanner;

public class Linear {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe o valor de n: ");
		long n = scanner.nextLong();
		scanner.close();
		System.out.printf("%20s%30s%30s\n", "n", "solucao", "tempo");
		double inicio = System.currentTimeMillis();
		double soma = 0;
		for (long i = 1; i <= n; i++) {
			soma = soma + i;
		}
		double fim = System.currentTimeMillis();
		double tempo = fim - inicio;
		System.out.printf("%20d%30.0f%30.0f\n", n, soma, tempo);
	}
}