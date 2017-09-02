public class Codigo3 {
	public static void main(String[] args) {
		System.out.printf("%20s%30s\n", "n", "tempo");
		for (int inst = 1; inst <= 50; inst++) {
			long n = 1000 * inst;
			double inicio = System.currentTimeMillis();
			double soma;
			double total = 0;
			for (int j = 1; j <= n; j++) {
				soma = 0;
				for (long i = 1; i <= n; i++) {
					soma = soma + i;
				}
				total = total + soma;
			}
			soma = total / n;
			double fim = System.currentTimeMillis();
			double tempo = fim - inicio;
			System.out.printf("%20d%30.0f\n", n, tempo);
		}
	}
}