package com.example.assistantabiturient.Class;

public class FacultiesTusur {
    private String nameFaculties;
    private String linkFaculties;
    private boolean isCheck;

    public FacultiesTusur(){

    }

    public FacultiesTusur(String nameFaculties, String linkFaculties, boolean isCheck) {
        this.nameFaculties = nameFaculties;
        this.linkFaculties = linkFaculties;
        this.isCheck = isCheck;
    }

    public String getNameFaculties() {
        return nameFaculties;
    }

    public void setNameFaculties(String nameFaculties) {
        this.nameFaculties = nameFaculties;
    }

    public String getLinkFaculties() {
        return linkFaculties;
    }

    public void setLinkFaculties(String linkFaculties) {
        this.linkFaculties = linkFaculties;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
