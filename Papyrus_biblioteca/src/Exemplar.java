public class Exemplar {

    private int idExemplar;
    private Livro livro;
    private String numeroTombo;
    private String localizacaoEstante;
    private EstadoConservacao estadoConservacao;
    private Situacao situacao;

    public enum EstadoConservacao {
        NOVO("Novo"),
        BOM("Bom"),
        DANIFICADO("Danificado");

        private String descricao;

        EstadoConservacao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum Situacao {
        DISPONIVEL("Disponível"),
        EMPRESTADO("Emprestado"),
        EM_MANUTENCAO("Em Manutenção"),
        PERDIDO("Perdido");

        private String descricao;

        Situacao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public Exemplar() {
    }

    public Exemplar(int idExemplar, Livro livro, String numeroTombo, String localizacaoEstante,
                    EstadoConservacao estadoConservacao, Situacao situacao) {
        this.idExemplar = idExemplar;
        this.livro = livro;
        this.numeroTombo = numeroTombo;
        this.localizacaoEstante = localizacaoEstante;
        this.estadoConservacao = estadoConservacao;
        this.situacao = situacao;
    }

    public int getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getNumeroTombo() {
        return numeroTombo;
    }

    public void setNumeroTombo(String numeroTombo) {
        this.numeroTombo = numeroTombo;
    }

    public String getLocalizacaoEstante() {
        return localizacaoEstante;
    }

    public void setLocalizacaoEstante(String localizacaoEstante) {
        this.localizacaoEstante = localizacaoEstante;
    }

    public EstadoConservacao getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(EstadoConservacao estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Exemplar [" +
                "idExemplar=" + idExemplar +
                ", livro=" + livro +
                ", numeroTombo='" + numeroTombo + '\'' +
                ", localizacaoEstante='" + localizacaoEstante + '\'' +
                ", estadoConservacao=" + estadoConservacao +
                ", situacao=" + situacao +
                ']';
    }
}