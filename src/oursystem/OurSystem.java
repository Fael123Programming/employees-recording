package oursystem;
import java.util.Scanner;
//Programa Principal
public class OurSystem {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Employee allEmployees[]=new Employee[100];
        String[] optionsStr={"(1) Registrar funcionário",
            "(2) Ver funcionários","(3) Apagar funcionário",
        "(4) Limpar dados","(5) Sair"};
        int lastFilledPosition=0,option;      
        while(true){
            while(true){
                message("Seja bem-vindo",60,true,true);
                options(optionsStr);
                System.out.print("-> ");
                option=input.nextInt();
                if(validOption(option)) break;
                else message("Escolha uma opção válida!",60,true,false);
            }
            switch(option){
                case 1:
                    record(allEmployees,lastFilledPosition);
                    lastFilledPosition++;
                    break;
                case 2:
                    employeesTable(allEmployees,lastFilledPosition);
                    break;
                case 3:
                    boolean wasDeleted=deleteFunctionary(allEmployees,
                            lastFilledPosition);
                    if(wasDeleted) lastFilledPosition--;
                    break;
                case 4:
                    cleanArray(allEmployees);
                    lastFilledPosition=0;
                    break;
            }
            if(option==5) break;
        }
            message("Rotina finalizada",60,true,true);
        }
       //Tools
       public static void message(String msg,int sizeDashes,
               boolean showTopRow,boolean showBottomRow){
            String dashes="";
            while(dashes.length()<=sizeDashes){dashes+="-";}
            if(showTopRow)System.out.println(dashes);
            System.out.println(fillString(msg,sizeDashes));
            if(showBottomRow)System.out.println(dashes);
        }
        public static void row(int size){
            String dashes="";
            while(dashes.length()<=size){dashes+="-";}
            System.out.println(dashes);
        }
        public static String fillString(String str,int totalSpaces){
            while(str.length()<totalSpaces){
                if(str.length()%2==0) str+=" ";
                else str=" "+str;
            }
            return str;
        }
        public static String fillStringAtRight(String str,int finalSize){
            while(str.length()<finalSize){str+=" ";}
            return str;
        }
        public static void cleanArray(Employee array[]){
            if(isArrayClean(array)){
               message("Não há dados",60,true,false);
               return;
            } 
            for(int pos=0;pos<array.length;pos++){array[pos]=null;}
            message("Limpo com sucesso!",60,true,false);
        }
        public static boolean isArrayClean(Employee array[]){
            for (Employee counter : array) {
                if (counter != null) return false;}
            return true;
        }
        public static int numberOfObjects(Employee array[]){
            int quantity=0;
            for(Employee counter:array){if(counter!=null) quantity++;}
            return quantity;
        }
        //Main functions
        public static boolean validOption(int opt){return opt>0&&opt<6;}
       
        public static void options(String[] options){
            for(String counter:options) System.out.println(counter);
            row(60);
        }
        public static void record(Employee array[],int lastFilledPosition)
        {
            Scanner input=new Scanner(System.in);
            Employee newEmployee=new Employee();
            message("Prencha os campos abaixo",60,true,true);
            System.out.print("Nome:");
            newEmployee.setName(input.nextLine());
            System.out.print("Ocupação:");
            newEmployee.setOccupation(input.nextLine());
            System.out.print("Idade:");
            newEmployee.setAge(input.nextInt());
            System.out.print("Salário: R$");
            newEmployee.setSalary(input.nextDouble());
            array[lastFilledPosition]=newEmployee;
            message("Registrado com sucesso",60,true,false);
        }
        public static void employeesTable(Employee array[],int 
                lastFilledPosition){
            if(isArrayClean(array)){
                message("Ninguém cadastrado",60,true,false);
                return;
            }
            Scanner input=new Scanner(System.in);
            int option;
            while(true){
                do{
                    message("Funcionários",60,true,true);
                    System.out.println("Código                        "
                            + "Funcionário");
                    for(int counter=0;counter<lastFilledPosition;
                            counter++){
                        System.out.format("%s%s\n",fillStringAtRight(
                                Integer.toString(counter),30),
                                array[counter].getName());
                    }
                    row(60);
                    System.out.print(
                            "Código do funcionário \n[-1 para sair]:");
                    option=input.nextInt();
                    if(option==-1) return;
                }while(option<0||option>=lastFilledPosition);
                employeeData(array[option]);
            }
        }
        public static void employeeData(Employee employee){
            message("Dados de "+employee.getName().split(
                    " ")[0],60,true,true);
            System.out.println(employee);
        }
        public static boolean deleteFunctionary(Employee array[],int 
                lastFilledPosition){
            if(isArrayClean(array)){
                message("Não há funcionários",60,true,false);
                return false;
            }
            Scanner input=new Scanner(System.in);
            int functionaryCode;
            do{
                message("Apagar funcionário",60,true,true);
                System.out.print("Código do funcionário:");
                functionaryCode=input.nextInt();
            }while(functionaryCode<0||functionaryCode>=
                    lastFilledPosition);
            String name=array[functionaryCode].getName().split(" ")[0];
            array[functionaryCode]=null;
            for(int counter=functionaryCode,counter2=functionaryCode+1;
                    counter2<lastFilledPosition;counter++,counter2++){
                array[counter]=array[counter2];
            }
            array[lastFilledPosition-1]=null;
            message(name+" excluído",60,true,false);
            return true;
        }    
}
