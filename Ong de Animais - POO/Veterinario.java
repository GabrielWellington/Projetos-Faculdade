public class Veterinario extends Usuario {
    private String crmv;

    public Veterinario(String nome, String email, String crmv) {
        super(nome, email);
        this.crmv = crmv;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    @Override
    public String toString() {
        return "🐾 Veterinário: " + nome + " | CRMV: " + crmv + " | Email: " + email;
    }
}
