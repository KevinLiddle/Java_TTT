import junit.framework.TestCase;

public class BoardTest extends TestCase {

  Board board;

  public void setUp() {
    board = new Board();
  }

  public void testBoardConstructor() {
    assertTrue( board != null );
    assertEquals( 3, board.dimension );
  }

  public void testSetBoardCells() {
    int[] cell = { 2, 1 };
    assertEquals( 0, board.cellValueAt(cell));
    board.setCellValue( cell, 1);
    assertEquals( 1, board.cellValueAt(cell) );
  }

}
