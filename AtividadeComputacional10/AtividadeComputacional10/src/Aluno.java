import java.util.Random;
class Aluno {
	public String matricula;
	public String nome;
	public int creditos;
	
	public Aluno() {
		Random randomGenerator = new Random();
		matricula = "";
		for (int i = 1; i <= 10; i++) {
			matricula += (char) ('0' + randomGenerator.nextInt(10));
		}
		nome = "";
		nome += (char)('A' + randomGenerator.nextInt(26));
		for (int i = 2; i <= 10; i++) {
			nome += (char) ('a' + randomGenerator.nextInt(26));
		}
		creditos = randomGenerator.nextInt(201);
	}
}