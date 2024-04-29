package structural_pattern.adapter_pattern;

import structural_pattern.adapter_pattern.adaptee.JSONParserImpl;
import structural_pattern.adapter_pattern.adapter.JSONAdapter;
import structural_pattern.adapter_pattern.target.XMLParser;

public class Client {
    public static void main(String[] args) {
        XMLParser jsonAdapter = new JSONAdapter(new JSONParserImpl());
        jsonAdapter.parseXML();
    }
}
