import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller implements KeyListener, ActionListener  {
    private Model model;
    int direction=0;
    Controller(Viewer viewer){
        model = new Model(viewer);
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


            networkFram.setSize(300,200);
            networkFram.setLayout(null);
            networkFram.setModal(true);
            networkFram.setResizable(false);
            networkFram.setVisible(true);
        }
    }

}
