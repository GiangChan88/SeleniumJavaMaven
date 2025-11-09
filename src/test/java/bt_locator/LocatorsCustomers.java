package bt_locator;

public class LocatorsCustomers {
    //locator menu Customers
    public static String menuCustomers = "//ul[@id='side-menu']//span[@class='menu-text' and normalize-space()='Customers']";
    public static String headerCustomers = "//h4[normalize-space()='Customers Summary']";

    public static String labelTotalCustomers = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Total Customers']";
    public static String numberTotalCustomers = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Total Customers']/preceding-sibling::span]";

    public static String labelActiveCustomers = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Active Customers']";
    public static String numberActiveCustomers = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Active Customers']/preceding-sibling::span";

    public static String labelInactiveCustomers = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Inactive Customers']";
    public static String numberInactiveCustomers = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Inactive Customers']/preceding-sibling::span";

    public static String labelActiveContacts = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Active Contacts']";
    public static String numberActiveContacts = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Active Contacts']/preceding-sibling::span";

    public static String labelInactiveContacts = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Inactive Contacts']";
    public static String numberInactiveContacts = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Inactive Contacts']/preceding-sibling::span";

    public static String labelContactsLoggedInToday = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Contacts Logged In Today']";
    public static String numberContactsLoggedInToday = "//h4[normalize-space()='Customers Summary']/following-sibling::div//span[normalize-space()='Contacts Logged In Today']/preceding-sibling::span";

    public static String btnNewCustomers = "//a[normalize-space()='New Customer']";
    public static String btnImportCustomers = "//a[normalize-space()='Import Customers']";
    public static String btnContacts = "//a[normalize-space()='Contacts' and @href='https://crm.anhtester.com/admin/clients/all_contacts']";



}
