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
    protected String getNumIdentificacao() {
        return this.numIdentificacao;
    }

    protected String getAgencia() {
        return this.agencia;
    }

    protected Senha getSenha() {
        return this.senha;
    }

    // Setters
    protected void setNumIdentificacao(String numIdentificacao) {
        this.numIdentificacao = numIdentificacao;
    }

    protected void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    protected void setSenha(Senha senha) {
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
    protected String getSenhaLN() {
        return this.senhaLN;
    }

    protected String getSenhaN() {
        return this.senhaN;
    }

    // Setters
    protected void setSenhaLN(String senhaLN) {
        this.senhaLN = senhaLN;
    }

    protected void setSenhaN(String senhaN) {
        this.senhaN = senhaN;
    }
}