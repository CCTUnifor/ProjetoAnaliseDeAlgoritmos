public class Imprime {
	public static void main(String[] args) {
		System.out.println("Imprime1");
		imprime1(64);
		System.out.println("Imprime2");
		imprime2(64);
	}
	
	static void imprime1(int n) {
		if (n != 1) {
			for (int i = 1; i <= Math.sqrt(n); i++) {
				System.out.printf("%5d", i);
			}
			System.out.println();
			imprime1(n/2);
		}
	}

	static void imprime2(int n) {
		if (n != 1) {
			for (int i = 1; i <= Math.sqrt(n); i++) {
				System.out.printf("%5d", i);
			}
			System.out.println();
			imprime2(n/2);
			imprime2(n/2);
		}
	}
	
}
