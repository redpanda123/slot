package slot;

import com.genesis.exams.slot.Symbol;

public enum SymbolEnum {
  A(new Symbol("A", 1)),
  B(new Symbol("B", 1)),
  C(new Symbol("C", 1)),
  X(new Symbol("X", 1)),
  Y(new Symbol("Y", 2)),
  Z(new Symbol("Z", 3));

  private final Symbol symbol;

  SymbolEnum(Symbol symbol) {
    this.symbol = symbol;
  }

  public Symbol getSymbol() {
    return symbol;
  }
}
