import java.io.*;

public class Util {
    public static void salvarAgenda(Agenda agenda, String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(agenda);
        }
    }

    public static Agenda carregarAgenda(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (Agenda) ois.readObject();
        }
    }
}
