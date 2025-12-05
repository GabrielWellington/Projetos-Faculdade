public class Administrador extends Usuario {

    public Administrador(String nome, String email) {
        super(nome, email);
    }

    // Possível adição futura: funções administrativas
    public void exibirPainelControle() {
        System.out.println("🛠️ Painel do Administrador - Acesso concedido.");
    }
}
