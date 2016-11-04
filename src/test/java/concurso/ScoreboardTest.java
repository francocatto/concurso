package concurso;

import aplicacoes.GameEntry;
import aplicacoes.Scoreboard;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ScoreboardTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ScoreboardTest(String testName )
    {

        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {

        return new TestSuite( ScoreboardTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testShouldRejectScoreLesserThanLast()
    {
        GameEntry entryJohn = new GameEntry();
        entryJohn.setName("John");
        entryJohn.setScore(10);

        GameEntry entryJoshua = new GameEntry();
        entryJoshua.setName("Joshua");
        entryJoshua.setScore(20);

        GameEntry entryBob = new GameEntry();
        entryBob.setName("Bob");
        entryBob.setScore(5);

        Scoreboard scoreboard = new Scoreboard(2);
        scoreboard.add(entryJohn);
        scoreboard.add(entryJoshua);
        scoreboard.add(entryBob);


        assertTrue( scoreboard.getNumberOfEntries() == 2);
    }

    public void testShouldRemoveSecondELement()
    {
        GameEntry entryJohn = new GameEntry();
        entryJohn.
                setName("John");
        entryJohn.setScore(20);

        GameEntry entryJoshua = new GameEntry();
        entryJoshua.setName("Joshua");
        entryJoshua.setScore(10);

        GameEntry entryWill = new GameEntry();
        entryWill.setName("Will");
        entryWill.setScore(5);

        GameEntry entryBob = new GameEntry();
        entryBob.setName("Bob");
        entryBob.setScore(15);

        Scoreboard scoreboard = new Scoreboard(3);
        scoreboard.add(entryJohn);
        scoreboard.add(entryJoshua);
        scoreboard.add(entryWill);
        scoreboard.add(entryBob);


        assertEquals(3, scoreboard.getNumberOfEntries());
        assertEquals("Bob",scoreboard.getNameByPosition(2));
        assertEquals("Joshua",scoreboard.getNameByPosition(3));
    }

    public void testShouldRemoveSecondElement()
    {
        GameEntry entryJohn = new GameEntry();
        entryJohn.setName("John");
        entryJohn.setScore(20);

        GameEntry entryJoshua = new GameEntry();
        entryJoshua.setName("Joshua");
        entryJoshua.setScore(10);

        GameEntry entryWill = new GameEntry();
        entryWill.setName("Will");
        entryWill.setScore(5);

        Scoreboard scoreboard = new Scoreboard(3);
        scoreboard.add(entryJohn);
        scoreboard.add(entryJoshua);
        scoreboard.add(entryWill);

        scoreboard.remove(2);

        assertEquals(2, scoreboard.getNumberOfEntries());
        assertEquals("John",scoreboard.getNameByPosition(1));
        assertEquals("Will",scoreboard.getNameByPosition(2));
    }
}
