import java.util.ArrayList;
import java.util.List;

public class Acervo {

    private List<Livro> livros = new ArrayList<>();

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

        if (buscarLivroPorId(livro.getIdLivro()) != null) {
            return false;
        }

        livros.add(livro);
        return true;
    }
}
