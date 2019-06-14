import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller implements KeyListener, ActionListener  {
    private Model model;
    private TcpClient tcpClient;
    int direction=0;
    Controller(Viewer viewer){
        model = new Model(viewer);
        tcpClient = new TcpClient();
    }

    public Model getModel(){
        return model;
    }

    public void keyTyped(KeyEvent event){

    }

    public void keyPressed(KeyEvent event){
        int keyCode = event.getKeyCode();
        switch (keyCode){
            case 38:
                direction = 1;
                break;
            case 87:
                direction = 1;
                break;
            case 39:
                direction = 2;
                break;
            case 68:
                direction = 2;
                break;
            case 40:
                direction = 3;
                break;
            case 83:
                direction = 3;
                break;
            case 37:
                direction = 4;
                break;
            case 65:
                direction = 4;
            break;
            case 66:
                direction = 5;
                break;
            case 82:
                model.arrayInit();
                direction = 0;
                break;
            default:
                return;
        }
        //model.backup=model.desktop;
        //System.out.println(keyCode);
        model.move(direction);
    }

    public void keyReleased(KeyEvent event){

    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if(command.equals("MB")){
            model.move(5);
        }else if(command.equals("RL")){
            model.arrayInit();
            model.move(0);
        }else if(command.equals("L1")){
            model.initLvlFromMenu(1);
        }else if(command.equals("L2")){
            model.initLvlFromMenu(2);
        }else if(command.equals("L3")){
            model.initLvlFromMenu(3);
        }else if(command.equals("L4")){
            model.initLvlFromMenu(4);
        }else if(command.equals("L5")){
            model.initLvlFromMenu(5);
        }else if(command.equals("Lfile")){
            model.initLvlFromMenu(6);
        }else if(command.equals("Lnetwork")){
            JDialog networkFram = new JDialog(new JFrame("Network"));

            JLabel jLabel1 = new JLabel("Для загрузки карты с сервера , перейдите");
            jLabel1.setBounds(10,10,300,20);

            JLabel jLabel2 = new JLabel("по ссылке sokoban.linux.kg, и вставьте");
            jLabel2.setBounds(10,30,300,20);

            JLabel jLabel3 = new JLabel("ID карты, в поле ниже.");
            jLabel3.setBounds(10,50,300,20);

            JTextField  textFiled = new JTextField();
            textFiled.setBounds(10,80,50,20);

            JButton downloadButton = new JButton("Download");
            downloadButton.setBounds(65,80,100,20);
            downloadButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tcpClient.startTcpSession(textFiled.getText());
                }
            });

            JButton close = new JButton("Close");
            close.setBounds(70,120,150,30);
            close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    networkFram.dispose();
                }
            });

            networkFram.setLayout(null);
            networkFram.add(jLabel1);
            networkFram.add(jLabel2);
            networkFram.add(jLabel3);
            networkFram.add(textFiled);
            networkFram.add(downloadButton);
            networkFram.add(close);

            networkFram.setSize(300,200);

            networkFram.setModal(true);
            networkFram.setLocationRelativeTo(null);
            networkFram.setResizable(false);
            networkFram.setVisible(true);
        }
    }

}
