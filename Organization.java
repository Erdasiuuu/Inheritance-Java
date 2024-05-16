import java.util.List;
import java.util.Scanner;

public class Organization {
  protected String name;
  protected int foundationYear;
  protected int id;
  protected Scanner scanner = new Scanner(System.in);

  public Organization() {
    this.name = "name";
    this.foundationYear = 2024;
    this.id = -1;
  }

  public Organization(String name, int foundationYear, int id) {
    this.name = name;
    this.foundationYear = foundationYear;
    this.id = id;
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

  public void setId(int id) {
	  if (positiveNum(id, this.id) == true) {
		  this.id = id;
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
		  printAttributes();
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
		  else if (choice == 3) {
			  int num = scanner.nextInt();
			  scanner.nextLine();
			  setId(num);
		  }
  }

  protected void objectOutputAndErrorInput(int choice) {
  		  if (choice == 4){
			  outputObject();
		  }
		  else if (choice > 5 || choice <= 0) {
			  Main.printErrorInput();
		  }
  }

  public static void removeObject(List<Organization> list) {
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

  public static void checkEquals(List<Organization> list) {
  }

  private void printAttributes() {
    System.out.printf("\n1. Название\n");
    System.out.printf("2. Год основания\n");
    System.out.printf("3. ID\n");
    System.out.printf("4. Вывести текущие данные\n");
    System.out.printf("5. Закончить ввод\n");
  }

  protected void outputObject() {
	  System.out.printf("\n%s\n", this);
  }

  @Override
  public boolean equals(Object o) {
    Organization organization = (Organization) o;
    return this.name.equals(organization.name) && this.foundationYear == organization.foundationYear
        && this.id == organization.id;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public String toString() {
    return "Organization: " + defaultAttributes();
  }

  protected String defaultAttributes() {
	  return "ID = " + id + ", Name = " + name
        + ", Foundation year = " + foundationYear;
  }
}
