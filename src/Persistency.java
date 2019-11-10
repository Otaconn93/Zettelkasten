interface Persistency {

    static void save(Zettelkasten zk, String dateiname) {

    }

    Zettelkasten load(String dateiname) throws NoSuchMethodException;
}
