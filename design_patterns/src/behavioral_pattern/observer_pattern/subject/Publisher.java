package behavioral_pattern.observer_pattern.subject;

import behavioral_pattern.observer_pattern.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements IPublisher {
    private String publisherName;
    private String blogTitle;
    private List<Subscriber> subscribers;

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber() {
        for (Subscriber subscriber: subscribers) {
            subscriber.update(this);
        }
    }

    @Override
    public void publishBlog(String blogTitle) {
        this.blogTitle = blogTitle;
        notifySubscriber();
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getBlogTitle() {
        return blogTitle;
    }
}
