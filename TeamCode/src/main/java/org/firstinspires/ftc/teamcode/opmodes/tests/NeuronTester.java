package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.tests.NeuronTest;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.tissues.TCamera;

/**
 * Created by max on 11/15/16.
 *
 * You can add tests with the NeuronTest controller.
 */
@TeleOp(name="Neuron Tester", group="Testers")
public class NeuronTester extends T10Opmode {
    public NeuronTest neuronTest;
    public TCamera camera;
    public void run() {
        Instruments i = new Instruments();
        i.start();
        TCamera camera = new TCamera();
        neuronTest = new NeuronTest(i, camera);
    }
    public void tick() {
        neuronTest.tick();
    }
    @Override
    public void stop() {
        camera.stop();
    }
}
