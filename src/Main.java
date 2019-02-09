import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        try {
            Client client = new Client("192.168.1.198", 14449);
            client.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
