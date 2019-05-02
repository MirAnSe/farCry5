import javax.swing.*;

public class Viewer {

    private int widthWindow = 680;
    private Canvas canvas;
    private JFrame frame;
    private Model model;

    Viewer(){
        Controller controller = new Controller(this);

        model = controller.getModel();
        canvas = new Canvas(model,controller,widthWindow);

        frame = new JFrame("FarCry V3.0");

        //frame.setSize(widthWindow,770);
        //frame.setLocation(200,0);
        setSize();
        frame.add("Center",canvas);

        frame.setVisible(true);
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setSize(){
        frame.setSize(model.desktop[0].length*50+30,model.desktop.length*50+canvas.getLogoHeight());

    }

    public void update(){
       canvas.repaint();
    }
}