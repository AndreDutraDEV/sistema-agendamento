import java.io.*;

public class Util {
    public static void salvarDados(Dados dados, String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(dados);
            System.out.println("\n Dados salvos com sucesso! \n");
        }
    }

    public static Dados carregarDados(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            System.out.println("\n Dados carregados com sucesso! \n");
            return (Dados) ois.readObject();
        }
    }
}
