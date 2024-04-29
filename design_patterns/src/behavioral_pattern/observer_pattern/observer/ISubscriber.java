package behavioral_pattern.observer_pattern.observer;

import behavioral_pattern.observer_pattern.subject.Publisher;

public interface ISubscriber {
    void update(Publisher publisher);
}
