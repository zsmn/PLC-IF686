class Principal
{
    public static void main(String [] args) {
        ColecaoVetor colecao = new ColecaoVetor();

        // Inserting first 'Pessoa'
        colecao.inserir(new Professor("Castor", "400.289.221-23", "transcendental", "informatica"));
        System.out.println("Ainda restam " + colecao.tamanhoColecaoNaoNull() + " vagas.");

        // Inserting first 'Pessoa'
        colecao.inserir(new Professor("Acm", "123.456.789-10", "satelite-solver", "informatica"));
        System.out.println("Ainda restam " + colecao.tamanhoColecaoNaoNull() + " vagas.");

        // Inserting first 'Pessoa'
        colecao.inserir(new Aluno("Zildao", "987.654.321-00", "nula", "informatica"));
        System.out.println("Ainda restam " + colecao.tamanhoColecaoNaoNull() + " vagas.");

        // Printing names
        String names [] = colecao.getNomePessoas();
        for(int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

    }
}

abstract class Pessoa {
    protected String nome;
    protected String cpf;

    Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    protected String getNome() {
        return this.nome;
    }

    protected String getCPF() {
        return this.cpf;
    }

    protected abstract void setNome(String nome);
    protected abstract void setCPF(String cpf);
}

class Aluno extends Pessoa {
    protected String matricula;
    protected String curso;

    Aluno(String nome, String cpf, String matricula, String curso) {
        super(nome, cpf);
        this.matricula = matricula;
        this.curso = curso;
    }

    // Overriding abstract 'setNome' from 'Pessoa'
    @Override
    protected void setNome(String nome) {
        this.nome = nome;
    }

    // Overriding abstract 'setCPF' from 'Pessoa'
    @Override
    protected void setCPF(String cpf) {
        this.cpf = cpf;
    }

    // Aluno setters
    protected void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    protected void setCurso(String curso) {
        this.curso = curso;
    }

    // Aluno getters
    protected String getMatricula() {
        return this.matricula;
    }

    protected String getCurso() {
        return this.curso;
    }
}

class Professor extends Pessoa {
    protected String formacao;
    protected String area;

    Professor(String nome, String cpf, String formacao, String area) {
        super(nome, cpf);
        this.formacao = formacao;
        this.area = area;
    }

    // Overriding abstract 'setNome' from 'Pessoa'
    @Override
    protected void setNome(String nome) {
        this.nome = nome;
    }

    // Overriding abstract 'setCPF' from 'Pessoa'
    @Override
    protected void setCPF(String cpf) {
        this.cpf = cpf;
    }

    // Aluno setters
    protected void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    protected void setArea(String area) {
        this.area = area;
    }

    // Aluno getters
    protected String getFormacao() {
        return this.formacao;
    }

    protected String getArea() {
        return this.area;
    }
}

interface Colecao {
    void inserir(Pessoa p);
    int tamanhoColecaoNaoNull();
}

class ColecaoVetor implements Colecao {
    protected Pessoa[] dados;

    ColecaoVetor() {
        this.dados = new Pessoa[5];
    }

    @Override
    public void inserir(Pessoa p) {
        for(int i = 0; i < 5; i++) {
            if(dados[i] == null) {
                dados[i] = p;
                break;
            }
        }
    }

    @Override
    public int tamanhoColecaoNaoNull() {
        int counter = 0;
        for(int i = 0; i < 5; i++) {
            if(dados[i] == null) {
                break;
            }
            else {
                counter++;
            }
        }

        return (5 - counter);
    }

    public String[] getNomePessoas() {
        int qtPessoasRegistradas = (5 - this.tamanhoColecaoNaoNull());
        String nomePessoas [] = new String[qtPessoasRegistradas];
        
        for(int i = 0; i < qtPessoasRegistradas; i++) {
            nomePessoas[i] = dados[i].getNome();
        }

        return nomePessoas;
    }
}
