package tasks;


import Util.Areas;
import Util.Utils;
import org.powbot.api.Condition;
import org.powbot.api.Nameable;
import org.powbot.api.Tile;
import org.powbot.api.rt4.*;
import org.powbot.api.rt4.stream.item.ItemStream;
import org.powbot.mobile.script.ScriptManager;

import java.util.concurrent.Callable;

public class GrandExchangeBank extends Task {

    public GrandExchangeBank() {
        super();
    }

    @Override
    public void init() {
        System.out.println("initing");
    }

    @Override
    public boolean activate() {
        return !Utils.hasLogs() && Utils.hasTinderbox() && Utils.location == "Grand Exchange";
    }



    @Override
    public void execute() {

            if(!Bank.inViewport()) {
                WebWalking.walkTo(Areas.GEBank, false,false);
            } else {
                if (!Bank.opened()) {
                    Bank.open();
                    if (Bank.stream().name(Utils.getLogType()).first().valid()) {
                        Bank.withdraw(Utils.getLogType(), 27);
                        Bank.close();
                    } else {
                        ScriptManager.INSTANCE.stop();
                    }

                }
            }
    }

    @Override
    public String status () {
        return "derp";
    }

}
