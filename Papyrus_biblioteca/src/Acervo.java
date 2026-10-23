import java.util.ArrayList;
import java.util.List;

public class Acervo {

    private List<Livro> livros = new ArrayList<>(); //Lista de livros do acervo
    private List<Autor> autores = new ArrayList<>(); //Lista de autores do acervo
    private List<Categoria> categorias = new ArrayList<>(); //Lista de categorias do acervo//
    private List<Usuario> usuarios = new ArrayList<>(); //Lista de usuários da biblioteca

    private int proximoIdLivro = 1;
    private int proximoIdAutor = 1;
    private int proximoIdCategoria = 1;
    private int proximoIdUsuario = 1;

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

}
