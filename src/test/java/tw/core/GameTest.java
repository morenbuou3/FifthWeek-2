package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    private Game game;
    private Answer actualAnswer;

    @Before
    public void setUp() throws Exception {
        //Given
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        actualAnswer = Answer.createAnswer("1 2 3 4");

        //When
        when(answerGenerator.generate()).thenReturn(actualAnswer);

        //Then
        game = new Game(answerGenerator);
    }

    @Test
    public void test_game_guess_should_return_1A2B_when_give_input_answer_1325() {
        //Given
        String inputAnswer = "1 3 2 5";
        Answer answer = Answer.createAnswer(inputAnswer);
        String expect = "1A2B";

        //Then
        assertThat(game.guess(answer).getResult(), is(expect));
    }
}
