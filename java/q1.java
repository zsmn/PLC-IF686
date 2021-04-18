class Q1
{
    public static void main(String[] args) {
        LivroLivraria livroLivraria = new LivroLivraria();
        LivroBiblioteca livroBiblioteca = new LivroBiblioteca();

        // Setting livroLivraria data
        livroLivraria.setISBN("9780329975876");
        livroLivraria.setTitulo("Harry Potter and the Prisoner of Azkaban");
        livroLivraria.setAutor("J. K. Rowling");
        livroLivraria.setEditora("Rocco");
        livroLivraria.setAno(1999);

        // Setting livroBiblioteca data
        livroBiblioteca.setISBN("9780439784542");
        livroBiblioteca.setTitulo("Harry Potter and the Half Blood Prince");
        livroBiblioteca.setAutor("J. K. Rowling");
        livroBiblioteca.setEditora("Rocco");
        livroBiblioteca.setAno(2005);

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

    // Setters
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // Getters
    public String getISBN() {
        return this.ISBN;
    }

    public String getTitulo() {
        return this.titulo;
    }
    
    public String getAutor() {
        return this.autor;
    }

    public String getEditora() {
        return this.editora;
    }

    public int getAno() {
        return this.ano;
    }
}

class LivroLivraria extends Livro {
    protected Boolean vendido;

    LivroLivraria() {
        this.vendido = false;
    }

    public void venderLivro() {
        this.vendido = true;
        System.out.println("LivroLivraria " + this.getISBN() + " [" + this.getTitulo() + "] " + "vendido.");
    }

    public Boolean isVendido() {
        return this.vendido;
    }
}

class LivroBiblioteca extends Livro {
    protected Boolean emprestado;

    LivroBiblioteca() {
        this.emprestado = false;
    }

    public void emprestarLivro() {
        this.emprestado = true;
        System.out.println("LivroBiblioteca " + this.getISBN() + " [" + this.getTitulo() + "] " + "emprestado.");
    }

    public Boolean isEmprestado() {
        return this.emprestado;
    }
}