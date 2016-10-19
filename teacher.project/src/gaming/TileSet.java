package gaming;

public class TileSet {

    int numberOfColumns;
    int numberOfRows;
    Tile[][] tileArray;

    public TileSet(int numberOfColumns, int numberOfRows) {

        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;

        tileArray = new Tile[numberOfColumns][numberOfRows];

        //Fill tileset with "normal" tiles
        for (int i = 0; i < tileArray.length; i++) {
            for (int j = 0; j < tileArray[0].length; j++) {
                tileArray[i][j] = Tile.Normal;
            }
        }
    }

    public void setRandomReward() {
        int columnNumber;
        int rowNumber;
        
        columnNumber = -1;
        rowNumber = -1;

        boolean undecided;
        undecided = true;

        while (undecided) {
            columnNumber = (int) (Math.random() * (this.numberOfColumns - 1) + 1);
            rowNumber = (int) (Math.random() * (this.numberOfRows - 1) + 1);
            System.out.println(columnNumber + " " + rowNumber);
            if (this.isObstacle(columnNumber, rowNumber) == false
                    && this.isBody(columnNumber, rowNumber) == false) {
                undecided = false;
            } else {
                undecided = true;
            }
        }
        
        this.setReward(columnNumber, rowNumber);
        
    }

    public void setObstacle(int columnNumber, int rowNumber) {
        tileArray[columnNumber][rowNumber] = Tile.Obstacle;
    }

    public boolean isObstacle(int columnNumber, int rowNumber) {
        return tileArray[columnNumber][rowNumber] == Tile.Obstacle;
    }

    public void setReward(int columnNumber, int rowNumber) {
        tileArray[columnNumber][rowNumber] = Tile.Reward;
    }

    public boolean isReward(int columnNumber, int rowNumber) {
        return tileArray[columnNumber][rowNumber] == Tile.Reward;
    }

    public void setBody(int columnNumber, int rowNumber) {
        tileArray[columnNumber][rowNumber] = Tile.Body;
    }

    public boolean isBody(int columnNumber, int rowNumber) {
        return tileArray[columnNumber][rowNumber] == Tile.Body;
    }

    public void setNormal(int columnNumber, int rowNumber) {
        tileArray[columnNumber][rowNumber] = Tile.Normal;
    }

}
