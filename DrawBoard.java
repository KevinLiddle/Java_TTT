public class DrawBoard {

  public static void draw(Board board) {
    String drawnBoard = "";
    for(int i = 0; i < board.dimension; i++){
      for(int j = 0; j < board.dimension; j++){
        int[] cell = {i,j};
        drawnBoard += "[" + marker(board.cellValueAt(cell)) + "]";
      }
      drawnBoard += "\n";
    }
    System.out.println(drawnBoard);
  }

  private static String marker(int value) {
    if(value == 1)
      return "X";
    else if(value == -1)
      return "O";
    else
      return " ";
  }
}
