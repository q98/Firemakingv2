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


public class GrandExchangeBurn extends Task {

    public GrandExchangeBurn() {
        super();
    }

    @Override
    public void init() {
        System.out.println("initing");
    }

    @Override
    public boolean activate() {
        return Utils.hasLogs() && Utils.hasTinderbox() && Utils.location == "Grand Exchange";
    }



    @Override
    public void execute() {
        Utils.CheckLane(Areas.GENorthLane1, Areas.GEN1);
        Utils.CheckLane(Areas.GENorthLane2, Areas.GEN2);
        Utils.CheckLane(Areas.GESouthLane1, Areas.GES1);
        Utils.CheckLane(Areas.GESouthLane2, Areas.GES2);
        if (!Utils.isinGE() || Utils.isFireUnderPlayer()){
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
