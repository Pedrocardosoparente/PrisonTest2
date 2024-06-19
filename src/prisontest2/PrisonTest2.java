
import java.util.Objects;

public class PrisonTest2 {
    public static void main(String[] args) {
        // Instanciando os prisioneiros
        Prisioneiro twitch = new Prisioneiro("Twitch", 1.73, "3 anos");
        Prisioneiro bubba = new Prisioneiro("Bubba", 2.08, "4 anos");
        
        // Testando a igualdade dos objetos
        System.out.println("Os prisioneiros são iguais (antes de alterar a referência)? " + twitch.equals(bubba));

        // Definindo a variável de referência de bubba como igual a twitch
        bubba = twitch;

        // Testando a igualdade dos objetos novamente
        System.out.println("Os prisioneiros são iguais (depois de alterar a referência)? " + twitch.equals(bubba));
    }
}

class Prisioneiro {
    private final String nome;
    private final double altura;
    private final String sentenca;

    public Prisioneiro(String nome, double altura, String sentenca) {
        this.nome = nome;
        this.altura = altura;
        this.sentenca = sentenca;
    }

    // Método equals para comparar prisioneiros
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.sentenca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Prisioneiro that = (Prisioneiro) obj;
        return Double.compare(that.altura, altura) == 0 && nome.equals(that.nome) && sentenca.equals(that.sentenca);
    }
}
