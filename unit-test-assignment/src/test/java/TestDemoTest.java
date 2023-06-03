import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
	 private TestDemo testDemo;

	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			}else {
	            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	}

	public static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                Arguments.arguments(2, 4, 6, false),
                Arguments.arguments(0, 4, 4, true),
                Arguments.arguments(-2, 4, 2, true));
    }
	
	 @Test
	    void assertThatNumberSquaredIsCorrect() {
	        TestDemo testDemo = new TestDemo();
	        TestDemo mockDemo = spy(testDemo);
	        
	        doReturn(5).when(mockDemo).getRandomInt();
	        
	        int fiveSquared = mockDemo.randomNumberSquared();
	        
	        assertThat(fiveSquared).isEqualTo(25);
	    }
	
}
