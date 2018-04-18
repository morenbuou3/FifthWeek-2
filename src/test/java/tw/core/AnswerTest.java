package tw.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_should_return_aAnswer_when_createAnswer() {
        //Given
        String expectAnswer = "1 2 3 4";

        //Then
        assertThat(Answer.createAnswer(expectAnswer).toString(), is(expectAnswer));
    }

    @Test
    public void test_should_return_an_NumberFormatException_when_give_wrong_digit() throws OutOfRangeAnswerException {
        //Given
        String wrongDigit = "a";
        String expectAnswer = "1 2 3 a";
        Answer answer = Answer.createAnswer(expectAnswer);

        //Then
        expectedException.expect(NumberFormatException.class);
        expectedException.expectMessage("For input string: \"" + wrongDigit + "\"");
        answer.validate();

    }

    @Test
    public void test_should_return_an_OutOfRangeAnswerException_when_give_repeat_digit() throws OutOfRangeAnswerException {
        //Given
        String expectAnswer = "1 2 3 3";
        Answer answer = Answer.createAnswer(expectAnswer);

        //Then
        expectedException.expect(OutOfRangeAnswerException.class);
        expectedException.expectMessage("Answer format is incorrect");
        answer.validate();

    }

    @Test
    public void test_should_return_an_OutOfRangeAnswerException_when_give_digit_greater_than_9() throws OutOfRangeAnswerException {
        //Given
        String expectAnswer = "1 2 3 10";
        Answer answer = Answer.createAnswer(expectAnswer);

        //Then
        expectedException.expect(OutOfRangeAnswerException.class);
        expectedException.expectMessage("Answer format is incorrect");
        answer.validate();

    }

    @Test
    public void test_should_return_an_OutOfRangeAnswerException_when_give_digit_without_trim() throws OutOfRangeAnswerException {
        //Given
        String expectAnswer = "1 2 34";
        Answer answer = Answer.createAnswer(expectAnswer);

        //Then
        expectedException.expect(OutOfRangeAnswerException.class);
        expectedException.expectMessage("Answer format is incorrect");
        answer.validate();
    }
}