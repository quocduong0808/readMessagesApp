package quongduong.readmessagesapp;

public class Messages {
    private String mess;
    Messages(String mess){
        this.mess = mess;
    };
    String getMess(){
        return mess;
    }
    void setMess(String mess){
        this.mess = mess;
    }
}
