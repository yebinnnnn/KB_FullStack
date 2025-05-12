package tcpServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private int port = 5432;
    String clientIP;
    public TCPServer() {
        ServerSocket ss=null;
        Socket s=null;
        try {
            ss = new ServerSocket(port);
            System.out.println("클라이언트의 접속을 기다립니다");
            s=ss.accept();
            DataInputStream dis=null;
            dis=new DataInputStream(s.getInputStream());
            String readValue;
            clientIP=s.getInetAddress().getHostAddress();
            while(!"quit".equals(readValue=dis.readUTF())){
                System.out.println(clientIP+"클라이언트가 보내준 데이터" + readValue);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(s!=null){
                try {
                    s.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        new TCPServer();
    }
}
