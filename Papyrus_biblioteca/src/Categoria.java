public class Categoria {

    private int idCategoria;
    private String nomeCategoria;

    public Categoria() {
    }

    public Categoria(String nomeCategoria) {
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

    @Override
    public String toString() {
        return "Categoria [" +
                "idCategoria=" + idCategoria +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                ']';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Categoria categoria = (Categoria) obj;
        return nomeCategoria != null &&
                categoria.nomeCategoria != null &&
                nomeCategoria.trim().equalsIgnoreCase(categoria.nomeCategoria.trim());
    }

    @Override
    public int hashCode() {
        return nomeCategoria == null ? 0 :
                nomeCategoria.trim().toLowerCase().hashCode();
    }
}