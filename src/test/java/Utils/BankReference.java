package Utils;

public class BankReference {
    public String name;
    public String routingCode;
    public String shortCode;

    public BankReference(String name, String routingCode, String shortCode) {
        this.name = name;
        this.routingCode = routingCode;
        this.shortCode = shortCode;
    }

    public String getName() {
        return name;
    }

    public String getRoutingCode() {
        return routingCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    @Override
    public String toString() {
        return "BankReference{" +
                "name='" + name + '\'' +
                ", routingCode='" + routingCode + '\'' +
                ", shortCode='" + shortCode + '\'' +
                '}';
    }
}
