package com.jeeho.common.JThread.DeadLockThread;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DiningPhilosopherProblem {

    public static void main(String args[]){
        int numberPlilosophers;
        numberPlilosophers = args.length > 0 ? Integer.valueOf(args[0]) : 2;
        Chopstick[] chopsticks = new Chopstick[numberPlilosophers];
        for (int i = 0;i<numberPlilosophers;i++){
            chopsticks[i] = new Chopstick(i);
        }

        String philosopherImplClassName = "DeadlockingPhilosopher";

        for (int i=0;i<numberPlilosophers;i++){
            createPhilosopher(philosopherImplClassName,i,chopsticks);
        }
    }

    private static void createPhilosopher(String philosopherImplClassName, int i, Chopstick[] chopsticks) {
        int numOfPhilosophers = chopsticks.length;
        try {
            Class<Philosopher> philosopherClass = (Class<Philosopher>) Class.forName(DiningPhilosopherProblem.class.getPackage().getName()
            +"."+philosopherImplClassName);
            Constructor<Philosopher> constructor = philosopherClass.getConstructor(int.class, Chopstick.class, Chopstick.class);
            DeadLockingPhilosopher philosopher = (DeadLockingPhilosopher) constructor.newInstance(i, chopsticks[0], chopsticks[(i + 1) % numOfPhilosophers]);
            philosopher.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
