package it.mappito.thing;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ThingService {

    private final AtomicLong counter = new AtomicLong();

    private Map<Long, Thing> things = new HashMap<>();

    public Thing getSomething(Long id) {
        return things.get(id);
    }

    public Thing getSomethingSpecial(Long id) {
        Thing thing = things.get(id);

        if(thing == null){
            throw new ThingNotFoundException(String.format("Thing with id %d does not exist", id));
        }

        return thing;
    }

    public Thing saveSomething(Thing thing) {
        Long id = counter.incrementAndGet();
        thing.setId(id);
        things.put(id, thing);
        return thing;
    }
}
