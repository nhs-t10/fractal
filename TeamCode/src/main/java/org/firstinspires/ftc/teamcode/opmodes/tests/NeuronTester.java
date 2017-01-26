package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.controllers.teleop.ButtonPusher;
import org.firstinspires.ftc.teamcode.controllers.tests.NeuronTest;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.Instruments;
import org.firstinspires.ftc.teamcode.organs.Pusher;
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
    public Instruments instruments;
    public ButtonPusher bp;
    public void run() {
        instruments = new Instruments();
        instruments.start();
        bp = new ButtonPusher(new Pusher());
        camera = new TCamera();
        neuronTest = new NeuronTest(instruments, camera);
    }
    public void tick() {
        neuronTest.tick();
        bp.tick();
    }
    @Override
    public void stop() {
        camera.stop();
    }
}
