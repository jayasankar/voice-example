package jay.voice.helloworld.handlers;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import jay.voice.generic.CancelIntentHandler;
import jay.voice.generic.HelpIntentHandler;
import jay.voice.generic.LaunchReuestHandler;
import jay.voice.generic.StopIntentHandler;

/**
 * Created by jayasankar on 10/06/18.
 */
public class HelloWorldStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        System.out.println("Inside stream handler");
        return Skills.standard()
                .addRequestHandlers(new HelloWorldIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchReuestHandler(),
                        new CancelIntentHandler(),
                        new StopIntentHandler())
                .build();
    }

    public HelloWorldStreamHandler() {
        super(getSkill());
    }
}
