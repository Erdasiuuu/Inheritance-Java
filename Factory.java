public class Factory extends Organization {
  private String productionType;
  private int numberOfEmployees;

  public Factory(String name, int foundationYear, int id, String productionType, int numberOfEmployees) {
    super(name, foundationYear, id);
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
		  printAttributes();
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
    System.out.printf("3. ID\n");
    System.out.printf("4. Тип продукции\n");
    System.out.printf("5. Количество сотрудников\n");
    System.out.printf("6. Вывести текущие данные\n");
    System.out.printf("7. Закончить ввод\n");
  }

  private void setNewAttributes(int choice) {
	  if (choice == 4) {
		String productionType = scanner.nextLine();
		setProductionType(productionType);
	  }
	  else if (choice == 5) {
		  int numberOfEmployees = scanner.nextInt();
		  scanner.nextLine();
		  setNumberOfEmployees(numberOfEmployees);
	  }
 }

  @Override
  public boolean equals(Object o) {
    Factory factory = (Factory) o;
    return this.name.equals(factory.name) && this.foundationYear == factory.foundationYear
        && this.id == factory.id;
  }

  @Override
  public String toString() {
    return "Fabrics: " + super.defaultAttributes() + factoryAttributes();
  }

  private String factoryAttributes() {
	  return ", Production type = " + productionType + " Number of employees = " + numberOfEmployees;
  }
}
