package com;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook implements IAddressBook {

	Scanner scanner = new Scanner(System.in);
	ArrayList<Person> personList = new ArrayList<Person>();

	/**
	 * add method is public void type 
	 * add method used to add contact details to address book
	 */

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
		String mobileNo = scanner.nextLine();
		System.out.println("Enter your zip code");
		String zip = scanner.nextLine();

		Person person1 = new Person(firstName, lastName, address, city, state, mobileNo, zip);
		personList.add(person1);
		System.out.println("Contact added successfully");
	}

	/**
	 * edit method is public void type 
	 * edit method used to edit contact present in address book. 
	 * Contact will be edited , based on first name
	 */

	public void edit() {
		String enteredName;
		System.out.println("Enter First name of contact to edit it ");
		enteredName = scanner.next();
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(enteredName)) {
				int check = 0;
				System.out.println("Person found , what do you want to edit ?");
				System.out.println(
						"Enter\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Phone\n8.Email");
				check = scanner.nextInt();
				switch (check) {
				case 1:
					System.out.println("Enter new first name");
					personList.get(i).setFirstName(scanner.next());
					break;
				case 2:
					System.out.println("Enter new last name");
					personList.get(i).setLastName(scanner.next());
					break;
				case 3:
					System.out.println("Enter new Address");
					personList.get(i).setAddress(scanner.next());
					break;
				case 4:
					System.out.println("Enter new city");
					personList.get(i).setCity(scanner.next());
					break;
				case 5:
					System.out.println("Enter new state");
					personList.get(i).setState(scanner.next());
					break;
				case 6:
					System.out.println("Enter new zip");
					personList.get(i).setPincode(scanner.next());
					break;
				case 7:
					System.out.println("Enter new phone number");
					personList.get(i).setMobileNo(scanner.next());
					break;
				case 8:
					System.out.println("Enter new email");
					personList.get(i).setPincode(scanner.next());
					break;
				default:
					System.out.println("Invalid Entry");

				}
			}
		}

	}

	/**
	 * Creating delete method , so that user can delete the contact details which is
	 * not required for user by entering first name user can delete the contact
	 */

	public void delete(String name) {
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(name)) {
				Person person = personList.get(i);
				personList.remove(person);
			}
		}
	}
	
	/**
	  *Creating AddMultiplePerson method , so that user can add the contact details 
	  *by entering person name user can delete the contact.
	  *If contact person already present it display duplicate statement
	  */
	
	public void addMultiplePerson() {
		System.out.println("Enter a person Name:");
		String firstName = scanner.nextLine();
		for (int i = 0; i < personList.size(); i++) {
			Person person = personList.get(i);
		}
	}

	/**
	 * display is a public void type, display method used to display the entered
	 * details. Creating display method to display the contact details
	 */

	public void display() {
		for (int i = 0; i < personList.size(); i++) {
			Person person = personList.get(i);
			System.out.println("FirstName:" + person.getFirstName() + "\n" + "LastName:" + person.getLastName() + "\n"
					+ "Adress:" + person.getAddress() + "\n" + "City:" + person.getCity() + "\n" + "State:"
					+ person.getCity() + "\n" + "Phone-Number:" + person.getMobileNo() + "\n" + "Pin-code:"
					+ person.getPincode());
		}
	}
}
