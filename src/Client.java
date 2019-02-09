import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {

    private String host;
    private int port;
    private SocketChannel x;

    public Client(String host, int port) throws IOException {

        this.host = host;
        this.port = port;
        this.x = SocketChannel.open(new InetSocketAddress(host,port));
    }

    public void start() {
        Thread receiver = new Thread(new ReceiverThread(x));
        receiver.start();

        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                String string = "Florian: " + sc.nextLine();
                ByteBuffer buffer = ByteBuffer.wrap(string.getBytes());
                x.write(buffer);

            } catch (IOException e) {
                System.out.println("ceva nu e bine: ");
                e.printStackTrace();
            }
        }

    }

    public SocketChannel getX() {
        return x;
    }
}
