import java.io.*;

public class Util {
    public static void salvarDados(Dados dados, String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(dados);
        }
    }

    public static Dados carregarDados(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (Dados) ois.readObject();
        }
    }
}
