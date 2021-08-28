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

public class DraynorBurn extends Task {

    public DraynorBurn() {
        super();
    }

    @Override
    public void init() {
        System.out.println("initing");
    }

    @Override
    public boolean activate() {
        return Utils.hasLogs() && Utils.hasTinderbox() && Utils.location == "Draynor";
    }



    @Override
    public void execute() {
        Utils.CheckLane(Areas.DLane1, Areas.D1);
        Utils.CheckLane(Areas.DLane2, Areas.D2);
        Utils.CheckLane(Areas.DLane3, Areas.D3);
        if (!Utils.isinD() || Utils.isFireUnderPlayer()){
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
