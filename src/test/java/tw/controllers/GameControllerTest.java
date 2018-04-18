package tw.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tw.commands.InputCommand;
import tw.core.Game;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static tw.core.GameStatus.FAIL;
import static tw.core.GameStatus.SUCCESS;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    private GameController gameController;
    private ByteArrayOutputStream outContent;
    private Game game;
    private InputCommand inputCommand;

    @Before
    public void setUp() throws Exception {
        game = mock(Game.class);
        inputCommand = mock(InputCommand.class);

        gameController = new GameController(game, new GameView());

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @After
    public void tearDown() throws Exception {
        outContent.close();
    }

    @Test
    public void test_begin_game_should_return_instructions() throws IOException {
        //Given
        String expcet = "------Guess Number Game, You have 6 chances to guess!  ------\r\n";
        gameController.beginGame();

        //Then
        assertThat(systemOut(), is(expcet));
    }

    @Test
    public void test_should_system_out_fail_when_game_status_is_fail() throws IOException {
        //Given
        String status = FAIL;
        String expect = "Game Status: " + status + "\r\n";


        //When
        when(game.checkStatus()).thenReturn(status);
        gameController.play(inputCommand);

        //Then
        assertThat(systemOut(), is(expect));

    }

    @Test
    public void test_should_system_out_success_when_game_status_is_success() throws IOException {
        //Given
        String status = SUCCESS;
        String expect = "Game Status: " + status + "\r\n";


        //When
        when(game.checkStatus()).thenReturn(status);
        gameController.play(inputCommand);

        //Then
        assertThat(systemOut(), is(expect));

    }
}