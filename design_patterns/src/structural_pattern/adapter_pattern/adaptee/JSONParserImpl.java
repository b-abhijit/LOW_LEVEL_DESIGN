package structural_pattern.adapter_pattern.adaptee;

public class JSONParserImpl implements JSONParser {
    @Override
    public void parseJSON() {
        System.out.println("Request parsed using JSON parser");
    }
}
