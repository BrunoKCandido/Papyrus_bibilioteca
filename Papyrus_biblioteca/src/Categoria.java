public class Categoria {

    private int idCategoria;
    private String nomeCategoria;
    private Livro livro;; //Livro associado à categoria

    public Categoria() {
    }

    public Categoria(int idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }

    @Override
    public String toString() {
        return "Categoria [" +
                "idCategoria=" + idCategoria +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                ']';
    }
}
