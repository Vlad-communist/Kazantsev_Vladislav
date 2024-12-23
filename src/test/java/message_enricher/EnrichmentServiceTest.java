package message_enricher;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class EnrichmentServiceTest {

    @Test
    void testUsualMessage() {
        Map<String, String> content = new HashMap<>();
        content.put("action", "button_click");
        content.put("page", "book_card");
        content.put("msisdn", "88005553535");

        Message message = new Message();
        message.enrichmentType = Message.EnrichmentType.MSISDN;
        message.content = content;

        EnrichmentService service = new EnrichmentService();
        Message result = service.enrich(message);

        assertTrue(result.content.containsKey("action"));
        assertEquals("button_click", result.content.get("action"));

        assertTrue(result.content.containsKey("page"));
        assertEquals("book_card", result.content.get("page"));

        assertTrue(result.content.containsKey("msisdn"));
        assertEquals("88005553535", result.content.get("msisdn"));

        assertEquals(5, result.content.size());

        assertTrue(result.content.containsKey("firstName"));
        assertTrue(result.content.containsKey("lastName"));
    }

    @Test
    void testTheSameMSISDN() {
        Map<String, String> content = new HashMap<>();
        content.put("action", "button_click");
        content.put("page", "book_card");
        content.put("msisdn", "88005553535");

        Message message1 = new Message();
        message1.enrichmentType = Message.EnrichmentType.MSISDN;
        message1.content = content;

        Message message2 = new Message();
        message2.enrichmentType = Message.EnrichmentType.MSISDN;
        message2.content = content;

        EnrichmentService service = new EnrichmentService();

        Message result1 = service.enrich(message1);
        Message result2 = service.enrich(message2);

        assertEquals(result1.content.get("firstName"), result2.content.get("firstName"));
        assertEquals(result1.content.get("lastName"), result2.content.get("lastName"));
    }

    @Test
    void testMessageWithNoMSISDN() {
        Map<String, String> content = new HashMap<>();
        content.put("action", "button_click");
        content.put("page", "book_card");

        Message message = new Message();
        message.enrichmentType = Message.EnrichmentType.MSISDN;
        message.content = content;

        EnrichmentService service = new EnrichmentService();
        Message result = service.enrich(message);

        assertEquals(2, result.content.size());

        assertTrue(result.content.containsKey("action"));
        assertEquals("button_click", result.content.get("action"));

        assertTrue(result.content.containsKey("page"));
        assertEquals("book_card", result.content.get("page"));
    }

    @Test
    void testUnknownTypeOfEnrichment() {
        Map<String, String> content = new HashMap<>();
        content.put("action", "button_click");
        content.put("page", "book_card");
        content.put("msisdn", "88005553535");

        Message message = new Message();
        message.enrichmentType = Message.EnrichmentType.UNKNOWN_TYPE;
        message.content = content;

        EnrichmentService service = new EnrichmentService();
        Message result = service.enrich(message);

        assertEquals(3, result.content.size());

        assertTrue(result.content.containsKey("action"));
        assertEquals("button_click", result.content.get("action"));

        assertTrue(result.content.containsKey("page"));
        assertEquals("book_card", result.content.get("page"));

        assertTrue(result.content.containsKey("msisdn"));
        assertEquals("88005553535", result.content.get("msisdn"));
    }

    // Проверяем потенциальную ошибку, когда два запроса с одним msisdn могут неправильно обработаться
    // Второй запрос приходит, и пока первый не успел обработаться до конца, второй перезаписывает имя фамилию
    // Проверяем на равенство все имена и фамилии
    // В теории тест может не сработать, т.к. имя фамилися генерится рандомно, но это очень маловероятно (1 / 26^20)
    @Test
    void testAsyncQueries() throws InterruptedException {
        Map<String, String> content = new HashMap<>();
        content.put("action", "button_click");
        content.put("page", "book_card");
        content.put("msisdn", "88005553535");

        EnrichmentService service = new EnrichmentService();
        List<Message> enrichmentResults = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            Message message = new Message();
            message.enrichmentType = Message.EnrichmentType.MSISDN;
            message.content = content;

            executorService.submit(() -> {
                enrichmentResults.add(
                        service.enrich(message)
                );
                latch.countDown();
            });
        }
        latch.await();

        for (int i = 0; i < 5; ++i) {
            for (int j = i + 1; j < 5; ++j) {
                assertEquals(enrichmentResults.get(i).content.get("firstName"), enrichmentResults.get(j).content.get("firstName"));
                assertEquals(enrichmentResults.get(i).content.get("lastName"), enrichmentResults.get(j).content.get("lastName"));
            }
        }
    }
}