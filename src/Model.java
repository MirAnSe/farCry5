public class Model {

    private Viewer viewer;

    int [][] desktop;
    int indexX;
    int indexY;

    int checkX;
    int checkY;

    int checkBox;

    int directionImage=0;

    Model(Viewer viewer){
        this.viewer = viewer;

        desktop = new int[13][13];

        indexX = 0;
        indexY = 0;

        initArray(indexX,indexY);

    }

    public void move(String direction){
        if (direction.equals("Up")){
            moveUp();
        }else if(direction.equals("Right")){
            moveRight();
        }else if(direction.equals("Down")){
            moveDown();
        }else if(direction.equals("Left")){
            moveLeft();
        }
        //printArray();
        viewer.update();
    }

    private void moveUp(){
        if (indexX>0 && check((checkX=indexX-1),indexY)){
            desktop[indexX][indexY]=0;
            indexX--;
            desktop[indexX][indexY]=1;
        }
        directionImage = 2;
    }

    private void moveRight(){
        /*if (checkBox(indexX,(checkBox=indexY+1))){
            desktop[indexX][checkBox]=0;
            desktop[indexX][checkBox+1]=3;
        }


        if (indexY<(desktop[indexX].length-1) && check(indexX,checkY=indexY+1)){
            desktop[indexX][indexY]=0;
            indexY++;
            desktop[indexX][indexY]=1;
        }*/

        if (desktop[indexX][indexY + 1] ==3 && indexY+1 < desktop[indexX].length){
            if(desktop[indexX][indexY + 2]==0){
                desktop[indexX][indexY+1]=0;
                desktop[indexX][indexY+2]=3;
            }
        }

        if (desktop[indexX][indexY+1]==0 && indexY+1< desktop[indexX].length){
            desktop[indexX][indexY]=0;
            desktop[indexX][indexY+1]=1;
            indexY++;
        }

        directionImage = 4;
    }

    private void moveDown(){
        if (indexX<(desktop[indexY].length-1) && check((checkX=indexX+1),indexY)){
            desktop[indexX][indexY]=0;
            indexX++;
            desktop[indexX][indexY]=1;
        }
        directionImage = 1;
    }

    private void moveLeft(){
        if (indexY>0 && check(indexX,(checkY=indexY-1))){
            desktop[indexX][indexY]=0;
            indexY--;
            desktop[indexX][indexY]=1;
        }
        directionImage = 3;
    }

    private boolean check(int x2, int y2){
        if (desktop[x2][y2]==2){
            return  false;
        }else{
            return true;
        }
    }

    private boolean checkBox(int x2, int y2){
        if (desktop[x2][y2]==3){
            return  true;
        }else{
            return false;
        }
    }
/*
    private boolean checkWall(int x3, int y3){
        //if (desktop)
    }*/

    private void initArray(int x,int y){
        desktop[x][y]=1;
        desktop[3][3]=2;
        desktop[3][5]=2;
        desktop[3][6]=2;
        desktop[3][7]=2;
        desktop[4][3]=2;
        desktop[5][3]=2;
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
        System.out.println();System.out.println();
    }
}
