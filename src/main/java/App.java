import java.util.Arrays;

import com.genesis.exams.slot.Reel;
import com.genesis.exams.slot.Symbol;
import slot.ExamSpinner;
import slot.SymbolEnum;

import static slot.SymbolEnum.*;

public class App {

  private static Reel[] getReels() {
    return new Reel[]{
        new Reel(getSymbols(A, B, C, X, Y, Z)),
        new Reel(getSymbols(X, Y, Z, A, B, C)),
        new Reel(getSymbols(A, B, C, X, Y, Z))
    };
  }

  private static Symbol[] getSymbols(SymbolEnum... symbols) {
    return Arrays.stream(symbols).map(SymbolEnum::getSymbol).toArray(Symbol[]::new);
  }

  public static void main(String[] args) {
    Reel[] reels = getReels();
    ExamSpinner spinner = new ExamSpinner();


  }
}
