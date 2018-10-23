import java.util.EnumSet;

import com.genesis.exams.slot.Evaluator;
import org.junit.Test;
import slot.ExamEvaluator;
import slot.SymbolEnum;
import slot.SymbolUtil;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static slot.SymbolEnum.*;

public class ExamEvaluatorTest {

  private Evaluator evaluator;

  private long bet = 29;

  public ExamEvaluatorTest() {
    this.evaluator = new ExamEvaluator();
  }

  @Test
  public void testAAACombination() {
    long result = evaluator.evaluate(SymbolUtil.getSymbols(A, A, A), bet);

    assertThat(result, is(20 * bet));
  }

  @Test
  public void testBBBCombination() {
    long result = evaluator.evaluate(SymbolUtil.getSymbols(B, B, B), bet);

    assertThat(result, is(20 * bet));
  }

  @Test
  public void testCCCCombination() {

    long result = evaluator.evaluate(SymbolUtil.getSymbols(C, C, C), bet);

    assertThat(result, is(20 * bet));
  }

  @Test
  public void testABCCombination() {
    long result = evaluator.evaluate(SymbolUtil.getSymbols(A, B, C), bet);

    assertThat(result, is(30 * bet));
  }

  @Test
  public void testLosingCombination(){
    long result = 0;

    for (SymbolEnum s1 :EnumSet.allOf(SymbolEnum.class)) {
      for (SymbolEnum s2 :EnumSet.allOf(SymbolEnum.class)) {
        for (SymbolEnum s3 :EnumSet.allOf(SymbolEnum.class)) {
          SymbolEnum[] symbols = new SymbolEnum[]{s1, s2, s3};
          result += evaluator.evaluate(SymbolUtil.getSymbols(symbols), bet);
        }
      }
    }

    assertThat(result, is(90 * bet));
  }
}
