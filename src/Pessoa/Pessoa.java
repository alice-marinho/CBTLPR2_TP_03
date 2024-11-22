public class Pessoa {
    private static int kp = 0; // Contador estático
    private String nome;
    private char sexo;
    private int idade;

    // Construtores
    public Pessoa() {
        kp++;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;
    }

    // Métodos setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("Sexo inválido. Use 'M' ou 'F'.");
        }
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        } else {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
    }

    // Métodos getters
    public static int getKp() {
        return kp;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }
}
