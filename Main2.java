public class Main {
    
    public  interface Matcher {
        boolean match(int number1, int number2);
    }
    
    public class SimpleMatcher implements Matcher{
        
        boolean match(int number1, int number2) {
            return number1 > number2;
        }
        
    }
    
    public class PrimeMatcher implements Matcher {
        
        public int findModule(int foo, int bar) {
            int r = foo % bar;
            if (r < 0) {
                r += Math.abs(bar);
            }
            return r;
        }
        
        public boolean match(int number1, int number2) {
            while (number2 != 0) {
                int tmp = number1;
                number1 = number2;
                number2 = findModule(tmp, number2);
            }
            return number1 == 1;
        }
        
    }
    
    public static void main(String... args) {
        PrimeMatcher p = new PrimeMatcher();
        System.out.print(p.match(14, -8));
    }
}
