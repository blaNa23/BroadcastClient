import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ReceiverThread implements Runnable {

    SocketChannel socket;

    ReceiverThread(SocketChannel socket) {
        this.socket = socket;
    }

    @Override
    public void run() {



        while (true) {

            try {
                ByteBuffer buffer = ByteBuffer.allocate(256);
                socket.read(buffer);
                System.out.println(new String(buffer.array()));
            } catch (IOException e) {
                System.out.println("ceva nu e bine: ");
                e.printStackTrace();
            }
        }

    }
}
