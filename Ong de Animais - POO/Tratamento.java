public class Tratamento {
    private String nomeAnimal;
    private String tipoTratamento;
    private String data;

    public Tratamento(String nomeAnimal, String tipoTratamento, String data) {
        this.nomeAnimal = nomeAnimal;
        this.tipoTratamento = tipoTratamento;
        this.data = data;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getTipoTratamento() {
        return tipoTratamento;
    }

    public String getData() {
        return data;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public void setTipoTratamento(String tipoTratamento) {
        this.tipoTratamento = tipoTratamento;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "🩺 Animal: " + nomeAnimal + " | Tipo: " + tipoTratamento + " | Data: " + data;
    }
}
