package edu.self_project.exo1;

import edu.self_project.exo1.client.Client;
import edu.self_project.exo1.communication.Communication;
import edu.self_project.exo1.communication.ERequestType;
import edu.self_project.exo1.communication.ETarget;

public class Main {

    public static void main(String[] args) {
        (new Client()).request(
                new Communication(ERequestType.READ, ETarget.STUDENT, null, true)
        );
    }
}
