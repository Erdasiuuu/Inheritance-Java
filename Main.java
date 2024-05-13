import java.util.Scanner;

public class Main
{
    enum Constants {
        SEVEN_DAY(10),
        NOW_SHOWING(10),
        ALL_TIMESLOTS(10);
        
        private int value;
        
        Constants(int value) {
            this.value = value;
        }
        
        int getValue() {
            return value;
        }
    }
    
    public class Organization {
    
    private String name;
    private int foundationYear;
    private int id;
    
    //constructors, getters, setters
    
    public Organization(String name, int foundationYear, int id) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.id = id;
    }
    
    public Organization() {
        this.name = "name";
        this.foundationYear = 2024;
        this.id = -1;
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
        return "Organization: id = " + id + ", name = " + name + ", foundation year = " + foundationYear;
    }
    
}

  public static void main(String[] args) {
  }
  
  public class Fabrics extends Organization {
    
    private String productionType;
    
    public Fabrics(String name, int foundationYear, int id, String productionType) {
        super(name, foundationYear, id);
        this.productionType = productionType;
    }
    
    public Fabrics() {
        super();
        this.productionType = "productionType";
    }
    
    
    //TODO
    //  @Override
    // public boolean equals(Object o) {
    //      organization = (Organization) o;
    //     return this.name.equals(organization.name) && this.foundationYear == organization.foundationYear && this.id == organization.id ;
    // }
    
    //   //TODO
    // @Override
    // public int hashCode() {
    //     return id;
    // }
    
      //TODO
    // @Override
    // public String toString() {
    //     return "Fabrics: id = " + id + ", name = " + name + ", foundation year = " + foundationYear + ", productionType = " + productionType;
    // }
    
}
}





