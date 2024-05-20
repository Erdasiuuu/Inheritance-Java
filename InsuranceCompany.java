import java.util.Objects;

public class InsuranceCompany extends Organization {
  private String insuranceType;
  private int numberOfClients;

  public InsuranceCompany(
      String name, int foundationYear, String insuranceType, int numberOfClients) {
    super(name, foundationYear);
    this.insuranceType = insuranceType;
    this.numberOfClients = numberOfClients;
  }

  public InsuranceCompany() {
    super();
    this.insuranceType = "insuranceType";
    this.numberOfClients = 1;
  }

  private void setInsuranceType(String insuranceType) {
    if (stringExist(insuranceType, this.insuranceType) == true) {
      this.insuranceType = insuranceType;
    }
  }

  private void setNumberOfClients(int numberOfClients) {
    if (positiveNum(numberOfClients, this.numberOfClients) == true) {
      this.numberOfClients = numberOfClients;
    }
  }

  /**
   * @brief Добавление элемента в список
   *
   * Выводятся все варианты меню и считывается ввод.
   * Выполняется проверка на коррекный числовой ввод, в случае ошибки
   * выводится уведомление об этом
   *
   */

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

  /**
   * @brief Проверка на выбор измениения новых аттрибутов дочернего класса
   *
   * @param Ранее введенный выбор
   * @return Был ли введен один из вариантов на изменение аттрибутов дочернего класса
   *
   */

  private boolean setSpecificAttributes(int choice) {
    boolean result = true;
    if (choice == 3) {
      System.out.println(1);
      String insuranceType = scanner.nextLine();
      setInsuranceType(insuranceType);
    } else if (choice == 4) {
      int numberOfClients = scanner.nextInt();
      scanner.nextLine();
      setNumberOfClients(numberOfClients);
    } else {
      result = false;
    }
    return result;
  }

  private void printSpecificAttributes() {
    System.out.printf("3. Тип страховки\n");
    System.out.printf("4. Количество клиентов\n");
  }

  /**
   * @brief Проверка на равенство объектов
   *
   * @param Объект
   * @return Равны ли объекты
   *
   */

  @Override
  public boolean equals(Object o) {
    boolean result = defaultCheck(o);
    if (result == true) {
      InsuranceCompany insuranceCompany = (InsuranceCompany) o;
      result = super.cmpDefaultAttributes(insuranceCompany.name, insuranceCompany.foundationYear)
          && cmpSpecificAttributes(
              insuranceCompany.insuranceType, insuranceCompany.numberOfClients);
    }
    return result;
  }

  private boolean cmpSpecificAttributes(String insuranceType, int numberOfClients) {
    return this.insuranceType.equals(insuranceType) && this.numberOfClients == numberOfClients;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, foundationYear, insuranceType, numberOfClients);
  }

  @Override
  public String toString() {
    return "Insurance company: " + super.defaultAttributes() + insuranceCompanyAttributes();
  }

  private String insuranceCompanyAttributes() {
    return ", Insurance type = " + insuranceType + ", Number of clients = " + numberOfClients;
  }
}
