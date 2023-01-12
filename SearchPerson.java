package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook implements IAddressBook {

	Scanner scanner = new Scanner(System.in);
	public ArrayList<Person> personList = new ArrayList<Person>();
	private Map<String, ArrayList<Person>> Books = new HashMap<>();
	public String city;

	/**
	 * add method is public void type add method used to add contact details to
	 * address book
	 */

	public void add() {

		System.out.println("To which city you want to add ?");
		city = scanner.next();
		Person person = new Person(city, personList);
		System.out.println("Enter your first name");
		String firstName = scanner.next();
		System.out.println("Enter your last name");
		String lastName = scanner.next();
		System.out.println("Enter your address");
		String address = scanner.next();
		System.out.println("Enter your city");
		String city = scanner.next();
		System.out.println("Enter your state");
		String state = scanner.next();
		System.out.println("Enter your phone");
		String mobileNo = scanner.next();
		System.out.println("Enter your zip code");
		String zip = scanner.next();

		if (Books.containsKey(city)) {
			Books.get(city).add(person);
		} else {
			personList = new ArrayList<>();
			personList.add(person);
			Books.put(city, personList);
		}

	}

	/**
	 * edit method is public void type edit method used to edit contact present in
	 * address book. Contact will be edited , based on first name
	 */

	public void edit() {
		System.out.println("Enter the city to which u want to edit person ");
		city = scanner.next();
		String enteredName;
		System.out.println("Enter First name of contact to edit it ");
		enteredName = scanner.next();
		for (int i = 0; i < Books.get(city).size(); i++) {
			if (Books.get(city).get(i).getFirstName().equals(enteredName)) {
				int check = 0;
				System.out.println("Person found , what do you want to edit ?");
				System.out.println(
						"Enter\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Phone\n8.Email");
				check = scanner.nextInt();
				switch (check) {
				case 1:
					System.out.println("Enter new first name");
					Books.get(city).get(i).setFirstName(scanner.next());
					break;
				case 2:
					System.out.println("Enter new last name");
					Books.get(city).get(i).setLastName(scanner.next());
					break;
				case 3:
					System.out.println("Enter new Address");
					Books.get(city).get(i).setAddress(scanner.next());
					break;
				case 4:
					System.out.println("Enter new city");
					Books.get(city).get(i).setCity(scanner.next());
					break;
				case 5:
					System.out.println("Enter new state");
					Books.get(city).get(i).setState(scanner.next());
					break;
				case 6:
					System.out.println("Enter new zip");
					Books.get(city).get(i).setPincode(scanner.next());
					break;
				case 7:
					System.out.println("Enter new phone number");
					Books.get(city).get(i).setMobileNo(scanner.next());
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
	 * Creating AddMultiplePerson method , so that user can add the contact details
	 * by entering person name user can delete the contact. 
	 * If contact person already present it display duplicate statement
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
	 * details. 
	 * Creating display method to display the contact details
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

	/**
	 * duplicateCheck is an public void type 
	 * ensuring there is no Duplicate Entry of the same Person in a Address Book
	 *
	 */
	public void duplicateCheck(String firstName) {
		for (int k = 0; k < personList.size(); k++) {
			String contactName = personList.get(k).firstName;

			if (firstName.equals(contactName)) {
				System.out.println("This Person is Already Present");
			} else {
				System.out.println("You can Add this Person");
				break;
			}
		}
	}

	/**
	 * Uc7: Ability to ensure there is no Duplicate Entry of the same Person in a
	 * particular Address Book.
	 */

	@Override
	public void searchPersonByName(String firstname) {
		List listPerson = (List) personList.stream()
				.filter(person1 -> person1.getFirstName().equalsIgnoreCase(firstname)).collect(Collectors.toList());
		personList.stream().forEach(System.out::println);
	}

	/**
	 * Uc8: Ability to search person in a city or state across the multiple
	 * AddressBook
	 */

	@Override
	public void searchPersonByState(String firstname) {
		List listPerson = (List) personList.stream()
				.filter(person1 -> person1.getFirstName().equalsIgnoreCase(firstname)).collect(Collectors.toList());
		personList.stream().forEach(System.out::println);
	}
}
