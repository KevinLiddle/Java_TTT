import junit.framework.TestCase;
import java.io.*;

public class HumanPlayerTest extends TestCase {

  static HumanPlayer player;

  public void setUp(){
    player = new HumanPlayer(1, "Kevin");
  }

  public void testHumanPlayerConstructor() {
    assertTrue( player != null );
    assertEquals( 1, player.playerValue() );
    assertEquals( "Kevin", player.playerName() );
  }

  private static void inputTest(String input) {
    int[] expectedMove = {2,1};
    InputStream stream = new ByteArrayInputStream(input.getBytes());
    int[] result = player.promptForMove(stream);
    for(int i = 0; i < expectedMove.length; i++)
      assertEquals( expectedMove[i], result[i] );
  }

  public void testPromptForMove() {
    String input = "2 1";
    inputTest(input);
  }

  public void testPromptForMoveWithDifferentInputFormat() {
    String input = "2\n 1";
    inputTest(input);
  }

  public void testPromptForMoveWithCommaSeparator() {
    String input = "2, 1";
    inputTest(input);
  }

  public void testPromptForMoveWithLetters() {
    String input = "x2efswerg1regwb";
    inputTest(input);
  }

}
