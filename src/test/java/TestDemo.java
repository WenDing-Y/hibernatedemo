import com.haut.dao.StudentDao;
import com.haut.model.Student;
import com.haut.util.BatchUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springContext-test.xml")
public class TestDemo {

    @Autowired
    StudentDao studentDao;

    @Autowired
    BatchUtil batchUtil;

    @Test
    public void save() {
        Student student = new Student("good", 12);
        studentDao.save(student);
    }

    @Test
    public void delete() {
        Student student = new Student(2, "good", 12);
        studentDao.delete(student);
    }

    @Test
    public void queryById() {
        System.out.println(studentDao.queryById(1L));
    }

    @Test
    public void batchSave() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(batchUtil);
        }
    }

}
