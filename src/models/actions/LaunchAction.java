package models.actions;

import common.Const;
import models.Device;
import models.Flow;
import utils.ADBUtils;

public class LaunchAction extends Action {

    private int app_type;
    private String package_name;
    public LaunchAction(String name, int stepid, String memo, Flow flow, String[] param) {
        super(name, stepid, memo, flow);
        this.type = Const.ActionType.LAUNCH;
        this.tag = "launch";
        app_type = 1;
        if(param.length <= 1) return;
        app_type = Integer.parseInt(param[1]);
    }
    @Override
    public String doAction(Device device) {
        super.doAction(device);
//        if(device == null || device.client == null) return "";
//        device.client.sendData("LAUNCHAPP:"+appid);
        if(app_type == 1)
            ADBUtils.startApp(device.serialnumber, Const.qtt_pkg, Const.qtt_activity);
        else if(app_type == 2)
            ADBUtils.startApp(device.serialnumber, Const.dftt_pkg, Const.dftt_activity);
        return "";
    }

}
