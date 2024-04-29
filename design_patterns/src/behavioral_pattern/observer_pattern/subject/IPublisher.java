package behavioral_pattern.observer_pattern.subject;

import behavioral_pattern.observer_pattern.observer.Subscriber;

public interface IPublisher {
    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    void notifySubscriber();
    void publishBlog(String blogTitle);
}
