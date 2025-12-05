public class Adocao {
    private Animal animal;
    private String nomeAdotante;

    public Adocao(Animal animal, String nomeAdotante) {
        this.animal = animal;
        this.nomeAdotante = nomeAdotante;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getNomeAdotante() {
        return nomeAdotante;
    }

    @Override
    public String toString() {
        return "🐶 Animal: " + animal.getNome() + " | Adotante: " + nomeAdotante;
    }
}
