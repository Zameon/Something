package jp.jaxa.iss.kibo.rpc.sampleapk;

import gov.nasa.arc.astrobee.Kinematics;
import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

import gov.nasa.arc.astrobee.Result;
import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;
import android.util.Log;
import org.opencv.core.Mat;

// opencv library
import org.opencv.aruco.Aruco;
import org.opencv.aruco.Dictionary;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Rect;

import static gov.nasa.arc.astrobee.Kinematics.Confidence.GOOD;
import static org.opencv.android.Utils.matToBitmap;
import org.opencv.core.Core;
import org.opencv.android.Utils;
import android.graphics.Bitmap;
import static org.opencv.android.Utils.matToBitmap;
import android.os.SystemClock;
import jp.jaxa.iss.kibo.rpc.api.types.PointCloud;




// java library
import java.util.ArrayList;
import java.util.List;

//import org.opencv.core.Mat;


/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    int NAV_MAX_COL = 1280;
    int NAV_MAX_ROW = 960;
    float AR_diagonal = 0.07071067812f;

    @Override
    protected void runPlan1() {


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


        //edited
        Point point1a = new Point(11.306f, -8.7768f, 4.48f);
        Quaternion quaternion1a = new Quaternion(0f, 0.707f, 0f, 0.707f);
        api.moveTo(point1a, quaternion1a, true);

        Point point1b = new Point(11.306f, -9.9356f, 4.48f);
        Quaternion quaternion1b = new Quaternion(0f, 0.707f, 0f, 0.707f);
        api.moveTo(point1b, quaternion1b, true);

        Point point2 = new Point(11.2131f, -9.92284f, 5.46681f);
        Quaternion quaternion2 = new Quaternion(0f, 0f, -0.707f, 0.707f);
        //api.moveTo(point2, quaternion2, true);


        // report point1 arrival

        // get a camera image
        //Mat image = api.getMatNavCam();

        // irradiate the laser
        Result result1;
        int count = 0, max_count = 3;
        //check result and loop while moveto api is not succed.

//        do {
//            result1 = api.moveTo(point2, quaternion2, true);
//            count++;
//        }
//        while (!result1.hasSucceeded() && count < max_count);

        AR_event(11.2131f, -9.92284f, 5.46681f, 0f, 0f, -0.707f, 0.707f, max_count);

        //Circle detection code (Opencv)


        //Circle detection ends here


        api.laserControl(true);

        // take target1 snapshots
        api.takeTarget2Snapshot();

        // turn the laser off
        api.laserControl(false);

        //edited
        Point point3 = new Point(11.306f, -9.9228f, 4.48f);
        Quaternion quaternion3 = new Quaternion(0f, 0f, -0.707f, 0.707f);
        api.moveTo(point3, quaternion3, true);

        //edited
        Point point4 = new Point(11.306f, -8.4168f, 4.48f);
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

    /*public class YourService extends KiboRpcService {
        private final String TAG = this.getClass().getSimpleName();
        @Override
        protected void runPlan1(){
            Log.i(TAG,"start mission");
            // the mission starts
            api.startMission();
            // move to a point
            Point point = new Point(10.71f, -7.76f, 4.42f);
            Quaternion quaternion = new Quaternion(0f, 0.707f, 0f, 0.707f);
            api.moveTo(point, quaternion, true);
            // report point1 arrival
            api.reportPoint1Arrival();
            //opencv code
            try {
                Mat source = undistord(api.getMatNavCam());
            }
            catch (Exception ex )
            {
                Log.i(TAG,"podda setu");
            }
            finally {
                Log.i(TAG,"shopno puron hoyeche");
            }
            // Mat src =  api.getMatNavCam();
            //   Mat dst = new Mat();
            //getNavCamIntrinsics();
            // Mat cameraMatrix = Mat(3, 3, api.getNavCamIntrinsics());
            // Mat cameraMatrix = new Mat(3,3,api.getNavCamIntrinsics());
            //Mat distCoeffs = ;
            //Imgproc.undistort(src, dst, cameraMatrix, distCoeffs);
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
            Result result1;
            int count = 0, max_count = 3;
            //check result and loop while moveto api is not succed.
            do
            {
                result1 = api.moveTo(point2, quaternion2, true);
                count++;
            }
            while (!result1.hasSucceeded() && count < max_count);
            try {
                Mat source = undistord(api.getMatNavCam());
            }
            catch (Exception ex )
            {
                Log.i(TAG,"podda setu");
            }
            finally {
                Log.i(TAG,"shopno puron hoyeche");
            }
            api.laserControl(true);
            api.takeTarget2Snapshot();
            api.laserControl(false);
            //edited
            Point point3 = new Point(11.345f, -9.3f, 4.48f);
            Quaternion quaternion3 = new Quaternion(0f, 0f, -0.707f, 0.707f);
            api.moveTo(point3, quaternion3, true);
            //edited
            Point point4 = new Point(11.286f, -8.6f, 4.48f);
            Quaternion quaternion4 = new Quaternion(0f, 0f, -0.707f, 0.707f);
            api.moveTo(point4, quaternion4, true);
            Point pointg = new Point(11.27460f, -7.89178f, 4.96538f);
            Quaternion quaterniong = new Quaternion(0f, 0f, -0.707f, 0.707f);
            api.moveTo(pointg, quaterniong, true);
            api.reportMissionCompletion();
        }*/


    @Override
    protected void runPlan2() {
        // write here your plan 2
    }

    @Override
    protected void runPlan3() {
        // write here your plan 3
    }

    // You can add your method
    public Mat undistord(Mat src) {
        Mat dst = new Mat(1280, 960, CvType.CV_8UC1);
        Mat cameraMatrix = new Mat(3, 3, CvType.CV_32FC1);
        Mat distCoeffs = new Mat(1, 5, CvType.CV_32FC1);

        int row = 0, col = 0;

        double[][] intrinsics = api.getNavCamIntrinsics();
        double[] cameraMat = intrinsics[0];

        double[] distMat = intrinsics[1];

        cameraMatrix.put(row, col, cameraMat);
        distCoeffs.put(row, col, distMat);
        Log.d("Mode[camera]:", " Undistorted");


        cameraMatrix.put(row, col, cameraMat);
        distCoeffs.put(row, col, distMat);

        Imgproc.undistort(src, dst, cameraMatrix, distCoeffs);
        return dst;
    }

    private void moveToWrapper(double pos_x, double pos_y, double pos_z,
                               double qua_x, double qua_y, double qua_z,
                               double qua_w) {

        final Point point = new Point(pos_x, pos_y, pos_z);
        final Quaternion quaternion = new Quaternion((float) qua_x, (float) qua_y,
                (float) qua_z, (float) qua_w);

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






    public double[] Intersection(double p[][])
    {
        double[] center = new double[3];

        double a = (p[1][0] - p[0][0]) * (p[3][0] - p[2][0]);
        double b = (p[1][0] - p[0][0]) * (p[3][1] - p[2][1]);
        double c = (p[3][0] - p[2][0]) * (p[1][1] - p[0][1]);

        center[0] = (a * p[0][1] + b * p[2][0] - a * p[2][1] - c * p[0][0]) / (b - c);
        center[1] = ((p[1][1] - p[0][1]) * (center[0] - p[0][0]) / (p[1][0] - p[0][0])) + p[0][1];

        double x_l1 = Math.pow(p[0][0] - p[1][0], 2);
        double y_l1 = Math.pow(p[0][1] - p[1][1], 2);
        double x_l2 = Math.pow(p[3][0] - p[2][0], 2);
        double y_l2 = Math.pow(p[3][1] - p[2][1], 2);
        double avg = (Math.sqrt(x_l1 + y_l1) + Math.sqrt(x_l2 + y_l2)) / 2;

        center[2] = avg / AR_diagonal;
        Log.d("AR[info]: ", center[0] + ", " + center[1] + ", " + center[2]);
        return center;
    }

//    public double getPointCloud(int center_range)
//    {
//        double depth = 0;
//        int count = 0;
//
//        Log.d("PointCloud[status]:", " start");
//        PointCloud hazCam = api.getPointCloudHazCam();
//        Point[] point = hazCam.getPointArray();
//        int width  = hazCam.getWidth();
//        int height = hazCam.getHeight();
//        int row_max = height/2 + center_range/2;
//        int row_min = height/2 - center_range/2;
//        int col_max = width/2  + center_range/2;
//        int col_min = width/2  - center_range/2;
//        Log.d("PointCloud[status]:", " stop");
//
//
//        //////////////////////////////////////////////////////////////////////////////////////////////////////
//        for (int row = row_min; row < row_max; row++)
//        {
//            for (int col = col_min; col < col_max; col++)
//            {
//                depth += point[(row * width) + col].getZ();
//                count++;
//            }
//        }
//        //////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//        depth /= count;
//        Log.d("PointCloud[value]:", "z[" + depth + "]");
//        return depth;
//    }

//    public void flash_control(boolean status)
//    {
//        if(status)
//        {
//            api.flashlightControlFront(0.025f);
//
//            try
//            {
//                Thread.sleep(1000); // wait a few seconds
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        else api.flashlightControlFront(0);
//    }







    public double[] AR_event(float px, float py, float pz, float qx, float qy, float qz, float qw, int count_max)
    {
        int contents = 0, count = 0;
        double result[] = new double[3];

        while (contents == 0 && count < count_max)
        {
            Log.d("AR[status]:", " start");
            long start_time = SystemClock.elapsedRealtime();
            //
            Point point = new Point(px, py, pz);
            Quaternion quaternion = new Quaternion(qx, qy, qz, qw);
            api.moveTo(point, quaternion, true);


            //////////////////////////////////////////////////////////////////////////////////////////////////////
            Mat source = undistord(api.getMatNavCam());
            Kinematics robot = api.getRobotKinematics();
            Mat ids = new Mat();
            Dictionary dictionary = Aruco.getPredefinedDictionary(Aruco.DICT_5X5_250);
            List<Mat> corners = new ArrayList<>();

            try
            {
                Aruco.detectMarkers(source, dictionary, corners, ids);
                contents = (int) ids.get(0, 0)[0];

                Log.d("AR[status]:", " Detected");


                double[][] AR_corners =
                        {
                                {(int) corners.get(0).get(0, 0)[0], (int) corners.get(0).get(0, 0)[1]},
                                {(int) corners.get(0).get(0, 2)[0], (int) corners.get(0).get(0, 2)[1]},
                                {(int) corners.get(0).get(0, 1)[0], (int) corners.get(0).get(0, 1)[1]},
                                {(int) corners.get(0).get(0, 3)[0], (int) corners.get(0).get(0, 3)[1]}
                        };
                double[] AR_info = Intersection(AR_corners);


                Point point2 = new Point(px, py, pz);
                if(robot != null)
                {
                    point2 = robot.getPosition();
                    Log.d("getKinematics[status]:"," Finished");
                }
                result[0] = point2.getX() + (AR_info[0]- NAV_MAX_COL/2) / AR_info[2];
                result[1] = point2.getY();
                result[2] = point2.getZ() + (AR_info[1]- NAV_MAX_ROW/2) / AR_info[2];
            }
            catch (Exception e)
            {
                Log.d("AR[status]:", " Not detected");
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////
            Log.d("AR[status]:", " stop");
            long stop_time = SystemClock.elapsedRealtime();



            Log.d("AR[count]:", " " + count);
            Log.d("AR[total_time]:"," "+ (stop_time-start_time)/1000);
            count++;
        }
        return result;
    }
}

