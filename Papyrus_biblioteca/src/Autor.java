import java.util.Objects;

public class Autor {

    private int idAutor;
    private String nomeAutor;

    public Autor() {
    }

    public Autor(int idAutor, String nomeAutor) {
        this.idAutor = idAutor;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return idAutor == autor.idAutor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutor);
    }
}