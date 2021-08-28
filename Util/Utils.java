package Util;

import org.powbot.api.Area;
import org.powbot.api.Tile;
import org.powbot.api.rt4.*;
import org.powbot.api.rt4.walking.model.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static String mode;
    public static String location;
    public static List<Tile> StartTile = new ArrayList<Tile>();

    public static String getLogType() {
        if (mode != "Progressive") {
            return mode;
        } else {
            if(Skills.realLevel(Constants.SKILLS_FIREMAKING) < 15) {
                return "Logs";
            } else if (Skills.realLevel(Constants.SKILLS_FIREMAKING) < 30) {
                return "Oak Logs";
            } else if (Skills.realLevel(Constants.SKILLS_FIREMAKING) < 45) {
                return "Willow Logs";
            } else if (Skills.realLevel(Constants.SKILLS_FIREMAKING) < 50) {
                return "Maple Logs";
            }
        }
        return null;
    }

    public static boolean hasTinderbox() {
        if (Inventory.stream().name("Tinderbox").first().valid()) {
            return true;
        } else return false;
    }

    public static boolean hasLogs() {
        if (Inventory.stream().name(getLogType()).first().valid()) {
            return true;
        } else return false;
    }
    public static void getMode() {

    }

    public static boolean isLightingFire() {
        if (Players.local().animation() != -1) {
            return true;
        } else return false;
    }

    public static boolean isFireUnderPlayer() {
        GameObject Fire = Objects.stream().name("Fire").nearest().first();
        if (Fire != null && Fire.tile().equals(Players.local().tile())) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isClearLane(Area area) {
        GameObject Fire = Objects.stream().name("Fire").nearest().first();
        if (Fire != null && area.contains(Fire)) {
            return false;
        } else {
            return true;
        }
    }
    public static void CheckLane(Area area, Tile tile) {
        if(isClearLane(area)) {
            StartTile.add(tile);
        } else {
            StartTile.remove(tile);
        }
    }
    public static Tile anyTile() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(StartTile.size());
        return StartTile.get(index);
    }
    public static boolean isinVW() {
        if (Areas.VWNorthLane1.contains(Players.local()) || Areas.VWNorthLane2.contains(Players.local()) || Areas.VWSouthLane1.contains(Players.local()) || Areas.VWSouthLane2.contains(Players.local())) {
            return true;
        } else
            return false;
    }
    public static boolean isinVE() {
        if (Areas.VELane1.contains(Players.local()) || Areas.VELane2.contains(Players.local()) || Areas.VELane3.contains(Players.local())) {
            return true;
        } else
            return false;
    }
    public static boolean isinD() {
        if (Areas.DLane1.contains(Players.local()) || Areas.DLane2.contains(Players.local()) || Areas.DLane3.contains(Players.local())) {
            return true;
        } else
            return false;
    }
    public static boolean isinGE() {
        if (Areas.GESouthArea.contains(Players.local()) || Areas.GENorthArea.contains(Players.local())) {
            return true;
        } else
            return false;
    }
}
