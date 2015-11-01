import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Main {

    private static final String IP = "192.168.56.101";
    private static final Integer PORT = 10000;

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(IP, PORT));
        System.out.println("Connected!");

        ProtocolService protocolService = new ProtocolService(socketChannel);

        protocolService.readID();
        System.out.println("PLAYER_ID = " + Information.PLAYER_ID);

        protocolService.readMessage();
        protocolService.sendMessage(Information.CURRENT_MOVE, Command.NONE, false);
        protocolService.readMessage();
    }

}
