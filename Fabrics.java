public class Fabrics extends Organization {
  private String productionType;
  private int productionCapacity;

  public Fabrics() {
    super();
    this.productionType = "productionType";
    this.productionCapacity = 1;
  }

  public Fabrics(
      String name, int foundationYear, int id, String productionType, int productionCapacity) {
    super(name, foundationYear, id);
    this.productionType = productionType;
    this.productionCapacity = productionCapacity;
  }

  @Override
  public boolean equals(Object o) {
    Fabrics fabrics = (Fabrics) o;
    return super.equals(o) && this.productionType.equals(fabrics.productionType)
        && this.productionCapacity == fabrics.productionCapacity;
  }

  @Override
  public String toString() {
    return super.toString() + ", Production type = " + productionType
        + ", Production capacity = " + productionCapacity;
  }
}
