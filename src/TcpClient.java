import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.io.IOException;


public class TcpClient {

    private PrintWriter out;

    TcpClient(){

    }

    public void startTcpSession(String ID){
        try(
                Socket echoSocket = new Socket("linux.kg",4444);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ){


            out.println("get");
            out.println(ID);

            echoSocket.close();
            /*String userInput;
            //viewer.setText(in.readLine());
            while((userInput = stdIn.readLine()) != null){
                out.println(userInput);
                //viewer.setText(in.readLine());
                System.out.println(in.readLine());
            }
            */
        }catch (UnknownHostException uhe){
            System.out.println("UHE "+uhe);
        }catch (IOException ioe){
            System.out.println("ioe "+ioe);
        }finally {

        }
    }

}
