import java.util.Arrays;

import com.genesis.exams.slot.*;
import slot.ExamEvaluator;
import slot.ExamSpinner;
import slot.SymbolEnum;
import slot.SymbolUtil;

import static slot.SymbolEnum.*;

public class App {

  public static void main(String[] args) {
    Reel[] reels = getReels();
    Spinner spinner = new ExamSpinner();
    Evaluator evaluator = new ExamEvaluator();

    SlotMachine slotMachine = new SlotMachine(reels, spinner, evaluator);
    SpinResult spinResult = slotMachine.spin(100);

    System.out.println("Result : " + SymbolUtil.getCombinedName(spinResult.getSymbols()));
    System.out.println("Payout : " + spinResult.getPayout());
  }

  /**
   * Build reel array according to requirement
   */
  private static Reel[] getReels() {
    return new Reel[]{
        new Reel(getSymbols(A, B, C, X, Y, Z)),
        new Reel(getSymbols(X, Y, Z, A, B, C)),
        new Reel(getSymbols(A, B, C, X, Y, Z))
    };
  }

  /**
   * Build Array of symbols by Array of SymbolEnum
   */
  private static Symbol[] getSymbols(SymbolEnum... symbols) {
    return Arrays.stream(symbols).map(SymbolEnum::getSymbol).toArray(Symbol[]::new);
  }


}
