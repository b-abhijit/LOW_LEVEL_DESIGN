package behavioral_pattern.observer_pattern.observer;

import behavioral_pattern.observer_pattern.subject.IPublisher;
import behavioral_pattern.observer_pattern.subject.Publisher;

public class Subscriber implements ISubscriber {
    private String subscriberName;
    private IPublisher publisher;

    public Subscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update(Publisher publisher) {
        System.out.println("Hello " + subscriberName + ", new blog: " + publisher.getBlogTitle() + ", published by: " + publisher.getPublisherName());
    }
}
