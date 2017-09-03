package spring.rest.models;

public class Greeting {
    public String message;

    public Greeting() {

    }

    public Greeting(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                '}';
    }
}
