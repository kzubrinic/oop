package hr.unidu.oop.p04.genericki;

public class Broj<N extends Number> {
  private N b;
  public Broj(N b) {
    this.b = b;
  }
  public N getB() {
    return b;
  }
  @Override
  public String toString() {
    return "Broj s vrijednošću " + b;
  }
}

