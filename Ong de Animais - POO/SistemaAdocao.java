import java.io.*;
import java.util.*;

public class SistemaAdocao {
    private List<Adocao> adocoes = new ArrayList<>();

    public void registrarAdocao(Adocao adocao) {
        adocoes.add(adocao);
    }

    public void listarAdocoes() {
        if (adocoes.isEmpty()) {
            System.out.println("⚠️ Nenhuma adoção registrada.");
        } else {
            for (Adocao adocao : adocoes) {
                System.out.println(adocao);
            }
        }
    }

    public void salvarAdocoes(String caminho) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho))) {
            for (Adocao adocao : adocoes) {
                Animal a = adocao.getAnimal();
                writer.println(a.getNome() + ";" + a.getEspecie() + ";" + a.getIdade() + ";" + adocao.getNomeAdotante());
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar adoções.");
        }
    }

    public void carregarAdocoes(String caminho) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    Animal animal = new Animal(partes[0], partes[1], Integer.parseInt(partes[2]));
                    Adocao adocao = new Adocao(animal, partes[3]);
                    adocoes.add(adocao);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Arquivo de adoções não encontrado. Será criado ao salvar.");
        }
    }
}
