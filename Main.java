import java.util.Scanner;

public class Main
{

  public static void main(String[] args) {
      Organization x = new Organization();
      System.out.println(x);
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

  public class Fabrics extends Organization {

    private String productionType;
    private int productionCapacity;

    public Fabrics(String name, int foundationYear, int id, String productionType, int productionCapacity) {
        super(name, foundationYear, id);
        this.productionType = productionType;
        this.productionCapacity = productionCapacity;
    }

    public Fabrics() {
        super();
        this.productionType = "productionType";
        this.productionCapacity = 1;
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
    
  public class InsuranceCompany extends Organization {

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
        Fabrics fabrics = (Fabrics) o;
        return super.equals(o) && this.insuranceType.equals(fabrics.insuranceType) && this.numberOfClients == fabrics.numberOfClients;
    }

    @Override
    public String toString() {
        return super.toString() + ", Production type = " + productionType + ", Number of clients = " + numberOfClients;
    }

    }
    
  public class Factory extends Organization {

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
