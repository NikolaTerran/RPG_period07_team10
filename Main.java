import java.io.*;   
import java.util.*;

public class Main
{
  public final static int MAX_ENCOUNTERS = 5;

  private Protagonist prot;
  private Monster mons;

  private int moveCount;
  private boolean gameOver;
  private int difficulty;

  private InputStreamReader inSR;
  private BufferedReader inBR;

  public Main()
  {
    moveCount = 0;
    gameOver = false;
    inSR = new InputStreamReader( System.in );
    inBR = new BufferedReader( inSR );
    newGame();
  }

  public void newGame()
  {
    String s;
    String name = "";
    s = "~~~ Welcome to JAVA-RPG, a Zork-like rpg game. ~~~\n";

    System.out.print( s );

    s = "What is your name?";
    System.out.print( s );

    try {
	    name = inBR.readLine();
    } catch ( IOException e ) { }

    prot = new Protagonist( name );

  }


  public boolean playTurn()
  {
    int i = 1;
    int d1, d2;

	    System.out.println( "\nLo, yonder monster approacheth!" );

	    mons = new Monster();

	    while( mons.isAlive() && prot.isAlive() ) {

        if ( i == 2 )
          prot.specialize();
        else
          prot.normalize();

        d1 = prot.attack( mons );
        d2 = mons.attack( prot );

        System.out.println( "\n" + prot.getName() + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde Monster smacked " + prot.getName() +
                            " for " + d2 + " points of damage.");
	    }


	    if ( !mons.isAlive() && !prot.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " + 
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thy skull." );
        return false;
	    }

	    else if ( !mons.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
        return true;
	    }

	    else if ( !prot.isAlive() ) {
        System.out.println( "You die..." );
        return false;
	    }

    return true;
  }


  public static void main( String[] args )
  {
    Main game = new Main();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
        if ( !game.playTurn() )
            break;
        encounters++;
        System.out.println();
     }

    System.out.println( "Thy game doth be over." );
  }
}
