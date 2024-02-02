package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InitProyect {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            executorService.execute(() -> {
                CBT_CaribbeanBrazaletTrackerMain cbtCaribbeanBrazaletTrackerMain = new CBT_CaribbeanBrazaletTrackerMain("CBT CARIBBEAN BRAZALET TRACKER");
            });
        }

    }
}
