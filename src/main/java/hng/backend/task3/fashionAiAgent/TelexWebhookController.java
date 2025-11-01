package hng.backend.task3.fashionAiAgent;

import com.google.adk.events.Event;
import com.google.adk.runner.InMemoryRunner;
import com.google.adk.sessions.Session;
import com.google.genai.types.Content;
import com.google.genai.types.Part;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/telex")
public class TelexWebhookController {

    private final InMemoryRunner runner;
    private final Session session;

    public TelexWebhookController() {
        var rootAgent = AiAgents.createRootAgent();
        this.runner = new InMemoryRunner(rootAgent);
        this.session = runner.sessionService()
                .createSession(runner.appName(), "telexUser")
                .blockingGet();
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleMessage(@RequestBody TelexMessage message) {
        Content userMsg = Content.fromParts(Part.fromText(message.getText()));
        Flowable<Event> events = runner.runAsync(session.userId(), session.id(), userMsg);

        String response = events
                .toList()
                .blockingGet()
                .stream()
                .map(Event::stringifyContent)
                .collect(Collectors.joining("\n"));

        return ResponseEntity.ok(response);
    }
}
