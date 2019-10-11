package guru.mahesh.swaggeraddressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class AddressBookRepo {
	
	ConcurrentMap<String,Contact> contacts=new ConcurrentHashMap<>();
	
	@GetMapping("/{conId}")
	@ApiOperation(value="Search contact by ConId",notes="provide an id and search the details",response=Contact.class)
	public Contact getContact(@PathVariable String conId)
	{
		return contacts.get(conId);
	}

	@GetMapping("/")
	public List<Contact> getAllContacts()
	{
		return new ArrayList<Contact>(contacts.values());
		
	}
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact)
	{
		contacts.put(contact.getConId(),contact);
		return contact;
		
	}
}
