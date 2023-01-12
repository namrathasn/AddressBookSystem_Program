package com;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook implements IAddressBook {

	Scanner scanner = new Scanner(System.in);
	ArrayList<Person> personList = new ArrayList<Person>();

	/**
	 * add method is public void type
	 * add method used to add contact details
	 * Ability to add a new contact to Address Book
	 */

	@Override
	public void add() {
		System.out.println("Enter your first name");
		String firstName = scanner.nextLine();
		System.out.println("Enter your last name");
		String lastName = scanner.nextLine();
		System.out.println("Enter your address");
		String address = scanner.nextLine();
		System.out.println("Enter your city");
		String city = scanner.nextLine();
		System.out.println("Enter your state");
		String state = scanner.nextLine();
		System.out.println("Enter your phone");
		long mobileNo = scanner.nextLong();
		System.out.println("Enter your zip code");
		int zip = scanner.nextInt();

		Person person1 = new Person(firstName, lastName, address, city, state, mobileNo, zip);
		personList.add(person1);
		System.out.println("Contact added successfully");
	}

	/**
	 * display is a public void type
	 * display method used to display the entered details.
	 * Creating display method to display the contact details 
	 */
	
	public void display() {
		for (int i = 0; i < personList.size(); i++) {
			Person person = personList.get(i);
			System.out.println("FirstName:" + person.getFirstName() + "\n" + "LastName:" + person.getLastName() + "\n"
					+ "Adress:" + person.getAddress() + "\n" + "City:" + person.getCity() + "\n" + "State:"
					+ person.getCity() + "Phone-Number:" + person.getMobileNo() + "\n" + "Pin-code:"
					+ person.getPincode());
		}
	}

	/**
	 * main method 
	 * Printing welcome message
	 *  
	 * @param args - argument, its an actual value that are passed to variables.
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Problem");
		AddressBook adressBookImplementation =new AddressBook();
        boolean condition = true;
     
        while (condition == true) {
    	     Scanner scanner= new Scanner(System.in);
    	     System.out.println("1.add"+"\n"+"2.Display"); 
    	     Scanner option = new Scanner(System.in);

             switch(option.nextInt()) {
             case 1: adressBookImplementation.add();
                     break;
         	 case 2: adressBookImplementation.display(); 
                         break;
    	     default : System.out.println();
             }
        }
	}
}
