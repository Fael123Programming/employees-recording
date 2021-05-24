package oursystem;
public class Employee extends Person{
    private String occupation;
    private double salary;
    
    public Employee(String name, int age,String occupation,double salary) {
        super(name,age);
        this.occupation=occupation;
        this.salary=salary;
    }
    public Employee(){super();}
    public void setOccupation(String newOccupation){this.occupation=newOccupation;}
    public void setSalary(double newSalary){this.salary=newSalary;}
    
    public String getOccupation(){return this.occupation;}
    public double getSalary(){return this.salary;}
    @Override
    public String toString(){
        return "Nome:"+this.getName()+"\nOcupação:"+this.occupation+
                "\nIdade:"+this.getAge()+"\nSalário: R$"+this.salary;
    }
}