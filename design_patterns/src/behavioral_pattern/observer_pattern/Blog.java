package behavioral_pattern.observer_pattern;

import behavioral_pattern.observer_pattern.observer.Subscriber;
import behavioral_pattern.observer_pattern.subject.Publisher;

public class Blog {
    public static void main(String[] args) {
        Publisher publisher1 = new Publisher("publisher1");

        Subscriber subscriber1 = new Subscriber("subscriber1");
        Subscriber subscriber2 = new Subscriber("subscriber2");
        Subscriber subscriber3 = new Subscriber("subscriber3");

        publisher1.subscribe(subscriber1);
        publisher1.subscribe(subscriber2);
        publisher1.subscribe(subscriber3);

        publisher1.publishBlog("Article 1");

        publisher1.unSubscribe(subscriber2);

        publisher1.publishBlog("Article 2");
    }
}
