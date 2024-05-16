import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main
{

  public static void main(String[] args) {
	  List<Organization> list = new ArrayList<>();
	  Scanner scanner = new Scanner(System.in);
	  int choice = 0;
	  while (choice != Constants.EXIT.getValue()) {
		  printMenu();
		  choice = scanner.nextInt();
		  scanner.nextLine();
		  if (choice == Constants.ADD_OBJECT.getValue()) {
			  Organization.addObject();
		  }
		  else if (choice == Constants.REMOVE_OBJECT.getValue()) {
			  Organization.removeObject();
		  }
		  else if (choice == Constants.OUTPUT_LIST.getValue()) {
			  Organization.outputList();
		  }
		  else if (choice == Constants.CHECK_EQUALS.getValue()) {
			  Organization.checkEquals();
		  }
		  else if (choice != Constants.EXIT.getValue()) {
			  printErrorInput();
		  }
	  }
  }

  	public static void printErrorInput() {
    		System.out.printf("\nНеверный ввод. Попробуйте еще раз\n");
  	}

    public static class Organization {
    
        protected String name;
        protected int foundationYear;
        protected int id;
    
        //constructors, getters, setters
        
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
    
        @Override
        public boolean equals(Object o) {
            Organization organization = (Organization) o;
            return this.name.equals(organization.name) && this.foundationYear == organization.foundationYear && this.id == organization.id ;
        }
    
        @Override
        public int hashCode() {
            return id;
        }
    
        @Override
        public String toString() {
            return "Organization: ID = " + id + ", Name = " + name + ", Foundation year = " + foundationYear;
        }
    
    }

  public static class Fabrics extends Organization {

    private String productionType;
    private int productionCapacity;
    
    public Fabrics() {
        super();
        this.productionType = "productionType";
        this.productionCapacity = 1;
    }

    public Fabrics(String name, int foundationYear, int id, String productionType, int productionCapacity) {
        super(name, foundationYear, id);
        this.productionType = productionType;
        this.productionCapacity = productionCapacity;
    }


    @Override
    public boolean equals(Object o) {
        Fabrics fabrics = (Fabrics) o;
        return super.equals(o) && this.productionType.equals(fabrics.productionType) && this.productionCapacity == fabrics.productionCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Production type = " + productionType + ", Production capacity = " + productionCapacity;
    }

  }
    
  public static class InsuranceCompany extends Organization {

    private String insuranceType;
    private int numberOfClients;

    public InsuranceCompany(String name, int foundationYear, int id, String insuranceType, int numberOfClients) {
        super(name, foundationYear, id);
        this.insuranceType = insuranceType;
        this.numberOfClients = numberOfClients;
    }

    public InsuranceCompany() {
        super();
        this.productionType = "productionType";
        this.numberOfClients = 1;
    }

     @Override
    public boolean equals(Object o) {
        InsuranceCompany insuranceCompany = (InsuranceCompany) o;
        return super.equals(o) && this.insuranceType.equals(insuranceCompany.insuranceType) && this.numberOfClients == insuranceCompany.numberOfClients;
    }

    @Override
    public String toString() {
        return super.toString() + ", Production type = " + productionType + ", Number of clients = " + numberOfClients;
    }

    }
    
  public static class Factory extends Organization {

    private String productionType;
    private int numberOfEmployees;

    public Fabrics(String name, int foundationYear, int id, String productionType) {
        super(name, foundationYear, id);
        this.productionType = productionType;
    }

    public Fabrics() {
        super();
        this.productionType = "productionType";
    }

     @Override
    public boolean equals(Object o) {
        Factory factory = (Factory) o;
        return this.name.equals(factory.name) && this.foundationYear == factory.foundationYear && this.id == factory.id ;
    }

    @Override
    public String toString() {
        return "Fabrics: ID = " + id + ", Name = " + name + ", Foundation year = " + foundationYear + ", Production type = " + productionType;
    }

    }
}
