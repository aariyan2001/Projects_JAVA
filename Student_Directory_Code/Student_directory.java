import java.util.*;
public class Student_directory {

    void welcome_page(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\t-----------------------------------------------------------------");
        System.out.println("\t-----------------------------------------------------------------");
        System.out.println("\t      ::::::::::: Welcome To The Project ::::::::::::::::");
        System.out.println("\t      :::::::::::   Student Directory    ::::::::::::::::");
        System.out.println("\t      :::::::::::                        ::::::::::::::::");
        System.out.println("\t      :::::::::::      Made by:-         ::::::::::::::::");
        System.out.println("\t      :::::::::::    Aariyan Sahu        ::::::::::::::::");
        System.out.println("\t      ::::::::::: Sapid:- 1000015386     ::::::::::::::::");
        System.out.println("\t-----------------------------------------------------------------");
        System.out.println("\t-----------------------------------------------------------------");
    } 

    void menu(){
        System.out.println("\n");
        System.out.println("\t\t\t <<<<< Main Menu >>>>> ");
        System.out.println("\n");
        System.out.println("\t\t 1. Input student data.");
        System.out.println("\t\t 2. Search student record by rollno.");
        System.out.println("\t\t 3. Display student data sorted by marks.");
        System.out.println("\t\t 4. Display data sorted by name.");
        System.out.println("\t\t 5. Exit.");
        System.out.println(" ");
    } 
    char grade(double n){
        char grade;
        if(n>=80.0)
        { 
            grade='A'; 
        }
        else if(n<=79 && n>=70){
            grade='B';
        }
        else if(n<=69 && n>=60){
            grade='C';
        }
        else if(n<=59 && n>=30){
            grade='D';
        }
        else{
            grade='F';
        }

        return grade;
    }

