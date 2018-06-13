package jay.voice.color.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.request.Predicates;
import com.amazon.ask.response.ResponseBuilder;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static jay.voice.color.handlers.WhatIsMyColorIntentHandler.COLOR_KEY;
import static jay.voice.color.handlers.WhatIsMyColorIntentHandler.COLOR_SLOT;

public class MyColorIsIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("MyColorIsIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        Request request = handlerInput.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;

        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        Slot favoriteColorSlot = slots.get(COLOR_SLOT);

        System.out.println("The favorite color slot is :" + favoriteColorSlot);

        String speechText, repromptText;
        boolean isAskResponse = false;


        if (favoriteColorSlot != null) {
            String favoriteColor = favoriteColorSlot.getValue();
            handlerInput.getAttributesManager().setSessionAttributes(Collections.singletonMap(COLOR_KEY, favoriteColor));

            speechText = String.format("I now know your favorite color is %s, you can ask me your" +
                    "favorite color by asking, what is my favorite color", favoriteColor);

            repromptText = "You can ask me my favorite color by asking, what is my favorite color";

        } else {

            speechText = "I am not sure what your favorite color is, please try again";

            repromptText = "I am not sure what your favorite color is, " +
                    "you can tell me by saying, my favorite color is red";
            isAskResponse = true;
        }

        ResponseBuilder responseBuilder = handlerInput.getResponseBuilder();

        responseBuilder.withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)
                .withShouldEndSession(false);

        if(isAskResponse) {
            responseBuilder.withShouldEndSession(false)
                    .withReprompt(repromptText);
        }

        return responseBuilder.build();
    }
}
