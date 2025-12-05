import java.io.*;
import java.util.*;

public class SistemaTratamento {
    private List<Tratamento> tratamentos = new ArrayList<>();

    public void registrarTratamento(Tratamento tratamento) {
        tratamentos.add(tratamento);
    }

    public void listarTratamentos() {
        if (tratamentos.isEmpty()) {
            System.out.println("⚠️ Nenhum tratamento registrado.");
        } else {
            for (Tratamento t : tratamentos) {
                System.out.println(t);
            }
        }
    }

    public void salvarTratamentos(String caminho) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho))) {
            for (Tratamento t : tratamentos) {
                writer.println(t.getNomeAnimal() + ";" + t.getTipoTratamento() + ";" + t.getData());
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar tratamentos.");
        }
    }

    public void carregarTratamentos(String caminho) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    Tratamento t = new Tratamento(partes[0], partes[1], partes[2]);
                    tratamentos.add(t);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Arquivo de tratamentos não encontrado. Será criado ao salvar.");
        }
    }
}
