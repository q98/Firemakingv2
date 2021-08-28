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

public class VWestBurn extends Task {

    public VWestBurn() {
        super();
    }

    @Override
    public void init() {
        System.out.println("initing");
    }

    @Override
    public boolean activate() {
        return Utils.hasLogs() && Utils.hasTinderbox() && Utils.location == "Varrock West";
    }



    @Override
    public void execute() {
        Utils.CheckLane(Areas.VWNorthLane1, Areas.VWN1);
        Utils.CheckLane(Areas.VWNorthLane2, Areas.VWN2);
        Utils.CheckLane(Areas.VWSouthLane1, Areas.VWS1);
        Utils.CheckLane(Areas.VWSouthLane2, Areas.VWS2);
        if (!Utils.isinVW() || Utils.isFireUnderPlayer()){
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
