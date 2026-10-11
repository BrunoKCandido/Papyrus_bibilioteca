import java.util.ArrayList;
import java.util.List;

public class Livro {

    private int idLivro;
    private String titulo;
    private String editora;
    private String edicao;
    private int anoPublicacao;
    private String isbn;
    private Categoria categoria;
    private List<Autor> autores = new ArrayList<>();

    public Livro() {
    }

    public Livro(int idLivro, String titulo, String editora, String edicao,
                 int anoPublicacao, String isbn, Categoria categoria) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    @Override
    public String toString() {
        return "Livro [" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", editora='" + editora + '\'' +
                ", edicao='" + edicao + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", isbn='" + isbn + '\'' +
                ", categoria=" + categoria +
                ", autores=" + autores +
                ']';
    }
}