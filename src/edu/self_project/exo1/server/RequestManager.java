package edu.self_project.exo1.server;

import edu.self_project.exo1.communication.Communication;
import edu.self_project.exo1.communication.ERequestType;
import edu.self_project.exo1.communication.ETarget;
import edu.self_project.exo1.server.model.DAO.StudentDAO;

class RequestManager {
    private Communication request;
    public Communication response = new Communication();

    RequestManager(Communication request) {
        this.request = request;
        dispatcher();
        manageResponse();
    }

    private void manageResponse() {
        if (response.getContent() != null) {
            response.setTarget(ETarget.STUDENT);
            response.setType(ERequestType.READ);
            response.setSuccess(true);
        }
    }

    private void dispatcher() {
        if (request.getType().equals(ERequestType.READ)) read();
    }

    private void read() {
        if (request.getTarget().equals(ETarget.STUDENT))
            response.setContent(new StudentDAO().getAll());
    }


}
