package jp.jaxa.iss.kibo.rpc.sampleapk;

import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

import gov.nasa.arc.astrobee.Result;
import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;

import org.opencv.core.Mat;

/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    @Override
    protected void runPlan1(){
        // the mission starts
        api.startMission();

        // move to a point
        Point point = new Point(10.71f, -7.76f, 4.42f);
        Quaternion quaternion = new Quaternion(0f, 0.707f, 0f, 0.707f);
        api.moveTo(point, quaternion, true);

        // report point1 arrival
        api.reportPoint1Arrival();

        // get a camera image
        //Mat image = api.getMatNavCam();

        // irradiate the laser
        api.laserControl(true);

        // take target1 snapshots
        api.takeTarget1Snapshot();

        // turn the laser off
        api.laserControl(false);



        Point point1 = new Point(11.52f, -9.93557f, 4.48f);
        Quaternion quaternion1 = new Quaternion(0f, 0.707f, 0f, 0.707f);
        api.moveTo(point1, quaternion1, true);

        Point point2 = new Point(11.2131f, -9.92284f, 5.46681f);
        Quaternion quaternion2 = new Quaternion(0f, 0f, -0.707f, 0.707f);
        api.moveTo(point2, quaternion2, true);


        // report point1 arrival

        // get a camera image
        //Mat image = api.getMatNavCam();

        // irradiate the laser
        api.laserControl(true);

        // take target1 snapshots
        api.takeTarget2Snapshot();

        // turn the laser off
        api.laserControl(false);

        Point point3 = new Point(11.345f, -9.3f, 4.48f);
        Quaternion quaternion3 = new Quaternion(0f, 0f, -0.707f, 0.707f);
        api.moveTo(point3, quaternion3, true);

        Point point4 = new Point(11.286f, -8.6f, 4.48f);
        Quaternion quaternion4 = new Quaternion(0f, 0f, -0.707f, 0.707f);
        api.moveTo(point4, quaternion4, true);

        Point pointg = new Point(11.27460f, -7.89178f, 4.96538f);
        Quaternion quaterniong = new Quaternion(0f, 0f, -0.707f, 0.707f);
        api.moveTo(pointg, quaterniong, true);


        /* ******************************************** */
        /* write your own code and repair the air leak! */
        /* ******************************************** */

        // send mission completion
        api.reportMissionCompletion();
    }

    @Override
    protected void runPlan2(){
        // write here your plan 2
    }

    @Override
    protected void runPlan3(){
        // write here your plan 3
    }

    // You can add your method
    private void moveToWrapper(double pos_x, double pos_y, double pos_z,
                               double qua_x, double qua_y, double qua_z,
                               double qua_w){

        final Point point = new Point(pos_x, pos_y, pos_z);
        final Quaternion quaternion = new Quaternion((float)qua_x, (float)qua_y,
                                                     (float)qua_z, (float)qua_w);

        api.moveTo(point, quaternion, true);
    }

    private void relativeMoveToWrapper(double pos_x, double pos_y, double pos_z,
                               double qua_x, double qua_y, double qua_z,
                               double qua_w) {

        final Point point = new Point(pos_x, pos_y, pos_z);
        final Quaternion quaternion = new Quaternion((float) qua_x, (float) qua_y,
                (float) qua_z, (float) qua_w);

        api.relativeMoveTo(point, quaternion, true);
    }

}

