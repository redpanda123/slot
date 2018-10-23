import com.genesis.exams.slot.*;
import slot.ExamEvaluator;
import slot.ExamSpinner;
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
        new Reel(SymbolUtil.getSymbols(A, B, C, X, Y, Z)),
        new Reel(SymbolUtil.getSymbols(X, Y, Z, A, B, C)),
        new Reel(SymbolUtil.getSymbols(A, B, C, X, Y, Z))
    };
  }



}