     public static void main(String[] args) {
         Student [] obj = new Student[100];
         Scanner in = new Scanner(System.in);
         Student_directory obj1 = new Student_directory();

         obj1.welcome_page();
         int choice,num=1;

         do{
            obj1.menu();
            System.out.print("\nEnter your choice: ");
            choice = in.nextInt();
            
            switch(choice){
                case 1: System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("\nNo.of student records want to enter: ");
                        num = in.nextInt();
                        for(int i=0 ; i<num ; i++){
                            obj[i] = new Student();
                            for(int j=0 ;j<i;j++){ 
                                if(j==i){
                                    continue;
                                }
                                else if(obj[j].get_rollno()==obj[i].get_rollno()){
                                    System.out.println("\nNo two student can have same rollno! Enter again the last record!");
                                    --i;
                                    break;
                                }
                                else{
                                    continue;
                                }
                            }
                        }
             
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("\nThe enter student record is: \n\n");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%5s %10s %20s %23s %25s %15s %10s","Rollno","Name","University","marks","Total marks","percentage","Grade");
                        System.out.println();
                        System.out.printf("%70s","java C.O D.M ");
                        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
                        
                        for(int i=0 ; i<num ; i++){
                            System.out.printf("%-10d %-15s %-22s %-7d %-6d %-15d %-14d %-15.2f %-10s",obj[i].get_rollno(),obj[i].get_name(),obj[i].get_univ(),obj[i].get_java_marks(),obj[i].get_co_marks(),obj[i].get_dm_marks(),obj[i].get_total_marks(),obj[i].get_percentage(),obj[i].get_grade()); System.out.print("\n");
            
                        }
             
                        System.out.println("\nThe student Records Entered Sucessfully :)\n");
                        break;

                case 2: System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("\nEnter the student rollno want to search for: ");
                        int val = in.nextInt();
                        System.out.println("--------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%5s %10s %20s %23s %25s %15s %10s","Rollno","Name","University","marks","Total marks","percentage","Grade");
                        
                        System.out.println();
                        System.out.printf("%70s","java C.O D.M ");
                        
                        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");

                        for(int i=0 ; i<num ; i++){
                            if(obj[i].get_rollno()==val){
                                System.out.printf("%-10d %-15s %-22s %-7d %-6d %-15d %-14d %-15.2f %-10s",obj[i].get_rollno(),obj[i].get_name(),obj[i].get_univ(),obj[i].get_java_marks(),obj[i].get_co_marks(),obj[i].get_dm_marks(),obj[i].get_total_marks(),obj[i].get_percentage(),obj[i].get_grade()); System.out.print("\n");
                
                            }
                            else {
                                continue;
                            }
                        
                        }
                        
                        break;

                case 3: System.out.print("\033[H\033[2J");
                        System.out.flush();
                        for(int i=0;i<num;i++){
                            for(int j=i+1;j<num;j++){
                                if(obj[i].get_total_marks()>obj[j].get_total_marks()){
                                    Student temp;
                                    temp=obj[i];
                                    obj[i]=obj[j];
                                    obj[j]=temp;
                                } 
                                else{
                                    continue;
                                } 
                            }
                        }
                        System.out.println("--------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%5s %10s %20s %23s %25s %15s %10s","Rollno","Name","University","marks","Total marks","percentage","Grade");
                        System.out.println();
                        System.out.printf("%70s","java C.O D.M ");
                        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");

                        for(int i=0 ; i<num ; i++){
                            System.out.printf("%-10d %-15s %-22s %-7d %-6d %-15d %-14d %-15.2f %-10s",obj[i].get_rollno(),obj[i].get_name(),obj[i].get_univ(),obj[i].get_java_marks(),obj[i].get_co_marks(),obj[i].get_dm_marks(),obj[i].get_total_marks(),obj[i].get_percentage(),obj[i].get_grade()); System.out.print("\n");
                        }
                        break; 

                case 4: System.out.print("\033[H\033[2J");
                        for(int i=0;i<num;i++){
                            System.out.flush();
                            for(int j=i+1;j<num;j++){
                                if(obj[i].get_name().compareToIgnoreCase(obj[j].get_name())>0){
                                    Student temp;
                                    temp=obj[i];
                                    obj[i]=obj[j];
                                    obj[j]=temp;
                                } 
                                else{
                                    continue;
                                } 
                            }
                        }
                
                        System.out.println("--------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%5s %10s %20s %23s %25s %15s %10s","Rollno","Name","University","marks","Total marks","percentage","Grade");
                        System.out.println();
                        System.out.printf("%70s","java C.O D.M ");
                        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
                        for(int i=0;i<num;i++){
                            System.out.printf("%-10d %-15s %-22s %-7d %-6d %-15d %-14d %-15.2f %-10s",obj[i].get_rollno(),obj[i].get_name(),obj[i].get_univ(),obj[i].get_java_marks(),obj[i].get_co_marks(),obj[i].get_dm_marks(),obj[i].get_total_marks(),obj[i].get_percentage(),obj[i].get_grade()); System.out.print("\n");
                         }

                         break;
                         
                case 5: System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("\n\n\t <<<< Thankyou >>>>");
                        System.exit(0);
                        break;
                        
                default: System.out.print("\n\n\n\t\tYou entered wrong choice!!!");
                         System.out.print("\n\t\tPlease enter again (:");
                         break;
           }
        }while(choice!=0);
            
        in.close();
    }
}
        
class Student{
    
    Scanner in = new Scanner(System.in);
    String name,Univ_name;
    int rollno,total;
    int [] marks = new int [3];
    double percent;
    char grade;

    Student(){
        int val;
        double val1;
        System.out.println("\n\tStudent Record ");
        System.out.print("\nName(full name): ");
        name=in.nextLine();
        System.out.print("\nUniversity Name: ");
        Univ_name=in.nextLine();

        System.out.print("\nRollno: ");
        rollno=in.nextInt();
        System.out.print("\nMark in java: ");
        marks[0]=in.nextInt();
        System.out.print("\nMark in C.O: ");
        marks[1]=in.nextInt();
        System.out.print("\nMark in D.M: ");
        marks[2]=in.nextInt();

        val = marks[0]+marks[1]+marks[2];
        total = val;

        val1 = (total*100)/300.0;
        percent = val1;
        Student_directory obj = new Student_directory();
        grade = obj.grade(percent);

    }

    String get_name(){
        return name;
    }
    String get_univ(){
        return Univ_name;
    }
    int get_rollno(){
        return rollno;
    }
    int get_java_marks(){
        return marks[0];
    }
    int get_co_marks(){
        return marks[1];
    }
    int get_dm_marks(){
        return marks[2];
    }
    int get_total_marks(){
        return total;
    }
    double get_percentage(){
        return percent;
    }
    char get_grade(){
        return grade;
    }
}