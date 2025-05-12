package tcpServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//서버와 짝을 이루는 양방향 클라이언트 만들어주기
//"192.168.50.16"; //은진 "192.168.50.105";-유진 //"192.168.10.58";=줴  //"192.168.10.64";학준 "192.168.50.103";- 석사오빠 //192.168.50.138 승우옵
public class TCPClient {
    public TCPClient() {
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        String serverIP ="192.168.10.64";
        int serverPort = 5432;
        Socket s = null;
        DataOutputStream dos = null;
        try {
            s = new Socket(serverIP, serverPort);
            dos = new DataOutputStream(s.getOutputStream());
            String sendValue;
            do {
                sendValue = br.readLine();
                dos.writeUTF(sendValue);
            }while(!"quit".equals(sendValue));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(s!=null){
                try{
                    s.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        new TCPClient();
    }
}
