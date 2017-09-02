import java.util.Scanner;

public class Constante {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe o valor de n: ");
		long n = scanner.nextLong();
		scanner.close();
		System.out.printf("%20s%30s%30s\n", "n", "solucao", "tempo");
		double inicio = System.currentTimeMillis();
		double soma = n;
		soma = soma * (n + 1) / 2;
		double fim = System.currentTimeMillis();
		double tempo = fim - inicio;
		System.out.printf("%20d%30.0f%30.0f\n", n, soma, tempo);
	}
}
