import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.WindowConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;


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
        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuAction = new JMenu("Action");
        JMenu menuLevels = new JMenu("Levels");

        //frame.setSize(widthWindow,770);
        //frame.setLocation(200,0);
        setSize();

        JMenuItem moveBack = new JMenuItem("Move Back   B");
        moveBack.addActionListener(controller);
        moveBack.setActionCommand("MB");

        JMenuItem reloadLevel = new JMenuItem("Reload lvl     R");
        reloadLevel.addActionListener(controller);
        reloadLevel.setActionCommand("RL");

        JMenuItem Level1 = new JMenuItem("Level 1 (own)");
        Level1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
        Level1.addActionListener(controller);
        Level1.setActionCommand("L1");

        JMenuItem Level2 = new JMenuItem("Level 2");
        Level2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
        Level2.addActionListener(controller);
        Level2.setActionCommand("L2");

        JMenuItem Level3 = new JMenuItem("Level 3");
        Level3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
        Level3.addActionListener(controller);
        Level3.setActionCommand("L3");

        JMenuItem Level4 = new JMenuItem("Level 4");
        Level4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK));
        Level4.addActionListener(controller);
        Level4.setActionCommand("L4");

        JMenuItem Level5 = new JMenuItem("Level 5");
        Level5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.CTRL_MASK));
        Level5.addActionListener(controller);
        Level5.setActionCommand("L5");

        JMenuItem Level6 = new JMenuItem("Level 6 from file");
        Level6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.CTRL_MASK));
        Level6.addActionListener(controller);
        Level6.setActionCommand("Lfile");

        JMenuItem Level7 = new JMenuItem("Level from Network");
        Level7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.CTRL_MASK));
        Level7.addActionListener(controller);
        Level7.setActionCommand("Lnetwork");


        menuLevels.add(Level1);
        menuLevels.add(Level2);
        menuLevels.add(Level3);
        menuLevels.add(Level4);
        menuLevels.add(Level5);
        menuLevels.add(Level6);
        menuLevels.add(Level7);

        menuAction.add(moveBack);
        menuAction.add(reloadLevel);

        jMenuBar.add(menuAction);
        jMenuBar.add(menuLevels);


        frame.setJMenuBar(jMenuBar);
        frame.add("Center",canvas);
        frame.setLocationRelativeTo(null);
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