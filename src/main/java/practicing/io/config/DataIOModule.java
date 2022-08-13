package practicing.io.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import practicing.io.function.DataMapper;
import practicing.io.function.InputProcessor;
import practicing.io.service.JsonUnmarshallService;
import practicing.io.service.UnmarshallService;
import practicing.io.service.XmlUnmarshallService;

public class DataIOModule extends AbstractModule {

    @Override
    public void configure(){
        super.configure();
        bind(InputProcessor.class).asEagerSingleton();
        bind(UnmarshallService.class).to(JsonUnmarshallService.class).asEagerSingleton();
        bind(DataMapper.class).asEagerSingleton();
        bind(ObjectMapper.class).asEagerSingleton();
        MapBinder<String, UnmarshallService> mapbinder
                = MapBinder.newMapBinder(binder(), String.class, UnmarshallService.class);
        mapbinder.addBinding("json").to(JsonUnmarshallService.class);
        mapbinder.addBinding("xml").to(XmlUnmarshallService.class);
    }
}
