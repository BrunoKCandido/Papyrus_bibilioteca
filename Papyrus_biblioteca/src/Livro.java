import java.util.ArrayList;
import java.util.List;

public class Livro {

    private int idLivro;
    private String titulo;
    private String editora;
    private String edicao;
    private int anoPublicacao;
    private String isbn;
    private List<Categoria> categorias = new ArrayList<>(); //Lista de categorias do livro
    private List<Autor> autores = new ArrayList<>();
    private List<Exemplar> exemplares = new ArrayList<>(); //associação por composição com Exemplar

    public Livro() {
    }

    public Livro(int idLivro, String titulo, String editora, String edicao,
                 int anoPublicacao, String isbn) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.autores = new ArrayList<>();
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Categoria> getCategoria() { return categorias; }

    //Metodo para adicionar Categoria a lista de categorias do livro
    //(1) adiciona a categoria à lista de categorias do livro
    //(2) associa o livro (this) a categoria
    public void addCategoria(Categoria categoria) {
        if (categoria != null && !categorias.contains(categoria)) {
            categorias.add(categoria);
            categoria.setLivro(this);
        }
    }

    //Metodo para remover uma categoria da lista, mas não a exclui da memória
    public void removeCategoria(Categoria categoria) {
        if (categoria != null && categorias.remove(categoria)) {
            categoria.setLivro(null);
        }
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        if (autores != null && autores.size() > 3) {
            throw new IllegalArgumentException("Um livro pode ter no máximo 3 autores.");
        }
        this.autores = autores;
    }

    public void addAutor(Autor autor) {
        if (this.autores.size() >= 3) {
            System.out.println("Não é possível adicionar mais de 3 autores ao livro.");
            return;
        }
        if (autor != null && !this.autores.contains(autor)) {
            this.autores.add(autor);
        }
    }

    public void removeAutor(Autor autor) {
        this.autores.remove(autor);
    }

    //Na composição apenas o metodo getExemplar deve ser implementado (não tem set)
    //(1)Metodo para consultar exemplares
    public List<Exemplar> getExemplares() { return exemplares; }

    //(2)Metodo para adicionar exemplares
    public void addExemplar(Exemplar exemplar) {
        if (exemplar != null) {
            exemplar.setLivro(this);
            exemplares.add(exemplar);
        }
    }

    @Override
    public String toString() {
        return "Livro [" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", editora='" + editora + '\'' +
                ", edicao='" + edicao + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", isbn='" + isbn + '\'' +
                ", categorias=" + categorias +
                ", autores=" + autores +
                ']';
    }
}