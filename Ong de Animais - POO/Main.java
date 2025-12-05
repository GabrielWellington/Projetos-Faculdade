import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Animal> animais = new ArrayList<>();
    static SistemaAdocao sistemaAdocao = new SistemaAdocao();

    public static void main(String[] args) {
        carregarAnimais();
        carregarAdocoes();

        int opcao = -1;
        while (opcao != 6) {
            System.out.println("\n===== ONG ANIMAIS - MENU =====");
            System.out.println("1. Cadastrar animal");
            System.out.println("2. Listar animais");
            System.out.println("3. Remover animal");
            System.out.println("4. Registrar adoção");
            System.out.println("5. Listar adoções pendentes");
            System.out.println("6. Salvar e sair");
            System.out.print("Opção: ");
            try {
                opcao = Integer.parseInt(sc.nextLine());
                switch (opcao) {
                    case 1: cadastrarAnimal(); break;
                    case 2: listarAnimais(); break;
                    case 3: removerAnimal(); break;
                    case 4: registrarAdocao(); break;
                    case 5: listarAdocoesPendentes(); break;
                    case 6:
                        salvarAnimais();
                        salvarAdocoes();
                        System.out.println("✅ Dados salvos. Programa encerrado.");
                        break;
                    default:
                        System.out.println("⚠️ Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Digite um número.");
            }
        }
    }

    static void cadastrarAnimal() {
        System.out.println("\n== Cadastro de Animal ==");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Espécie: ");
        String especie = sc.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        Animal animal = new Animal(nome, especie, idade);
        animais.add(animal);
        System.out.println("✅ Animal cadastrado com sucesso.");
    }

    static void listarAnimais() {
        System.out.println("\n== Lista de Animais ==");
        if (animais.isEmpty()) {
            System.out.println("⚠️ Nenhum animal cadastrado.");
        } else {
            for (Animal a : animais) {
                System.out.println(a);
            }
        }
    }

    static void removerAnimal() {
        System.out.print("\nDigite o nome do animal a ser removido: ");
        String nome = sc.nextLine();
        boolean removido = animais.removeIf(a -> a.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("✅ Animal removido.");
        } else {
            System.out.println("❌ Animal não encontrado.");
        }
    }

    static void registrarAdocao() {
        System.out.print("\nDigite o nome do animal a ser adotado: ");
        String nome = sc.nextLine();
        Animal animal = null;
        for (Animal a : animais) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                animal = a;
                break;
            }
        }

        if (animal != null) {
            System.out.print("Nome do adotante: ");
            String adotante = sc.nextLine();
            sistemaAdocao.registrarAdocao(new Adocao(animal, adotante));
            animais.remove(animal);
            System.out.println("✅ Adoção registrada.");
        } else {
            System.out.println("❌ Animal não encontrado.");
        }
    }

    static void listarAdocoesPendentes() {
        System.out.println("\n== Adoções Registradas ==");
        sistemaAdocao.listarAdocoes();
    }

    static void carregarAnimais() {
        try (BufferedReader reader = new BufferedReader(new FileReader("animais.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    Animal animal = new Animal(dados[0], dados[1], Integer.parseInt(dados[2]));
                    animais.add(animal);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Arquivo de animais não encontrado. Um novo será criado.");
        }
    }

    static void salvarAnimais() {
        try (PrintWriter writer = new PrintWriter("animais.txt")) {
            for (Animal a : animais) {
                writer.println(a.getNome() + ";" + a.getEspecie() + ";" + a.getIdade());
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar animais.");
        }
    }

    static void carregarAdocoes() {
        sistemaAdocao.carregarAdocoes("adocoes.txt");
    }

    static void salvarAdocoes() {
        sistemaAdocao.salvarAdocoes("adocoes.txt");
    }
}
