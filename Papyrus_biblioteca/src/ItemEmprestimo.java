import java.time.LocalDate;

public class ItemEmprestimo {

    private int idItemEmprestimo;
    private Emprestimo emprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataEfetivaDevolucao;
    private StatusItemEmprestimo statusItemEmprestimo;

    public enum StatusItemEmprestimo {
        EMPRESTADO("Emprestado"),
        DEVOLVIDO("Devolvido"),
        ATRASADO("Atrasado");

        private String descricao;

        StatusItemEmprestimo(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public ItemEmprestimo() {
    }

    public ItemEmprestimo(int idItemEmprestimo, Emprestimo emprestimo,
                          LocalDate dataPrevistaDevolucao, LocalDate dataEfetivaDevolucao,
                          StatusItemEmprestimo statusItemEmprestimo) {
        this.idItemEmprestimo = idItemEmprestimo;
        this.emprestimo = emprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
        this.statusItemEmprestimo = statusItemEmprestimo;
    }

    public int getIdItemEmprestimo() {
        return idItemEmprestimo;
    }

    public void setIdItemEmprestimo(int idItemEmprestimo) {
        this.idItemEmprestimo = idItemEmprestimo;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataEfetivaDevolucao() {
        return dataEfetivaDevolucao;
    }

    public void setDataEfetivaDevolucao(LocalDate dataEfetivaDevolucao) {
        this.dataEfetivaDevolucao = dataEfetivaDevolucao;
    }

    public StatusItemEmprestimo getStatusItemEmprestimo() {
        return statusItemEmprestimo;
    }

    public void setStatusItemEmprestimo(StatusItemEmprestimo statusItemEmprestimo) {
        this.statusItemEmprestimo = statusItemEmprestimo;
    }

    @Override
    public String toString() {
        return "ItemEmprestimo [" +
                "idItemEmprestimo=" + idItemEmprestimo +
                ", emprestimo=" + emprestimo +
                ", dataPrevistaDevolucao=" + dataPrevistaDevolucao +
                ", dataEfetivaDevolucao=" + dataEfetivaDevolucao +
                ", statusItemEmprestimo=" + statusItemEmprestimo +
                ']';
    }
}
