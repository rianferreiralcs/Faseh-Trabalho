public class Garcom {
    private String cpf;
    private String nome;
    private String email;
    private String dataNascimento;
    private String telefone;
    private String sexo;
    private float salarioFixo;






    // Construtor
    public Garcom (String cpf, String nome, String email, String dataNascimento, String telefone, String sexo, float salarioFixo) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = String.valueOf(email);
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.sexo = sexo;
        this.salarioFixo = salarioFixo;

    }

    public Garcom() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public float getSalarioFixo() {
        return salarioFixo;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setSalarioFixo(float salarioFixo) {
        this.salarioFixo = salarioFixo;
    }
}

