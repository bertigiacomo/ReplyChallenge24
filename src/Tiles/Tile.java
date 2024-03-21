package Tiles;

import java.util.ArrayList;

public class Tile {

    int objectID;
    String tileID;
    int tileCost;
    int allowedUses;

    ArrayList<ComplexDirection> allowedDirections;

    public Tile() {
    }

    public Tile(String tileID, int tileCost, int allowedUses) {
        this.tileID = tileID;
        this.tileCost = tileCost;
        this.allowedUses = allowedUses;
        this.allowedDirections = new ArrayList<ComplexDirection>();
        setComplexType();
    }

    public String getTileID() {
        return tileID;
    }

    public void setTileID(String tileID) {
        this.tileID = tileID;
    }

    public int getTileCost() {
        return tileCost;
    }

    public void setTileCost(int tileCost) {
        this.tileCost = tileCost;
    }

    public ArrayList<ComplexDirection> getAllowedDirections() {
        return allowedDirections;
    }

    public void setAllowedDirections(ArrayList<ComplexDirection> allowedDirections) {
        this.allowedDirections = allowedDirections;
    }

    public int getAllowedUses() {
        return allowedUses;
    }

    public void setAllowedUses(int allowedUses) {
        this.allowedUses = allowedUses;
    }

    public void setComplexType(){

        switch (this.tileID){

            case "3":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Right)); //Left to Right
                break;

            case "5":

                allowedDirections.add(new ComplexDirection(Direction.Down, Direction.Right)); //Down to Right
                break;

            case "6":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Down)); //Left to Down
                break;

            case "7":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Right)); //Left to Right
                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Down)); //Left to Down
                allowedDirections.add(new ComplexDirection(Direction.Down, Direction.Right)); //Down to Right
                break;

            case "9":

                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Right)); //Up to Right
                break;

            case "96":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Down)); //Left to Down
                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Right)); //Up to Right
                break;

            case "A":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Up)); //Left to Up
                break;

            case "A5":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Up)); //Left to Up
                allowedDirections.add(new ComplexDirection(Direction.Down, Direction.Right)); //Left to Right
                break;

            case "B":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Right)); //Left to Right
                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Up)); //Left to Up
                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Right)); //Up to Right
                break;

            case "C":

                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Down)); //Up to Down
                break;

            case "C3":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Right)); //Left to Right
                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Down)); //Up to Down
                break;

            case "D":

                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Down)); //Up to Down
                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Right)); //Up to Right
                allowedDirections.add(new ComplexDirection(Direction.Down, Direction.Right)); //Down to Right
                break;

            case "E":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Up)); //Left to Up
                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Down)); //Left to Down
                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Down)); //Up to Down
                break;

            case "F":

                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Right)); //Left to Right
                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Down)); //Left to Down
                allowedDirections.add(new ComplexDirection(Direction.Left, Direction.Up)); //Left to Up
                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Down)); //Up to Down
                allowedDirections.add(new ComplexDirection(Direction.Down, Direction.Right)); //Down to Right
                allowedDirections.add(new ComplexDirection(Direction.Up, Direction.Right)); //Up to Right
                break;
        }






    }

    public boolean checkDirection(ComplexDirection dirToCheck){

        int nTilesStored = allowedDirections.size();
        boolean validFound = false;

        for(int i = 0; i < nTilesStored && !validFound; i++){

            //Check if the given InOut direction is contained in the tile
            ComplexDirection currDir = allowedDirections.get(i);
            if(currDir.d1 == dirToCheck.d1){
                if(currDir.d2 == dirToCheck.d2){

                    //Allowed in default direction
                    validFound = true;


                }
            } else if (currDir.d1 == dirToCheck.d2){
                if(currDir.d2 == dirToCheck.d1){

                    //Allowed in opposite direction (valid anyway)
                    validFound = true;

                }
            }



        }


        return validFound; //auto exit if true


    }


    public void useTile(ComplexDirection dir){

        if(checkDirection(dir) && allowedUses >= 0){
            allowedUses--;
        }
    }
}
