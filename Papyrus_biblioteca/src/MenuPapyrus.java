import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPapyrus {

    private String nome;
    private String tipo;
    private Scanner scanner;
    private Acervo acervo = new Acervo();

    public void exibirResultados(List<Livro> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
            return;
        }

        System.out.println("\n--- LIVROS ENCONTRADOS ---");

        for (Livro livro : resultados) {
            System.out.println(livro);
        }
    }


    public void consultarLivros() {
        System.out.println("\n--- CONSULTAR LIVROS ---");

        List<Livro> livros = acervo.consultarLivros();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void gerenciarLivros() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR LIVROS ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Consultar Livros");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    consultarLivros();
                    break;
                case 0:
                    System.out.println("Voltando ao menu do administrador...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public MenuPapyrus() {
        this.scanner = new Scanner(System.in);
        this.nome = "";
        this.tipo = "";
    }

    public void cadastrarLivro() {
        System.out.println("\n--- CADASTRAR LIVRO ---");

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
                0, titulo, editora, edicao, ano, isbn
        );

        associarAutores(livro);
        associarCategorias(livro);

        if (acervo.cadastrarLivro(livro)) {
            System.out.println("Livro cadastrado com sucesso!");
            System.out.println("ID gerado: " + livro.getIdLivro());
        } else {
            System.out.println("Não foi possível cadastrar o livro.");
        }
    }

    public void associarAutores(Livro livro) {
        List<Autor> autores = acervo.consultarAutores();

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
            return;
        }

        int opcao;

        do {
            System.out.println("\n--- ASSOCIAR AUTORES AO LIVRO ---");

            for (int i = 0; i < autores.size(); i++) {
                System.out.println((i + 1) + ". " + autores.get(i));
            }

            System.out.println("0. Finalizar seleção");
            System.out.print("Escolha o número do autor: ");

            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao > 0 && opcao <= autores.size()) {
                Autor autor = autores.get(opcao - 1);

                if (livro.getAutores().contains(autor)) {
                    System.out.println("Esse autor já foi associado ao livro.");
                } else if (livro.getAutores().size() >= 3) {
                    System.out.println("O livro já possui o limite de 3 autores.");
                } else {
                    livro.addAutor(autor);
                    System.out.println("Autor associado com sucesso!");
                }
            } else if (opcao != 0) {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0 && livro.getAutores().size() < 3);
    }

    public void associarCategorias(Livro livro) {
        List<Categoria> categorias = acervo.consultarCategorias();

        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.");
            return;
        }

        int opcao;

        do {
            System.out.println("\n--- ASSOCIAR CATEGORIAS AO LIVRO ---");

            for (int i = 0; i < categorias.size(); i++) {
                System.out.println((i + 1) + ". " + categorias.get(i));
            }

            System.out.println("0. Finalizar seleção");
            System.out.print("Escolha o número da categoria: ");

            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao > 0 && opcao <= categorias.size()) {
                Categoria categoria = categorias.get(opcao - 1);

                if (livro.getCategorias().contains(categoria)) {
                    System.out.println("Essa categoria já foi associada ao livro.");
                } else {
                    livro.addCategoria(categoria);
                    System.out.println("Categoria associada com sucesso!");
                }
            } else if (opcao != 0) {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public void cadastrarCategoria() {
        System.out.println("\n--- CADASTRAR CATEGORIA ---");

        System.out.print("Nome da categoria: ");
        String nome = scanner.nextLine();

        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(nome);

        if (acervo.cadastrarCategoria(categoria)) {
            System.out.println("Categoria cadastrada com sucesso!");
            System.out.println("ID gerado: " + categoria.getIdCategoria());
        } else {
            System.out.println(
                    "Não foi possível cadastrar a categoria. Verifique se ela já existe."
            );
        }
    }

    public void consultarCategorias() {
        System.out.println("\n--- CONSULTAR CATEGORIAS ---");

        List<Categoria> categorias = acervo.consultarCategorias();

        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.");
            return;
        }

        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

    public void gerenciarCategorias() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR CATEGORIAS ---");
            System.out.println("1. Cadastrar Categoria");
            System.out.println("2. Consultar Categorias");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarCategoria();
                    break;
                case 2:
                    consultarCategorias();
                    break;
                case 0:
                    System.out.println("Voltando ao menu do administrador...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void cadastrarAutor() {
        System.out.println("\n--- CADASTRAR AUTOR ---");
        System.out.print("Nome do autor: ");

        String nomeAutor = scanner.nextLine();

        Autor autor = new Autor();
        autor.setNomeAutor(nomeAutor);

        if (acervo.cadastrarAutor(autor)) {
            System.out.println("Autor cadastrado com sucesso!");
            System.out.println("ID gerado: " + autor.getIdAutor());
        } else {
            System.out.println("Não foi possível cadastrar o autor.");
        }
    }

    public void consultarAutores() {
        System.out.println("\n--- CONSULTAR AUTORES ---");

        List<Autor> autores = acervo.consultarAutores();

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
            return;
        }

        for (Autor autor : autores) {
            System.out.println(autor);
        }
    }

    public void gerenciarAutores() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR AUTORES ---");
            System.out.println("1. Cadastrar Autor");
            System.out.println("2. Consultar Autores");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarAutor();
                    break;
                case 2:
                    consultarAutores();
                    break;
                case 0:
                    System.out.println("Voltando ao menu do administrador...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public void gerenciarExemplares() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR EXEMPLARES ---");
            System.out.println("1. Cadastrar Exemplar");
            System.out.println("2. Consultar Exemplares");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarExemplar();
                    break;
                case 2:
                    consultarExemplares();
                    break;
                case 0:
                    System.out.println("Voltando ao menu do administrador...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public void cadastrarExemplar() {
        System.out.println("\n--- CADASTRAR EXEMPLAR ---");

        List<Livro> livros = acervo.consultarLivros();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado. Cadastre um livro antes de adicionar exemplares.");
            return;
        }

        System.out.println("Selecione o livro:");

        for (int i = 0; i < livros.size(); i++) {
            System.out.println((i + 1) + ". " + livros.get(i).getTitulo());
        }

        System.out.print("Número do livro: ");
        int opcaoLivro = Integer.parseInt(scanner.nextLine());

        if (opcaoLivro < 1 || opcaoLivro > livros.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Livro livro = livros.get(opcaoLivro - 1);

        System.out.print("Número de tombo: ");
        String numeroTombo = scanner.nextLine();

        System.out.print("Localização na estante: ");
        String localizacao = scanner.nextLine();

        System.out.println("Estado de conservação:");
        System.out.println("1. Novo");
        System.out.println("2. Bom");
        System.out.println("3. Danificado");
        System.out.print("Opção: ");
        int opcaoEstado = Integer.parseInt(scanner.nextLine());

        Exemplar.EstadoConservacao estado;

        switch (opcaoEstado) {
            case 1:
                estado = Exemplar.EstadoConservacao.NOVO;
                break;
            case 2:
                estado = Exemplar.EstadoConservacao.BOM;
                break;
            case 3:
                estado = Exemplar.EstadoConservacao.DANIFICADO;
                break;
            default:
                System.out.println("Opção de conservação inválida.");
                return;
        }

        Exemplar exemplar = new Exemplar();
        exemplar.setNumeroTombo(numeroTombo);
        exemplar.setLocalizacaoEstante(localizacao);
        exemplar.setEstadoConservacao(estado);

        livro.addExemplar(exemplar);

        System.out.println("Exemplar cadastrado com sucesso!");
        System.out.println("ID do exemplar: " + exemplar.getIdExemplar());
        System.out.println("Livro: " + livro.getTitulo());
    }

    public void consultarExemplares() {
        System.out.println("\n--- CONSULTAR EXEMPLARES ---");

        List<Livro> livros = acervo.consultarLivros();

        boolean encontrouExemplar = false;

        for (Livro livro : livros) {
            List<Exemplar> exemplares = livro.getExemplares();

            if (!exemplares.isEmpty()) {
                System.out.println("\nLivro: " + livro.getTitulo());

                for (Exemplar exemplar : exemplares) {
                    System.out.println(exemplar);
                    encontrouExemplar = true;
                }
            }
        }

        if (!encontrouExemplar) {
            System.out.println("Nenhum exemplar cadastrado.");
        }
    }

    public void consultarAcervo() {
        System.out.println("\n--- CONSULTAR ACERVO ---");
        System.out.print("Digite o título ou parte dele: ");

        String titulo = scanner.nextLine();

        List<Livro> resultados = acervo.buscarLivrosPorTitulo(titulo);

        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
            return;
        }

        for (Livro livro : resultados) {
            System.out.println(livro);
        }
    }


    public void cadastrarUsuario() {
        System.out.println("\n--- CADASTRAR USUÁRIO ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Tipo de usuário:");
        System.out.println("1. Funcionário");
        System.out.println("2. Leitor");
        System.out.println("3. Administrador");
        System.out.print("Opção: ");

        int opcaoTipo = Integer.parseInt(scanner.nextLine());

        Usuario.TipoUsuario tipo;

        switch (opcaoTipo) {
            case 1:
                tipo = Usuario.TipoUsuario.FUNCIONARIO;
                break;
            case 2:
                tipo = Usuario.TipoUsuario.LEITOR;
                break;
            case 3:
                tipo = Usuario.TipoUsuario.ADMINISTRADOR;
                break;
            default:
                System.out.println("Tipo de usuário inválido.");
                return;
        }

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nome);
        usuario.setCpf(cpf);
        usuario.setTelefoneUsuario(telefone);
        usuario.setEnderecoUsuario(endereco);
        usuario.setEmail(email);
        usuario.setTipoUsuario(tipo);
        usuario.setDataCadastro(java.time.LocalDate.now());
        usuario.setStatusCadastro(Usuario.StatusCadastro.ATIVO);

        if (acervo.cadastrarUsuario(usuario)) {
            System.out.println("Usuário cadastrado com sucesso!");
            System.out.println("ID gerado: " + usuario.getIdUsuario());
        } else {
            System.out.println("Não foi possível cadastrar o usuário.");
        }
    }

    public void consultarUsuarios() {
        System.out.println("\n--- CONSULTAR USUÁRIOS ---");

        List<Usuario> usuarios = acervo.consultarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void gerenciarUsuarios() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR USUÁRIOS ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Consultar Usuários");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    consultarUsuarios();
                    break;
                case 0:
                    System.out.println("Voltando ao menu do administrador...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
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
        System.out.println("Escolha o tipo de usuário:");
        System.out.println("1 - Funcionário");
        System.out.println("2 - Leitor");
        System.out.println("3 - Administrador");
        System.out.print("Opção: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            setTipo("Funcionário");
        } else if (opcao == 2) {
            setTipo("Leitor");
        } else if (opcao == 3) {
            setTipo("Administrador");
        } else {
            setTipo("Inválido");
        }
    }

    public void exibirMenuPrincipal() {
        int opcao = 0;
        do {
            System.out.println("\n===== SISTEMA PAPYRUS =====");
            System.out.println("1. Acessar o Sistema");
            System.out.println("0. Sair do Sistema");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                lerNome();
                lerTipo();
                System.out.println("\n>> " + toString());
                direcionarMenu();
            } else if (opcao == 0) {
                System.out.println("\nSaindo do sistema Papyrus... Até logo!");
            } else {
                System.out.println("\nOpção inválida! Tente novamente.");
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
            System.out.println("Tipo de usuário inválido. Retornando ao menu principal.");
        }
    }

    public void exibirMenuFuncionario() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU DO FUNCIONARIO ---");
            System.out.println("Usuário: " + getNome());
            System.out.println("1. Registrar Empréstimo");
            System.out.println("2. Registrar Devolução");
            System.out.println("3. Consultar Acervo");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                System.out.println(">> Registrando emprestimo...");
            } else if (opcao == 2) {
                System.out.println(">> Registrando devolucao...");
            } else if (opcao == 3) {
                consultarAcervo();
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void exibirMenuLeitor() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU DO LEITOR ---");
            System.out.println("Usuário: " + getNome());
            System.out.println("1. Consultar Acervo");
            System.out.println("2. Meus Empréstimos");
            System.out.println("3. Reservar Livro");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                consultarAcervo();
            } else if (opcao == 2) {
                System.out.println(">> Exibindo meus empréstimos...");
            } else if (opcao == 3) {
                System.out.println(">> Reservando livro...");
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void exibirMenuAdministrador() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU DO ADMINISTRADOR ---");
            System.out.println("Usuário: " + getNome());
            System.out.println("1. Gerenciar Usuários");
            System.out.println("2. Gerenciar Livros");
            System.out.println("3. Gerenciar Categorias");
            System.out.println("4. Gerenciar Autores");
            System.out.println("5. Gerenciar Exemplares");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                gerenciarUsuarios();
            } else if (opcao == 2) {
                gerenciarLivros();
            } else if (opcao == 3) {
                gerenciarCategorias();
            } else if (opcao == 4) {
                gerenciarAutores();
            } else if (opcao == 5) {
                gerenciarExemplares();
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    @Override
    public String toString() {
        return "Usuário: " + getNome() + " | Tipo: " + getTipo();
    }
}