package  com.example.ats.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ats.model.CandidateUser;

@Repository
//public interface CandidateUserRepository extends ElasticsearchRepository<CandidateUser, Long> {
//    Optional<CandidateUser> findByUserName(String username);
//}
public interface CandidateUserRepository extends JpaRepository<CandidateUser, Long> {

    Optional<CandidateUser> findByUserName(String username);

    @Query("SELECT user from CandidateUser user LEFT JOIN user.educations edu LEFT JOIN user.experiences exp LEFT JOIN user.skills sk WHERE user.Id = 235")
    List<CandidateUser> getData();

    @Query("SELECT u from CandidateUser u where u.userName = :username")
    CandidateUser findUsersByCandidateUsername(@Param("username")String username);

    @Query("SELECT u.id from CandidateUser u where u.userName = :username")
    Long findUserIdByCandidateUsername(@Param("username")String username);

}
