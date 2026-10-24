import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPapyrus {

    private Scanner scanner;
    private Acervo acervo = new Acervo();

    public MenuPapyrus() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuPrincipal() {
        int opcao = 0;
        do {
            System.out.println("\n===== SISTEMA PAPYRUS =====");
            System.out.println("1. Acessar o Sistema");
            System.out.println("0. Sair do Sistema");
            opcao = lerOpcao("Opção: ", 0, 1);

            if (opcao == 1) {
                direcionarMenu();
            } else {
                System.out.println("\nSaindo do sistema Papyrus... Até logo!");
            }
        } while (opcao != 0);
    }

    public void direcionarMenu() {
        System.out.println("\n===== ESCOLHA O PERFIL DE ACESSO =====");
        System.out.println("1. Leitor");
        System.out.println("2. Funcionário");
        System.out.println("3. Administrador");
        System.out.println("0. Voltar ao menu principal");

        int opcao = lerOpcao("Opção: ", 0, 3);

        switch (opcao) {
            case 1:
                exibirMenuLeitor();
                break;
            case 2:
                exibirMenuFuncionario();
                break;
            case 3:
                exibirMenuAdministrador();
                break;
            case 0:
                System.out.println("Retornando ao menu principal...");
                break;
        }
    }

    public void exibirMenuLeitor() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU DO LEITOR ---");
            System.out.println("1. Consultar Acervo");
            System.out.println("2. Meus Empréstimos");
            System.out.println("0. Voltar ao Menu Principal");
            opcao = lerOpcao("Opção: ", 0, 2);

            if (opcao == 1) {
                consultarAcervo();
            } else if (opcao == 2) {
                consultarMeusEmprestimos();
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            }
        } while (opcao != 0);
    }

    public void exibirMenuFuncionario() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU DO FUNCIONARIO ---");
            System.out.println("1. Registrar Empréstimo");
            System.out.println("2. Registrar Devolução");
            System.out.println("3. Consultar Acervo");
            System.out.println("4. Consultar Empréstimos");
            System.out.println("0. Voltar ao Menu Principal");
            opcao = lerOpcao("Opção: ", 0, 4);

            if (opcao == 1) {
                registrarEmprestimo();
            } else if (opcao == 2) {
                registrarDevolucao();
            } else if (opcao == 3) {
                consultarAcervo();
            } else if (opcao == 4) {
                consultarEmprestimos();
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            }
        } while (opcao != 0);
    }

    public void exibirMenuAdministrador() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU DO ADMINISTRADOR ---");
            System.out.println("1. Gerenciar Usuários");
            System.out.println("2. Gerenciar Livros");
            System.out.println("3. Gerenciar Categorias");
            System.out.println("4. Gerenciar Autores");
            System.out.println("5. Gerenciar Exemplares");
            System.out.println("0. Voltar ao Menu Principal");
            opcao = lerOpcao("Opção: ", 0, 5);

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
            }
        } while (opcao != 0);
    }

    public void gerenciarLivros() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR LIVROS ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Consultar Livros");
            System.out.println("0. Voltar");
            opcao = lerOpcao("Opção: ", 0, 2);

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
            }
        } while (opcao != 0);
    }

    public void cadastrarLivro() {
        System.out.println("\n--- CADASTRAR LIVRO ---");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Editora: ");
        String editora = scanner.nextLine();

        System.out.print("Edição: ");
        String edicao = scanner.nextLine();

        int ano = lerOpcao("Ano de publicação: ", 1, 9999);

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

            opcao = lerOpcao("Escolha o número do autor: ", 0, autores.size());

            if (opcao != 0) {
                Autor autor = autores.get(opcao - 1);

                if (livro.getAutores().contains(autor)) {
                    System.out.println("Esse autor já foi associado ao livro.");
                } else if (livro.getAutores().size() >= 3) {
                    System.out.println("O livro já possui o limite de 3 autores.");
                } else {
                    livro.addAutor(autor);
                    System.out.println("Autor associado com sucesso!");
                }
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

            opcao = lerOpcao("Escolha o número da categoria: ", 0, categorias.size());

            if (opcao != 0) {
                Categoria categoria = categorias.get(opcao - 1);

                if (livro.getCategorias().contains(categoria)) {
                    System.out.println("Essa categoria já foi associada ao livro.");
                } else {
                    livro.addCategoria(categoria);
                    System.out.println("Categoria associada com sucesso!");
                }
            }

        } while (opcao != 0);
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

    public void gerenciarCategorias() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR CATEGORIAS ---");
            System.out.println("1. Cadastrar Categoria");
            System.out.println("2. Consultar Categorias");
            System.out.println("0. Voltar");
            opcao = lerOpcao("Opção: ", 0, 2);

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
            }
        } while (opcao != 0);
    }

    public void cadastrarCategoria() {
        System.out.println("\n--- CADASTRAR CATEGORIA ---");

        System.out.print("Nome da categoria: ");
        String nomeCategoria = scanner.nextLine();

        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(nomeCategoria);

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

    public void gerenciarAutores() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR AUTORES ---");
            System.out.println("1. Cadastrar Autor");
            System.out.println("2. Consultar Autores");
            System.out.println("0. Voltar");
            opcao = lerOpcao("Opção: ", 0, 2);

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

    public void gerenciarExemplares() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR EXEMPLARES ---");
            System.out.println("1. Cadastrar Exemplar");
            System.out.println("2. Consultar Exemplares");
            System.out.println("0. Voltar");
            opcao = lerOpcao("Opção: ", 0, 2);

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

        int opcaoLivro = lerOpcao("Escolha o livro: ", 1, livros.size());

        Livro livro = livros.get(opcaoLivro - 1);

        System.out.print("Número de tombo: ");
        String numeroTombo = scanner.nextLine();

        System.out.print("Localização na estante: ");
        String localizacao = scanner.nextLine();

        System.out.println("Estado de conservação:");
        System.out.println("1. Novo");
        System.out.println("2. Bom");
        System.out.println("3. Danificado");
        int opcaoEstado = lerOpcao("Escolha o estado de conservação: ", 1, 3);

        Exemplar.EstadoConservacao estado = switch (opcaoEstado) {
            case 1 -> Exemplar.EstadoConservacao.NOVO;
            case 2 -> Exemplar.EstadoConservacao.BOM;
            case 3 -> Exemplar.EstadoConservacao.DANIFICADO;
            default -> throw new IllegalStateException(
                    "Opção de conservação inesperada: " + opcaoEstado
            );
        };

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

    public void gerenciarUsuarios() {
        int opcao = -1;

        do {
            System.out.println("\n--- GERENCIAR USUÁRIOS ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Consultar Usuários");
            System.out.println("0. Voltar");
            opcao = lerOpcao("Opção: ", 0, 2);

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
            }

        } while (opcao != 0);
    }

    public void cadastrarUsuario() {
        System.out.println("\n--- CADASTRAR USUÁRIO ---");

        System.out.print("Nome: ");
        String nomeUsuario = scanner.nextLine();

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
        int opcaoTipo = lerOpcao("Opção: ", 1, 3);

        Usuario.TipoUsuario tipo = switch (opcaoTipo) {
            case 1 -> Usuario.TipoUsuario.FUNCIONARIO;
            case 2 -> Usuario.TipoUsuario.LEITOR;
            case 3 -> Usuario.TipoUsuario.ADMINISTRADOR;
            default -> throw new IllegalStateException(
                    "Tipo de usuário inesperado: " + opcaoTipo
            );
        };

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
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

    public Usuario selecionarUsuario() {
        List<Usuario> usuarios = acervo.consultarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return null;
        }

        System.out.println("\n--- SELECIONAR USUÁRIO ---");

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);

            System.out.println(
                    (i + 1) + ". " + usuario.getNomeUsuario()
                            + " - CPF: " + usuario.getCpf()
            );
        }

        System.out.println("0. Cancelar");

        int opcao = lerOpcao("Escolha o usuário: ", 0, usuarios.size());

        if (opcao == 0) {
            return null;
        }

        return usuarios.get(opcao - 1);
    }

    public List<Exemplar> selecionarExemplares(Usuario usuario) {
        List<Exemplar> selecionados = new ArrayList<>();

        int pendentes = acervo.contarExemplaresPendentes(usuario);
        int limite = 3 - pendentes;

        if (limite <= 0) {
            System.out.println(
                    "O usuário já possui 3 exemplares pendentes."
            );
            return selecionados;
        }

        List<Exemplar> disponiveis = new ArrayList<>();

        for (Livro livro : acervo.consultarLivros()) {
            for (Exemplar exemplar : livro.getExemplares()) {
                if (exemplar.getSituacao()
                        == Exemplar.Situacao.DISPONIVEL) {
                    disponiveis.add(exemplar);
                }
            }
        }

        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum exemplar disponível.");
            return selecionados;
        }

        while (selecionados.size() < limite) {
            System.out.println("\n--- EXEMPLARES DISPONÍVEIS ---");

            for (int i = 0; i < disponiveis.size(); i++) {
                Exemplar exemplar = disponiveis.get(i);

                if (!selecionados.contains(exemplar)) {
                    System.out.println(
                            (i + 1) + ". "
                                    + exemplar.getLivro().getTitulo()
                                    + " | Tombo: " + exemplar.getNumeroTombo()
                                    + " | Localização: "
                                    + exemplar.getLocalizacaoEstante()
                    );
                }
            }

            System.out.println("0. Finalizar seleção");

            int opcao = lerOpcao("Opção: ", 0, disponiveis.size());

            if (opcao == 0) {
                break;
            }

            Exemplar exemplar = disponiveis.get(opcao - 1);

            if (selecionados.contains(exemplar)) {
                System.out.println("Esse exemplar já foi selecionado.");
            } else {
                selecionados.add(exemplar);
                System.out.println("Exemplar selecionado.");
            }
        }

        return selecionados;
    }

    public void registrarEmprestimo() {
        System.out.println("\n--- REGISTRAR EMPRÉSTIMO ---");

        Usuario usuario = selecionarUsuario();

        if (usuario == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        if (usuario.getStatusCadastro() != Usuario.StatusCadastro.ATIVO) {
            System.out.println("O usuário não está ativo.");
            return;
        }

        List<Exemplar> exemplares = selecionarExemplares(usuario);

        if (exemplares.isEmpty()) {
            System.out.println("Nenhum exemplar selecionado.");
            return;
        }

        boolean registrado = acervo.registrarEmprestimo(usuario, exemplares);

        if (registrado) {
            System.out.println("Empréstimo registrado com sucesso!");
            System.out.println("Usuário: " + usuario.getNomeUsuario());
            System.out.println("Quantidade de exemplares: " + exemplares.size());
            System.out.println("Data do empréstimo: " + java.time.LocalDate.now());
            System.out.println(
                    "Prazo para devolução: "
                            + java.time.LocalDate.now().plusDays(10)
            );
        } else {
            System.out.println(
                    "Não foi possível registrar o empréstimo. "
                            + "Verifique o limite e a disponibilidade dos exemplares."
            );
        }
    }

    public void registrarDevolucao() {
        System.out.println("\n--- REGISTRAR DEVOLUÇÃO ---");

        List<ItemEmprestimo> itens = acervo.consultarItensEmprestimo();
        List<ItemEmprestimo> pendentes = new ArrayList<>();

        for (ItemEmprestimo item : itens) {
            if (item.getStatusItemEmprestimo()
                    == ItemEmprestimo.StatusItemEmprestimo.EMPRESTADO) {
                pendentes.add(item);
            }
        }

        if (pendentes.isEmpty()) {
            System.out.println("Não há exemplares pendentes de devolução.");
            return;
        }

        System.out.println("\n--- EXEMPLARES PENDENTES ---");

        for (int i = 0; i < pendentes.size(); i++) {
            ItemEmprestimo item = pendentes.get(i);

            System.out.println(
                    (i + 1) + ". "
                            + "Usuário: "
                            + item.getEmprestimo().getUsuario().getNomeUsuario()
                            + " | Livro: "
                            + item.getExemplar().getLivro().getTitulo()
                            + " | Tombo: "
                            + item.getExemplar().getNumeroTombo()
                            + " | Devolução prevista: "
                            + item.getDataPrevistaDevolucao()
            );
        }

        System.out.println("0. Cancelar");

        int opcao = lerOpcao("Selecione o exemplar a ser devolvido:", 0, pendentes.size());

        if (opcao == 0) {
            System.out.println("Operação cancelada.");
            return;
        }

        ItemEmprestimo item = pendentes.get(opcao - 1);

        boolean devolvido = item.devolver(java.time.LocalDate.now());

        if (devolvido) {
            System.out.println("Devolução registrada com sucesso!");
            System.out.println(
                    "Livro: " + item.getExemplar().getLivro().getTitulo()
            );
            System.out.println(
                    "Data da devolução: " + item.getDataEfetivaDevolucao()
            );
        } else {
            System.out.println("Não foi possível registrar a devolução.");
        }
    }

    public void consultarEmprestimos() {
        System.out.println("\n--- CONSULTAR EMPRÉSTIMOS ---");

        List<Emprestimo> emprestimos = acervo.consultarEmprestimos();

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }

        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("\nID do empréstimo: "
                    + emprestimo.getIdEmprestimo());

            System.out.println("Usuário: "
                    + emprestimo.getUsuario().getNomeUsuario());

            System.out.println("Data do empréstimo: "
                    + emprestimo.getDataEmprestimo());

            System.out.println("--- ITENS DO EMPRÉSTIMO ---");

            for (ItemEmprestimo item : acervo.consultarItensEmprestimo()) {
                if (item.getEmprestimo() == emprestimo) {
                    System.out.println("Livro: "
                            + item.getExemplar().getLivro().getTitulo());

                    System.out.println("Número de tombo: "
                            + item.getExemplar().getNumeroTombo());

                    System.out.println("Data prevista de devolução: "
                            + item.getDataPrevistaDevolucao());

                    System.out.println("Data efetiva de devolução: "
                            + (item.getDataEfetivaDevolucao() == null
                            ? "Ainda não devolvido"
                            : item.getDataEfetivaDevolucao()));

                    System.out.println("Status: "
                            + item.getStatusItemEmprestimo().getDescricao());

                    System.out.println("-----------------------------");
                }
            }
        }
    }

    public void consultarMeusEmprestimos() {
        System.out.println("\n--- MEUS EMPRÉSTIMOS ---");

        int idUsuario = lerOpcao("Digite o ID do leitor: ", 1, Integer.MAX_VALUE);
        Usuario usuario = null;

        for (Usuario cadastrado : acervo.consultarUsuarios()) {
            if (cadastrado.getIdUsuario() == idUsuario
                    && cadastrado.getTipoUsuario() == Usuario.TipoUsuario.LEITOR) {
                usuario = cadastrado;
                break;
            }
        }

        if (usuario == null) {
            System.out.println(
                    "Nenhum leitor cadastrado corresponde ao ID informado."
            );
            return;
        }

        List<ItemEmprestimo> itens = acervo.consultarItensEmprestimo();
        boolean encontrou = false;

        for (ItemEmprestimo item : itens) {
            if (item.getEmprestimo() != null
                    && item.getEmprestimo().getUsuario() == usuario) {

                if (!encontrou) {
                    System.out.println(
                            "Leitor: " + usuario.getNomeUsuario()
                    );
                    encontrou = true;
                }

                System.out.println("\nLivro: "
                        + item.getExemplar().getLivro().getTitulo());

                System.out.println("Número de tombo: "
                        + item.getExemplar().getNumeroTombo());

                System.out.println("Data do empréstimo: "
                        + item.getEmprestimo().getDataEmprestimo());

                System.out.println("Data prevista de devolução: "
                        + item.getDataPrevistaDevolucao());

                System.out.println("Data efetiva de devolução: "
                        + (item.getDataEfetivaDevolucao() == null
                        ? "Ainda não devolvido"
                        : item.getDataEfetivaDevolucao()));

                System.out.println("Status: "
                        + item.getStatusItemEmprestimo().getDescricao());

                System.out.println("-----------------------------");
            }
        }

        if (!encontrou) {
            System.out.println("Você ainda não possui empréstimos registrados.");
        }
    }

    public int lerOpcao(String mensagem, int minimo, int maximo) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                int opcao = Integer.parseInt(entrada);

                if (opcao < minimo || opcao > maximo) {
                    System.out.println(
                            "Opção inválida! Digite um número entre "
                                    + minimo + " e " + maximo + "."
                    );
                    continue;
                }

                return opcao;

            } catch (NumberFormatException e) {
                System.out.println(
                        "Entrada inválida! Digite apenas um número inteiro."
                );
            }
        }
    }
}