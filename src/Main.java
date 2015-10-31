import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Main {

    private static final String IP = "192.168.56.101";
    private static final Integer PORT = 10000;

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(IP, PORT));
        System.out.println("Connected!");

        ProtocolService protocolService = new ProtocolService(socketChannel);
        int ID = protocolService.getID();
        int CURRENT_MOVE = protocolService.getNextInt();
        int AGGRESSIVE_MODE = protocolService.getNextInt();
        int MAX_MOVE = protocolService.getNextInt();
        int N = protocolService.getNextInt();
        int M = protocolService.getNextInt();

        System.out.println("ID = " + ID);
        System.out.println("CURRENT_MOVE = " + CURRENT_MOVE);
        System.out.println("AGGRESSIVE_MODE = " + AGGRESSIVE_MODE);
        System.out.println("MAX_MOVE = " + MAX_MOVE);
        System.out.println("N = " + N);
        System.out.println("M = " + M);
    }
}
