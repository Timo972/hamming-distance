package main;

public class HammingDistance {
    public static void main(String[] args) {
        int dist = distance("0100111", "1000110");
        System.out.printf("Distance: %d\n", dist);
        String[] bits = { "0100000", "1110000", "0101010", "0111000", "0101100" };
        int hd = hammingDistance(bits);
        System.out.printf("Hamming Distance: %d\n", hd);
    }

    public static int distance(String bits1, String bits2) {
        if (bits1.length() != bits2.length())
            throw new RuntimeException("bits must be same length");

        int dist = 0;
        for (int i = 0; i < bits1.length(); i++) {
            if (bits1.charAt(i) != bits2.charAt(i))
                dist++;
        }

        return dist;
    }

    public static int hammingDistance(String[] bits) {
        if (bits.length < 2)
            throw new RuntimeException("bits array needs at least 2 bit sequences");

        int min = bits[0].length();
        for (int i = 0; i < bits.length - 1; i++) {
            int dist = distance(bits[i], bits[i + 1]);
            if (dist < min) {
                min = dist;
            }
        }
        return min;
    }
}
