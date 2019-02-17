package physicscalculator;

/**
 * This is the library (class) that we use to calculate the various components
 * in 2-d kinematic motion.
 *
 * It utilizes the Math class quite a bit.
 *
 * @author Thomas Scanlan
 */
public class Physics {

    // DEGCONVERT is used to convert radians to degrees.
    static final double DEGCONVERT = 180.0 / Math.PI;

    // RADCONVERT is used to convert degrees to radians.
    static final double RADCONVERT = Math.PI / 180.0;

    // GRAVITY is the constant acceleration of of projectile in freefall.
    // It is non-negative because it is a magnitude. 
    // 9.80 m/s^2
    static final double GRAVITY = 9.80;

    public Physics() {
        // This is a constructor that is never used
        // this class is more a library or feature for kinematics.        
        // Do not instantiate this class, you do not have to
    }

    /**
     * Uses the Pythagorean theorem to calculate the magnitude of
     * initial velocity.
     *
     * @param velocityX - initial velocity in the x-direction (m/s)
     * @param velocityY - initial velocity in the y-direction (m/s)
     * @return initial velocity magnitude (m/s)
     */
    public static double calcVMagnitude(double velocityX, double velocityY) {

        return Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));
    }

    /**
     * Uses the magnitude of initial velocity and the initial
     * velocity in the y-direction to calculate the initial velocity in the
     * x-direction.
     *
     * @param velocityMagnitude - initial velocity (m/s)
     * @param velocityY - initial velocity in the y-direction (m/s)
     * @return initial velocity in the x-direction (m/s)
     */
    public static double calcVX(double velocityMagnitude, double velocityY) {

        return Math.sqrt(Math.pow(velocityMagnitude, 2) - Math.pow(velocityY, 2));
    }

    /**
     * Uses initial velocity and initial velocity in the x-direction to calculate the initial velocity in the y-direction.
     *
     * @param velocityMagnitude is the magnitude of initial velocity (m/s)
     * @param velocityX is the initial velocity in the x-direction (m/s)
     * @return the initial velocity in the y direction (m/s)
     */
    public static double calcVY(double velocityMagnitude, double velocityX) {

        return Math.sqrt(Math.pow(velocityMagnitude, 2) - Math.pow(velocityX, 2));
    }

    /**
     * This function uses the magnitude of the initial velocity and the launch
     * angle to find initial velocity in the y-direction.
     *
     * @param velocityMagnitude the initial velocity (m/s)
     * @param degrees the launch angle in degrees
     * @return the initial velocity in the y-direction (m/s)
     */
    public static double calcVYWithAngle(double velocityMagnitude, double degrees) {
        return velocityMagnitude * (Math.sin(degrees) * DEGCONVERT);
    }

    /**
     * This function uses the magnitude of the initial velocity and the launch
     * angle to find initial velocity in the x-direction.
     *
     * @param velocityMagnitude the initial velocity (m/s)
     * @param degrees the launch angle in degrees
     * @return the initial velocity in the x-direction (m/s)
     */
    public static double calcVXWithAngle(double velocityMagnitude, double degrees) {
        return velocityMagnitude * (Math.cos(degrees) * DEGCONVERT);
    }

    /**
     * This function uses the vertical and horizontal components of the initial
     * velocity to determine the launch angle. It mirrors tan^-1(Vyi/Vxi).
     *
     * @param velocityX initial velocity in the x-direction, in m/s
     * @param velocityY initial velocity in the y-direction, in m/s
     * @return the launch angle in degrees
     */
    public static double calcAngleDegrees(double velocityX, double velocityY) {
        return Math.atan(velocityY / velocityX) * DEGCONVERT;
    }

    /**
     * This function calculates the time at which the projectile will reach its
     * maximum height given the initial velocity in the y-direction.
     *
     * @param velocityY is the initial velocity in the y-direction, in m/s
     * @return the time it takes for the projectile to reach its maximum height,
     * in seconds
     */
    public static double calcTimeAtMaxHeight(double velocityY) {
        return (velocityY / GRAVITY); // two negatives cancel 
    }

    /**
     * This function calculates the max height it mirrors the equation: Y =
     * (1/2)a(t)^2 + Vyi(t) + Yi.
     *
     * @param velocityY - initial velocity in the y-direction (m/s)
     * @param timeOfMaxHeightSeconds - seconds until the max height occurs
     * @param initialHeight - initial y-position (meters)
     * @return the maximum height the projectile reaches (meters)
     */
    public static double calcMaxHeight(double velocityY, double timeOfMaxHeightSeconds, double initialHeight) {
        double halfAccelTimeSqr = .5 * -GRAVITY * Math.pow(timeOfMaxHeightSeconds, 2);

        // initial y-velocity * time at max height
        double vyInitial_mult_time = velocityY * timeOfMaxHeightSeconds;   
        return (halfAccelTimeSqr + vyInitial_mult_time + initialHeight);
    }

    /**
     * This function calculates the final x-position in meters, given initial
     * velocity in the x-direction and the total time the projectile spends in
     * the air.
     *
     * @param velocityX - initial velocity in the x-direction (m/s)
     * @param totalTimeSeconds - time from initial height to the max height,
     * then the max height to the ground
     * @return the final x-position of the projectile (meters)
     */
    public static double calcXfinal(double velocityX, double totalTimeSeconds) {
        return velocityX * totalTimeSeconds;
    }

    /**
     * This function calculates the total time the projectile is in free-fall
     * from its maximum height.
     *
     * @param height - maximum height (meters)
     * @return time (seconds) projectile spends in free-fall
     */
    public static double calcTimeFromMaxHeightToGround(double height) {
        return Math.sqrt((2 * height) / GRAVITY);
    }

    /**
     * This function performs a quadratic equation to determine the total time
     * that projectile takes from launch to reach the ground.
     *
     * @param velocityY initial velocity in y-direction (m/s)
     * @param initialHeight the height from which the projectile is launched
     * (meters)
     * @return the total time in seconds that the projectile will take to travel
     * from launch to the ground
     */
    public static double calcTotalTime(double velocityY, double initialHeight) {
        double root1 = (velocityY - Math.sqrt((Math.pow(velocityY, 2) + (2 * GRAVITY * initialHeight)))) / GRAVITY;
        double root2 = (velocityY + Math.sqrt((Math.pow(velocityY, 2) + (2 * GRAVITY * initialHeight)))) / GRAVITY;
        return root1 > root2 ? root1 : root2;
    }

    /**
     * This function calculates and returns the final velocity in the
     * y-direction.
     *
     * @param velocityY is the initial velocity in the y-direction
     * @param totalTime is the total time the projectile spends in the air
     * @return the final velocity in the y-direction
     */
    public static double calcFinalYvelocity(double velocityY, double totalTime) {
        return (velocityY - (GRAVITY * totalTime));
    }

    /**
     * This function calculates and returns the final velocity in the
     * x-direction.
     *
     * @param velocityX is the initial velocity in the x-direction
     * @return the final velocity in the x direction
     */
    public static double calcFinalXvelocity(double velocityX) {
        return velocityX;
    }

    /**
     * This function returns the angle that the projectile makes with the
     * ground.
     *
     * @param velocityY
     * @param velocityX
     * @return the projectiles final angle with the ground (degrees)
     */
    public static double calcFinalAngleWithGround(double velocityY, double velocityX) {
        return Math.toDegrees(Math.atan(velocityY / velocityX));
    }

    /**
     * This function uses the final velocity in both x and y directions to
     * calculate the final velocity's magnitude.
     *
     * @param velocityY is final velocity in the y-direction
     * @param velocityX is the final velocity in the x-direction
     * @return
     */
    public static double calcFinalVelocity(double velocityY, double velocityX) {
        return Math.sqrt((velocityY * velocityY) + (velocityX * velocityX));
    }
}
