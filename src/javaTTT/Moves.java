package javaTTT;

public class Moves {

  Board board;

  public Moves() {
    board = new Board();
  }

  public void makeMove(Player player) {
    int[] move = { -1, -1 };
    while( invalid(move) ){
      move = player.move();
    }
    board.setCellValue( move, player.playerValue() );
  }

  private boolean invalid(int[] move) {
    return (move.length < 2 || move[0] > board.dimension - 1 ||
            move[0] < 0     || move[1] > board.dimension - 1 ||
            move[1] < 0     || board.cellValueAt(move) != 0);
  }

}
