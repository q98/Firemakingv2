import Util.Utils;
import org.powbot.api.rt4.Constants;
import org.powbot.api.rt4.Skills;
import org.powbot.api.rt4.walking.model.Skill;
import org.powbot.api.script.*;
import org.powbot.mobile.service.ScriptUploader;
import tasks.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@ScriptManifest(name= "FireMaking", description="Makes fire..", version = "1.0.0")
@ScriptConfiguration(
        name = "*INFO*",
        description = "Progressive will automatically switch logs depending on your level. \n" +
                "please make sure you have the required logs when selecting progressive mode. \n" +
                "below is a list of the required logs. \n" +
                "Please note that Progressive mode is only designed to go from 1-50 Firemaking currently.",
        defaultValue = "61 Normal 1-15",
        allowedValues = {"Normal (61 logs, level 1-15)","Oak (183 logs, level 15-30)", "Willow (535 logs, level 30-45)", "Maple (295 logs, level 45-50)"},
        optionType = OptionType.STRING,
        enabled = false, // Default
        visible = true// Default

)
@ScriptConfiguration(
        name = "Mode",
        description = "Pick a specific Log type, or Progressive mode.",
        defaultValue = "Logs",
        allowedValues = {"Logs","Oak Logs", "Willow Logs", "Maple Logs", "Yew Logs", "Redwood Logs", "Progressive"},
        optionType = OptionType.STRING, // Default
        enabled = true, // Default
        visible = true // Default

)
@ScriptConfiguration(
        name = "Location",
        description = "Pick the location where you'd like to burn.",
        defaultValue = "Grand Exchange",
        allowedValues = {"Grand Exchange", "Varrock West", "Varrock East", "Draynor"},
        optionType = OptionType.STRING, // Default
        enabled = true, // Default
        visible = true// Default

)
public class Firemaking extends AbstractScript {
    public static void main(String[] args) {
        new ScriptUploader().uploadAndStart("FireMaking", "N/A", "127.0.0.1", false, false);
    }

    public static List<Task> taskList = new ArrayList<>();

    @Override
    public void onStart() {

        Utils.mode = getOption("Mode");
        Utils.location = getOption("Location");
        taskList.addAll((Collection<? extends Task>) Arrays.asList(new GrandExchangeBurn(), new GrandExchangeBank(), new VWestBurn(), new VWestBank(), new VEastBurn(), new VEastBank(), new DraynorBurn(), new DraynorBank()));
    }
    @Override
    public void poll() {
         for (Task t : taskList) {
                if (t.activate()) {
                    System.out.println(t.status());
                    t.execute();
                }
            }
        }
    }


