import java.util.List;
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

  protected void addObject() {
	  int choice = 0;
	  while (choice != 5) {
		  printDefaultAttributes();
	          printOutputAndExit();	
		  choice = scanner.nextInt();
		  scanner.nextLine();
		  setDefaultAttributes(choice);
		  objectOutputAndErrorInput(choice);
	  }
  }

  protected void setDefaultAttributes(int choice) {
  		  if (choice == 1) {
			  String name = scanner.nextLine();
			  setName(name);
		  }
		  else if (choice == 2) {
			  int num = scanner.nextInt();
			  scanner.nextLine();
			  setFoundationYear(num);
		  }
  }

  protected void objectOutputAndErrorInput(int choice) {
  		  if (choice == 3){
			  outputObject();
		  }
		  else if (choice > 4 || choice <= 0) {
			  Main.printErrorInput();
		  }
  }

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
    System.out.printf(
        "Введите индекс объекта. Общее количество объектов в списке: %d. Отсчет начинается с 1\n", size);
  }

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

  public static void checkEquals(List<Organization> list, Scanner scanner) {
	  int size = list.size();
       checkListSize(size);
	if (size > 0) {
	    	int firstChoice = getListIndex(size, scanner);
		int secondChoice = getListIndex(size, scanner);
		if (list.get(firstChoice).hashCode() == list.get(secondChoice).hashCode() || list.get(firstChoice).equals(list.get(secondChoice))) {
			System.out.printf("\nЭлементы равны\n");
		}
		else {
			System.out.printf("\nЭлементы не равны\n");
		}
	}

  }

  protected void printDefaultAttributes() {
    System.out.printf("\n1. Название\n");
    System.out.printf("2. Год основания\n");
  }

  private void printOutputAndExit() {
    System.out.printf("3. Вывести текущие данные\n");
    System.out.printf("4. Закончить ввод\n");
  }

  protected void outputObject() {
	  System.out.printf("\n%s\n\n", this);
  }

  @Override
  public boolean equals(Object o) {
    boolean result = defaultCheck(o);
    if (result == true) {
		Organization organization = (Organization)o;
	    result = cmpDefaultAttributes(organization.name, organization.foundationYear);
    }
    return result;
  }

  protected boolean defaultCheck(Object o) {
    boolean result = true;
    if (this == o) {
	    result = true;
    }
    else if (o == null || this.getClass() != o.getClass()) {
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
	  return "Name = " + name
        + ", Foundation year = " + foundationYear;
  }
}
