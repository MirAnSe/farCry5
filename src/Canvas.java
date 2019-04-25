import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;


public class Canvas extends JPanel{
    private Model model;

    private Image imageHero;
    private Image imageWall;
    private Image imageHeroDawn, imageHeroUp, imageHeroLeft, imageHeroRight, imageBox;

    Canvas(Model model){
        this.model=model;
        File fileNameHero = new File("src/image/HeroV2.png");
        File fileNameHeroDawn = new File("src/image/HeroDown.png");
        File fileNameHeroUp = new File("src/image/HeroUp.png");
        File fileNameHeroLeft = new File("src/image/HeroLeft.png");
        File fileNameHeroRight = new File("src/image/HeroRight.png");
        File fileNameWall = new File("src/image/Wall.png");
        File filenameBox = new File("src/image/Box.png");
        setBackground(Color.white);
        setOpaque(true);

        try{
            imageHero = ImageIO.read(fileNameHero);
            imageHeroDawn = ImageIO.read(fileNameHeroDawn);
            imageHeroUp = ImageIO.read(fileNameHeroUp);
            imageHeroLeft = ImageIO.read(fileNameHeroLeft);
            imageHeroRight = ImageIO.read(fileNameHeroRight);
            imageWall = ImageIO.read(fileNameWall);
            imageBox = ImageIO.read(filenameBox);
        }catch (IOException e) {
            System.out.println("Error load image file");
        }
    }

    public void paint(Graphics pen){
        super.paint(pen);

        int start=5;
        int x = start;
        int y = start;
        int width = 50;
        int height = 50;
        int offset = 0;

        for (int i=0;i<model.desktop.length;i++){
            for(int j=0;j<model.desktop[i].length;j++){
                if (model.desktop[i][j]==1){
                    /*pen.setColor(Color.blue);
                    pen.fillRect(x,y,width,height);
                    pen.setColor(Color.black);
                    pen.drawRect(x,y,width,height);*/

                    if (model.directionImage==1){
                        pen.drawImage(imageHeroDawn,x,y,null);
                    }else if(model.directionImage==0){
                        pen.drawImage(imageHero,x,y,null);
                    }else if(model.directionImage==2){
                        pen.drawImage(imageHeroUp,x,y,null);
                    }else if(model.directionImage==3){
                        pen.drawImage(imageHeroLeft,x,y,null);
                    }else if(model.directionImage==4){
                        pen.drawImage(imageHeroRight,x,y,null);
                    }

                }else if(model.desktop[i][j]==2){
                    /*pen.setColor(Color.red);
                    pen.fillRect(x,y,width,height);
                    pen.setColor(Color.black);
                    pen.drawRect(x,y,width,height);
                    */
                    pen.drawImage(imageWall,x,y,null);
                }else if (model.desktop[i][j]==3){
                    pen.drawImage(imageBox,x,y,null);
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
