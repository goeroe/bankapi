package bank.xyz.bankapi;

import bank.xyz.bankapi.customer.Customer;
import bank.xyz.bankapi.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        try {
            Customer customer1 = new Customer(customer.getUserName(), customer.getBirthDate(),  customer.getCountry());
            if (!customer1.isAdult()) {
                customer1.setPassword("");
                return new ResponseEntity<Customer>(customer1, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);

            }
            Customer _customer = customerRepository.save(customer1);
            return new ResponseEntity<Customer>(_customer, HttpStatus.CREATED);


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
