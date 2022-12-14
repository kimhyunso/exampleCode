package chapter09.example;

public class Chatting {
    public void startChat(final String nickName){
        Chat chat = new Chat(){
            @Override
            public void start() {
                while(true){
                    String inputData = "안녕하세요";
                    String message = "["+nickName+"] " + inputData;
                    sendMessage(message);
                }
            }
        };
        chat.start();
    }

    class Chat{
        public void start(){}
        public void sendMessage(String message){}
    }

}
