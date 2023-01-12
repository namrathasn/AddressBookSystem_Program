package com;

import com.Person;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressBook implements IAddressBook {

	// Storing person info list inside address book map and then storing it to
	// hashmap.
	private static Map<String, Set<Person>> addressBookMap = new HashMap();
	private static Set<Person> personList = new HashSet<>();

	private String addressBookName;
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * Uc2: Ability to add a new contact to Address Book
	 */

	@Override
	public void add() {
		Set<Person> personList1 = new HashSet<>();
		System.out.println("Enter the name for your AddressBook : ");
		addressBookName = scanner.next();

		// checking if addressbookmap contain the userinput addressbook.
		if (addressBookMap.containsKey(addressBookName)) {
            System.out.println(addressBookName + " is already there please choose another name. ");
            add();
        } else {
        	
			UserInputData userDetails = new UserInputData();
			personList1 = userDetails.addUserInfo();

			// uc7 : checking for duplicate values if exist or not.
			if (!(personList1.equals(personList))) {
				addressBookMap.put(addressBookName, personList1);
				System.out.println("person added successfully");

			}
		}
	}

	public void display() {
		addressBookMap.forEach((String key, Set<Person> value) -> {
			System.out.println("AddressBook Name : " + key + "\t\t" + "Person Details : " + value);
		});
	}

	/**
	 * Uc3: Ability to edit existing contact person using their name
	 */

	@Override
	public void edit() {
		System.out.println("Enter the first name to edit contact.");
		String contactName = scanner.next();

		addressBookMap.entrySet().stream().map(entry -> entry.getValue().iterator()).forEachOrdered(itr -> {
			while (itr.hasNext()) {
				if (itr.next().getFirstName().equals(contactName)) {
					UserInputData userDetails = new UserInputData();
					personList = userDetails.addUserInfo();
					System.out.println("Contact edited with given first name : " + contactName);
					addressBookMap.put(addressBookName, (Set<Person>) personList);

				} else {
					System.out.println("Person with this name not found please try with another name.");
					edit();
				}
			}
		});

	}

	/**
	 * Uc4: Ability to delete a person using persons name
	 */

	@Override
	public void delete() {
		System.out.println("Enter the first name : ");
		String userInput = scanner.next();

		addressBookMap.entrySet().stream().map(entry -> entry.getValue().iterator()).forEachOrdered(itr -> {
			while (itr.hasNext()) {
				if (itr.next().getFirstName().equals(userInput)) {
					itr.remove();
					System.out.println("Contact deleted successfully");
				}

			}
		});

	}

	/**
	 * UC 11:Here persons list will be sorted in a alphabetical order.
	 * 
	 */
	private void sortByName() {
		addressBookMap.keySet().forEach((String name) -> {
			addressBookMap.get(name).stream().sorted(Comparator.comparing(Person::getFirstName))
					.collect(Collectors.toList()).forEach(person -> System.out.println(person.toString()));
		});

	}
	
	/**
     * UC 12:Here persons list will be sorted and displayed with city name of an alphabetical order.
     *  
     */

    private void sortByCity() {

        addressBookMap.keySet().forEach((String key) -> {
            addressBookMap.get(key).stream()
                    .sorted(Comparator.comparing(Person::getCity))
                    .collect(Collectors.toList())
                    .forEach(person -> System.out.println(person.toString()));
        });

    }
}
