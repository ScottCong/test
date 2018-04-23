package test;

public class Singleton {  
    private Singleton() {}  
    private static Singleton single=null; 
    public int counter = 0;
    //静态工厂方法   
    public static Singleton getInstance() {  
         if (single == null) {    
             single = new Singleton();  
         }    
        return single;  
    }  
}  