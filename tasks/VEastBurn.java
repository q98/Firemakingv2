package tasks;


import Util.Areas;
import Util.Utils;
import org.powbot.api.Condition;
import org.powbot.api.Tile;
import org.powbot.api.rt4.Chat;
import org.powbot.api.rt4.Inventory;
import org.powbot.api.rt4.Players;
import org.powbot.api.rt4.WebWalking;

import java.util.concurrent.Callable;

public class VEastBurn extends Task {

    public VEastBurn() {
        super();
    }

    @Override
    public void init() {
        System.out.println("initing");
    }

    @Override
    public boolean activate() {
        return Utils.hasLogs() && Utils.hasTinderbox() && Utils.location == "Varrock East";
    }



    @Override
    public void execute() {
        Utils.CheckLane(Areas.VELane1, Areas.VE1);
        Utils.CheckLane(Areas.VELane2, Areas.VE2);
        Utils.CheckLane(Areas.VELane3, Areas.VE3);
        if (!Utils.isinVE() || Utils.isFireUnderPlayer()){
            Tile Start = Utils.anyTile();
            WebWalking.walkTo(Start, false, false);
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return Players.local().tile() == Start;
                }
            }, 500, 10);
        }
        if (!Inventory.opened()) {
            Inventory.open();
        }

        if (Utils.hasLogs() && Utils.hasTinderbox()&& !Utils.isFireUnderPlayer()) {
            Inventory.stream().name("Tinderbox").first().interact("Use");
            Inventory.stream().name(Utils.getLogType()).first().interact("Use");
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return !Utils.isLightingFire();

                }
            }, 950, 20);

        }
        if (Chat.canContinue()) {
            Chat.clickContinue();
        }



    }

    @Override
    public String status () {
        return "derp";
    }

}

