import java.util.Scanner;
public class Potencia {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe a: ");
		int a = scanner.nextInt();
		System.out.print("Informe b: ");
		int b = scanner.nextInt();
		scanner.close();
		System.out.printf("%15s%15s\n", "potencia1", "potencia2");
		System.out.println("------------------------------");
		System.out.printf("%15d%15d\n", potencia1(a, b), potencia3(a, b));
	}
	
	static long potencia1(int a, int b) {
		long potencia = 1;
		for (int i = 1; i <= b; i++) {
			potencia = potencia * a;
		}
		return potencia;
	}

	static long potencia2(int a, int b) {
		if (b == 1)
			return a;
		
		if (b % 2 == 0)
			return potencia2(a, b/2) * potencia2(a, b/2);
		return potencia2(a, b/2) * potencia2(a, b/2) * a;
	}
	static long potencia3(int a, int b) {
		if (b == 1)
			return a;
		if (b == 0)
			return 1;
		return potencia2(a, b - 1) * potencia2(a, b - 2) * a;
	}/*
	static long potencia3(int a, int b) {
		if (b == 1)
			return a;
		return potencia2(a, b - 1) * a;
	}
	*/
}
