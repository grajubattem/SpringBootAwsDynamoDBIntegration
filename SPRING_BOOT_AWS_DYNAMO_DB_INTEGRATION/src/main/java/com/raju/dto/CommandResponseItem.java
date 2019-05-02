package com.raju.dto;

public class CommandResponseItem {
    private String commandId;  // This is a GUID
    private String status;
    private String statusMessage;
    private String fileType;
    private Integer onboardCommandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getOnboardCommandId() {
        return onboardCommandId;
    }

    public void setOnboardCommandId(Integer onboardCommandId) {
        this.onboardCommandId = onboardCommandId;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
