package jay.voice.color.handlers;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import jay.voice.generic.CancelIntentHandler;
import jay.voice.generic.HelpIntentHandler;
import jay.voice.generic.LaunchReuestHandler;
import jay.voice.generic.StopIntentHandler;

public class ColorPickerStreamHandler extends SkillStreamHandler {

    private static Skill getSkills() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelIntentHandler(),
                        new HelpIntentHandler(),
                        new StopIntentHandler(),
                        new MyColorIsIntentHandler(),
                        new WhatIsMyColorIntentHandler(),
                        new LaunchReuestHandler()).build();
    }

    public ColorPickerStreamHandler() {
        super(getSkills());
    }
}
