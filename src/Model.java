public class Model {

    private Viewer viewer;
    private Lvls lvls = new Lvls(5);

    private Reset buttonReset;

    private boolean firstStep=false;
    int [][] desktop;
    int [][] backup;
    int indexX,indexY,indexXbackup,indexYbackup;
    //private int indexXstart,indexYstart;
    boolean stopProgramm = true;

    //int directionImage=0;

    Model(Viewer viewer){
        this.viewer = viewer;

        buttonReset = new Reset(0,0,150,100);

        initArray(false);
    }

    public void arrayInit(){
        initArray(false);
    }

    public void move(int direction){
        if (direction!=5) {
            if (stopProgramm) {
                switch (direction) {
                    case 1:
                        move(indexX - 1, indexX - 2, indexY, indexY);
                        break;
                    case 2:
                        move(indexX, indexX, indexY + 1, indexY + 2);
                        break;
                    case 3:
                        move(indexX + 1, indexX + 2, indexY, indexY);
                        break;
                    case 4:
                        move(indexX, indexX, indexY - 1, indexY - 2);
                        break;
                }
                //printArray();
                viewer.update();
            }
        }else if(direction==5){
            if (firstStep){
                backup((byte)0);
                indexX=indexXbackup;
                indexY=indexYbackup;
                stopProgramm=true;
                viewer.update();
            }

        }else {
            //viewer.update();
        }
    }

    private void move(int xx, int xx1, int yy, int yy1){
        //move BOX
      if (yy1 < desktop[indexX].length && xx1 < desktop.length && xx1 > -1 && yy1 > -1 && (desktop[xx][yy] ==3|| desktop[xx][yy]==5)){

            if(desktop[xx1][yy1]==0 && desktop[xx][yy]==3){
                backup();
                desktop[xx][yy]=0;
                desktop[xx1][yy1]=3;
            }else if(desktop[xx1][yy1]==4){
                backup();
                if (desktop[xx][yy]==5){
                    desktop[xx][yy]=4;
                }else if(desktop[xx][yy]==3){
                    desktop[xx][yy]=0;
                }
                desktop[xx1][yy1]=5;
            }else if (desktop[xx1][yy1]==0 && desktop[xx][yy]==5){
                backup();
                desktop[xx][yy]=4;
                desktop[xx1][yy1]=3;
            }
        }

            //move Persone
        if (yy < desktop[indexX].length && xx < desktop.length && xx > -1 && yy > -1){

            if (desktop[xx][yy]==0){
                if (desktop[indexX][indexY]==1){
                    desktop[indexX][indexY]=0;
                }else if(desktop[indexX][indexY]==6){
                    desktop[indexX][indexY]=4;
                }
                desktop[xx][yy]=1;
                indexY=yy;
                indexX=xx;
            } else if(desktop[xx][yy]==4){
                //desktop[indexX][indexY]=0;
                if (desktop[indexX][indexY]==6){
                    desktop[indexX][indexY]=4;
                }else if(desktop[indexX][indexY]==1){
                    desktop[indexX][indexY]=0;
                }
                desktop[xx][yy]=6;
                indexY=yy;
                indexX=xx;
            }
        }
        firstStep=true;
    }

    private void backup(){
        indexXbackup = indexX;
        indexYbackup = indexY;
        backup((byte)1);
    }

    private void initArray(boolean next){
        desktop=lvls.returnLvl(next);
        backup = new int[desktop.length][];

        for (int i=0;i<desktop.length;i++){
            backup[i] = new int[desktop[i].length];
        }

        auca: for(int i=0;i < desktop.length;i++){
            for(int j=0;j<desktop[i].length;j++){
                if (desktop[i][j]==1){
                    indexX=i;
                    indexY=j;

                    break auca;
                }
            }
        }
        firstStep=false;
    }

    public void initLvlFromMenu(int level){
        lvls.getLvl(level);
        initArray(false);
        viewer.setSize();
        viewer.update();
    }

    public void nextLvl(boolean next){
        //initLvl++;
        initArray(next);
        viewer.setSize();
        viewer.update();
    }

    private void backup(byte action){
        if (action==1) {
            for (int i = 0; i < backup.length; i++) {
                for (int j = 0; j < backup[i].length; j++) {
                    backup[i][j]=desktop[i][j];
                }
            }
        }else{
            for (int i = 0; i < backup.length; i++) {
                for (int j = 0; j < backup[i].length; j++) {
                    desktop[i][j]=backup[i][j];
                }
            }
        }
    }

    private void printArray(){
        for(int i=0; i< backup.length;i++){
            for(int j=0;j<backup[i].length;j++){
                System.out.print(backup[i][j]+" ");
            }
            System.out.println();
        }
        //System.out.println();
       // System.out.println("X - "+indexX+"    Y - "+indexY+"     wid"+desktop[0].length+" Hei"+desktop.length);
    }

    public Reset getMyButton(){
        return buttonReset;
    }
}
