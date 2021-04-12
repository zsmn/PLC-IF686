class Q4
{
    public static void main(String [] args) {
        // Create Conta object
        Conta conta = new Conta("1324545488-140", "16540-1", new Senha("1a2b3c", "123456"));
        
        // Show object 'numIdentificacao' and senha 'senhaLN'
        System.out.println(conta.getNumIdentificacao());
        System.out.println(conta.getSenha().getSenhaLN());

        // Modify object Senha
        Senha senhaNew = conta.getSenha();
        senhaNew.setSenhaLN("4a5b6c");
        conta.setSenha(senhaNew);

        // Show object Senha 'senhaLN' field
        System.out.println(conta.getSenha().getSenhaLN());
    }
}

class Conta {
    // Attributes
    protected String numIdentificacao;
    protected String agencia;
    protected Senha senha;

    // Constructor
    Conta(String numIdentificacao, String agencia, Senha senha) {
        this.numIdentificacao = numIdentificacao;
        this.agencia = agencia;
        this.senha = senha;
    }

    // Getters
    public String getNumIdentificacao() {
        return this.numIdentificacao;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public Senha getSenha() {
        return this.senha;
    }

    // Setters
    public void setNumIdentificacao(String numIdentificacao) {
        this.numIdentificacao = numIdentificacao;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setSenha(Senha senha) {
        this.senha = senha;
    }
}

class Senha {
    // Attributes
    protected String senhaLN;
    protected String senhaN;

    // Constructor
    Senha(String senhaLN, String senhaN) {
        this.senhaLN = senhaLN;
        this.senhaN = senhaN;
    }

    // Getters
    public String getSenhaLN() {
        return this.senhaLN;
    }

    public String getSenhaN() {
        return this.senhaN;
    }

    // Setters
    public void setSenhaLN(String senhaLN) {
        this.senhaLN = senhaLN;
    }

    public void setSenhaN(String senhaN) {
        this.senhaN = senhaN;
    }
}