package oursystem;
//This is the abstract class that we'll use to apply inheritance concept
public abstract class Person {
    private String name;
    private int age;
    
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public Person(){}
    //Set functions
    public void setName(String newName){this.name=newName;}
    public void setAge(int newAge){this.age=newAge;}
    //Get functions
    public String getName(){return this.name;}
    public int getAge(){return this.age;}
}