package structural_pattern.adapter_pattern.adapter;

import structural_pattern.adapter_pattern.adaptee.JSONParser;
import structural_pattern.adapter_pattern.target.XMLParser;

public class JSONAdapter implements XMLParser {

    JSONParser jsonParser;

    public JSONAdapter(JSONParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Override
    public void parseXML() {
        jsonParser.parseJSON();
    }
}
