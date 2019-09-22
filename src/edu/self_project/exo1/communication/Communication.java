package edu.self_project.exo1.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Communication implements Serializable {
    private String type;
    private Target target;
    private Object content;
    private Boolean success;

    public Communication(String type, Target target, Object content, Boolean success) {
        this.type = type;
        this.target = target;
        this.content = content;
        this.success = success;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(type);
        out.writeObject(target);
        out.writeObject(content);
        out.writeBoolean(success);
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        type = (String) in.readObject();
        target = (Target) in.readObject();
        content = in.readObject();
        success = in.readBoolean();
    }
}
