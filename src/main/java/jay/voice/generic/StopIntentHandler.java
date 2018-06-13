package jay.voice.generic;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

/**
 * Created by jayasankar on 10/06/18.
 */
public class StopIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("AMAZON.StopIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        System.out.println("Inside stop world intent");
        String speechText = "You can say stop to me";
        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("HelloWorld", speechText)
                .withReprompt(speechText)
                .build();
    }
}
