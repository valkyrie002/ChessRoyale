package Util;

import java.util.HashSet;
import java.util.Set;

public class CoordinateFunctions {
    /**
     * Converts bit array to set of coordinates from reference coordinate
     * @param bitArr bit array input
     * @param ref reference point
     * @return set of coordinates based on bit array
     */
    public static Set<Coordinate> bitArrayToCoord(int[][] bitArr, Coordinate ref) {
        Set<Coordinate> out = new HashSet<>();
        int dim = bitArr.length;
        int mid = dim/2 + 1;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (bitArr[i][j] != 0) out.add(new Coordinate(mid - i, mid - j));
            }
        }
        return out;
    }
}
