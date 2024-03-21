package Map;
import Points.*;
import Tiles.*;

import java.util.ArrayList;

public class Map {

    Object aMap[][];

    int W, H; //Map size

    int Tl; //Number of tiles available to player

    public Map(int W, int H, int Tl){
        aMap = new AbstractPoint[W][H];
        this.Tl = Tl;
        generateEmpty();
    }

    public void generateEmpty(){
        for(int i = 0; i < W; i++){
            for(int j = 0; j < H; i++){
                aMap[i][j] = new Tile("0", 0, 0);
            }
        }
    }

    public void insertPoint(AbstractPoint p1){
        this.aMap[p1.getX()][p1.getY()] = p1;
    }

    public void insertTile(Tile t1, int x, int y){

        this.aMap[x][y] = t1;
    }

    public SilverPoint finNearestSilver(GoldenPoint G1, GoldenPoint G2, SilverPoint Silver[], int nSilver){

        ArrayList<SilverPoint> dynamicVector = new ArrayList<>();


        for(int i =0; i < nSilver; i++){
            if (Silver[i].getX() >= G1.getX() && Silver[i].getX() <= G2.getX()
                && Silver[i].getY() >= G1.getY() && Silver[i].getY() <= G2.getY() && !Silver[i].isTaken()) {
                dynamicVector.add(Silver[i]);
            }
        }

        SilverPoint min = dynamicVector.get(0);

        for(int i = 1; i < dynamicVector.size(); i++){
            if((dynamicVector.get(i).getX() - G1.getX() + dynamicVector.get(i).getY() - G1.getY()) <
                    (min.getX() - G1.getX() + min.getY() - G1.getY())){
                min = dynamicVector.get(i);
            }
        }

        return min;
    }

}
