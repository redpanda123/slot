package slot;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

import com.genesis.exams.slot.Reel;
import com.genesis.exams.slot.Spinner;
import com.genesis.exams.slot.Symbol;

/**
 * Implementation of Spinner
 */
public class ExamSpinner implements Spinner {

  private Random random = new Random();


  /**
   * Generate a random number multiplied by the total weight and find symbol in by the multiplied result in map
   */
  @Override
  public Symbol spin(Reel reel) {
    int totalWeight = getTotalWeight(reel);
    NavigableMap<Double, Symbol> weightMap = buildWeightMap(reel);

    double roll = random.nextDouble() * totalWeight;
    return weightMap.floorEntry(roll).getValue();
  }

  /**
   * Returns the total weight of the reel
   */
  private int getTotalWeight(Reel reel) {
    return Arrays
        .stream(reel.getSymbols())
        .map(Symbol::getWeight)
        .mapToInt(w -> w)
        .sum();
  }

  /**
   * Builds a Navigable map according to the Symbols of the reel
   */
  private NavigableMap<Double, Symbol> buildWeightMap(Reel reel) {
    NavigableMap<Double, Symbol> weightMap = new TreeMap<>();
    double weight = 0.0;

    for (Symbol symbol : reel.getSymbols()) {
      weightMap.put(weight, symbol);
      weight += symbol.getWeight();
    }

    return weightMap;
  }
}
