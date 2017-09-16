# Atividade Computacional 06
## Arquivos de resposta
* [AtividadeComputacional06.txt](https://github.com/thiagomaia971/ProjetoAnaliseDeAlgoritmos/blob/master/AtividadeComputacional06/AtividadeComputacional06.txt)

## Respostas

#### Exercicio 1

* **Passo 1**:
</br>
	imprime1(64) 1
	imprime1(32) 2
	imprime1(16) 3
	imprime1(8)  4
	imprime1(4)  5
	imprime1(2)  6
	imprime1(1)  7

* **Passo 4**:
</br>
														  (64) 			
								(32)		                                            (32) 	
				   (16)                        (16)                       (16)                        (16) 	
			 (8)                          (8)                        (8)                         (8)                         (8)                         (8)                         (8)                         (8)
   	  (4)           (4)           (4)           (4)           (4)           (4)           (4)          (4)           (4)           (4)           (4)           (4)            (4)           (4)           (4)          (4)
  (2)    (2)    (2)    (2)    (2)    (2)    (2)    (2)    (2)    (2)    (2)    (2)    (2)    (2)    (2)   (2)     (2)   (2)    (2)    (2)     (2)   (2)     (2)   (2)      (2)   (2)    (2)    (2)    (2)    (2)    (2)    (2)
(1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1) (1)(1)


* **Passo 5**:
	T(n) = 1T(n/2) + teta(n^1/2)

* **Passo 6**:
	Caso 3:
		• n^1/2 = Omega(n^log1+Ebase2)
		• 1f((n/2)^1/2) <= cf((n^1/2)) =>	E atende ao caso especifico do caso 3
		
	Solução: T(n) = Teta(n^1/2)			
	
* **Passo 7**:
	T(n) = 2T(n/2) + teta(n^1/2)
	
* **Passo 8**:
	Caso 1:
		• n^1/2 = O(n^log(2-E)(base 2))
	
	Solução: T(n) = teta(n^log2base2)
			 T(n) = teta(n)
	
#### Exercicio 2

* **Passo 2**:
	c1 = 1
	c2 = 1
	c3 = n + 1
	c4 = n
	c5 = 1
	
* **Passo 4**:
     soma1     soma2
   --------------------
    445832    445832
	
* **Passo 5**:	
	T(n) = 2T(n/2) + teta(1)
	
* **Passo 6**:
	Caso 1:
		• teta(1) = O(n^log(2 - E)(base 2))
		• teta(1) = O(n^log(2 - 1)(base 2), para E = 1
		• teta(1) = O(n^log(1)(base 2), para E = 1
		• teta(1) = O(n^0), para E = 1
		• teta(1) = O(1), para E = 1
		
	Solução: T(n) = teta(n^log(2)(base 2))
			 T(n) = teta(n^1)
			 T(n) = teta(n)
 
 * **Passo 7**:	 
	soma1 => Teta(n)
	soma2 => Teta(n)
	
	São assintoticamente iguais, porque estão na mesma classe de complexidade.
	
#### Exercicio 3

* **Passo 2**:
	c1 = 1
	c2 = n(n + 2)/2
	c3 = n(n + 1)/2
	c4 = 1

* **Passo 3**:
	static long potencia2(int a, int b) {
		if (b == 1)
			return a;
		if (b % 2 == 0)
			return potencia2(a, b/2) * potencia2(a, b/2);
		return potencia2(a, b/2) * potencia2(a, b/2) * a;
	}
	
* **Passo 4**:

      potencia1      potencia2
	------------------------------
           1024           1024

	
* **Passo 5**:
	T(n) = 2T(n/2) + Teta(1)
	
* **Passo 6**:
	Caso 1:
		• teta(1) = O(n^log(2 - E)(base 2))
		• teta(1) = O(n^log(2 - 1)(base 2), para E = 1
		• teta(1) = O(n^log(1)(base 2), para E = 1
		• teta(1) = O(n^0), para E = 1
		• teta(1) = O(1), para E = 1
		
	Solução: T(n) = teta(n^log(2)(base 2))
			 T(n) = teta(n^1)
			 T(n) = teta(n)
		
* **Passo 7**:
	Algoritmo:
		static long potencia3(int a, int b) {
			if (b == 1)
				return a;
			return potencia2(a, b - 1) * a;
		}
	
	Equação de Recorrencia:
		T(n) = 1T(n-1) + Teta(1)
	
	Resolução teorema mestre:
		Caso 2:
			• Teta(1) = Teta(n^log(1)(base -1))
			• Teta(1) = Teta(n^0)
			• Teta(1) = Teta(1) => verdadeiro
			
			Solução: T(n) = teta(n^log(1)(base -1) * lgn)
			         T(n) = teta(n^0 * lgn)
					 T(n) = teta(1 * lgn)
					 T(n) = teta(lgn)