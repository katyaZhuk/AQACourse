package senla.addressbook;

public class Main {

    public static void main(String[] args) {

        Tests tests = new Tests();
        tests.openPage("http://a.testaddressbook.com/sign_in");
        tests.testLogin("tester115@qa.com", "test");
        tests.testAddAddress("Katya", "Zhuk",
                "Main Street, 1", "Vitebsk", "111111");
        tests.testEditAddress("Second St. 101", "Minsk", "222222");
        tests.testDeleteAddress();
        tests.testLogout();

        tests.finishWork();
    }

}
