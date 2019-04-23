public class Model {

    private Viewer viewer;

    int [][] desktop;
    int indexX;
    int indexY;

    Model(Viewer viewer){
        this.viewer = viewer;

        desktop = new int[10][10];

        indexX = 1;
        indexY = 2;

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
        if (indexX>0){
            desktop[indexX][indexY]=0;
            indexX--;
            desktop[indexX][indexY]=1;
        }
    }

    private void moveRight(){
        if (indexY<(desktop[indexX].length-1)){
            desktop[indexX][indexY]=0;
            indexY++;
            desktop[indexX][indexY]=1;
        }
    }

    private void moveDown(){
        if (indexX<(desktop[indexY].length-1)){
            desktop[indexX][indexY]=0;
            indexX++;
            desktop[indexX][indexY]=1;
        }
    }

    private void moveLeft(){
        if (indexY>0){
            desktop[indexX][indexY]=0;
            indexY--;
            desktop[indexX][indexY]=1;
        }
    }

    private void initArray(int x,int y){
        desktop[x][y]=1;
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
