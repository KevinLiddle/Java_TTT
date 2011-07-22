public class Board {

  int dimension;
  int[][] cellValues;

  public Board() {
    dimension = 3;
    cellValues = new int[dimension][dimension];
  }

  public Board(int dim){
    dimension = dim;
    cellValues = new int[dimension][dimension];
  }

  public int cellValueAt(int[] cell){
    return cellValues[cell[0]][cell[1]];
  }

  public void setCellValue(int[] cell, int value) {
    cellValues[cell[0]][cell[1]] = value;
  }

}
