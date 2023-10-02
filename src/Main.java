
import java.sql.*;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;
public class Main
{
    static Connection conexao = null;
    static Scanner ler = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String cpf, nome, email, dataNascimento, telefone, sexo, opcao, finalizar = ""; finalizar = "Nao";
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        numberFormat.setMaximumFractionDigits(2);


        while (finalizar != "Sim") {
            System.out.println("Menu");
            System.out.println("1 - Incluir Garçom");
            System.out.println("2 - Alterar Garçom");
            System.out.println("3 - Pesquisar Garçom");
            System.out.println("4 - Excluir Garçom");
            System.out.println("5 - Média dos Salários");
            System.out.println("6 - Cadastrar Mesas");
            System.out.println("7 - Sair");
            opcao = ler.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Digite os dados do garçom");
                    System.out.println("Digite o CPF:");
                    cpf = ler.nextLine();
                    System.out.println("Digite o Nome:");
                    nome = ler.nextLine();
                    System.out.println("Digite o Email:");
                    email = ler.nextLine();
                    System.out.println("Digite a data de nascimento:");
                    dataNascimento = ler.nextLine();
                    System.out.println("Digite o telefone:");
                    telefone = ler.nextLine();
                    System.out.println("Digite o sexo:");
                    sexo = ler.nextLine();
                    System.out.println("Digite o salário fixo:");
                    float salarioFixo = Float.parseFloat(ler.nextLine());


                    Garcom g = new Garcom(cpf, nome, email, dataNascimento, telefone, sexo, salarioFixo);
                    try {
                        inserirGarcom(g);
                        System.out.println("Garçom cadastrado com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Não foi possível cadastrar o Garçom.");
                        e.printStackTrace();
                    }
                    break;

                case "2":
                    System.out.println("Digite o email do garçom que deseja alterar:");
                    String emailGarcomAlterar = ler.nextLine();
                    try {

                        Garcom garcomEncontrado = buscarGarcomPeloEmail(emailGarcomAlterar);

                        if (garcomEncontrado == null) {
                            System.out.println("Garçom não encontrado.");
                        } else {
                            /* Carregando as variaveis de memoria */
                            cpf = garcomEncontrado.getCpf();
                            nome = garcomEncontrado.getNome();
                            email = garcomEncontrado.getEmail();
                            dataNascimento = garcomEncontrado.getDataNascimento();
                            telefone = garcomEncontrado.getTelefone();
                            sexo = garcomEncontrado.getSexo();
                            salarioFixo = garcomEncontrado.getSalarioFixo();

                            /* Mostrando na tela */
                            System.out.println("CPF: " + cpf);
                            System.out.println("Nome: " + nome);
                            System.out.println("Email: " + email);
                            System.out.println("Data de Nascimento: " + dataNascimento);
                            System.out.println("Telefone: " + telefone);
                            System.out.println("Sexo: " + sexo);
                            //System.out.println("Salário Fixo: " + salarioFixo);
                            System.out.println("Salário Fixo: " + numberFormat.format(salarioFixo));


                            System.out.println("Digite os novos dados do garçom:");
                            System.out.println("CPF:");
                            cpf=ler.nextLine();
                            System.out.println("Nome:");
                            nome=ler.nextLine();
                            System.out.println("Data de Nascimento:");
                            dataNascimento=ler.nextLine();
                            System.out.println("Telefone:");
                            telefone=ler.nextLine();
                            System.out.println("Sexo:");
                            sexo=ler.nextLine();
                            System.out.println("Salário Fixo:");
                            salarioFixo =Float.parseFloat(ler.nextLine());

                            Garcom gAlterar = new Garcom(cpf, nome, email, dataNascimento, telefone, sexo, salarioFixo);

                            alterarGarcom(gAlterar);
                            System.out.println("Garçom alterado com sucesso.");

                        }

                        if (garcomEncontrado == null) {
                            System.out.println("Garçom não encontrado.");
                        } else {

                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao alterar o garçom.");
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("Digite o email do garçom que deseja pesquisar:");
                    String emailGarcomPesquisar = ler.nextLine();
                    try {

                        Garcom garcomEncontrado = buscarGarcomPeloEmail(emailGarcomPesquisar);
                        if (garcomEncontrado == null) {
                            System.out.println("Garçom não encontrado.");
                        } else {
                            System.out.println("CPF: " + garcomEncontrado.getCpf());
                            System.out.println("Nome: " + garcomEncontrado.getNome());
                            System.out.println("Email: " + garcomEncontrado.getEmail());
                            System.out.println("Data de Nascimento: " + garcomEncontrado.getDataNascimento());
                            System.out.println("Telefone: " + garcomEncontrado.getTelefone());
                            System.out.println("Sexo: " + garcomEncontrado.getSexo());
                            //System.out.println("Salário Fixo: " + garcomEncontrado.getSalarioFixo());
                            System.out.println("Salário Fixo: " + numberFormat.format(garcomEncontrado.getSalarioFixo()));

                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao buscar o garçom.");
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("Digite o email do garçom que deseja remover:");
                    String emailGarcomRemover = ler.nextLine();
                    try {
                        Connection connection = conexao = ConexaoBD.getInstance();
                        removerGarcomPeloEmail(emailGarcomRemover);
                        System.out.println("Garçom removido com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao remover o garçom.");
                        e.printStackTrace();

                    }
                    break;
                case "5":
                    try
                    {
                        float mediaSalarios = calcularMediaSalarios();
                        System.out.println("Média dos salários: " + mediaSalarios);
                    } catch (SQLException e)
                    {
                        System.out.println("Erro ao calcular a média dos salários.");
                        e.printStackTrace();
                    }

                    break;
                case "6":
                    int numero, capacidadeMaxima;
                    String situacao;

                    Scanner ler = new Scanner(System.in);

                    System.out.println("Digite os dados da mesa");
                    System.out.println("Digite o número: ");
                    numero = ler.nextInt();
                    System.out.println("Digite a situação (livre, ocupada, reservada): ");
                    situacao = ler.next();
                    System.out.println("Digite a capacidade máxima: ");
                    capacidadeMaxima = ler.nextInt();

                    Mesa m = new Mesa(numero, situacao, capacidadeMaxima);

                    try {
                        Connection conexao = ConexaoBD.getInstance();
                        PreparedStatement tmt = conexao.prepareStatement("INSERT INTO Mesa (numero, situacao, capacidadeMaxima) VALUES (?, ?, ?)");

                        tmt.setInt(1, numero);
                        tmt.setString(2, situacao);
                        tmt.setInt(3, capacidadeMaxima);

                        int linhasAfetadas = tmt.executeUpdate();
                        if (linhasAfetadas > 0) {
                            System.out.println("Mesa cadastrada com sucesso");
                        } else {
                            System.out.println("Não foi possível cadastrar a mesa");
                        }
                    } catch (SQLException e) {
                        System.out.println("Ocorreu um erro ao inserir a mesa");
                        e.printStackTrace();
                    }
                    break;

                case "7":
                    finalizar = "Sim";
                    System.out.println("Encerrando o programa...");
                    break;

            }

        }
    }

    public static void alterarGarcom(Garcom gSendoAlterado) throws Exception {
        Connection connection = ConexaoBD.getInstance();

        String sql = "UPDATE garcom SET  cpf = ?,nome  = ?, email = ?, dataNascimento = ?, telefone = ?, sexo = ?, salarioFixo = ?" + "WHERE email = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, gSendoAlterado.getCpf());
        stmt.setString(2, gSendoAlterado.getNome());
        stmt.setString(3, gSendoAlterado.getEmail());
        stmt.setString(4, gSendoAlterado.getDataNascimento());
        stmt.setString(5, gSendoAlterado.getTelefone());
        stmt.setString(6, gSendoAlterado.getSexo());
        stmt.setFloat(7, gSendoAlterado.getSalarioFixo());
        stmt.setString(8, gSendoAlterado.getEmail());

        stmt.execute();
        stmt.close();

    }
    private static float calcularMediaSalarios() throws SQLException, ClassNotFoundException {
        Connection connection = ConexaoBD.getInstance();
        String sql = "SELECT AVG(salarioFixo) AS mediaSalarios FROM garcom";
        float mediaSalarios = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = ((Statement) statement).executeQuery(sql);
            if (resultSet.next())
            {   mediaSalarios = resultSet.getFloat("mediaSalarios");}
            resultSet.close();
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao calcular a média dos salários.");
            e.printStackTrace();
        }
        return mediaSalarios;
    }
        public static void removerGarcomPeloEmail(String emailDoGarcomQueSeraRemovido) throws Exception{
        Connection connection = ConexaoBD.getInstance();
        String sql = "delete from garcom where email like ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1,emailDoGarcomQueSeraRemovido);

        stmt.execute();
        stmt.close();
    }
    public static Garcom buscarGarcomPeloEmail(String emailBuscado) throws Exception{
        Connection connection = ConexaoBD.getInstance();

        String sql = "SELECT * FROM garcom WHERE email = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1,emailBuscado);
        ResultSet resultado = stmt.executeQuery();

        Garcom g = null;
        if (resultado.next()){
            g = new Garcom(resultado.getString("cpf"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("dataNascimento"),
                    resultado.getString("telefone"),
                    resultado.getString("sexo"),
                    resultado.getFloat("salarioFixo"));
        }
        resultado.close();
        stmt.close();
        return g;
    }
    private static void inserirGarcom(Garcom glido) throws SQLException, ClassNotFoundException{
        try{
            Connection connection = ConexaoBD.getInstance();
            String sql = "insert into garcom ( cpf,nome, email, dataNascimento, telefone, sexo, salarioFixo) values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,glido.getCpf());
            stmt.setString(2,glido.getNome());
            stmt.setString(3,glido.getEmail());
            stmt.setString(4,glido.getDataNascimento());
            stmt.setString(5,glido.getTelefone());
            stmt.setString(6,glido.getSexo());
            stmt.setFloat(7,glido.getSalarioFixo());
            System.out.println("Garcom cadastrado com sucesso");
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e){
            System.out.println("Nao foi possivel cadastrar o Garçom");
            e.printStackTrace();
        }
    }
}


