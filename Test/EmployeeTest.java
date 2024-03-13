import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    Employee employee = new Employee("Anna Kovalenko", 19, 4);

    //Test Constructor
    @Test
    public void test_EmployeeConstructor(){
        System.out.println("Testing Constructor");
        assertNotNull(employee);
        assertEquals("Anna Kovalenko",  employee.getName());
        assertEquals(19,  employee.getAge());
        assertEquals(4,  employee.getExperience());
        assertEquals(30400, employee.getSalary());
    }

    //Test Name
    @Test
    public void test_GetName(){
        assertEquals("Anna Kovalenko", employee.getName());
    }

    //Test Age
    @Test
    public void test_GetAge(){
        assertEquals(19, employee.getAge());
    }

    //Test Experience
    @Test
    public void test_GetExperience(){
        assertEquals(4, employee.getExperience());
    }

    //Test T1
    @Test
    public void test_Employee_Valid(){
        assertEquals("Anna Kovalenko", employee.getName());
        assertEquals(19, employee.getAge());
        assertEquals(4, employee.getExperience());
    }

    // Test T2
    @Test
    public void test_GetName_Invalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Employee e1 = new Employee("", 30, 5);
        });
    }

    //Test T3
    @Test
    public void test_GetAge_Invalid(){
        assertThrows(IllegalArgumentException.class, ()->{
            Employee e2 = new Employee("Anna Kovalenko", 15, 4);
        });
    }

    //Test T5
    @Test
    public void test_GetExperience_Invalid(){
        Employee e3 = new Employee("Anna Kovalenko", 25, 2);
        assertEquals(2, e3.getExperience());
    }
    //Test T7
    @Test
    public void test_GetAge_getExperience_Invalid(){
        assertThrows(IllegalArgumentException.class, ()->{
            Employee e4 = new Employee("Anna Kovalenko", 64, 1);
            assertEquals(1, e4.getExperience());
        });
    }

    //Test T9
    @Test
    public void test_GetSelary_Less40_Less6(){
        assertEquals(30400.00, employee.getSalary());
    }

    //Test T10
    @Test
    public void test_GetSelary_Less40_More6(){
        Employee e5 = new Employee("Anna Kovalenko", 30, 9);
        assertEquals(31900.00, e5.getSalary());
    }

    //Test T11
    @Test
    public void test_GetSelary_More40_Less6(){
        Employee e6= new Employee("Anna Kovalenko", 45, 5);
        assertEquals(33750.00, e6.getSalary());
    }

    //Test T12
    @Test
    public void test_GetSelary_More40_More6(){
        Employee e7 = new Employee("Anna Kovalenko", 62, 10);
        assertEquals(35500.00, e7.getSalary());
    }


    // Test private setAge method with age 55
    @Test
    public void test_SetAge() throws Exception{
        System.out.println("setAgeMethod");

        Employee e8 = new Employee("Anna Kovalenko", 19, 4);

        Method method = Employee.class.getDeclaredMethod("setAge", int.class);
        method.setAccessible(true);
        method.invoke(e8, 55);

        Class secretClass = e8.getClass();
        Field f = secretClass.getDeclaredField("age");
        f.setAccessible(true);

        int result = f.getInt(e8);
        System.out.println("The value in f (age) is " + f.get(e8));

        assertEquals(55, result);
    }

    //Test Invalid Name Boundary
    @ParameterizedTest
    @ValueSource(strings = {"", "Abcdefghigklmnopqrstlmnopqrrergrgbhrdbgbgldbbhrjbjhr"})
    public void test_GetName_Invalid_Boundary(String name){
        assertThrows(IllegalArgumentException.class, () -> new Employee(name, 19, 4));
    }

    //Test Valid Name Boundary
    @ParameterizedTest
    @ValueSource(
            strings = {"Anna", "A A A", "anna", "ANNA"})
    public void test_GetName_Valid_Boundary(String name){
        new Employee(name, 19, 4);
    }

    //Test Invalid Age Boundary
    @ParameterizedTest
    @ValueSource(ints = {17, 0, 63})
    public void test_GetAge_Invalid_Boundary(int age){
        assertThrows(IllegalArgumentException.class, ()-> new Employee("Anna Kovalenko", age, 4));
    }

    //Test Valid Age Boundary
    @ParameterizedTest
    @ValueSource(ints = {19, 44, 60})
    public void test_GetAge_Valid_Boundary(int age){
        new Employee("Anna Kovalenko", age, 4);
    }

    //Test Invalid Experience Boundary
    @ParameterizedTest
    @ValueSource(ints = {1,0,-2})
    public void test_GetExperience_Invalid_Boundary(int exp){
        Employee e10 = new Employee("Anna Kovalenko", 19, exp);
        assertEquals(exp, e10.getExperience());
    }

    //Test Valid Experience Boundary
    @ParameterizedTest
    @ValueSource(ints = {3,6,22})
    public void test_GetExperience_Valid_Boundary(int exp){
        new Employee("Anna Kovalenko", 19, exp);
    }

}