public class Dinamico
{
    public static void main(String[] args) {
        int troco = 47;
//         int troco = 103;
        int[] p = {1, 7, 17, 25};
        trocoDinamico(troco, p);
        System.out.printf("Total de cedulas: %d\n", trocoRecursivo(troco, p));
    }

    static int trocoRecursivo(int troco, int[] p) {
        if (troco != 0) {
            int qMin = Integer.MAX_VALUE;
            for (int i = 0; i < p.length; i++) {
                if (troco - p[i] >= 0) {
                    int q = trocoRecursivo(troco - p[i], p) + 1;
                    if (q < qMin) {
                        qMin = q;
                    }
                }
            }
            return qMin;
        }
        return 0;
    }

    static void trocoDinamico(int troco, int[] p) {
        int[] q = new int[troco + 1];
        int[] c = new int[troco + 1];
        // to do

        for (int t = 1; t < q.length; t++) { // 1
            int menor = Integer.MAX_VALUE;

            for (int j = 0; j < p.length; j++) {
                int moeda = p[j]; // 1
                if (moeda <= t) {
                    int quantidadeMinimaDeMoedas = q[t - moeda] + 1;
                    if (quantidadeMinimaDeMoedas <= menor) {
                        menor = quantidadeMinimaDeMoedas;
                        q[t] = quantidadeMinimaDeMoedas;
                        c[t] = moeda;
                    }
                }
            }

        }
        System.out.printf("Total de cedulas: %d\n", q[troco]);
        imprimeTroco(c, troco);
    }

    static void imprimeTroco(int[] c, int troco) {
        if (troco > 0)
        {
            int moeda = c[troco];
            System.out.print(moeda + ", ");
            imprimeTroco(c, troco - moeda);
        }
        else
            System.out.println();
    }

}
