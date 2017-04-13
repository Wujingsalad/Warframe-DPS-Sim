package com.example.wujing.warframe_dps_sim.database;

/**
 * Created by Wujing on 2017/4/12.
 */

public class WeaponDbSchema {
    public static final class WeaponTable{
        public static final String NAME="weapons";
        public static final class cols{
            public static final String WEAPONNAME="weaponname";
            public static final String BASICDAMAGE="basicdamage";
            public static final String FIRERATE="firerate";
            public static final String CRITCHANCE="critchance";
            public static final String CRITDAMAGE="critdamage";
            public static final String MULTSHOT="multshot";
            public static final String GENOCIDE="genocide";

        }
    }

}
