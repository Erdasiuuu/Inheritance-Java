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

  private void setInsuranceType(String insuraceType) {
	  if (stringExist(insuranceType, this.insuranceType) == true) {
		  this.insuranceType = insuranceType;
	  }
  }

  private void setNumberOfClients(int numberOfClients) {
	  if (positiveNum(numberOfClients, this.numberOfClients) == true) {
		  this.numberOfClients = numberOfClients;
	  }
  }

  @Override
  protected void addObject() {
	  int choice = 0;
	  while (choice != 7) {
		  super.printDefaultAttributes();
		  printSpecificAttributes();
		  printOutputAndExit();
		  choice = scanner.nextInt();
		  scanner.nextLine();
		  super.setDefaultAttributes(choice);
		  setSpecificAttributes(choice);
		  super.objectOutputAndErrorInput(choice - 2);
	  }
  }

  private void setSpecificAttributes(int choice) {
	  if (choice == 4) {
		  String insuranceType = scanner.nextLine();
		  setInsuranceType(insuranceType);
	  }
	  else if (choice == 5) {
		  int numberOfClients = scanner.nextInt();
		  scanner.nextLine();
		  setNumberOfClients(numberOfClients);
	  }
  }

  private void printSpecificAttributes() {
	  System.out.printf("4. Тип страховки\n");
	  System.out.printf("5. Количество клиентов\n");
  }

  private void printOutputAndExit() {
	  System.out.printf("6. Вывести текущие данные\n");
	  System.out.printf("7. Закончить ввод\n");
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
