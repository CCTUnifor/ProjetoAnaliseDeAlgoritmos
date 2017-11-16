public class Atividade {
    public int s;
    public int f;

    public Atividade(int _s, int _f) {
        this.s = _s;
        this.f = _f;
    }

    @Override
    public String toString() {
        return s + ", "+ f;
    }
}
