
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) throws Exception {
        String screenName = args[0];
        String host       = args[1];
        int port          = 4444;

        // connect to server and open up IO streams
        Socket socket = new Socket(host, port);
        In     stdin  = new In();
        In     in     = new In(socket);
        Out    out    = new Out(socket);
        System.err.println("Connected to " + host + " on port " + port);

        // read in a line from stdin, send to server, and print back reply
        while (!stdin.hasNextLine()) {

            // read line of client
            String s = stdin.readLine();

            // send over socket to server
            out.println("[" + screenName + "]: " + s);

            // get reply from server and print it out
            StdOut.println(in.readLine());
        }

        // close IO streams, then socket
        System.err.println("Closing connection to " + host);
        out.close();
        in.close();
        socket.close();
    }
}
