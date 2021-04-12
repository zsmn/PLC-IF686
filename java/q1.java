class Q1
{
    public static void main(String[] args) {
        LivroLivraria livroLivraria = new LivroLivraria();
        LivroBiblioteca livroBiblioteca = new LivroBiblioteca();

        // Setting livroLivraria data
        livroLivraria.ISBN = "9780329975876";
        livroLivraria.titulo = "Harry Potter and the Prisoner of Azkaban";
        livroLivraria.autor = "J. K. Rowling";
        livroLivraria.editora = "Rocco";
        livroLivraria.ano = 1999;

        // Setting livroBiblioteca data
        livroBiblioteca.ISBN = "9780439784542";
        livroBiblioteca.titulo = "Harry Potter and the Half Blood Prince";
        livroBiblioteca.autor = "J. K. Rowling";
        livroBiblioteca.editora = "Rocco";
        livroBiblioteca.ano = 2005;

        // Print statuses
        System.out.println("livroLivraria isVendido => " + livroLivraria.isVendido());
        System.out.println("livroBiblioteca isEmprestado => " + livroBiblioteca.isEmprestado());

        // Mark both as vendido / emprestado
        livroLivraria.venderLivro();
        livroBiblioteca.emprestarLivro();

        // Print statuses again
        System.out.println("livroLivraria isVendido => " + livroLivraria.isVendido());
        System.out.println("livroBiblioteca isEmprestado => " + livroBiblioteca.isEmprestado());
    }
}

abstract class Livro {
    public String ISBN;
    public String titulo;
    public String autor;
    public String editora;
    public int ano;
}

class LivroLivraria extends Livro {
    protected Boolean vendido;

    protected LivroLivraria() {
        this.vendido = false;
    }

    public void venderLivro() {
        this.vendido = true;
        System.out.println("LivroLivraria " + this.ISBN + " vendido.");
    }

    public Boolean isVendido() {
        return this.vendido;
    }
}

class LivroBiblioteca extends Livro {
    protected Boolean emprestado;

    protected LivroBiblioteca() {
        this.emprestado = false;
    }

    public void emprestarLivro() {
        this.emprestado = true;
        System.out.println("LivroBiblioteca " + this.ISBN + " emprestado.");
    }

    public Boolean isEmprestado() {
        return this.emprestado;
    }
}