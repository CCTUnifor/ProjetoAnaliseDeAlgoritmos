import java.util.Random;

public class Dinamico {

    public static void main(String[] args) {
        int n = 10;
        Atividade[] atividades = new Atividade[n + 2];
        Random random = new Random();
        int s;
        int f = 5;
        atividades[0] = new Atividade(0, 0);
        for (int i = 1; i <= n; i++) {
            f = random.nextInt(20) + f + 1;
            s = random.nextInt(f - 1) + 1;
            atividades[i] = new Atividade(s, f);
        }
        atividades[n + 1] = new Atividade(Integer.MAX_VALUE, Integer.MAX_VALUE);
        imprimeAtividades(atividades);
        System.out.println("Recursivo");
        System.out.printf("Quantidade: %d\n\n", selecaoRecursivo(atividades, 0, n + 1));
        System.out.println("Dinamico");
        selecaoDinamico(atividades);
        System.out.println("Guloso");
        selecaoGuloso(atividades);
    }

    static int selecaoRecursivo(Atividade[] a, int i, int j) {
        boolean vazio = true;
        for (int k = i + 1; k < j; k++) {
            if (a[k].s >= a[i].f && a[k].f <= a[j].s) {
                vazio = false;
            }
        }
        if (!vazio) {
            int qMax = 0;
            for (int k = i + 1; k < j; k++) {
                if (a[k].s >= a[i].f && a[k].f <= a[j].s) {
                    int q = selecaoRecursivo(a, i, k) + selecaoRecursivo(a, k, j) + 1;
                    if (q > qMax) {
                        qMax = q;
                    }
                }
            }
            return qMax;
        }
        return 0;
    }

    static void selecaoDinamico(Atividade[] a) {
        int[][] c = new int[a.length][a.length];
        int[][] s = new int[a.length][a.length];

        for (int l = 3; l < a.length + 1; l++) {
            for (int i = 0; i < a.length - l + 1; i++) {
                int j = i + l - 1;
                c[i][j] = Integer.MIN_VALUE;
                for (int k = i + 1; k < j - 1; k++) {
                    if (a[k].s >= a[i].f && a[k].f <= a[j].s) {
                        int q = c[i][k] + c[k + 1][j] + 1;
                        if (q > c[i][j]) {
                            c[i][j] = q;
                            s[i][j] = k;
                        }
                    }
                }
            }
        }

        impressaoDinamico(s, a, 0, a.length - 1);
        System.out.println();
    }

    static void impressaoDinamico(int[][] s, Atividade[] a, int i, int j) {
        int k = s[i][j];

        if (k != 0) {
            impressaoDinamico(s, a, i, k);
            System.out.println("A" + s[i][j] + ": " + a[k]);
            impressaoDinamico(s, a, k, j);
        }
    }

    static void selecaoGuloso(Atividade[] a) {
        //to do
        System.out.println("A" + 1 + ": " + a[1]);
        for (int i = 2; i < a.length - 1; i++) {
            if (a[i].s >= a[i-1].f)
                System.out.println("A" + i + ": " + a[i]);
        }
    }

    static void imprimeAtividades(Atividade[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d\t%d\n", a[i].s, a[i].f);
        }
    }
}
