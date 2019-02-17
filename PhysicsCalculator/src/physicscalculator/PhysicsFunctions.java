/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physicscalculator;

/**
 *
 * @author Thomas Scanlan
 */
 
public class PhysicsFunctions {

    double calculateViWith_VfAccelerationTime(double vf, double a, double t) {
        double vi = vf - (a * t);
        return vi;
    }

    double calculateViWithAccelerationTimeDistance(double a, double t, double d) {
        double vi = (d / t) - ((a * t) / 2);
        return vi;
    }

    double calculateViWithVfAccelerationDistance(double vf, double acceleration, double distance) {
        double vi = Math.sqrt(vf - (2 * acceleration * distance));
        return vi;
    }

    double calculateViWithVfTimeDistance(double vf, double t, double d) {
        double vi = (2 * (d / t)) - vf;
        return vi;
    }
}
