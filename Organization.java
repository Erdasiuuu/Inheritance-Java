import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Organization {
  protected String name;
  protected int foundationYear;
  protected Scanner scanner = new Scanner(System.in);

  public Organization() {
    this.name = "name";
    this.foundationYear = 2024;
  }

  public Organization(String name, int foundationYear) {
    this.name = name;
    this.foundationYear = foundationYear;
  }

  public void setName(String name) {
    if (stringExist(name, this.name) == true) {
      this.name = name;
    }
  }

  public void setFoundationYear(int foundationYear) {
    if (positiveNum(foundationYear, this.foundationYear) == true) {
      this.foundationYear = foundationYear;
    }
  }
  /**
   * @brief Проверка на пустую строку перед изменением аттрибута
   *
   * @param Проверяемая строка
   * @param Строка перед заменой
   * @return Результат проверки на пустую строку
   *
   */
  public boolean stringExist(String str, String previousStr) {
    boolean result = true;
    if (str.length() == 0) {
      System.out.printf("%s %s", incorrectStr(), previousStr);
      result = false;
    }
    return result;
  }

  private String incorrectStr() {
    return "Введена пустая строка, Оставлены предыдущие данные:";
  }
  /**
   * @brief Проверка на неотрецательное число
   *
   * @param Проверяемое число 
   * @param Число перед заменой
   * @return Результат проверки на неотрицательное число
   *
   */
  public boolean positiveNum(int num, int previousNum) {
    boolean result = true;
    if (num < 0) {
      System.out.printf("\n%s %s", incorrectNum(), previousNum);
      result = false;
    }
    return result;
  }

  private String incorrectNum() {
    return "Введено отрицательное число, Оставлены предыдущие данные:";
  }
  /**
   * @brief Добавление элемента в список
   *
   * Выводятся все варианты меню и считывается ввод.
   * Выполняется проверка на коррекный числовой ввод, в случае ошибки
   * выводится уведомление об этом
   *
   */
  protected void addObject() {
    int choice = 0;
    while (choice != 4) {
      printDefaultAttributes();
      printOutputAndExit(2);
      choice = scanner.nextInt();
      scanner.nextLine();
      boolean notDefaultAttributes = setDefaultAttributes(choice) == false;
      boolean notOutput = objectOutput(choice) == false;
      if (notDefaultAttributes && notOutput) {
        Main.printErrorInput();
      }
    }
  }
  /**
   * @brief Проверка на выбор измениения стандартных аттрибутов родительского класса
   *
   * @param Ранее введенный выбор
   * @return Был ли введен один из вариантов на изменение стандартных аттрибутов
   *
   */
  protected boolean setDefaultAttributes(int choice) {
    boolean result = true;
    if (choice == 1) {
      String name = scanner.nextLine();
      setName(name);
    } else if (choice == 2) {
      int num = scanner.nextInt();
      scanner.nextLine();
      setFoundationYear(num);
    } else {
      result = false;
    }
    return result;
  }
  /**
   * @brief Проверка на выбор вывода объекта
   *
   * @param Ранее введенный выбор
   * @return Был ли введен вариан на изменение вывод объекта
   *
   */
  protected boolean objectOutput(int choice) {
    boolean result = true;
    if (choice == 3) {
      outputObject();
    } else {
      result = false;
    }
    return result;
  }
  /**
   * @brief Удаление объекта из списка
   *
   * @param Список с объектами
   * @param Сканнер
   *
   * Выполняется проверка на пустоту списка.
   * Если список не пустой, то получаем индекс удаляемого элемента, выводим его
   * и удаляем из списка
   *
   */
  public static void removeObject(List<Organization> list, Scanner scanner) {
    int size = list.size();
    checkListSize(size);
    if (size != 0) {
      output(list);
      int choice = getListIndex(size, scanner);
      System.out.printf("\nУдален объект");
      list.get(choice).outputObject();
      list.remove(choice);
    }
  }

  protected static void printIndexFindMenu(int size) {
    System.out.printf("введите индекс объекта. общее количество объектов в списке: "); 
    System.out.printf("%d. Отсчет начинается с 1\n", size);
  }
  /**
   * @brief Получение существующего индекса в не пустом списке
   *
   * @param Размер списка
   * @param Сканнер
   * @return Индекс в списке
   *
   */
  protected static int getListIndex(int size, Scanner scanner) {
    int choice = 0;
    while (choice <= 0 || choice > size) {
      printIndexFindMenu(size);
      choice = scanner.nextInt();
      scanner.nextLine();
      if (choice <= 0 || choice > size) {
        Main.printErrorInput();
      }
    }
    return --choice;
  }
  /**
   * @brief Вывод всех элементов списка
   *
   * @param Список объектов
   *
   */
  protected static void output(List<Organization> list) {
    int size = list.size();
    checkListSize(size);
    for (int i = 0; i < size; i++) {
      System.out.printf("\n%d: %s\n", i + 1, list.get(i));
    }
    if (size != 0) {
      System.out.printf("\n");
    }
  }

  protected static void checkListSize(int size) {
    if (size == 0) {
      System.out.printf("\nНет введенных данных\n\n");
    }
  }

  public void printSuccessAdd() {
    System.out.printf("\nУспешно добавлен объект");
    outputObject();
  }
  /**
   * @brief Проверка двух элементов из списка на равенство
   *
   * @param Список
   * @param Сканнер
   *
   */
  public static void checkEquals(List<Organization> list, Scanner scanner) {
    int size = list.size();
    checkListSize(size);
    if (size > 0) {
      output(list);
      int firstChoice = getListIndex(size, scanner);
      int secondChoice = getListIndex(size, scanner);
      if (list.get(firstChoice).hashCode() == list.get(secondChoice).hashCode()
          && list.get(firstChoice).equals(list.get(secondChoice))) {
        System.out.printf("\nЭлементы равны\n");
      } else {
        System.out.printf("\nЭлементы не равны\n");
      }
    }
  }

  protected void printDefaultAttributes() {
    System.out.printf("\n1. Название\n");
    System.out.printf("2. Год основания\n");
  }
  /**
   * @brief Универсальная часть меню
   *
   * @param Переменная для указания является ли объект экземпляром
   * родительского или дочернего класса
   *
   */
  protected void printOutputAndExit(int notChild) {
    System.out.printf("%d. Вывести текущие данные\n", 5 - notChild);
    System.out.printf("%d. Закончить ввод\n", 6 - notChild);
  }

  protected void outputObject() {
    System.out.printf("\n%s\n\n", this);
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
      Organization organization = (Organization) o;
      result = cmpDefaultAttributes(organization.name, organization.foundationYear);
    }
    return result;
  }
  /**
   * @brief Стандартная проверка для объекта любого класса
   *
   * @param Объект
   * @return Прошел ли объект проверку
   *
   * Самая первая проверка для объектов любого класса(укахывают ли на один объект,
   * указывает ли параметр на null, являются ли они объектами одного класса
   *
   */
  protected boolean defaultCheck(Object o) {
    boolean result = true;
    if (this == o) {
      result = true;
    } else if (o == null || this.getClass() != o.getClass()) {
      result = false;
    }
    return result;
  }

  protected boolean cmpDefaultAttributes(String name, int foundationYear) {
    return this.name.equals(name) && this.foundationYear == foundationYear;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, foundationYear);
  }

  @Override
  public String toString() {
    return "Organization: " + defaultAttributes();
  }

  protected String defaultAttributes() {
    return "Name = " + name + ", Foundation year = " + foundationYear;
  }
}
