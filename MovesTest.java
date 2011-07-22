import junit.framework.TestCase;
import java.io.*;

public class MovesTest extends TestCase {

  static Moves moves;
  static HumanPlayer player1;
  static HumanPlayer player2;

  public void setUp() {
    moves = new Moves();
    player1 = new HumanPlayer( 1, "Marcellus Wallace");
    player2 = new HumanPlayer( -1, "Butch");
  }

  public void testBoardCellsSetOnMove() {
    int expectedCellValue = -1;
    int[] cell = {2,1};
    fakeMove(player2);

    assertEquals( -1, moves.board.cellValueAt( cell ) );
  }

  private static void fakeMove(Player player) {
    HumanPlayer humanPlayer = (HumanPlayer) player;
    String[] input = {"2\n1", "3, 0", "-1,2", "1\n1"};
    InputStream stream = new ByteArrayInputStream(input[0].getBytes());
    int[] move = humanPlayer.promptForMove(stream);
    int i = 1;
    while( move.length < 2 || move[0] > moves.board.dimension - 1 || move[0] < 0 || move[1] > moves.board.dimension - 1 || move[1] < 0 || moves.board.cellValueAt(move) != 0 ){
      stream = new ByteArrayInputStream(input[i].getBytes());
      move = humanPlayer.promptForMove(stream);
      i++;
    }
    moves.board.setCellValue( move, humanPlayer.playerValue());
  }

  public void testMoveDoesNotAcceptInvalidMoves() {
    int[] move1 = {2,1};
    int[] move2 = {1,1};
    fakeMove(player1);
    fakeMove(player2);

    assertEquals( 1, moves.board.cellValueAt( move1 ) );
    assertEquals( -1, moves.board.cellValueAt( move2 ) );
  }

}
