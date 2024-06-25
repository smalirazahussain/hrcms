package config.properties;

public class MainClass {
    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReader();
        String username = configReader.getProperty("username");
        String employerurl = configReader.getProperty("employerurl");
        String password = configReader.getProperty("password");
        String adminUrl = configReader.getProperty("adminUrl");
        String exchangeHouseUrl = configReader.getProperty("exchangeHouseUrl");
        String stageEmployerUrl = configReader.getProperty("stageEmployerUrl");
        String stageAminUrl = configReader.getProperty("stageAminUrl");

        System.out.println("URL: " + employerurl);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("AdminUrl"+adminUrl);
        System.out.println("ExchangeHouse Url"+exchangeHouseUrl);
        System.out.println("Stage Employer Url" + stageEmployerUrl);
        System.out.println("Stage Amin Url" + stageAminUrl);
        // Use the properties as needed in your automation
    }
}
