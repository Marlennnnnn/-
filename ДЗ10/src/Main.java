public class Main {
    public static void main(String[] args) {
        AudioSystem audioSystem = new AudioSystem();
        VideoProjector videoProjector = new VideoProjector();
        LightingSystem lightingSystem = new LightingSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(audioSystem, videoProjector, lightingSystem);


        homeTheater.watchMovie();


        homeTheater.endMovie();
    }
}
