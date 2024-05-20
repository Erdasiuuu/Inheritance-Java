import java.util.Objects;

public class Fabrics extends Organization {
  private String productionType;
  private int productionCapacity;

  public Fabrics() {
    super();
    this.productionType = "productionType";
    this.productionCapacity = 1;
  }

  public Fabrics(String name, int foundationYear, String productionType, int productionCapacity) {
    super(name, foundationYear);
    this.productionType = productionType;
    this.productionCapacity = productionCapacity;
  }

  private void setProductionType(String productionType) {
    if (super.stringExist(productionType, this.productionType) == true) {
      this.productionType = productionType;
    }
  }

  private void setProductionCapacity(int productionCapacity) {
    if (super.positiveNum(productionCapacity, this.productionCapacity) == true) {
      this.productionCapacity = productionCapacity;
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

  private void printSpecificAttributes() {
    System.out.printf("3. Тип продукции\n");
    System.out.printf("4. Производственная мощность\n");
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
      String productionType = scanner.nextLine();
      setProductionType(productionType);
    } else if (choice == 4) {
      int productionCapacity = scanner.nextInt();
      scanner.nextLine();
      setProductionCapacity(productionCapacity);
    } else {
      result = false;
    }
    return result;
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
      Fabrics fabrics = (Fabrics) o;
      result = cmpDefaultAttributes(fabrics.name, fabrics.foundationYear)
          && cmpSpecificAttributes(fabrics.productionType, fabrics.productionCapacity);
    }
    return result;
  }

  private boolean cmpSpecificAttributes(String productionType, int productionCapacity) {
    return this.productionType.equals(productionType)
        && this.productionCapacity == productionCapacity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, foundationYear, productionType, productionCapacity);
  }

  @Override
  public String toString() {
    return "Fabrics: " + super.defaultAttributes() + fabricsAttributes();
  }

  private String fabricsAttributes() {
    return ", Production type = " + productionType
        + ", Production capacity = " + productionCapacity;
  }
}
