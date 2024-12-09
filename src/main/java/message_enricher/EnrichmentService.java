package message_enricher;

class EnrichmentService {
    private UserRepository repository = new UserRepository();

    private Message enrichByMSISDN(Message message) {
        if (!message.content.containsKey("msisdn")) {
            return message;
        }
        String msisdn = message.content.get("msisdn");
        String firstName = repository.getFirstName(msisdn);
        String lastName = repository.getLastName(msisdn);
        message.content.put("firstName", firstName);
        message.content.put("lastName", lastName);
        return message;
    }

    // возвращается обогащенный (или необогащенный content сообщения)
    public Message enrich(Message message) {
        if (message.enrichmentType == Message.EnrichmentType.MSISDN) {
            synchronized (message) {
                return enrichByMSISDN(message);
            }
        }
        return message;
    }
}