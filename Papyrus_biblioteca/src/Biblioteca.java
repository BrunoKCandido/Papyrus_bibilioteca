import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>(); //Lista de livros da biblioteca
    private List<Autor> autores = new ArrayList<>(); //Lista de autores da biblioteca
    private List<Categoria> categorias = new ArrayList<>(); //Lista de categorias da biblioteca
    private List<Usuario> usuarios = new ArrayList<>(); //Lista de usuários da biblioteca
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<ItemEmprestimo> itensEmprestimo = new ArrayList<>();

    private int proximoIdLivro = 1;
    private int proximoIdAutor = 1;
    private int proximoIdCategoria = 1;
    private int proximoIdUsuario = 1;
    private int proximoIdEmprestimo = 1;
    private int proximoIdItemEmprestimo = 1;

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getIdLivro() == id) {
                return livro;
            }
        }

        return null;
    }

    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        List<Livro> resultado = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getTitulo() != null &&
                    livro.getTitulo().toLowerCase()
                            .contains(titulo.toLowerCase())) {

                resultado.add(livro);
            }
        }

        return resultado;
    }

    public boolean cadastrarLivro(Livro livro) {
        if (livro == null) {
            return false;
        }

        livro.setIdLivro(proximoIdLivro);
        livros.add(livro);
        proximoIdLivro++;

        return true;
    }

    public List<Livro> consultarLivros() {
        return livros;
    }


    public boolean cadastrarAutor(Autor autor) {
        if (autor == null) {
            return false;
        }

        autor.setIdAutor(proximoIdAutor);
        autores.add(autor);
        proximoIdAutor++;

        return true;
    }

    public List<Autor> consultarAutores() {
        return autores;
    }

    public boolean cadastrarCategoria(Categoria categoria) {
        if (categoria == null) {
            return false;
        }

        for (Categoria existente : categorias) {
            if (existente.getNomeCategoria()
                    .equalsIgnoreCase(categoria.getNomeCategoria())) {
                return false;
            }
        }

        categoria.setIdCategoria(proximoIdCategoria);
        categorias.add(categoria);
        proximoIdCategoria++;

        return true;
    }

    public List<Categoria> consultarCategorias() {
        return categorias;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }

        usuario.setIdUsuario(proximoIdUsuario);
        usuarios.add(usuario);
        proximoIdUsuario++;

        return true;
    }

    public List<Usuario> consultarUsuarios() {
        return usuarios;
    }

    public boolean cadastrarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo == null) {
            return false;
        }

        emprestimo.setIdEmprestimo(proximoIdEmprestimo);
        emprestimos.add(emprestimo);
        proximoIdEmprestimo++;

        return true;
    }

    public List<Emprestimo> consultarEmprestimos() {
        return emprestimos;
    }

    public boolean cadastrarItemEmprestimo(ItemEmprestimo item) {
        if (item == null) {
            return false;
        }

        item.setIdItemEmprestimo(proximoIdItemEmprestimo);
        itensEmprestimo.add(item);
        proximoIdItemEmprestimo++;

        return true;
    }

    public List<ItemEmprestimo> consultarItensEmprestimo() {
        return itensEmprestimo;
    }

    public int contarExemplaresPendentes(Usuario usuario) {
        int quantidade = 0;

        for (ItemEmprestimo item : itensEmprestimo) {
            if (item.getEmprestimo().getUsuario().equals(usuario)
                    && item.getStatusItemEmprestimo()
                    == ItemEmprestimo.StatusItemEmprestimo.EMPRESTADO) {
                quantidade++;
            }
        }

        return quantidade;
    }

    public boolean podeRealizarEmprestimo(Usuario usuario, int quantidade) {
        if (usuario == null || quantidade <= 0) {
            return false;
        }

        if (usuario.getStatusCadastro() != Usuario.StatusCadastro.ATIVO) {
            return false;
        }

        int pendentes = contarExemplaresPendentes(usuario);

        return pendentes + quantidade <= 3;
    }

    public boolean registrarEmprestimo(Usuario usuario,
                                       List<Exemplar> exemplares) {

        if (usuario == null || exemplares == null || exemplares.isEmpty()) {
            return false;
        }

        if (!podeRealizarEmprestimo(usuario, exemplares.size())) {
            return false;
        }

        for (Exemplar exemplar : exemplares) {
            if (exemplar == null
                    || exemplar.getSituacao() != Exemplar.Situacao.DISPONIVEL) {
                return false;
            }
        }

        java.time.LocalDate hoje = java.time.LocalDate.now();

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(hoje);

        if (!cadastrarEmprestimo(emprestimo)) {
            return false;
        }

        for (Exemplar exemplar : exemplares) {
            ItemEmprestimo item = new ItemEmprestimo();

            item.setEmprestimo(emprestimo);
            item.setExemplar(exemplar);
            item.setDataPrevistaDevolucao(hoje.plusDays(10));
            item.setStatusItemEmprestimo(
                    ItemEmprestimo.StatusItemEmprestimo.EMPRESTADO
            );

            cadastrarItemEmprestimo(item);
            exemplar.setSituacao(Exemplar.Situacao.EMPRESTADO);
        }

        return true;
    }
}
