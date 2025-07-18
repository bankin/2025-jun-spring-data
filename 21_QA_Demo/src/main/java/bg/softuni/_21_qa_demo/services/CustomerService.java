package bg.softuni._21_qa_demo.services;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public void create(/*List<CreateCustomerDTO> data*/) {
        // aggregate this.persist(..) results
    }

    private String persist(/*CreateCustomerDTO data*/) {
        // Validate static data
        // if (!isValid(data)) { return ... }

        // Validate relations
        // var = *Repository.findById(..);
        // var.isEmpty, var == null ?

        //
        return "";
    }

    private boolean isValid(/*CreateCustomerDTO data*/) {
        // static validations

        return false;
    }
}
