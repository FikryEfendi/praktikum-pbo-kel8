public class Employee {
    int employeeId;
    String employeeName;
    double sallary;

    static int jumlahEmployee = 0;
    
    public static void tampilkanJumlahEmployee(){
        System.out.println("Jumlah Employee adalah : "+ jumlahEmployee);
    }

    public Employee (int employeeId, String employeeName, double sallary){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.sallary = sallary;
        jumlahEmployee++;
    }

    public double getsallary(){
        return sallary;
    }
    public void setSallary(double newSallary){
        if (newSallary > 0){
            System.out.println("Awokwowkow Rodi");
        }
        else{
            System.out.println("Selamat anda bergaji");    
        }
    }

    public void tampilkanInfo(){
        System.out.println ();
        System.out.println ("Employee ID = " + employeeId);
        System.out.println ("Employee Name = "  + employeeName);
        System.out.println ("Employee Sallary = " + sallary);
    }

}
