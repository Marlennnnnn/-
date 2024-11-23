public class VideoProjector {
    public void on() {
        System.out.println("Видеопроектор включен.");
    }

    public void off() {
        System.out.println("Видеопроектор выключен");
    }

    public void setInput(String inputSource) {
        System.out.println("Вход видеопроектора установлен в положение " + inputSource + ".");
    }
}
