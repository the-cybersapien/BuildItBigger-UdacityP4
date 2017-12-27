package xyz.cybersapien.jokeprovider;

/**
 * Created by ogcybersapien on 26/12/17.
 */
public class Joke {

    private String joke;

    public Joke(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Joke{");
        sb.append("joke='").append(joke).append('\'');
        sb.append('}');
        return sb.toString();
    }
}