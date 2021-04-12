class Q3
{
    public static void main(String [] args) {
        // Create Pessoas objects
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa("Zilde", 20, GrausEscolaridade.MEDIO, IdentidadesGenero.NAO_BINARIO, OrientacaoSexual.HETEROSSEXUAL, SexoBiologico.MASCULINO);

        // Set data in pessoa1
        pessoa1.setNome("Zildao");
        pessoa1.setIdade(20);
        pessoa1.setGrauEscolaridade(GrausEscolaridade.DOUTORADO);

        // Cast methods for pessoa1
        pessoa1.cagar();
        pessoa1.viver();
        System.out.println("Grau de escolaridade de " + pessoa1.getNome() + " -> " + pessoa1.getGrauEscolaridade().name());

        // Cast methods for pessoa2
        pessoa2.trabalhar();
        pessoa2.sobreviver();
    }
}

// Enums
enum IdentidadesGenero {
    CISGENERO,
    TRANSGENERO,
    GENERO_FLUIDO,
    NAO_BINARIO,
    NAO_DECLARADO
}

enum OrientacaoSexual {
    HETEROSSEXUAL,
    HOMOSSEXUAL,
    BISSEXUAL,
    ASSEXUAL,
    PANSEXUAL,
    NAO_DECLARADO
}

enum SexoBiologico {
    MASCULINO,
    FEMININO,
    NAO_DECLARADO
}

enum GrausEscolaridade {
    INFANTIL,
    FUNDAMENTAL,
    MEDIO,
    SUPERIOR,
    POS_GRADUACAO,
    MESTRADO,
    DOUTORADO,
    NAO_DECLARADO
}

class Pessoa {
    // Attributes
    protected String nome;
    protected int idade;
    protected GrausEscolaridade grauEscolaridade;
    protected IdentidadesGenero identidadeGenero;
    protected OrientacaoSexual oriSexual;
    protected SexoBiologico sexoBiologico;

    // Default constructor
    Pessoa() {
        this.nome = "";
        this.idade = -1;
        this.grauEscolaridade = GrausEscolaridade.NAO_DECLARADO;
        this.identidadeGenero = IdentidadesGenero.NAO_DECLARADO;
        this.oriSexual = OrientacaoSexual.NAO_DECLARADO;
        this.sexoBiologico = SexoBiologico.NAO_DECLARADO;
    }

    // Constructor with args
    Pessoa(String nome, int idade, GrausEscolaridade grauEscolaridade, IdentidadesGenero identidadeGenero, OrientacaoSexual oriSexual, SexoBiologico sexoBiologico) {
        this.nome = nome;
        this.idade = idade;
        this.grauEscolaridade = grauEscolaridade;
        this.identidadeGenero = identidadeGenero;
        this.oriSexual = oriSexual;
        this.sexoBiologico = sexoBiologico;
    }

    // Getters
    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public GrausEscolaridade getGrauEscolaridade() {
        return this.grauEscolaridade;
    }

    public IdentidadesGenero getIdentidadeGenero() {
        return this.identidadeGenero;
    }

    public OrientacaoSexual getOriSexual() {
        return this.oriSexual;
    }

    public SexoBiologico getSexoBiologico() {
        return this.sexoBiologico;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setGrauEscolaridade(GrausEscolaridade grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    // Methods
    public void dormir() {
        System.out.println(this.nome + " dormiu.");
    }

    public void cagar() {
        System.out.println(this.nome + " cagou.");
    }

    public void comer() {
        System.out.println(this.nome + " comeu.");
    }

    public void estudar() {
        System.out.println(this.nome + " estudou.");
    }

    public void viver() {
        System.out.println(this.nome + " viveu.");
    }
    
    public void sobreviver() {
        System.out.println(this.nome + " sobreviveu.");
    }

    public void trabalhar() {
        System.out.println(this.nome + " trabalhou.");
    }
}