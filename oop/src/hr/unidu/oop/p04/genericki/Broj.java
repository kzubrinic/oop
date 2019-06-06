package hr.unidu.oop.p04.genericki;

public class Broj<T extends Number> {
  private T b;
  public Broj(T b) {
    this.b = b;
  }
  public T getB() {
    return b;
  }
  @Override
  public String toString() {
    return "Broj s vrijednošću " + b;
  }
}

