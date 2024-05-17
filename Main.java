import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    List<Organization> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int choice = 0;
    while (choice != Constants.EXIT.getValue()) {
      printMenu();
      choice = scanner.nextInt();
      scanner.nextLine();
      if (choice == Constants.ADD_OBJECT.getValue()) {
	pickClass(list, scanner);
      } else if (choice == Constants.REMOVE_OBJECT.getValue()) {
        Organization.removeObject(list, scanner);
      } else if (choice == Constants.OUTPUT_LIST.getValue()) {
        Organization.output(list);
      } else if (choice == Constants.CHECK_EQUALS.getValue()) {
        Organization.checkEquals(list, scanner);
      } else if (choice != Constants.EXIT.getValue()) {
        printErrorInput();
      }
    }
  }

  public static void pickClass(List<Organization> list, Scanner scanner) {
	int choice = 0;
	while (choice != Constants.EXIT.getValue()) {
		printClasses();
      choice = scanner.nextInt();
      scanner.nextLine();
      		if (choice == 1) {
	Organization organization = new Organization();
			organization.addObject();
			organization.printSuccessAdd();
			list.add(organization);
		}
		else if (choice == 2) {
			Factory factory = new Factory();
			factory.addObject();
			factory.printSuccessAdd();
			list.add(factory);
		}
		else if (choice == 3) {
			InsuranceCompany insuranceCompany = new InsuranceCompany();
			insuranceCompany.addObject();
			insuranceCompany.printSuccessAdd();
			list.add(insuranceCompany);
		}
		else if (choice == 4) {
			Fabrics fabrics = new Fabrics();
			fabrics.addObject();
			fabrics.printSuccessAdd();
			list.add(fabrics);
		}
		else if (choice != 5) {
			printErrorInput();
		}
	}
  }

  public static void printClasses() {
    System.out.printf("Выберите класс для создания объекта.\n");
    System.out.printf("1. Организация\n");
    System.out.printf("2. Завод\n");
    System.out.printf("3. Страховая компания\n");
    System.out.printf("4. Фабрика\n");
    System.out.printf("5. Завершение ввода\n");
  }

  public static void printMenu() {
    System.out.printf("Введите один из вариантов меню.\n");
    System.out.printf("1. Добавить новые элемент\n");
    System.out.printf("2. Удалить элемент\n");
    System.out.printf("3. Вывод всех элементов\n");
    System.out.printf("4. Сравнение элементов\n");
    System.out.printf("5. Завершение программы\n");
  }

  public static void printErrorInput() {
    System.out.printf("\nНеверный ввод. Попробуйте еще раз\n");
  }
}
