import java.time.LocalDate;

public class Usuario {

    private int idUsuario;
    private String nomeUsuario;
    private String cpf;
    private String telefoneUsuario;
    private String enderecoUsuario;
    private String email;
    private TipoUsuario tipoUsuario;
    private LocalDate dataCadastro;
    private StatusCadastro statusCadastro;

    public enum TipoUsuario {
        FUNCIONARIO("Funcionário"),
        LEITOR("Leitor"),
        ADMINISTRADOR("Administrador");

        private String descricao;

        TipoUsuario(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum StatusCadastro {
        ATIVO("Ativo"),
        SUSPENSO("Suspenso");

        private String descricao;

        StatusCadastro(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public Usuario() {
    }

    public Usuario(
            int idUsuario,
            String nomeUsuario,
            String cpf,
            String telefoneUsuario,
            String enderecoUsuario,
            String email,
            TipoUsuario tipoUsuario,
            LocalDate dataCadastro,
            StatusCadastro statusCadastro
    ) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpf = cpf;
        this.telefoneUsuario = telefoneUsuario;
        this.enderecoUsuario = enderecoUsuario;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.dataCadastro = dataCadastro;
        this.statusCadastro = statusCadastro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public StatusCadastro getStatusCadastro() {
        return statusCadastro;
    }

    public void setStatusCadastro(StatusCadastro statusCadastro) {
        this.statusCadastro = statusCadastro;
    }

    @Override
    public String toString() {
        return "Usuario [" +
                "idUsuario=" + idUsuario +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefoneUsuario='" + telefoneUsuario + '\'' +
                ", enderecoUsuario='" + enderecoUsuario + '\'' +
                ", email='" + email + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", dataCadastro=" + dataCadastro +
                ", statusCadastro=" + statusCadastro +
                ']';
    }
}
