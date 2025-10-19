package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    //----------------추가 테스트----------------
    @Test
    void 기본_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 콜론_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 혼합_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_복잡한_예제_첫번째() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_복잡한_예제_두번째() {
        assertSimpleTest(() -> {
            run("//<<\\n1<<2<<3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_복잡한_예제_세번재() {
        assertSimpleTest(() -> {
            run("//abcde\\n11abcde12abcde13");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
