import java.util.Scanner;

public class MenuPapyrus {

    private String nome;
    private String tipo;
    private Scanner scanner;

    public MenuPapyrus() {
        this.scanner = new Scanner(System.in);
        this.nome = "";
        this.tipo = "";
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
