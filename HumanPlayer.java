import java.util.*;
import java.io.*;

public class HumanPlayer implements Player {

  private int playerValue;
  private String playerName;

  public HumanPlayer(int value, String name) {
    playerValue = value;
    playerName = name;
  }

  public int playerValue() {
    return playerValue;
  }

  public String playerName() {
    return playerName;
  }

  public int[] move() {
    System.out.print(playerName + ", please enter a move (i.e.: 1,2): ");
    return promptForMove(System.in);
  }

  public int[] promptForMove(InputStream stream) {
    int[] move = new int[2];
    Scanner scanner = new Scanner(stream).useDelimiter("[ abcdefghijklmnopqrstuvwxyz\n,./!@#$%^&*()-+=|;:'\"<>?]+");
    int i = 0;
    while( i < 2 && scanner.hasNext() ){
      try{
        move[i] = scanner.nextInt();
        i++;
      }
      catch(InputMismatchException e) {
        scanner.next();
      }
    }
    return move;
  }

}
