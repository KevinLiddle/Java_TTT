import junit.framework.TestCase;

public class GameStateTest extends TestCase {

  Board board;

  public void setUp() {
    board = new Board();
    int[][] moves = {{0,0},{2,0},{0,2},{2,2}};
    for(int[] move : moves)
      board.setCellValue(move,1);
  }

  public void testHorizontalWinnerReturnsZeroForNoWinner() {
    assertEquals( 0, GameState.HorizontalWinner(board) );
  }

  public void testHorizontalWinnerIsEqualToWinnerValue() {
    int[] cell = {0,1};
    board.setCellValue( cell, 1);
    assertEquals( 1, GameState.HorizontalWinner(board) );
  }

  public void testVerticalWinnerReturnsZeroForNoWinner() {
    assertEquals( 0, GameState.VerticalWinner(board) );
  }

  public void testVerticalWinnerReturnsWinnerValue() {
    int[] cell = {1,2};
    board.setCellValue( cell, 1);
    assertEquals( 1, GameState.VerticalWinner(board) );
  }

  public void testDiagonalWinnerReturnsZeroForNoWinner() {
    assertEquals( 0, GameState.DiagonalWinner(board) );
  }

  public void testDiagonalWinnerReturnsOneForFirstDiagonal() {
    int[] cell1 = {1,1};
    int[] cell2 = {0,2};
    board.setCellValue( cell1, 1);
    board.setCellValue( cell2, 0);
    assertEquals( 1, GameState.DiagonalWinner(board) );
  }

  public void testDiagonalWinnerReturnsOneForSecondDiagonal() {
    int[] cell1 = {1,1};
    int[] cell2 = {0,0};
    board.setCellValue( cell1, 1 );
    board.setCellValue( cell2, 0 );
    assertEquals( 1, GameState.DiagonalWinner(board) );
  }

  public void testWinnerForVertical() {
    int[] cell = {1,2};
    board.setCellValue( cell, 1 );
    assertEquals( 1, GameState.winner(board) );
  }

  public void testWinnerForHorizontal() {
    int[] cell = {0,1};
    board.setCellValue( cell, 1 );
    assertEquals( 1, GameState.winner(board) );
  }

  public void testWinnerForDiagonal() {
    int[] cell = {1,1};
    board.setCellValue( cell, 1 );
    assertEquals( 1, GameState.winner(board) );
  }

  public void testWinnerIsZeroForNoWinner() {
    assertEquals( 0, GameState.winner(board) );
  }

  public void testHasWinnerForVertical() {
    int[] cell = {1,2};
    board.setCellValue( cell, 1 );
    assertTrue( GameState.hasWinner(board) );
  }

  public void testHasWinnerForHorizontal() {
    int[] cell = {0,1};
    board.setCellValue( cell, 1 );
    assertTrue( GameState.hasWinner(board) );
  }

  public void testHasWinnerForDiagonal() {
    int[] cell = {1,1};
    board.setCellValue( cell, 1 );
    assertTrue( GameState.hasWinner(board) );
  }

  public void testHasWinnerIsFalse() {
    assertFalse( GameState.hasWinner(board) );
  }

  public void testFullForNonFullBoard() {
    assertFalse( GameState.full(board) );
  }

  public void testFullForFullBoard() {
    for(int i = 0; i < board.dimension; i++){
      for(int j = 0; j < board.dimension; j++){
        int[] cell = {i,j};
        board.setCellValue(cell, 1);
      }
    }
    assertTrue( GameState.full(board) );
  }

  public void testFinished() {
    assertFalse( GameState.finished(board) );
  }

  public void testFinishedOnGameWithWinner() {
    for(int i = 0; i < board.dimension; i++){
      int[] cell = {i,0};
      board.setCellValue(cell, 1);
    }
    assertTrue( GameState.finished(board) );
  }

  public void testFinishedOnFullBoard() {
    for(int i = 0; i < board.dimension; i++){
      for(int j = 0; j < board.dimension; j++){
        int[] cell = {i,j};
        board.setCellValue(cell, 1);
      }
    }
    assertTrue( GameState.finished(board) );
  }

}
