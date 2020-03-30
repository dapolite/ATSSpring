package com.example.ats.api;

        import com.example.ats.repository.IndustryRepository;
        import com.example.ats.repository.RecruiterUserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RestController;

@RestController("api/Industry")
public class IndustryController {

    @Autowired
    IndustryRepository industryRepository;

    @Autowired
    RecruiterUserRepository recruiterUserRepository;
}
