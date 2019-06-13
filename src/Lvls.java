import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Lvls {

    //int map[][];
    private int lvl;
    //private int [][] dynamicArray;// = null;

    Lvls(int lvl){
        this.lvl=lvl;
    }

    public int[][] returnLvl(boolean next){

        if (next){
            lvl++;
        }

        int [][] retLvl = null;
        switch (lvl){
            case 1:
                retLvl = level1();
                break;
            case 2:
                retLvl = level2();
                break;
            case 3:
                retLvl = level3();
                break;
            case 4:
                retLvl = level4();
                break;
            case 5:
                retLvl = level5();
                break;
            case 6:
                retLvl = readFromFile("src/maps/fraCryMap1.far5");
                break;
            default:
                retLvl = level1();
                lvl = 1;
                break;
        }
        System.out.println("super INIT "+lvl);
        return retLvl;
    }

    public void getLvl(int level){
        lvl=level;
    }

    private int[][] level1(){
        int [][] map = new int[][]{
                {0,0,0,0,0,0,0,0,0,0,2,0,0},
                {0,0,0,0,0,0,0,0,0,0,2,3,0},
                {2,2,2,2,0,0,2,0,0,0,2,0,0},
                {0,0,2,2,0,2,2,2,0,2,0,0,0},
                {0,0,0,2,0,0,0,2,0,0,0,0,0},
                {0,1,3,4,0,4,0,2,0,0,0,2,2},
                {2,0,0,2,2,2,0,2,2,2,2,2,0},
                {0,0,0,2,0,0,0,2,0,0,0,0,0},
                {0,0,0,0,0,0,2,2,0,0,0,0,0},
                {0,0,0,0,0,2,0,2,0,0,0,0,0},
                {0,0,0,2,2,0,0,2,0,0,0,0,0},
                {0,0,0,0,0,0,0,2,0,0,0,0,0},
                {0,0,0,0,0,0,0,2,0,0,0,0,0}
        };
        return map;
    }

    private int[][] level2(){
        int [][] map = new int[][]{
                {0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,2,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,2,3,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,2,2,2,0,0,3,2,2,2,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,2,0,0,3,0,0,3,0,2,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,0,2,0,2,2,2,0,2,0,0,0,0,0,2,2,2,2,2,2},
                {2,0,0,0,2,0,2,2,2,0,2,2,2,2,2,2,2,0,0,4,4,2},
                {2,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,2},
                {2,2,2,2,2,0,2,2,2,2,0,2,1,2,2,2,2,0,0,4,4,2},
                {0,0,0,0,2,0,0,0,0,0,0,2,2,2,0,0,2,2,2,2,2,2},
                {0,0,0,0,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0}
        };
        return map;
    }

    private int[][] level3(){
        int [][] map = new int[][]{
                {2,2,2,2,2,2,2,2,2,2,2,2,0,0},
                {2,4,4,0,0,2,0,0,0,0,0,2,2,2},
                {2,4,4,0,0,2,0,3,0,0,3,0,0,2},
                {2,4,4,0,0,2,3,2,2,2,2,0,0,2},
                {2,4,4,0,0,0,0,1,0,2,2,0,0,2},
                {2,4,4,0,0,2,0,2,0,0,3,0,2,2},
                {2,2,2,2,2,2,0,2,2,3,0,3,0,2},
                {0,0,2,0,3,0,0,3,0,3,0,3,0,2},
                {0,0,2,0,0,0,0,2,0,0,0,0,0,2},
                {0,0,2,2,2,2,2,2,2,2,2,2,2,2}
        };
        return map;
    }

    private int[][] level4(){
        int [][] map = new int[][]{
                {0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,0},
                {0,0,0,0,0,0,0,0,2,0,0,0,0,0,1,2,0},
                {0,0,0,0,0,0,0,0,2,0,3,2,3,0,2,2,0},
                {0,0,0,0,0,0,0,0,2,0,3,0,0,3,2,0,0},
                {0,0,0,0,0,0,0,0,2,2,3,0,3,0,2,0,0},
                {2,2,2,2,2,2,2,2,2,0,3,0,2,0,2,2,2},
                {2,4,4,4,4,0,0,2,2,0,3,0,0,3,0,0,2},
                {2,2,4,4,4,0,0,0,0,3,0,0,3,0,0,0,2},
                {2,4,4,4,4,0,0,2,2,2,2,2,2,2,2,2,2},
                {2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0}
        };
        return map;
    }

    private int[][] level5(){
        int [][] map = new int[][]{
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,4,4,4,4,2},
                {0,0,0,2,2,2,2,2,2,2,2,2,2,2,2,0,0,4,4,4,4,2},
                {0,0,0,2,0,0,0,0,2,0,0,3,0,3,0,0,0,4,4,4,4,2},
                {0,0,0,2,0,3,3,3,2,3,0,0,3,0,2,0,0,4,4,4,4,2},
                {0,0,0,2,0,0,3,0,0,0,0,0,3,0,2,0,0,4,4,4,4,2},
                {0,0,0,2,0,3,3,0,2,3,0,3,0,3,2,2,2,2,2,2,2,2},
                {2,2,2,2,0,0,3,0,2,0,0,0,0,0,2,0,0,0,0,0,0,0},
                {2,0,0,0,2,0,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0},
                {2,0,0,0,0,3,0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,0,3,3,2,3,3,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,0,0,0,2,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };
        return map;
    }

    private int [][] readFromFile(String nameFile){
        String outText = "";
        File filename = new File(nameFile);
        FileInputStream in = null;
        int row = 1;
        int countColumn = 0;
        int countRow = 0;
        int outTextCount=0;
            try{ // read file
                in = new FileInputStream(filename);
                int c;
                while ((c = in.read()) != -1){
                    char symbol = (char) c;
                    if ('0' <= symbol && symbol <= '9' || symbol == '\n') {
                        outText = outText + symbol;
                        if (symbol == '\n'){
                            row++; // column for initalize 1 way array dynamicArray
                        }
                    }
                }
                //System.out.println(row);
                in.close();
            }catch (IOException e){
                System.out.println("Error load Map File");
            }

        int [][] dynamicArray = new int [row][];

        for (int a=0;a<outText.length();a++){
            char symbol = outText.charAt(a);
            if (symbol == '\n'){
                dynamicArray[countRow] = new int [countColumn];
                //System.out.println("Row - "+countRow+", Column - "+countColumn);
                countRow++;
                countColumn=0;
            }else{
                countColumn++;
            }
            if (a==outText.length()-1){
                dynamicArray[countRow] = new int [countColumn];
                //System.out.println("Row - "+countRow+", Column - "+countColumn);
            }
        }

        for (int i = 0; i < dynamicArray.length;i++){
            for (int j = 0;j<dynamicArray[i].length;j++){
                char symbol = outText.charAt(outTextCount);
                if (symbol != '\n'){
                    dynamicArray[i][j]=Integer.parseInt("" + symbol);
                }
                outTextCount++;
            }
            outTextCount++;
        }

        //printArray(dynamicArray);
            return dynamicArray;
    }

    private void printArray(int [][] value){
        for (int i = 0; i < value.length;i++){
            for (int j = 0;j<value[i].length;j++){
                System.out.print(value[i][j]+" ");
            }
            System.out.println();
        }
    }

}