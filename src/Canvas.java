import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Canvas extends JPanel{
    private Model model;
    Canvas(Model model){
        this.model=model;
        setBackground(Color.gray);
        setOpaque(true);
    }

    public void paint(Graphics pen){
        super.paint(pen);

        int start=50;
        int x = start;
        int y = start;
        int width = 50;
        int height = 50;
        int offset = 5;

        for (int i=0;i<model.desktop.length;i++){
            for(int j=0;j<model.desktop[i].length;j++){
                if (model.desktop[i][j]==1){
                    pen.setColor(Color.yellow);
                    pen.fillRect(x,y,width,height);
                    pen.setColor(Color.black);
                    pen.drawRect(x,y,width,height);
                }else{
                    pen.setColor(Color.white);
                    pen.drawRect(x,y,width,height);
                }
                x=x+width+offset;
            }
            x=start;
            y=y+height+offset;
        }


    }
}
