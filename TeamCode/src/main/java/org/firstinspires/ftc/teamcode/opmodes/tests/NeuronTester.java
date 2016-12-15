package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.controllers.Team;
import org.firstinspires.ftc.teamcode.controllers.tests.NeuronTest;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.neurons.BeaconCheck;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.tissues.TCamera;
import org.lasarobotics.vision.ftc.resq.Beacon;

/**
 * Created by max on 11/15/16.
 *
 * You can add tests with the NeuronTest controller.
 */
@TeleOp(name="Neuron Tester", group="Testers")
public class NeuronTester extends T10Opmode {
    public NeuronTest neuronTest;
    public TCamera camera;
    public Instruments instruments;
    public void run() {
        instruments = new Instruments();
        instruments.start();
        TCamera camera = new TCamera();
        neuronTest = new NeuronTest(instruments, camera);
    }
    public void tick() {
        neuronTest.tick();
    }
    @Override
    public void stop() {
        camera.stop();
    }
}
