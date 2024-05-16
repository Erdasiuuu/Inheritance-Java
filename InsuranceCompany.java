public class InsuranceCompany extends Organization {
  private String insuranceType;
  private int numberOfClients;

  public InsuranceCompany(
      String name, int foundationYear, int id, String insuranceType, int numberOfClients) {
    super(name, foundationYear, id);
    this.insuranceType = insuranceType;
    this.numberOfClients = numberOfClients;
  }

  public InsuranceCompany() {
    super();
    this.insuranceType = "productionType";
    this.numberOfClients = 1;
  }

  @Override
  public boolean equals(Object o) {
    InsuranceCompany insuranceCompany = (InsuranceCompany) o;
    return super.equals(o) && this.insuranceType.equals(insuranceCompany.insuranceType)
        && this.numberOfClients == insuranceCompany.numberOfClients;
  }

  @Override
  public String toString() {
    return super.toString() + ", Production type = " + insuranceType
        + ", Number of clients = " + numberOfClients;
  }
}
