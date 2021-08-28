package Util;

import org.powbot.api.Area;
import org.powbot.api.Tile;

public class Areas {
    //GE
        public static final Area GENorthArea = new Area(new Tile(3143, 3493), new Tile(3183, 3508));
        public static final Area GESouthArea = new Area(new Tile(3148, 3484, 0), new Tile(3179, 3477, 0));
        public static final Tile GES1 = new Tile(3178, 3483);
        public static final Tile GES2 = new Tile(3178, 3482);
        public static final Tile GEN1 = new Tile(3178, 3497);
        public static final Tile GEN2 = new Tile(3178, 3496);
        public static final Area GESouthLane1 = new Area(new Tile(3145, 3483), GES1);
        public static final Area GESouthLane2 = new Area(new Tile(3145, 3482), GES2);
        public static final Area GENorthLane1 = new Area(new Tile(3145, 3497), GEN1);
        public static final Area GENorthLane2 = new Area(new Tile(3145, 3496), GEN2);
        public static final Tile GEBank = new Tile(3162, 3489);

        //VWEST
        public static final Tile VWN1 = new Tile(3200, 3431);
        public static final Tile VWN2 = new Tile(3204, 3430);
        public static final Tile VWS1 = new Tile(3204, 3429);
        public static final Tile VWS2 = new Tile(3204, 3428);
        public static final Area VWNorthLane1 = new Area(new Tile(3170,3431), VWN1);
        public static final Area VWNorthLane2 = new Area(new Tile(3170,3430), VWN2);
        public static final Area VWSouthLane1 = new Area(new Tile(3170,3429), VWS1);
        public static final Area VWSouthLane2 = new Area(new Tile(3170, 3428), VWS2);
        public static final Tile VWBank = new Tile(3185, 3436);

        //VEAST
        public static final Tile VE1 = new Tile(3266, 3430);
        public static final Tile VE2 = new Tile(3266, 3429);
        public static final Tile VE3 = new Tile(3266, 3428);
        public static final Area VELane1 = new Area(new Tile(3240,3430), VWN1);
        public static final Area VELane2 = new Area(new Tile(3240,3429), VWN2);
        public static final Area VELane3 = new Area(new Tile(3240,3428), VWS1);
        public static final Tile VEBank = new Tile(3254, 3420);

        //DRAYNOR
        public static final Tile D1 = new Tile(3097, 3250);
        public static final Tile D2 = new Tile(3097, 3249);
        public static final Tile D3 = new Tile(3097, 3248);
        public static final Area DLane1 = new Area(new Tile(3077,3250), D1);
        public static final Area DLane2 = new Area(new Tile(3077,3249), D2);
        public static final Area DLane3 = new Area(new Tile(3077,3248), D3);
        public static final Tile DBank = new Tile(3092, 3245);









}
