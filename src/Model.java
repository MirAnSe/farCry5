public class Model {

    private Viewer viewer;

    int [][] desktop;
    int indexX,indexY;

    //int directionImage=0;

    Model(Viewer viewer){
        this.viewer = viewer;

        desktop = new int[13][13];

        indexX = 0;
        indexY = 0;

        initArray(indexX,indexY);
    }

    public void move(int direction){
        switch (direction){
            case 1:
                move(indexX-1,indexX-2,indexY,indexY);
                break;
            case 2:
                move(indexX,indexX,indexY+1,indexY+2);
                break;
            case 3:
                move(indexX+1,indexX+2,indexY,indexY);
                break;
            case 4:
                move(indexX,indexX,indexY-1,indexY-2);
                break;
        }
        //printArray();
        viewer.update();
    }

    private void move(int xx, int xx1, int yy, int yy1){
      if (yy1 < desktop[indexX].length && xx1 < desktop.length && xx1 > -1 && yy1 > -1 && desktop[xx][yy] ==3){
            if(desktop[xx1][yy1]==0){
                desktop[xx][yy]=0;
                desktop[xx1][yy1]=3;
            }
        }

        if (yy < desktop[indexX].length && xx < desktop.length && xx > -1 && yy > -1 && desktop[xx][yy]==0){
            desktop[indexX][indexY]=0;
            desktop[xx][yy]=1;
            indexY=yy;
            indexX=xx;
        }

        //directionImage = dir;
        //printArray();
        //System.out.println(xx1+" - "+yy1+"   "+xx+" - "+yy);
    }

    private void initArray(int x,int y){
        desktop[x][y]=1;
        desktop[3][3]=2;
        desktop[3][5]=2;
        desktop[3][6]=2;
        desktop[3][7]=2;
        desktop[4][3]=2;
        //desktop[5][3]=2;
        desktop[6][3]=2;
        desktop[6][4]=2;
        desktop[6][5]=2;
        //desktop[6][6]=2;
        desktop[6][7]=2;
        desktop[4][7]=2;
        desktop[5][7]=2;
        desktop[5][1]=3;
        //desktop[0][1]=2;
        //desktop[7][6]=2;
        //printArray();
    }

    private void printArray(){
        for(int i=0; i< desktop.length;i++){
            for(int j=0;j<desktop[i].length;j++){
                System.out.print(desktop[i][j]+" ");
            }
            System.out.println();
        }
        //System.out.println();
       // System.out.println("X - "+indexX+"    Y - "+indexY+"     wid"+desktop[0].length+" Hei"+desktop.length);
    }
}
