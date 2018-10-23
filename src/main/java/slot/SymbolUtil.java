package slot;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.genesis.exams.slot.Symbol;

/**
 * Utility class with functions for symbols.
 */
public class SymbolUtil {

  /**
   * Concat symbol names in order.
   * example Symbol A, B, C, -> ABC
   */
  public static String getCombinedName(Symbol[] symbols) {
    return Arrays
        .stream(symbols)
        .map(Symbol::getName)
        .collect(Collectors.joining());
  }
}
