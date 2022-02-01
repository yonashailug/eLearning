package edu.hahu.enrollement.service;

import edu.hahu.enrollement.dao.EnrollmentDao;
import edu.hahu.enrollement.model.Enrollment;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollmentService implements IEnrollmentService {

    private final Environment env;
    private final EnrollmentDao enrollmentDao;
    private final RestTemplate restTemplate;

    @Override
    public List<Enrollment> findAll() {
        return enrollmentDao.findAll();
    }

    @Override
    public Enrollment findById(Long id) {
        return enrollmentDao.findById(id).get();
    }

    @Override
    public Optional<Enrollment> save(Enrollment enrollment) {

        if (!checkCourseExists(enrollment.getCourseId())) {
            return Optional.empty();
        }

        Enrollment enrollment1 = enrollmentDao.save(enrollment);
        return Optional.of(enrollment1);
    }

    @Override
    public void update(Enrollment enrollment) {
        enrollmentDao.save(enrollment);
    }

    @Override
    public void deleteById(Long id) {
        enrollmentDao.deleteById(id);
    }

    @Override
    public List<Object> getCoursesByUser(Long id) {
        String path = env.getProperty("course.service.location") + "/users/" + id;
        ResponseEntity<List<Object>> response = restTemplate
                .exchange(path,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        });
        return response.getBody();
    }

    public Boolean checkCourseExists(Long id) {
        String path = env.getProperty("course.service.location") + "/" + id;
        ResponseEntity<Object> response = restTemplate.exchange(path, HttpMethod.GET,
                null, new ParameterizedTypeReference<Object>() {
                });
        return response.getBody() != null;

    }
}
