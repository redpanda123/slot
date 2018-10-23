package slot;

import com.genesis.exams.slot.Evaluator;
import com.genesis.exams.slot.Symbol;

/**
 * Implementation of Evaluator
 */
public class ExamEvaluator implements Evaluator {

  @Override
  public long evaluate(Symbol[] symbols, long bet) {
    int multiplier;

    String combinedName = SymbolUtil.getCombinedName(symbols);


    switch (combinedName) {
      case "AAA":
      case "BBB":
      case "CCC":
        multiplier = 20;
        break;
      case "ABC":
        multiplier = 30;
        break;
      default:
        return 0;
    }
    return multiplier * bet;
  }


}
