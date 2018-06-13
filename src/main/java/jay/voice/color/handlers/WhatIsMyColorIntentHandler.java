package jay.voice.color.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;
import java.util.function.Predicate;

public class WhatIsMyColorIntentHandler implements RequestHandler {

    public static final String COLOR_KEY = "COLOR";
    public static final String COLOR_SLOT = "Color";

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("WhatIsMyColorIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = "";

        String favoriteColor = (String) handlerInput.getAttributesManager().getSessionAttributes().get(COLOR_KEY);
        System.out.println("The favorite color is :"+ favoriteColor);

        if (favoriteColor != null && !favoriteColor.isEmpty()) {
            speechText = String.format("Your favorite color is %s, good bye", favoriteColor);
        } else {
            speechText = "I am not sure what your favorite color is, you can say, my favorite color is red";
        }

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("ColorSession", speechText)
                .build();
    }
}
