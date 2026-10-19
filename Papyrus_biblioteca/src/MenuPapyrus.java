import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPapyrus {

    private String nome;
    private String tipo;
    private Scanner scanner;
    private List<Autor> autores = new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();
    private Acervo acervo = new Acervo();

    private void exibirResultados(List<Livro> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
            return;
        }

        System.out.println("\n--- LIVROS ENCONTRADOS ---");

        for (Livro livro : resultados) {
            System.out.println(livro);
        }
    }

    private void pesquisarLivros() {
        System.out.println("\n--- PESQUISAR LIVROS ---");
        System.out.println("1. Pesquisar por ID");
        System.out.println("2. Pesquisar por título");
        System.out.println("0. Voltar");
        System.out.print("Opção: ");

        int opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao) {
            case 1:
                System.out.print("Digite o ID do livro: ");
                int id = Integer.parseInt(scanner.nextLine());

                Livro livro = acervo.buscarLivroPorId(id);

                if (livro != null) {
                    List<Livro> resultado = new ArrayList<>();
                    resultado.add(livro);
                    exibirResultados(resultado);
                } else {
                    System.out.println("Livro não encontrado.");
                }
                break;

            case 2:
                System.out.print("Digite o título ou parte dele: ");
                String titulo = scanner.nextLine();

                List<Livro> resultados = acervo.buscarLivrosPorTitulo(titulo);
                exibirResultados(resultados);
                break;

            case 0:
                System.out.println("Voltando...");
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public MenuPapyrus() {
        this.scanner = new Scanner(System.in);
        this.nome = "";
        this.tipo = "";
    }

    private void cadastrarLivro() {
        System.out.println("\n--- CADASTRAR LIVRO ---");

        System.out.print("ID do livro: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Editora: ");
        String editora = scanner.nextLine();

        System.out.print("Edição: ");
        String edicao = scanner.nextLine();

        System.out.print("Ano de publicação: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Livro livro = new Livro(
                id, titulo, editora, edicao, ano, isbn
        );

        if (acervo.cadastrarLivro(livro)) {
            System.out.println("Livro cadastrado com sucesso!");
        } else {
            System.out.println("Não foi possível cadastrar o livro.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void lerNome() {
        System.out.print("Digite seu nome: ");
        setNome(scanner.nextLine());
    }

    public void lerTipo() {
        System.out.println("Escolha o tipo de usuario:");
        System.out.println("1 - Funcionario");
        System.out.println("2 - Leitor");
        System.out.println("3 - Administrador");
        System.out.print("Opcao: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            setTipo("Funcionario");
        } else if (opcao == 2) {
            setTipo("Leitor");
        } else if (opcao == 3) {
            setTipo("Administrador");
        } else {
            setTipo("Invalido");
        }
    }

    public void exibirMenuPrincipal() {
        int opcao = 0;
        do {
            System.out.println("\n===== SISTEMA PAPYRUS =====");
            System.out.println("1. Acessar o Sistema");
            System.out.println("0. Sair do Sistema");
            System.out.print("Opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                lerNome();
                lerTipo();
                System.out.println("\n>> " + toString());
                direcionarMenu();
            } else if (opcao == 0) {
                System.out.println("\nSaindo do sistema Papyrus... Ate logo!");
            } else {
                System.out.println("\nOpcao invalida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public void direcionarMenu() {
        if (getTipo().equals("Funcionario")) {
            exibirMenuFuncionario();
        } else if (getTipo().equals("Leitor")) {
            exibirMenuLeitor();
        } else if (getTipo().equals("Administrador")) {
            exibirMenuAdministrador();
        } else {
            System.out.println("Tipo de usuario invalido. Retornando ao menu principal.");
        }
    }

    public void exibirMenuFuncionario() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU DO FUNCIONARIO ---");
            System.out.println("Usuario: " + getNome());
            System.out.println("1. Registrar Emprestimo");
            System.out.println("2. Registrar Devolucao");
            System.out.println("3. Consultar Acervo");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                System.out.println(">> Registrando emprestimo...");
            } else if (opcao == 2) {
                System.out.println(">> Registrando devolucao...");
            } else if (opcao == 3) {
                System.out.println(">> Consultando acervo...");
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    public void exibirMenuLeitor() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU DO LEITOR ---");
            System.out.println("Usuario: " + getNome());
            System.out.println("1. Consultar Acervo");
            System.out.println("2. Meus Emprestimos");
            System.out.println("3. Reservar Livro");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                System.out.println(">> Consultando acervo...");
            } else if (opcao == 2) {
                System.out.println(">> Exibindo meus emprestimos...");
            } else if (opcao == 3) {
                System.out.println(">> Reservando livro...");
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    public void exibirMenuAdministrador() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU DO ADMINISTRADOR ---");
            System.out.println("Usuario: " + getNome());
            System.out.println("1. Gerenciar Usuarios");
            System.out.println("2. Gerenciar Livros");
            System.out.println("3. Gerenciar Categorias");
            System.out.println("4. Relatorios");
            System.out.println("5. Pesquisar Livros");
            System.out.println("6. Cadastrar Livro");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                System.out.println(">> Gerenciando usuarios...");
            } else if (opcao == 2) {
                System.out.println(">> Gerenciando livros...");
            } else if (opcao == 3) {
                System.out.println(">> Gerenciando categorias...");
            } else if (opcao == 4) {
                System.out.println(">> Gerando relatorios...");
            } else if (opcao == 5) {
                pesquisarLivros();
            } else if (opcao == 6) {
                cadastrarLivro();
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    @Override
    public String toString() {
        return "Usuario: " + getNome() + " | Tipo: " + getTipo();
    }
}
