package utils;
import org.testng.asserts.SoftAssert;
public class AssertionsUtility {
    public static SoftAssert softAssert;
    public static void initSoftAssert(){
        softAssert=new SoftAssert();
    }
    public static SoftAssert getSoftAssert(){
        return softAssert;
    }
    public static void completeAssertions(){
        softAssert.assertAll();
    }
}
