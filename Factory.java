import java.util.Objects;

public class Factory extends Organization {
  private String productionType;
  private int numberOfEmployees;

  public Factory(String name, int foundationYear, String productionType, int numberOfEmployees) {
    super(name, foundationYear);
    this.productionType = productionType;
    this.numberOfEmployees = numberOfEmployees;
  }

  public Factory() {
    super();
    this.productionType = "productionType";
    this.numberOfEmployees = 1;
  }

  private void setProductionType(String productionType) {
    if (super.stringExist(productionType, this.productionType) == true) {
      this.productionType = productionType;
    }
  }

  private void setNumberOfEmployees(int numberOfEmployees) {
    if (super.positiveNum(numberOfEmployees, this.numberOfEmployees) == true) {
      this.numberOfEmployees = numberOfEmployees;
    }
  }

  @Override
  protected void addObject() {
    int choice = 0;
    while (choice != 6) {
      super.printDefaultAttributes();
      printSpecificAttributes();
      super.printOutputAndExit(0);
      choice = scanner.nextInt();
      scanner.nextLine();
      boolean notDefaultAttributes = super.setDefaultAttributes(choice) == false;
      boolean notSpecificAttributes = setSpecificAttributes(choice) == false;
      boolean notOutput = super.objectOutput(choice - 2) == false;
      if (notDefaultAttributes && notSpecificAttributes && notOutput) {
        Main.printErrorInput();
      }
    }
  }

  private void printSpecificAttributes() {
    System.out.printf("3. Тип продукции\n");
    System.out.printf("4. Количество сотрудников\n");
  }

  private boolean setSpecificAttributes(int choice) {
    boolean result = true;
    if (choice == 3) {
      String productionType = scanner.nextLine();
      setProductionType(productionType);
    } else if (choice == 4) {
      int numberOfEmployees = scanner.nextInt();
      scanner.nextLine();
      setNumberOfEmployees(numberOfEmployees);
    } else {
      result = false;
    }
    return result;
  }

  @Override
  public boolean equals(Object o) {
    boolean result = defaultCheck(o);
    if (result == true) {
      Factory factory = (Factory) o;
      result = super.cmpDefaultAttributes(factory.name, factory.foundationYear)
          && cmpSpecificAttributes(factory.productionType, factory.numberOfEmployees);
    }
    return result;
  }

  private boolean cmpSpecificAttributes(String productionType, int numberOfEmployees) {
    return this.productionType.equals(productionType)
        && this.numberOfEmployees == numberOfEmployees;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, foundationYear, productionType, numberOfEmployees);
  }

  @Override
  public String toString() {
    return "Factory : " + super.defaultAttributes() + factoryAttributes();
  }

  private String factoryAttributes() {
    return ", Production type = " + productionType + " Number of employees = " + numberOfEmployees;
  }
}
