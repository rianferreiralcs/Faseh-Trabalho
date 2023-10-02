public class Mesa {
    private int numero;
    private String situacao;
    private int capacidadeMaxima;

    public Mesa (int numero, String situacao, int capacidadeMaxima) {
        this.numero = numero;
        this.situacao = situacao;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }





}


