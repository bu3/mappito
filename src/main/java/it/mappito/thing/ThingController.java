package it.mappito.thing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/things")
public class ThingController {

    private static Logger LOGGER = LoggerFactory.getLogger(ThingController.class);

    @Autowired
    private ThingService thingService;

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Thing saveSomething( @RequestBody @Valid Thing thing) {
        return thingService.saveSomething(thing);
    }

    /**
     * Esempio di GET con ResponseEntity
     * */
    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public ResponseEntity<Thing> getSomething(@PathVariable Long id) {
        Thing thing = thingService.getSomething(id);
        return (thing != null) ? new ResponseEntity<>(thing, OK) : new ResponseEntity<>(NOT_FOUND);
    }

    /**
     * Esempio di GET con ExceptionHandler. Gestisce HttpStatus usando eccezioni ed exception handler
     * */
    @RequestMapping(value = "/alt/{id}",method=RequestMethod.GET)
    public Thing getSomethingSpecial(@PathVariable Long id) {
        return thingService.getSomethingSpecial(id);
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void handleThingNotFoundException(ThingNotFoundException ex) {
        LOGGER.error("Thing not found", ex);
        //DO SOMETHING
    }

}
