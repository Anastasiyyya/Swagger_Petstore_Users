package tests;

import org.testng.annotations.BeforeMethod;
import specs.Specifications;

public class BaseTest {

    Specifications specifications;

    @BeforeMethod
    public void initTest(){
        initPages();
    }

    public void initPages() {
        specifications = new Specifications();

    }
}
