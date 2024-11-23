class HomeTheaterFacade {
    private AudioSystem audioSystem;
    private VideoProjector videoProjector;
    private LightingSystem lightingSystem;

    public HomeTheaterFacade(AudioSystem audioSystem, VideoProjector videoProjector, LightingSystem lightingSystem) {
        this.audioSystem = audioSystem;
        this.videoProjector = videoProjector;
        this.lightingSystem = lightingSystem;
    }

    public void watchMovie() {
        System.out.println("Настройка режима видеосъемки...");
        lightingSystem.dim(50);
        audioSystem.on();
        audioSystem.setVolume(70);
        videoProjector.on();
        videoProjector.setInput("HDMI");
        System.out.println("Фильм готов к просмотру! Наслаждайтесь!");
    }

    public void endMovie() {
        System.out.println("Выключение режима просмотра фильмов...");
        lightingSystem.on();
        audioSystem.off();
        videoProjector.off();
        System.out.println("Фильм выключен.");
    }
}
