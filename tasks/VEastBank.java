package tasks;

import Util.Areas;
import Util.Utils;
import org.powbot.api.rt4.Bank;
import org.powbot.api.rt4.WebWalking;
import org.powbot.mobile.script.ScriptManager;

public class VEastBank extends Task {

    public VEastBank() {
        super();
    }

    @Override
    public void init() {
        System.out.println("initing");
    }

    @Override
    public boolean activate() {
        return !Utils.hasLogs() && Utils.hasTinderbox() && Utils.location == "Varrock East";
    }



    @Override
    public void execute() {

        if(!Bank.inViewport()) {
            WebWalking.walkTo(Areas.VEBank, false,false);
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