import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class Viewer {

    private int widthWindow = 680;
    private Canvas canvas;

    Viewer(){
        Controller controller = new Controller(this);

        Model model = controller.getModel();
        canvas = new Canvas(model,controller,widthWindow);

        JFrame frame = new JFrame("FarCry V2.6");
        frame.setSize(widthWindow,770);
        frame.setLocation(200,0);
        frame.add("Center",canvas);
        frame.setVisible(true);
        frame.addKeyListener(controller);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void update(){
       canvas.repaint();
    }
}