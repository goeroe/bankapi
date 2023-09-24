package bank.xyz.bankapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findCustomerByUserName(String userName);
    boolean existsCustomerByUserName(String userName);
}
