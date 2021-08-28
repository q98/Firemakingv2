package tasks;

import Util.Areas;
import Util.Utils;
import org.powbot.api.rt4.Bank;
import org.powbot.api.rt4.WebWalking;
import org.powbot.mobile.script.ScriptManager;

public class VWestBank extends Task {

    public VWestBank() {
        super();
    }

    @Override
    public void init() {
        System.out.println("initing");
    }

    @Override
    public boolean activate() {
        return !Utils.hasLogs() && Utils.hasTinderbox() && Utils.location == "Varrock West";
    }



    @Override
    public void execute() {

        if(!Bank.inViewport()) {
            WebWalking.walkTo(Areas.VWBank, false,false);
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