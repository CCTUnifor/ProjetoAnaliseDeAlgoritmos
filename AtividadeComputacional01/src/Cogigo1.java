public class Cogigo1 {
	public static void main(String[] args) {
		System.out.printf("%20s%30s\n", "n", "tempo");
		for (int inst = 1; inst <= 50; inst++) {
			long n = 1000000 * inst;
			double inicio = System.currentTimeMillis();
			double soma = n;
			soma = soma * (n + 1) / 2;
			double fim = System.currentTimeMillis();
			double tempo = fim - inicio;
			System.out.printf("%20d%30.0f\n", n, tempo);
		}
	}
}