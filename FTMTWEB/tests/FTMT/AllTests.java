package FTMT;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountControllerTest.class, AdminControllerTest.class, AdminInteractionTest.class, AdminTest.class,
		DBControllerTest.class, UniversityTest.class, UserControllerTest.class, UserInteractionTest.class,
		UserTest.class })
public class AllTests {

}
