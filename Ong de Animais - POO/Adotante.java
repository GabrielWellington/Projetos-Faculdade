public class Adotante extends Usuario {
    private String telefone;

    public Adotante(String nome, String email, String telefone) {
        super(nome, email);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "👥 Adotante: " + nome + " | Email: " + email + " | Telefone: " + telefone;
    }
}
