/**
 * Problem 5: Circular Tour Problem
 * Given a set of petrol pumps with petrol available and distance to the next pump,
 * determine the starting pump index from which a circular tour can be completed.
 * Hint: Track cumulative surplus. If total petrol >= total distance, a solution exists.
 *       The start is reset whenever the running surplus drops below zero.
 */
public class CircularTourProblem {

    static class PetrolPump {
        int petrol;   // petrol available at this pump
        int distance; // distance to the next pump

        PetrolPump(int petrol, int distance) {
            this.petrol   = petrol;
            this.distance = distance;
        }
    }

    /**
     * Returns the index of the starting pump, or -1 if no solution exists.
     * Time Complexity: O(n)
     */
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n          = pumps.length;
        int totalSurplus   = 0;
        int currentSurplus = 0;
        int start      = 0;

        for (int i = 0; i < n; i++) {
            int net = pumps[i].petrol - pumps[i].distance;
            currentSurplus += net;
            totalSurplus   += net;

            // If we can't reach the next pump, reset starting point
            if (currentSurplus < 0) {
                start          = i + 1;
                currentSurplus = 0;
            }
        }
        // A valid start exists only if total petrol >= total distance
        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int start = findStartingPoint(pumps);
        if (start == -1) {
            System.out.println("No circular tour is possible.");
        } else {
            System.out.println("Start the tour from pump index: " + start); // Expected: 1
        }
    }
}
