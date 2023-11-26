package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static ArrayList<GuitarString> keys = new ArrayList<>();


    public static void main(String[] args) {
//        /* create two guitar strings, for concert A and C */
//        GuitarString stringA = new GuitarString(CONCERT_A);
//        GuitarString stringC = new GuitarString(CONCERT_C);
        for (int i = 0; i < keyboard.length(); i++){
            Double freq = 440 * Math.pow(2, (i - 24) / 12.0);
            keys.add(new GuitarString(freq));

        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    keys.get(index).pluck();
                }
            }

            // Compute the superposition of samples
            double sample = 0;
            for (GuitarString string : keys) {
                sample += string.sample();
                string.tic();
            }

            // Play the sample on standard audio
            StdAudio.play(sample);

        }
    }
}

