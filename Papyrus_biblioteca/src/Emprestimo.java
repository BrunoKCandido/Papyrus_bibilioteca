import java.time.LocalDate;

public class Emprestimo {

    private int idEmprestimo;
    private Usuario usuario;
    private LocalDate dataEmprestimo;

    public Emprestimo() {
    }

    public Emprestimo(int idEmprestimo, Usuario usuario, LocalDate dataEmprestimo) {
        this.idEmprestimo = idEmprestimo;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString() {
        return "Emprestimo [" +
                "idEmprestimo=" + idEmprestimo +
                ", usuario=" + usuario +
                ", dataEmprestimo=" + dataEmprestimo +
                ']';
    }
}



