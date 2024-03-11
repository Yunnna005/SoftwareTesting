public class Employee {

    String name;
    int age;
    int years_experience;
    double salary;

    // This is the constructor of the class Employee
    public Employee (String name, int empAge, int years_exp){

        setName(name);
        setAge(empAge);
        setExperience(years_exp);
        setSalary();

    }


    private void setName(String name) {
        if ((name.isEmpty()) || (name.length() > 40) ){
            throw new IllegalArgumentException("Name must not be empty and must be less than 40 characters");
        }
        this.name = name;
    }

    // Assign the age of the Employee  to the variable age.
    public void setAge(int empAge) {

        if ((empAge < 18 ) || (empAge > 62)) {
            throw new IllegalArgumentException("The employee age must be betwee 18 and 62");
        }
        age = empAge;
    }

    /* Assign the years experience to the variable years experience.*/
    private void setExperience(int years_exp) {
        try {
            if (years_exp < 3) {
                throw new IllegalArgumentException("The employee must have a minimum of 3 years experience");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
        years_experience = years_exp;
    }

    /* Assign the salary to the variable salary.*/
    private void setSalary() {
        if (age <= 40) {
            if (years_experience <= 6) {
                salary = 30000.00 + (100 * years_experience);
            } else {
                salary = 31000.00 + (100 * years_experience);
            }
        }
        else {
            if (years_experience <= 6) {
                salary = 33000.00 + (150 * years_experience);
            }
            else
                salary = 34000.00 + (150 * years_experience);
        }
    }


    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getExperience(){
        return years_experience;
    }

    public double getSalary(){
        return salary;
    }

    /* Print the Employee details */
    public void printEmployee() {
        System.out.print(" Name:"+ name + "\n Age:" + age + "\n Experience:" +  years_experience + "\n Salary:" + salary);
    }
}
