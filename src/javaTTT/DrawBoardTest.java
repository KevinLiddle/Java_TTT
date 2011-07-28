package javaTTT;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class DrawBoardTest {

  final ByteArrayOutputStream output = new ByteArrayOutputStream();
  Board board;

  @Before
  public void setUp() {
    board = new Board();
    System.setOut(new PrintStream(output));
  }

  @Test
  public void testDrawBlankBoard() {
    String drawnBoard = "[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n\n";
    DrawBoard.draw(board);
    assertEquals( drawnBoard, output.toString() );
  }

  @Test
  public void testDrawPartiallyFilledInBoard() {
    int[][] moves = {{0,0},{1,0},{2,2},{0,2},{1,1}};
    int[] values = {1,1,1,-1,-1};
    for(int i = 0; i < moves.length; i++)
      board.setCellValue(moves[i], values[i]);
    String drawnBoard = "[X][ ][O]\n[X][O][ ]\n[ ][ ][X]\n\n";
    DrawBoard.draw(board);
    assertEquals( drawnBoard, output.toString() );
  }
}
