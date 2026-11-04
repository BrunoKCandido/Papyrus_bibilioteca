import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {

    private int idEmprestimo;
    private Usuario usuario; // Associação unidirecional com a classe Usuario
    private LocalDate dataEmprestimo;
    private List<ItemEmprestimo> itensEmprestimo = new ArrayList<>(); // Associação por composição com ItemEmprestimo

    public Emprestimo() {
    }

    public Emprestimo(Usuario usuario, LocalDate dataEmprestimo) {
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

    public boolean adicionarItemEmprestimo(ItemEmprestimo item) {
        if (item == null || itensEmprestimo.contains(item)) {
            return false;
        }

        itensEmprestimo.add(item);
        item.setEmprestimo(this);

        return true;
    }

    public boolean removerItemEmprestimo(ItemEmprestimo item) {
        if (item == null || !itensEmprestimo.contains(item)) {
            return false;
        }

        itensEmprestimo.remove(item);
        item.setEmprestimo(null);

        return true;
    }

    public List<ItemEmprestimo> consultarItensEmprestimo() {
        return itensEmprestimo;
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