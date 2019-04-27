import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Controller implements KeyListener {
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
        //System.out.println(keyCode);


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
            case 8:
                direction = 5;
                break;
            case 82:
                model.arrayInit();
                direction = 0;
                break;
        }
        //model.backup=model.desktop;
        //System.out.println(keyCode);
        model.move(direction);
    }

    public void keyReleased(KeyEvent event){

    }

}
