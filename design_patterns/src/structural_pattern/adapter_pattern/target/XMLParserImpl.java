package structural_pattern.adapter_pattern.target;

public class XMLParserImpl implements XMLParser {
    @Override
    public void parseXML() {
        System.out.println("Request parsed using XML parser");
    }
}
