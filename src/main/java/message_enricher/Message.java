package message_enricher;

import java.util.Map;

public class Message {

    public Map<String, String> content;
    public EnrichmentType enrichmentType;

    public enum EnrichmentType {
        MSISDN, UNKNOWN_TYPE;
    }
}