package spaceshuttle;

import com.au.arvin.spaceshuttle.controller.UserController;
import com.au.arvin.spaceshuttle.repository.UserRepository;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

public class UserControllerTest {

    @Mock
    private UserRepository mockUserRepository;
    private UserController subject;

    @Before
    public void setup() {
        subject = new UserController();
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(subject, "userRepository", mockUserRepository);

    }


}
