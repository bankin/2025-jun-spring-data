package bg.softuni._23_workshop.services;

import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    // Must work with ImportProjectDTO?
    private Unmarshaller unmarshaller;

    public ProjectService(
            @Qualifier("importProject") Unmarshaller unmarshaller
    ) {
        this.unmarshaller = unmarshaller;
    }
}
