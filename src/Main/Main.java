package Main;

import Map.*;
import Points.*;
import Tiles.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("AAAA");
        // Scanner scanner = new Scanner(System.in);

        Map map;

        //Legend of the Output (not the actual one)
        //Provided variables for golden points:
        int goldID;
        int goldX, goldY;
        GoldenPoint gPoint; //<- x, y, ID

        //Provided variables for silver points;
        int silverID;
        int silverX, silverY;
        int points;
        SilverPoint sPoint; //<- x, y, value

        //Provided variables for tiles:
        String ID;
        int cost, nTilesAvailable;
        Tile tileType; //<- direction, ID, complexDirection



        //Start reading file
        try {
            File myObj = new File("trailer.txt"/* scanner.nextLine() */);
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine();

            //Generic array of three numbers
            String vars[] = data.split(" ");
            
            // System.out.println(Integer.parseInt(vars[0]));

            int mapX = Integer.parseInt(vars[0]);
            int mapY = Integer.parseInt(vars[1]);
            int nGoldenTile = Integer.parseInt(vars[2]);
            int nSilverTile = Integer.parseInt(vars[3]);
            int nTileType = Integer.parseInt(vars[4]);

            System.out.println("===== FILE HEADER =====");
            System.out.println("Map size: " + mapX + ", " + mapY);
            System.out.println("Golden tile number: " + nGoldenTile);
            System.out.println("Silver tile number: " + nSilverTile);
            System.out.println("Number of tiles: " + nTileType);
            System.out.println("=======================");

            map = new Map(mapX, mapY, nTileType);

            AbstractPoint golden[] = new GoldenPoint[nGoldenTile];
            AbstractPoint silver[] = new SilverPoint[nSilverTile];
            Tile tile[] = new Tile[nTileType];

            for(int i = 0; i < nGoldenTile; i++){ //Insert the golden points
                data = myReader.nextLine();
                vars = data.split(" "); // 0 <- X, 1 <- Y
                
                //Read values
                System.out.println("Added: new GoldenPoint(" + vars[0] + ", " + vars[1] +  ")");
                golden[i] = new GoldenPoint(i, Integer.parseInt(vars[0]), Integer.parseInt(vars[1]));

                map.insertPoint(golden[i]);

            }

            for(int i = 0; i < nSilverTile; i++){ //Insert the silver points
                data = myReader.nextLine();
                vars = data.split(" "); // 0 <- X, 1 <- Y, 2 <- cost

                //Read values
                System.out.println("Added: new SilverPoint(" + vars[0] + ", " + vars[1] + ", " + vars[2] + ")");
                silver[i] = new SilverPoint(i, Integer.parseInt(vars[0]), Integer.parseInt(vars[1]), Integer.parseInt(vars[2]));

                map.insertPoint(silver[i]);

            }

            for(int i = 0; i < nTileType; i++){
                data = myReader.nextLine();
                vars = data.split(" "); // 0 <- TileID, 1 <- TileCost, 2 <- AvailableTiles

                //The tiles will be added to the map once the pathfinding method is running
                System.out.println("Added: new Tile(" + vars[0] + ", " + vars[1] + ", " + vars[2] + ")");
                tile[i] = new Tile(vars[0], Integer.parseInt(vars[1]), Integer.parseInt(vars[2]));

            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //End reading file



        







    }
}