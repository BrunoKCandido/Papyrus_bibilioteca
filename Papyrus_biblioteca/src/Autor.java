public class Autor {

    private int idAutor;
    private String nomeAutor;

    public Autor() {
    }

    public Autor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        if (nomeAutor == null || nomeAutor.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do autor não pode ser vazio.");
        }
        this.nomeAutor = nomeAutor;
    }

    @Override
    public String toString() {
        return "Autor [" +
                "idAutor=" + idAutor +
                ", nomeAutor='" + nomeAutor + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Autor autor = (Autor) obj;
        return nomeAutor != null &&
                autor.nomeAutor != null &&
                nomeAutor.trim().equalsIgnoreCase(autor.nomeAutor.trim());
    }

    @Override
    public int hashCode() {
        return nomeAutor == null ? 0 :
                nomeAutor.trim().toLowerCase().hashCode();
    }
}