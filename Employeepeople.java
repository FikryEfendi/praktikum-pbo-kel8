public class Employeepeople{
    public static void main(String[] args){
        Employee e1 = new Employee (23421,"Ujang", 12000000);
        Employee e2 = new Employee (34352,"Slamet", 15000000);
        Employee e3 = new Employee (56656,"Mahmud", 34000000);

        e1.tampilkanInfo();
        e2.tampilkanInfo();
        e3.tampilkanInfo();
        Employee.tampilkanJumlahEmployee();
        System.out.println("Gaji Ujang : "+ e1.getsallary());
        e1.setSallary(5500000);
    }
}