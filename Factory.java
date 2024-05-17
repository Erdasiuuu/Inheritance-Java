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
	  while (choice != 7) {
		  super.printDefaultAttributes();
		  printSpecificAttributes();
		  super.printChildOutputAndExit();
		  choice = scanner.nextInt();
		  scanner.nextLine();
		  super.setDefaultAttributes(choice);
		  setNewAttributes(choice);
		  super.objectOutputAndErrorInput(choice - 2);
	  }
  }

  private void printAttributes() {
    System.out.printf("\n1. Название\n");
    System.out.printf("2. Год основания\n");
    System.out.printf("3. Тип продукции\n");
    System.out.printf("4. Количество сотрудников\n");
    System.out.printf("5. Вывести текущие данные\n");
    System.out.printf("6. Закончить ввод\n");
  }

  private void setNewAttributes(int choice) {
	  if (choice == 3) {
		String productionType = scanner.nextLine();
		setProductionType(productionType);
	  }
	  else if (choice == 4) {
		  int numberOfEmployees = scanner.nextInt();
		  scanner.nextLine();
		  setNumberOfEmployees(numberOfEmployees);
	  }
 }

  @Override
  public boolean equals(Object o) {
    boolean result = defaultCheck(o);
    if (result == true) {
	    Factory factory = (Factory) o;
	    result = cmpDefauleAttributes(factory.name, factory.foundationYear) && cmpSpecificAttributes(factory.productionType, factory.numberOfEmloyees);
    }
    return result;
  }

  private boolean cmpSpecificAttributes(String productionType, int numberOfEmployees) {
	  return this.productionType.equals(productionType) && this.numberOfEmployees == numberOfEmployees;
 }

  @Override
  public int hashCode() {
	  return Objects.hash(name, foundationYear, productionType, numberOfEmployees);  }

  @Override
  public String toString() {
    return "Fabrics: " + super.defaultAttributes() + factoryAttributes();
  }

  private String factoryAttributes() {
	  return ", Production type = " + productionType + " Number of employees = " + numberOfEmployees;
  }
}
