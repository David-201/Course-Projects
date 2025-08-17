/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package car;

import java.time.LocalDate;

/**
 *
 * @author TAM
 */
public class Car {
    // Attributes, data fields
    private String model;
    private int yearMade;
    private String carNumber;
    Integer yearPurchase; //attribute to satisfy the complement

    //A constructor to initialize model and yearMade
    public Car(String model, int yearMade) {
        this.model = model;
        this.yearMade = yearMade;
    }

    //A constructor to initialize model, yearMade and carNumber
    public Car(String model, int yearMade, String carNumber) {
        this.model = model;
        this.yearMade = yearMade;
        this.carNumber = carNumber;
    }

    //Getter methods for each attribute
    public String getModel() {
        return model;
    }

    public int getYearMade() {
        return yearMade;
    }

    public String getCarNumber() {
        return carNumber;
    }

    //A setter method for carNumber
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    //Display vehicle details (Model, Year made, Car number)
    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Year Made: " + yearMade);
        System.out.println("Car Number: " + carNumber);
    }

    //Compare "Car number" to see if they are Same/Different
    public void compareCarNumber(Car anotherCar) {
        if ((this.carNumber == null) || (anotherCar.getCarNumber() == null)) {
            System.out.println("One or both vehicles do not have a \"Car number\".");
        } else {
            if (this.carNumber.equals(anotherCar.getCarNumber())) {
                System.out.println("Warning: The \"Car number\" of the two cars is the same.");
            } else {
                System.out.println("The \"Car number\" of the two cars is different.");
            }
        }
    }

    //The time from when the car was purchased to the present.
    public Car(String model, int yearMade, String carNumber, Integer yearPurchase) {
        this.model = model;
        this.yearMade = yearMade;
        this.carNumber = carNumber;
        this.yearPurchase = yearPurchase;
    } //For information on when to buy a car

    public void setYearPurchase(Integer yearPurchase) {
        this.yearPurchase = yearPurchase;
    }

    public void sinceTheCarPurchase() {
        LocalDate currentDate = LocalDate.now(); //located in the "java.time" package to get the current year
        int currentYear = currentDate.getYear();
        if (this.yearPurchase == null) {
            System.out.println("Vehicle has no information on purchase time.");
        } else {
            System.out.println((currentYear - this.yearPurchase) + " years.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Enter vehicle data
        Car car_1 = new Car("Honda City", 2022, "VJM1775");
        Car car_2 = new Car("Toyota Vios", 2019, "VME841");

        //Print vehicle information (Model, Year made, Car number)
        System.out.printf("\t----Vehicle information----\n");
        System.out.println("      Car 1");
        car_1.displayDetails();
        System.out.printf("\n      Car 2\n");
        car_2.displayDetails();

        //print the comparison result "Car number"
        System.out.printf("\n\t\t\t----Compare car numbers----\n");
        System.out.printf("\nBetween car 1 and car 2:\n\t->");
        car_1.compareCarNumber(car_2);

        System.out.printf("Vehicle \"car number\" data of vehicle 2 is lost, comparison result between vehicle 1 and vehicle 2:\n\t->");
        car_2.setCarNumber(null);//If car 2 loses "car number" data
        car_1.compareCarNumber(car_2);

        System.out.printf("The \"vehicle number\" data of vehicle 2 is entered the same as that of vehicle 1. Comparison result between vehicle 1 and vehicle 2:\n\t-> ");
        car_2.setCarNumber(car_1.getCarNumber()); //If the "Car number" data of vehicle 2 is entered incorrectly and is the same as vehicle 1
        car_1.compareCarNumber(car_2);

        //The time from when the car was purchased to the present.
        System.out.printf("\n\t----The time from when the car was purchased to the present----\n");
        System.out.print("Car 1: ");

        car_1.sinceTheCarPurchase(); //If there is no information about the time of purchase of the car
        System.out.print("Car 2: ");
        car_2.setYearPurchase(2020); //Add year of purchase to data
        car_2.sinceTheCarPurchase();
    }
}