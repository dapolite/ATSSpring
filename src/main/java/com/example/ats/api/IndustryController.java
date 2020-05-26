
package com.example.ats.api;

        import com.example.ats.repository.IndustryRepository;
        import com.example.ats.repository.JobPostRepository;
        import com.example.ats.repository.RecruiterUserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/Industry")
public class IndustryController {

    @Autowired
    IndustryRepository industryRepository;

    @Autowired
    RecruiterUserRepository recruiterUserRepository;

    @Autowired
    JobPostRepository jobPostRepository;


}

