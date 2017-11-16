public class Counting {
	public static void main(String[] args) {
		int n = 40;
		Aluno[] alunos = new Aluno[n];
		for (int i = 0; i < alunos.length; i++) {
			alunos[i] = new Aluno();
		}
		imprime(alunos);
		alunos = ordenaCreditos(alunos);
		imprime(alunos);
		alunos = ordenaMatricula(alunos);
		imprime(alunos);
	}

	static Aluno[] ordenaCreditos (Aluno[] A) {
		// to do
		// credito maximo 200
		int creditoMaximo = 200;
		Aluno[] B = new Aluno[A.length];
		int[] C = new int[creditoMaximo + 1];
				
		for (int j = 0; j < A.length; j++){
			int creditosCorrente = creditosCorrente(A, j);
			C[creditosCorrente] += 1;
		}
		
		for (int i = 1; i < C.length; i++)
			C[i] = C[i] + C[i - 1];
		
		for (int j = A.length - 1; j >= 0; j--) {
			Aluno aluno = A[j];
			int creditos = creditosCorrente(A, j);
			int posicao = C[creditos] - 1;
			
			B[posicao] = aluno;
			C[creditos] = C[creditos] - 1;
		}
		
		return B;
	}
	
	private static int creditosCorrente(Aluno[] A, int j) {
		Aluno aluno = A[j]; 
		return aluno.creditos;
	}

	static Aluno[] ordenaMatricula (Aluno[] A) {
		int tamanhoMatricula = 10;
		
		for (int d = tamanhoMatricula -1; d >= 0; d--) {
			Aluno[] B = new Aluno[A.length];
			int[] C = new int[10];
			
			
			for (int j = 0; j < A.length; j++){
				int digito = digito(A, j, d);
				C[digito] += 1;
			}
			
			for (int i = 1; i < C.length; i++)
				C[i] = C[i] + C[i - 1];
			
			for (int j = A.length - 1; j >= 0; j--) {
				Aluno aluno = A[j];
				int digito = digito(A, j, d);
				int posicao = C[digito] - 1;
				
				B[posicao] = aluno;
				C[digito] = C[digito] - 1;
			}
			A = B;			
		}
		return A;
	}
	
	static int digito(Aluno[] A, int j, int d) {
		return (int) A[j].matricula.charAt(d) - '0';
	}

	static void imprime (Aluno[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%-15s%-15s%10d\n", A[i].matricula, A[i].nome, A[i].creditos);
		}
		System.out.print("\n\n\n");
	}
}
