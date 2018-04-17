package tw.core.generator;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    private RandomIntGenerator randomIntGenerator;
    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws Exception {
        randomIntGenerator = mock(RandomIntGenerator.class);
        answerGenerator = new AnswerGenerator(randomIntGenerator);
    }

    @Test
    public void test_should_return_an_given_random_answer() throws OutOfRangeAnswerException {
        //Given
        String expectAnswer = "1 2 3 4";

        //When
        when(randomIntGenerator.generateNums(9, 4)).thenReturn(expectAnswer);

        //Then
        assertThat(answerGenerator.generate().toString(), is(expectAnswer));

    }
}

